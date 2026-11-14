package ru.vldkr.shkaff.data.llm

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * T-055: «Скачать» второй модели во время активной загрузки молча игнорировался
 * (кнопка была активна), а «Отмена» активного сбрасывала состояние и сообщение
 * по всем строкам каталога вместо отменённой.
 */
@RunWith(RobolectricTestRunner::class)
class ModelStoreBusyAndCancelTest {

    private fun store(): ModelStore =
        ModelStore(ApplicationProvider.getApplicationContext<Application>())

    @Test
    fun secondStartWhileBusyExplainsInsteadOfSilentlyIgnoring() {
        val store = store()
        val rows = store.state.value.rows
        store.start(rows[0].copy(sizeBytes = 1024L * 1024L))
        assertEquals(rows[0].file, store.state.value.activeName)
        // Вторая модель: старт запрещён, но пользователь обязан увидеть почему.
        store.start(rows[1].copy(sizeBytes = 1024L * 1024L))
        val second = store.state.value.rows.first { it.id == rows[1].id }
        assertEquals(ModelState.ERROR, second.state)
        assertTrue("нет объяснения: ${second.message}", second.message.orEmpty().contains("качается"))
        // Активная загрузка при этом не сдвинулась.
        assertEquals(rows[0].file, store.state.value.activeName)
    }

    @Test
    fun cancelResetsOnlyTheCancelledRow() {
        val store = store()
        val rows = store.state.value.rows
        // У другой строки — своя ошибка (отказ по месту), её отмена трогать не должна.
        store.start(rows[1].copy(sizeBytes = 1L shl 50))
        val before = store.state.value.rows.first { it.id == rows[1].id }
        assertEquals(ModelState.ERROR, before.state)
        store.start(rows[0].copy(sizeBytes = 1024L * 1024L))
        store.cancel()
        val untouched = store.state.value.rows.first { it.id == rows[1].id }
        assertEquals(before.state, untouched.state)
        assertEquals(before.message, untouched.message)
        val cancelled = store.state.value.rows.first { it.id == rows[0].id }
        assertEquals(ModelState.IDLE, cancelled.state)
        assertEquals(null, cancelled.message)
        assertEquals(null, store.state.value.activeName)
    }
}
