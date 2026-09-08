package ru.vldkr.shkaff.data.printer

import android.graphics.Bitmap
import android.graphics.Color
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.printer.LabelMath
import ru.vldkr.shkaff.domain.printer.PrintJob
import ru.vldkr.shkaff.domain.printer.TspPos
import ru.vldkr.shkaff.features.labels.LabelGenerator
import java.util.concurrent.ConcurrentHashMap

object PrintManager {

    private val cmdModeCache = ConcurrentHashMap<String, String>()

    // Последний определённый режим команд (для подсказки в UI): "01" — ESC/POS, "02" — TSC
    @Volatile
    var lastCmdMode: String? = null

    private fun note(): String = when (lastCmdMode) {
        "02" -> " (TSC)"
        "01" -> " (ESC/POS)"
        else -> ""
    }

    suspend fun testPrint(profile: PrinterProfileEntity): Result<Unit> {
        val t = transport(profile)
        val widthMm = profile.paper_width_mm.toInt()
        val bytes = when (cmdModeOf(profile)) {
            "02" -> TspPos.testPage(widthMm)
            else -> PrintJob.testPage(widthMm)
        }
        return t.send(bytes)
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
        val t = transport(profile)
        val bytes = if (cmdModeOf(profile) == "02") {
            TspPos.label(final.width, final.height, bits)
        } else {
            PrintJob(final.width, final.height, bits, feedLines = 3).bytes()
        }
        return t.send(bytes)
    }

    fun describe(p: PrinterProfileEntity): String = when (p.transport.lowercase()) {
        "tcp" -> "Сеть ${p.host}:${p.port}"
        "usb" -> "USB ${p.host}"
        "ble" -> "BLE ${p.bt_mac}"
        else -> "Bluetooth ${p.bt_mac}"
    }

    // Режим команд принтера (запрос ESC ## JXIG, кэш по MAC):
    // "01" — ESC/POS, "02" — TSC (TSPL); null — не удалось определить/транспорт без ответа → ESC.
    private suspend fun cmdModeOf(p: PrinterProfileEntity): String? {
        val mac = p.bt_mac.trim()
        if (mac.isEmpty()) return null
        cmdModeCache[mac]?.let { return it }
        val mode = transport(p).probe().getOrNull()?.cmdModeHex
        if (!mode.isNullOrBlank()) cmdModeCache[mac] = mode
        return mode
    }

    private fun lum(c: Int): Int =
        (77 * Color.red(c) + 150 * Color.green(c) + 29 * Color.blue(c)) ushr 8

    private fun transport(p: PrinterProfileEntity): Transport = when (p.transport.lowercase()) {
        "tcp" -> TcpTransport(p.host, p.port)
        "usb" -> UsbTransport(Deps.app, p.host)
        "ble" -> BleSppTransport(Deps.app, p.bt_mac)
        else -> BtSppTransport(Deps.app, p.bt_mac)
    }
}