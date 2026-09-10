package ru.vldkr.shkaff.domain.recommend

import ru.vldkr.shkaff.domain.capacity.CapacityUsage

// Рекомендация хранилища для нового объекта (US-C6). Чистый Kotlin — ранжирование без Android.
// Кандидат — пара «контейнер (storage|location) + его заполненность + категории уже лежащих вещей».
data class RecommendCandidate(
    val id: String,
    val name: String,
    val usage: CapacityUsage,
    val itemCount: Int,
    val presentCategories: Set<String>,
    val pathPrefix: String = ""
)

data class StorageSuggestion(
    val id: String,
    val name: String,
    val score: Double,
    val pros: List<String>,
    val cons: List<String>
)

object Recommend {

    private const val CATEGORY_BONUS = 3.0
    private const val FREE_SPACE_WEIGHT = 2.0
    private const val NOT_EMPTY_BONUS = 1.5
    private const val FULL_PENALTY = -10.0

    // Ранжирует кандидатов по близости к категории и свободному месту.
    // v/w — габариты добавляемого объекта (усреднённые, если неизвестны — 0).
    fun rank(
        candidates: List<RecommendCandidate>,
        category: String?,
        volume: Double,
        weight: Double,
        top: Int = 3
    ): List<StorageSuggestion> {
        return candidates
            .map { c -> suggest(c, category, volume, weight) }
            .sortedByDescending { it.score }
            .take(top)
    }

    private fun suggest(c: RecommendCandidate, category: String?, volume: Double, weight: Double): StorageSuggestion {
        val u = c.usage
        val pros = mutableListOf<String>()
        val cons = mutableListOf<String>()

        var score = 0.0

        // Фит: «полное» или переполнение исключает кандидата.
        if (u.isFull) {
            pros += "помечено «полное»"
            score += FULL_PENALTY
        } else if (!u.canFit(if (volume <= 0) 0.01 else volume, if (weight <= 0) 0.01 else weight)) {
            pros += "не влезет: лимит будет превышен"
            score += FULL_PENALTY
        } else {
            // Свободное место по тому лимиту, что задан.
            val freeV = u.remainingVolume()
            val freeW = u.remainingWeight()
            val freeText = when {
                freeV != null && freeW != null ->
                    "свободно ≈ ${fmt(freeV)} л и ${fmt(freeW)} кг"
                freeV != null -> "свободно ≈ ${fmt(freeV)} л"
                freeW != null -> "свободно ≈ ${fmt(freeW)} кг"
                else -> "вместимость не задана"
            }
            pros += freeText
            // Доля свободного места (0..1) — нормализуем по шкале, чтобы вес был сопоставим.
            val freeRatio = when {
                u.capacityVolumeLiters != null && u.capacityVolumeLiters > 0 ->
                    (freeV ?: 0.0) / u.capacityVolumeLiters
                u.capacityWeightKg != null && u.capacityWeightKg > 0 ->
                    (freeW ?: 0.0) / u.capacityWeightKg
                else -> 1.0
            }
            score += FREE_SPACE_WEIGHT * freeRatio.coerceIn(0.0, 1.0)
        }

        // Одна категория с уже лежащими объектами — большой плюс.
        val cat = category?.trim()?.takeIf { it.isNotEmpty() }
        if (cat != null && cat in c.presentCategories) {
            pros += "там уже есть «$cat»"
            score += CATEGORY_BONUS
        } else if (cat != null && c.presentCategories.isNotEmpty()) {
            cons += "категория «$cat» там пока не встречалась"
        }

        // Не пустой — значит понятно, где искать (а не пустая коробка в углу).
        if (c.itemCount > 0) {
            score += NOT_EMPTY_BONUS * 0.5
        }

        val overflow = u.volumeRatio()?.let { it >= 1.0 } == true || u.weightRatio()?.let { it >= 1.0 } == true
        if (overflow && !u.isFull) cons += "уже переполнено на бумаге"

        if (u.capacityVolumeLiters == null && u.capacityWeightKg == null) {
            cons += "нет данных о вместимости — без гарантии"
        }

        val display = if (c.pathPrefix.isBlank()) c.name else "${c.pathPrefix} — ${c.name}"
        return StorageSuggestion(c.id, display, score, pros, cons)
    }

    private fun fmt(v: Double): String = if (v >= 100) v.toInt().toString() else "%.1f".format(v)
}