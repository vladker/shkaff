package ru.vldkr.shkaff.domain.ean

import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage

// US-B1: LLM-фолбэк для неизвестных OpenFoodFacts штрихкодов. Просим модель
// вернуть JSON-карточку товара; используем только разобранные поля.
class EanLlm(private val settings: () -> AgentSettings) : EanProvider {

    override suspend fun lookup(ean: String): EanProduct? {
        val s = settings()
        if (!s.enabled) return null
        val prompt = buildString {
            append("Ты — справочник по штрихкодам EAN/UPC. По коду ").append(ean)
            append(" приведи товар, если уверен. Ответь строго одним JSON без пояснений в виде: ")
            append("{\"name\": \"...\", \"brand\": \"...\", \"quantity\": \"...\", \"categories\": \"...\"}. ")
            append("Пустые поля — как пустые строки. Если не знаешь — верни {\"name\": \"\"}")
        }
        val text = runCatching {
            ChatClient.complete(s, listOf(ChatMessage("user", prompt)))
        }.getOrNull() ?: return null
        val obj = ChatClient.extractJson(text) ?: return null
        val name = obj.optString("name", "").trim()
        if (name.isBlank()) return null
        return EanProduct(
            name = name,
            brand = obj.optString("brand", "").trim(),
            quantity = obj.optString("quantity", "").trim(),
            categories = obj.optString("categories", "").trim()
        )
    }
}