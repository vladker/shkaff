package ru.vldkr.shkaff.domain.batch

// Чистая логика массового ввода серии однотипных вещей (US-A1):
// шаблон имени с номером позиции и разделение атрибутов на
// «общие» (копируются из первого объекта) и «для каждого» (вводятся заново).
object BatchPlan {

    const val MAX_SERIES = 500

    // {n} заменяется на номер позиции в серии (счёт с 1). Без {n} — имя общее.
    fun expandName(pattern: String, index: Int): String {
        val p = pattern.trim()
        if (index < 1) return p
        return if (p.contains("{n}")) p.replace("{n}", index.toString()) else p
    }

    // T-027: серия из нескольких вещей без {n} даёт N одинаковых имён —
    // предупреждаем до старта, это почти всегда ошибка шаблона.
    fun duplicateNameWarning(pattern: String, count: Int): String? {
        val p = pattern.trim()
        if (count < 2 || p.isEmpty() || p.contains("{n}")) return null
        return "Без {n} все $count вещей серии получат одинаковое имя — добавьте {n} в название."
    }

    // Общие атрибуты: всё, что НЕ отмечено «для каждого».
    fun copiedAttrs(all: Map<String, String>, perItem: Set<String>): Map<String, String> =
        all.filterKeys { it !in perItem }

    // Итог для объекта: общие + значения, введённые для этой позиции (преобладают).
    fun mergeValues(copied: Map<String, String>, perItem: Map<String, String>): Map<String, String> =
        copied + perItem
}
