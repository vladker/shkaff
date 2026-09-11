package ru.vldkr.shkaff.util

import kotlinx.coroutines.channels.Channel

// Deep-link (US-I3): код вещи, пришедший со сторонней ссылки (QR/браузера).
// MainActivity кладёт его сюда, AppRoot открывает экран «Вещи» с поиском.
object DeepLinkBus {
    private val _codes = Channel<String>(Channel.BUFFERED)
    val codes = _codes

    fun send(code: String) {
        runCatching { _codes.trySend(code) }
    }
}