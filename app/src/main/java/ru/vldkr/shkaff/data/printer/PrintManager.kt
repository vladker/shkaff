package ru.vldkr.shkaff.data.printer

import android.graphics.Bitmap
import android.graphics.Color
import android.util.Log
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

    // Момент последнего неудачного опроса режима (по MAC) — чтобы не повторять его вхолостую.
    private val probeFailAt = ConcurrentHashMap<String, Long>()

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
        val isTsc = cmdModeOf(profile) == "02"
        val bytes = if (isTsc) TspPos.testPage(widthMm) else PrintJob.testPage(widthMm)
        val res = t.send(bytes)
        Log.d("ShkaffPrint", "testPrint tsc=$isTsc -> ${res.exceptionOrNull()?.message ?: "отправлено"}")
        return res
    }

    suspend fun printLabel(
        profile: PrinterProfileEntity,
        template: LabelTemplateEntity,
        code: String,
        name: String
    ): Result<Unit> {
        val bmp = LabelGenerator.generateLayout(template, code, name, dpi = LabelMath.DPI)
            ?: return Result.failure(
                IllegalStateException("Не удалось сгенерировать этикетку: пустой код или неизвестный формат")
            )
        val fg = LabelGenerator.parseColor(template.text_color)
        val bg = LabelGenerator.parseColor(template.bg_color)
        val dark = if (template.invert) bg else fg
        val light = if (template.invert) fg else bg
        // Печатать с реальным размером этикетки, а не на всю ширину бумаги.
        // Шаблон-зона: растр со сдвигом offset_x/y (мм → px), чтобы зона легла не в (0,0) листа.
        return printBitmap(
            profile, bmp, dark, light, widthMm = template.width_mm,
            offsetXpx = LabelMath.px(template.offset_x_mm),
            offsetYpx = LabelMath.px(template.offset_y_mm)
        )
    }

    // Печать готового bitmap (например, калибровочной сетки) с порогами тёмлого/светлого.
    // widthMm — физическая ширина растра (зона этикетки); null — вся ширина бумаги.
    // offsetX/Ypx — сдвиг вывода растра на метке в точках (TSC BITMAP); 0 — по умолчанию.
    suspend fun printBitmap(
        profile: PrinterProfileEntity,
        bmp: Bitmap,
        dark: Int = Color.BLACK,
        light: Int = Color.WHITE,
        feedLines: Int = 3,
        widthMm: Double? = null,
        offsetXpx: Int = 0,
        offsetYpx: Int = 0
    ): Result<Unit> {
        val wMm = (widthMm ?: profile.paper_width_mm).coerceAtLeast(5.0)
        val targetW = LabelMath.px(wMm).coerceAtLeast(32)
        val final = if (bmp.width != targetW) {
            val h = (bmp.height * targetW / bmp.width).coerceAtLeast(16)
            Bitmap.createScaledBitmap(bmp, targetW, h, true)
        } else bmp
        val bits = BitmapRaster.toBits(final, lum(dark), lum(light))
        val t = transport(profile)
        val isTsc = cmdModeOf(profile) == "02"
        // TSC: SIZE — по ширине бумаги (узкий растр рисуется слева, иначе принтер отклоняет),
        // ESC/POS: растр любой ширины принимается как есть.
        val bytes = if (isTsc) {
            TspPos.label(
                final.width,
                final.height,
                bits,
                labelWidthMm = profile.paper_width_mm.toInt().coerceAtLeast(1),
                offsetXpx = offsetXpx,
                offsetYpx = offsetYpx
            )
        } else {
            if (offsetXpx != 0 || offsetYpx != 0) {
                Log.w("ShkaffPrint", "Сдвиг вывода не поддерживается в ESC/POS — печатаю без позиции")
            }
            PrintJob(final.width, final.height, bits, feedLines = feedLines).bytes()
        }
        val res = t.send(bytes)
        Log.d("ShkaffPrint", "printBitmap ${final.width}x${final.height} tsc=$isTsc -> ${res.exceptionOrNull()?.message ?: "отправлено"}")
        return res
    }

    fun describe(p: PrinterProfileEntity): String = when (p.transport.lowercase()) {
        "tcp" -> "Сеть ${p.host}:${p.port}"
        "usb" -> "USB ${p.host}"
        "ble" -> "BLE ${p.bt_mac}"
        else -> "Bluetooth ${p.bt_mac}"
    }

    // Режим команд принтера (запрос ESC ## JXIG, кэш по MAC):
    // "01" — ESC/POS, "02" — TSC (TSPL); null — не удалось определить/транспорт без ответа → ESC.
    // Сбой опроса кэшируется на 60 с: без этого каждый вызов ждал бы таймаут 6 с,
    // а успешный режим — навсегда (режим принтера не меняется в процессе печати).
    private suspend fun cmdModeOf(p: PrinterProfileEntity): String? {
        val mac = p.bt_mac.trim()
        if (mac.isEmpty()) return null
        cmdModeCache[mac]?.let {
            lastCmdMode = it
            return it
        }
        val failAt = probeFailAt[mac]
        if (failAt != null && System.currentTimeMillis() - failAt < 60_000) {
            lastCmdMode = null
            return null
        }
        val mode = transport(p).probe().getOrNull()?.cmdModeHex?.trim().orEmpty()
        if (mode.isEmpty()) {
            probeFailAt[mac] = System.currentTimeMillis()
            lastCmdMode = null
        } else {
            cmdModeCache[mac] = mode
            lastCmdMode = mode
        }
        Log.d("ShkaffPrint", "probe ${p.transport}/${p.bt_mac.ifEmpty { p.host }}: mode='${mode.ifEmpty { "нет ответа" }}'")
        return mode.ifEmpty { null }
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