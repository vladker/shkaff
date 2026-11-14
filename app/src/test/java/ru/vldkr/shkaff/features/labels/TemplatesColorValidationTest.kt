package ru.vldkr.shkaff.features.labels

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps

// T-048: save() проверял цвета только на isBlank — «red» или «#GG» сохранялись
// и при печати молча становились чёрными. save() обязан требовать #RRGGBB.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class TemplatesColorValidationTest {

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        runBlocking { Deps.db.clearAllTables() }
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    private fun savedCount(): Int =
        runBlocking { Deps.db.labelTemplateDao().observeAll().first().size }

    @Test
    fun `save rejects non-hex background`() {
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { f -> f.copy(name = "Мой шаблон", bgColor = "red") }
        vm.save()
        assertNotNull("цвет «red» должен быть отвергнут", vm.ui.value.error)
        assertEquals(0, savedCount())
    }

    @Test
    fun `save rejects malformed hex`() {
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { f -> f.copy(name = "Мой шаблон", bgColor = "#GG8800") }
        vm.save()
        assertNotNull(vm.ui.value.error)
        runBlocking { assertEquals(0, Deps.db.labelTemplateDao().observeAll().first().size) }
    }

    @Test
    fun `save rejects blank colors`() {
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { f -> f.copy(name = "Мой шаблон", bgColor = "") }
        vm.save()
        assertNotNull(vm.ui.value.error)
    }

    // Room пишет на своём executor-потоке — ждём эмиссию поллингом (паттерн репо).
    private fun awaitSavedCount(expected: Int, timeoutMs: Long = 5000): Int {
        val deadline = System.currentTimeMillis() + timeoutMs
        var n = savedCount()
        while (n != expected && System.currentTimeMillis() < deadline) {
            Thread.sleep(50)
            n = savedCount()
        }
        return n
    }

    @Test
    fun `save accepts valid hex colors`() {
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { f -> f.copy(name = "Мой шаблон", bgColor = "#FF8800", textColor = "#102030") }
        vm.save()
        assertNull(vm.ui.value.error)
        assertEquals(1, awaitSavedCount(1))
        val saved = runBlocking { Deps.db.labelTemplateDao().observeAll().first() }
        assertEquals("#FF8800", saved[0].bg_color)
        assertEquals("#102030", saved[0].text_color)
    }
}
