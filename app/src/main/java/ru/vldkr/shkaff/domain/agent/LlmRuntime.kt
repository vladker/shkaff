package ru.vldkr.shkaff.domain.agent

import android.app.ActivityManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.llm.LlamaBridge
import java.io.File

/**
 * При нехватке RAM llama.cpp не бросает исключение, а зовёт GGML_ABORT — процесс
 * падает целиком, без ошибки в UI. Поэтому размер контекста подбираем по
 * свободной памяти и размеру GGUF-файла, а если не влезает даже минимальный —
 * отказываемся грузить и показываем причину.
 *
 * Оценка грубая: KV-кэш — 128 КиБ на токен контекста (у моделей 0.6–4B реально
 * 100–140 КиБ/токен), плюс 64 МиБ на буферы ggml; четверть свободной памяти
 * резервируем под само приложение.
 * shortcut: точный расчёт будет, когда начнём читать метаданные GGUF
 * (n_layer / n_head / kv_head) вместо константы.
 */
internal const val KV_BYTES_PER_TOKEN = 128L * 1024
internal const val GGML_BUFFER_BYTES = 64L * 1024 * 1024
internal val CTX_LADDER = intArrayOf(4096, 2048, 1024)

/** Наибольший подходящий n_ctx из [CTX_LADDER]; 0 — если не влезает даже минимальный. */
internal fun planNCtx(
    modelBytes: Long,
    availBytes: Long,
): Int {
    val budget = availBytes - maxOf(availBytes / 4, 256L * 1024 * 1024)
    if (budget <= 0) return 0
    return CTX_LADDER.firstOrNull { modelBytes + it * KV_BYTES_PER_TOKEN + GGML_BUFFER_BYTES <= budget } ?: 0
}

/** Сколько байт нужно модели для минимального контекста — для текста ошибки. */
internal fun minNeedBytes(modelBytes: Long): Long = modelBytes + CTX_LADDER.last() * KV_BYTES_PER_TOKEN + GGML_BUFFER_BYTES

// Единственный движок инференса на устройстве (llama.cpp из модуля :llama).
// `loadModel`/`complete` блокирующие — вызывать с фоновых диспетчеров.
object LlmRuntime {
    /** Код Kotlin-слоя (не нативный): модели не хватает свободной памяти. */
    const val ERR_NO_RAM = -8

    data class LoadState(
        val file: String? = null,
        val percent: Int = 0,
        val loading: Boolean = false,
        val error: String? = null,
    )

    private val _load = MutableStateFlow(LoadState())
    val load: StateFlow<LoadState> = _load

    private var loadedPath: String? = null
    private var loadedNCtx = 0

    /** n_ctx, выбранный при последней загрузке (0 — модель не загружена). */
    fun loadedNCtx(): Int = loadedNCtx

    fun loadedPath(): String? = loadedPath

    /**
     * Загружает модель, если она ещё не загружена или файл другой.
     * Возвращает [LlamaBridge.OK] при успехе, код ошибки иначе.
     */
    fun ensureLoaded(
        modelPath: String,
        mmprojPath: String?,
    ): Int =
        synchronized(this) {
            if (LlamaBridge.isLoaded && loadedPath == modelPath) return LlamaBridge.OK
            val modelBytes = File(modelPath).length() + (mmprojPath?.let { File(it).length() } ?: 0L)
            val avail = availMemBytes()
            val nCtx = planNCtx(modelBytes, avail)
            if (nCtx == 0) {
                loadedPath = null
                loadedNCtx = 0
                _load.value =
                    LoadState(
                        file = modelPath,
                        error =
                            "Модели нужно ~${minNeedBytes(modelBytes) / (1024 * 1024)} МиБ свободной памяти, " +
                                "доступно ~${avail / (1024 * 1024)} МиБ. Освободите память или возьмите модель меньше.",
                    )
                return ERR_NO_RAM
            }
            _load.value = LoadState(file = modelPath, percent = 0, loading = true, error = null)
            val code =
                LlamaBridge.loadModel(
                    modelPath = modelPath,
                    mmprojPath = mmprojPath,
                    nCtx = nCtx,
                    nThreads = Runtime.getRuntime().availableProcessors().coerceIn(2, 8),
                    progress = { p -> _load.value = _load.value.copy(percent = p, loading = true) },
                )
            if (code == LlamaBridge.OK) {
                loadedPath = modelPath
                loadedNCtx = nCtx
                _load.value = LoadState(file = modelPath, percent = 100, loading = false, error = null)
            } else {
                loadedPath = null
                loadedNCtx = 0
                _load.value = LoadState(file = modelPath, percent = 0, loading = false, error = LlamaBridge.lastError())
            }
            code
        }

    fun unload() {
        synchronized(this) {
            LlamaBridge.unloadModel()
            loadedPath = null
            loadedNCtx = 0
            _load.value = LoadState()
        }
    }

    /** Свободная память системы (нативные аллокации не ограничены кучей Dalvik). */
    private fun availMemBytes(): Long {
        val am = Deps.app.getSystemService(ActivityManager::class.java) ?: return Long.MAX_VALUE
        val info = ActivityManager.MemoryInfo()
        am.getMemoryInfo(info)
        return info.availMem
    }
}
