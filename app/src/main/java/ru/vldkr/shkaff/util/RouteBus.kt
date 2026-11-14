package ru.vldkr.shkaff.util

import kotlinx.coroutines.channels.Channel

// T-056: маршрут экрана, пришедший из вне (тап по уведомлению скачивания модели).
// MainActivity кладёт его сюда, AppRoot навигирует на экран.
object RouteBus {
    private val _routes = Channel<String>(Channel.BUFFERED)
    val routes = _routes

    fun send(route: String) {
        runCatching { _routes.trySend(route) }
    }
}
