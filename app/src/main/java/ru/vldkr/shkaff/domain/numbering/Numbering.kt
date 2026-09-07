package ru.vldkr.shkaff.domain.numbering

// Чистая логика автонумерации (без БД) — формат, разбор и подбор следующего номера.
// Схема: <префикс>-<порядковый>, напр. T-001 (вещь), B-01 (ящик), S-01 (шкаф).
object Numbering {

    const val SCOPE_ITEM = "item"
    const val SCOPE_LOCATION = "location"
    const val SCOPE_STORAGE = "storage"

    fun format(prefix: String, seq: Int, width: Int): String {
        require(seq >= 1) { "seq должен быть >= 1" }
        val p = prefix.trim()
        val body = if (width > 0) seq.toString().padStart(width, '0') else seq.toString()
        return if (p.isEmpty()) body else "$p-$body"
    }

    // Возвращает порядковый номер, если code — «наш» номер (prefix-NNN), иначе null.
    fun parseSeq(code: String, prefix: String): Int? {
        val p = prefix.trim()
        val body: String
        if (p.isEmpty()) {
            body = code.trim()
        } else {
            val sep = "$p-"
            if (!code.startsWith(sep)) return null
            body = code.substring(sep.length)
        }
        if (body.isEmpty() || !body.all { it.isDigit() }) return null
        val v = body.toIntOrNull() ?: return null
        return if (v >= 1) v else null
    }

    // Следующий номер серии: максимум существующих + 1 (чужие префиксы игнорируются).
    fun nextAfter(existing: Collection<String>, prefix: String): Int {
        var max = 0
        for (c in existing) {
            val v = parseSeq(c, prefix) ?: continue
            if (v > max) max = v
        }
        return max + 1
    }
}
