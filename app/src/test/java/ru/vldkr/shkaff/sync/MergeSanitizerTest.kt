package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity

class MergeSanitizerTest {

    private fun storage(id: String, parent: String? = null) = StorageEntity(
        id = id, name = id, description = "", attributes = "{}", parent_id = parent,
        photo_path = null, created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun location(id: String, storageId: String, parent: String? = null) = LocationEntity(
        id = id, storage_id = storageId, parent_id = parent, label = id, name = "",
        attributes = "{}", photo_path = null,
        created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun item(id: String, locationId: String? = null) = ItemEntity(
        id = id, name = id, code = "", description = "", attributes = "{}",
        location_id = locationId, photo_path = null,
        created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun anno(id: String, storageId: String, locationId: String) = AnnotationEntity(
        id = id, storage_id = storageId, location_id = locationId,
        shape = "rect", points = "[]", label = "", color = "#FFB300", z_order = 0,
        created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    @Test
    fun orphanStorageParentIsUnnested() {
        val input = MergeInput(storages = listOf(storage("s1", parent = "ghost")))
        val r = MergeSanitizer.sanitize(input)
        assertNull(r.merged.storages.single().parent_id)
        assertEquals(1, r.warnings.size)
    }

    @Test
    fun locationWithoutStorageIsDropped() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            locations = listOf(location("l1", storageId = "ghost"))
        )
        val r = MergeSanitizer.sanitize(input)
        assertTrue(r.merged.locations.isEmpty())
        assertTrue(r.warnings.any { it.contains("без шкафа") })
    }

    @Test
    fun orphanLocationParentIsUnnested() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            locations = listOf(location("l1", "s1"), location("l2", "s1", parent = "ghost"))
        )
        val r = MergeSanitizer.sanitize(input)
        assertEquals(null, r.merged.locations.first { it.id == "l2" }.parent_id)
    }

    @Test
    fun itemWithoutLocationKeptWithoutLocation() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            items = listOf(item("i1", locationId = "ghost"))
        )
        val r = MergeSanitizer.sanitize(input)
        assertEquals(null, r.merged.items.single().location_id)
        assertTrue(r.warnings.any { it.contains("без ящика") })
    }

    @Test
    fun annotationWithoutOwnerDropped() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            locations = listOf(location("l1", "s1")),
            annotations = listOf(anno("a1", "s1", "ghost"), anno("a2", "ghost", "l1"))
        )
        val r = MergeSanitizer.sanitize(input)
        assertTrue(r.merged.annotations.isEmpty())
    }

    @Test
    fun consistentInputPassesThrough() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            locations = listOf(location("l1", "s1")),
            items = listOf(item("i1", "l1")),
            annotations = listOf(anno("a1", "s1", "l1"))
        )
        val r = MergeSanitizer.sanitize(input)
        assertTrue(r.warnings.isEmpty())
        assertEquals(1, r.merged.items.size)
        assertEquals("l1", r.merged.items.single().location_id)
    }
}
