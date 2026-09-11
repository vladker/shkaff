package ru.vldkr.shkaff.domain.links

import java.net.URLDecoder
import java.net.URLEncoder

// QR (US-I3): обычная HTTPS-ссылка — «Шкаф» deep-link, без приложения — GitHub.
// Формат: https://github.com/vldkr/shkaff/releases/latest?app=1&code=<закодированный код>
// Гипотеза: `app=1` отделяет ссылки приложения от прочих релиз-ссылок.
object AppLink {
    const val BASE = "https://github.com/vldkr/shkaff/releases/latest"

    fun urlFor(code: String): String =
        "$BASE?app=1&code=${URLEncoder.encode(code, Charsets.UTF_8.name())}"

    fun isAppLink(url: String): Boolean =
        url.startsWith(BASE) && queryParam(url, "app") == "1"

    // Возвращает код вещи из ссылки приложения; null — если это не наша ссылка.
    fun parse(url: String): String? {
        if (!isAppLink(url)) return null
        return queryParam(url, "code")?.let { safeDecode(it) }
    }

    private fun queryParam(url: String, name: String): String? {
        val q = url.substringAfter('?', "").ifBlank { return null }
        for (pair in q.split('&')) {
            val idx = pair.indexOf('=')
            if (idx <= 0) continue
            val k = safeDecode(pair.substring(0, idx))
            if (k == name) return pair.substring(idx + 1)
        }
        return null
    }

    private fun safeDecode(s: String): String = runCatching {
        URLDecoder.decode(s, Charsets.UTF_8.name())
    }.getOrDefault(s)
}