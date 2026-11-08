package ru.vldkr.shkaff.domain.access

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

// Активная роль — наблюдаемое состояние (T-009): UI перестраивается при смене профиля
// и не мигает VIEW до первой загрузки.
class ActiveRoleTest {

    @Test
    fun `set parses preset and unknown falls back to view`() {
        ActiveRole.set("admin"); assertEquals(Role.ADMIN, ActiveRole.role.value)
        ActiveRole.set("add"); assertEquals(Role.ADD, ActiveRole.role.value)
        ActiveRole.set("move"); assertEquals(Role.MOVE, ActiveRole.role.value)
        ActiveRole.set("нет-такой"); assertEquals(Role.VIEW, ActiveRole.role.value)
        ActiveRole.set(null); assertEquals(Role.VIEW, ActiveRole.role.value)
    }

    @Test
    fun `flow emits new role on change`() = runBlocking {
        ActiveRole.set("admin")
        assertEquals(Role.ADMIN, ActiveRole.role.first())
        ActiveRole.set("view")
        assertEquals(Role.VIEW, ActiveRole.role.value)
    }
}
