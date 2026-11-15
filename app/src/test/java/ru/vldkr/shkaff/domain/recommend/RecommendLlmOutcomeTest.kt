package ru.vldkr.shkaff.domain.recommend

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.domain.agent.AgentSettings

// T-026 (US-C6): ИИ-рекомендация обязана сообщать источник — ИИ или правила,
// и текст причины, если ИИ не смог. Транспорт подменяется fake-лямбдой, сеть не трогается.
// org.json в ветке разбора ответа → Robolectric (как в AgentLoopTest).
@RunWith(RobolectricTestRunner::class)
class RecommendLlmOutcomeTest {

    private val candidate = RecommendLlm.CandidateInfo(
        id = "loc1",
        name = "Гараж",
        freeLiters = 100.0,
        freeKg = 50.0,
        dontFillToBrim = false,
        isFull = false,
        itemCount = 1,
        presentCategories = listOf("инструмент"),
        climate = emptyMap(),
    )

    @Test
    fun disabledSettingsReportRulesWithReason() = runBlocking {
        val out = RecommendLlm.recommendOutcome(
            settings = AgentSettings(enabled = false),
            itemName = "Дрель",
            itemCategory = "инструмент",
            volumeLiters = 10.0,
            weightKg = 2.0,
            candidates = listOf(candidate),
            complete = { error("ИИ выключен — лямбда не должна вызываться") },
        )
        assertEquals(RecommendLlm.Source.RULES, out.source)
        assertTrue(out.aiError.orEmpty().contains("выключен"))
        assertEquals(1, out.recommendations.size)
    }

    @Test
    fun aiSuccessMarksSourceAi() = runBlocking {
        val json = """{"top":[{"id":"loc1","reason":"хранят похожее"}]}"""
        val out = RecommendLlm.recommendOutcome(
            settings = AgentSettings(enabled = true),
            itemName = "Дрель",
            itemCategory = "инструмент",
            volumeLiters = 10.0,
            weightKg = 2.0,
            candidates = listOf(candidate),
            complete = { json },
        )
        assertEquals(RecommendLlm.Source.AI, out.source)
        assertEquals(null, out.aiError)
        assertEquals("хранят похожее", out.recommendations.first().reason)
    }

    @Test
    fun aiFailureMarksRulesAndReportsCause() = runBlocking {
        val out = RecommendLlm.recommendOutcome(
            settings = AgentSettings(enabled = true),
            itemName = "Дрель",
            itemCategory = "инструмент",
            volumeLiters = 10.0,
            weightKg = 2.0,
            candidates = listOf(candidate),
            complete = { throw IllegalStateException("таймаут сети") },
        )
        assertEquals(RecommendLlm.Source.RULES, out.source)
        assertEquals("таймаут сети", out.aiError)
        assertEquals(1, out.recommendations.size) // фолбэк тот же, что и раньше
    }

    @Test
    fun unparseableAnswerMarksRulesWithCause() = runBlocking {
        val out = RecommendLlm.recommendOutcome(
            settings = AgentSettings(enabled = true),
            itemName = "Дрель",
            itemCategory = null,
            volumeLiters = 10.0,
            weightKg = 2.0,
            candidates = listOf(candidate),
            complete = { "не JSON, а просто текст" },
        )
        assertEquals(RecommendLlm.Source.RULES, out.source)
        assertNotNull(out.aiError)
        assertTrue(out.aiError!!.isNotBlank())
    }

    // Старый публичный API сохраняется — только делегирует к outcome.
    @Test
    fun legacyRecommendStillReturnsRuleFallback() = runBlocking {
        val recs = RecommendLlm.recommend(
            settings = AgentSettings(enabled = false),
            itemName = "Дрель",
            itemCategory = null,
            volumeLiters = 10.0,
            weightKg = 2.0,
            candidates = listOf(candidate),
        )
        assertEquals(1, recs.size)
    }
}
