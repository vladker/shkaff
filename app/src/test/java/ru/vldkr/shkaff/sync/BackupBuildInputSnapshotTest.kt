package ru.vldkr.shkaff.sync

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

/**
 * T-068: Backup.buildInput обязан снимать все таблицы внутри одной транзакции.
 *
 * Дискриминатор: обёртка над queryExecutor во время замеряемого buildInput смотрит,
 * открыта ли в SQLite транзакция в момент диспатча чтения. Без `db.withTransaction`
 * каждая DAO-читка уходит на queryExecutor без транзакции (снимок «рвётся»: правка,
 * попавшая между чтениями, даёт смешанную версию). Внутри транзакции чтения идут на
 * поток транзакции и к queryExecutor не приходят вовсе; счётчик transactionExecutor
 * доказывает, что транзакция действительно открывалась (непустота проверки).
 *
 * Первый buildInput — прогрев: после сидящей записи InvalidationTracker разово
 * дёргает queryExecutor для проверки версий таблиц — это не чтение снимка.
 */
@RunWith(RobolectricTestRunner::class)
class BackupBuildInputSnapshotTest {
    private val item =
        ItemEntity(
            id = "i1",
            name = "Дрель",
            code = "DR-1",
            description = "",
            attributes = "{}",
            location_id = null,
            photo_path = null,
            created_at = 1L,
            updated_at = 2L,
            deleted_at = null,
            device_last_modified = "dev",
        )

    @Test
    fun buildInputReadsAllTablesInsideTransaction() =
        runBlocking {
            val ctx = ApplicationProvider.getApplicationContext<Context>()
            val readsOutsideTx = CopyOnWriteArrayList<Int>()
            val txRuns = AtomicInteger()
            val recording = AtomicBoolean(false)
            lateinit var db: ShkaffDatabase
            val qExec =
                Executor { r ->
                    if (recording.get()) {
                        val inTx = runCatching { db.openHelper.readableDatabase.inTransaction() }.getOrDefault(false)
                        if (!inTx) readsOutsideTx += 1
                    }
                    r.run()
                }
            val txExec =
                Executor { r ->
                    txRuns.incrementAndGet()
                    r.run()
                }
            db =
                Room
                    .inMemoryDatabaseBuilder(ctx, ShkaffDatabase::class.java)
                    .setQueryExecutor(qExec)
                    .setTransactionExecutor(txExec)
                    .allowMainThreadQueries()
                    .build()
            try {
                db.itemDao().upsertAll(listOf(item))
                Backup.buildInput(db) // прогрев: сбрасываем разовый шум InvalidationTracker
                readsOutsideTx.clear()
                txRuns.set(0)
                recording.set(true)
                val input =
                    try {
                        Backup.buildInput(db)
                    } finally {
                        recording.set(false)
                    }
                // Снимок непустой — чтения реально происходили…
                assertTrue("buildInput не вернул вещей (тест ничего не проверяет)", input.items.size == 1)
                // …транзакция действительно открывалась…
                assertTrue(
                    "buildInput не открывал транзакцию вовсе — 15+ чтений идут несогласованно (T-068)",
                    txRuns.get() >= 1,
                )
                // …и ни одно диспатченное чтение не шло без активной транзакции.
                // Порог с запасом: без withTransaction на queryExecutor приходит 15+
                // DAO-читок (в 2.6 валидатор ещё шумит 0..2 раза); внутри транзакции —
                // только шум валидатора.
                assertTrue(
                    "buildInput читал таблицы вне транзакции: ${readsOutsideTx.size} чтений без inTransaction — T-068",
                    readsOutsideTx.size < 5,
                )
            } finally {
                db.close()
            }
        }
}
