package ru.vldkr.shkaff.data.printer

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

// Гарантированный путь: этикетка как PNG → системный Share (печать из стороннего приложения)
class ShareTransport(private val ctx: Context) : Transport {

    override suspend fun send(bytes: ByteArray): Result<Unit> {
        val intent = withContext(Dispatchers.Main) {
            val dir = File(ctx.cacheDir, "share").apply { mkdirs() }
            val f = File(dir, "label-${System.currentTimeMillis()}.png")
            f.writeBytes(bytes)
            val uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", f)
            Intent.createChooser(
                Intent(Intent.ACTION_SEND).apply {
                    type = "image/png"
                    putExtra(Intent.EXTRA_STREAM, uri)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
                },
                "Отправить этикетку"
            )
        }
        ctx.startActivity(intent)
        return Result.success(Unit)
    }
}
