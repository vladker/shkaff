package ru.vldkr.shkaff.domain.ean

import org.junit.Assert.assertEquals
import org.junit.Test

class EanHeadlessBrowserTest {

    @Test
    fun queryStringIncludesPartNumber() {
        val q = EanHeadlessBrowser.SearchQuery(
            name = "Дрель",
            partNumber = "DF333RFE"
        )
        assertEquals("Дрель партномер артикул DF333RFE", q.toQueryString())
    }

    @Test
    fun queryStringOrder() {
        val q = EanHeadlessBrowser.SearchQuery(
            ean = "4607001234567",
            name = "Дрель",
            brand = "Makita",
            partNumber = "DF333",
            category = "Инструменты"
        )
        assertEquals(
            "штрихкод 4607001234567 Дрель бренд Makita партномер артикул DF333 категория Инструменты",
            q.toQueryString()
        )
    }

    @Test
    fun queryStringSkipsBlankParts() {
        val q = EanHeadlessBrowser.SearchQuery(name = "  ", partNumber = "")
        assertEquals("", q.toQueryString())
    }
}
