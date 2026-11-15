package ru.vldkr.shkaff.features.items

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.di.Deps

// T-023: значения из умного поиска/EAN применяются к вещи всегда, но если
// справочник не обновился (строки нет или запись упала) — пользователь обязан
// получить короткое предупреждение, а не молчаливую потерю словарного значения.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ItemFormDictWarningTest {

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        runBlocking { Deps.db.clearAllTables() }
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    private fun awaitUntil(timeoutMs: Long = 3000, pred: () -> Boolean): Boolean {
        val end = System.currentTimeMillis() + timeoutMs
        while (System.currentTimeMillis() < end) {
            if (pred()) return true
            Thread.sleep(25)
        }
        return pred()
    }

    @Test
    fun `smart search value warns when dictionary definition is missing`() {
        val label = "Т023-Цвет-" + System.nanoTime()
        val missingDef = AttributeDefEntity(
            id = "t023-нет-в-бд-" + System.nanoTime(), scope = "item",
            key = "t023key", label = label, type = "select",
            options = "[]", created_at = 0, updated_at = 0
        )
        val vm = ItemFormVm(null, null)
        vm.attrDefs.value = listOf(missingDef)
        vm.smartSearchResult.value = listOf(ItemFormVm.SmartField("attr:$label", label, "Красный"))
        vm.applySmartSearch()
        assertEquals(
            "значение должно применяться к вещи независимо от словаря",
            "Красный", vm.attrs[missingDef.key]
        )
        assertTrue(
            "словарь не обновился, но предупреждения нет",
            awaitUntil { vm.dictWarning.value != null }
        )
    }
}
