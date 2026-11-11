package ru.vldkr.shkaff.sync

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PeerEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Role

// T-065: сервер обязан обрезать PUSH пира к области доверия так же, как PULL.
// Пир со scope=some и ролью add не может добавлять и перезаписывать у нас
// хранилища, которые ему никогда не выдавались (до фикса ограничение
// «Федерации» работало в одну сторону).
@RunWith(RobolectricTestRunner::class)
class PeerServerPushScopeTest {

    private var seq = 0
    private fun uid(p: String) = "$p-${System.currentTimeMillis()}-${++seq}"

    private fun storage(id: String, name: String, at: Long) = StorageEntity(
        id = id, name = name, description = "", attributes = "{}", parent_id = null,
        photo_path = null, created_at = 0L, updated_at = at, deleted_at = null,
        device_last_modified = "local"
    )

    private fun location(id: String, storageId: String, at: Long) = LocationEntity(
        id = id, storage_id = storageId, parent_id = null, label = id, name = "",
        attributes = "{}", photo_path = null,
        created_at = 0L, updated_at = at, deleted_at = null, device_last_modified = "remote"
    )

    private fun item(id: String, locationId: String?, at: Long) = ItemEntity(
        id = id, name = id, code = "", description = "", attributes = "{}",
        location_id = locationId, photo_path = null,
        created_at = 0L, updated_at = at, deleted_at = null, device_last_modified = "remote"
    )

    @Before
    fun setUp() {
        MergeSession.clear()
        PeerServer.stop()
        assertNull("сервер должен встать на эфемерный порт", PeerServer.start(0))
        assertTrue(PeerServer.port > 0)
    }

    @After
    fun tearDown() {
        PeerServer.stop()
        MergeSession.clear()
    }

    // Доверие для устройства, которым стучится PeerClient (петля — тот же Deps.deviceId).
    private fun seedTrust(trust: PeerTrust) = runBlocking {
        val dao = Deps.db.peerDao()
        val now = System.currentTimeMillis()
        val existing = dao.byPeerDevice(Deps.deviceId)
        dao.upsert(
            (existing ?: PeerEntity(
                id = uid("peer"), name = "тестовый пир", peer_device_id = Deps.deviceId,
                trust = PeerTrust.toJson(PeerTrust.DEFAULT), last_synced_at = 0L,
                created_at = now, updated_at = now, deleted_at = null,
                device_last_modified = Deps.deviceId
            )).copy(trust = PeerTrust.toJson(trust), updated_at = now)
        )
    }

    // Сервер глотает исключения обработчика в lastError — поднимаем их наружу,
    // иначе отказ выглядит как «Пир не ответил» без причины.
    private fun pushOrExplain(json: String): PeerClient.PushResult = try {
        PeerClient.push("127.0.0.1", PeerServer.port, json)
    } catch (e: PeerClient.PeerException) {
        throw AssertionError("сервер: ${PeerServer.lastError ?: "без ошибки"} — ${e.message}", e)
    }

    @Test
    fun `push from a scope-some peer cannot overwrite foreign storages`() {
        val t0 = System.currentTimeMillis() - 60_000
        val t1 = System.currentTimeMillis()
        val s1 = uid("s1"); val s2 = uid("s2"); val s3 = uid("s3")
        val l2 = uid("l2"); val i2 = uid("i2"); val i0 = uid("i0")

        runBlocking {
            Deps.db.storageDao().upsert(storage(s1, "свое-разрешённое", t0))
            Deps.db.storageDao().upsert(storage(s2, "чужое-не-трогай", t0))
        }
        seedTrust(PeerTrust(Role.ADD, PeerTrust.SCOPE_SOME, listOf(s1)))

        // Пир шлёт: разрешённое s1 (новое имя), чужое s2 (переписанное), чужое s3
        // (новое), ящик и вещь под чужим s2, и вещь без ящика.
        val remote = MergeInput(
            storages = listOf(
                storage(s1, "переименовано-пиром", t1),
                storage(s2, "ВЗЛОМ", t1),
                storage(s3, "новый-чужой", t1)
            ),
            locations = listOf(location(l2, s2, t1)),
            items = listOf(item(i2, l2, t1), item(i0, null, t1))
        )

        val resp = pushOrExplain(Backup.toJson(remote))
        assertTrue("push должен пройти без конфликтов: $resp", resp.ok)

        runBlocking {
            val storages = Deps.db.storageDao().allWithDeleted().associateBy { it.id }
            assertEquals("разрешённое хранилище пир менять может",
                "переименовано-пиром", storages[s1]?.name)
            assertEquals("чужое хранилище перезаписано быть не может",
                "чужое-не-трогай", storages[s2]?.name)
            assertNull("чужое хранилище не должно добавляться", storages[s3])
            assertTrue("ящик чужого хранилища не должен добавляться",
                Deps.db.locationDao().allWithDeleted().none { it.id == l2 })
            assertTrue("вещь в чужом ящике не должна добавляться",
                Deps.db.itemDao().allWithDeleted().none { it.id == i2 })
            assertTrue("вещь без ящика всегда в области (симметрично PULL)",
                Deps.db.itemDao().allWithDeleted().any { it.id == i0 })
        }
    }

    @Test
    fun `push out of scope does not open conflicts over our own objects`() {
        val t0 = System.currentTimeMillis() - 60_000
        val s1 = uid("s1"); val s2 = uid("s2")
        runBlocking { Deps.db.storageDao().upsert(storage(s2, "наше-хранилище", t0)) }
        seedTrust(PeerTrust(Role.ADD, PeerTrust.SCOPE_SOME, listOf(s1)))

        // Тот же updated_at и другое имя — без обрезки это конфликт, где побеждает
        // пир (remoteWins), и у нас открывается экран разрешения конфликтов.
        val remote = MergeInput(storages = listOf(storage(s2, "пир перебил", t0)))
        val resp = pushOrExplain(Backup.toJson(remote))
        assertTrue("строки вне области не должны давать конфликт: $resp", resp.ok)
        assertEquals(0, resp.conflicts)
        assertNull("сессия слияния не должна открываться из-за чужих строк", MergeSession.pending)
        runBlocking {
            assertEquals("наше-хранилище", Deps.db.storageDao().byId(s2)?.name)
        }
    }

    @Test
    fun `view-role peer push is denied`() {
        seedTrust(PeerTrust(Role.VIEW, PeerTrust.SCOPE_ALL))
        val resp = PeerClient.push(
            "127.0.0.1", PeerServer.port,
            Backup.toJson(MergeInput(storages = listOf(storage(uid("s"), "x", System.currentTimeMillis()))))
        )
        assertTrue("роль без права создания обязана получить отказ", resp.denied)
        assertFalse(resp.ok)
    }
}
