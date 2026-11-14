package ru.vldkr.shkaff.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.ByteArrayOutputStream
import java.io.File

/**
 * Фото вещей/полок должны попадать во внутреннее хранилище нормализованными:
 * не более MAX_SIDE px по длинной стороне, JPEG фиксированного качества —
 * иначе 50-Мп камера раздувает базу и бэкап-архив.
 */
@RunWith(RobolectricTestRunner::class)
class PhotoNormalizeTest {

    private fun jpegFile(w: Int, h: Int): File {
        val bmp = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888)
        val out = File.createTempFile("src_", ".jpg")
        ByteArrayOutputStream().use { ba ->
            bmp.compress(Bitmap.CompressFormat.JPEG, 90, ba)
            out.writeBytes(ba.toByteArray())
        }
        bmp.recycle()
        return out
    }

    private fun dims(f: File): Pair<Int, Int> {
        val o = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(f.absolutePath, o)
        return o.outWidth to o.outHeight
    }

    @Test
    fun `большое фото уменьшается до 1600 по длинной стороне с сохранением пропорций`() {
        val ctx = ApplicationProvider.getApplicationContext<android.content.Context>()
        val res = PhotoCapture.normalizePhoto(ctx, jpegFile(2400, 1800))
        assertEquals("jpg", res.extension)
        assertTrue(res.parentFile!!.name == "photos")
        val (w, h) = dims(res)
        assertTrue("длинная сторона $w x $h", maxOf(w, h) <= PhotoCapture.MAX_SIDE)
        assertEquals(4.0 / 3.0, w.toDouble() / h.toDouble(), 0.03)
    }

    @Test
    fun `маленькое фото не увеличивается`() {
        val ctx = ApplicationProvider.getApplicationContext<android.content.Context>()
        val (w, h) = dims(PhotoCapture.normalizePhoto(ctx, jpegFile(800, 600)))
        assertEquals(800, w)
        assertEquals(600, h)
    }

    @Test
    fun `подозрительный файл не теряется — попадает в каталог photos как есть или пережатый`() {
        val ctx = ApplicationProvider.getApplicationContext<android.content.Context>()
        val junk = File.createTempFile("junk_", ".jpg")
        junk.writeBytes(byteArrayOf(1, 2, 3, 4, 5))
        val res = PhotoCapture.normalizePhoto(ctx, junk)
        assertTrue(res.exists() && res.length() > 0)
        assertEquals("photos", res.parentFile!!.name)
    }

@Test
    fun `целочисленный inSampleSize не меньше истинного масштаба`() {
        assertEquals(1, PhotoCapture.sampleSizeFor(1600, 1200, PhotoCapture.MAX_SIDE))
        assertEquals(2, PhotoCapture.sampleSizeFor(3200, 2400, PhotoCapture.MAX_SIDE))
        assertEquals(4, PhotoCapture.sampleSizeFor(8000, 6000, PhotoCapture.MAX_SIDE))
        assertEquals(8, PhotoCapture.sampleSizeFor(16384, 12288, PhotoCapture.MAX_SIDE))
    }
}
