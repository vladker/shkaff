package ru.vldkr.shkaff.domain.actions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ActionCodeTest {

    @Test
    fun `round trip without entity`() {
        val raw = ActionCode.encode(ActionCode.Verb.EXPORT)
        val p = ActionCode.parse(raw)
        assertTrue(p.valid)
        assertEquals(ActionCode.Verb.EXPORT, p.verb)
        assertEquals("", p.entityType)
        assertEquals("", p.entityId)
    }

    @Test
    fun `round trip with type and ulid id`() {
        val id = "01J5Z3VXQ8K2M9R4TN6WYHBCDE"
        val raw = ActionCode.encode(ActionCode.Verb.ADD, "item", id)
        val p = ActionCode.parse(raw)
        assertTrue(p.valid)
        assertEquals(ActionCode.Verb.ADD, p.verb)
        assertEquals("item", p.entityType)
        assertEquals(id, p.entityId)
    }

    @Test
    fun `is service code`() {
        assertTrue(ActionCode.isServiceCode(ActionCode.encode(ActionCode.Verb.ADD)))
        assertFalse(ActionCode.isServiceCode("T-001"))
        assertFalse(ActionCode.isServiceCode(ActionCode.INSTALL_URL))
    }

    @Test
    fun `bad version or empty verb is invalid`() {
        assertFalse(ActionCode.parse("shkaff:v2:add:item:x").valid)
        assertFalse(ActionCode.parse("shkaff:v1:").valid)
    }
}
