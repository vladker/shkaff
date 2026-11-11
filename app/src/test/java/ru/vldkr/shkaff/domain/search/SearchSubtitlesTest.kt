package ru.vldkr.shkaff.domain.search

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity

// T-043: подпись ящика в глобальном поиске («в каком шкафу») обязана resolvиться из
// ПОЛНОГО списка шкафов (ui.storages). results.storages — только совпадения с запросом,
// обрезанные .take(50): если запрос не задел имя шкафа, его нет в results и подпись
// пропадала (storageNames[it.storage_id] == null).
class SearchSubtitlesTest {

    private fun storage(id: String, name: String, code: String = "") = StorageEntity(
        id = id, name = name, code = code, created_at = 0, updated_at = 0
    )

    private fun location(id: String, storageId: String, label: String) = LocationEntity(
        id = id, storage_id = storageId, label = label, created_at = 0, updated_at = 0
    )

    @Test
    fun `drawer subtitle resolves from full storages list`() {
        val all = listOf(storage("s1", "Гараж"), storage("s2", "Кладовка"))
        // Запрос «перчат» задел только вещь; шкаф «Гараж» в results.storages не попал.
        val matched = emptyList<StorageEntity>()
        val drawer = location("l1", storageId = "s1", label = "Полка верхняя")

        val map = SearchSubtitles.storageById(all)
        assertEquals("Гараж", SearchSubtitles.locationStorageName(drawer, map))

        // Старое поведение (карта из results.storages) — подпись терялась; фиксируем контраст.
        assertNull(SearchSubtitles.locationStorageName(drawer, SearchSubtitles.storageById(matched)))
    }

    @Test
    fun `subtitle resolves even when storage was cut by take limit`() {
        val all = (1..60).map { storage("s$it", "Шкаф $it") }
        // results.storages = all.take(50): «Шкаф 57» среди совпадений обрезан.
        val matched = all.take(50)
        val drawer = location("l57", storageId = "s57", label = "Ящик 57")
        assertEquals(
            "Шкаф 57",
            SearchSubtitles.locationStorageName(drawer, SearchSubtitles.storageById(all))
        )
        assertNull(
            SearchSubtitles.locationStorageName(drawer, SearchSubtitles.storageById(matched))
        )
    }

    @Test
    fun `unknown storage id yields no subtitle`() {
        val map = SearchSubtitles.storageById(listOf(storage("s1", "Гараж")))
        assertNull(
            SearchSubtitles.locationStorageName(location("l9", storageId = "sX", label = "X"), map)
        )
    }
}
