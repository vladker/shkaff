package ru.vldkr.shkaff.data.llm

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * До старта фонового скачивания на 10 ГБ ModelStore обязан проверить
 * свободное место: иначе посреди загрузки ловится ENOSPC с английским
 * «No space left on device» в карточке (T-052).
 */
@RunWith(RobolectricTestRunner::class)
class ModelStoreSpaceGuardTest {

    private fun store(): ModelStore =
        ModelStore(ApplicationProvider.getApplicationContext<Application>())

    @Test
    fun hugeModelIsRefusedBeforeTheServiceStarts() {
        val store = store()
        val base = store.state.value.rows.first()
        // Модель «размером в эксабайт» не влезет на диск тестового окружения.
        store.start(base.copy(sizeBytes = 1L shl 50))
        val row = store.state.value.rows.first { it.id == base.id }
        assertEquals(ModelState.ERROR, row.state)
        assertTrue(row.message ?: "", row.message!!.contains("Недостаточно свободного места"))
        // Сервис скачивания не запускался: активная загрузка не выставлена.
        assertNull(store.state.value.activeName)
    }

    @Test
    fun modelThatFitsStartsNormally() {
        val store = store()
        val base = store.state.value.rows.first()
        store.start(base.copy(sizeBytes = 1024L * 1024L))
        val row = store.state.value.rows.first { it.id == base.id }
        assertEquals(ModelState.DOWNLOADING, row.state)
        assertEquals(null, row.message)
        assertEquals(base.file, store.state.value.activeName)
    }
}
