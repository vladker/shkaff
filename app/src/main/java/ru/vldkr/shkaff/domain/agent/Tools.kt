package ru.vldkr.shkaff.domain.agent

import org.json.JSONObject

// Инструмент агента (как в opencode): модель запрашивает вызов через tool_calls,
// цикл AgentLoop выполняет [execute] и возвращает результат обратно в контекст.
// [parameters] — JSON Schema аргументов (OpenAI-формат).
interface Tool {
    val name: String
    val description: String
    val parameters: JSONObject

    // Короткая подпись шага для UI (напр., «Поиск: цена кофе»).
    fun label(args: JSONObject): String = name

    suspend fun execute(args: JSONObject): String
}
