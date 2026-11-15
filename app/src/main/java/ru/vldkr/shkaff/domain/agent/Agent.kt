package ru.vldkr.shkaff.domain.agent

// Точка входа для всех LLM-запросов приложения: выбирает транспорт по
// `settings.provider` — облако/локальная сеть (HTTP) или модель на устройстве.
object Agent {

    const val PROVIDER_CLOUD = "cloud"
    const val PROVIDER_LOCAL = "local"
    const val PROVIDER_DEVICE = "device"

    fun isDevice(settings: AgentSettings): Boolean =
        settings.provider.trim().lowercase() == PROVIDER_DEVICE

    // Подпись индикатора режима (T-034): вместо хардкода «Qwen API» облачный
    // провайдер показывает реальный хост из baseUrl; локальная сеть и устройство — свои метки.
    fun llmStatusLabel(settings: AgentSettings): String {
        if (isDevice(settings)) return "Офлайн (Локальная модель)"
        if (settings.provider.trim().lowercase() == PROVIDER_LOCAL) return "Онлайн (Локальная сеть)"
        val host = hostLabel(settings.baseUrl)
        return if (host != null) "Онлайн ($host)" else "Онлайн (Облако)"
    }

    // Человекочитаемый хост из baseUrl: без схемы, логина и пути («https://user:pw@API.DeepSeek.com/v1» -> «api.deepseek.com»).
    private fun hostLabel(baseUrl: String): String? {
        var s = baseUrl.trim()
        val scheme = s.indexOf("://")
        if (scheme >= 0) s = s.substring(scheme + 3)
        s = s.substringBefore('/').substringBefore('?').substringAfterLast('@')
        return s.ifBlank { null }?.lowercase()
    }

    suspend fun complete(
        settings: AgentSettings,
        messages: List<ChatMessage>,
        onToken: (String) -> Unit = {},
        nMaxTokens: Int = DeviceLlm.N_MAX_TOKENS,
        imagePath: String? = null,
    ): String {
        require(messages.isNotEmpty()) { "Пустой список сообщений" }
        return if (isDevice(settings)) {
            DeviceLlm.complete(settings, messages, onToken, nMaxTokens, imagePath)
        } else {
            // cloud/local: изображение уже на сообщении (messageToJson сериализует image_url).
            ChatClient.complete(settings, messages)
        }
    }

    /**
     * Запрос с инструментами (web_search/web_fetch).
     * Провайдеры cloud/local — полноценный цикл tool-calling через OpenAI-API;
     * device (llama.cpp) — мост не умеет tool_calls, отвечаем без инструментов.
     */
    suspend fun run(
        settings: AgentSettings,
        messages: List<ChatMessage>,
        tools: List<Tool>,
        onStep: (String) -> Unit = {},
        onToken: (String) -> Unit = {},
    ): AgentLoop.RunResult {
        require(messages.isNotEmpty()) { "Пустой список сообщений" }
        return if (isDevice(settings)) {
            val answer = DeviceLlm.complete(settings, messages, onToken)
            AgentLoop.RunResult(answer, messages + ChatMessage("assistant", answer))
        } else {
            AgentLoop.run(settings, messages, tools, onStep = onStep)
        }
    }
}
