package ru.vldkr.shkaff.domain.ean

import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage

// US-B1: LLM-фолбэк для штрихкодов, которых нет в OpenFoodFacts.
// Провайдер по настройкам: облако, локальная сеть или модель на устройстве.
class EanLlm(private val settings: () -> AgentSettings) : EanProvider {

    override suspend fun lookup(ean: String): EanProduct? {
        val s = settings()
        if (!s.enabled) return null
        val prompt = "По штрихкоду $ean верни JSON: {\"name\":\"...\",\"brand\":\"...\",\"categories\":\"...\",\"quantity\":\"...\"}. Пустые поля — пустые строки. Если сомневаешься — name=\"\"."
        val text = runCatching {
            Agent.complete(
                settings = s,
                messages = listOf(ChatMessage("user", prompt))
            )
        }.getOrNull() ?: return null

        val obj = ChatClient.extractJson(text) ?: return null
        val name = obj.optString("name", "").trim()
        if (name.isBlank()) return null
        val categories = obj.optString("categories", "").trim()
        val quantity = obj.optString("quantity", "").trim()
        return EanProduct(
            name = fixGarbled(name, ean),
            brand = obj.optString("brand", "").trim(),
            categories = categories,
            quantity = quantity,
            imageUrl = ""
        )
    }

    // Иногда облако возвращает "NNNNNNNN NNNN" вместо названия — восстанавливаем смысл:
    // одного этого кода в названии не должно быть.
    private fun fixGarbled(raw: String, ean: String): String {
        val r = raw
            .replace(ean, "")
            .replace(Regex("[\\d\\s]{6,}"), "")
            .trim()
        return r.ifBlank { raw.trim() }
    }
}
