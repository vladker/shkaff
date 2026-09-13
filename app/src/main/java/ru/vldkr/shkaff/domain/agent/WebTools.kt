package ru.vldkr.shkaff.domain.agent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLDecoder
import java.net.URLEncoder

// Инструменты для поиска в интернете (как web_search/web_fetch в opencode).
// Поиск — DuckDuckGo HTML-эндпоинт без API-ключа; результат парсится регексами.
// Чистые парсеры (stripHtml/decodeEntities/parseDuckDuckGo/htmlToText) — без сети,
// покрываются юнит-тестами.

data class SearchHit(val title: String, val url: String, val snippet: String)

object WebTools {
    fun all(): List<Tool> = listOf(WebSearchTool(), WebFetchTool())
}

class WebSearchTool : Tool {

    override val name = "web_search"
    override val description =
        "Поиск в интернете. Возвращает список результатов: заголовок, URL, краткое описание. " +
        "Используй, когда нужны актуальные внешние факты (цены, характеристики, новости) или ссылки на источники."

    override val parameters: JSONObject = JSONObject().apply {
        put("type", "object")
        put(
            "properties", JSONObject().apply {
                put(
                    "query", JSONObject()
                        .put("type", "string")
                        .put("description", "Поисковый запрос — что искать в интернете")
                )
            }
        )
        put("required", JSONArray().put("query"))
    }

    override fun label(args: JSONObject): String = "Поиск: «${args.optString("query", "")}»"

    override suspend fun execute(args: JSONObject): String {
        val q = args.optString("query", "").trim()
        if (q.isEmpty()) return "Пустой запрос — передай аргумент query."
        val html = httpGet("https://html.duckduckgo.com/html/?q=${URLEncoder.encode(q, "UTF-8")}")
            ?: return "Не удалось выполнить поиск: нет сети или поисковик недоступен."
        val hits = parseDuckDuckGo(html).take(8)
        if (hits.isEmpty()) {
            return "Результатов не найдено. Попробуй переформулировать запрос (короче, на русском или английском)."
        }
        return hits.indices.joinToString("\n\n") { i ->
            val h = hits[i]
            buildString {
                append(i + 1).append(". ").append(h.title)
                if (h.url.isNotBlank()) append("\n   ").append(h.url)
                if (h.snippet.isNotBlank()) append("\n   ").append(h.snippet.take(300))
            }
        }
    }
}

class WebFetchTool : Tool {

    override val name = "web_fetch"
    override val description =
        "Прочитать веб-страницу по URL и вернуть её текст без разметки. " +
        "Используй после web_search, чтобы получить детали из конкретного источника."

    override val parameters: JSONObject = JSONObject().apply {
        put("type", "object")
        put(
            "properties", JSONObject().apply {
                put(
                    "url", JSONObject()
                        .put("type", "string")
                        .put("description", "URL страницы (http:// или https://)")
                )
                put(
                    "max_chars", JSONObject()
                        .put("type", "integer")
                        .put("description", "Максимальное число символов текста (по умолчанию 8000)")
                )
            }
        )
        put("required", JSONArray().put("url"))
    }

    override fun label(args: JSONObject): String = "Чтение: ${args.optString("url", "")}"

    override suspend fun execute(args: JSONObject): String {
        val u = args.optString("url", "").trim()
        if (!u.startsWith("http://") && !u.startsWith("https://")) {
            return "URL должен начинаться с http:// или https:// (получено: \"$u\")"
        }
        val maxChars = args.optInt("max_chars", 8000).coerceIn(500, 20_000)
        val html = httpGet(u) ?: return "Не удалось открыть страницу (сайт недоступен или нет сети)."
        val text = htmlToText(html)
        if (text.isBlank()) return "Страница открыта, но текста в ней нет (видимо, только картинки или скрипты)."
        if (text.length > maxChars) {
            return text.substring(0, maxChars) + "\n…[текст обрезан по длине]"
        }
        return text
    }
}

// ---------- Чистая, тестируемая часть ----------

// Ссылки DuckDuckGo — редиректы вида //duckduckgo.com/l/?uddg=<urlencoded>&rut=…
internal fun resolveDdgHref(href: String): String {
    if (href.isBlank()) return ""
    val raw = if ("uddg=" in href) href.substringAfter("uddg=").substringBefore('&') else href
    val decoded = URLDecoder.decode(raw, "UTF-8")
    return if (decoded.startsWith("//")) "https:$decoded" else decoded
}

// Результаты DuckDuckGo HTML: пары <a class="result__a" …>заголовок</a> +
// <a class="result__snippet">…</a>; сопоставляем по порядку появления.
internal fun parseDuckDuckGo(html: String): List<SearchHit> {
    val titles = mutableListOf<Pair<String, String>>()
    Regex("""<a\b[^>]*\bclass="result__a"[^>]*>""").findAll(html).forEach { m ->
        val tag = m.value
        val href = Regex("""href="([^"]*)"""").find(tag)?.groupValues?.get(1) ?: ""
        val start = m.range.last + 1
        val end = html.indexOf("</a>", start)
        val inner = if (end > start) html.substring(start, end) else ""
        titles.add(href to inner)
    }
    val snippets = Regex("""<a\b[^>]*\bclass="result__snippet"[^>]*>([\s\S]*?)</a>""")
        .findAll(html)
        .map { decodeEntities(stripHtml(it.groupValues[1])).trim() }
        .toList()
    return titles.mapIndexed { i, (href, inner) ->
        SearchHit(
            title = decodeEntities(stripHtml(inner)).trim(),
            url = resolveDdgHref(href),
            snippet = snippets.getOrNull(i) ?: "",
        )
    }
}

internal fun stripHtml(s: String): String = s.replace(Regex("<[^>]*>"), "")

private val ENTITY = Regex("&#x([0-9a-fA-F]+);|&#(\\d+);|&([a-zA-Z][a-zA-Z0-9]*);")

// Одним проходом, чтобы «&amp;lt;» не превратилось в «&<».
internal fun decodeEntities(s: String): String = s.replace(ENTITY) { m ->
    when {
        m.groupValues[1].isNotEmpty() -> m.groupValues[1].toInt(16).toChar().toString()
        m.groupValues[2].isNotEmpty() -> m.groupValues[2].toIntOrNull()?.let { it.toChar().toString() } ?: " "
        else -> when (val n = m.groupValues[3]) {
            "amp" -> "&"
            "lt" -> "<"
            "gt" -> ">"
            "quot" -> "\""
            "apos" -> "'"
            "nbsp" -> " "
            "mdash" -> "—"
            "ndash" -> "–"
            "laquo" -> "«"
            "raquo" -> "»"
            "hellip" -> "…"
            else -> "&$n;"
        }
    }
}

// HTML → читаемый текст: режем скрипты/стили, превращаем блоки в переносы,
// сжимаем пробельное на строку и убираем пустые строки.
internal fun htmlToText(html: String): String {
    var s = html
        .replace(Regex("(?is)<script[^>]*>.*?</script>"), " ")
        .replace(Regex("(?is)<style[^>]*>.*?</style>"), " ")
        .replace(Regex("(?is)<noscript[^>]*>.*?</noscript>"), " ")
    s = s.replace(Regex("(?i)</\\s*(p|div|li|ul|ol|table|h[1-6]|tr|section|article|blockquote|pre)>"), "\n")
    s = s.replace(Regex("(?i)<br\\s*/?>"), "\n")
    s = stripHtml(s)
    s = decodeEntities(s)
    s = s.split('\n').joinToString("\n") { it.replace(Regex("[\\s\\u00A0]+"), " ").trim() }
    return s.replace(Regex("\n{3,}"), "\n\n").trim()
}

// ---------- Сеть ----------

// GET с таймаутами; null при любой ошибке (инструменты сами формулируют текст ошибки).
private suspend fun httpGet(url: String, connectMs: Int = 8_000, readMs: Int = 20_000): String? =
    withContext(Dispatchers.IO) {
        val conn = URL(url).openConnection() as HttpURLConnection
        try {
            conn.requestMethod = "GET"
            conn.connectTimeout = connectMs
            conn.readTimeout = readMs
            conn.instanceFollowRedirects = true
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 14; Mobile) Shkaff/1.0")
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            conn.setRequestProperty("Accept-Language", "ru,en;q=0.8")
            val code = conn.responseCode
            if (code !in 200..299) return@withContext null
            val charsetName = conn.contentType
                ?.substringAfter("charset=", "")
                ?.substringBefore(';')
                ?.trim()
                ?.takeIf { it.isNotBlank() }
            val charset = charsetName?.let { runCatching { java.nio.charset.Charset.forName(it) }.getOrNull() }
                ?: Charsets.UTF_8
            conn.inputStream.bufferedReader(charset).readText()
        } catch (e: Exception) {
            null
        } finally {
            conn.disconnect()
        }
    }
