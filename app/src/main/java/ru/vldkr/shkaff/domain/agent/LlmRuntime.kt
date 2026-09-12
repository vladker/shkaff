package ru.vldkr.shkaff.domain.agent

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import ru.vldkr.shkaff.llm.LlamaBridge

// Единственный движок инференса на устройстве (llama.cpp из модуля :llama).
// `loadModel`/`complete` блокирующие — вызывать с фоновых диспетчеров.
object LlmRuntime {

    data class LoadState(
        val file: String? = null,
        val percent: Int = 0,
        val loading: Boolean = false,
        val error: String? = null,
    )

    private val _load = MutableStateFlow(LoadState())
    val load: StateFlow<LoadState> = _load

    private var loadedPath: String? = null

    fun loadedPath(): String? = loadedPath

    /**
     * Загружает модель, если она ещё не загружена или файл другой.
     * Возвращает [LlamaBridge.OK] при успехе, код ошибки иначе.
     */
    fun ensureLoaded(modelPath: String, mmprojPath: String?): Int = synchronized(this) {
        if (LlamaBridge.isLoaded && loadedPath == modelPath) return LlamaBridge.OK
        _load.value = LoadState(file = modelPath, percent = 0, loading = true, error = null)
        val code = LlamaBridge.loadModel(
            modelPath = modelPath,
            mmprojPath = mmprojPath,
            nCtx = 4096,
            nThreads = Runtime.getRuntime().availableProcessors().coerceIn(2, 8),
            progress = { p -> _load.value = _load.value.copy(percent = p, loading = true) },
        )
        if (code == LlamaBridge.OK) {
            loadedPath = modelPath
            _load.value = LoadState(file = modelPath, percent = 100, loading = false, error = null)
        } else {
            loadedPath = null
            _load.value = LoadState(file = modelPath, percent = 0, loading = false, error = LlamaBridge.lastError())
        }
        code
    }

    fun unload() {
        synchronized(this) {
            LlamaBridge.unloadModel()
            loadedPath = null
            _load.value = LoadState()
        }
    }
}
