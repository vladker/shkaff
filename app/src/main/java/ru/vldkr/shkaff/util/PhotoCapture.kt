package ru.vldkr.shkaff.util

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.remember
import java.io.File
import java.io.FileOutputStream
import java.util.UUID

object PhotoCapture {

    fun internalPhotoDir(ctx: Context): File =
        File(ctx.filesDir, "photos").apply { mkdirs() }

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
            if (f.exists()) onCaptured(PhotoCapture.copyToInternal(ctx, f))
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
                if (f.exists()) onPicked(PhotoCapture.copyToInternal(ctx, f))
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
