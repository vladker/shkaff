package ru.vldkr.shkaff.domain.vision

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage

// Заполнение карточки вещи ИИ по фото (vision) или по тексту (модель/EAN/название).
// Схема полей одна для обоих путей — дальше результат идёт в SmartSearchDialog без изменений.
object ItemVision {

    class VisionException(message: String) : Exception(message)

    // Единая точка «Заполнить с ИИ»: есть фото → vision, иначе текстовый запрос по модели/EAN.
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
            recognizeFromPhoto(settings, photo, attributeLabels, onStep)
        } else {
            recognizeByText(settings, model, ean, name, attributeLabels, onStep)
        }
    }

    suspend fun recognizeFromPhoto(
        settings: AgentSettings,
        photoPath: String,
        attributeLabels: List<String>,
        onStep: (String) -> Unit = {},
    ): JSONObject {
        checkEnabled(settings)
        val prompt = buildPhotoPrompt(attributeLabels)
        val text = runCompletion(settings, prompt, imagePath = photoPath, onStep = onStep)
        return parseJson(text)
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
        return parseJson(text)
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

    // Чистые промпты (без Android) — удобно тестировать.
    fun buildPhotoPrompt(attributeLabels: List<String>): String {
        val catalog = attributeLabels.filter { it.isNotBlank() }
        val catalogLine = if (catalog.isEmpty()) "" else
            "\nЗаполняй объект \"attributes\" ТОЛЬКО ключами из каталога: " + catalog.joinToString(", ") + "."
        val head = """
            You are an expert inventory and merchandising assistant. Analyze the photo of a new product and fill its card.

            WORK IN STEPS:
            1. Identify the core product and its category.
            2. OCR: read ALL visible text — name, brand, model/article/serial numbers, printed numbers, weight, volume, dates.
            3. Extract only the physical attributes that are clearly visible.
            4. Map the data strictly to the JSON schema below.

            STRICT RULES:
            - Never guess or invent. If a value is not clearly visible or readable, set it to null.
            - Preserve model numbers, serial numbers, article codes and the brand EXACTLY as printed.
            - Do not decode 1D barcodes visually; use only numbers printed as text.
            - "name" is required. If no name is printed, build it as: [Brand] [Category] [key visible feature].
            - Write "name" and "description" in Russian.
            - Return ONLY a valid JSON object: no markdown fences, no comments, no text outside the JSON.
        """.trimIndent()
        return head + "\n\nJSON SCHEMA:\n" + schemaJson(attributeLabels) + catalogLine
    }

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
}
