package ru.vldkr.shkaff.domain.actions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.LocationData
import ru.vldkr.shkaff.domain.StorageData
import ru.vldkr.shkaff.domain.access.ActiveRole

// US-R: пакетный перенос выбранных вещей в ящик. Движок — ItemRepository.batchMove /
// undoBatchMove: гейт права перекладки, updated_at++ для LWW, action_log по записи на
// вещь, undo payload с прежними location_id/updated_at/device_last_modified.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class BatchMoveTest {
    private fun rid(p: String) = "$p-" + System.nanoTime()

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        runBlocking { Deps.db.clearAllTables() }
        ActiveRole.set("admin")
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
        // ActiveRole — глобальный object: без возврата к admin просачивается между тестами.
        ActiveRole.set("admin")
    }

    @Test
    fun `batchMove обновляет location_id и updated_at у всех выбранных`() =
        runBlocking {
            val store = Deps.storages.create(StorageData(name = rid("store")))
            val a = Deps.locations.create(LocationData(storageId = store.id, name = rid("box-a")))
            val b = Deps.locations.create(LocationData(storageId = store.id, name = rid("box-b")))
            val target = Deps.locations.create(LocationData(storageId = store.id, name = rid("target")))
            val i1 = Deps.items.create(ItemData(name = rid("i1"), locationId = a.id))
            val i2 = Deps.items.create(ItemData(name = rid("i2"), locationId = b.id))
            val i3 = Deps.items.create(ItemData(name = rid("i3"), locationId = b.id))
            Thread.sleep(10) // updated_at — мс; без паузы «строго больше» может не сработать

            val res = Deps.items.batchMove(listOf(i1.id, i2.id), target.id)

            assertEquals(listOf(i1.id, i2.id), res.moved)
            assertEquals(emptyList<String>(), res.skipped)
            for (id in listOf(i1.id, i2.id)) {
                val after = Deps.db.itemDao().byId(id)!!
                assertEquals("вещь должна переехать в целевой ящик", target.id, after.location_id)
            }
            for (before in listOf(i1, i2)) {
                val after = Deps.db.itemDao().byId(before.id)!!
                assertTrue("updated_at обязан вырасти — от него зависит LWW слияния", after.updated_at > before.updated_at)
            }
            val untouched = Deps.db.itemDao().byId(i3.id)!!
            assertEquals("невыбранная вещь остаётся в своём ящике", b.id, untouched.location_id)
            assertEquals("у невыбранной вещи updated_at не меняется", i3.updated_at, untouched.updated_at)
        }

    @Test
    fun `batchMove пропускает удалённые и несуществующие`() =
        runBlocking {
            val store = Deps.storages.create(StorageData(name = rid("store")))
            val src = Deps.locations.create(LocationData(storageId = store.id, name = rid("src")))
            val target = Deps.locations.create(LocationData(storageId = store.id, name = rid("target")))
            val live = Deps.items.create(ItemData(name = rid("live"), locationId = src.id))
            val gone = Deps.items.create(ItemData(name = rid("gone"), locationId = src.id))
            Deps.items.softDelete(gone.id)
            val before = Deps.db.itemDao().byId(gone.id)!!
            Thread.sleep(10)

            val res = Deps.items.batchMove(listOf(live.id, gone.id, "нет-такого-id"), target.id)

            assertEquals(listOf(live.id), res.moved)
            assertEquals("мягко удалённая и несуществующая — в skipped", listOf(gone.id, "нет-такого-id"), res.skipped)
            val after = Deps.db.itemDao().byId(gone.id)!!
            assertEquals("удалённая вещь не переезжает", before.location_id, after.location_id)
            assertEquals("у удалённой вещи updated_at не меняется", before.updated_at, after.updated_at)
        }

    @Test
    fun `batchMove требует право перекладки`() =
        runBlocking {
            val store = Deps.storages.create(StorageData(name = rid("store")))
            val src = Deps.locations.create(LocationData(storageId = store.id, name = rid("src")))
            val target = Deps.locations.create(LocationData(storageId = store.id, name = rid("target")))
            val i1 = Deps.items.create(ItemData(name = rid("i1"), locationId = src.id))
            Thread.sleep(10)

            for (role in listOf("view", "add")) {
                ActiveRole.set(role)
                var thrown: Exception? = null
                try {
                    Deps.items.batchMove(listOf(i1.id), target.id)
                } catch (e: IllegalStateException) {
                    thrown = e
                } catch (e: SecurityException) {
                    thrown = e
                }
                assertTrue("профиль '$role' не имеет права перекладки", thrown != null)
                val after = Deps.db.itemDao().byId(i1.id)!!
                assertEquals("в БД ничего не изменилось ($role)", src.id, after.location_id)
                assertEquals("в БД ничего не изменилось ($role)", i1.updated_at, after.updated_at)
            }

            ActiveRole.set("move")
            val res = Deps.items.batchMove(listOf(i1.id), target.id)
            assertEquals(listOf(i1.id), res.moved)
            assertEquals(
                target.id,
                Deps.db
                    .itemDao()
                    .byId(i1.id)!!
                    .location_id,
            )
        }

    @Test
    fun `batchMove пишет action_log по записи на каждую перемещённую вещь`() =
        runBlocking {
            val store = Deps.storages.create(StorageData(name = rid("store")))
            val a = Deps.locations.create(LocationData(storageId = store.id, name = rid("box-a")))
            val b = Deps.locations.create(LocationData(storageId = store.id, name = rid("box-b")))
            val target = Deps.locations.create(LocationData(storageId = store.id, name = rid("target")))
            val i1 = Deps.items.create(ItemData(name = rid("i1"), locationId = a.id))
            val i2 = Deps.items.create(ItemData(name = rid("i2"), locationId = b.id))
            Thread.sleep(10)

            Deps.items.batchMove(listOf(i1.id, i2.id), target.id)

            val log =
                Deps.db
                    .actionLogDao()
                    .observeRecent(50)
                    .first()
            for (id in listOf(i1.id, i2.id)) {
                val entries = log.filter { it.action == "move" && it.entity_type == "item" && it.entity_id == id }
                assertEquals("ровно одна запись move на вещь $id", 1, entries.size)
            }
        }

    @Test
    fun `undo payload возвращает прежние значения, undoBatchMove их восстанавливает`() =
        runBlocking {
            val store = Deps.storages.create(StorageData(name = rid("store")))
            val src = Deps.locations.create(LocationData(storageId = store.id, name = rid("src")))
            val target = Deps.locations.create(LocationData(storageId = store.id, name = rid("target")))
            val i1 = Deps.items.create(ItemData(name = rid("i1"), locationId = src.id))
            Thread.sleep(10)

            val res = Deps.items.batchMove(listOf(i1.id), target.id)
            assertEquals(
                target.id,
                Deps.db
                    .itemDao()
                    .byId(i1.id)!!
                    .location_id,
            )

            val u = res.undo.single()
            assertEquals("undo payload хранит прежний ящик", src.id, u.prevLocationId)
            assertEquals("undo payload хранит прежний updated_at", i1.updated_at, u.prevUpdatedAt)
            assertEquals("undo payload хранит прежний device_last_modified", i1.device_last_modified, u.prevDeviceLastModified)

            Deps.items.undoBatchMove(res.undo)

            val back = Deps.db.itemDao().byId(i1.id)!!
            assertEquals(src.id, back.location_id)
            assertEquals(i1.updated_at, back.updated_at)
            assertEquals(i1.device_last_modified, back.device_last_modified)
        }
}
