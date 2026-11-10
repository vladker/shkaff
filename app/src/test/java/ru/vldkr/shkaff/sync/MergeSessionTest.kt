package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.data.db.TagEntity
import ru.vldkr.shkaff.data.db.UserEntity

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

    // T-066: движок конфликтует все 15 таблиц, а rowOf/replaceRow знали только 8.
    private fun tag(id: String, name: String, created: Long) = TagEntity(
        id = id, name = name, created_at = created, deleted_at = null, device_last_modified = ""
    )

    private fun user(id: String, name: String, role: String, ts: Long) = UserEntity(
        id = id, name = name, role = role, permissions = "[]",
        created_at = 1000L, updated_at = ts, deleted_at = null, device_last_modified = ""
    )

    private fun loan(id: String, borrower: String, ts: Long) = LoanEntity(
        id = id, entity_type = "item", entity_id = "i1", borrower = borrower, note = "",
        lent_at = 1000L, due_at = null, returned_at = null,
        created_at = 1000L, updated_at = ts, device_last_modified = ""
    )

    private fun stack(id: String, name: String, ts: Long) = StackEntity(
        id = id, name = name, description = "", code = "",
        created_at = 1000L, updated_at = ts, deleted_at = null, device_last_modified = ""
    )

    private fun stackMember(id: String, stackId: String, entityId: String, sort: Int, ts: Long) = StackMemberEntity(
        id = id, stack_id = stackId, entity_type = "item", entity_id = entityId, sort_order = sort,
        created_at = 1000L, updated_at = ts, deleted_at = null, device_last_modified = ""
    )

    private fun basket(id: String, name: String, status: String, ts: Long) = BasketEntity(
        id = id, name = name, status = status,
        created_at = 1000L, updated_at = ts, deleted_at = null, device_last_modified = ""
    )

    private fun basketItem(id: String, basketId: String, itemId: String, picked: Long?, ts: Long) = BasketItemEntity(
        id = id, basket_id = basketId, item_id = itemId, picked_ts = picked,
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

    @Test
    fun tagsConflictResolutionHonored() {
        val local = MergeInput(tags = listOf(tag("t1", "гараж", 1000L)))
        val remote = MergeInput(tags = listOf(tag("t1", "гаражный", 1000L)))
        val result = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(1, result.conflicts.size)
        assertEquals("tags", result.conflicts.single().table)
        val out = MergeSession.applyResolutions(
            result.merged, local, remote,
            mapOf(MergeSession.resolutionKey("tags", "t1") to "remote")
        )
        assertEquals("гаражный", out.tags.single().name)
    }

    @Test
    fun loansConflictResolutionHonored() {
        val local = MergeInput(loans = listOf(loan("l1", "Анна", 1000L)))
        val remote = MergeInput(loans = listOf(loan("l1", "Борис", 1000L)))
        val result = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(1, result.conflicts.size)
        assertEquals("loans", result.conflicts.single().table)
        val out = MergeSession.applyResolutions(
            result.merged, local, remote,
            mapOf(MergeSession.resolutionKey("loans", "l1") to "remote")
        )
        assertEquals("Борис", out.loans.single().borrower)
    }

    @Test
    fun allSevenGapTablesResolveBothWays() {
        val ts = 1000L
        val local = MergeInput(
            tags = listOf(tag("t1", "гараж", ts)),
            users = listOf(user("u1", "Анна", "admin", ts)),
            loans = listOf(loan("l1", "Анна", ts)),
            stacks = listOf(stack("s1", "Набор А", ts)),
            stackMembers = listOf(stackMember("m1", "s1", "i9", 1, ts)),
            baskets = listOf(basket("b1", "Ремонт", "active", ts)),
            basketItems = listOf(basketItem("bi1", "b1", "i9", null, ts)),
        )
        val remote = MergeInput(
            tags = listOf(tag("t1", "гаражный", ts)),
            users = listOf(user("u1", "Пётр", "add", ts)),
            loans = listOf(loan("l1", "Борис", ts)),
            stacks = listOf(stack("s1", "Набор Б", ts)),
            stackMembers = listOf(stackMember("m1", "s1", "i9", 7, ts)),
            baskets = listOf(basket("b1", "Дача", "done", ts)),
            basketItems = listOf(basketItem("bi1", "b1", "i9", 500L, ts)),
        )
        val result = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals(7, result.conflicts.size)
        val keys = result.conflicts.map { MergeSession.resolutionKey(it.table, it.id) }.toSet()
        assertEquals(
            setOf("tags/t1", "users/u1", "loans/l1", "stacks/s1", "stack_members/m1", "baskets/b1", "basket_items/bi1"),
            keys
        )

        val remoteChosen = MergeSession.applyResolutions(
            result.merged, local, remote, keys.associateWith { "remote" }
        )
        assertEquals("гаражный", remoteChosen.tags.single().name)
        assertEquals("Пётр", remoteChosen.users.single().name)
        assertEquals("Борис", remoteChosen.loans.single().borrower)
        assertEquals("Набор Б", remoteChosen.stacks.single().name)
        assertEquals(7, remoteChosen.stackMembers.single().sort_order)
        assertEquals("Дача", remoteChosen.baskets.single().name)
        assertEquals(500L, remoteChosen.basketItems.single().picked_ts)

        val localChosen = MergeSession.applyResolutions(
            result.merged, local, remote, keys.associateWith { "local" }
        )
        assertEquals("гараж", localChosen.tags.single().name)
        assertEquals("Анна", localChosen.users.single().name)
        assertEquals("Анна", localChosen.loans.single().borrower)
        assertEquals("Набор А", localChosen.stacks.single().name)
        assertEquals(1, localChosen.stackMembers.single().sort_order)
        assertEquals("Ремонт", localChosen.baskets.single().name)
        assertNull(localChosen.basketItems.single().picked_ts)
    }
}
