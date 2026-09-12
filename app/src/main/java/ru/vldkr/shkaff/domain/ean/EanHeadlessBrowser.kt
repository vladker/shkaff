package ru.vldkr.shkaff.domain.ean

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
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
    suspend fun lookupByQuery(query: SearchQuery): EanProduct? {
        val queryString = query.toQueryString()
        if (queryString.isBlank()) return null

        val s = settings()
        if (!s.enabled) return null

        return withContext(Dispatchers.IO) {
            try {
                // Шаг 1: Парсим страницу поиска через headless браузер (эмуляция)
                val scrapedContent = scrapeSearchResults(queryString)
                
                // Шаг 2: Отправляем собранные данные в Алиса AI для структурирования
                val productData = extractProductInfoWithAI(scrapedContent, queryString, s)
                
                productData
            } catch (e: Exception) {
                null
            }
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
     * Извлечение структурированной информации о продукте с помощью ИИ
     */
    private suspend fun extractProductInfoWithAI(
        scraped: ScrapedContent,
        originalQuery: String,
        settings: AgentSettings
    ): EanProduct? {
        
        val prompt = buildPrompt(scraped, originalQuery)
        
        val responseText = runCatching {
            Agent.complete(
                settings = settings,
                messages = listOf(ChatMessage("user", prompt))
            )
        }.getOrNull() ?: return null

        val jsonObj = ru.vldkr.shkaff.domain.agent.ChatClient.extractJson(responseText) ?: return null
        
        val name = jsonObj.optString("name", "").trim()
        if (name.isBlank()) return null
        
        return EanProduct(
            name = name,
            brand = jsonObj.optString("brand", "").trim(),
            categories = jsonObj.optString("categories", "").trim(),
            quantity = jsonObj.optString("quantity", "").trim(),
            imageUrl = jsonObj.optString("imageUrl", "").trim(),
            extra = buildExtraFromAI(jsonObj)
        )
    }

    /**
     * Построение промпта для ИИ с инструкцией вернуть структурированный JSON
     */
    private fun buildPrompt(scraped: ScrapedContent, query: String): String {
        return """
Ты помощник для заполнения карточки товара. Проанализируй результаты поиска по запросу "$query" и извлеки структурированную информацию.

Результаты поиска:
${scraped.titles.take(5).joinToString("\n")}

Фрагменты:
${scraped.snippets.take(5).joinToString("\n")}

Верни ТОЛЬКО JSON в формате:
{
  "name": "Название товара",
  "brand": "Бренд",
  "categories": "Категория1 / Категория2",
  "quantity": "Количество/вес/объём",
  "imageUrl": "URL изображения (если есть)",
  "description": "Краткое описание",
  "manufacturer": "Производитель"
}

Если какое-то поле неизвестно — оставь пустую строку.
Название (name) обязательно должно быть заполнено.
Не добавляй никаких пояснений, только JSON.
""".trimIndent()
    }

    private fun buildExtraFromAI(json: JSONObject): Map<String, String> {
        val extra = mutableMapOf<String, String>()
        json.optString("description", "").takeIf { it.isNotBlank() }?.let { 
            extra["Описание"] = it 
        }
        json.optString("manufacturer", "").takeIf { it.isNotBlank() }?.let { 
            extra["Производитель"] = it 
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
