package ru.vldkr.shkaff.util

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Шина кодов штрихкодов: источники (HID-перехват MainActivity, камеры) → экраны.
 * `codes` — живая очередь без реплея для подписки в LaunchedEffect;
 * `lastCode` — одноразовый код для экранов, ещё не скомпозированных: читают при
 * композиции и обнуляют после взятия.
 */
object ScanBus {
    @Volatile
    var lastCode: String? = null

    private val _codes = MutableSharedFlow<String>(
        extraBufferCapacity = 16,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val codes: SharedFlow<String> = _codes.asSharedFlow()

    fun publish(code: String) {
        lastCode = code
        _codes.tryEmit(code)
    }

    /** Только для тестов: сброс состояния синглтона. */
    fun reset() {
        lastCode = null
    }
}
