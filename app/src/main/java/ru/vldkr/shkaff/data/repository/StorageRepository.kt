package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.StorageData
import ru.vldkr.shkaff.domain.capacity.CapacityUsage
import ru.vldkr.shkaff.domain.numbering.Numbering
import ru.vldkr.shkaff.util.newId

class StorageRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId },
    private val numbering: () -> NumberingService = { Deps.numbering }
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
            code = resolveCode(d.code.trim()),
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = null,
            parent_id = d.parentId,
            capacity_volume = d.capacityVolumeLiters,
            capacity_weight = d.capacityWeightKg,
            dont_fill_to_brim = d.dontFillToBrim,
            is_full = d.isFull,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        Deps.actionLog.log("create", "storage", e.id, mapOf("name" to e.name))
        return e
    }

    suspend fun update(id: String, d: StorageData): StorageEntity? {
        val e = dao.byId(id) ?: return null
        val code = d.code.trim()
        if (code.isNotEmpty() && code != e.code && dao.existsByCode(code, id) > 0)
            throw IllegalStateException("Номер уже занят: $code")
        val u = e.copy(
            name = d.name.trim(),
            code = code,
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            parent_id = d.parentId,
            capacity_volume = d.capacityVolumeLiters,
            capacity_weight = d.capacityWeightKg,
            dont_fill_to_brim = d.dontFillToBrim,
            is_full = d.isFull,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        Deps.actionLog.log("update", "storage", u.id, mapOf("name" to u.name))
        return u
    }

    // Пустой номер → автонумерация серии; заданный номер → проверка дубля.
    private suspend fun resolveCode(input: String): String {
        if (input.isEmpty()) return numbering().nextFreeCode(Numbering.SCOPE_STORAGE, dao.allCodes())
        if (dao.existsByCode(input) > 0) throw IllegalStateException("Номер уже занят: $input")
        return input
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
        val e = dao.byId(id)
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("delete", "storage", id, mapOf("name" to it.name)) }
    }

    suspend fun hardDelete(id: String) {
        dao.hardDelete(id)
    }

    // Текущая заполненность хранилища: сумма объёма/массы вещей во всех его ящиках
    // (включая вложенные) и самого хранилища.
    suspend fun usage(id: String): CapacityUsage {
        val e = dao.byId(id) ?: return CapacityUsage(0.0, 0.0)
        val locIds = db.locationDao().allByStorage(id).map { it.id }
        return CapacityUsage(
            volumeLiters = db.itemDao().sumVolume(locIds),
            weightKg = db.itemDao().sumWeight(locIds),
            capacityVolumeLiters = e.capacity_volume,
            capacityWeightKg = e.capacity_weight,
            dontFillToBrim = e.dont_fill_to_brim,
            isFull = e.is_full
        )
    }
}
