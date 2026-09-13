package ru.vldkr.shkaff.domain.agent

import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

// Цикл инструментов — без сети: транспорт и инструменты подменяются.
// org.json в подставках → Robolectric (как в ChatClientTest).
@RunWith(RobolectricTestRunner::class)
class AgentLoopTest {

    private class FakeTool(
        private val result: String = "результат",
        private val boom: Boolean = false,
    ) : Tool {
        val calls = mutableListOf<String>()

        override val name = "echo"
        override val description = "тестовый эхо-инструмент"
        override val parameters: JSONObject = JSONObject().apply { put("type", "object") }
        override fun label(args: JSONObject) = "echo: ${args.optString("x")}"

        override suspend fun execute(args: JSONObject): String {
            calls.add(args.toString())
            if (boom) throw IllegalStateException("сломалось")
            return result
        }
    }

    @Test
    fun loop_executesToolThenReturnsFinalAnswer() = runBlocking {
        val tool = FakeTool()
        var first = true
        val res = AgentLoop.run(
            settings = AgentSettings(),
            messages = listOf(ChatMessage("user", "привет")),
            tools = listOf(tool),
            transport = { msgs, _ ->
                if (first) {
                    first = false
                    ChatResponse(
                        content = null,
                        toolCalls = listOf(ToolCall("c1", "echo", """{"x":"1"}"""))
                    )
                } else {
                    assertEquals(1, msgs.count { it.role == "tool" })
                    ChatResponse(content = "Итоговый ответ", toolCalls = emptyList())
                }
            }
        )
        assertEquals("Итоговый ответ", res.answer)
        assertEquals(1, tool.calls.size)
        assertEquals("""{"x":"1"}""", tool.calls[0])
        assertEquals(
            listOf("user", "assistant", "tool", "assistant"),
            res.conversation.map { it.role }
        )
        assertEquals("c1", res.conversation[2].toolCallId)
        assertEquals("результат", res.conversation[2].content)
    }

    @Test
    fun loop_rejectsDuplicateCallAndStopsAtMaxRounds() = runBlocking {
        val tool = FakeTool()
        val res = AgentLoop.run(
            settings = AgentSettings(),
            messages = listOf(ChatMessage("user", "зациклись")),
            tools = listOf(tool),
            maxRounds = 3,
            transport = { _, _ ->
                ChatResponse(
                    content = null,
                    toolCalls = listOf(ToolCall("c1", "echo", """{"x":"1"}"""))
                )
            }
        )
        assertEquals(1, tool.calls.size)
        assertTrue(res.answer.contains("3 шагов"))
    }

    @Test
    fun loop_unknownToolGetsErrorInContext() = runBlocking {
        var first = true
        val res = AgentLoop.run(
            settings = AgentSettings(),
            messages = listOf(ChatMessage("user", "вызови фантом")),
            tools = listOf(FakeTool()),
            transport = { msgs, _ ->
                if (first) {
                    first = false
                    ChatResponse(
                        content = null,
                        toolCalls = listOf(ToolCall("c1", "phantom", "{}"))
                    )
                } else {
                    val toolMsgs = msgs.filter { it.role == "tool" }
                    assertEquals(1, toolMsgs.size)
                    assertTrue(toolMsgs[0].content!!.contains("Неизвестный инструмент: phantom"))
                    ChatResponse(content = "ок", toolCalls = emptyList())
                }
            }
        )
        assertEquals("ок", res.answer)
    }

    @Test
    fun loop_toolExceptionBecomesResultMessage() = runBlocking {
        var first = true
        val res = AgentLoop.run(
            settings = AgentSettings(),
            messages = listOf(ChatMessage("user", "сломайся")),
            tools = listOf(FakeTool(boom = true)),
            transport = { _, _ ->
                if (first) {
                    first = false
                    ChatResponse(
                        content = null,
                        toolCalls = listOf(ToolCall("c1", "echo", "{}"))
                    )
                } else {
                    ChatResponse(content = "готово", toolCalls = emptyList())
                }
            }
        )
        val toolMsg = res.conversation.first { it.role == "tool" }
        assertTrue(toolMsg.content!!.contains("Ошибка инструмента"))
        assertTrue(toolMsg.content!!.contains("сломалось"))
    }

    @Test
    fun loop_reportsSteps() = runBlocking {
        val steps = mutableListOf<String>()
        var first = true
        AgentLoop.run(
            settings = AgentSettings(),
            messages = listOf(ChatMessage("user", "привет")),
            tools = listOf(FakeTool()),
            onStep = { steps.add(it) },
            transport = { _, _ ->
                if (first) {
                    first = false
                    ChatResponse(
                        content = null,
                        toolCalls = listOf(ToolCall("c1", "echo", """{"x":"7"}"""))
                    )
                } else {
                    ChatResponse(content = "ок", toolCalls = emptyList())
                }
            }
        )
        assertEquals(listOf("echo: 7"), steps)
    }
}
