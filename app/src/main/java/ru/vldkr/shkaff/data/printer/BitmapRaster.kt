package ru.vldkr.shkaff.data.printer

import android.graphics.Bitmap
import ru.vldkr.shkaff.domain.printer.Raster

object BitmapRaster {

    // Тёмные пиксели — те, чья яркость ближе к тёмному цвету этикетки, чем к светлому
    fun toBits(bmp: Bitmap, darkLum: Int, lightLum: Int): ByteArray {
        val w = bmp.width
        val h = bmp.height
        val pixels = IntArray(w * h)
        bmp.getPixels(pixels, 0, w, 0, 0, w, h)
        val threshold = darkLum + lightLum
        val out = ByteArray(Raster.bytesPerRow(w) * h)
        for (y in 0 until h) {
            val rowStart = y * w
            for (x in 0 until w) {
                val argb = pixels[rowStart + x]
                val a = (argb ushr 24) and 0xFF
                if (a == 0) continue
                val r = (argb ushr 16) and 0xFF
                val g = (argb ushr 8) and 0xFF
                val b = argb and 0xFF
                // целочисленная яркость BT.601 (77+150+29 = 256) — без float-дрейфа на границе порога
                val lum = (77 * r + 150 * g + 29 * b) ushr 8
                if (lum * 2 < threshold) {
                    val i = y * Raster.bytesPerRow(w) + (x ushr 3)
                    out[i] = (out[i].toInt() or (0x80 ushr (x and 7))).toByte()
                }
            }
        }
        return out
    }
}
