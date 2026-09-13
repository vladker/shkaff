package ru.vldkr.shkaff.domain.agent

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Test
import org.json.JSONArray
import org.json.JSONObject
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ChatClientTest {

    @Test
    fun extractJson_parsesBareJson() {
        val obj = ChatClient.extractJson("""{"name":"Молоко","brand":"Домик в деревне"}""")
        assertNotNull(obj)
        assertEquals("Молоко", obj!!.getString("name"))
    }

    @Test
    fun extractJson_stripsMarkdownFence() {
        val text = """Вот ответ:

```json
{"name": "Печенье", "quantity": "200 г"}
```
Надеюсь, помог.
"""
        val obj = ChatClient.extractJson(text)
        assertNotNull(obj)
        assertEquals("Печенье", obj!!.getString("name"))
        assertEquals("200 г", obj.getString("quantity"))
    }

    @Test
    fun extractJson_findsObjectInsideFreeText() {
        val text = "Товар найден: {\"name\": \"Кружка\", \"brand\": \"IKEA\"} конец."
        val obj = ChatClient.extractJson(text)
        assertNotNull(obj)
        assertEquals("Кружка", obj!!.getString("name"))
    }

    @Test
    fun extractJson_returnsNullOnGarbage() {
        assertNull(ChatClient.extractJson("Просто текст без JSON"))
        assertNull(ChatClient.extractJson(""))
        assertNull(ChatClient.extractJson("null"))
    }

    @Test
    fun complete_endpoint_fromBaseAndOverride() {
        val s = AgentSettings(baseUrl = "https://dashscope.aliyuncs.com/compatible-mode/v1", model = "qwen-turbo")
        assertEquals("https://dashscope.aliyuncs.com/compatible-mode/v1/chat/completions", ChatClient.endpoint(s))

        val s2 = AgentSettings(baseUrl = "http://localhost:11434/v1", model = "gemma3")
        assertEquals("http://localhost:11434/v1/chat/completions", ChatClient.endpoint(s2))

        val s3 = AgentSettings(baseUrl = "", model = "gpt-4o-mini")
        assertEquals("https://api.openai.com/v1/chat/completions", ChatClient.endpoint(s3))

        val s4 = AgentSettings(baseUrl = "https://x/v1/chat/completions")
        assertEquals("https://x/v1/chat/completions", ChatClient.endpoint(s4))
    }

    @Test
    fun extractContent_takesFirstChoice() {
        val root = JSONObject()
        root.put(
            "choices", JSONArray().put(
                JSONObject().put(
                    "message", JSONObject().put("role", "assistant").put("content", "Ответ модели")
                )
            )
        )
        assertEquals("Ответ модели", ChatClient.extractContent(root))
    }

    @Test
    fun parseResponse_extractsToolCallsAndNullContent() {
        val root = JSONObject()
        root.put(
            "choices", JSONArray().put(
                JSONObject().put(
                    "message", JSONObject()
                        .put("role", "assistant")
                        .put("content", JSONObject.NULL)
                        .put(
                            "tool_calls", JSONArray().put(
                                JSONObject()
                                    .put("id", "call_1")
                                    .put("type", "function")
                                    .put(
                                        "function", JSONObject()
                                            .put("name", "web_search")
                                            .put("arguments", """{"query":"цена кофе"}""")
                                    )
                            )
                        )
                )
            )
        )
        val resp = ChatClient.parseResponse(root)
        assertNull(resp.content)
        assertEquals(1, resp.toolCalls.size)
        assertEquals("call_1", resp.toolCalls[0].id)
        assertEquals("web_search", resp.toolCalls[0].name)
        assertEquals("""{"query":"цена кофе"}""", resp.toolCalls[0].argumentsJson)
    }

    @Test
    fun messageToJson_serializesToolResultMessage() {
        val m = ChatMessage("tool", "результат поиска", toolCallId = "call_1")
        val j = ChatClient.messageToJson(m)
        assertEquals("tool", j.getString("role"))
        assertEquals("результат поиска", j.getString("content"))
        assertEquals("call_1", j.getString("tool_call_id"))
        assertFalse(j.has("tool_calls"))
    }

    @Test
    fun messageToJson_serializesAssistantToolCallsWithoutContent() {
        val m = ChatMessage(
            "assistant", null,
            listOf(ToolCall("c1", "web_search", """{"query":"x"}"""))
        )
        val j = ChatClient.messageToJson(m)
        assertFalse(j.has("content"))
        val arr = j.getJSONArray("tool_calls")
        assertEquals(1, arr.length())
        val t = arr.getJSONObject(0)
        assertEquals("c1", t.getString("id"))
        assertEquals("function", t.getString("type"))
        assertEquals("web_search", t.getJSONObject("function").getString("name"))
        assertEquals("""{"query":"x"}""", t.getJSONObject("function").getString("arguments"))
    }
}