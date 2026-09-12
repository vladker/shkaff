package ru.vldkr.shkaff.llm

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Тонкий JNI-мост к vendored llama.cpp (third_party/llama.cpp, tag b9999).
 *
 * Один экземпляр движка на процесс. Все вызовы сериализованы контрактом
 * агента (single-flight): [complete] блокирует вызывающий поток и должен
 * запускаться на фоновом потоке; [abort] можно дёргать из любого потока.
 * Колбэки генерации вызываются на потоке вызова [complete].
 */
object LlamaBridge {

    /** Список кодов ошибок нативной части (дубль kErr* из shkaff_llm.cpp). */
    const val OK = 0
    const val ERR_NOT_LOADED = -1
    const val ERR_LOAD = -2
    const val ERR_EVAL = -3
    const val ERR_DECODE = -4
    const val ERR_IMAGE = -5
    const val ERR_NO_VISION = -6
    const val ABORTED = -7

    private val loadedFlag = AtomicBoolean(false)

    /** Модель загружена и готова к генерации. */
    val isLoaded: Boolean get() = loadedFlag.get()

    /** Версия нативного движка: "shkaff_llm 1 (llama.cpp <ver>)". */
    val nativeVersion: String get() = nativeVersion()

    /**
     * Загрузить текстовую модель (modelPath) и, опционально, vision-проектор
     * (mmprojPath, GGUF из моделей вроде Qwen3-VL). Возвращает [OK] при успехе.
     */
    fun loadModel(
        modelPath: String,
        mmprojPath: String? = null,
        nCtx: Int = 4096,
        nThreads: Int = 4,
        progress: LlamaLoadProgress? = null,
    ): Int {
        val code = nativeLoadModel(modelPath, mmprojPath, nCtx, nThreads, progress)
        loadedFlag.set(code == OK)
        return code
    }

    /** Выгрузить модель и освободить память. */
    fun unloadModel() {
        nativeUnloadModel()
        loadedFlag.set(false)
    }

    /** Установить системный промпт; toolsJson — непустая строка добавляет блок инструментов. */
    fun setSystemPrompt(system: String, toolsJson: String = "") = nativeSetSystemPrompt(system, toolsJson)

    /** Очистить историю диалога и состояние KV-кэша. */
    fun resetChat() = nativeResetChat()

    /**
     * Одно сообщение пользователя. imagePath — путь к фото (только при
     * загруженном mmproj), иначе для vision-моделей вернётся [ERR_NO_VISION].
     * Токены стримятся в [cb.onToken]; возвращает [OK] при завершении.
     */
    fun complete(
        prompt: String,
        imagePath: String? = null,
        nMaxTokens: Int = 1024,
        cb: LlamaGenerationCallback,
    ): Int = nativeComplete(prompt, imagePath, nMaxTokens, cb)

    /** Прервать текущую генерацию (атомарный флаг; [complete] вернёт [ABORTED]). */
    fun abort() = nativeAbort()

    /** Человекочитаемое описание последней ошибки. */
    fun lastError(): String = nativeLastError()

    private external fun nativeVersion(): String
    private external fun nativeLoadModel(
        modelPath: String,
        mmprojPath: String?,
        nCtx: Int,
        nThreads: Int,
        progress: LlamaLoadProgress?,
    ): Int
    private external fun nativeUnloadModel()
    private external fun nativeSetSystemPrompt(system: String, toolsJson: String)
    private external fun nativeResetChat()
    private external fun nativeComplete(prompt: String, imagePath: String?, nMaxTokens: Int, cb: LlamaGenerationCallback): Int
    private external fun nativeAbort()
    private external fun nativeLastError(): String
}

/** Прогресс загрузки модели, 0..100 (вызывается на потоке [LlamaBridge.loadModel]). */
fun interface LlamaLoadProgress {
    fun onProgress(percent: Int)
}

/** Колбэки потоковой генерации. */
interface LlamaGenerationCallback {
    fun onToken(text: String)
    fun onError(code: Int, message: String)
}