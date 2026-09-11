package ru.vldkr.shkaff.util

import android.graphics.BitmapFactory
import java.io.ByteArrayOutputStream
import java.io.File
import java.net.HttpURLConnection
import java.net.URL
import java.util.UUID

// US-I5: «ссылка — сохранить как картинку в базу». Скачиваем картинку по прямой
// ссылке (http/https) и кладём в кэш — дальше её переносит обычный setPhoto.
object ImageDownload {

    // Страховка от огромных файлов: не читаем в память больше 10 МБ.
    const val MAX_BYTES = 10 * 1024 * 1024

    fun download(ctx: android.content.Context, rawUrl: String): File {
        val trimmed = rawUrl.trim()
        val url = if (trimmed.startsWith("//")) URL("https:$trimmed") else URL(trimmed)
        if (url.protocol != "http" && url.protocol != "https") {
            throw IllegalStateException("Поддерживаются только ссылки http(s)")
        }

        val conn = url.openConnection() as HttpURLConnection
        try {
            conn.connectTimeout = 15_000
            conn.readTimeout = 60_000
            conn.instanceFollowRedirects = true
            conn.setRequestProperty("User-Agent", "Shkaff/1.0")
            val code = conn.responseCode
            if (code !in 200..299) throw IllegalStateException("Ссылка недоступна (HTTP $code)")

            val type = (conn.contentType ?: "").lowercase()
            if (type.isNotEmpty() && !type.startsWith("image/")) {
                throw IllegalStateException("По ссылке не картинка (${type.removePrefix("text/")})")
            }

            val bos = ByteArrayOutputStream()
            val buf = ByteArray(8192)
            var total = 0
            conn.inputStream.use { ins ->
                while (true) {
                    val n = ins.read(buf)
                    if (n < 0) break
                    total += n
                    if (total > MAX_BYTES) throw IllegalStateException("Файл больше 10 МБ")
                    bos.write(buf, 0, n)
                }
            }
            val bytes = bos.toByteArray()
            if (bytes.isEmpty()) throw IllegalStateException("Пустой ответ")

            val opts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            if (BitmapFactory.decodeByteArray(bytes, 0, bytes.size, opts) == null && opts.outWidth <= 0) {
                throw IllegalStateException("Не удалось распознать картинку")
            }

            val ext = when {
                type.contains("png") -> "png"
                type.contains("webp") -> "webp"
                else -> "jpg"
            }
            val out = File(ctx.cacheDir, "link_photo_${UUID.randomUUID()}.$ext")
            out.writeBytes(bytes)
            return out
        } finally {
            conn.disconnect()
        }
    }
}
