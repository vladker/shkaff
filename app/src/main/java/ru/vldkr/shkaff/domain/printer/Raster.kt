package ru.vldkr.shkaff.domain.printer

// Упаковка монохромного растра в байты: 1 бит на точку, тёмная точка = 1, MSB-first, построчно.
object Raster {

    fun bytesPerRow(widthPx: Int): Int = (widthPx + 7) / 8

    fun packRow(dark: BooleanArray, widthPx: Int): ByteArray {
        val out = ByteArray(bytesPerRow(widthPx))
        for (x in dark.indices) {
            if (dark[x]) out[x ushr 3] = (out[x ushr 3].toInt() or (0x80 ushr (x and 7))).toByte()
        }
        return out
    }

    fun pack(widthPx: Int, heightPx: Int, isDark: (Int, Int) -> Boolean): ByteArray {
        val out = ByteArray(bytesPerRow(widthPx) * heightPx)
        for (y in 0 until heightPx) {
            val row = BooleanArray(widthPx) { x -> isDark(x, y) }
            packRow(row, widthPx).copyInto(out, y * bytesPerRow(widthPx))
        }
        return out
    }

    // ARGB-пиксели (в строке) -> монохром по яркости
    fun fromArgb(pixels: IntArray, widthPx: Int, heightPx: Int, threshold: Int = 127): ByteArray {
        return pack(widthPx, heightPx) { x, y ->
            val argb = pixels[y * widthPx + x]
            val a = (argb ushr 24) and 0xFF
            val r = (argb ushr 16) and 0xFF
            val g = (argb ushr 8) and 0xFF
            val b = argb and 0xFF
            // целочисленная яркость BT.601 (77+150+29 = 256): серый уровень даёт точное значение, без float-дрейфа
            if (a == 0) false else ((77 * r + 150 * g + 29 * b) ushr 8) < threshold
        }
    }
}
