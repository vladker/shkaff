package ru.vldkr.shkaff.data

import org.json.JSONObject

object AttrJson {

    fun toJson(map: Map<String, String>): String = try {
        val o = JSONObject()
        for ((k, v) in map) if (k.isNotBlank()) o.put(k.trim(), v)
        o.toString()
    } catch (e: Exception) {
        "{}"
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
