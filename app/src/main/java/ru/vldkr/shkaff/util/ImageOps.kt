package ru.vldkr.shkaff.util

import android.graphics.Bitmap
import android.graphics.Color
import kotlin.math.min
import kotlin.math.sqrt

object ImageOps {

    data class BgOptions(
        val tolerance: Int = 48,
        val feather: Int = 14
    )

    fun removeBackground(src: Bitmap, options: BgOptions = BgOptions()): Bitmap {
        val bmp = PhotoCapture.maxBmp(src)
        val w = bmp.width
        val h = bmp.height
        val pixels = IntArray(w * h)
        bmp.getPixels(pixels, 0, w, 0, 0, w, h)

        val border = sampleBorder(pixels, w, h)
        val d = distanceMap(pixels, w, h, border)
        val feather = options.feather.toFloat().coerceAtLeast(1f)
        val alpha = d.map { dist ->
            val x = ((dist - options.tolerance) / feather).coerceIn(0f, 1f)
            (x * x * (3f - 2f * x) * 255f).toInt().coerceIn(0, 255)
        }

        val out = IntArray(w * h)
        for (i in pixels.indices) {
            val p = pixels[i]
            out[i] = (alpha[i] shl 24) or (p and 0x00FFFFFF)
        }
        val result = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        result.setPixels(out, 0, w, 0, 0, w, h)
        if (result !== bmp) bmp.recycle()
        return result
    }

    private fun sampleBorder(pixels: IntArray, w: Int, h: Int): Int {
        var r = 0L
        var g = 0L
        var b = 0L
        var n = 0L
        val step = (min(w, h) / 24).coerceAtLeast(1)
        for (x in 0 until w step step) {
            r += Color.red(pixels[x]); g += Color.green(pixels[x]); b += Color.blue(pixels[x]); n++
            r += Color.red(pixels[(h - 1) * w + x]); g += Color.green(pixels[(h - 1) * w + x]); b += Color.blue(pixels[(h - 1) * w + x]); n++
        }
        for (y in 0 until h step step) {
            r += Color.red(pixels[y * w]); g += Color.green(pixels[y * w]); b += Color.blue(pixels[y * w]); n++
            r += Color.red(pixels[y * w + w - 1]); g += Color.green(pixels[y * w + w - 1]); b += Color.blue(pixels[y * w + w - 1]); n++
        }
        return (0xFF shl 24) or ((r / n).toInt() shl 16) or ((g / n).toInt() shl 8) or (b / n).toInt()
    }

    private fun distanceMap(pixels: IntArray, w: Int, h: Int, border: Int): FloatArray {
        val dist = FloatArray(w * h)
        for (i in pixels.indices) {
            val p = pixels[i]
            val dr = Color.red(p) - Color.red(border)
            val dg = Color.green(p) - Color.green(border)
            val db = Color.blue(p) - Color.blue(border)
            dist[i] = sqrt((dr * dr + dg * dg + db * db).toFloat()) / sqrt(3f)
        }
        return dist
    }
}
