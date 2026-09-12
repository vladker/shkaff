package ru.vldkr.shkaff.domain.ean

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

/**
 * US-B2: Поиск информации о вещи через headless браузер с умным поиском Алиса AI.
 * 
 * Этот провайдер использует headless браузер для парсинга веб-страниц и отправляет
 * собранные данные в Алиса AI для получения структурированного ответа в формате JSON
 * для заполнения карточки вещи.
 * 
 * @param settings Функция для получения настроек LLM (Алиса AI)
 * @param searchUrlTemplate Шаблон URL для поиска (по умолчанию Яндекс)
 */
class EanHeadlessBrowser(
    private val settings: () -> AgentSettings,
    private val searchUrlTemplate: String = "https://yandex.ru/search/?text={query}"
) : EanProvider {

    // Понятная пользователю причина сбоя поиска (вместо тихого null).
    class SearchException(message: String) : Exception(message)

    data class SearchQuery(
        val ean: String? = null,
        val name: String? = null,
        val brand: String? = null,
        val category: String? = null
    ) {
        fun toQueryString(): String {
            val parts = mutableListOf<String>()
            ean?.takeIf { it.isNotBlank() }?.let { parts += "штрихкод $it" }
            name?.takeIf { it.isNotBlank() }?.let { parts += it }
            brand?.takeIf { it.isNotBlank() }?.let { parts += "бренд $it" }
            category?.takeIf { it.isNotBlank() }?.let { parts += "категория $it" }
            return parts.joinToString(" ")
        }
    }

    override suspend fun lookup(ean: String): EanProduct? {
        return lookupByQuery(SearchQuery(ean = ean))
    }

    /**
     * Поиск по произвольному запросу (название, бренд, категория)
     */
    suspend fun lookupByQuery(query: SearchQuery, onStep: (String) -> Unit = {}): EanProduct? {
        val json = runCatching { smartLookup(query, emptyMap(), onStep) }.getOrNull() ?: return null
        val name = json.optString("name", "").trim()
        if (name.isBlank()) return null
        val attrs = json.optJSONObject("attributes") ?: JSONObject()
        return EanProduct(
            name = name,
            brand = attrs.optString("Бренд", "").trim().ifBlank { json.optString("brand", "").trim() },
            categories = attrs.optString("Категория", "").trim().ifBlank { json.optString("categories", "").trim() },
            quantity = attrs.optString("Количество", "").trim().ifBlank { json.optString("quantity", "").trim() },
            imageUrl = json.optString("imageUrl", "").trim(),
            extra = buildExtraFromAI(json)
        )
    }

    /**
     * Полный поиск: Яндекс → Алиса AI → JSON с полями карточки.
     *
     * @param formContext Текущие поля карточки (подпись → значение): Алиса AI видит,
     *                    что уже заполнено, и дополняет/уточняет по результатам поиска.
     * @param onStep      Вызов с текстом текущего шага (отображается в строке формы).
     * @return JSON с полями (name, code, ean, description, expiryDate, volumeLiters,
     *         weightKg, tags, attributes{подпись→значение}).
     * @throws SearchException С понятной причиной, если что-то пошло не так.
     */
    suspend fun smartLookup(
        query: SearchQuery,
        formContext: Map<String, String>,
        onStep: (String) -> Unit = {}
    ): JSONObject {
        val queryString = query.toQueryString()
        if (queryString.isBlank()) throw SearchException("Пустой запрос для поиска")

        val s = settings()
        if (!s.enabled) throw SearchException("Алиса AI выключена — включите её в настройках агента")

        return withContext(Dispatchers.IO) {
            onStep("Открываем поиск Яндекса…")
            val scraped = try {
                scrapeSearchResults(queryString)
            } catch (e: Exception) {
                throw SearchException("Не удалось связаться с Яндексом: ${e.message}")
            }
            if (scraped.error != null) {
                throw SearchException("Яндекс не открыл страницу поиска: ${scraped.error}")
            }

            onStep("Парсим результаты поиска…")
            onStep("Отправляем в Алиса AI…")
            val prompt = buildPrompt(scraped, queryString, formContext)
            val responseText = try {
                Agent.complete(
                    settings = s,
                    messages = listOf(ChatMessage("user", prompt))
                )
            } catch (e: Exception) {
                throw SearchException("Алиса AI не ответила: ${e.message}")
            }

            onStep("Разбираем ответ…")
            ChatClient.extractJson(responseText)
                ?: throw SearchException("Ответ Алисы AI не распознал как JSON")
        }
    }

    /**
     * Эмуляция парсинга через headless браузер.
     * В реальной реализации здесь будет интеграция с WebView или Selenium/Playwright.
     * Для Android используем упрощённый подход с HttpURLConnection + User-Agent.
     */
    private fun scrapeSearchResults(query: String): ScrapedContent {
        val searchUrl = searchUrlTemplate.replace("{query}", query.encodeToURL())
        
        val conn = URL(searchUrl).openConnection() as HttpURLConnection
        try {
            conn.requestMethod = "GET"
            conn.connectTimeout = 15_000
            conn.readTimeout = 30_000
            // Эмуляция браузера
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            
            if (conn.responseCode !in 200..299) {
                return ScrapedContent(error = "HTTP ${conn.responseCode}")
            }
            
            val html = conn.inputStream.bufferedReader(Charsets.UTF_8).readText()
            
            // Упрощённый парсинг HTML для извлечения текста
            val textContent = extractTextFromHtml(html)
            val titles = extractTitlesFromHtml(html)
            val snippets = extractSnippetsFromHtml(html)
            
            return ScrapedContent(
                fullText = textContent,
                titles = titles,
                snippets = snippets,
                url = searchUrl
            )
        } finally {
            conn.disconnect()
        }
    }

    /**
     * Промпт: Алиса AI видит текущее содержимое карточки (все поля, включая
     * пользовательские атрибуты) и результаты поиска, возвращает JSON для предзаполнения.
     */
    private fun buildPrompt(scraped: ScrapedContent, query: String, formContext: Map<String, String>): String {
        val context = if (formContext.isEmpty()) "" else
            "\n\nТекущее содержимое карточки (заполни пустые поля, уточни непустые, если в результатах есть точные данные):\n" +
                formContext.entries.joinToString("\n") { (label, value) -> "- $label: $value" }
        return """
Ты помощник, который заполняет карточку вещи в приложении инвентаризации.
Проанализируй результаты поиска по запросу "$query" и заполни поля карточки.$context

Результаты поиска:
${scraped.titles.take(5).joinToString("\n")}

Фрагменты:
${scraped.snippets.take(5).joinToString("\n")}

Верни ТОЛЬКО JSON без пояснений:
{
  "name": "Название вещи",
  "code": "Код/артикул производителя или пусто",
  "ean": "Штрихкод (EAN) или пусто",
  "description": "Краткое описание вещи",
  "expiryDate": "Срок годности ДД.ММ.ГГГГ или пусто",
  "volumeLiters": "Объём в литрах, число или пусто",
  "weightKg": "Вес в кг, число или пусто",
  "tags": "тег1, тег2 или пусто",
  "attributes": { "Бренд": "...", "Категория": "...", "название атрибута из карточки": "значение" }
}

Правила:
- name обязателен.
- Не выдумывай: только данные, присутствующие в результатах поиска. Неизвестное — пустая строка.
- В attributes — атрибуты карточки (по их названиям из текущего содержимого) и другие уместные: бренд, категория, серия, цвет.
""".trimIndent()
    }

    private fun buildExtraFromAI(json: JSONObject): Map<String, String> {
        val extra = mutableMapOf<String, String>()
        val attrs = json.optJSONObject("attributes")
        attrs?.let { a ->
            a.keys().forEach { k ->
                val v = a.optString(k, "").trim()
                if (v.isNotBlank()) extra[k] = v
            }
        }
        return extra
    }

    // Упрощённые функции парсинга HTML
    private fun extractTextFromHtml(html: String): String {
        return html
            .replace(Regex("<script[^>]*>.*?</script>", RegexOption.DOT_MATCHES_ALL), " ")
            .replace(Regex("<style[^>]*>.*?</style>", RegexOption.DOT_MATCHES_ALL), " ")
            .replace(Regex("<[^>]+>"), " ")
            .replace(Regex("\\s+"), " ")
            .trim()
            .take(5000) // Ограничиваем размер
    }

    private fun extractTitlesFromHtml(html: String): List<String> {
        return buildList {
            val titlePattern = Regex("<title[^>]*>(.*?)</title>", RegexOption.IGNORE_CASE)
            titlePattern.findAll(html).forEach { match ->
                add(match.groupValues[1].trim())
            }
            
            val h1Pattern = Regex("<h1[^>]*>(.*?)</h1>", RegexOption.IGNORE_CASE)
            h1Pattern.findAll(html).forEach { match ->
                add(match.groupValues[1].trim().take(200))
            }
        }
    }

    private fun extractSnippetsFromHtml(html: String): List<String> {
        return buildList {
            val snippetPattern = Regex("<div[^>]*class=\"[^\"]*snippet[^\"]*\"[^>]*>(.*?)</div>", RegexOption.IGNORE_CASE)
            snippetPattern.findAll(html).forEach { match ->
                val text = match.groupValues[1]
                    .replace(Regex("<[^>]+>"), " ")
                    .trim()
                    .take(300)
                if (text.isNotBlank()) add(text)
            }
            
            val linkTitlePattern = Regex("<a[^>]*title=\"([^\"]+)\"", RegexOption.IGNORE_CASE)
            linkTitlePattern.findAll(html).forEach { match ->
                add(match.groupValues[1].trim().take(200))
            }
        }.take(10)
    }

    private fun String.encodeToURL(): String {
        return java.net.URLEncoder.encode(this, "UTF-8")
    }

    data class ScrapedContent(
        val fullText: String = "",
        val titles: List<String> = emptyList(),
        val snippets: List<String> = emptyList(),
        val url: String = "",
        val error: String? = null
    )
}

/**
 * Комбинированный провайдер: сначала OpenFoodFacts, затем headless браузер с ИИ
 */
class EanLookupWithHeadless(
    private val headlessProvider: EanHeadlessBrowser
) : EanProvider {
    
    override suspend fun lookup(ean: String): EanProduct? {
        return OpenFoodFactsEan.lookup(ean) ?: headlessProvider.lookup(ean)
    }
}
