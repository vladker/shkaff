package ru.vldkr.shkaff.domain.llm

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * T-056: уведомление скачивания модели — человекочитаемые тексты вместо
 * голых процентов; финальное уведомление об успехе/ошибке.
 */
class DownloadNotifyTest {

    @Test
    fun `progress text is labeled with percent`() {
        assertEquals("Скачивание: 45%", DownloadNotify.progressText(0.45f))
        assertEquals("Скачивание: 0%", DownloadNotify.progressText(0f))
        assertEquals("Скачивание: 100%", DownloadNotify.progressText(1f))
    }

    @Test
    fun `fraction outside zero-one clamps to bounds`() {
        assertEquals("Скачивание: 0%", DownloadNotify.progressText(-0.3f))
        // 0.9999 → 99%, не 100%: 100% показываем только по факту завершения
        assertEquals("Скачивание: 99%", DownloadNotify.progressText(0.9999f))
        assertEquals("Скачивание: 100%", DownloadNotify.progressText(1.4f))
    }

    @Test
    fun `done notification says model downloaded`() {
        assertEquals("Модель скачана", DownloadNotify.doneTitle())
    }

    @Test
    fun `error notification is prefixed and never blank`() {
        assertEquals("Ошибка: нет свободного места", DownloadNotify.errorText("нет свободного места"))
        val blank = DownloadNotify.errorText(null)
        assertTrue(blank, blank.startsWith("Ошибка: ") && blank.length > "Ошибка: ".length)
        val empty = DownloadNotify.errorText("")
        assertTrue(empty, empty.startsWith("Ошибка: ") && empty.length > "Ошибка: ".length)
    }

    @Test
    fun `fail title is Russian`() {
        assertEquals("Скачивание не удалось", DownloadNotify.failTitle())
    }
}
