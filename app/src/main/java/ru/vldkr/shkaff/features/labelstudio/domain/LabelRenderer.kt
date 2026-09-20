package ru.vldkr.shkaff.features.labelstudio.domain

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Typeface
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.MultiFormatWriter
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import java.io.File
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToInt

interface QrEncoder {
    fun encode(content: String, sizePx: Int, ecLevel: String, quietZone: Int): Bitmap?
}

class ZxingQrEncoder : QrEncoder {
    override fun encode(content: String, sizePx: Int, ecLevel: String, quietZone: Int): Bitmap? {
        if (content.isBlank() || sizePx <= 0) return null
        return try {
            val hints = mapOf(
                EncodeHintType.ERROR_CORRECTION to ErrorCorrectionLevel.valueOf(ecLevel),
                EncodeHintType.MARGIN to quietZone,
                EncodeHintType.CHARACTER_SET to "UTF-8"
            )
            val matrix = QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, sizePx, sizePx, hints)
            matrixToBitmap(matrix)
        } catch (_: Exception) {
            null
        }
    }
}

/**
 * Рендер LabelDoc в растр для предпросмотра и печати. Один и тот же рендер используется
 * и в WYSIWYG-превью, и при отправке на принтер — «печать как есть».
 * dpi по умолчанию 203 = 8 точек/мм (LabelMath.DPI).
 */
object LabelRenderer {

    fun render(
        doc: LabelDoc,
        bindings: Map<String, String> = emptyMap(),
        dpi: Int = 203,
        qrEncoder: QrEncoder = ZxingQrEncoder()
    ): Bitmap {
        val pxPerMm = dpi / 25.4f
        val page = doc.page

        val contentBottom = doc.elements.maxOfOrNull { it.yMm + it.heightMm } ?: page.marginTopMm
        val autoHeight = (contentBottom + page.marginBottomMm)
            .coerceIn(page.minHeightMm, page.maxHeightMm)
        val heightMm = if (page.labelHeightMm > 0f) page.labelHeightMm else autoHeight

        val widthPx = (page.printableWidthMm * pxPerMm).roundToInt().coerceAtLeast(16)
        val heightPx = (heightMm * pxPerMm).roundToInt().coerceAtLeast(16)

        val bmp = Bitmap.createBitmap(widthPx, heightPx, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        canvas.drawColor(Color.WHITE)

        val sorted = doc.elements.sortedBy { it.zIndex }
        for (el in sorted) {
            drawElement(canvas, el, pxPerMm, bindings, qrEncoder)
        }

        return if (page.invert) invertBitmap(bmp) else bmp
    }

    /** 1-bit конверсия с дизерингом Floyd–Steinberg (термопринтер не понимает серый). */
    fun toMonochrome(src: Bitmap, dither: Boolean = true, threshold: Int = 128): Bitmap {
        val w = src.width
        val h = src.height
        val out = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val pixels = IntArray(w * h)
        src.getPixels(pixels, 0, w, 0, 0, w, h)

        val err = FloatArray(w * h)
        for (y in 0 until h) {
            for (x in 0 until w) {
                val i = y * w + x
                val c = pixels[i]
                val r = (c shr 16) and 0xff
                val g = (c shr 8) and 0xff
                val b = c and 0xff
                var lum = 0.299f * r + 0.587f * g + 0.114f * b
                lum += err[i]
                val old = lum.coerceIn(0f, 255f)
                val new = if (old >= threshold) 255f else 0f
                pixels[i] = if (new > 127f) Color.WHITE else Color.BLACK
                val q = old - new
                if (dither) {
                    if (x + 1 < w) err[i + 1] += q * 7f / 16f
                    if (y + 1 < h) {
                        if (x > 0) err[i + w - 1] += q * 3f / 16f
                        err[i + w] += q * 5f / 16f
                        if (x + 1 < w) err[i + w + 1] += q * 1f / 16f
                    }
                }
            }
        }
        out.setPixels(pixels, 0, w, 0, 0, w, h)
        return out
    }

    private fun drawElement(
        canvas: Canvas,
        el: LabelElement,
        pxPerMm: Float,
        bindings: Map<String, String>,
        qrEncoder: QrEncoder
    ) {
        val x = el.xMm * pxPerMm
        val y = el.yMm * pxPerMm
        val w = el.widthMm * pxPerMm
        val h = el.heightMm * pxPerMm

        canvas.save()
        if (el.rotationDeg != 0) {
            canvas.rotate(el.rotationDeg.toFloat(), x + w / 2f, y + h / 2f)
        }

        when (el) {
            is QrElement -> drawQr(canvas, el, x, y, w, h, bindings, qrEncoder)
            is BarcodeElement -> drawBarcode(canvas, el, x, y, w, h, bindings, pxPerMm)
            is TextElement -> drawText(canvas, el, x, y, w, h, bindings, pxPerMm)
            is FieldElement -> drawField(canvas, el, x, y, w, h, bindings, pxPerMm)
            is ImageElement -> drawImage(canvas, el, x, y, w, h)
            is ShapeElement -> drawShape(canvas, el, x, y, w, h, pxPerMm)
        }

        canvas.restore()
    }

    private fun drawQr(
        canvas: Canvas,
        el: QrElement,
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        bindings: Map<String, String>,
        qrEncoder: QrEncoder
    ) {
        val content = resolve(el.content, bindings)
        val side = min(w, h) * el.scale
        val qx = x + (w - side) / 2f
        val qy = y + (h - side) / 2f
        val sizePx = side.roundToInt().coerceAtLeast(8)

        val qr = qrEncoder.encode(content, sizePx, el.ecLevel, el.quietZoneModules)
        if (qr != null) {
            canvas.drawBitmap(qr, null, RectF(qx, qy, qx + side, qy + side), null)
        } else {
            drawPlaceholder(canvas, RectF(qx, qy, qx + side, qy + side), "QR")
        }
    }

    private fun drawBarcode(
        canvas: Canvas,
        el: BarcodeElement,
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        bindings: Map<String, String>,
        pxPerMm: Float
    ) {
        val content = resolve(el.content, bindings)
        val fmt = barcodeFormat(el.symbology)
        if (content.isBlank() || fmt == null) {
            drawPlaceholder(canvas, RectF(x, y, x + w, y + h), "BARCODE")
            return
        }
        val isSquare = fmt == BarcodeFormat.QR_CODE || fmt == BarcodeFormat.DATA_MATRIX
        val side = min(w, h)
        val bw = (if (isSquare) side else w).roundToInt().coerceAtLeast(8)
        val bh = (if (isSquare) side else h).roundToInt().coerceAtLeast(8)
        val matrix = try {
            MultiFormatWriter().encode(content, fmt, bw, bh)
        } catch (e: Exception) {
            drawPlaceholder(canvas, RectF(x, y, x + w, y + h), "BARCODE")
            return
        }
        val bmp = matrixToBitmap(matrix)
        val dx = x + (w - bmp.width) / 2f
        val dy = y + (h - bmp.height) / 2f
        canvas.drawBitmap(bmp, dx, dy, null)
        if (el.showText && content.isNotBlank()) {
            val tp = TextPaint().apply {
                color = Color.BLACK
                textSize = (2f * pxPerMm).coerceAtLeast(6f)
                textAlign = Paint.Align.CENTER
            }
            canvas.drawText(content.take(24), x + w / 2f, y + h - 1f * pxPerMm, tp)
        }
    }

    private fun drawText(
        canvas: Canvas,
        el: TextElement,
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        bindings: Map<String, String>,
        pxPerMm: Float
    ) {
        val text = resolve(el.content, bindings)
        if (text.isBlank()) return

        if (el.background) {
            canvas.drawRect(x, y, x + w, y + h, Paint().apply { color = Color.BLACK })
        }

        val paint = TextPaint().apply {
            color = if (el.background) Color.WHITE else Color.BLACK
            textSize = el.sizeMm * pxPerMm
            typeface = if (el.bold) Typeface.DEFAULT_BOLD else Typeface.DEFAULT
            textAlign = when (el.align) {
                TextAlign.LEFT -> Paint.Align.LEFT
                TextAlign.CENTER -> Paint.Align.CENTER
                TextAlign.RIGHT -> Paint.Align.RIGHT
            }
        }

        val layout = StaticLayout.Builder
            .obtain(text, 0, text.length, paint, w.roundToInt().coerceAtLeast(1))
            .setAlignment(
                when (el.align) {
                    TextAlign.LEFT -> Layout.Alignment.ALIGN_NORMAL
                    TextAlign.CENTER -> Layout.Alignment.ALIGN_CENTER
                    TextAlign.RIGHT -> Layout.Alignment.ALIGN_OPPOSITE
                }
            )
            .setLineSpacing(0f, el.lineHeight)
            .setMaxLines(el.maxLines)
            .setEllipsize(android.text.TextUtils.TruncateAt.END)
            .build()

        val ty = when (el.verticalAlign) {
            VAlign.TOP -> y
            VAlign.CENTER -> y + (h - layout.height) / 2f
            VAlign.BOTTOM -> y + h - layout.height
        }

        canvas.save()
        canvas.translate(x, ty)
        layout.draw(canvas)
        canvas.restore()
    }

    private fun drawField(
        canvas: Canvas,
        el: FieldElement,
        x: Float,
        y: Float,
        w: Float,
        h: Float,
        bindings: Map<String, String>,
        pxPerMm: Float
    ) {
        val value = bindings[el.key].orEmpty().ifBlank { el.fallback }
        val text = if (el.showLabel && el.label.isNotBlank()) "${el.label} $value" else value
        if (text.isBlank()) return
        val paint = TextPaint().apply {
            color = Color.BLACK
            textSize = el.sizeMm * pxPerMm
        }
        val layout = StaticLayout.Builder
            .obtain(text, 0, text.length, paint, w.roundToInt().coerceAtLeast(1))
            .setAlignment(Layout.Alignment.ALIGN_NORMAL)
            .setMaxLines(2)
            .setEllipsize(android.text.TextUtils.TruncateAt.END)
            .build()
        canvas.save()
        canvas.translate(x, y)
        layout.draw(canvas)
        canvas.restore()
    }

    private fun drawImage(canvas: Canvas, el: ImageElement, x: Float, y: Float, w: Float, h: Float) {
        if (el.path.isBlank()) {
            drawPlaceholder(canvas, RectF(x, y, x + w, y + h), "IMG")
            return
        }
        val file = File(el.path)
        if (!file.exists()) {
            drawPlaceholder(canvas, RectF(x, y, x + w, y + h), "NO FILE")
            return
        }
        val src = android.graphics.BitmapFactory.decodeFile(file.absolutePath) ?: return
        val dst = RectF(x, y, x + w, y + h)
        when (el.scaleMode) {
            ScaleMode.FIT -> {
                val ratio = min(w / src.width, h / src.height)
                val dw = src.width * ratio
                val dh = src.height * ratio
                val dx = x + (w - dw) / 2f
                val dy = y + (h - dh) / 2f
                canvas.drawBitmap(src, null, RectF(dx, dy, dx + dw, dy + dh), null)
            }
            ScaleMode.FILL -> {
                val ratio = max(w / src.width, h / src.height)
                val dw = src.width * ratio
                val dh = src.height * ratio
                val dx = x + (w - dw) / 2f
                val dy = y + (h - dh) / 2f
                canvas.drawBitmap(src, null, RectF(dx, dy, dx + dw, dy + dh), null)
            }
            ScaleMode.STRETCH -> canvas.drawBitmap(src, null, dst, null)
        }
    }

    private fun drawShape(canvas: Canvas, el: ShapeElement, x: Float, y: Float, w: Float, h: Float, pxPerMm: Float) {
        val paint = Paint().apply {
            color = Color.BLACK
            style = if (el.filled) Paint.Style.FILL else Paint.Style.STROKE
            strokeWidth = max(1f, el.strokeMm * pxPerMm)
            isAntiAlias = true
        }
        when (el.shape) {
            ShapeType.LINE -> canvas.drawLine(x, y + h / 2f, x + w, y + h / 2f, paint)
            ShapeType.RECT -> canvas.drawRect(x, y, x + w, y + h, paint)
            ShapeType.ELLIPSE -> canvas.drawOval(RectF(x, y, x + w, y + h), paint)
        }
    }

    private fun drawPlaceholder(canvas: Canvas, r: RectF, label: String) {
        val paint = Paint().apply {
            color = Color.DKGRAY
            style = Paint.Style.STROKE
            strokeWidth = 2f
            pathEffect = DashPathEffect(floatArrayOf(8f, 8f), 0f)
        }
        canvas.drawRect(r, paint)
        val tp = Paint().apply {
            color = Color.DKGRAY
            textSize = 18f
            textAlign = Paint.Align.CENTER
            isAntiAlias = true
        }
        canvas.drawText(label, r.centerX(), r.centerY() + 6f, tp)
    }

    private fun resolve(source: ContentSource, bindings: Map<String, String>): String = when (source) {
        is ContentSource.Static -> source.value
        is ContentSource.Field -> bindings[source.key].orEmpty().ifBlank { source.fallback }
        is ContentSource.Template -> {
            var s = source.pattern
            bindings.forEach { (k, v) -> s = s.replace("{{$k}}", v) }
            Regex("\\{\\{[^}]+}}").replace(s, "")
        }
    }

    private fun barcodeFormat(symbology: String): BarcodeFormat? = when (symbology.uppercase()) {
        "QR" -> BarcodeFormat.QR_CODE
        "CODE128" -> BarcodeFormat.CODE_128
        "CODE39" -> BarcodeFormat.CODE_39
        "EAN13" -> BarcodeFormat.EAN_13
        "EAN8" -> BarcodeFormat.EAN_8
        "DATAMATRIX" -> BarcodeFormat.DATA_MATRIX
        "PDF417" -> BarcodeFormat.PDF_417
        else -> null
    }

    private fun invertBitmap(src: Bitmap): Bitmap {
        val w = src.width
        val h = src.height
        val out = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val pixels = IntArray(w * h)
        src.getPixels(pixels, 0, w, 0, 0, w, h)
        for (i in pixels.indices) {
            val c = pixels[i]
            val r = 255 - ((c shr 16) and 0xff)
            val g = 255 - ((c shr 8) and 0xff)
            val b = 255 - (c and 0xff)
            pixels[i] = Color.rgb(r, g, b)
        }
        out.setPixels(pixels, 0, w, 0, 0, w, h)
        return out
    }
}

private fun matrixToBitmap(m: BitMatrix): Bitmap {
    val w = m.width
    val h = m.height
    val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
    val pixels = IntArray(w * h)
    for (y in 0 until h) {
        val offset = y * w
        for (x in 0 until w) {
            pixels[offset + x] = if (m[x, y]) Color.BLACK else Color.WHITE
        }
    }
    bmp.setPixels(pixels, 0, w, 0, 0, w, h)
    return bmp
}