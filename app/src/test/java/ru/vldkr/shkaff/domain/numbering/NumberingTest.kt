package ru.vldkr.shkaff.domain.numbering

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class NumberingTest {

    @Test
    fun formatPadsSeq() {
        assertEquals("T-001", Numbering.format("T", 1, 3))
        assertEquals("T-010", Numbering.format("T", 10, 3))
        assertEquals("S-07", Numbering.format("S", 7, 2))
        assertEquals("B-14", Numbering.format("B", 14, 2))
    }

    @Test
    fun formatEdgeCases() {
        assertEquals("T-1000", Numbering.format("T", 1000, 3)) // seq длиннее ширины — просто приписывается
        assertEquals("0123", Numbering.format("", 123, 4)) // пустой префикс — только тело
        assertEquals("T-7", Numbering.format("T", 7, 0)) // ширина 0 — без дополнения нулями
        assertEquals("T-7", Numbering.format(" T ", 7, 0)) // префикс обрезается
    }

    @Test(expected = IllegalArgumentException::class)
    fun formatRejectsZeroSeq() {
        Numbering.format("T", 0, 3)
    }

    @Test
    fun parseSeq() {
        assertEquals(7, Numbering.parseSeq("T-007", "T"))
        assertEquals(1, Numbering.parseSeq("T-001", "T"))
        assertEquals(123, Numbering.parseSeq("123", ""))
        assertNull(Numbering.parseSeq("", "T"))
        assertNull(Numbering.parseSeq("   ", "T"))
        assertNull(Numbering.parseSeq("T-", "T"))
        assertNull(Numbering.parseSeq("T-x", "T"))
        assertNull(Numbering.parseSeq("T-0", "T"))
    }

    @Test
    fun parseSeqIgnoresForeignPrefix() {
        assertNull(Numbering.parseSeq("B-001", "T"))
        assertNull(Numbering.parseSeq("T001", "T")) // без дефиса не считаем нашим
        assertNull(Numbering.parseSeq("XT-001", "T"))
    }

    @Test
    fun nextAfter() {
        assertEquals(1, Numbering.nextAfter(emptyList(), "T"))
        assertEquals(3, Numbering.nextAfter(listOf("T-001", "T-002"), "T"))
        assertEquals(11, Numbering.nextAfter(listOf("T-001", "T-010", "T-002"), "T"))
        // чужие префиксы и мусор не мешают серии
        assertEquals(2, Numbering.nextAfter(listOf("B-001", "мусор", "T-001"), "T"))
    }
}
