package ru.vldkr.shkaff.domain.ean

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentLoop
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage
import ru.vldkr.shkaff.domain.agent.WebTools
import ru.vldkr.shkaff.domain.agent.decodeEntities
import ru.vldkr.shkaff.domain.agent.htmlToText
import java.net.HttpURLConnection
import java.net.URL

// «Из ссылки»: пользователь вставляет ссылку на СТРАНИЦУ товара (маркетплейс, сайт продавца),
// а не на картинку. Открываем страницу, ИИ изучает описание на ней и — если данных
// не хватает — через web_search добирает сведения об этом же товаре.
// Результат: JSON с полями карточки (та же схема, что smartLookup) + картинка товара
// со страницы (её скачивают и ставят главным фото вещи).
class ProductPageBrowser(
    private val settings: () -> AgentSettings
) {

    class PageException(message: String) : Exception(message)

    data class PageResult(
        val json: JSONObject,
        val imageUrl: String? = null
    )

    suspend fun lookupFromPage(
        url: String,
        hintText: String = "",
        formContext: Map<String, String> = emptyMap(),
        onStep: (String) -> Unit = {},
    ): PageResult {
        val s = settings()
        if (!s.enabled) throw PageException("ИИ выключен — включите его в настройках агента")
        val pageUrl = normalizePageUrl(url)

        // Страницу пробуем открыть; маркетплейсы часто режут запрос (403/антибот) — тогда
        // не падаем, а ИИ добирает данные о товаре поиском (web_search) по названию/ссылке.
        onStep("Открываем страницу товара…")
        var html: String? = null
        runCatching {
            val h = fetchPage(pageUrl)
            if (h != null) {
                val t = htmlToText(h)
                if (t.length >= 40) html = h
            }
        }
        val pageText = html?.let { htmlToText(it) }
        val imageUrl = html?.let { extractProductImageUrl(it) }

        onStep(
            if (pageText != null) "ИИ изучает описание на странице…"
            else "Страница закрыта (антибот) — ИИ ищет данные о товаре…"
        )
        val prompt = buildPrompt(
            pageUrl = pageUrl,
            hintText = hintText,
            title = html?.let { extractPageTitle(it) }.orEmpty(),
            metaDescription = html?.let { extractMetaDescription(it) }.orEmpty(),
            text = pageText.orEmpty(),
            formContext = formContext,
        )
        // Инструменты — чтобы ИИ сам решил, добрать ли сведения об этом товаре поиском.
        val run = try {
            Agent.run(
                settings = s,
                messages = listOf(ChatMessage("user", prompt)),
                tools = WebTools.all(),
                onStep = { step -> onStep(step) },
            )
        } catch (e: Exception) {
            throw PageException("ИИ не ответил: ${e.message}")
        }

        onStep("Разбираем ответ…")
        val json = parseCardJson(s, run, onStep)
        return PageResult(json = json, imageUrl = imageUrl)
    }

    // «Распознать скриншот»: пользователь отдаёт скриншот описания товара (карточка магазина,
    // фото упаковки/таблицы характеристик). ИИ (vision) читает с него название/модель/бренд,
    // а через web_search по модели добирает атрибуты. Картинка-скриншот фото вещи не является.
    suspend fun lookupFromScreenshot(
        imagePath: String,
        formContext: Map<String, String> = emptyMap(),
        onStep: (String) -> Unit = {},
    ): PageResult {
        val s = settings()
        if (!s.enabled) throw PageException("ИИ выключен — включите его в настройках агента")
        if (!java.io.File(imagePath).isFile) throw PageException("Файл скриншота не найден")

        onStep("ИИ читает скриншот…")
        val prompt = buildScreenshotPrompt(formContext)
        // Картинка — на сообщении (messageToJson сериализует её как image_url);
        // инструменты — чтобы ИИ сам добрал сведения о товаре поиском по модели.
        val run = try {
            Agent.run(
                settings = s,
                messages = listOf(ChatMessage("user", prompt, imagePath = imagePath)),
                tools = WebTools.all(),
                onStep = { step -> onStep(step) },
            )
        } catch (e: Exception) {
            throw PageException("ИИ не ответил: ${e.message}")
        }

        onStep("Разбираем ответ…")
        val json = parseCardJson(s, run, onStep)
        return PageResult(json = json, imageUrl = null)
    }

    // Ответ модели может не содержать валидный JSON (объяснила словами, «задумалась»,
    // обрезала вывод). extractJson уже пробует все сбалансированные {...}-фрагменты;
    // если их нет — один повторный запрос по той же беседе «верни только JSON»
    // (Agent.complete работает и с device-провайдером, картинку подхватит из сообщения).
    private suspend fun parseCardJson(
        s: AgentSettings,
        run: AgentLoop.RunResult,
        onStep: (String) -> Unit,
    ): JSONObject {
        ChatClient.extractJson(run.answer)?.let { return it }
        onStep("ИИ не выдал JSON — прошу переслать только объект…")
        val retry = try {
            Agent.complete(
                settings = s,
                messages = run.conversation + ChatMessage(
                    "user",
                    "В твоём последнем ответе нет валидного JSON-объекта. " +
                        "Верни тот же результат заново — только JSON-объект с полями карточки, " +
                        "без пояснений и без кодовых заборов.",
                ),
            )
        } catch (e: Exception) {
            throw PageException("Ответ ИИ не распознан как JSON (${e.message})")
        }
        ChatClient.extractJson(retry)?.let { return it }
        val snippet = run.answer.take(160).replace(Regex("\\s+"), " ").trim()
        throw PageException("Ответ ИИ не распознан как JSON (фрагмент ответа: $snippet)")
    }

    // GET с заголовками браузера: маркетплейсы часто режут запросы с UA Android-приложения.
    private suspend fun fetchPage(url: String): String? = withContext(Dispatchers.IO) {
        val conn = URL(url).openConnection() as HttpURLConnection
        try {
            conn.requestMethod = "GET"
            conn.connectTimeout = 15_000
            conn.readTimeout = 30_000
            conn.instanceFollowRedirects = true
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")
            conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7")
            val code = conn.responseCode
            if (code !in 200..299) return@withContext null
            val charset = conn.contentType
                ?.substringAfter("charset=", "")
                ?.substringBefore(';')
                ?.trim()
                ?.takeIf { it.isNotBlank() }
                ?.let { runCatching { java.nio.charset.Charset.forName(it) }.getOrNull() }
                ?: Charsets.UTF_8
            conn.inputStream.bufferedReader(charset).readText()
        } catch (e: Exception) {
            null
        } finally {
            conn.disconnect()
        }
    }

    private fun buildPrompt(
        pageUrl: String,
        hintText: String,
        title: String,
        metaDescription: String,
        text: String,
        formContext: Map<String, String>,
    ): String {
        val context = if (formContext.isEmpty()) "" else
            "\n\nТекущее содержимое карточки (заполни пустые поля; если есть точные данные — уточни и непустые):\n" +
                formContext.entries.joinToString("\n") { (label, value) -> "- $label: $value" }
        val hint = if (hintText.isBlank()) "" else
            "\n\nПользователь ввёл о товаре (подсказка, можно использовать):\n${hintText.trim().take(2000)}\n"
        val schema = cardSchema()

        // Режим 1: страница открылась — ИИ изучает её текст.
        if (text.isNotBlank()) {
            val head = buildList {
                add("URL: $pageUrl")
                if (title.isNotBlank()) add("Заголовок страницы: $title")
                if (metaDescription.isNotBlank()) add("Описание со страницы: $metaDescription")
            }.joinToString("\n")
            return """
                Ты помощник, который заполняет карточку вещи в приложении инвентаризации.
                Ниже — содержимое страницы товара из интернета:
                $head
                $hint

                Текст страницы:
                ${text.take(15_000)}
                $context

                Изучи страницу и заполни поля карточки.
                Если на странице не хватает важных данных (описание, бренд, характеристики),
                используй инструмент web_search, чтобы найти дополнительные сведения об этом же товаре
                (по его названию/модели с этой страницы), и учти найденное.

                $schema
            """.trimIndent()
        }

        // Режим 2: страницу открыть не удалось (антибот/403) — ИИ находит данные о товаре поиском.
        return """
            Ты помощник, который заполняет карточку вещи в приложении инвентаризации.
            Страницу товара открыть не удалось (сайт блокирует автоматические запросы),
            поэтому используй инструмент web_search, чтобы найти сведения об этом товаре.

            Ссылка на товар:
            $pageUrl
            $hint
            $context

            По найденным в поиске данным заполни поля карточки.

            $schema
        """.trimIndent()
    }

    // Скриншот описания товара: ИИ читает его (vision), находит модель/название и
    // через web_search добирает атрибуты. Картинка-скриншот — не фото вещи.
    private fun buildScreenshotPrompt(formContext: Map<String, String>): String {
        val context = if (formContext.isEmpty()) "" else
            "\n\nТекущее содержимое карточки (заполни пустые поля; если есть точные данные — уточни и непустые):\n" +
                formContext.entries.joinToString("\n") { (label, value) -> "- $label: $value" }
        return """
            Ты помощник, который заполняет карточку вещи в приложении инвентаризации.
            Приложен скриншот описания товара (карточка магазина, фото упаковки, таблица характеристик).

            1. Прочитай скриншот: определи товар, его название, модель/артикул, бренд.
            2. Используй инструмент web_search, чтобы найти дополнительные сведения об этом товаре
               по модели/названию (характеристики, атрибуты, объём, вес и т.п.).
            3. Заполни поля карточки, опираясь на прочитанное со скриншота и найденное в поиске.
            $context

            ${cardSchema()}
        """.trimIndent()
    }

    // Общая JSON-схема карточки (используется и в промпте по странице, и по скриншоту).
    private fun cardSchema(): String = """
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
        - Не выдумывай: только данные из надёжных источников. Неизвестное — пустая строка.
        - В attributes — атрибуты карточки (по их названиям из текущего содержимого) и другие уместные: бренд, категория, серия, цвет.
    """.trimIndent()
}

// ---------- Чистые, тестируемые помощники ----------

// Ссылку ищем и в чистом виде, и внутри произвольного текста
// («вот товар — https://ozon.ru/p, смотрите»), как человек копирует из мессенджеров.
internal fun findUrlInText(text: String): String? {
    val t = text.trim()
    if (t.isEmpty()) return null
    val candidates = mutableListOf<String>()
    Regex("""https?://[^\s"'<>«»()\[\]{}]+""", RegexOption.IGNORE_CASE)
        .findAll(t)
        .forEach { candidates += it.value }
    if (candidates.isEmpty()) {
        // Голый адрес: www.ozon.ru/… или ozon.ru/… (TLD из двух и более букв).
        Regex("""(?:www\.[^\s"'<>«»()\[\]{}]+|(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z]{2,}(?:/[^\s"'<>«»()\[\]{}]*)?)""", RegexOption.IGNORE_CASE)
            .findAll(t)
            .forEach { candidates += it.value }
    }
    val raw = candidates.firstOrNull() ?: return null
    // Срезаем знаки, прилипшие к хвосту ссылки: «https://x.ru/p.» → «https://x.ru/p».
    val trimmed = raw.trimEnd('.', ',', ';', ':', '!', '?', ')', ']', '}', '"', '\'', '»')
    return normalizePageUrl(trimmed)
}

internal fun normalizePageUrl(raw: String): String {
    var u = raw.trim()
    if (u.startsWith("//")) u = "https:$u"
    if (!u.startsWith("http://") && !u.startsWith("https://")) u = "https://$u"
    return u
}

// <meta … property|name="X" … content="…"> — порядок атрибутов у сайтов разный.
internal fun metaTagValue(html: String, attr: String, value: String): String? {
    val tag = Regex("""<meta\b[^>]*\b$attr=["']${Regex.escape(value)}["'][^>]*>""", RegexOption.IGNORE_CASE)
        .find(html) ?: return null
    return Regex("""content=["']([^"']*)["']""", RegexOption.IGNORE_CASE)
        .find(tag.value)
        ?.groupValues?.get(1)
        ?.trim()
        ?.takeIf { it.isNotEmpty() }
}

internal fun extractPageTitle(html: String): String {
    metaTagValue(html, "property", "og:title")?.let { return decodeEntities(it).trim() }
    return Regex("""<title[^>]*>(.*?)</title>""", RegexOption.IGNORE_CASE)
        .find(html)
        ?.groupValues?.get(1)
        ?.let { decodeEntities(it).trim() }
        .orEmpty()
}

internal fun extractMetaDescription(html: String): String {
    return metaTagValue(html, "name", "description")
        ?.let { decodeEntities(it).trim() }
        .orEmpty()
}

// Картинка товара: og:image → twitter:image → JSON-LD "image" → первый <img src|data-src>.
internal fun extractProductImageUrl(html: String): String? {
    for (prop in listOf("og:image", "twitter:image", "twitter:image:src")) {
        metaTagValue(html, "property", prop)?.let { return absolutizeUrl(it) }
        metaTagValue(html, "name", prop)?.let { return absolutizeUrl(it) }
    }
    Regex(""""image"\s*:\s*(\[[^\]]*\]|"[^"]*"|\{[^{}]*\})""")
        .findAll(html)
        .forEach { m ->
            Regex("""https?://[^\s"',\]]+""").find(m.groupValues[1])?.value?.let { return it }
        }
    Regex("""<img\b[^>]*\b(?:src|data-src)=["']([^"']+)["']""", RegexOption.IGNORE_CASE)
        .findAll(html)
        .map { it.groupValues[1].trim() }
        .firstOrNull { it.startsWith("http://") || it.startsWith("https://") || it.startsWith("//") }
        ?.let { return absolutizeUrl(it) }
    return null
}

private fun absolutizeUrl(u: String): String =
    if (u.startsWith("//")) "https:$u" else u
