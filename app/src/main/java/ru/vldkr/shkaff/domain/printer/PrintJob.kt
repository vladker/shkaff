package ru.vldkr.shkaff.domain.printer

import java.io.ByteArrayOutputStream
import java.time.LocalDate

// Полный пакет печати: инициализация → (текст) → растр (чунками <= 255 строк) → подача.
data class PrintJob(
    val widthPx: Int,
    val heightPx: Int,
    val bits: ByteArray,
    val textBefore: String? = null,
    val feedLines: Int = 3
) {
    fun bytes(): ByteArray {
        val out = ByteArrayOutputStream()
        out.write(EscPos.init())
        textBefore?.takeIf { it.isNotBlank() }?.let { t ->
            out.write(EscPos.center(true))
            out.write(EscPos.size(2, 2))
            out.write(t.toByteArray(Charsets.US_ASCII))
            out.write(EscPos.size(1, 1))
            out.write(EscPos.center(false))
            out.write(byteArrayOf(0x0D, 0x0A))
        }
        val rowBytes = if (widthPx > 0) Raster.bytesPerRow(widthPx) else 1
        var y = 0
        while (heightPx > 0 && y < heightPx) {
            val h = minOf(255, heightPx - y)
            val slice = bits.copyOfRange(y * rowBytes, (y + h) * rowBytes)
            out.write(EscPos.raster(widthPx, h, slice))
            y += h
        }
        out.write(EscPos.feed(feedLines))
        return out.toByteArray()
    }

    companion object {
        fun testPage(widthMm: Int = 58): ByteArray {
            val text = buildString {
                append("SHKAFF TEST PAGE\r\n")
                append("paper ${widthMm} mm @ ${LabelMath.DPI} dpi\r\n")
                append(LocalDate.now().toString() + "\r\n")
                append("OK: ESC/POS, raster GS v 0\r\n")
            }
            return PrintJob(
                widthPx = 1,
                heightPx = 0,
                bits = ByteArray(0),
                textBefore = text.trimEnd('\r', '\n', ' '),
                feedLines = 3
            ).bytes()
        }
    }
}
