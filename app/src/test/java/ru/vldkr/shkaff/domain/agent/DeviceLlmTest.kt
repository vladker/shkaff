package ru.vldkr.shkaff.domain.agent

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class DeviceLlmTest {

    @Test
    fun transcript_alternatesRolesAndEndsWithAssistantTurn() {
        val text = DeviceLlm.buildTranscript(
            listOf(
                ChatMessage("user", "Где мука?"),
                ChatMessage("assistant", "В «Кухня» → «Полка 2»"),
                ChatMessage("user", "А где сахар?"),
            )
        )
        assertTrue(text.contains("Пользователь: Где мука?"))
        assertTrue(text.contains("Ассистент: В «Кухня» → «Полка 2»"))
        assertTrue(text.endsWith("Пользователь: А где сахар?\nАссистент:"))
    }

    @Test
    fun transcript_skipsSystemMessages() {
        val text = DeviceLlm.buildTranscript(
            listOf(
                ChatMessage("system", "Ты — агент Шкаф"),
                ChatMessage("user", "Привет"),
            )
        )
        assertFalse(text.contains("Ты — агент Шкаф"))
        assertTrue(text.contains("Пользователь: Привет"))
    }

    @Test
    fun transcript_emptyListIsEmpty() {
        assertEquals("", DeviceLlm.buildTranscript(emptyList()))
    }

    @Test
    fun isDevice_matchesProviderCaseInsensitive() {
        assertTrue(Agent.isDevice(AgentSettings(provider = "device")))
        assertTrue(Agent.isDevice(AgentSettings(provider = "DEVICE")))
        assertTrue(Agent.isDevice(AgentSettings(provider = " device ")))
        assertFalse(Agent.isDevice(AgentSettings(provider = "cloud")))
        assertFalse(Agent.isDevice(AgentSettings(provider = "local")))
    }
}
