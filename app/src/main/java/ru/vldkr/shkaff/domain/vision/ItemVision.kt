package ru.vldkr.shkaff.domain.vision

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage
import ru.vldkr.shkaff.domain.ean.EanHeadlessBrowser

// Заполнение карточки вещи:
// - по фото: ИИ читает ТОЛЬКО видимый текст (название/бренд/модель/EAN) и по нему
//   ищем вещь в интернете (Яндекс → ИИ). Описания «в лоб» по фото нет — только из поиска.
// - без фото: текстовый запрос по модели/EAN/названию.
// Результат — JSON со схемой полей, дальше уходит в SmartSearchDialog без изменений.
object ItemVision {

    class VisionException(message: String) : Exception(message)

    // «null»/«none»/«—» — ИИ часто отвечает так вместо пустого значения; считаем отсутствием.
    fun clean(raw: String?): String {
        val v = raw?.trim() ?: ""
        if (v.isEmpty()) return ""
        return when (v.lowercase()) {
            "null", "none", "n/a", "na", "—", "-" -> ""
            else -> v
        }
    }

    // Единая точка «Заполнить с ИИ»: есть фото → фото + интернет, иначе текстовый запрос.
    suspend fun fill(
        settings: AgentSettings,
        photoPath: String?,
        model: String,
        ean: String?,
        name: String?,
        attributeLabels: List<String>,
        onStep: (String) -> Unit = {},
    ): JSONObject {
        val photo = photoPath?.trim()?.takeIf { it.isNotEmpty() }
        return if (photo != null) {
            fillFromPhoto(settings, photo, model, ean, name, onStep)
        } else {
            recognizeByText(settings, model, ean, name, attributeLabels, onStep)
        }
    }

    // Фото → 1) читаем видимый текст; если текста нет — 1б) описываем внешность предмета;
    // 2) по тексту/внешности ищем вещь в интернете;
    // 3) поля: интернет первичен, видимый текст — запасной (описание — только из интернета).
    suspend fun fillFromPhoto(
        settings: AgentSettings,
        photoPath: String,
        model: String,
        ean: String?,
        name: String?,
        onStep: (String) -> Unit = {},
    ): JSONObject {
        checkEnabled(settings)
        val facts = extractFromPhoto(settings, photoPath, onStep)
        var query = EanHeadlessBrowser.SearchQuery(
            ean = firstNonBlank(ean, facts.optString("ean")),
            name = firstNonBlank(name, facts.optString("name")),
            brand = facts.optString("brand").takeIf { clean(it).isNotEmpty() },
            partNumber = firstNonBlank(model, facts.optString("model")),
        )
        var appearance: String? = null
        if (query.toQueryString().isBlank()) {
            // На фото нечего читать (нет надписей): ищем по внешнему виду предмета.
            appearance = describeAppearance(settings, photoPath, onStep)
            query = EanHeadlessBrowser.SearchQuery(name = appearance)
        }
        val web: JSONObject? = try {
            EanHeadlessBrowser(settings = { settings }).smartLookup(query, emptyMap(), onStep)
        } catch (e: Exception) {
            null
        }
        if (web != null) return mergeWebWithFacts(web, facts)
        // Нет интернета (или поиск не открылся): берём только то, что реально написано на фото.
        val fallback = fallbackFromFacts(facts)
        if (fallback.has("name")) return fallback
        if (appearance != null) {
            throw VisionException("Не удалось найти вещь в интернете (по внешнему виду: $appearance). Проверьте сеть или введите название вручную.")
        }
        throw VisionException("Не удалось найти вещь в интернете. Проверьте сеть или введите название вручную.")
    }

    // Фото → только видимый текст (название/бренд/модель/EAN). Без описаний и догадок:
    // «что это за вещь» уточняется поиском в интернете, а не выдумкой модели.
    suspend fun extractFromPhoto(
        settings: AgentSettings,
        photoPath: String,
        onStep: (String) -> Unit = {},
    ): JSONObject {
        checkEnabled(settings)
        val text = runCompletion(settings, buildExtractionPrompt(), imagePath = photoPath, onStep = onStep)
        val json = ChatClient.extractJson(text) ?: throw VisionException("Ответ ИИ не распознан как JSON")
        val out = JSONObject()
        listOf("name", "brand", "model", "ean").forEach { k ->
            val v = clean(json.optString(k))
            if (v.isNotEmpty()) out.put(k, v)
        }
        return out
    }

    // Нет надписей на фото → описываем внешность предмета; это сырьё для поиска в интернете
    // (не подставляется в поля карточки — только как запрос).
    suspend fun describeAppearance(
        settings: AgentSettings,
        photoPath: String,
        onStep: (String) -> Unit = {},
    ): String {
        checkEnabled(settings)
        val text = runCompletion(settings, buildAppearancePrompt(), imagePath = photoPath, onStep = onStep)
        val cleaned = text.trim().trim('"').trim()
        if (cleaned.isEmpty()) throw VisionException("ИИ не описал предмет")
        return cleaned
    }

    fun buildAppearancePrompt(): String = """
        Посмотри на фото предмета и опиши его ВНЕШНИЙ ВИД на русском, 1–3 предложения:
        тип вещи, форма, цвет, материал, ориентировочный размер, характерные детали (ручки, крышка, кнопки, вырезы, знаки).
        Не угадывай бренд, модель или название — опиши только то, что реально видно на фото.
        Верни только текст описания, без кавычек и пояснений.
    """.trimIndent()

    // Кнопка «ИИ» в поле «Описание»: короткое описание по фото (заменяет текст описания).
    suspend fun describeFromPhoto(
        settings: AgentSettings,
        photoPath: String,
        onStep: (String) -> Unit = {},
    ): String {
        checkEnabled(settings)
        val prompt = """
            Посмотри фото вещи и напиши КРОТКОЕ фактическое описание на русском (1–3 предложения):
            что это за вещь, бренд и ключевые видимые признаки (габариты, цвет, упаковка) — если видны.
            Не выдумывай фактов, которых нет на фото. Верни только текст описания, без кавычек и пояснений.
        """.trimIndent()
        val text = runCompletion(settings, prompt, imagePath = photoPath, onStep = onStep)
        val cleaned = text.trim().trim('"').trim()
        if (cleaned.isEmpty()) throw VisionException("ИИ не ответил")
        return cleaned
    }

    // Текстовый путь: работает офлайн (device) и онлайн (cloud/local) — без веб-скрапинга.
    suspend fun recognizeByText(
        settings: AgentSettings,
        model: String,
        ean: String?,
        name: String?,
        attributeLabels: List<String>,
        onStep: (String) -> Unit = {},
    ): JSONObject {
        checkEnabled(settings)
        val prompt = buildTextPrompt(model, ean, name, attributeLabels)
        val text = runCompletion(settings, prompt, imagePath = null, onStep = onStep)
        return normalizeCard(parseJson(text))
    }

    private fun checkEnabled(settings: AgentSettings) {
        if (!settings.enabled) throw VisionException("ИИ выключен — включите его в настройках агента")
    }

    private suspend fun runCompletion(
        settings: AgentSettings,
        prompt: String,
        imagePath: String?,
        onStep: (String) -> Unit,
    ): String {
        val buffer = StringBuilder()
        onStep("Отправляем в ИИ…")
        val text = try {
            withContext(Dispatchers.IO) {
                Agent.complete(
                    settings = settings,
                    messages = listOf(ChatMessage("user", prompt, imagePath = imagePath)),
                    onToken = { t ->
                        buffer.append(t)
                        onStep("ИИ заполняет… ${buffer.length} зн.")
                    },
                    // Reasoning-модели тратят токены на «размышление» (reasoning_content)
                    // до ответа: 1024 часто не хватает → пустой content. Даём запас.
                    nMaxTokens = 4096,
                )
            }
        } catch (e: Exception) {
            throw VisionException("ИИ не ответил: ${e.message}")
        }
        onStep("Разбираем ответ…")
        return text
    }

    private fun parseJson(text: String): JSONObject =
        ChatClient.extractJson(text) ?: throw VisionException("Ответ ИИ не распознан как JSON")

    // Промпт «только видимый текст»: без описаний и догадок — это сырьё для поиска.
    fun buildExtractionPrompt(): String = """
        You are an OCR assistant for an inventory app. Look at the photo of a product.

        Read ONLY text that is actually visible and readable on the product or its label/package:
        - name: the product name printed on the label; if none is printed, the most visible product designation
        - brand: the brand printed on the label
        - model: model / article / serial number printed on the label
        - ean: a barcode/EAN number printed as text (do NOT try to read the barcode itself)

        STRICT RULES:
        - Never guess or invent anything that is not printed on the photo.
        - If a value is not visible, set it to null.
        - Preserve model numbers, serial numbers and the brand EXACTLY as printed.
        - Return ONLY a valid JSON object: no markdown fences, no comments, no text outside the JSON.

        JSON SCHEMA:
        {
          "name": "string or null",
          "brand": "string or null",
          "model": "string or null",
          "ean": "string or null"
        }
    """.trimIndent()

    fun buildTextPrompt(model: String, ean: String?, name: String?, attributeLabels: List<String>): String {
        val catalog = attributeLabels.filter { it.isNotBlank() }
        val catalogLine = if (catalog.isEmpty()) "" else
            "\nЗаполняй объект \"attributes\" ТОЛЬКО ключами из каталога: " + catalog.joinToString(", ") + "."
        val facts = buildList {
            model.trim().takeIf { it.isNotEmpty() }?.let { add("Код/модель/сериальный номер: $it") }
            ean?.trim()?.takeIf { it.isNotEmpty() }?.let { add("Штрихкод (EAN): $it") }
            name?.trim()?.takeIf { it.isNotEmpty() }?.let { add("Название (черновик): $it") }
        }
        val factBlock = if (facts.isEmpty()) "" else
            "\n\nИзвестные данные о вещи:\n" + facts.joinToString("\n") + "."
        val head = """
            You are an expert inventory and merchandising assistant. Fill the product card from the known data below (there is no photo).

            STRICT RULES:
            - Never guess or invent beyond the given data. If a value cannot be derived from the data, set it to null.
            - Preserve model numbers, serial numbers, article codes and the brand EXACTLY as given.
            - "name" is required. If no name is given, build it from the known data.
            - Write "name" and "description" in Russian.
            - Return ONLY a valid JSON object: no markdown fences, no comments, no text outside the JSON.
        """.trimIndent()
        return head + factBlock + "\n\nJSON SCHEMA:\n" + schemaJson(attributeLabels) + catalogLine
    }

    // JSON-схема под ключи карточки: фиксированные поля + attributes{...}.
    // Атрибуты = базовые ключи + каталог пользователя (без дублей); неизвестное — null.
    private fun schemaJson(attributeLabels: List<String>): String {
        val base = listOf("Категория", "Бренд", "Цвет", "Материал")
        val keys = (base + attributeLabels.filter { it.isNotBlank() }).distinctBy { it.trim().lowercase() }
        val attrs = keys.joinToString(", ") { "\"${it.trim()}\": \"string or null\"" }
        return """
        {
          "name": "string, required — product name (Russian)",
          "code": "string or null — model/article/serial number",
          "ean": "string or null — barcode/EAN number printed as text",
          "description": "string or null — short factual description (Russian)",
          "expiryDate": "string or null — expiry date, format DD.MM.YYYY",
          "volumeLiters": "number or null — volume in liters",
          "weightKg": "number or null — weight in kilograms",
          "tags": "string or null — comma-separated free tags",
          "attributes": { $attrs }
        }
        """.trimIndent()
    }

    // Интернет первичен; видимый текст добирает только name/code/ean/бренд.
    // Описание — только из интернета, никогда «придуманное» по фото.
    fun mergeWebWithFacts(web: JSONObject, facts: JSONObject): JSONObject {
        val attrs = JSONObject()
        web.optJSONObject("attributes")?.let { wa ->
            wa.keys().forEach { k ->
                val v = clean(wa.optString(k))
                if (v.isNotEmpty()) attrs.put(k, v)
            }
        }
        val brand = clean(facts.optString("brand"))
        if (brand.isNotEmpty() && clean(attrs.optString("Бренд")).isEmpty()) attrs.put("Бренд", brand)
        val out = JSONObject()
        out.put("name", clean(web.optString("name")).ifBlank { clean(facts.optString("name")) })
        out.put("code", clean(web.optString("code")).ifBlank { clean(facts.optString("model")) })
        out.put("ean", clean(web.optString("ean")).ifBlank { clean(facts.optString("ean")) })
        out.put("description", clean(web.optString("description")))
        out.put("expiryDate", clean(web.optString("expiryDate")))
        out.put("volumeLiters", clean(web.optString("volumeLiters")))
        out.put("weightKg", clean(web.optString("weightKg")))
        out.put("tags", clean(web.optString("tags")))
        if (attrs.length() > 0) out.put("attributes", attrs)
        return out
    }

    // Запасной результат без интернета: только то, что реально написано на фото.
    fun fallbackFromFacts(facts: JSONObject): JSONObject {
        val out = JSONObject()
        val name = clean(facts.optString("name"))
        if (name.isNotEmpty()) out.put("name", name)
        val code = clean(facts.optString("model"))
        if (code.isNotEmpty()) out.put("code", code)
        val ean = clean(facts.optString("ean"))
        if (ean.isNotEmpty()) out.put("ean", ean)
        val brand = clean(facts.optString("brand"))
        if (brand.isNotEmpty()) out.put("attributes", JSONObject().put("Бренд", brand))
        return out
    }

    // Пустой JSON, если ни интернет, ни фото ничего не дали — дальше ошибка с понятным текстом.
    private fun firstNonBlank(a: String?, b: String?): String? {
        val va = clean(a)
        if (va.isNotEmpty()) return va
        val vb = clean(b)
        if (vb.isNotEmpty()) return vb
        return null
    }

    // Убираем из ответа «пустые» значения ИИ, чтобы они не попали в форму.
    private fun normalizeCard(json: JSONObject): JSONObject {
        val out = JSONObject()
        json.keys().forEach { k ->
            when (val v = json.opt(k)) {
                is String -> {
                    val c = clean(v)
                    if (c.isNotEmpty()) out.put(k, c)
                }
                is JSONObject -> {
                    val c = JSONObject()
                    v.keys().forEach { kk ->
                        val cc = clean(v.optString(kk))
                        if (cc.isNotEmpty()) c.put(kk, cc)
                    }
                    if (c.length() > 0) out.put(k, c)
                }
                else -> out.put(k, v)
            }
        }
        return out
    }
}
