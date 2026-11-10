package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.LocationData
import ru.vldkr.shkaff.domain.StorageData

// T-041: мягкое удаление ящика обязано снимать location_id с его вещей (обещание
// диалога удаления «вещи останутся как без ящика») — иначе вещь выпадает и из ящика,
// и из выборки «без места»: её id ссылается на скрытый ящик.
@RunWith(RobolectricTestRunner::class)
class LocationGhostTest {

    private fun rid(p: String) = "$p-" + System.nanoTime()

    @Test
    fun `deleting a box detaches its live items to no-place and returns ids for undo`() = runBlocking {
        val store = Deps.storages.create(StorageData(name = rid("t041-store")))
        val box = Deps.locations.create(LocationData(storageId = store.id, name = rid("t041-box")))
        val item = Deps.items.create(ItemData(name = rid("t041-item"), locationId = box.id))
        Deps.items.create(ItemData(name = rid("t041-loose"))) // без места — не должна «переехать» в ящик
        Thread.sleep(10)

        val detached = Deps.locations.softDelete(box.id)

        assertEquals("id отцепленной вещи возвращается для Undo", listOf(item.id), detached)
        val after = Deps.items.byId(item.id)!!
        assertNull("вещь не должна ссылаться на удалённый ящик", after.location_id)
        assertTrue("updated_at обязан вырасти — от него зависит LWW слияния", after.updated_at > item.updated_at)
        assertTrue("мягко удалённый ящик скрыт из живых", Deps.locations.observeAll().first().none { it.id == box.id })
    }

    @Test
    fun `undo restores the box and returns its items back`() = runBlocking {
        val store = Deps.storages.create(StorageData(name = rid("t041-store")))
        val box = Deps.locations.create(LocationData(storageId = store.id, name = rid("t041-box")))
        val item = Deps.items.create(ItemData(name = rid("t041-item"), locationId = box.id))

        val detached = Deps.locations.softDelete(box.id)
        assertNull(Deps.items.byId(item.id)!!.location_id)

        Deps.locations.restore(box.id, detached)

        assertEquals("после Undo вещь снова в ящике", box.id, Deps.items.byId(item.id)!!.location_id)
        assertEquals("ящик снова жив", null, Deps.locations.byId(box.id)!!.deleted_at)
    }

    @Test
    fun `items of nested boxes are not touched when the parent box is deleted`() = runBlocking {
        val store = Deps.storages.create(StorageData(name = rid("t041-store")))
        val outer = Deps.locations.create(LocationData(storageId = store.id, name = rid("t041-outer")))
        val inner = Deps.locations.create(LocationData(storageId = store.id, parentId = outer.id, name = rid("t041-inner")))
        val innerItem = Deps.items.create(ItemData(name = rid("t041-item"), locationId = inner.id))

        Deps.locations.softDelete(outer.id)

        assertEquals(
            "вложенный ящик жив — его вещь остаётся в нём",
            inner.id, Deps.items.byId(innerItem.id)!!.location_id
        )
    }

    @Test
    fun `soft-deleted items are unbound too but not returned by undo`() = runBlocking {
        val store = Deps.storages.create(StorageData(name = rid("t041-store")))
        val box = Deps.locations.create(LocationData(storageId = store.id, name = rid("t041-box")))
        val gone = Deps.items.create(ItemData(name = rid("t041-gone"), locationId = box.id))
        Deps.items.softDelete(gone.id)

        val detached = Deps.locations.softDelete(box.id)

        assertEquals("мёртвая вещь не участвует в Undo", emptyList<String>(), detached)
        assertEquals(
            "удалённая вещь тоже не должна остаться «призраком» на случай возврата",
            null, Deps.items.byId(gone.id)!!.location_id
        )
    }
}
