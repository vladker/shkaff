package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.di.Deps

// T-023: inline-добавление значения словаря должно отличать успешную запись
// от «строки нет / запись не удалась» — addOption возвращает результат.
@RunWith(RobolectricTestRunner::class)
class AttributeAddOptionTest {

    @Before
    fun clearDb() {
        runBlocking { Deps.db.clearAllTables() }
    }

    private fun def(id: String) = AttributeDefEntity(
        id = id, scope = "item", key = "t023-color", label = "Цвет T023",
        type = "select", options = "[]", created_at = 0, updated_at = 0
    )

    @Test
    fun `addOption writes option and reports success`() {
        val d = def("t023-def-" + System.nanoTime())
        runBlocking { Deps.attributes.upsert(d) }
        val ok = runBlocking { Deps.attributes.addOption(d.id, "Красный", Deps.deviceId) }
        assertTrue("запись существующего определения должна сообщать об успехе", ok)
        val stored = runBlocking { Deps.attributes.byId(d.id) }!!
        assertTrue(
            "значение не попало в словарь",
            stored.options.contains("Красный")
        )
    }

    @Test
    fun `addOption on missing definition reports failure`() {
        val ok = runBlocking {
            Deps.attributes.addOption("t023-нет-такого-" + System.nanoTime(), "Красный", Deps.deviceId)
        }
        assertFalse("отсутствие строки не должно выглядеть как успех", ok)
    }
}
