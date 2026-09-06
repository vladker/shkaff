package ru.vldkr.shkaff.domain.printer

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PrintJobTest {

    @Test
    fun testPageStartsWithInitAndContainsAscii() {
        val b = PrintJob.testPage(58)
        assertArrayEquals(byteArrayOf(0x1B, 0x40), b.copyOf(2))
        val s = String(b, Charsets.US_ASCII)
        assertTrue(s.contains("SHKAFF TEST PAGE"))
        assertTrue(s.contains("58 mm"))
    }

    @Test
    fun labelJobSingleChunk() {
        val w = 464
        val h = 200
        val bits = ByteArray(58 * h)
        val job = PrintJob(w, h, bits).bytes()
        // init(2) + raster header(8) + bits + feed(3)
        assertEquals(2 + 8 + bits.size + 3, job.size)
        assertArrayEquals(byteArrayOf(0x1B, 0x40), job.copyOf(2))
        // GS v 0, x=58 (0x3A), y=200 (0xC8)
        assertArrayEquals(
            byteArrayOf(0x1D.toByte(), 0x76.toByte(), 0x30, 0x00, 0x01, 0x3A.toByte(), 0x00, 0xC8.toByte()),
            job.copyOfRange(2, 10)
        )
        assertArrayEquals(byteArrayOf(0x1B, 0x64, 0x03), job.copyOfRange(job.size - 3, job.size))
    }

    @Test
    fun tallLabelSplitsIntoTwoChunks() {
        val w = 464
        val h = 320
        val bits = ByteArray(58 * h)
        val job = PrintJob(w, h, bits).bytes()
        val expected = 2 + (8 + 58 * 255) + (8 + 58 * 65) + 3
        assertEquals(expected, job.size)
        val second = 2 + 8 + 58 * 255
        assertArrayEquals(byteArrayOf(0x1D.toByte(), 0x76.toByte(), 0x30), job.copyOfRange(second, second + 3))
        assertEquals(0x41, job[second + 7].toInt() and 0xFF)
    }

    private fun containsSeq(hay: ByteArray, needle: ByteArray): Boolean {
        for (i in 0..hay.size - needle.size) {
            if (hay.copyOfRange(i, i + needle.size).contentEquals(needle)) return true
        }
        return false
    }

    @Test
    fun textBeforeIsCenteredAndSized() {
        val job = PrintJob(464, 1, ByteArray(58), textBefore = "PRINTER OK").bytes()
        assertTrue(String(job, Charsets.US_ASCII).contains("PRINTER OK"))
        assertTrue(containsSeq(job, byteArrayOf(0x1B, 0x61, 0x01)))
        assertTrue(containsSeq(job, byteArrayOf(0x1D.toByte(), 0x21, 0x11)))
    }
}
