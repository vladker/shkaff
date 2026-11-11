package ru.vldkr.shkaff.domain.llm

/**
 * Проверка свободного места перед скачиванием GGUF (T-052): модели весят до
 * 10 ГБ и раньше писались на диск вслепую — посреди загрузки FileOutputStream
 * бросал английское «No space left on device». Пороги и русские тексты —
 * чистые функции без Android, чтобы тестировались на JVM.
 */
object StorageFit {

    private const val MIB = 1024L * 1024L
    private const val GIB = 1024L * MIB

    /** После загрузки на разделе должен остаться запас — система не терпит нули. */
    const val MIN_RESERVE = 128 * MIB
    const val MAX_RESERVE = 1 * GIB

    /** Сколько реально допишется на диск с учётом уже качнутых «*.part». */
    fun requiredBytes(mainSize: Long, mainDone: Long, mmprojSize: Long?, mmprojDone: Long): Long {
        val main = (mainSize - mainDone).coerceAtLeast(0L)
        val mm = ((mmprojSize ?: 0L) - mmprojDone).coerceAtLeast(0L)
        return main + mm
    }

    /** Запас растёт с размером модели: десятая часть от нужного, в рамках 128 МиБ..1 ГиБ. */
    fun reserve(required: Long): Long = (required / 10).coerceIn(MIN_RESERVE, MAX_RESERVE)

    /** required <= 0 — размер неизвестен (своя модель по ссылке) или всё уже скачано. */
    fun fits(required: Long, usable: Long): Boolean =
        required <= 0L || usable >= required + reserve(required)

    fun notEnoughSpaceText(required: Long, usable: Long): String =
        "Недостаточно свободного места: нужно ~${fmt(required + reserve(required))}, " +
            "свободно ~${fmt(usable)}. Освободите память или выберите модель меньшего размера."

    /** Android-формулировка ENOSPC: «write failed: ENOSPC (No space left on device)». */
    fun isOutOfSpace(t: Throwable): Boolean = generateSequence(t) { it.cause }.any { e ->
        val m = e.message ?: ""
        m.contains("ENOSPC", ignoreCase = true) || m.contains("No space left", ignoreCase = true)
    }

    /** Человеческий текст вместо стека ОС; ENOSPC в середине докачки — по-русски и с обещанием продолжить. */
    fun errorText(t: Throwable, fallback: String = "Ошибка загрузки"): String = when {
        isOutOfSpace(t) ->
            "На устройстве закончилось свободное место. Освободите память и нажмите «Скачать» — " +
                "загрузка продолжится с места остановки."
        else -> t.message ?: fallback
    }

    fun fmt(bytes: Long): String = when {
        bytes >= GIB -> String.format(java.util.Locale.ROOT, "%.1f ГБ", bytes.toDouble() / GIB)
        bytes >= MIB -> String.format(java.util.Locale.ROOT, "%.0f МБ", bytes.toDouble() / MIB)
        else -> "меньше МБ"
    }
}
