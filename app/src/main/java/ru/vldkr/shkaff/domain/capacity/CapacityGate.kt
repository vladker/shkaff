package ru.vldkr.shkaff.domain.capacity

import java.util.Locale

// Честная проверка ёмкости перед записью вещи в ящик (T-006, П3.3). Чистый Kotlin.
// Раньше надпись «добавление блокировано» была ложью: репозитории ёмкость не проверяли.
// Теперь вердикт гейта соблюдается на уровне ItemRepository: BLOCK — бросает исключение,
// CONFIRM — бросает OverCapacityException, пока вызывающий не подтвердит (allowOverCapacity).

enum class GateVerdict { OK, CONFIRM, BLOCK }

// Превышение объёма/массы — не запрет, а предупреждение: сохраняется только после
// подтверждения пользователем (диалог формы / подтверждение перекладки по скану).
class OverCapacityException(message: String) : RuntimeException(message)

data class GateDecision(val verdict: GateVerdict, val message: String? = null)

object CapacityGate {

    // Вычесть вклад самой вещи из заполненности: при правке/перекладке вещь уже стоит
    // в целевом поддереве и учтена в usage — иначе она «съедает» место дважды.
    fun excludingItem(usage: CapacityUsage, volumeLiters: Double, weightKg: Double): CapacityUsage =
        usage.copy(
            volumeLiters = (usage.volumeLiters - volumeLiters).coerceAtLeast(0.0),
            weightKg = (usage.weightKg - weightKg).coerceAtLeast(0.0)
        )

    // usage должен уже включать вклад вещи, если она стоит внутри целевого поддерева
    // (для update/moveTo сначала прогнать через excludingItem).
    fun checkPlacement(usage: CapacityUsage, volumeLiters: Double, weightKg: Double): GateDecision {
        if (usage.isFull) {
            return GateDecision(
                GateVerdict.BLOCK,
                "Ящик помечен «полным» — добавление блокировано. Снимите отметку или выберите другой ящик."
            )
        }
        if (usage.canFit(volumeLiters, weightKg)) return GateDecision(GateVerdict.OK)

        val over = mutableListOf<String>()
        usage.effectiveVolumeLimit()?.let { lim ->
            if (usage.volumeLiters + volumeLiters > lim) {
                over += "объём: ${num(usage.volumeLiters)} + ${num(volumeLiters)} = ${num(usage.volumeLiters + volumeLiters)} л при ёмкости ${num(lim)} л"
            }
        }
        usage.effectiveWeightLimit()?.let { lim ->
            if (usage.weightKg + weightKg > lim) {
                over += "масса: ${num(usage.weightKg)} + ${num(weightKg)} = ${num(usage.weightKg + weightKg)} кг при грузоподъёмности ${num(lim)} кг"
            }
        }
        val reserve = if (usage.dontFillToBrim) " (лимит учтён с резервом «не набивать до упора»)" else ""
        return GateDecision(
            GateVerdict.CONFIRM,
            "Ёмкость будет превышена: ${over.joinToString("; ")}$reserve. Запись возможна после подтверждения."
        )
    }

    // Детерминированные числа для текста: целые без дробей, иначе одна цифра после запятой.
    private fun num(v: Double): String =
        if (v == Math.floor(v) && !v.isInfinite()) v.toLong().toString()
        else String.format(Locale.US, "%.1f", v).replace('.', ',')
}
