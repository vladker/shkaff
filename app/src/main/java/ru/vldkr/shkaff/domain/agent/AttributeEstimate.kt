package ru.vldkr.shkaff.domain.agent

import org.json.JSONArray

// US-I2: агент находит недостающие важные атрибуты вещи (категория, размер, материал, цвет …);
// в БД пишется только после подтверждения пользователем. Чистый Kotlin — парсер без Android.
data class AttributeProposal(
    val itemId: String,
    val name: String,
    val attrs: Map<String, String>,
    val reason: String
)

data class AttributeItemLine(
    val id: String,
    val name: String,
    val code: String,
    val description: String
)

object AttributeEstimate {

    fun buildPrompt(lines: List<AttributeItemLine>): String {
        val sb = StringBuilder()
        sb.append("Найди важные атрибуты для каждой вещи по названию и описанию.\n")
        sb.append(
            "Верни ТОЛЬКО JSON без пояснений: " +
            "{\"proposals\":[{\"id\":\"...\",\"attrs\":{\"category\":\"...\",\"size\":\"...\"},\"reason\":\"короткое обоснование\"}]}\n"
        )
        sb.append("Заполняй только то, что реально можно вывести из описания; не выдумывай.\n")
        sb.append("reason — 3-6 слов. Если атрибутов нет — оставь attrs пустым.\n\n")
        sb.append("Вещи:\n")
        lines.forEach { l ->
            sb.append("- id=").append(l.id).append(" · ").append(l.name)
            if (l.code.isNotBlank()) sb.append(" [").append(l.code).append("]")
            if (l.description.isNotBlank()) sb.append(" — ").append(l.description)
            sb.append("\n")
        }
        return sb.toString()
    }

    // Разбор ответа: допускаем заборы ```json и произвольный текст вокруг, голый массив.
    // Неизвестные id и пустой attrs выбрасываются.
    fun parse(text: String, validIds: Map<String, String>): List<AttributeProposal> {
        val arr = proposalsArray(text) ?: return emptyList()
        val out = mutableListOf<AttributeProposal>()
        for (i in 0 until arr.length()) {
            val o = arr.optJSONObject(i) ?: continue
            val id = o.optString("id", "").trim()
            val name = validIds[id] ?: continue
            val attrsObj = o.optJSONObject("attrs")
            val attrs = LinkedHashMap<String, String>()
            if (attrsObj != null) {
                val it = attrsObj.keys()
                while (it.hasNext()) {
                    val k = it.next()
                    val v = attrsObj.optString(k, "").trim()
                    if (k.isNotBlank() && v.isNotBlank()) attrs[k] = v
                }
            }
            if (attrs.isEmpty()) continue
            out += AttributeProposal(
                itemId = id,
                name = name,
                attrs = attrs,
                reason = o.optString("reason", "").trim()
            )
        }
        return out
    }

    private fun proposalsArray(text: String): JSONArray? {
        val root = ChatClient.extractJson(text)
        root?.optJSONArray("proposals")?.let { if (it.length() > 0) return it }
        val open = text.indexOf('[')
        val close = text.lastIndexOf(']')
        if (open >= 0 && close > open) {
            runCatching { JSONArray(text.substring(open, close + 1)) }
                .getOrNull()?.let { if (it.length() > 0) return it }
        }
        return null
    }
}
