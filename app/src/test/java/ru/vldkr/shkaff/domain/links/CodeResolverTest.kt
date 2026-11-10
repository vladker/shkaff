package ru.vldkr.shkaff.domain.links

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import ru.vldkr.shkaff.data.db.StackEntity

// T-016 (US-E2): скан QR набора → карточка стека. Резолв стека — код вперёд,
// затем id карточки (QR может нести и его). Удалённые отсекает репозиторий.
class CodeResolverTest {

    private fun stack(id: String = "st-id-1", code: String = "STACK-42") = StackEntity(
        id = id, name = "Набор инструментов", description = "", code = code,
        created_at = 1L, updated_at = 2L, deleted_at = null, device_last_modified = "dev"
    )

    private val s = stack()
    private val byCode: suspend (String) -> StackEntity? = { c -> s.takeIf { it.code == c } }
    private val byId: suspend (String) -> StackEntity? = { c -> s.takeIf { it.id == c } }

    @Test
    fun `resolveStack finds stack by its plain code`() = runBlocking {
        assertEquals(s, CodeResolver.resolveStack("STACK-42", byCode, byId))
    }

    @Test
    fun `resolveStack unpacks app link qr`() = runBlocking {
        assertEquals(s, CodeResolver.resolveStack(AppLink.urlFor("STACK-42"), byCode, byId))
    }

    @Test
    fun `resolveStack trims surrounding whitespace`() = runBlocking {
        assertEquals(s, CodeResolver.resolveStack("  STACK-42  ", byCode, byId))
    }

    @Test
    fun `resolveStack falls back to card id when code misses`() = runBlocking {
        assertEquals(s, CodeResolver.resolveStack("st-id-1", byCode, byId))
    }

    @Test
    fun `resolveStack null for empty or unknown code`() = runBlocking {
        assertNull(CodeResolver.resolveStack("", byCode, byId))
        assertNull(CodeResolver.resolveStack("   ", byCode, byId))
        assertNull(CodeResolver.resolveStack("NE-VESHT", byCode, byId))
    }

    // Регрессия: старые ветки сканера (вещь/ящик) не сломаны.
    @Test
    fun `item and location resolution still works`() = runBlocking {
        assertEquals("IT-1", CodeResolver.innerCode(AppLink.urlFor("IT-1")))
        val loc = ru.vldkr.shkaff.data.db.LocationEntity(
            id = "loc-1", storage_id = "st-1", parent_id = null, label = "LOC-A", name = "Ящик А",
            attributes = "{}", photo_path = null, created_at = 1L, updated_at = 2L,
            deleted_at = null, device_last_modified = "dev"
        )
        val item = ru.vldkr.shkaff.data.db.ItemEntity(
            id = "it-1", name = "Дрель", code = "IT-1", description = "", attributes = "{}",
            location_id = "loc-1", photo_path = null, created_at = 1L, updated_at = 2L,
            deleted_at = null, device_last_modified = "dev", expiry_date = "", tags = "[]"
        )
        assertEquals(
            loc,
            CodeResolver.resolveLocation(
                AppLink.urlFor("LOC-A"),
                { c -> loc.takeIf { it.label == c } },
                { c -> loc.takeIf { c == item.code } }
            )
        )
        assertEquals(item, CodeResolver.resolveItem("IT-1", { c -> item.takeIf { it.code == c } }))
    }
}
