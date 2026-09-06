package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.StorageData
import ru.vldkr.shkaff.util.newId

class StorageRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.storageDao()

    fun observeAll(): Flow<List<StorageEntity>> = dao.observeAll()

    suspend fun byId(id: String): StorageEntity? = dao.byId(id)

    suspend fun count(): Int = dao.count()

    suspend fun create(d: StorageData): StorageEntity {
        val now = System.currentTimeMillis()
        val e = StorageEntity(
            id = newId(),
            name = d.name.trim(),
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = null,
            parent_id = d.parentId,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        return e
    }

    suspend fun update(id: String, d: StorageData): StorageEntity? {
        val e = dao.byId(id) ?: return null
        val u = e.copy(
            name = d.name.trim(),
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            parent_id = d.parentId,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        return u
    }

    suspend fun setPhoto(id: String, path: String?) {
        val e = dao.byId(id) ?: return
        dao.upsert(e.copy(
            photo_path = path,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        ))
    }

    suspend fun softDelete(id: String) {
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
    }

    suspend fun hardDelete(id: String) {
        dao.hardDelete(id)
    }
}
