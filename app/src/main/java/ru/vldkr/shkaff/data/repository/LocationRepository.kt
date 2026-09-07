package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.LocationData
import ru.vldkr.shkaff.domain.numbering.Numbering
import ru.vldkr.shkaff.util.newId

class LocationRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId },
    private val numbering: () -> NumberingService = { Deps.numbering }
) {
    private val dao get() = db.locationDao()

    fun observeAll(): Flow<List<LocationEntity>> = dao.observeAll()

    fun observeByStorage(storageId: String): Flow<List<LocationEntity>> = dao.observeByStorage(storageId)

    suspend fun allByStorage(storageId: String): List<LocationEntity> = dao.allByStorage(storageId)

    suspend fun byId(id: String): LocationEntity? = dao.byId(id)

    suspend fun children(parentId: String): List<LocationEntity> = dao.children(parentId)

    fun observeChildren(parentId: String): Flow<List<LocationEntity>> = dao.observeChildren(parentId)

    suspend fun count(): Int = dao.count()

    suspend fun countByStorage(storageId: String): Int = dao.countByStorage(storageId)

    suspend fun create(d: LocationData): LocationEntity {
        val now = System.currentTimeMillis()
        val e = LocationEntity(
            id = newId(),
            storage_id = d.storageId,
            parent_id = d.parentId,
            label = resolveLabel(d.label.trim()),
            name = d.name.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = null,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        return e
    }

    suspend fun update(id: String, d: LocationData): LocationEntity? {
        val e = dao.byId(id) ?: return null
        val label = d.label.trim()
        if (label.isNotEmpty() && label != e.label && dao.existsByLabel(label, id) > 0)
            throw IllegalStateException("Номер уже занят: $label")
        val u = e.copy(
            parent_id = d.parentId,
            label = label,
            name = d.name.trim(),
            attributes = AttrJson.toJson(d.attributes),
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        return u
    }

    // Пустая метка → автонумерация серии; заданная метка → проверка дубля.
    private suspend fun resolveLabel(input: String): String {
        if (input.isEmpty()) return numbering().nextFreeCode(Numbering.SCOPE_LOCATION, dao.allLabels())
        if (dao.existsByLabel(input) > 0) throw IllegalStateException("Номер уже занят: $input")
        return input
    }

    suspend fun softDelete(id: String) {
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
    }

    suspend fun hardDelete(id: String) {
        dao.hardDelete(id)
    }
}
