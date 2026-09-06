package ru.vldkr.shkaff.domain.printer

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class EscPosTest {

    @Test
    fun initCommand() {
        assertArrayEquals(byteArrayOf(0x1B, 0x40), EscPos.init())
    }

    @Test
    fun centerOnOff() {
        assertArrayEquals(byteArrayOf(0x1B, 0x61, 0x01), EscPos.center(true))
        assertArrayEquals(byteArrayOf(0x1B, 0x61, 0x00), EscPos.center(false))
    }

    @Test
    fun sizeCommand() {
        assertArrayEquals(byteArrayOf(0x1D, 0x21, 0x00), EscPos.size(1, 1))
        assertArrayEquals(byteArrayOf(0x1D, 0x21, 0x11), EscPos.size(2, 2))
        assertArrayEquals(byteArrayOf(0x1D, 0x21, 0x77), EscPos.size(8, 8))
    }

    @Test
    fun boldAndInverted() {
        assertArrayEquals(byteArrayOf(0x1B, 0x45, 0x01), EscPos.bold(true))
        assertArrayEquals(byteArrayOf(0x1D, 0x42, 0x01), EscPos.inverted(true))
    }

    @Test
    fun feedCommand() {
        assertArrayEquals(byteArrayOf(0x1B, 0x64, 0x03), EscPos.feed(3))
    }

    @Test
    fun rasterHeaderAndLength() {
        val bits = ByteArray(58 * 40)
        val cmd = EscPos.raster(464, 40, bits)
        assertEquals(8 + bits.size, cmd.size)
        // GS v 0, m=0, fn=1, x=58 (0x3A), y=40 (0x28)
        assertArrayEquals(
            byteArrayOf(0x1D.toByte(), 0x76.toByte(), 0x30, 0x00, 0x01, 0x3A.toByte(), 0x00, 0x28.toByte()),
            cmd.copyOf(8)
        )
    }

    @Test
    fun rasterMismatchThrows() {
        assertThrows(IllegalArgumentException::class.java) { EscPos.raster(8, 1, ByteArray(3)) }
    }

    @Test
    fun rasterTooTallThrows() {
        assertThrows(IllegalArgumentException::class.java) { EscPos.raster(8, 256, ByteArray(32)) }
    }
}
