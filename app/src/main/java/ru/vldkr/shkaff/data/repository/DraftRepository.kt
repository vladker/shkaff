package ru.vldkr.shkaff.data.repository

import ru.vldkr.shkaff.data.db.DraftEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase

// Черновики форм (US-A4): ключ вида "item/new" или "item/{id}",
// form_json — полное состояние формы, локально, в бэкап не попадает.
class DraftRepository(
    private val db: ShkaffDatabase
) {
    private val dao get() = db.draftDao()

    suspend fun get(key: String): DraftEntity? = dao.byId(key)

    suspend fun save(key: String, entityType: String, entityId: String?, formJson: String) {
        dao.upsert(
            DraftEntity(
                id = key,
                entity_type = entityType,
                entity_id = entityId,
                form_json = formJson,
                saved_at = System.currentTimeMillis()
            )
        )
    }

    suspend fun clear(key: String) {
        dao.delete(key)
    }
}