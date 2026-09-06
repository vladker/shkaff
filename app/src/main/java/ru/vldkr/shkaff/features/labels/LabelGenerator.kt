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
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
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

    fun renderText(template: LabelTemplateEntity, name: String, code: String): String =
        template.text_content
            .replace("{name}", name)
            .replace("{code}", code)
            .replace("{id}", template.id)

    fun generate(
        template: LabelTemplateEntity,
        code: String,
        name: String,
        dpi: Int = 150
    ): Bitmap? {
        if (code.isBlank()) return null
        val fmt = barcodeFormat(template.format) ?: return null
        val pxPerMm = dpi / 25.4f
        val W = ((template.width_mm * pxPerMm).toInt()).coerceAtLeast(16)
        val H = ((template.height_mm * pxPerMm).toInt()).coerceAtLeast(16)
        val bg = parseColor(template.bg_color)
        val fg = parseColor(template.text_color)
        val margin = if (template.quiet_zone)
            ((template.margin_mm * pxPerMm).toInt()).coerceAtLeast(2)
        else 2

        val text = renderText(template, name, code)
        val showText = template.show_text && text.isNotBlank()
        val fontSizePx = ((template.font_size * 25.4f / 72f) * pxPerMm).toInt().coerceIn(8, 800)
        val textBlockH = if (showText) ((fontSizePx * 1.7f).toInt()) else 0

        val areaW = (W - margin * 2).coerceAtLeast(4)
        val areaH = (H - margin * 2 - textBlockH).coerceAtLeast(4)
        val isSquare = fmt == BarcodeFormat.QR_CODE || fmt == BarcodeFormat.DATA_MATRIX
        val codeW = if (isSquare) minOf(areaW, areaH) else areaW
        val codeH = if (isSquare) minOf(areaW, areaH) else areaH

        val matrix = try {
            MultiFormatWriter().encode(code, fmt, codeW, codeH)
        } catch (e: Exception) {
            return null
        }

        val codeBmp = matrixToBitmap(matrix, fg, bg, template.invert)
        val out = Bitmap.createBitmap(W, H, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(out)
        canvas.drawColor(bg)
        val cx = (W - codeW) / 2f
        canvas.drawBitmap(codeBmp, cx, margin.toFloat(), null)
        if (showText) {
            val paint = Paint(Paint.ANTI_ALIAS_FLAG)
            paint.color = fg
            paint.textSize = fontSizePx.toFloat()
            paint.textAlign = Paint.Align.CENTER
            val baseline = H - margin / 2f - (textBlockH - fontSizePx) / 2f
            canvas.drawText(text, W / 2f, baseline, paint)
        }
        return out
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
            bmp.setPixels(row, 0, w, 0, y, w, h)
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
