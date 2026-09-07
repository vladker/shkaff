package ru.vldkr.shkaff.data

import org.json.JSONArray
import org.json.JSONObject

object AttrJson {

    fun toJson(map: Map<String, String>): String = try {
        val o = JSONObject()
        for ((k, v) in map) if (k.isNotBlank()) o.put(k.trim(), v)
        o.toString()
    } catch (e: Exception) {
        "{}"
    }

    fun parseOptions(json: String?): List<String> = try {
        val a = JSONArray(json ?: "[]")
        (0 until a.length()).map { a.optString(it, "") }.filter { it.isNotBlank() }
    } catch (e: Exception) {
        emptyList()
    }

    // Добавляет новое значение в JSON-массив словаря; дубликат (без учёта регистра) не добавляется
    fun optionsWithNew(json: String?, option: String): String {
        val t = option.trim()
        val current = parseOptions(json)
        if (t.isEmpty() || current.any { it.equals(t, ignoreCase = true) }) {
            return json ?: "[]"
        }
        val a = JSONArray()
        current.forEach { a.put(it) }
        a.put(t)
        return a.toString()
    }

    fun toMap(json: String?): Map<String, String> = try {
        val o = JSONObject(json ?: "{}")
        val out = LinkedHashMap<String, String>()
        val it = o.keys()
        while (it.hasNext()) {
            val k = it.next()
            out[k] = o.optString(k, "")
        }
        out
    } catch (e: Exception) {
        emptyMap()
    }
}
