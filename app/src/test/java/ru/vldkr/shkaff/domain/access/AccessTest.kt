package ru.vldkr.shkaff.domain.access

import org.junit.Assert.assertEquals
import org.junit.Test

// T-009: закреплённая матрица прав. Выдача/возврат (lend) — только полный доступ;
// «администрирование» (настройки, профили) — тоже только полный доступ.
class AccessTest {

    @Test
    fun `lend right belongs to admin only`() {
        assertEquals(true, Access.can(Role.ADMIN, Access.LEND))
        for (r in listOf(Role.ADD, Role.MOVE, Role.VIEW)) {
            assertEquals(r.name, false, Access.can(r, Access.LEND))
        }
    }

    @Test
    fun `admin right belongs to admin only`() {
        assertEquals(true, Access.can(Role.ADMIN, Access.ADMIN))
        for (r in listOf(Role.ADD, Role.MOVE, Role.VIEW)) {
            assertEquals(r.name, false, Access.can(r, Access.ADMIN))
        }
    }

    @Test
    fun `matrix sanity per preset`() {
        val all = listOf(Access.CREATE, Access.EDIT, Access.MOVE, Access.LEND, Access.ADMIN, Access.EXPORT, Access.VIEW)
        for (a in all) {
            assertEquals("admin/$a", true, Access.can(Role.ADMIN, a))
            if (a != Access.VIEW) assertEquals("view/$a", false, Access.can(Role.VIEW, a))
        }
        assertEquals(true, Access.can(Role.ADD, Access.CREATE))
        assertEquals(true, Access.can(Role.ADD, Access.VIEW))
        for (a in listOf(Access.EDIT, Access.MOVE, Access.LEND, Access.ADMIN, Access.EXPORT)) {
            assertEquals("add/$a", false, Access.can(Role.ADD, a))
        }
        assertEquals(true, Access.can(Role.MOVE, Access.MOVE))
        assertEquals(true, Access.can(Role.MOVE, Access.VIEW))
        for (a in listOf(Access.CREATE, Access.EDIT, Access.LEND, Access.ADMIN, Access.EXPORT)) {
            assertEquals("move/$a", false, Access.can(Role.MOVE, a))
        }
    }
}
