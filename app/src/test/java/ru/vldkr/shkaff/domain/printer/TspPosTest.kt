package ru.vldkr.shkaff.domain.printer

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class TspPosTest {

    @Test
    fun labelHeaderAndInvertedBits() {
        // 464 px (58 mm) x 8 px; растр 58 байт на строку
        val bits = ByteArray(58 * 8)
        java.util.Arrays.fill(bits, 0xFF.toByte())
        val out = TspPos.label(464, 8, bits)
        val head = "SIZE 58 mm,1 mm\nSPEED 5\nDENSITY 40\nCLS\nDIRECTION 0\nBITMAP 0,0,58,8,0,".toByteArray(Charsets.US_ASCII)
        assertArrayEquals(head, out.copyOf(head.size))
        // данные инвертированы: все единицы -> все нули
        for (i in head.size until head.size + bits.size) {
            org.junit.Assert.assertEquals(0, out[i].toInt() and 0xFF)
        }
        // хвост: перевод строки + PRINT 1,1
        val tail = "\nPRINT 1,1\n".toByteArray(Charsets.US_ASCII)
        assertArrayEquals(tail, out.copyOfRange(out.size - tail.size, out.size))
    }

    @Test
    fun copiesRepeatsPrint() {
        val bits = ByteArray(8)
        val out = TspPos.label(8, 8, bits, copies = 2)
        val s = out.toString(Charsets.US_ASCII)
        val first = s.indexOf("PRINT 1,1")
        val second = s.indexOf("PRINT 1,1", first + 1)
        org.junit.Assert.assertTrue(first >= 0 && second > first)
    }
}