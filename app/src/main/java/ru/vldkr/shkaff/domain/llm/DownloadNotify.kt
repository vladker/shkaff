package ru.vldkr.shkaff.domain.llm

/**
 * T-056: человекочитаемые тексты уведомления о скачивании модели.
 * Раньше текст был «45%» без контекста, а итог (готово/ошибка/обрыв) — молча.
 */
object DownloadNotify {

    fun percent(fraction: Float): Int = (fraction * 100).toInt().coerceIn(0, 100)

    fun progressText(fraction: Float): String = "Скачивание: ${percent(fraction)}%"

    fun doneTitle(): String = "Модель скачана"

    fun failTitle(): String = "Скачивание не удалось"

    fun errorText(message: String?): String =
        "Ошибка: " + (message?.takeIf { it.isNotBlank() } ?: "неизвестная ошибка")
}
