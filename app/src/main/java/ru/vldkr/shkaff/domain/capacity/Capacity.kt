package ru.vldkr.shkaff.domain.capacity

// Заполненность хранилища/ящика (US-C3/C4). Чистый Kotlin — расчёты без Android.
// Резерв «не до упора»: при dontFillToBrim используем только 90% заявленной ёмкости,
// чтобы оставался запас и вещи можно было найти, не вываливая соседние.
const val BRIM_RESERVE_RATIO = 0.9

data class CapacityUsage(
    val volumeLiters: Double,
    val weightKg: Double,
    val capacityVolumeLiters: Double? = null,
    val capacityWeightKg: Double? = null,
    val dontFillToBrim: Boolean = false,
    val isFull: Boolean = false
) {
    fun effectiveVolumeLimit(): Double? = capacityVolumeLiters?.let {
        if (it <= 0) null else if (dontFillToBrim) it * BRIM_RESERVE_RATIO else it
    }

    fun effectiveWeightLimit(): Double? = capacityWeightKg?.let {
        if (it <= 0) null else if (dontFillToBrim) it * BRIM_RESERVE_RATIO else it
    }

    // Доля использованного объёма 0..1 по эффективному лимиту (или null, если лимит не задан).
    fun volumeRatio(): Double? = effectiveVolumeLimit()?.let { if (it > 0) (volumeLiters / it).coerceIn(0.0, 2.0) else null }

    fun weightRatio(): Double? = effectiveWeightLimit()?.let { if (it > 0) (weightKg / it).coerceIn(0.0, 2.0) else null }

    fun remainingVolume(): Double? = effectiveVolumeLimit()?.let { (it - volumeLiters).coerceAtLeast(0.0) }

    fun remainingWeight(): Double? = effectiveWeightLimit()?.let { (it - weightKg).coerceAtLeast(0.0) }

    // Принудительно «полное» или вышло за эффективный лимит (с учётом резерва).
    fun overLimit(): Boolean = isFull || volumeRatio()?.let { it >= 1.0 } == true || weightRatio()?.let { it >= 1.0 } == true

    // Влезает ли объект v/w без превышения лимита.
    fun canFit(v: Double, w: Double): Boolean {
        if (isFull) return false
        effectiveVolumeLimit()?.let { if (volumeLiters + v > it) return false }
        effectiveWeightLimit()?.let { if (weightKg + w > it) return false }
        return true
    }
}