package ru.vldkr.shkaff.domain.printer

import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Test

class RasterTest {

    @Test
    fun bytesPerRow() {
        assertEquals(1, Raster.bytesPerRow(8))
        assertEquals(2, Raster.bytesPerRow(9))
        assertEquals(58, Raster.bytesPerRow(464))
    }

    @Test
    fun packRowMsbFirst() {
        val dark = BooleanArray(8)
        dark[0] = true
        assertArrayEquals(byteArrayOf(0x80.toByte()), Raster.packRow(dark, 8))
        dark.fill(false)
        dark[7] = true
        assertArrayEquals(byteArrayOf(0x01), Raster.packRow(dark, 8))
        dark.fill(true)
        assertArrayEquals(byteArrayOf(0xFF.toByte()), Raster.packRow(dark, 8))
    }

    @Test
    fun packRowWide() {
        val dark = BooleanArray(10)
        dark[0] = true
        dark[9] = true
        assertArrayEquals(byteArrayOf(0x80.toByte(), 0x40.toByte()), Raster.packRow(dark, 10))
    }

    @Test
    fun packImage() {
        val bits = Raster.pack(4, 2) { _, _ -> true }
        // MSB-first (как в GS v 0): бит x сидит в позиции 7-(x and 7) своего байта
        assertArrayEquals(byteArrayOf(0xF0.toByte(), 0xF0.toByte()), bits)
    }

    @Test
    fun fromArgbBlackWhite() {
        val pixels = intArrayOf(0xFF000000.toInt(), 0xFFFFFFFF.toInt())
        val bits = Raster.fromArgb(pixels, 2, 1)
        assertEquals(0x80, bits[0].toInt() and 0xFF)
    }

    @Test
    fun fromArgbTransparentIsNotDark() {
        val bits = Raster.fromArgb(intArrayOf(0x00FF0000.toInt()), 1, 1)
        assertEquals(0, bits[0].toInt() and 0xFF)
    }

    @Test
    fun fromArgbThreshold() {
        val lum127 = 0xFF7F7F7F.toInt()
        val bits = Raster.fromArgb(intArrayOf(lum127), 1, 1, threshold = 128)
        assertEquals(0x80, bits[0].toInt() and 0xFF)
        val bits2 = Raster.fromArgb(intArrayOf(lum127), 1, 1, threshold = 127)
        assertEquals(0, bits2[0].toInt() and 0xFF)
    }
}
