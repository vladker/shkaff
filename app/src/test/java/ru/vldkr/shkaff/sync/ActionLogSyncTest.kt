package ru.vldkr.shkaff.sync

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ActionLogEntity
import ru.vldkr.shkaff.di.Deps

/**
 * T-073: журнал действий (action_log) участвует в пир-синхронизации — общая семейная
 * лента (US-F2). Журнал append-only: слияние по id не порождает конфликтов, повторный
 * upsert идемпотентен.
 */
class ActionLogSyncTest {
    private fun act(
        id: String,
        action: String = "update",
        at: Long = 1000L,
        detail: String = "{}",
    ) = ActionLogEntity(
        id = id,
        user_id = "u1",
        user_name = "Аня",
        action = action,
        entity_type = "item",
        entity_id = "i1",
        detail = detail,
        at = at,
        device_id = "dev-1",
    )

    @Test
    fun unionMergeCombinesEntriesFromBothPeers() {
        val local = MergeInput(actionLogs = listOf(act("a1"), act("a2", detail = """{"who":"local"}""")))
        val remote = MergeInput(actionLogs = listOf(act("a2", detail = """{"who":"remote"}"""), act("a3", at = 2000L)))
        val r = MergeEngine.merge(local, remote, remoteWins = true)
        assertEquals(
            listOf("a1", "a2", "a3"),
            r.merged.actionLogs
                .map { it.id }
                .sorted(),
        )
        assertTrue(r.conflicts.isEmpty())
        // Строки неизменяемы, но при расхождении остаётся локальная версия.
        assertEquals(
            """{"who":"local"}""",
            r.merged.actionLogs
                .first { it.id == "a2" }
                .detail,
        )
        assertEquals(1, r.stats.added)
        assertEquals(1, r.stats.kept)
    }

    @Test
    fun duplicateIdsAreIdempotent() {
        val local = MergeInput(actionLogs = listOf(act("a1"), act("a2")))
        val remote = MergeInput(actionLogs = listOf(act("a2"), act("a3")))
        val once = MergeEngine.merge(local, remote, remoteWins = false)
        val twice = MergeEngine.merge(once.merged, remote, remoteWins = false)
        assertEquals(
            once.merged.actionLogs
                .map { it.id }
                .toSet(),
            twice.merged.actionLogs
                .map { it.id }
                .toSet(),
        )
        assertTrue(once.conflicts.isEmpty())
        assertTrue(twice.conflicts.isEmpty())
    }

    @Test
    fun mergeProducesNoConflictsForActionLog() {
        val local = MergeInput(actionLogs = listOf(act("a1", at = 1000L, detail = """{"local":true}""")))
        val remote = MergeInput(actionLogs = listOf(act("a1", at = 1000L, detail = """{"remote":true}""")))
        val r = MergeEngine.merge(local, remote, remoteWins = true)
        assertTrue(r.conflicts.isEmpty())
        assertEquals(
            """{"local":true}""",
            r.merged.actionLogs
                .single()
                .detail,
        )
    }
}

@RunWith(RobolectricTestRunner::class)
class ActionLogBackupSyncTest {
    private fun act(
        id: String,
        action: String = "update",
        at: Long = 1000L,
        detail: String = "{}",
        userId: String? = "u1",
    ) = ActionLogEntity(
        id = id,
        user_id = userId,
        user_name = if (userId == null) "" else "Аня",
        action = action,
        entity_type = "item",
        entity_id = "i1",
        detail = detail,
        at = at,
        device_id = "dev-1",
    )

    @Test
    fun backupRoundTripKeepsActionLogs() {
        val input =
            MergeInput(
                actionLogs =
                    listOf(
                        act("a1"),
                        act("a2", action = "service", at = 2000L, detail = """{"peer":"PULL"}""", userId = null),
                    ),
            )
        val back = Backup.fromJson(Backup.toJson(input))
        assertEquals(input.actionLogs, back.actionLogs)
    }
}

@RunWith(RobolectricTestRunner::class)
class ActionLogApplyMergeTest {
    private fun act(
        id: String,
        action: String = "update",
        at: Long = 1000L,
    ) = ActionLogEntity(
        id = id,
        user_id = "u1",
        user_name = "Аня",
        action = action,
        entity_type = "item",
        entity_id = "i1",
        detail = "{}",
        at = at,
        device_id = "dev-1",
    )

    @Before
    fun clear() {
        runBlocking { Deps.db.clearAllTables() }
    }

    @Test
    fun applyMergeUpsertsAndSecondApplyIsNoOp() {
        val local = MergeInput(actionLogs = listOf(act("a1"), act("s1", action = "service")))
        val remote = MergeInput(actionLogs = listOf(act("a1"), act("a2", at = 2000L)))
        val result = MergeEngine.merge(local, remote, remoteWins = false)

        runBlocking {
            Backup.applyMerge(result, Deps.db)
            assertEquals(
                setOf("a1", "a2", "s1"),
                Deps.db
                    .actionLogDao()
                    .all()
                    .map { it.id }
                    .toSet(),
            )
            // Повторный applyMerge (петля PULL/PUSH) ничего не дублирует и не теряет.
            Backup.applyMerge(result, Deps.db)
            assertEquals(
                3,
                Deps.db
                    .actionLogDao()
                    .all()
                    .size,
            )
            // Retention чистит старые записи.
            Deps.db.actionLogDao().deleteOlderThan(System.currentTimeMillis())
            assertEquals(
                0,
                Deps.db
                    .actionLogDao()
                    .all()
                    .size,
            )
        }
    }
}
