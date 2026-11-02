package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelDocEntity

class MergeEngineTest {
    private fun item(
        id: String,
        name: String,
        ts: Long,
        del: Long? = null,
    ) = ItemEntity(
        id = id,
        name = name,
        code = "",
        description = "",
        attributes = "{}",
        location_id = null,
        photo_path = null,
        created_at = 1000L,
        updated_at = ts,
        deleted_at = del,
        device_last_modified = "",
    )

    @Test
    fun remoteNewItemIsAdded() {
        val local = MergeInput()
        val remote = MergeInput(items = listOf(item("i1", "А", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(1, r.merged.items.size)
        assertEquals(1, r.stats.added)
        assertTrue(r.conflicts.isEmpty())
    }

    @Test
    fun newerUpdateWins() {
        val local = MergeInput(items = listOf(item("i1", "старая", 1000L)))
        val remote = MergeInput(items = listOf(item("i1", "новая", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(
            "новая",
            r.merged.items
                .single()
                .name,
        )
        assertTrue(r.conflicts.isEmpty())
    }

    @Test
    fun olderRemoteUpdateLoses() {
        val local = MergeInput(items = listOf(item("i1", "своя", 2000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(
            "своя",
            r.merged.items
                .single()
                .name,
        )
        assertTrue(r.conflicts.isEmpty())
    }

    @Test
    fun equalTimestampsDifferentContentIsConflict() {
        val local = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(1, r.conflicts.size)
        val c = r.conflicts.single()
        assertEquals("items", c.table)
        assertEquals("i1", c.id)
        assertEquals("local", c.resolution)
        assertEquals(
            "своя",
            r.merged.items
                .single()
                .name,
        )
    }

    @Test
    fun equalTimestampsRemoteWinsFlag() {
        val local = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = true)
        assertEquals(
            "чужая",
            r.merged.items
                .single()
                .name,
        )
        assertEquals("remote", r.conflicts.single().resolution)
    }

    @Test
    fun deletedVsAliveNewerDeleteWins() {
        val local = MergeInput(items = listOf(item("i1", "удалена", 1000L, del = 3000L)))
        val remote = MergeInput(items = listOf(item("i1", "живая", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(
            3000L,
            r.merged.items
                .single()
                .deleted_at,
        )
    }

    @Test
    fun deletedVsAliveNewerAliveWins() {
        val local = MergeInput(items = listOf(item("i1", "удалена", 1000L, del = 1500L)))
        val remote = MergeInput(items = listOf(item("i1", "живая", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertNull(
            r.merged.items
                .single()
                .deleted_at,
        )
    }

    @Test
    fun sameRowBothSidesNoConflict() {
        val a = item("i1", "одна", 1000L)
        val local = MergeInput(items = listOf(a))
        val remote = MergeInput(items = listOf(a))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertTrue(r.conflicts.isEmpty())
        assertEquals(1, r.stats.kept)
    }

    // Отсутствие строки на другой стороне — не удаление: удаляет только tombstone
    // (deleted_at). Иначе синхронизация с неполной базой пира стирала бы данные.
    @Test
    fun rowMissingOnTheOtherSideIsKept() {
        val local = MergeInput(items = listOf(item("i1", "своя", 2000L)))
        val r = MergeEngine.merge(local, MergeInput(), remoteWins = false)
        val merged = r.merged.items.single()
        assertEquals("своя", merged.name)
        assertNull(merged.deleted_at)
    }

    private fun doc(
        id: String,
        name: String,
        ts: Long,
    ) = LabelDocEntity(
        id = id,
        name = name,
        entity_kind = "item",
        doc_json = "{}",
        is_default = false,
        created_at = 1000L,
        updated_at = ts,
        deleted_at = null,
        device_last_modified = "",
    )

    @Test
    fun labelDocsMergeNewerWins() {
        val local = MergeInput(labelDocs = listOf(doc("d1", "своя", 1000L)))
        val remote = MergeInput(labelDocs = listOf(doc("d1", "чужая", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        val merged = r.merged.labelDocs.single()
        assertEquals("чужая", merged.name)
        assertTrue(r.conflicts.isEmpty())
    }

    @Test
    fun labelDocsEqualTimestampsLoggedAsConflict() {
        val local = MergeInput(labelDocs = listOf(doc("d1", "своя", 1000L)))
        val remote = MergeInput(labelDocs = listOf(doc("d1", "чужая", 1000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        val c = r.conflicts.single()
        assertEquals("label_docs", c.table)
        assertEquals("d1", c.id)
        assertEquals("local", c.resolution)
        val merged = r.merged.labelDocs.single()
        assertEquals("своя", merged.name)
    }
}
