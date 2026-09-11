package ru.vldkr.shkaff.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.text.TextPaint
import android.text.TextUtils
import ru.vldkr.shkaff.domain.visual.SchematicBlock

// US-C2: отрисовка схемы хранилища (блоки-ящики) в Bitmap. Схема трактуется как
// обычная «картинка», поэтому редактор разметки и кликабельные области работают
// поверх неё без изменений.
object SchematicRenderer {

    fun render(
        blocks: List<SchematicBlock>,
        width: Int,
        height: Int,
        bg: Int = 0xFFFFFFFF.toInt(),
        blockColor: Int = Color.WHITE,
        borderColor: Int = 0xFF90A4AE.toInt(),
        labelColor: Int = 0xFF37474F.toInt()
    ): Bitmap {
        val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bmp)
        canvas.drawColor(bg)

        val borderPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.STROKE
            strokeWidth = Math.max(2f, width * 0.006f)
            color = borderColor
        }
        val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
            style = Paint.Style.FILL
            color = blockColor
        }
        val textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
            color = labelColor
            textAlign = Paint.Align.CENTER
        }

        val radius = width * 0.03f
        for (b in blocks) {
            val r = RectF(b.rect.left * width, b.rect.top * height, b.rect.right * width, b.rect.bottom * height)
            canvas.drawRoundRect(r, radius, radius, fillPaint)
            canvas.drawRoundRect(r, radius, radius, borderPaint)
            val fontSize = (r.height() * 0.32f).coerceIn(12f, 44f)
            textPaint.textSize = fontSize
            val cx = r.centerX()
            val cy = r.centerY()
            val maxWidth = r.width() - r.width() * 0.12f
            val line1 = TextUtils.ellipsize(b.label, textPaint, maxWidth, TextUtils.TruncateAt.END).toString()
            val fm = textPaint.fontMetrics
            val lineHeight = fm.descent - fm.ascent
            val textY = cy - (fm.ascent + fm.descent) / 2f
            canvas.drawText(line1, cx, if (line1.length < b.label.length) textY else textY, textPaint)
        }
        return bmp
    }
}