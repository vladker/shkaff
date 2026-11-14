package ru.vldkr.shkaff.util

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Matrix
import android.graphics.Paint
import android.graphics.Rect
import android.net.Uri
import android.provider.MediaStore
import androidx.exifinterface.media.ExifInterface
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.remember
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

object PhotoCapture {

    const val MAX_SIDE = 1600
    const val PHOTO_QUALITY = 82

    fun internalPhotoDir(ctx: Context): File =
        File(ctx.filesDir, "photos").apply { mkdirs() }

    /** Крупнейшая степень двойки, при которой длинная сторона при декоде не меньше MAX_SIDE. */
    fun sampleSizeFor(w: Int, h: Int, maxSide: Int): Int {
        var s = 1
        while (maxOf(w, h) / (s * 2) >= maxSide) s *= 2
        return s
    }

    /**
     * Canonical way to ingest a camera/gallery photo: EXIF-поворот, уменьшение до
     * MAX_SIDE px по длинной стороне, JPEG PHOTO_QUALITY. Декодируемый источник
     * копируется как есть (кадр не теряем). Фото лежит в filesDir/photos, в БД — имя файла.
     */
    fun normalizePhoto(ctx: Context, source: File, maxSide: Int = MAX_SIDE, quality: Int = PHOTO_QUALITY): File {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(source.absolutePath, bounds)
        if (bounds.outWidth <= 0 || bounds.outHeight <= 0) return copyToInternal(ctx, source)
        val opts = BitmapFactory.Options().apply {
            inSampleSize = sampleSizeFor(bounds.outWidth, bounds.outHeight, maxSide)
        }
        val bmp = BitmapFactory.decodeFile(source.absolutePath, opts)
            ?: return copyToInternal(ctx, source)
        val rotated = applyExifRotation(source, bmp)
        val scaled = maxBmp(rotated, maxSide)
        if (scaled !== rotated) rotated.recycle()
        if (scaled !== bmp && !rotated.isRecycled) bmp.recycle()
        val f = File(internalPhotoDir(ctx), "${UUID.randomUUID()}.jpg")
        FileOutputStream(f).use { scaled.compress(Bitmap.CompressFormat.JPEG, quality, it) }
        scaled.recycle()
        return f
    }

    private fun applyExifRotation(source: File, bmp: Bitmap): Bitmap {
        val orientation = runCatching {
            ExifInterface(source.absolutePath)
                .getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
        }.getOrDefault(ExifInterface.ORIENTATION_NORMAL)
        val matrix = Matrix()
        when (orientation) {
            ExifInterface.ORIENTATION_ROTATE_90 -> matrix.postRotate(90f)
            ExifInterface.ORIENTATION_ROTATE_180 -> matrix.postRotate(180f)
            ExifInterface.ORIENTATION_ROTATE_270 -> matrix.postRotate(270f)
            ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.preScale(-1f, 1f)
            ExifInterface.ORIENTATION_FLIP_VERTICAL -> matrix.preScale(1f, -1f)
            ExifInterface.ORIENTATION_TRANSPOSE -> { matrix.postRotate(90f); matrix.preScale(-1f, 1f) }
            ExifInterface.ORIENTATION_TRANSVERSE -> { matrix.postRotate(-90f); matrix.preScale(-1f, 1f) }
            else -> return bmp
        }
        val out = Bitmap.createBitmap(bmp, 0, 0, bmp.width, bmp.height, matrix, true)
        if (out !== bmp) bmp.recycle()
        return out
    }

    fun copyToInternal(ctx: Context, source: File): File {
        val f = File(internalPhotoDir(ctx), "${UUID.randomUUID()}.jpg")
        source.copyTo(f, overwrite = true)
        return f
    }

    fun saveBitmap(ctx: Context, bmp: Bitmap, name: String): File {
        val f = File(internalPhotoDir(ctx), name)
        FileOutputStream(f).use { bmp.compress(Bitmap.CompressFormat.PNG, 95, it) }
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
                bmp.compress(Bitmap.CompressFormat.PNG, 95, it)
            }
            values.clear()
            values.put(MediaStore.Images.Media.IS_PENDING, 0)
            ctx.contentResolver.update(uri, values, null, null)
        }
        return uri
    }

    fun maxBmp(bmp: Bitmap, maxSide: Int = 1600): Bitmap {
        val scale = minOf(1f, maxSide.toFloat() / maxOf(bmp.width, bmp.height))
        return if (scale < 1f)
            Bitmap.createScaledBitmap(bmp, (bmp.width * scale).toInt(), (bmp.height * scale).toInt(), true)
        else bmp
    }
}

@androidx.compose.runtime.Composable
fun rememberPhotoPickers(
    onCaptured: (File) -> Unit,
    onPicked: (File) -> Unit
): PhotoPickers {
    val ctx = androidx.compose.ui.platform.LocalContext.current
    val tmpDir = remember {
        File(ctx.cacheDir, "photo_tmp").apply { mkdirs() }
    }

    val take = rememberLauncherForActivityResult(
        ActivityResultContracts.TakePicture()
    ) { ok: Boolean ->
        if (ok) {
            val f = File(tmpDir, "pending_capture.jpg")
            if (f.exists()) onCaptured(PhotoCapture.normalizePhoto(ctx, f))
        }
    }

    val pick = rememberLauncherForActivityResult(
        ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            val f = File(tmpDir, "pick_${System.currentTimeMillis()}.jpg")
            runCatching {
                ctx.contentResolver.openInputStream(uri)?.use { input ->
                    f.outputStream().use { input.copyTo(it) }
                }
                if (f.exists()) onPicked(PhotoCapture.normalizePhoto(ctx, f))
            }
        }
    }

    val takeUri = remember {
        androidx.core.content.FileProvider.getUriForFile(
            ctx, "${ctx.packageName}.fileprovider",
            File(tmpDir, "pending_capture.jpg")
        )
    }
    return PhotoPickers(
        takePhoto = {
            val f = File(tmpDir, "pending_capture.jpg")
            if (f.exists()) f.delete()
            take.launch(takeUri)
        },
        pickFromGallery = {
            pick.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    )
}

data class PhotoPickers(
    val takePhoto: () -> Unit,
    val pickFromGallery: () -> Unit
)
