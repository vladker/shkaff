package ru.vldkr.shkaff.features.loans

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.ActiveRole

// T-009: «Вернул» требует права lend; в карточке вещи гейт есть, в списке выдач его не было.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class LoansVmTest {

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
        ActiveRole.set("admin")
    }

    @Test
    fun `canReturn follows active role`() {
        val vm = LoansVm()
        for (r in listOf("view", "add", "move")) {
            ActiveRole.set(r)
            assertEquals(r, false, vm.canReturn())
        }
        ActiveRole.set("admin")
        assertEquals(true, vm.canReturn())
    }

    @Test
    fun `role without lend right cannot close an active loan`() {
        ActiveRole.set("admin")
        val itemId = "loans-gate-item-" + System.nanoTime()
        val loan: LoanEntity = runBlocking { Deps.loans.lend("item", itemId, "Иван", "", null) }
        try {
            ActiveRole.set("view")
            val vm = LoansVm()
            vm.returnLoan(loan)
            Thread.sleep(250)
            val still = runBlocking { Deps.loans.activeForEntity("item", itemId) }
            assertEquals("возврат без права lend запрещён", true, still != null)

            ActiveRole.set("admin")
            vm.returnLoan(still!!)
            var closed = false
            repeat(40) {
                closed = runBlocking { Deps.loans.activeForEntity("item", itemId) } == null
                if (closed) return@repeat
                Thread.sleep(50)
            }
            assertEquals("администратор закрывает выдачу", true, closed)
        } finally {
            runBlocking { Deps.loans.returnLoan(loan.id) }
        }
    }
}
