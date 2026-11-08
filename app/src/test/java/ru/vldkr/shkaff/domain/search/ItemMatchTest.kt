package ru.vldkr.shkaff.domain.search

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ItemEntity

// Единый предикат поиска вещи (T-038): «Вещи» и «Поиск» обязаны находить по EAN и тегам —
// сканер (HID/камера) пишет штрихкод прямо в поисковый запрос.
// org.json (TagsJson) в юнит-тестах живёт только под Robolectric.
@RunWith(RobolectricTestRunner::class)
class ItemMatchTest {

    private fun item(
        name: String = "Дрель",
        code: String = "DR-01",
        ean: String? = "4600000000017",
        tags: String = """["инструмент"]""",
        description: String = "",
        attributes: String = "{}"
    ) = ItemEntity(
        id = name + code, name = name, code = code, description = description,
        attributes = attributes, photo_path = null, location_id = null,
        created_at = 0, updated_at = 0, deleted_at = null, device_last_modified = "",
        ean = ean, tags = tags
    )

    @Test
    fun `empty query matches all`() {
        assertTrue(ItemMatch.matches(item(), ""))
        assertTrue(ItemMatch.matches(item(), "   "))
    }

    @Test
    fun `matches name code description attributes`() {
        assertTrue(ItemMatch.matches(item(), "дре"))
        assertTrue(ItemMatch.matches(item(), "dr-01")) // регистронезависимо
        assertTrue(ItemMatch.matches(item(description = "аккумуляторная"), "аккум"))
        assertTrue(ItemMatch.matches(item(attributes = """{"brand":"Bosch"}"""), "bosch"))
    }

    @Test
    fun `matches by ean - T-038`() {
        assertTrue(ItemMatch.matches(item(), "4600000000017"))
        assertTrue(ItemMatch.matches(item(), "0000017")) // хвост EAN тоже ищется
        assertFalse(ItemMatch.matches(item(ean = null), "4600000000017"))
    }

    @Test
    fun `matches by tag substring`() {
        assertTrue(ItemMatch.matches(item(), "инструмент"))
        assertTrue(ItemMatch.matches(item(), "инстр"))
        assertFalse(ItemMatch.matches(item(tags = "[]"), "инструмент"))
    }

    @Test
    fun `no match returns false`() {
        assertFalse(ItemMatch.matches(item(), "фанера"))
    }

    @Test
    fun `tag filter is exact case-insensitive`() {
        assertTrue(ItemMatch.matchesTag(item(), "Инструмент"))
        assertFalse(ItemMatch.matchesTag(item(), "инстру"))
    }
}
