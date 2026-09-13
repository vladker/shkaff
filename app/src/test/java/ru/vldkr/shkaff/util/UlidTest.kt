package ru.vldkr.shkaff.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class UlidTest {

    @Test
    fun `length is 26 characters`() {
        assertEquals(26, newUlid().length)
    }

    @Test
    fun `uses crockford alphabet without ambiguous letters`() {
        val allowed = "0123456789ABCDEFGHJKMNPQRSTVWXYZ".toSet()
        repeat(100) {
            val ulid = newUlid()
            assertTrue(ulid.all { it in allowed })
            val lower = ulid.lowercase()
            assertTrue("I/L/O/U forbidden", !lower.any { it in "ilou" })
        }
    }

    @Test
    fun `ulids are unique`() {
        val set = (1..2000).map { newUlid() }.toSet()
        assertEquals(2000, set.size)
    }

    @Test
    fun `ulids are chronological`() {
        val a = newUlid()
        Thread.sleep(5)
        val b = newUlid()
        assertTrue("$a > $b", a <= b)
    }
}
