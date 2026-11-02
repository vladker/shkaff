package ru.vldkr.shkaff.features.labels

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.net.Uri
import android.provider.MediaStore
import androidx.core.content.FileProvider
import com.google.zxing.BarcodeFormat
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import org.json.JSONArray
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.domain.labels.GridSpec
import ru.vldkr.shkaff.domain.labels.LabelGrid
import ru.vldkr.shkaff.domain.labels.RectMm
import ru.vldkr.shkaff.domain.links.AppLink
import java.io.File
import java.io.FileOutputStream

object LabelGenerator {

    val FORMATS = listOf("QR", "CODE128", "CODE39", "EAN13", "EAN8", "DATAMATRIX", "PDF417")

    fun barcodeFormat(format: String): BarcodeFormat? = when (format.uppercase()) {
        "QR" -> BarcodeFormat.QR_CODE
        "CODE128" -> BarcodeFormat.CODE_128
        "CODE39" -> BarcodeFormat.CODE_39
        "EAN13" -> BarcodeFormat.EAN_13
        "EAN8" -> BarcodeFormat.EAN_8
        "DATAMATRIX" -> BarcodeFormat.DATA_MATRIX
        "PDF417" -> BarcodeFormat.PDF_417
        else -> null
    }

    // Ключи атрибутов, которые печатать на этикетке (JSON-массив в template.label_attrs).
    fun labelAttrKeys(template: LabelTemplateEntity): List<String> {
        val json = template.label_attrs
        if (json.isBlank()) return emptyList()
        return try {
            val a = JSONArray(json)
            (0 until a.length()).map { a.optString(it, "") }.filter { it.isNotBlank() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    // Строки атрибутов, добавляются под базовый текст: «ключ: значение»,
    // только для ключей, у объекта реально есть значение.
    fun attrLines(template: LabelTemplateEntity, attrs: Map<String, String>): List<String> {
        if (attrs.isEmpty()) return emptyList()
        return labelAttrKeys(template)
            .filter { it in attrs }
            .map { "${it}: ${attrs[it]}" }
            .filter { it.isNotBlank() }
    }

    fun renderText(
        template: LabelTemplateEntity,
        name: String,
        code: String,
        attrs: Map<String, String> = emptyMap()
    ): String {
        val base = template.text_content
            .replace("{name}", name)
            .replace("{code}", code)
            .replace("{id}", template.id)
        val extra = attrLines(template, attrs)
        if (extra.isEmpty()) return base
        val b = base.trimEnd()
        return if (b.isBlank()) extra.joinToString("\n") else "$b\n" + extra.joinToString("\n")
    }

    fun encodeContent(template: LabelTemplateEntity, code: String): String =
        if (template.app_link) AppLink.urlFor(code) else code

    fun generate(
        template: LabelTemplateEntity,
        code: String,
        name: String,
        dpi: Int = 150,
        attrs: Map<String, String> = emptyMap()
    ): Bitmap? {
        if (code.isBlank()) return null
        val fmt = barcodeFormat(template.format) ?: return null
        val payload = encodeContent(template, code)
        val pxPerMm = dpi / 25.4f
        val W = ((template.width_mm * pxPerMm).toInt()).coerceAtLeast(16)
        val H = ((template.height_mm * pxPerMm).toInt()).coerceAtLeast(16)
        val bg = parseColor(template.bg_color)
        val fg = parseColor(template.text_color)
        val margin = if (template.quiet_zone)
            ((template.margin_mm * pxPerMm).toInt()).coerceAtLeast(2)
        else 2

        val text = renderText(template, name, code, attrs)
        val showText = template.show_text && text.isNotBlank()
        val baseLines = if (showText)
            text.split('\n').map { it.trim() }.filter { it.isNotBlank() }
        else emptyList()
        // Номер объекта («code») печатается отдельной строкой, если текст шаблона его уже не содержит.
        val showNumber = template.show_number && code.isNotBlank() && !template.text_content.contains("{code}")
        val lines = if (showNumber && baseLines.none { it == code }) baseLines + code else baseLines
        val fontSizePx = ((template.font_size * 25.4f / 72f) * pxPerMm).toInt().coerceIn(8, 800)
        val lineH = (fontSizePx * 1.7f).toInt()
        val textBlockH = if (lines.isNotEmpty()) lineH * lines.size else 0
        val textOnTop = template.text_position.equals("top", ignoreCase = true)

        val areaW = (W - margin * 2).coerceAtLeast(4)
        val areaH = (H - margin * 2 - textBlockH).coerceAtLeast(4)
        val isSquare = fmt == BarcodeFormat.QR_CODE || fmt == BarcodeFormat.DATA_MATRIX
        val codeW = if (isSquare) minOf(areaW, areaH) else areaW
        val codeH = if (isSquare) minOf(areaW, areaH) else areaH

        val matrix = try {
            MultiFormatWriter().encode(payload, fmt, codeW, codeH)
        } catch (e: Exception) {
            return null
        }

        val codeBmp = matrixToBitmap(matrix, fg, bg, template.invert)
        val out = Bitmap.createBitmap(W, H, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(out)
        canvas.drawColor(bg)
        // Код центрируется в своей области (после блока текста, если текст сверху).
        val codeShift = if (textOnTop) textBlockH else 0
        val codeY = margin + codeShift + ((areaH - codeH) / 2).coerceAtLeast(0)
        canvas.drawBitmap(codeBmp, (W - codeW) / 2f, codeY.toFloat(), null)
        if (lines.isNotEmpty()) {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.color = fg
            paint.textSize = fontSizePx.toFloat()
            paint.textAlign = Paint.Align.CENTER
            val blockTop = if (textOnTop) margin else H - margin - textBlockH
            var y = blockTop + lineH
            lines.forEach {
                canvas.drawText(it, W / 2f, y.toFloat(), paint)
                y += lineH
            }
        }
        return out
    }

    /**
     * Адаптивная раскладка (layout_mode = auto/v/h): код вписывается в область,
     * текст — в оставшуюся полосу, с обрезкой до ширины полосы.
     * layout_mode = "classic" — обычный generate().
     */
    fun generateLayout(
        template: LabelTemplateEntity,
        code: String,
        name: String,
        dpi: Int = 150,
        attrs: Map<String, String> = emptyMap()
    ): Bitmap? {
        if (code.isBlank()) return null
        if (template.layout_mode.equals("classic", ignoreCase = true) || template.layout_mode.isBlank()) {
            return generate(template, code, name, dpi, attrs)
        }
        val fmt = barcodeFormat(template.format) ?: return null
        val plan = LabelGrid.plan(
            template.width_mm, template.height_mm, template.margin_mm,
            template.layout_mode, template.qr_count, template.qr_scale
        )
        val pxPerMm = dpi / 25.4f
        val W = ((template.width_mm * pxPerMm).toInt()).coerceAtLeast(16)
        val H = ((template.height_mm * pxPerMm).toInt()).coerceAtLeast(16)
        val bg = parseColor(template.bg_color)
        val fg = parseColor(template.text_color)
        val isSquare = fmt == BarcodeFormat.QR_CODE || fmt == BarcodeFormat.DATA_MATRIX

        val out = Bitmap.createBitmap(W, H, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(out)
        canvas.drawColor(bg)

        fun boxPx(r: RectMm) = (r.w * pxPerMm).toInt().coerceAtLeast(8) to (r.h * pxPerMm).toInt().coerceAtLeast(8)

        fun drawCode(payload: String, r: RectMm) {
            val (bw, bh) = boxPx(r)
            val matrix = try {
                if (isSquare) {
                    val s = minOf(bw, bh)
                    MultiFormatWriter().encode(payload, fmt, s, s)
                } else {
                    MultiFormatWriter().encode(payload, fmt, bw, bh)
                }
            } catch (e: Exception) {
                return
            }
            val bmp = matrixToBitmap(matrix, fg, bg, template.invert)
            val offX = (r.x * pxPerMm).toInt() + (bw - bmp.width) / 2
            val offY = (r.y * pxPerMm).toInt() + (bh - bmp.height) / 2
            canvas.drawBitmap(bmp, offX.toFloat(), offY.toFloat(), null)
        }

        drawCode(encodeContent(template, code), plan.codeItem)
        plan.codeGithub?.let { drawCode(LabelGrid.GITHUB_URL, it) }

        if (template.show_text) {
            val text = renderText(template, name, code, attrs)
            val baseLines = if (text.isNotBlank())
                text.split('\n').map { it.trim() }.filter { it.isNotBlank() }
            else emptyList()
            val showNumber = template.show_number && !template.text_content.contains("{code}")
            val lines = if (showNumber && baseLines.none { it == code }) baseLines + code else baseLines
            if (lines.isNotEmpty()) {
                val fontPx = ((maxOf(LabelGrid.MIN_FONT_PT, template.font_size) * 25.4f / 72f) * pxPerMm).toInt().coerceIn(8, 800)
                val paint = Paint(Paint.ANTI_ALIAS_FLAG)
                paint.color = fg
                paint.textSize = fontPx.toFloat()
                paint.textAlign = Paint.Align.CENTER
                val maxW = (plan.text.w * pxPerMm).toInt().coerceAtLeast(8)
                val lineH = (fontPx * 1.5f).toInt()
                val boxH = (plan.text.h * pxPerMm).toInt()
                val maxLines = (boxH / lineH).coerceAtLeast(0)
                // Перенос по словам: не вписавшееся по ширине продолжается на следующей строке.
                val wrapped = lines.flatMap { wrap(paint, it, maxW) }
                val shown = wrapped.take(maxLines).toMutableList()
                if (shown.size == maxLines && wrapped.size > maxLines && maxLines > 0) {
                    val last = shown.removeAt(shown.size - 1)
                    shown.add(truncate(paint, last, maxW))
                }
                val blockH = shown.size * lineH
                var y = (plan.text.y * pxPerMm).toInt() + ((boxH - blockH) / 2).coerceAtLeast(0)
                val cx = (plan.text.x + plan.text.w / 2).toFloat() * pxPerMm
                for (line in shown) {
                    canvas.drawText(line, cx, y.toFloat(), paint)
                    y += lineH
                }
            }
        }
        return out
    }

    /** Переносит строку по словам: возвращает строки, не шире maxWidthPx. */
    fun wrap(paint: Paint, text: String, maxWidthPx: Int): List<String> {
        if (paint.measureText(text) <= maxWidthPx) return listOf(text)
        val out = mutableListOf<String>()
        var cur = StringBuilder()
        for (word in text.split(" ")) {
            val pieces = if (paint.measureText(word) <= maxWidthPx) listOf(word)
            else hardBreak(paint, word, maxWidthPx)
            for (p in pieces) {
                when {
                    cur.isEmpty() -> cur.append(p)
                    paint.measureText(cur.toString() + " " + p) <= maxWidthPx -> cur.append(' ').append(p)
                    else -> {
                        out.add(cur.toString())
                        cur = StringBuilder(p)
                    }
                }
            }
        }
        if (cur.isNotEmpty()) out.add(cur.toString())
        return out
    }

    /** Ломает слишком длинное слово посимвольно. */
    private fun hardBreak(paint: Paint, text: String, maxWidthPx: Int): List<String> {
        val out = mutableListOf<String>()
        var rest = text
        while (paint.measureText(rest) > maxWidthPx) {
            var n = rest.length
            while (n > 0 && paint.measureText(rest.substring(0, n)) > maxWidthPx) n--
            if (n <= 0) n = 1
            out.add(rest.substring(0, n))
            rest = rest.substring(n)
        }
        if (rest.isNotEmpty()) out.add(rest)
        return out
    }

    /** Обрезает строку по ширине, подставляя многоточие. */
    fun truncate(paint: Paint, text: String, maxWidthPx: Int): String {
        if (paint.measureText(text) <= maxWidthPx) return text
        val ell = "…"
        var n = text.length
        while (n > 0 && paint.measureText(text.substring(0, n) + ell) > maxWidthPx) n--
        return if (n <= 0) ell else text.substring(0, n) + ell
    }

    private fun matrixToBitmap(m: BitMatrix, fg: Int, bg: Int, invert: Boolean): Bitmap {
        val dark = if (invert) bg else fg
        val light = if (invert) fg else bg
        val w = m.width
        val h = m.height
        val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val row = IntArray(w)
        for (y in 0 until h) {
            for (x in 0 until w) row[x] = if (m.get(x, y)) dark else light
            bmp.setPixels(row, 0, w, 0, y, w, 1)
        }
        return bmp
    }

    // Одна полоска штампования: код + название.
    data class RibbonEntry(val code: String, val name: String)

    /**
     * Штампование ленты (US-I3): N полосок высотой stripMm на одной длинной ленте шириной widthMm,
     * у каждой — код слева (квадрат, вписанный в высоту полоски) и название справа (обрезка по ширине).
     * Для непрерывной ленты/бумаги: печатается одним растром высотой N×stripMm.
     */
    fun generateRibbon(
        entries: List<RibbonEntry>,
        widthMm: Double,
        stripMm: Double = 10.0,
        dpi: Int = 150,
        bgHex: String = "#FFFFFF",
        fgHex: String = "#000000",
        fontPt: Float = 12f,
        showText: Boolean = true
    ): Bitmap? {
        val list = entries.filter { it.code.isNotBlank() }
        if (list.isEmpty()) return null
        // Полоска штампа всегда с QR (запрос пользователя: «QR слева, название справа»).
        val fmt = BarcodeFormat.QR_CODE
        val pxPerMm = dpi / 25.4f
        val W = ((widthMm * pxPerMm).toInt()).coerceAtLeast(32)
        val stripH = ((stripMm * pxPerMm).toInt()).coerceAtLeast(16)
        val H = (stripH * list.size).coerceAtLeast(16)
        val bg = parseColor(bgHex)
        val fg = parseColor(fgHex)
        val margin = (1f * pxPerMm).toInt().coerceAtLeast(2)
        val out = Bitmap.createBitmap(W, H, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(out)
        canvas.drawColor(bg)

        val qrSide = (stripH - margin * 2).coerceAtLeast(16)
        val textLeft = margin + qrSide + margin
        val textMaxW = (W - textLeft - margin).coerceAtLeast(8)
        val fontPx = ((fontPt * 25.4f / 72f) * pxPerMm).toInt().coerceIn(8, 800)
        val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            color = fg
            textSize = fontPx.toFloat()
        }
        val sepPaint = Paint().apply {
            color = fg
            alpha = 90
            strokeWidth = 1f
        }

        list.forEachIndexed { i, e ->
            val top = i * stripH
            // Код слева, по центру по вертикали.
            val matrix = try {
                MultiFormatWriter().encode(e.code, fmt, qrSide, qrSide)
            } catch (ex: Exception) {
                null
            }
            if (matrix != null) {
                val bmp = matrixToBitmap(matrix, fg, bg, false)
                val offX = margin + (qrSide - bmp.width) / 2
                val offY = top + margin + (qrSide - bmp.height) / 2
                canvas.drawBitmap(bmp, offX.toFloat(), offY.toFloat(), null)
            }
            // Название справа, по центру по вертикали, обрезка по ширине.
            if (showText && e.name.isNotBlank()) {
                val shown = truncate(textPaint, e.name, textMaxW)
                val ty = top + stripH / 2f - (textPaint.ascent() + textPaint.descent()) / 2f
                canvas.drawText(shown, textLeft.toFloat(), ty, textPaint)
            }
            // Разделитель между полосками (не после последней).
            if (i < list.size - 1) {
                val y = (top + stripH - 1f)
                canvas.drawLine(0f, y, W.toFloat(), y, sepPaint)
            }
        }
        return out
    }

    // Калибровочная сетка: шахматка (чередующиеся чёрные/белые клетки без зазоров).
    // Пользователь по напечатанной копии отмечает пальцем, какая зона печати плотная.
    fun renderGrid(spec: GridSpec, dpi: Int = 150): Bitmap {
        val pxPerMm = dpi / 25.4f
        val cellPx = (spec.cellMm * pxPerMm).toInt().coerceAtLeast(8)
        val marginPx = (spec.marginMm * pxPerMm).toInt()
        val W = (spec.cols * cellPx + marginPx * 2).coerceAtLeast(16)
        val H = (spec.rows * cellPx + marginPx * 2).coerceAtLeast(16)
        val bmp = Bitmap.createBitmap(W, H, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        canvas.drawColor(Color.WHITE)
        val p = Paint(Paint.ANTI_ALIAS_FLAG).apply { color = Color.BLACK }
        for (r in 0 until spec.rows) {
            for (c in 0 until spec.cols) {
                if ((r + c) % 2 != 0) continue
                val x = (marginPx + c * cellPx).toFloat()
                val y = (marginPx + r * cellPx).toFloat()
                canvas.drawRect(x, y, x + cellPx, y + cellPx, p)
            }
        }
        return bmp
    }

    fun parseColor(hex: String): Int = try {
        Color.parseColor(hex)
    } catch (e: Exception) {
        Color.BLACK
    }

    fun sanitizeFileName(s: String): String =
        s.replace(Regex("[^a-zA-Z0-9А-Яа-яЁё _\\-]"), "_")
            .trim()
            .ifBlank { "label" }

    fun saveToInternal(ctx: Context, bmp: Bitmap, baseName: String): File {
        val dir = File(ctx.filesDir, "labels").apply { mkdirs() }
        val f = File(dir, "${sanitizeFileName(baseName)}.png")
        FileOutputStream(f).use { bmp.compress(Bitmap.CompressFormat.PNG, 100, it) }
        return f
    }

    fun saveToGallery(ctx: Context, bmp: Bitmap, displayName: String): Uri? {
        val values = ContentValues().apply {
            put(MediaStore.Images.Media.DISPLAY_NAME, displayName)
            put(MediaStore.Images.Media.MIME_TYPE, "image/png")
            put(MediaStore.Images.Media.IS_PENDING, 1)
        }
        val uri = ctx.contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
            ?: return null
        runCatching {
            ctx.contentResolver.openOutputStream(uri)?.use {
                bmp.compress(Bitmap.CompressFormat.PNG, 100, it)
            }
            values.clear()
            values.put(MediaStore.Images.Media.IS_PENDING, 0)
            ctx.contentResolver.update(uri, values, null, null)
        }
        return uri
    }

    fun fileShareUri(ctx: Context, file: File): Uri =
        FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", file)
}
