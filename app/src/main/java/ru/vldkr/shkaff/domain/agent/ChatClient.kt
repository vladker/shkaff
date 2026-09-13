package ru.vldkr.shkaff.domain.agent

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

// Сообщение чата OpenAI-совместимого API: role = system|user|assistant|tool.
// tool-роль несёт результат вызова (toolCallId ссылается на id в toolCalls ассистента).
// imagePath — файл изображения (vision): для cloud/local сериализуется как image_url (data-URL),
// для device передаётся в llama.cpp напрямую.
data class ChatMessage(
    val role: String,
    val content: String? = null,
    val toolCalls: List<ToolCall> = emptyList(),
    val toolCallId: String? = null,
    val imagePath: String? = null,
)

// Вызов инструмента, запрошенный моделью (function calling в OpenAI-формате).
data class ToolCall(
    val id: String,
    val name: String,
    val argumentsJson: String,
)

// Ответ одной итерации: либо текст, либо список вызовов инструментов (иногда и то и другое).
data class ChatResponse(
    val content: String?,
    val toolCalls: List<ToolCall>,
)

// Спецификация инструмента для тела запроса (JSON Schema аргументов).
data class ToolSpec(
    val name: String,
    val description: String,
    val parameters: JSONObject,
)

data class AgentSettings(
    val enabled: Boolean = false,
    // cloud — облачный OpenAI-совместимый API (Qwen/OpenAI и т.п.);
    // local — локальный Ollama (тоже OpenAI-совместимый /v1/chat/completions).
    val provider: String = "cloud",
    // Преднастроенный домашний сервер (Qwen 27B, OpenAI-совместимый API).
    val baseUrl: String = "http://192.168.56.1:1234/v1",
    val apiKey: String = "",
    val model: String = "qwen/qwen3.8-27b"
)

object ChatClient {

    const val DEFAULT_BASE_URL = "https://api.openai.com/v1"

    fun endpoint(settings: AgentSettings): String {
        val base = settings.baseUrl.trim().ifBlank { DEFAULT_BASE_URL }.trimEnd('/')
        return if (base.endsWith("/chat/completions")) base else "$base/chat/completions"
    }

    // Один запрос chat completion; возвращает текст ответа ассистента.
    suspend fun complete(settings: AgentSettings, messages: List<ChatMessage>): String {
        val resp = completeWithTools(settings, messages, emptyList())
        return resp.content ?: ""
    }

    /**
     * Запрос chat completion с инструментами (OpenAI `tools`).
     * [tools] пустой — обычный запрос; иначе модель может ответить tool_calls.
     */
    suspend fun completeWithTools(
        settings: AgentSettings,
        messages: List<ChatMessage>,
        tools: List<ToolSpec>,
    ): ChatResponse =
        withContext(Dispatchers.IO) {
            val body = JSONObject()
            body.put("model", settings.model.ifBlank { "gpt-4o-mini" })
            body.put("messages", JSONArray().apply {
                messages.forEach { put(messageToJson(it)) }
            })
            if (tools.isNotEmpty()) {
                body.put("tools", JSONArray().apply {
                    tools.forEach { t ->
                        put(
                            JSONObject().apply {
                                put("type", "function")
                                put(
                                    "function", JSONObject().apply {
                                        put("name", t.name)
                                        put("description", t.description)
                                        put("parameters", t.parameters)
                                    }
                                )
                            }
                        )
                    }
                })
            }
            // Извлечение данных (карточка вещи, EAN, рекомендации) — нужна детерминированность.
            body.put("temperature", 0.0)

            val url = endpoint(settings)
            val conn = URL(url).openConnection() as HttpURLConnection
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
                parseResponse(JSONObject(raw))
            } catch (e: java.io.IOException) {
                throw IllegalStateException("Нет связи с $url: ${e.message}", e)
            } finally {
                conn.disconnect()
            }
        }

    internal fun extractContent(root: JSONObject): String = parseResponse(root).content ?: ""

    // Ответ → (текст, tool_calls). `content` может быть null — у OpenAI-формата
    // сообщение ассистента с tool_calls часто без текстового тела.
    internal fun parseResponse(root: JSONObject): ChatResponse {
        val choices = root.optJSONArray("choices")
            ?: return ChatResponse(root.optString("content", "").takeIf { it.isNotBlank() }, emptyList())
        if (choices.length() == 0) throw IllegalStateException("Нет ответа от модели")
        val msg = choices.getJSONObject(0).optJSONObject("message")
            ?: throw IllegalStateException("Нет ответа от модели")
        val content = (msg.opt("content") as? String)?.takeIf { it.isNotBlank() }
        val calls = mutableListOf<ToolCall>()
        msg.optJSONArray("tool_calls")?.let { arr ->
            for (i in 0 until arr.length()) {
                val t = arr.optJSONObject(i) ?: continue
                val fn = t.optJSONObject("function") ?: continue
                calls += ToolCall(
                    id = t.optString("id", ""),
                    name = fn.optString("name", ""),
                    argumentsJson = fn.optString("arguments", "{}"),
                )
            }
        }
        return ChatResponse(content, calls)
    }

    // Сообщение → JSON тела запроса: role, content, tool_calls, tool_call_id.
    // Если есть imagePath — content становится массивом [{type:text},{type:image_url}] (OpenAI vision).
    internal fun messageToJson(m: ChatMessage): JSONObject = JSONObject().apply {
        put("role", m.role)
        val img = m.imagePath?.takeIf { it.isNotBlank() }
        val dataUrl = img?.let { readImageDataUrl(it) }
        when {
            dataUrl != null -> put(
                "content", JSONArray().apply {
                    if (!m.content.isNullOrBlank()) {
                        put(JSONObject().apply {
                            put("type", "text")
                            put("text", m.content)
                        })
                    }
                    put(JSONObject().apply {
                        put("type", "image_url")
                        put("image_url", JSONObject().apply { put("url", dataUrl) })
                    })
                }
            )
            else -> if (m.content != null) put("content", m.content)
        }
        if (m.toolCalls.isNotEmpty()) {
            put(
                "tool_calls", JSONArray().apply {
                    m.toolCalls.forEach { tc ->
                        put(
                            JSONObject().apply {
                                put("id", tc.id)
                                put("type", "function")
                                put(
                                    "function", JSONObject().apply {
                                        put("name", tc.name)
                                        put("arguments", tc.argumentsJson)
                                    }
                                )
                            }
                        )
                    }
                }
            )
        }
        if (m.toolCallId != null) put("tool_call_id", m.toolCallId)
    }

    // Файл изображения → data-URL (base64) для OpenAI vision. null — если файла нет.
    private fun readImageDataUrl(path: String): String? {
        val f = File(path)
        if (!f.isFile) return null
        // Фото с телефона — full-res JPEG в несколько МБ; в base64 это сотни тысяч токенов,
        // из-за чего пре-филл «зависает». Перед отправкой ужимаем до ~1024px (JPEG ~85).
        // Если файл не декодируется (напр. HEIC), НЕ отсылаем full-res как есть —
        // он «завесит» модель. Лучше явная ошибка, чем зависание.
        val bytes = downscaleToJpeg(f, maxSide = 1024, quality = 85)
        return "data:image/jpeg;base64," + Base64.encodeToString(bytes, Base64.NO_WRAP)
    }

    // Декодируем файл с inSampleSize, при необходимости уменьшаем до maxSide и жмём JPEG.
    private fun downscaleToJpeg(src: File, maxSide: Int, quality: Int): ByteArray {
        val bounds = BitmapFactory.Options().apply { inJustDecodeBounds = true }
        BitmapFactory.decodeFile(src.absolutePath, bounds)
        val longest = maxOf(bounds.outWidth, bounds.outHeight)
        if (longest <= 0) throw IllegalArgumentException(
            "не удалось декодировать фото (возможно, HEIC или повреждённый файл)"
        )
        var sample = 1
        while (longest / (sample * 2) >= maxSide) sample *= 2
        val bmp = BitmapFactory.decodeFile(src.absolutePath, BitmapFactory.Options().apply { inSampleSize = sample })
            ?: throw IllegalArgumentException("не удалось прочитать фото")
        val scaled = if (bmp.width > maxSide || bmp.height > maxSide) {
            val scale = maxSide.toFloat() / maxOf(bmp.width, bmp.height)
            val out = Bitmap.createScaledBitmap(bmp, (bmp.width * scale).toInt(), (bmp.height * scale).toInt(), true)
            if (out !== bmp) bmp.recycle()
            out
        } else bmp
        val out = ByteArrayOutputStream()
        scaled.compress(Bitmap.CompressFormat.JPEG, quality, out)
        scaled.recycle()
        return out.toByteArray()
    }

    // Извлечение JSON-объекта из ответа: допускаем ```json … ```, «размышления» модели
    // и произвольный текст вокруг. Берём не «от первого { до последнего }» (падает на
    // вложенных объектах и мусорных скобках), а перебираем каждое «{»: для каждого
    // ищем сбалансированный фрагмент {...} и пробуем разобрать как JSON — первый
    // удачный кандидат и есть ответ.
    fun extractJson(text: String): JSONObject? {
        if (text.isBlank()) return null
        runCatching { JSONObject(text.trim()) }.getOrNull()?.let { return it }
        var from = 0
        while (true) {
            val open = text.indexOf('{', from)
            if (open < 0) return null
            balancedSpan(text, open)?.let { span ->
                runCatching { JSONObject(span) }.getOrNull()?.let { return it }
            }
            from = open + 1
        }
    }

    // Фрагмент от «{» до соответствующего «}», с учётом строк и экранирования.
    // null — если с этого «{» скобки не закрываются до конца текста.
    private fun balancedSpan(text: String, open: Int): String? {
        var depth = 0
        var inString = false
        var escaped = false
        for (i in open until text.length) {
            val c = text[i]
            if (inString) {
                when {
                    escaped -> escaped = false
                    c == '\\' -> escaped = true
                    c == '"' -> inString = false
                }
            } else {
                when (c) {
                    '"' -> inString = true
                    '{' -> depth++
                    '}' -> {
                        depth--
                        if (depth == 0) return text.substring(open, i + 1)
                    }
                }
            }
        }
        return null
    }
}