package ru.vldkr.shkaff.domain.vision

import org.json.JSONObject
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ItemVisionTest {

    @Test
    fun cleanTreatsNullLikeValuesAsEmpty() {
        assertEquals("", ItemVision.clean(null))
        assertEquals("", ItemVision.clean(""))
        assertEquals("", ItemVision.clean("  "))
        assertEquals("", ItemVision.clean("null"))
        assertEquals("", ItemVision.clean("NULL"))
        assertEquals("", ItemVision.clean("none"))
        assertEquals("", ItemVision.clean("N/A"))
        assertEquals("", ItemVision.clean("—"))
        assertEquals("", ItemVision.clean("-"))
    }

    @Test
    fun cleanKeepsRealValues() {
        assertEquals("Makita", ItemVision.clean(" Makita "))
        assertEquals("T-001", ItemVision.clean("T-001"))
        assertEquals("2,5", ItemVision.clean("2,5"))
    }

    @Test
    fun mergePrefersWebAndFillsGapsFromPhoto() {
        val web = JSONObject(
            """
            {
              "name": "Дрель Makita DF333RFE",
              "description": "Ударная дрель, 710 Вт",
              "attributes": { "Категория": "Инструменты" }
            }
            """
        )
        val facts = JSONObject(
            """
            {
              "name": "Makita",
              "brand": "Makita",
              "model": "DF333RFE",
              "ean": "4607001234567"
            }
            """
        )
        val out = ItemVision.mergeWebWithFacts(web, facts)
        assertEquals("Дрель Makita DF333RFE", out.getString("name"))
        // Модель с фото добирается, когда её нет в интернете
        assertEquals("DF333RFE", out.getString("code"))
        assertEquals("4607001234567", out.getString("ean"))
        assertEquals("Ударная дрель, 710 Вт", out.getString("description"))
        val attrs = out.getJSONObject("attributes")
        assertEquals("Инструменты", attrs.getString("Категория"))
        assertEquals("Makita", attrs.getString("Бренд"))
    }

    @Test
    fun mergeDropsNullLikeWebValues() {
        val web = JSONObject(
            """
            {
              "name": "Дрель Makita",
              "code": "null",
              "description": "None",
              "attributes": { "Категория": "null" }
            }
            """
        )
        val facts = JSONObject("""{ "model": "DF333RFE" }""")
        val out = ItemVision.mergeWebWithFacts(web, facts)
        assertEquals("Дрель Makita", out.getString("name"))
        assertEquals("DF333RFE", out.getString("code"))
        assertEquals("", out.getString("description"))
        assertFalse(out.has("attributes"))
    }

    @Test
    fun mergeKeepsWebNameOverPhoto() {
        val web = JSONObject("""{ "name": "Дрель Makita DF333RFE" }""")
        val facts = JSONObject("""{ "name": "Makita" }""")
        assertEquals("Дрель Makita DF333RFE", ItemVision.mergeWebWithFacts(web, facts).getString("name"))
    }

    @Test
    fun fallbackContainsOnlyVisibleText() {
        val facts = JSONObject(
            """
            {
              "name": "Makita",
              "brand": "Makita",
              "model": "DF333RFE",
              "ean": "null"
            }
            """
        )
        val out = ItemVision.fallbackFromFacts(facts)
        assertEquals("Makita", out.getString("name"))
        assertEquals("DF333RFE", out.getString("code"))
        assertFalse(out.has("ean"))
        // Описание по фото «в лоб» не генерим — его даёт кнопка ИИ в поле «Описание»
        assertFalse(out.has("description"))
        assertEquals("Makita", out.getJSONObject("attributes").getString("Бренд"))
    }

    @Test
    fun fallbackFromEmptyFactsIsEmpty() {
        val out = ItemVision.fallbackFromFacts(JSONObject("""{ "name": "null" }"""))
        assertEquals(0, out.length())
    }

    @Test
    fun appearancePromptAsksOnlyForVisibleFeatures() {
        val prompt = ItemVision.buildAppearancePrompt()
        assertTrue(prompt.contains("ВНЕШНИЙ ВИД"))
        assertTrue(prompt.contains("материал"))
        assertTrue(prompt.contains("цвет"))
        assertTrue(prompt.contains("Не угадывай"))
        assertFalse(prompt.contains("description"))
    }

    @Test
    fun extractionPromptDoesNotAskForDescription() {
        val prompt = ItemVision.buildExtractionPrompt()
        assertTrue(prompt.contains("\"name\""))
        assertTrue(prompt.contains("\"brand\""))
        assertTrue(prompt.contains("\"model\""))
        assertTrue(prompt.contains("\"ean\""))
        assertFalse(prompt.contains("\"description\""))
        assertTrue(prompt.contains("Never guess"))
    }
}
