/*
 * shkaff_llm.cpp - JNI bridge between the Shkaff app and the vendored
 * llama.cpp (third_party/llama.cpp, tag b9999).
 *
 * Single CPU-only engine instance. Text-only models use common utils for chat
 * formatting/sampling; vision models additionally load an mmproj via libmtmd.
 * Tokens stream back to Kotlin through callbacks on the calling thread.
 * Splitting both work on a single closure/abort is not supported: only one
 * generate() at a time (agent loop is single-flight), abort() is an atomic flag.
 */

#include <jni.h>

#include <atomic>
#include <cstdio>
#include <cstring>
#include <string>
#include <vector>

#include "common.h"
#include "chat.h"
#include "sampling.h"
#include "llama.h"
#include "ggml.h"
#include "mtmd.h"
#include "mtmd-helper.h"

namespace {

constexpr jint kOk             =  0;
constexpr jint kErrNotLoaded   = -1;
constexpr jint kErrLoad        = -2;
constexpr jint kErrEval        = -3;
constexpr jint kErrDecode      = -4;
constexpr jint kErrImage       = -5;
constexpr jint kErrNoVision    = -6;
constexpr jint kAborted        = -7;

struct load_progress_ud {
    JNIEnv   * env;
    jobject    cb;
    jmethodID on_progress;
};

struct engine_t {
    common_params                params;
    common_init_result_ptr       init;
    llama_model                * model  = nullptr;
    llama_context              * lctx   = nullptr;
    const llama_vocab          * vocab  = nullptr;
    common_sampler            * smpl   = nullptr;
    llama_batch                  batch  {}; // single-token batch during generation
    mtmd_context               * vctx   = nullptr;
    common_chat_templates_ptr    tmpls;
    std::vector<common_chat_msg> chat_history;
    std::string                  last_error;
    llama_pos                    n_past  = 0;
    int32_t                      n_batch = 512;
    bool                         loaded  = false;
    std::atomic<bool>            aborted {false};
};

engine_t g_engine;

std::string from_jstring(JNIEnv * env, jstring jstr) {
    if (jstr == nullptr) {
        return {};
    }
    const char * chars = env->GetStringUTFChars(jstr, nullptr);
    std::string res = chars != nullptr ? chars : "";
    env->ReleaseStringUTFChars(jstr, chars);
    return res;
}

void set_error(JNIEnv * env, jobject cb, jmethodID on_error, jint code, const std::string & msg) {
    g_engine.last_error = msg;
    fprintf(stderr, "shkaff_llm: %s\n", msg.c_str());
    if (cb != nullptr && on_error != nullptr) {
        jstring jmsg = env->NewStringUTF(msg.c_str());
        env->CallVoidMethod(cb, on_error, code, jmsg);
        env->DeleteLocalRef(jmsg);
    }
}

// llama model load progress -> Kotlin LlamaLoadProgress.onProgress(percent)
bool load_progress_cb(float progress, void * user_data) {
    auto * ud = static_cast<load_progress_ud *>(user_data);
    ud->env->CallVoidMethod(ud->cb, ud->on_progress, static_cast<jint>(progress * 100.0f));
    return true;
}

void unload() {
    if (g_engine.vctx != nullptr) {
        mtmd_free(g_engine.vctx);
        g_engine.vctx = nullptr;
    }
    if (g_engine.smpl != nullptr) {
        common_sampler_free(g_engine.smpl);
        g_engine.smpl = nullptr;
    }
    if (g_engine.batch.token != nullptr) {
        llama_batch_free(g_engine.batch);
        g_engine.batch = {};
    }
    g_engine.tmpls.reset();
    g_engine.chat_history.clear();
    g_engine.init.reset();
    g_engine.loaded = false;
    g_engine.aborted.store(false);
    g_engine.last_error.clear();
}

void reset_chat() {
    g_engine.n_past = 0;
    g_engine.chat_history.clear();
    llama_memory_clear(llama_get_memory(g_engine.lctx), true);
}

// Evaluate a formatted prompt. Vision path mirrors tools/mtmd/mtmd-cli.cpp:
// mtmd_tokenize -> text chunks via mtmd_helper_eval_chunk_single, media chunks
// via mtmd_batch_encode + mtmd_helper_decode_image_chunk (handles mrope).
bool eval_prompt(JNIEnv * env, jobject cb, jmethodID on_error,
                 const std::string & formatted, bool add_bos,
                 const std::string & image_path) {
    if (g_engine.vctx != nullptr) {
        std::vector<const mtmd_bitmap *> bitmaps;
        if (!image_path.empty()) {
            auto res = mtmd_helper_bitmap_init_from_file(g_engine.vctx, image_path.c_str(), false);
            if (res.bitmap == nullptr) {
                set_error(env, cb, on_error, kErrImage, "cannot decode image: " + image_path);
                return false;
            }
            bitmaps.push_back(res.bitmap);
        }

        mtmd_input_text text;
        text.text          = formatted.data();
        text.text_len      = formatted.size();
        text.add_special   = add_bos;
        text.parse_special = true;

        mtmd_input_chunks * chunks = mtmd_input_chunks_init();
        int32_t rc = mtmd_tokenize(g_engine.vctx, chunks, &text,
                                   bitmaps.data(), bitmaps.size());
        if (rc != 0) {
            mtmd_input_chunks_free(chunks);
            for (const mtmd_bitmap * b : bitmaps) {
                mtmd_bitmap_free(const_cast<mtmd_bitmap *>(b));
            }
            set_error(env, cb, on_error, kErrEval, "mtmd_tokenize failed");
            return false;
        }

        mtmd_batch * mbatch = nullptr;
        const size_t n_chunks = mtmd_input_chunks_size(chunks);
        for (size_t i = 0; i < n_chunks; i++) {
            const mtmd_input_chunk * chunk = mtmd_input_chunks_get(chunks, i);
            llama_pos new_n_past = g_engine.n_past;

            if (mtmd_input_chunk_get_type(chunk) == MTMD_INPUT_CHUNK_TYPE_TEXT) {
                rc = mtmd_helper_eval_chunk_single(g_engine.vctx, g_engine.lctx, chunk,
                                                   g_engine.n_past, 0, g_engine.n_batch,
                                                   i == n_chunks - 1, &new_n_past);
                if (rc != 0) {
                    set_error(env, cb, on_error, kErrEval, "eval text chunk failed");
                    break;
                }
                g_engine.n_past = new_n_past;
            } else {
                float * embd = nullptr;
                if (mbatch != nullptr) {
                    embd = mtmd_batch_get_output_embd(mbatch, chunk);
                }
                if (embd == nullptr) {
                    if (mbatch != nullptr) {
                        mtmd_batch_free(mbatch);
                    }
                    mbatch = mtmd_batch_init(g_engine.vctx);
                    rc = mtmd_batch_add_chunk(mbatch, chunk);
                    if (rc == 0) {
                        for (size_t j = i + 1; j < n_chunks; j++) {
                            const mtmd_input_chunk * next = mtmd_input_chunks_get(chunks, j);
                            if (mtmd_input_chunk_get_type(next) == MTMD_INPUT_CHUNK_TYPE_TEXT) {
                                break;
                            }
                            if (mtmd_batch_add_chunk(mbatch, next) != 0) {
                                break;
                            }
                        }
                        rc = mtmd_batch_encode(mbatch);
                    }
                    embd = rc == 0 ? mtmd_batch_get_output_embd(mbatch, chunk) : nullptr;
                    if (embd == nullptr) {
                        set_error(env, cb, on_error, kErrEval, "mtmd batch encode failed");
                        rc = -1;
                    }
                }
                if (rc != 0) {
                    break;
                }
                rc = mtmd_helper_decode_image_chunk(g_engine.vctx, g_engine.lctx, chunk,
                                                    embd, g_engine.n_past, 0, g_engine.n_batch,
                                                    &new_n_past, nullptr, nullptr);
                if (rc != 0) {
                    set_error(env, cb, on_error, kErrEval, "decode media chunk failed");
                    break;
                }
                g_engine.n_past = new_n_past;
            }
        }

        if (mbatch != nullptr) {
            mtmd_batch_free(mbatch);
        }
        mtmd_input_chunks_free(chunks);
        for (const mtmd_bitmap * b : bitmaps) {
            mtmd_bitmap_free(const_cast<mtmd_bitmap *>(b));
        }
        return rc == 0;
    }

    // text-only path: tokenize the whole turn and decode in one batch
    std::vector<llama_token> tokens = common_tokenize(g_engine.lctx, formatted, add_bos, true);
    if (tokens.empty()) {
        set_error(env, cb, on_error, kErrEval, "empty tokenized prompt");
        return false;
    }
    llama_batch batch = llama_batch_init(tokens.size(), 0, 1);
    for (size_t i = 0; i < tokens.size(); i++) {
        batch.token[i]   = tokens[i];
        batch.pos[i]     = g_engine.n_past + static_cast<llama_pos>(i);
        batch.n_seq_id[i] = 1;
        batch.seq_id[i][0] = 0;
        batch.logits[i]  = i == tokens.size() - 1;
    }
    batch.n_tokens = tokens.size();
    const bool ok = llama_decode(g_engine.lctx, batch) == 0;
    if (!ok) {
        set_error(env, cb, on_error, kErrDecode, "llama_decode prompt failed");
    } else {
        g_engine.n_past += static_cast<llama_pos>(tokens.size());
    }
    llama_batch_free(batch);
    return ok;
}

jint generate(JNIEnv * env, jobject cb, jmethodID on_token, jmethodID on_error, int32_t n_max_tokens) {
    llama_tokens generated_tokens;
    int32_t i = 0;
    for (; i < n_max_tokens; i++) {
        if (g_engine.aborted.load()) {
            break;
        }
        llama_token token_id = common_sampler_sample(g_engine.smpl, g_engine.lctx, -1);
        generated_tokens.push_back(token_id);
        common_sampler_accept(g_engine.smpl, token_id, true);

        if (llama_vocab_is_eog(g_engine.vocab, token_id)) {
            break;
        }

        std::string piece = common_token_to_piece(g_engine.lctx, token_id);
        jstring jpiece = env->NewStringUTF(piece.c_str());
        env->CallVoidMethod(cb, on_token, jpiece);
        env->DeleteLocalRef(jpiece);

        common_batch_clear(g_engine.batch);
        common_batch_add(g_engine.batch, token_id, g_engine.n_past++, { 0 }, true);
        if (llama_decode(g_engine.lctx, g_engine.batch) != 0) {
            set_error(env, cb, on_error, kErrDecode, "llama_decode token failed");
            break;
        }
    }

    const bool aborted = g_engine.aborted.load();
    if (i > 0) {
        // keep history in sync with the KV cache so the next turn stays consistent
        common_chat_msg msg;
        msg.role    = "assistant";
        msg.content = common_detokenize(g_engine.lctx, generated_tokens);
        g_engine.chat_history.push_back(std::move(msg));
    }
    return aborted ? kAborted : kOk;
}

// ---------------------------------------------------------------------------
// JNI entry points (Java methods on ru.vldkr.shkaff.llm.LlamaBridge)
// ---------------------------------------------------------------------------

jobject native_version(JNIEnv * env, jobject /*self*/) {
    const std::string v = "shkaff_llm 1 (llama.cpp b9999)";
    return env->NewStringUTF(v.c_str());
}

jint native_load_model(JNIEnv * env, jobject/* self*/, jstring jmodel, jstring jmmproj,
                       jint jn_ctx, jint jn_threads, jobject progress_cb) {
    unload();

    const std::string model_path = from_jstring(env, jmodel);
    const std::string mmproj_path = jmmproj != nullptr ? from_jstring(env, jmmproj) : "";
    const int32_t threads = jn_threads > 0 ? jn_threads : 4;

    load_progress_ud jp { env, progress_cb, nullptr };
    if (progress_cb != nullptr) {
        jclass cb_cls = env->GetObjectClass(progress_cb);
        jp.on_progress = env->GetMethodID(cb_cls, "onProgress", "(I)V");
    }

    ggml_backend_load_all();

    common_params & params = g_engine.params;
    params.model.path  = model_path;
    params.n_ctx       = jn_ctx > 0 ? jn_ctx : 4096;
    params.n_batch     = 512;
    params.n_ubatch    = 512;
    params.n_predict   = -1; // generation capped from the Kotlin side
    params.fit_params  = false;
    params.cpuparams.n_threads      = threads;
    params.cpuparams_batch.n_threads = 0;
    params.sampling.temp  = 0.8f;
    params.sampling.top_p = 0.95f;
    params.sampling.top_k = 40;

    params.load_progress_callback          = progress_cb != nullptr ? load_progress_cb : nullptr;
    params.load_progress_callback_user_data = progress_cb != nullptr ? &jp : nullptr;

    g_engine.init = common_init_from_params(params);

    params.load_progress_callback          = nullptr;
    params.load_progress_callback_user_data = nullptr;

    if (!g_engine.init) {
        set_error(env, nullptr, nullptr, kErrLoad, "common_init_from_params failed");
        return kErrLoad;
    }
    g_engine.model = g_engine.init->model();
    g_engine.lctx  = g_engine.init->context();
    g_engine.vocab = llama_model_get_vocab(g_engine.model);
    if (g_engine.model == nullptr || g_engine.lctx == nullptr) {
        set_error(env, nullptr, nullptr, kErrLoad, "model/context not created");
        return kErrLoad;
    }

    g_engine.tmpls = common_chat_templates_init(g_engine.model, "");
    g_engine.smpl  = common_sampler_init(g_engine.model, params.sampling);
    g_engine.batch = llama_batch_init(1, 0, 1);
    g_engine.n_batch = params.n_batch;

    if (!mmproj_path.empty()) {
        mtmd_context_params mparams = mtmd_context_params_default();
        mparams.use_gpu      = false;
        mparams.n_threads    = threads;
        mparams.print_timings = false;
        mparams.warmup       = false;
        g_engine.vctx = mtmd_init_from_file(mmproj_path.c_str(), g_engine.model, mparams);
        if (g_engine.vctx == nullptr) {
            set_error(env, nullptr, nullptr, kErrLoad, "failed to load vision model from mmproj");
            return kErrLoad;
        }
    }

    g_engine.loaded = true;
    g_engine.aborted.store(false);
    reset_chat();
    return kOk;
}

void native_unload_model(JNIEnv * /*env*/, jobject /*self*/) {
    unload();
}

void native_set_system_prompt(JNIEnv * env, jobject /*self*/, jstring jsystem, jstring jtools) {
    const std::string system = from_jstring(env, jsystem);
    const std::string tools  = jtools != nullptr ? from_jstring(env, jtools) : "";

    reset_chat();
    if (!system.empty()) {
        common_chat_msg msg;
        msg.role    = "system";
        msg.content = tools.empty() ? system : system + "\n\nAvailable tools (JSON):\n" + tools;
        g_engine.chat_history.push_back(std::move(msg));
    }
}

void native_reset_chat(JNIEnv * /*env*/, jobject /*self*/) {
    reset_chat();
}

jint native_complete(JNIEnv * env, jobject /*self*/, jstring jprompt, jstring jimage,
                     jint jn_max_tokens, jobject cb) {
    if (!g_engine.loaded) {
        return kErrNotLoaded;
    }
    g_engine.aborted.store(false);

    std::string prompt = from_jstring(env, jprompt);
    const std::string image_path = jimage != nullptr ? from_jstring(env, jimage) : "";

    jclass cb_cls = env->GetObjectClass(cb);
    jmethodID on_token = env->GetMethodID(cb_cls, "onToken", "(Ljava/lang/String;)V");
    jmethodID on_error = env->GetMethodID(cb_cls, "onError", "(ILjava/lang/String;)V");

    if (g_engine.vctx != nullptr && mtmd_support_vision(g_engine.vctx) && !image_path.empty()) {
        // most models expect the media marker just before the image
        prompt = std::string(mtmd_default_marker()) + prompt;
    } else if (!image_path.empty() && g_engine.vctx == nullptr) {
        set_error(env, cb, on_error, kErrNoVision, "image provided but no mmproj loaded");
        return kErrNoVision;
    }

    common_chat_msg user_msg;
    user_msg.role    = "user";
    user_msg.content = prompt;

    const bool add_bos = g_engine.chat_history.empty();
    const std::string formatted = common_chat_format_single(
        g_engine.tmpls.get(), g_engine.chat_history, user_msg, true, true);
    g_engine.chat_history.push_back(user_msg);

    if (!eval_prompt(env, cb, on_error, formatted, add_bos, image_path)) {
        reset_chat(); // KV and history may be inconsistent after a partial eval
        return kErrEval;
    }

    const int32_t n_max = jn_max_tokens > 0 ? jn_max_tokens : 1024;
    return generate(env, cb, on_token, on_error, n_max);
}

void native_abort(JNIEnv * /*env*/, jobject /*self*/) {
    g_engine.aborted.store(true);
}

jstring native_last_error(JNIEnv * env, jobject /*self*/) {
    return env->NewStringUTF(g_engine.last_error.c_str());
}

const JNINativeMethod kMethods[] = {
    { "nativeVersion",        "()Ljava/lang/String;",                                                            (void *) native_version },
    { "nativeLoadModel",      "(Ljava/lang/String;Ljava/lang/String;IILru/vldkr/shkaff/llm/LlamaLoadProgress;)I", (void *) native_load_model },
    { "nativeUnloadModel",    "()V",                                                                              (void *) native_unload_model },
    { "nativeSetSystemPrompt","(Ljava/lang/String;Ljava/lang/String;)V",                                          (void *) native_set_system_prompt },
    { "nativeResetChat",      "()V",                                                                              (void *) native_reset_chat },
    { "nativeComplete",       "(Ljava/lang/String;Ljava/lang/String;ILru/vldkr/shkaff/llm/LlamaGenerationCallback;)I", (void *) native_complete },
    { "nativeAbort",          "()V",                                                                              (void *) native_abort },
    { "nativeLastError",      "()Ljava/lang/String;",                                                             (void *) native_last_error },
};

} // namespace

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM * vm, void * /*reserved*/) {
    JNIEnv * env = nullptr;
    if (vm->GetEnv(reinterpret_cast<void **>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
    jclass cls = env->FindClass("ru/vldkr/shkaff/llm/LlamaBridge");
    if (cls == nullptr) {
        return JNI_ERR;
    }
    const jint n = sizeof(kMethods) / sizeof(kMethods[0]);
    if (env->RegisterNatives(cls, kMethods, n) != JNI_OK) {
        env->DeleteLocalRef(cls);
        return JNI_ERR;
    }
    env->DeleteLocalRef(cls);
    return JNI_VERSION_1_6;
}