package ru.vldkr.shkaff.domain.printer

import java.io.ByteArrayOutputStream
import kotlin.math.roundToInt

// TSPL (TSC) — команды лейбл-принтеров в TSC-режиме. Копия байтового построения из
// eleph-label (a1.java): SIZE/SPEED/DENSITY/CLS/DIRECTION, BITMAP mode 0 (bit=1 — белый,
// 1 строка данных без zlib), PRINT 1,1 на копию. 8 точек/мм (203 dpi).
object TspPos {

    fun label(
        widthPx: Int,
        heightPx: Int,
        bits: ByteArray,
        copies: Int = 1
    ): ByteArray {
        require(widthPx > 0 && heightPx > 0) { "Битовый растр пуст" }
        val wMm = (widthPx / 8f).roundToInt().coerceAtLeast(1)
        val hMm = (heightPx / 8f).roundToInt().coerceAtLeast(1)
        val bpr = Raster.bytesPerRow(widthPx)
        require(bits.size == bpr * heightPx) { "Размер растра не совпадает с пикселями" }
        // a1.b: бит=1 для белых пикселей — инвертируем наш растр (dark=1)
        val inv = ByteArray(bits.size) { bits[it].toInt().inv().toByte() }
        val out = ByteArrayOutputStream()
        out.write(line("SIZE $wMm mm,$hMm mm"))
        out.write(line("SPEED 5"))
        out.write(line("DENSITY 40"))
        out.write(line("CLS"))
        out.write(line("DIRECTION 0"))
        repeat(copies) {
            out.write("BITMAP 0,0,$bpr,$heightPx,0,".toByteArray(Charsets.US_ASCII))
            out.write(inv)
            out.write(byteArrayOf(0x0A))
            out.write(line("PRINT 1,1"))
        }
        return out.toByteArray()
    }

    fun testPage(widthMm: Int = 58): ByteArray {
        val out = ByteArrayOutputStream()
        out.write(line("SIZE $widthMm mm,20 mm"))
        out.write(line("SPEED 5"))
        out.write(line("DENSITY 40"))
        out.write(line("CLS"))
        out.write(line("DIRECTION 0"))
        out.write(line("TEXT 0,8,\"3\",0,1,1,\"SHKAFF OK $widthMm mm\""))
        out.write(line("PRINT 1,1"))
        return out.toByteArray()
    }

    private fun line(s: String): ByteArray = (s + "\n").toByteArray(Charsets.US_ASCII)
}