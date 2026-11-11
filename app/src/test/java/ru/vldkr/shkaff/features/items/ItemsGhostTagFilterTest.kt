package ru.vldkr.shkaff.features.items

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps

// T-039: тег-фильтр из роута items/<tag> (дашборд ведёт по тегам самих вещей) мог
// отсутствовать в словаре Deps.tags — VM обязан держать его в tagChips, чтобы UI
// показывал чип и «Все» даже при пустом словаре.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ItemsGhostTagFilterTest {

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    private val dao get() = Deps.db.tagDao()

    private fun awaitUntil(timeoutMs: Long = 3000, pred: () -> Boolean): Boolean {
        val end = System.currentTimeMillis() + timeoutMs
        while (System.currentTimeMillis() < end) {
            if (pred()) return true
            Thread.sleep(25)
        }
        return pred()
    }

    @Test
    fun `ghost tag from route stays in chips and clears with reset`() {
        val ghost = "t039-призрачный-${System.nanoTime()}"
        val vm = ItemsVm()
        assertTrue(
            "подписка экрана не отдала первую выдачу",
            awaitUntil { !vm.ui.value.loading }
        )
        // Так роут items/<tag> применяет фильтр (см. LaunchedEffect в ItemsScreen).
        vm.setTagFilter(ghost)
        assertEquals(ghost, vm.ui.value.tagFilter)
        assertTrue(
            "активный тег вне словаря пропал из чипов — фильтр невидим и неснимаем",
            vm.ui.value.tagChips.any { it.equals(ghost, ignoreCase = true) }
        )
        vm.clearTagFilter()
        assertEquals("", vm.ui.value.tagFilter)
        assertFalse(
            "сброшенный тег остался в чипах",
            vm.ui.value.tagChips.any { it.equals(ghost, ignoreCase = true) }
        )
    }

    @Test
    fun `dictionary tag appears in chips once regardless of case`() {
        val name = "t039-Книги-${System.nanoTime()}"
        val seeded = runBlocking { Deps.tags.add(name) }
        try {
            val vm = ItemsVm()
            assertTrue(
                "словарь тегов не дошёл до VM",
                awaitUntil { vm.ui.value.tagOptions.any { it.equals(name, ignoreCase = true) } }
            )
            vm.setTagFilter(name.lowercase())
            val hits = vm.ui.value.tagChips.count { it.equals(name, ignoreCase = true) }
            assertEquals("тег продублирован в чипах (словарь + активный)", 1, hits)
            assertEquals(name.lowercase(), vm.ui.value.tagFilter)
        } finally {
            runBlocking { dao.softDelete(seeded.id, System.currentTimeMillis(), Deps.deviceId) }
        }
    }
}
