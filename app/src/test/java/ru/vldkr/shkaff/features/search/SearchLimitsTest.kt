package ru.vldkr.shkaff.features.search
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

// T-044: заголовки секций должны показывать полное число совпадений, а не только показанные.
class SearchLimitsTest {
    @Test
    fun `section header counts shown out of total when truncated`() {
        assertEquals("50 из 137", countLabel(50, 137))
    }

    @Test
    fun `section header shows plain total when nothing is cut`() {
        assertEquals("12", countLabel(12, 12))
        assertEquals("0", countLabel(0, 0))
    }

    @Test
    fun `hint appears only when something was cut`() {
        assertEquals(
            "Показаны первые 50 совпадений — уточните запрос.",
            searchHint(truncated = true),
        )
        assertNull(searchHint(truncated = false))
    }

    @Test
    fun `limit matches the hint text`() {
        assertEquals(50, SEARCH_LIMIT)
        assertEquals(
            "Показаны первые $SEARCH_LIMIT совпадений — уточните запрос.",
            searchHint(truncated = true),
        )
    }
}
