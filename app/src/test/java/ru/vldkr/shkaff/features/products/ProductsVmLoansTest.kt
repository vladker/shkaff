package ru.vldkr.shkaff.features.products

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.StorageData
import ru.vldkr.shkaff.domain.access.ActiveRole

// T-042: экран «Продукты» обязан подписываться на активные выдачи (как «Вещи») —
// иначе выданный продукт на карточке выглядит свободным.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ProductsVmLoansTest {

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        // Deps.db — синглтон Robolectric-sandbox: чужие классы оставляют записи.
        runBlocking { Deps.db.clearAllTables() }
        ActiveRole.set("admin")
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
        ActiveRole.set("admin")
    }

    private fun settled(loans: () -> Boolean): Boolean {
        repeat(60) {
            if (loans()) return true
            Thread.sleep(50)
        }
        return false
    }

    @Test
    fun `active loan on a product appears in loansByItem`() {
        val item = runBlocking { Deps.items.create(ItemData(name = "Творог", ean = "4600000000017")) }
        runBlocking { Deps.loans.lend("item", item.id, "Иван", "", null) }
        val vm = ProductsVm()
        val ok = settled { vm.ui.value.loansByItem[item.id]?.borrower == "Иван" }
        assertEquals("выданный продукт виден в карте выдач экрана", true, ok)
    }

    @Test
    fun `loans of other entity types are not keyed by item`() {
        val storage = runBlocking { Deps.storages.create(StorageData(name = "Склад T-042")) }
        val item = runBlocking { Deps.items.create(ItemData(name = "Сыр", ean = "4600000000024")) }
        runBlocking {
            Deps.loans.lend("storage", storage.id, "Пётр", "", null)
            Deps.loans.lend("item", item.id, "Иван", "", null)
        }
        val vm = ProductsVm()
        // Дожидаемся эмиссии: карта обязана содержать вещь и не содержать выдачу хранилища.
        val sawItem = settled { vm.ui.value.loansByItem.containsKey(item.id) }
        assertEquals("выдача вещи попала в карту", true, sawItem)
        assertNull("выдача хранилища не ключуется по вещам (entity_type = item)", vm.ui.value.loansByItem[storage.id])
    }
}
