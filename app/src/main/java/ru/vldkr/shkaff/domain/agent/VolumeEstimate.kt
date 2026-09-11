package ru.vldkr.shkaff.domain.agent

import org.json.JSONArray
import ru.vldkr.shkaff.domain.capacity.CapacityUsage

// US-I1: агент оценивает примерный объём/массу вещей; в БД пишется только
// после подтверждения пользователем. Чистый Kotlin — парсер и fit-отчёт без Android.
data class VolumeProposal(
    val itemId: String,
    val name: String,
    val volumeLiters: Double,
    val weightKg: Double,
    val reason: String
)

// Строка вещи для промпта: достаточно имени, категории, размера и описания.
data class VolumeItemLine(
    val id: String,
    val name: String,
    val code: String,
    val category: String,
    val size: String,
    val description: String
)

object VolumeEstimate {

    // Оценки объёма не должны быть абсурдными: 0.001 л … 10 000 л (большой шкаф).
    const val MIN_VOLUME = 0.001
    const val MAX_VOLUME = 10_000.0
    const val MAX_WEIGHT = 100_000.0

    fun buildPrompt(lines: List<VolumeItemLine>): String {
        val sb = StringBuilder()
        sb.append("Оцени примерный объём (в литрах) и массу (в кг) каждой вещи по описанию.\n")
        sb.append(
            "Верни ТОЛЬКО JSON без пояснений: " +
            "{\"proposals\":[{\"id\":\"...\",\"volume_liters\":1.5,\"weight_kg\":0.8,\"reason\":\"короткое обоснование\"}]}\n"
        )
        sb.append("Объём — объём, который вещь займёт в ящике (с упаковкой). reason — 3-6 слов.\n\n")
        sb.append("Вещи:\n")
        lines.forEach { l ->
            sb.append("- id=").append(l.id).append(" · ").append(l.name)
            if (l.code.isNotBlank()) sb.append(" [").append(l.code).append("]")
            if (l.category.isNotBlank()) sb.append(", категория: ").append(l.category)
            if (l.size.isNotBlank()) sb.append(", размер: ").append(l.size)
            if (l.description.isNotBlank()) sb.append(" — ").append(l.description)
            sb.append("\n")
        }
        return sb.toString()
    }

    // Разбор ответа агента: допускаем заборы ```json, произвольный текст вокруг
    // и голый массив вместо объекта. Неизвестные id и объём <= 0 выбрасываются.
    fun parse(text: String, validIds: Map<String, String>): List<VolumeProposal> {
        val arr = proposalsArray(text) ?: return emptyList()
        val out = mutableListOf<VolumeProposal>()
        for (i in 0 until arr.length()) {
            val o = arr.optJSONObject(i) ?: continue
            val id = o.optString("id", "").trim()
            val name = validIds[id] ?: continue
            val v = o.optDouble("volume_liters", -1.0)
            if (v.isNaN() || v <= 0) continue
            val w = o.optDouble("weight_kg", 0.0)
            out += VolumeProposal(
                itemId = id,
                name = name,
                volumeLiters = v.coerceIn(MIN_VOLUME, MAX_VOLUME),
                weightKg = (if (w.isNaN()) 0.0 else w).coerceIn(0.0, MAX_WEIGHT),
                reason = o.optString("reason", "").trim()
            )
        }
        return out
    }

    private fun proposalsArray(text: String): JSONArray? {
        val root = ChatClient.extractJson(text)
        root?.optJSONArray("proposals")?.let { if (it.length() > 0) return it }
        // Модель иногда отвечает голым массивом [{…}, …].
        val open = text.indexOf('[')
        val close = text.lastIndexOf(']')
        if (open >= 0 && close > open) {
            runCatching { JSONArray(text.substring(open, close + 1)) }
                .getOrNull()?.let { if (it.length() > 0) return it }
        }
        return null
    }
}

// Fit-отчёт (US-I1 + US-C3): строка «свободно / переполнение» по ёмкости контейнера.
object FitReport {

    // «объём 2.3/5 л · свободно 2.7 л» или «объём 6.2/5 л — переполнено на 1.2 л».
    fun fitText(u: CapacityUsage): String {
        val vLimit = u.effectiveVolumeLimit()
        val wLimit = u.effectiveWeightLimit()
        if (vLimit == null && wLimit == null) return "ёмкость не задана"

        val parts = mutableListOf<String>()
        vLimit?.let { lim ->
            val free = lim - u.volumeLiters
            parts += if (free < -EPS)
                "объём ${fmt(u.volumeLiters)}/${fmt(lim)} л — переполнено на ${fmt(-free)} л"
            else
                "объём ${fmt(u.volumeLiters)}/${fmt(lim)} л · свободно ${fmt(free)} л"
        }
        wLimit?.let { lim ->
            val free = lim - u.weightKg
            parts += if (free < -EPS)
                "масса ${fmt(u.weightKg)}/${fmt(lim)} кг — перегруз ${fmt(-free)} кг"
            else
                "масса ${fmt(u.weightKg)}/${fmt(lim)} кг"
        }
        return parts.joinToString(" · ")
    }

    private const val EPS = 0.001

    private fun fmt(v: Double): String =
        if (v >= 100) v.toInt().toString() else ("%.1f".format(v))
}
