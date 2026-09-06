package ru.vldkr.shkaff.data.printer

import android.graphics.Bitmap
import android.graphics.Color
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.domain.printer.LabelMath
import ru.vldkr.shkaff.domain.printer.PrintJob
import ru.vldkr.shkaff.features.labels.LabelGenerator

object PrintManager {

    suspend fun testPrint(profile: PrinterProfileEntity): Result<Unit> {
        val bytes = PrintJob.testPage(profile.paper_width_mm.toInt())
        return transport(profile).send(bytes)
    }

    suspend fun printLabel(
        profile: PrinterProfileEntity,
        template: LabelTemplateEntity,
        code: String,
        name: String
    ): Result<Unit> {
        val bmp = LabelGenerator.generate(template, code, name, dpi = LabelMath.DPI)
            ?: return Result.failure(
                IllegalStateException("Не удалось сгенерировать этикетку: пустой код или неизвестный формат")
            )
        val targetW = LabelMath.px(profile.paper_width_mm).coerceAtLeast(32)
        val final = if (bmp.width != targetW) {
            val h = (bmp.height * targetW / bmp.width).coerceAtLeast(16)
            Bitmap.createScaledBitmap(bmp, targetW, h, true)
        } else bmp
        val fg = LabelGenerator.parseColor(template.text_color)
        val bg = LabelGenerator.parseColor(template.bg_color)
        val dark = if (template.invert) bg else fg
        val light = if (template.invert) fg else bg
        val bits = BitmapRaster.toBits(final, lum(dark), lum(light))
        val job = PrintJob(final.width, final.height, bits, feedLines = 3)
        return transport(profile).send(job.bytes())
    }

    fun describe(p: PrinterProfileEntity): String = when (p.transport.lowercase()) {
        "tcp" -> "Сеть ${p.host}:${p.port}"
        else -> "Bluetooth ${p.bt_mac}"
    }

    private fun lum(c: Int): Int =
        (77 * Color.red(c) + 150 * Color.green(c) + 29 * Color.blue(c)) ushr 8

    private fun transport(p: PrinterProfileEntity): Transport = when (p.transport.lowercase()) {
        "tcp" -> TcpTransport(p.host, p.port)
        else -> BtSppTransport(p.bt_mac)
    }
}
