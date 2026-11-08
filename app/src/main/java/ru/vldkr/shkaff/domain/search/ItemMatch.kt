package ru.vldkr.shkaff.domain.search

import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity

// Единый предикат поиска вещи для вкладок «Вещи» и «Поиск» (T-038): название, код,
// EAN, описание, атрибуты, теги. Скан (HID/камера) пишет штрихкод прямо в запрос —
// без EAN в предикате скан товарной вещи даёт ложное «не найдено».
object ItemMatch {

    fun matches(i: ItemEntity, q: String): Boolean {
        val t = q.trim()
        if (t.isEmpty()) return true
        return i.name.contains(t, true) ||
            i.code.contains(t, true) ||
            (i.ean ?: "").contains(t, true) ||
            i.description.contains(t, true) ||
            i.attributes.contains(t, true) ||
            TagsJson.toList(i.tags).any { it.contains(t, true) }
    }

    // Фильтр по чипу тега — точное совпадение имени без учёта регистра (US-I3).
    fun matchesTag(i: ItemEntity, tag: String): Boolean =
        TagsJson.toList(i.tags).any { it.equals(tag, ignoreCase = true) }
}
