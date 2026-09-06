package ru.vldkr.shkaff.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class ExpiryTest {

    @Test
    fun parseDotFormat() {
        assertEquals(LocalDate.of(2026, 12, 15), Expiry.parse("15.12.2026"))
        assertEquals(LocalDate.of(2026, 5, 3), Expiry.parse("3.5.2026"))
    }

    @Test
    fun parseIsoAndSlash() {
        assertEquals(LocalDate.of(2026, 12, 15), Expiry.parse("2026-12-15"))
        assertEquals(LocalDate.of(2026, 12, 15), Expiry.parse("15/12/2026"))
    }

    @Test
    fun parseInvalidOrNull() {
        assertNull(Expiry.parse(null))
        assertNull(Expiry.parse(""))
        assertNull(Expiry.parse("   "))
        assertNull(Expiry.parse("15.12.26"))
        assertNull(Expiry.parse("вечное"))
    }

    @Test
    fun normalizeToIso() {
        assertEquals("2026-12-15", Expiry.normalize("15.12.2026"))
        assertEquals("2026-05-03", Expiry.normalize("3.5.2026"))
        assertNull(Expiry.normalize("нет даты"))
    }

    @Test
    fun daysUntilSigns() {
        val today = LocalDate.of(2026, 9, 6)
        assertEquals(0, Expiry.daysUntil(today, today))
        assertEquals(1, Expiry.daysUntil(today.plusDays(1), today))
        assertEquals(-1, Expiry.daysUntil(today.minusDays(1), today))
        assertEquals(90, Expiry.daysUntil(today.plusDays(90), today))
    }

    @Test
    fun statusBoundaries() {
        val today = LocalDate.of(2026, 9, 6)
        assertEquals(Expiry.Status.EXPIRED, Expiry.status(today.minusDays(1), today, 90))
        assertEquals(Expiry.Status.SOON, Expiry.status(today, today, 90))
        assertEquals(Expiry.Status.SOON, Expiry.status(today.plusDays(90), today, 90))
        assertEquals(Expiry.Status.OK, Expiry.status(today.plusDays(91), today, 90))
        assertNull(Expiry.status(null, today, 90))
    }

    @Test
    fun isDueIncludesExpired() {
        val today = LocalDate.of(2026, 9, 6)
        assertTrue(Expiry.isDue(today.minusDays(365), today, 90))
        assertTrue(Expiry.isDue(today, today, 90))
        assertTrue(Expiry.isDue(today.plusDays(90), today, 90))
        assertFalse(Expiry.isDue(today.plusDays(91), today, 90))
        assertFalse(Expiry.isDue(null, today, 90))
    }

    @Test
    fun labelFormats() {
        val today = LocalDate.of(2026, 9, 6)
        assertEquals("06.09.2026 — истекает сегодня", Expiry.label(today, today))
        assertEquals("07.09.2026 — завтра", Expiry.label(today.plusDays(1), today))
        assertTrue(Expiry.label(today.minusDays(30), today)!!.contains("истекло 30 дн. назад"))
        assertTrue(Expiry.label(today.plusDays(45), today)!!.contains("через 45 дн."))
        assertNull(Expiry.label(null, today))
    }
}
