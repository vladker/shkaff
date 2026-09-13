package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.data.db.TagEntity
import ru.vldkr.shkaff.data.db.UserEntity
import ru.vldkr.shkaff.domain.access.Role

class PeerScopeTest {

    private fun storage(id: String, parent: String? = null) = StorageEntity(
        id = id, name = id, description = "", attributes = "{}", parent_id = parent,
        photo_path = null, created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun location(id: String, storageId: String) = LocationEntity(
        id = id, storage_id = storageId, parent_id = null, label = id, name = "",
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

    private fun loan(id: String, type: String, entityId: String) = LoanEntity(
        id = id, entity_type = type, entity_id = entityId, borrower = "bob",
        note = "", lent_at = 0L, due_at = null, returned_at = null,
        created_at = 0L, updated_at = 0L, device_last_modified = ""
    )

    private fun stack(id: String) = StackEntity(
        id = id, name = id, description = "", code = id,
        created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun member(id: String, stackId: String, type: String, entityId: String) = StackMemberEntity(
        id = id, stack_id = stackId, entity_type = type, entity_id = entityId,
        sort_order = 0, created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun basket(id: String) = BasketEntity(
        id = id, name = id, status = "active",
        created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun basketItem(id: String, basketId: String, itemId: String) = BasketItemEntity(
        id = id, basket_id = basketId, item_id = itemId,
        picked_ts = null, created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = ""
    )

    private fun tag(id: String) = TagEntity(id = id, name = id, created_at = 0L, deleted_at = null, device_last_modified = "")

    private fun user(id: String) = UserEntity(id = id, name = id, role = "view", permissions = "[]",
        created_at = 0L, updated_at = 0L, deleted_at = null, device_last_modified = "")

    private fun some(vararg ids: String) = PeerTrust(Role.VIEW, PeerTrust.SCOPE_SOME, ids.toList())

    @Test
    fun allScopePassesThroughUnchanged() {
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2")),
            locations = listOf(location("l1", "s2")),
            items = listOf(item("i1", "l1"))
        )
        val r = PeerScope.apply(input, PeerTrust.DEFAULT)
        assertEquals(input, r)
    }

    @Test
    fun subtreeOfAllowedStorageKeptAndUnnested() {
        // s1 -> s2 -> s3; разрешён только s2 — с3 остаётся, с1 вылетает, s2 выносится наверх.
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2", "s1"), storage("s3", "s2"))
        )
        val r = PeerScope.apply(input, some("s2"))
        assertEquals(setOf("s2", "s3"), r.storages.map { it.id }.toSet())
        assertNull(r.storages.first { it.id == "s2" }.parent_id)
        assertEquals("s2", r.storages.first { it.id == "s3" }.parent_id)
    }

    @Test
    fun locationsAndItemsOutsideScopeDropped() {
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2")),
            locations = listOf(location("l1", "s1"), location("l2", "s2")),
            items = listOf(item("i1", "l1"), item("i2", "l2"))
        )
        val r = PeerScope.apply(input, some("s2"))
        assertEquals(listOf("l2"), r.locations.map { it.id })
        assertEquals(listOf("i2"), r.items.map { it.id })
    }

    @Test
    fun itemWithoutLocationAlwaysKept() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            items = listOf(item("i0", null), item("i1", "ghost"))
        )
        val r = PeerScope.apply(input, some("s1"))
        // «Вещь без ящика» всегда видна; ящик «ghost» вне области — вещь с ним вылетает.
        assertEquals(listOf("i0"), r.items.map { it.id })
    }

    @Test
    fun annotationsOutsideScopeDropped() {
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2")),
            locations = listOf(location("l1", "s1"), location("l2", "s2")),
            annotations = listOf(anno("a1", "s1", "l1"), anno("a2", "s2", "l2"))
        )
        val r = PeerScope.apply(input, some("s2"))
        assertEquals(listOf("a2"), r.annotations.map { it.id })
    }

    @Test
    fun stackTrimmedToAllowedObjects() {
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2")),
            locations = listOf(location("l1", "s1")),
            items = listOf(item("i1", "l1")),
            stacks = listOf(stack("st1")),
            stackMembers = listOf(
                member("m1", "st1", "item", "i1"),      // вещь вне области
                member("m2", "st1", "storage", "s2")     // хранилище внутри области
            )
        )
        val r = PeerScope.apply(input, some("s2"))
        assertTrue(r.items.isEmpty())
        assertEquals(listOf("m2"), r.stackMembers.map { it.id })
        assertEquals(listOf("st1"), r.stacks.map { it.id })
    }

    @Test
    fun stackWithoutAllowedMembersDropped() {
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2")),
            locations = listOf(location("l1", "s1")),
            items = listOf(item("i1", "l1")),
            stacks = listOf(stack("st1")),
            stackMembers = listOf(member("m1", "st1", "item", "i1"))
        )
        val r = PeerScope.apply(input, some("s2"))
        assertTrue(r.stackMembers.isEmpty())
        assertTrue(r.stacks.isEmpty())
    }

    @Test
    fun loansTrimmedToScope() {
        val input = MergeInput(
            storages = listOf(storage("s1"), storage("s2")),
            locations = listOf(location("l1", "s1")),
            items = listOf(item("i1", "l1")),
            loans = listOf(loan("lo1", "item", "i1"), loan("lo2", "storage", "s2"))
        )
        val r = PeerScope.apply(input, some("s2"))
        assertEquals(listOf("lo2"), r.loans.map { it.id })
    }

    @Test
    fun basketsTrimmedToScope() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            items = listOf(item("i1")),
            baskets = listOf(basket("b1"), basket("b2")),
            basketItems = listOf(basketItem("bi1", "b1", "i1"), basketItem("bi2", "b2", "gone"))
        )
        val r = PeerScope.apply(input, some("s1"))
        assertEquals(listOf("bi1"), r.basketItems.map { it.id })
        assertEquals(listOf("b1"), r.baskets.map { it.id })
    }

    @Test
    fun globalTablesPassThrough() {
        val input = MergeInput(
            storages = listOf(storage("s1")),
            tags = listOf(tag("t1")),
            users = listOf(user("u1"))
        )
        val r = PeerScope.apply(input, some("s2"))
        assertEquals(listOf("t1"), r.tags.map { it.id })
        assertEquals(listOf("u1"), r.users.map { it.id })
    }
}
