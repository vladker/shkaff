package ru.vldkr.shkaff.domain.agent

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

// Сообщение чата OpenAI-совместимого API: role = system|user|assistant
data class ChatMessage(val role: String, val content: String)

data class AgentSettings(
    val enabled: Boolean = false,
    // cloud — облачный OpenAI-совместимый API (Qwen/OpenAI и т.п.);
    // local — локальный Ollama (тоже OpenAI-совместимый /v1/chat/completions).
    val provider: String = "cloud",
    val baseUrl: String = "",
    val apiKey: String = "",
    val model: String = ""
)

object ChatClient {

    const val DEFAULT_BASE_URL = "https://api.openai.com/v1"

    fun endpoint(settings: AgentSettings): String {
        val base = settings.baseUrl.trim().ifBlank { DEFAULT_BASE_URL }.trimEnd('/')
        return if (base.endsWith("/chat/completions")) base else "$base/chat/completions"
    }

    // Один запрос chat completion; возвращает текст ответа ассистента.
    suspend fun complete(settings: AgentSettings, messages: List<ChatMessage>): String =
        withContext(Dispatchers.IO) {
            val body = JSONObject()
            body.put("model", settings.model.ifBlank { "gpt-4o-mini" })
            body.put("messages", JSONArray().apply {
                messages.forEach { m ->
                    put(
                        JSONObject().apply {
                            put("role", m.role)
                            put("content", m.content)
                        }
                    )
                }
            })
            body.put("temperature", 0.2)

            val conn = URL(endpoint(settings)).openConnection() as HttpURLConnection
            try {
                conn.requestMethod = "POST"
                conn.connectTimeout = 15_000
                conn.readTimeout = 90_000
                conn.doOutput = true
                conn.setRequestProperty("Content-Type", "application/json")
                conn.setRequestProperty("Accept", "application/json")
                if (settings.apiKey.isNotBlank()) {
                    conn.setRequestProperty("Authorization", "Bearer ${settings.apiKey}")
                }
                OutputStreamWriter(conn.outputStream, Charsets.UTF_8).use { it.write(body.toString()) }

                val code = conn.responseCode
                val raw = (if (code in 200..299) conn.inputStream else conn.errorStream)
                    ?.bufferedReader(Charsets.UTF_8)?.readText().orEmpty()
                if (code !in 200..299) {
                    throw IllegalStateException("HTTP $code: ${raw.take(300)}")
                }
                extractContent(JSONObject(raw))
            } finally {
                conn.disconnect()
            }
        }

    internal fun extractContent(root: JSONObject): String {
        val choices = root.optJSONArray("choices")
            ?: return root.optString("content", "").takeIf { it.isNotBlank() }
                ?: throw IllegalStateException("Нет ответа от модели")
        if (choices.length() == 0) throw IllegalStateException("Нет ответа от модели")
        val msg = choices.getJSONObject(0).optJSONObject("message")
            ?: throw IllegalStateException("Нет ответа от модели")
        return msg.optString("content", "")
    }

    // Извлечение JSON-объекта из ответа: допускаем ```json … ``` и произвольный текст вокруг.
    fun extractJson(text: String): JSONObject? {
        if (text.isBlank()) return null
        val fence = "```"
        if (text.contains(fence)) {
            val start = text.indexOf(fence) + fence.length
            val inner = text.substring(start).removePrefix("json").trim()
            val end = inner.indexOf(fence)
            val code = if (end >= 0) inner.substring(0, end) else inner
            return runCatching { JSONObject(code.trim()) }.getOrNull()
        }
        val open = text.indexOf('{')
        val close = text.lastIndexOf('}')
        if (open >= 0 && close > open) {
            return runCatching { JSONObject(text.substring(open, close + 1)) }.getOrNull()
        }
        return runCatching { JSONObject(text.trim()) }.getOrNull()
    }
}