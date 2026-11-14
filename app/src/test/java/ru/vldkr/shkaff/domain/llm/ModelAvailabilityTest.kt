package ru.vldkr.shkaff.domain.llm

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Доступность «Удалить» у строки каталога моделей (T-053): прерванная загрузка
 * оставляет «*.part», но кнопка «Удалить» показывалась только полностью
 * скачанным строкам — осиротевшие части висели в каталоге, а пользовательскую
 * модель с плохим URL нельзя было ни убрать, ни добавить заново.
 */
class ModelAvailabilityTest {

    @Test
    fun idlePresetWithoutAnyFilesIsNotDeletable() {
        assertFalse(
            ModelAvailability.deletable(got = false, custom = false, error = false, partMainBytes = 0, partMmprojBytes = 0)
        )
    }

    @Test
    fun interruptedMainDownloadWithPartFileIsDeletable() {
        assertTrue(
            ModelAvailability.deletable(got = false, custom = false, error = false, partMainBytes = 123, partMmprojBytes = 0)
        )
    }

    @Test
    fun interruptedMmprojDownloadIsDeletable() {
        assertTrue(
            ModelAvailability.deletable(got = true, custom = false, error = false, partMainBytes = 0, partMmprojBytes = 45)
        )
    }

    @Test
    fun errorStateIsDeletableEvenWithoutPartBytes() {
        // Сбой мог стереть/не создать .part (например, HTTP 404 до записи байтов) —
        // карточка всё равно должна убираться.
        assertTrue(
            ModelAvailability.deletable(got = false, custom = false, error = true, partMainBytes = 0, partMmprojBytes = 0)
        )
    }

    @Test
    fun customRowIsAlwaysDeletable() {
        // Строку добавили «по ссылке» и передумали качать: файлов нет, но запись
        // в индексе — её нужно уметь убрать из списка.
        assertTrue(
            ModelAvailability.deletable(got = false, custom = true, error = false, partMainBytes = 0, partMmprojBytes = 0)
        )
    }

    @Test
    fun downloadedRowIsDeletable() {
        assertTrue(
            ModelAvailability.deletable(got = true, custom = false, error = false, partMainBytes = 0, partMmprojBytes = 0)
        )
    }

    @Test
    fun partialTextMentionsResumption() {
        val text = ModelAvailability.partialText(partBytes = 512L * 1024 * 1024, totalBytes = 1024L * 1024 * 1024)
        assertTrue(text, text.contains("загружено"))
        assertTrue(text, text.contains("Скачать"))
    }

    @Test
    fun partialTextWithoutKnownTotal() {
        // Своя модель по ссылке: размер неизвестен (sizeBytes == 0).
        val text = ModelAvailability.partialText(partBytes = 512L * 1024 * 1024, totalBytes = 0)
        assertTrue(text, text.contains("загружено"))
        assertFalse(text, text.contains("из "))
    }
}
