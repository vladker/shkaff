package ru.vldkr.shkaff.features.storages

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.domain.access.Role

// T-009: роль в VM карточки хранилища — наблюдаемая (ActiveRole), не одноразовое чтение.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class StorageDetailVmRoleTest {

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
    fun `vm role follows active role`() {
        ActiveRole.set("view")
        val vm = StorageDetailVm("no-such-storage")
        assertEquals(Role.VIEW, vm.role.value)
        ActiveRole.set("move")
        assertEquals(Role.MOVE, vm.role.value)
        ActiveRole.set("admin")
        assertEquals(Role.ADMIN, vm.role.value)
    }
}
