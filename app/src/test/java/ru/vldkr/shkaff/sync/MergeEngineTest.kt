package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.data.db.ItemEntity

class MergeEngineTest {

    private fun item(id: String, name: String, ts: Long, del: Long? = null) = ItemEntity(
        id = id, name = name, code = "", description = "", attributes = "{}",
        location_id = null, photo_path = null,
        created_at = 1000L, updated_at = ts, deleted_at = del, device_last_modified = ""
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
        assertEquals("новая", r.merged.items.single().name)
        assertTrue(r.conflicts.isEmpty())
    }

    @Test
    fun olderRemoteUpdateLoses() {
        val local = MergeInput(items = listOf(item("i1", "своя", 2000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals("своя", r.merged.items.single().name)
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
        assertEquals("своя", r.merged.items.single().name)
    }

    @Test
    fun equalTimestampsRemoteWinsFlag() {
        val local = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = true)
        assertEquals("чужая", r.merged.items.single().name)
        assertEquals("remote", r.conflicts.single().resolution)
    }

    @Test
    fun deletedVsAliveNewerDeleteWins() {
        val local = MergeInput(items = listOf(item("i1", "удалена", 1000L, del = 3000L)))
        val remote = MergeInput(items = listOf(item("i1", "живая", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(3000L, r.merged.items.single().deleted_at)
    }

    @Test
    fun deletedVsAliveNewerAliveWins() {
        val local = MergeInput(items = listOf(item("i1", "удалена", 1000L, del = 1500L)))
        val remote = MergeInput(items = listOf(item("i1", "живая", 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertNull(r.merged.items.single().deleted_at)
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
}
