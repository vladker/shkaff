package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.util.newId

class ItemRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.itemDao()

    fun observeAll(): Flow<List<ItemEntity>> = dao.observeAll()

    fun observeByLocation(locationId: String): Flow<List<ItemEntity>> = dao.observeByLocation(locationId)

    suspend fun recent(limit: Int): List<ItemEntity> = dao.recent(limit)

    suspend fun byId(id: String): ItemEntity? = dao.byId(id)

    suspend fun byCode(code: String): ItemEntity? = dao.byCode(code.trim())

    suspend fun count(): Int = dao.count()

    suspend fun countByLocation(locationId: String): Int = dao.countByLocation(locationId)

    suspend fun create(d: ItemData): ItemEntity {
        val now = System.currentTimeMillis()
        val e = ItemEntity(
            id = newId(),
            name = d.name.trim(),
            code = d.code.trim(),
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = d.photoPath,
            location_id = d.locationId,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        return e
    }

    suspend fun update(id: String, d: ItemData): ItemEntity? {
        val e = dao.byId(id) ?: return null
        val u = e.copy(
            name = d.name.trim(),
            code = d.code.trim(),
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = d.photoPath,
            location_id = d.locationId,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        return u
    }

    suspend fun softDelete(id: String) {
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
    }

    suspend fun hardDelete(id: String) {
        dao.hardDelete(id)
    }

    suspend fun search(q: String): List<ItemEntity> {
        val clean = q.trim()
        if (clean.isEmpty()) return emptyList()
        return dao.likeSearch(clean)
    }
}
