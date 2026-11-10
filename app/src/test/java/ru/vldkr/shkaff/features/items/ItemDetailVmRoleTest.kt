package ru.vldkr.shkaff.features.items

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

// T-009: роль в VM карточки — наблюдаемая (ActiveRole), а не одноразовое чтение init:
// после смены профиля кнопки карточки должны перестроиться без пересоздания экрана.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ItemDetailVmRoleTest {

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
        val vm = ItemDetailVm("no-such-item")
        assertEquals(Role.VIEW, vm.role.value)
        ActiveRole.set("add")
        assertEquals(Role.ADD, vm.role.value)
        ActiveRole.set("move")
        assertEquals(Role.MOVE, vm.role.value)
        ActiveRole.set("admin")
        assertEquals(Role.ADMIN, vm.role.value)
    }
}
