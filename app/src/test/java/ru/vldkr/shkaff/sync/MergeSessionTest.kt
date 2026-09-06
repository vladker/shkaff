package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import ru.vldkr.shkaff.data.db.ItemEntity

class MergeSessionTest {

    @Before
    fun reset() {
        MergeSession.clear()
    }

    private fun item(id: String, name: String, ts: Long) = ItemEntity(
        id = id, name = name, code = "", description = "", attributes = "{}",
        location_id = null, photo_path = null,
        created_at = 1000L, updated_at = ts, deleted_at = null, device_last_modified = ""
    )

    @Test
    fun resolutionKeyFormat() {
        assertEquals("items/i1", MergeSession.resolutionKey("items", "i1"))
    }

    @Test
    fun pendingIsSetAndCleared() {
        assertNull(MergeSession.pending)
        MergeSession.start(MergeInput(), MergeInput(), MergeResult(MergeInput(), emptyList(), MergeStats()), emptyList())
        assertEquals(0, MergeSession.pending!!.result.conflicts.size)
        MergeSession.clear()
        assertNull(MergeSession.pending)
    }

    @Test
    fun applyResolutionsChoosesRemoteRow() {
        val local = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val merged = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val out = MergeSession.applyResolutions(merged, local, remote, mapOf("items/i1" to "remote"))
        assertEquals("чужая", out.items.single().name)
    }

    @Test
    fun applyResolutionsChoosesLocalRow() {
        val local = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val remote = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val merged = MergeInput(items = listOf(item("i1", "чужая", 1000L)))
        val out = MergeSession.applyResolutions(merged, local, remote, mapOf("items/i1" to "local"))
        assertEquals("своя", out.items.single().name)
    }

    @Test
    fun applyResolutionsIgnoresUnknownKeys() {
        val merged = MergeInput(items = listOf(item("i1", "своя", 1000L)))
        val out = MergeSession.applyResolutions(merged, MergeInput(), MergeInput(), mapOf("nope/1" to "remote"))
        assertEquals("своя", out.items.single().name)
    }

    @Test
    fun rowOfFindsEntityByTable() {
        val input = MergeInput(items = listOf(item("i1", "Дрель", 1000L)))
        assertEquals("Дрель", (MergeSession.rowOf(input, "items", "i1") as ItemEntity).name)
        assertNull(MergeSession.rowOf(input, "items", "other"))
    }
}
