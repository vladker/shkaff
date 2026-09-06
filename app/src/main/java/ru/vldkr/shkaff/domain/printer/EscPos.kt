package ru.vldkr.shkaff.domain.printer

// ESC/POS — байтовые команды для 58-мм термопринтеров. Чистый Kotlin, без Android.
object EscPos {

    const val ESC: Byte = 0x1B
    const val GS: Byte = 0x1D

    fun init(): ByteArray = byteArrayOf(ESC, 0x40)

    fun center(on: Boolean): ByteArray = byteArrayOf(ESC, 0x61, if (on) 0x01 else 0x00)

    fun bold(on: Boolean): ByteArray = byteArrayOf(ESC, 0x45, if (on) 0x01 else 0x00)

    fun inverted(on: Boolean): ByteArray = byteArrayOf(GS, 0x42, if (on) 0x01 else 0x00)

    // GS ! — размер текста; множители 1..8 (аналог «GS h» из старых спецификаций)
    fun size(widthMul: Int = 2, heightMul: Int = 2): ByteArray {
        val w = widthMul.coerceIn(1, 8) - 1
        val h = heightMul.coerceIn(1, 8) - 1
        return byteArrayOf(GS, 0x21, ((h shl 4) or w).toByte())
    }

    fun feed(lines: Int): ByteArray {
        val n = lines.coerceIn(1, 255)
        return byteArrayOf(ESC, 0x64, n.toByte())
    }

    // GS v 0 — вставка растрового изображения: fn=1 (точки),
    // x — ширина в байтах, y — высота в точках; данные монохром, MSB-first построчно
    fun raster(widthPx: Int, heightPx: Int, bits: ByteArray): ByteArray {
        val rowBytes = (widthPx + 7) / 8
        require(widthPx > 0 && heightPx in 1..255 && rowBytes in 1..255) {
            "unsupported raster size: ${widthPx}x$heightPx"
        }
        require(bits.size == rowBytes * heightPx) {
            "raster size mismatch: expected ${rowBytes * heightPx}, got ${bits.size}"
        }
        val out = ByteArray(8 + bits.size)
        out[0] = GS
        out[1] = 0x76
        out[2] = 0x30
        out[3] = 0x00
        out[4] = 0x01
        out[5] = (rowBytes and 0xFF).toByte()
        out[6] = ((rowBytes ushr 8) and 0xFF).toByte()
        out[7] = (heightPx and 0xFF).toByte()
        System.arraycopy(bits, 0, out, 8, bits.size)
        return out
    }

}
