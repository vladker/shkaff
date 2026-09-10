package ru.vldkr.shkaff.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

// Временная выдача (US-D3): вещь/хранилище можно выдать (кому, заметка, срок) и вернуть.
class LoansRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.loanDao()

    fun observeActive(): Flow<List<LoanEntity>> = dao.observeActive(System.currentTimeMillis())

    suspend fun activeForEntity(entityType: String, entityId: String): LoanEntity? =
        dao.activeForEntity(entityType, entityId)

    suspend fun lend(entityType: String, entityId: String, borrower: String, note: String, dueAt: Long?): LoanEntity {
        val now = System.currentTimeMillis()
        val e = LoanEntity(
            id = newId(),
            entity_type = entityType,
            entity_id = entityId,
            borrower = borrower.trim(),
            note = note.trim(),
            lent_at = now,
            due_at = dueAt,
            returned_at = null,
            created_at = now,
            updated_at = now,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        Deps.actionLog.log("lend", entityType, entityId, mapOf("borrower" to e.borrower, "due" to (dueAt?.toString() ?: "")))
        return e
    }

    suspend fun returnLoan(id: String) {
        val e = dao.byId(id)
        dao.markReturned(id, System.currentTimeMillis(), System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("return", it.entity_type, it.entity_id, mapOf("borrower" to it.borrower)) }
    }
}