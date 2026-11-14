package ru.vldkr.shkaff.features.lists

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher as TestStd
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.features.items.ItemsVm
import ru.vldkr.shkaff.features.products.ProductsVm
import ru.vldkr.shkaff.features.search.SearchVm
import ru.vldkr.shkaff.features.storages.StoragesVm

// T-040: списочные экраны обязаны до первой эмиссии БД быть «загрузкой», а не «пусто»,
// и иметь ветку сбоя. Проверяем контракт VM каждого из четырёх экранов.
// Main — StandardTestDispatcher: collect в конструкторе VM становится очерёдью,
// окно «loading до первой эмиссии» детерминированно, запуск — runCurrent().
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ListVmLoadingTest {

    private val std = TestStd()

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(std)
    }

    @After
    fun restoreMain() {
        Dispatchers.resetMain()
    }

    private fun settled(loading: () -> Boolean): Boolean {
        repeat(120) {
            std.scheduler.runCurrent() // крутим очередь Main: эмиссии Room приходят фоном
            if (!loading()) return true
            Thread.sleep(25)
        }
        return false
    }

    @Test
    fun `items screen starts loading and has an error branch`() {
        val vm = ItemsVm()
        assertEquals("до первой эмиссии список грузится", true, vm.ui.value.loading)
        assertNull("ошибки на старте нет", vm.ui.value.error)
        assertEquals("подписки экрана доходят до данных", true, settled { vm.ui.value.loading })
        assertNull("сбой не выдуман", vm.ui.value.error)
    }

    @Test
    fun `search screen starts loading instead of nothing found`() {
        val vm = SearchVm()
        assertEquals("до первой эмиссии список грузится", true, vm.ui.value.loading)
        assertNull("ошибки на старте нет", vm.ui.value.error)
        assertEquals("подписки экрана доходят до данных", true, settled { vm.ui.value.loading })
        assertNull("сбой не выдуман", vm.ui.value.error)
    }

    @Test
    fun `products screen starts loading instead of products empty`() {
        val vm = ProductsVm()
        assertEquals("до первой эмиссии список грузится", true, vm.ui.value.loading)
        assertNull("ошибки на старте нет", vm.ui.value.error)
        assertEquals("подписки экрана доходят до данных", true, settled { vm.ui.value.loading })
        assertNull("сбой не выдуман", vm.ui.value.error)
    }

    @Test
    fun `storages screen starts loading instead of storages empty`() {
        val vm = StoragesVm()
        assertEquals("до первой эмиссии список грузится", true, vm.ui.value.loading)
        assertNull("ошибки на старте нет", vm.ui.value.error)
        assertEquals("подписки экрана доходят до данных", true, settled { vm.ui.value.loading })
        assertNull("сбой не выдуман", vm.ui.value.error)
    }
}
