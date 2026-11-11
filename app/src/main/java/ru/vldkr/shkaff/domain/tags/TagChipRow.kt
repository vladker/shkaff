package ru.vldkr.shkaff.domain.tags

// T-039: содержимое ряда чипов тега-фильтра на «Вещях».
// Словарь тегов (tagOptions) — не источник истины для фильтра: на экран «Вещи»
// фильтр заводит дашборд по роуту items/<tag>, где теги взяты из самих вещей
// и могут отсутствовать в словаре. Активный тег обязан попадать в ряд всегда,
// иначе фильтр невидим и его нельзя снять; дубль исключён сравнением без учёта
// регистра (как в ItemMatch.matchesTag).
object TagChipRow {
    fun row(tagOptions: List<String>, activeTag: String): List<String> {
        val opts = tagOptions.distinct()
        if (activeTag.isEmpty() || opts.any { it.equals(activeTag, ignoreCase = true) }) return opts
        return opts + activeTag
    }
}
