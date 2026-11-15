package ru.vldkr.shkaff.domain.recommend

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage

// ИИ-рекомендация места хранения вещи. Возвращает топ с причинами; при ошибке/выключенном
// ИИ — правило-фолбэк (аналог Recommend.rank) на тех же кандидатах.
object RecommendLlm {

    class RecommendException(message: String) : Exception(message)

    data class CandidateInfo(
        val id: String,
        val name: String,
        val freeLiters: Double?,
        val freeKg: Double?,
        val dontFillToBrim: Boolean,
        val isFull: Boolean,
        val itemCount: Int,
        val presentCategories: List<String>,
        val climate: Map<String, String>,
    )

    data class Recommendation(
        val id: String,
        val name: String,
        val reason: String,
        val score: Double,
    )

    // T-026 (US-C6): источник подсказки должен быть виден в UI — список по правилам
    // неотличим от ИИ, а провал ИИ молча проглатывался.
    enum class Source { AI, RULES }

    data class Outcome(
        val recommendations: List<Recommendation>,
        val source: Source,
        // Почему ИИ не смог (текст для подписи в UI); null — когда список дал ИИ.
        val aiError: String? = null,
    )

    // Transport подменяется лямбдой — тесты чистой логики без сети и llama.
    suspend fun recommendOutcome(
        settings: AgentSettings,
        itemName: String,
        itemCategory: String?,
        volumeLiters: Double?,
        weightKg: Double?,
        candidates: List<CandidateInfo>,
        top: Int = 5,
        complete: suspend (String) -> String = { prompt ->
            withContext(Dispatchers.IO) {
                Agent.complete(
                    settings = settings,
                    messages = listOf(ChatMessage("user", prompt)),
                    nMaxTokens = 512,
                )
            }
        },
    ): Outcome {
        if (candidates.isEmpty()) return Outcome(emptyList(), Source.RULES, null)
        if (settings.enabled) {
            try {
                val prompt = buildPrompt(itemName, itemCategory, volumeLiters, weightKg, candidates, top)
                val parsed = parse(complete(prompt), candidates, top)
                if (!parsed.isNullOrEmpty()) return Outcome(parsed, Source.AI, null)
                return Outcome(ruleBased(itemCategory, volumeLiters, weightKg, candidates, top), Source.RULES, "ответ не разобрался")
            } catch (e: Exception) {
                return Outcome(ruleBased(itemCategory, volumeLiters, weightKg, candidates, top), Source.RULES, e.message ?: "ошибка ИИ-запроса")
            }
        }
        return Outcome(ruleBased(itemCategory, volumeLiters, weightKg, candidates, top), Source.RULES, "ИИ выключен в настройках")
    }

    suspend fun recommend(
        settings: AgentSettings,
        itemName: String,
        itemCategory: String?,
        volumeLiters: Double?,
        weightKg: Double?,
        candidates: List<CandidateInfo>,
        top: Int = 5,
    ): List<Recommendation> =
        recommendOutcome(
            settings = settings,
            itemName = itemName,
            itemCategory = itemCategory,
            volumeLiters = volumeLiters,
            weightKg = weightKg,
            candidates = candidates,
            top = top,
        ).recommendations

    // Чистый промпт — удобно тестировать.
    fun buildPrompt(
        itemName: String,
        itemCategory: String?,
        volumeLiters: Double?,
        weightKg: Double?,
        candidates: List<CandidateInfo>,
        top: Int,
    ): String {
        val item = buildList {
            if (itemName.isNotBlank()) add("название: $itemName")
            itemCategory?.takeIf { it.isNotBlank() }?.let { add("категория: $it") }
            volumeLiters?.let { add("объём: ${it.round2()} л") }
            weightKg?.let { add("вес: ${it.round2()} кг") }
        }.joinToString("; ").ifBlank { "без уточнений" }

        val list = candidates.joinToString("\n") { c ->
            val free = buildList {
                c.freeLiters?.let { add("свободно ${it.round2()} л") }
                c.freeKg?.let { add("свободно ${it.round2()} кг") }
                if (c.isFull) add("ПОЛНОЕ")
                if (c.dontFillToBrim) add("не до упора")
            }.joinToString(", ")
            val cats = c.presentCategories.take(6).joinToString(", ").ifBlank { "пусто" }
            val clim = c.climate.entries.joinToString(", ") { "${it.key}=${it.value}" }
            "- id=\"${c.id}\" name=\"${c.name}\" | ${free.ifBlank { "лимит не задан" }} | вещей: ${c.itemCount} | категории: $cats" +
                (if (clim.isNotEmpty()) " | климат: $clim" else "")
        }
        return """
            Ты помощник инвентаризации. Выбери подходящие места хранения для вещи и объясни почему.
            Вещь: $item.
            Кандидаты:
            $list
            Верни ТОЛЬКО JSON: {"top": [{"id": "...", "reason": "короткая причина"}]} — по убыванию suitability, максимум $top.
        """.trimIndent()
    }

    // Разбор ответа ИИ: сохраняем только известные id, в порядке, который дал ИИ.
    fun parse(text: String, candidates: List<CandidateInfo>, top: Int): List<Recommendation>? {
        val obj: JSONObject = ChatClient.extractJson(text) ?: return null
        val arr = obj.optJSONArray("top") ?: return null
        val byId = candidates.associateBy { it.id }
        val out = ArrayList<Recommendation>()
        for (i in 0 until arr.length()) {
            val e = arr.optJSONObject(i) ?: continue
            val c = byId[e.optString("id")] ?: continue
            out += Recommendation(
                id = c.id,
                name = c.name,
                reason = e.optString("reason").ifBlank { "похож по свойствам" },
                score = (top - out.size).toDouble(),
            )
            if (out.size >= top) break
        }
        return out
    }

    // Правило-фолбэк: влезает по объёму/весу + похожие категории + «не до упора».
    fun ruleBased(
        category: String?,
        volumeLiters: Double?,
        weightKg: Double?,
        candidates: List<CandidateInfo>,
        top: Int = 5,
    ): List<Recommendation> {
        if (candidates.isEmpty()) return emptyList()
        val cat = category?.trim()?.takeIf { it.isNotEmpty() }
        val v = volumeLiters ?: 0.0
        val w = weightKg ?: 0.0
        val scored = candidates.map { c ->
            val fitsVolume = c.freeLiters?.let { it >= v } ?: true
            val fitsWeight = c.freeKg?.let { it >= w } ?: true
            val fits = fitsVolume && fitsWeight && !c.isFull
            val catMatch = cat != null && c.presentCategories.any { it.equals(cat, ignoreCase = true) }
            val score = (if (fits) 1000.0 else 0.0) + (if (catMatch) 100.0 else 0.0) + (if (!c.dontFillToBrim) 15.0 else 0.0)
            val reason = when {
                fits && catMatch -> "влезает, хранят похожее"
                fits -> "влезает по объёму/весу"
                else -> "лимит не хватает, но ближайший"
            }
            Quadruple(c, score, fits, catMatch, reason)
        }
        val sorted = if (cat == null) {
            // без категории — просто свободные сначала
            scored.sortedWith(compareByDescending<Quadruple> { it.fits }.thenBy { it.c.name.lowercase() })
        } else {
            scored.sortedWith(compareByDescending<Quadruple> { it.score }.thenBy { it.c.name.lowercase() })
        }
        return sorted.take(top).map { Recommendation(it.c.id, it.c.name, it.reason, it.score) }
    }

    private data class Quadruple(
        val c: CandidateInfo,
        val score: Double,
        val fits: Boolean,
        val catMatch: Boolean,
        val reason: String,
    )

    private fun Double.round2(): Double = Math.round(this * 100.0) / 100.0
}
