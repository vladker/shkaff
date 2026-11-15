package ru.vldkr.shkaff.domain.agent

import org.junit.Assert.assertEquals
import org.junit.Test

// T-034: индикатор режима ИИ обязан называть реальный хост API, а не хардкод «Qwen API».
class LlmStatusLabelTest {

    @Test
    fun `device provider gets offline label`() {
        val s = AgentSettings(provider = Agent.PROVIDER_DEVICE, model = "model.gguf")
        assertEquals("Офлайн (Локальная модель)", Agent.llmStatusLabel(s))
    }

    @Test
    fun `local network provider keeps network label without host`() {
        val s = AgentSettings(provider = Agent.PROVIDER_LOCAL, baseUrl = "http://192.168.56.1:1234/v1")
        assertEquals("Онлайн (Локальная сеть)", Agent.llmStatusLabel(s))
    }

    @Test
    fun `cloud deepseek preset shows deepseek host`() {
        val s = AgentSettings(provider = Agent.PROVIDER_CLOUD, baseUrl = "https://api.deepseek.com/v1")
        assertEquals("Онлайн (api.deepseek.com)", Agent.llmStatusLabel(s))
    }

    @Test
    fun `cloud openrouter base url shows its host`() {
        val s = AgentSettings(provider = Agent.PROVIDER_CLOUD, baseUrl = "https://openrouter.ai/api/v1")
        assertEquals("Онлайн (openrouter.ai)", Agent.llmStatusLabel(s))
    }

    @Test
    fun `host is lowercased and path and credentials stripped`() {
        val s = AgentSettings(provider = Agent.PROVIDER_CLOUD, baseUrl = "https://user:pass@API.DeepSeek.com/v1/chat")
        assertEquals("Онлайн (api.deepseek.com)", Agent.llmStatusLabel(s))
    }

    @Test
    fun `base url without scheme still yields host with port`() {
        val s = AgentSettings(provider = Agent.PROVIDER_CLOUD, baseUrl = "192.168.1.10:11434/v1")
        assertEquals("Онлайн (192.168.1.10:11434)", Agent.llmStatusLabel(s))
    }

    @Test
    fun `blank base url falls back to generic cloud label`() {
        val s = AgentSettings(provider = Agent.PROVIDER_CLOUD, baseUrl = "   ")
        assertEquals("Онлайн (Облако)", Agent.llmStatusLabel(s))
    }
}
