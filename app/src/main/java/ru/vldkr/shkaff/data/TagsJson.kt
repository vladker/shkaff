package ru.vldkr.shkaff.data

import org.json.JSONArray

// item.tags — JSON-массив имён тегов. Чистый Kotlin-мост к org.json, чтобы репозитории
// и UI не разбирали JSON сами (паттерн AttrJson)
object TagsJson {

    fun toJson(tags: List<String>): String = try {
        val a = JSONArray()
        tags.forEach { a.put(it.trim()) }
        a.toString()
    } catch (e: Exception) {
        "[]"
    }

    fun toList(json: String?): List<String> = try {
        val a = JSONArray(json ?: "[]")
        (0 until a.length()).map { a.optString(it, "") }.filter { it.isNotBlank() }
    } catch (e: Exception) {
        emptyList()
    }

    // Добавляет тег в массив; дубликат (без учёта регистра) не добавляется
    fun withNew(json: String?, tag: String): String {
        val t = tag.trim()
        if (t.isEmpty()) return json ?: "[]"
        val current = toList(json)
        if (current.any { it.equals(t, ignoreCase = true) }) return json ?: "[]"
        val a = JSONArray()
        current.forEach { a.put(it) }
        a.put(t)
        return a.toString()
    }

    fun without(json: String?, tag: String): String =
        toJson(toList(json).filter { !it.equals(tag.trim(), ignoreCase = true) })
}
