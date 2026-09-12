package ru.vldkr.shkaff.domain.agent

// Точка входа для всех LLM-запросов приложения: выбирает транспорт по
// `settings.provider` — облако/локальная сеть (HTTP) или модель на устройстве.
object Agent {

    const val PROVIDER_CLOUD = "cloud"
    const val PROVIDER_LOCAL = "local"
    const val PROVIDER_DEVICE = "device"

    fun isDevice(settings: AgentSettings): Boolean =
        settings.provider.trim().lowercase() == PROVIDER_DEVICE

    suspend fun complete(
        settings: AgentSettings,
        messages: List<ChatMessage>,
        onToken: (String) -> Unit = {},
        nMaxTokens: Int = DeviceLlm.N_MAX_TOKENS,
    ): String {
        require(messages.isNotEmpty()) { "Пустой список сообщений" }
        return if (isDevice(settings)) {
            DeviceLlm.complete(settings, messages, onToken, nMaxTokens)
        } else {
            ChatClient.complete(settings, messages)
        }
    }
}
