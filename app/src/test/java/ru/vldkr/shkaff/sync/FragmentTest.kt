package ru.vldkr.shkaff.sync

import org.junit.Assert.assertEquals
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
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

@RunWith(RobolectricTestRunner::class)
class FragmentTest {

    private val now = System.currentTimeMillis()

    private fun stor(id: String, parent: String? = null) = StorageEntity(
        id = id, name = "Шкаф $id", code = id, parent_id = parent,
        created_at = now, updated_at = now
    )

    private fun loc(id: String, storage: String, parent: String? = null) = LocationEntity(
        id = id, storage_id = storage, parent_id = parent, label = id, name = id,
        created_at = now, updated_at = now
    )

    private fun item(id: String, location: String? = null, updatedAt: Long = now, tags: String = "[]") = ItemEntity(
        id = id, name = "В $id", code = id, description = "", attributes = "{}",
        photo_path = null, location_id = location, created_at = now, updated_at = updatedAt,
        deleted_at = null, device_last_modified = "", tags = tags
    )

    private val stYard = stor("yard")
    private val stRoom = stor("room", parent = "yard")
    private val locA = loc("A", "room")
    private val locA1 = loc("A1", "room", parent = "A")
    private val locA2 = loc("A2", "room", parent = "A")
    private val locB = loc("B", "room")
    private val itemInA1 = item("i1", "A1", tags = """["a"]""")
    private val itemInB = item("i2", "B")

    private fun base() = MergeInput(
        storages = listOf(stYard, stRoom),
        locations = listOf(locA, locA1, locA2, locB),
        items = listOf(itemInA1, itemInB),
        tags = listOf(TagEntity("t1", "a", now, null, ""))
    )

    @Test
    fun noopOptsReturnInputVerbatim() {
        val input = base()
        val out = Fragment.split(input, Fragment.Options())
        assertSame(input, out)
    }

    @Test
    fun locationSelectsSubtreeWithAncestors() {
        val out = Fragment.split(base(), Fragment.Options(locationIds = setOf("A")))
        assertEquals(setOf("A", "A1", "A2"), out.locations.map { it.id }.toSet())
        assertEquals(setOf("yard", "room"), out.storages.map { it.id }.toSet())
        assertEquals(listOf("i1"), out.items.map { it.id })
    }

    @Test
    fun singleLocationNoChildren() {
        val out = Fragment.split(base(), Fragment.Options(locationIds = setOf("A1")))
        assertEquals(setOf("A1", "A"), out.locations.map { it.id }.toSet())
        assertEquals(listOf("i1"), out.items.map { it.id })
    }

    @Test
    fun storageSelectIncludesAllItsBoxes() {
        val out = Fragment.split(base(), Fragment.Options(storageIds = setOf("yard")))
        // Выбранный шкаф + все ящики («room» тоже, т.к. ящики лежат в нём)
        assertTrue("room" in out.storages.map { it.id })
        assertEquals(setOf("A", "A1", "A2", "B"), out.locations.map { it.id }.toSet())
        assertEquals(listOf("i1", "i2"), out.items.map { it.id }.toSet().sorted())
    }

    @Test
    fun windowKeepsRecentItemsAndTheirPath() {
        val old = now - 30L * Fragment.DAY_MS
        val inp = base().copy(
            items = listOf(item("fresh", "A1", now), item("stale", "B", old)),
            locations = listOf(locA, locA1, locA2, locB),
            storages = listOf(stYard, stRoom)
        )
        val out = Fragment.split(inp, Fragment.Options(windowDays = 7))
        assertEquals(listOf("fresh"), out.items.map { it.id })
        assertEquals(setOf("A", "A1"), out.locations.map { it.id }.toSet())
        assertEquals(setOf("yard", "room"), out.storages.map { it.id }.toSet())
    }

    @Test
    fun splitKeepsFragmentSelfValid() {
        val inp = base().copy(
            annotations = listOf(AnnotationEntity("an1", "room", "A2", created_at = now, updated_at = now)),
            loans = listOf(LoanEntity("ln1", "item", "i1", "Вася", lent_at = now, created_at = now, updated_at = now)),
            stacks = listOf(StackEntity("sk1", "Стек", created_at = now, updated_at = now)),
            stackMembers = listOf(StackMemberEntity("sm1", "sk1", "item", "i1", created_at = now, updated_at = now)),
            baskets = listOf(BasketEntity("bk1", "Вынос", created_at = now, updated_at = now)),
            basketItems = listOf(BasketItemEntity("bi1", "bk1", "i1", created_at = now, updated_at = now))
        )
        val out = Fragment.split(inp, Fragment.Options(locationIds = setOf("A")))
        assertTrue(out.annotations.all { it.storage_id in out.storages.map { s -> s.id } })
        assertTrue(out.items.all { it.location_id == null || it.location_id in out.locations.map { l -> l.id } })
        assertTrue(out.locations.all { it.storage_id in out.storages.map { s -> s.id } })
        assertTrue(out.locations.all { it.parent_id == null || it.parent_id in out.locations.map { l -> l.id } })
        assertTrue(out.stackMembers.all { it.stack_id in out.stacks.map { s -> s.id } })
        assertTrue(out.basketItems.all { it.basket_id in out.baskets.map { b -> b.id } })
        assertTrue(out.loans.any { it.id == "ln1" })
    }

    @Test
    fun globalsKeptIntact() {
        val out = Fragment.split(base(), Fragment.Options(locationIds = setOf("A")))
        // Словари-конфиг (users/defs/templates/printers) не режем — в базе теста их нет,
        // но tags ограничены попавшими вещами.
        assertEquals(listOf("a"), out.tags.map { it.name })
    }
}