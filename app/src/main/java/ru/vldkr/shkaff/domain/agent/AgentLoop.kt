package ru.vldkr.shkaff.domain.agent

import org.json.JSONObject

// Транспорт «модель + инструменты»: по умолчанию ChatClient,
// в юнит-тестах подставляется скриптованный фейк.
typealias LlmTransport = suspend (List<ChatMessage>, List<ToolSpec>) -> ChatResponse

// Цикл «модель → tool_calls → выполнить → результат в контекст → модель…»,
// как в opencode.
object AgentLoop {

    data class RunResult(
        val answer: String,
        val conversation: List<ChatMessage>,
    )

    // Стеклянная крышка: один инструмент-результат не должен съесть весь контекст.
    const val DEFAULT_RESULT_LIMIT = 8000
    const val DEFAULT_MAX_ROUNDS = 6

    suspend fun run(
        settings: AgentSettings,
        messages: List<ChatMessage>,
        tools: List<Tool>,
        maxRounds: Int = DEFAULT_MAX_ROUNDS,
        resultLimit: Int = DEFAULT_RESULT_LIMIT,
        onStep: (String) -> Unit = {},
        transport: LlmTransport = { msgs, specs -> ChatClient.completeWithTools(settings, msgs, specs) },
    ): RunResult {
        require(messages.isNotEmpty()) { "Пустой список сообщений" }
        if (tools.isEmpty()) {
            val answer = ChatClient.complete(settings, messages)
            return RunResult(answer, messages + ChatMessage("assistant", answer))
        }

        val specs = tools.map { ToolSpec(it.name, it.description, it.parameters) }
        var convo = messages
        val executed = mutableSetOf<String>()
        var lastContent: String? = null
        var rounds = 0

        while (rounds < maxRounds) {
            rounds++
            val resp = transport(convo, specs)
            if (resp.content != null) lastContent = resp.content

            if (resp.toolCalls.isEmpty()) {
                val final = resp.content?.takeIf { it.isNotBlank() }
                    ?: lastContent
                    ?: "Модель не ответила"
                val convoFinal = if (resp.content != null) convo + ChatMessage("assistant", resp.content) else convo
                return RunResult(final, convoFinal)
            }

            convo = convo + ChatMessage("assistant", resp.content, resp.toolCalls)
            for (call in resp.toolCalls) {
                val tool = tools.firstOrNull { it.name == call.name }
                val args = runCatching { JSONObject(call.argumentsJson.ifBlank { "{}" }) }.getOrNull()
                onStep(tool?.label(args ?: JSONObject()) ?: call.name)
                val key = call.name + "" + call.argumentsJson.trim()
                val result = when {
                    tool == null -> "Неизвестный инструмент: ${call.name}. Вызови только доступные инструменты."
                    args == null -> "Не удалось разобрать аргументы (JSON): ${call.argumentsJson.take(200)}"
                    !executed.add(key) -> "Этот вызов уже выполнялся — результат выше. Дай итоговый ответ."
                    else -> runCatching { tool.execute(args).take(resultLimit) }
                        .getOrElse { e -> "Ошибка инструмента: ${e.message ?: e::class.simpleName}" }
                }
                convo = convo + ChatMessage("tool", result, toolCallId = call.id)
            }
        }

        val final = lastContent?.takeIf { it.isNotBlank() }
            ?: "Не удалось получить ответ за $rounds шагов (модель повторяет вызов инструментов)."
        return RunResult(final, convo)
    }
}
