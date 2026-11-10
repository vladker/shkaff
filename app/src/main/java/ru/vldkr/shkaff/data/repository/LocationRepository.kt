package ru.vldkr.shkaff.data.repository

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.LocationData
import ru.vldkr.shkaff.domain.capacity.CapacityUsage
import ru.vldkr.shkaff.util.newId
import ru.vldkr.shkaff.util.newUlid

class LocationRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
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

    // Пометить, что этикетка напечатана.
    suspend fun markLabelled(id: String) {
        dao.markLabelled(id, System.currentTimeMillis(), deviceId())
    }

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
            capacity_volume = d.capacityVolumeLiters,
            capacity_weight = d.capacityWeightKg,
            dont_fill_to_brim = d.dontFillToBrim,
            is_full = d.isFull,
            level = d.level,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        Deps.actionLog.log("create", "location", e.id, mapOf("name" to e.label.ifBlank { e.name }))
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
            capacity_volume = d.capacityVolumeLiters,
            capacity_weight = d.capacityWeightKg,
            dont_fill_to_brim = d.dontFillToBrim,
            is_full = d.isFull,
            level = d.level,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        Deps.actionLog.log("update", "location", u.id, mapOf("name" to u.label.ifBlank { u.name }))
        return u
    }

    // Пустая метка → ULID (если включена автогенерация); заданная → проверка дубля.
    private suspend fun resolveLabel(input: String): String {
        if (input.isEmpty()) {
            if (Deps.numberingAuto()) return newUlid()
            return input
        }
        if (dao.existsByLabel(input) > 0) throw IllegalStateException("Номер уже занят: $input")
        return input
    }

    // T-041: мягкое удаление ящика в одной транзакции со снятием его вещей в «без места»
    // (так обещает диалог удаления; иначе вещь — «призрак»: не видна ни в ящике, ни в «без места»).
    // Возвращает id отцепленных живых вещей — Undo (restore) возвращает их обратно.
    suspend fun softDelete(id: String): List<String> {
        val e = dao.byId(id)
        val now = System.currentTimeMillis()
        val detached = db.itemDao().idsByLocation(id)
        db.withTransaction {
            db.itemDao().clearLocation(id, now, deviceId())
            dao.softDelete(id, now, deviceId())
        }
        e?.let { Deps.actionLog.log("delete", "location", id, mapOf("name" to it.label.ifBlank { it.name })) }
        return detached
    }

    // Undo: возврат ящика и (T-041) его вещей. Это восстановление прежнего состояния,
    // а не новая раскладка — гейт заполненности не применяется.
    suspend fun restore(id: String, itemIds: List<String> = emptyList()) {
        val e = dao.byId(id)
        val now = System.currentTimeMillis()
        db.withTransaction {
            dao.restore(id, now, deviceId())
            if (itemIds.isNotEmpty()) db.itemDao().assignLocation(itemIds, id, now, deviceId())
        }
        e?.let { Deps.actionLog.log("restore", "location", id, mapOf("name" to it.label.ifBlank { it.name })) }
    }

    suspend fun hardDelete(id: String) {
        dao.hardDelete(id)
    }

    // Заполненность ящика: сумма объёма/массы вещей в нём и во всех вложенных ящиках.
    suspend fun usage(id: String): CapacityUsage {
        val e = dao.byId(id) ?: return CapacityUsage(0.0, 0.0)
        val ids = subtreeIds(id)
        return CapacityUsage(
            volumeLiters = db.itemDao().sumVolume(ids),
            weightKg = db.itemDao().sumWeight(ids),
            capacityVolumeLiters = e.capacity_volume,
            capacityWeightKg = e.capacity_weight,
            dontFillToBrim = e.dont_fill_to_brim,
            isFull = e.is_full
        )
    }

    // ids самого ящика и всех его потомков (по дереву parent_id).
    suspend fun subtreeIds(rootId: String): List<String> {
        val storageId = dao.byId(rootId)?.storage_id ?: return listOf(rootId)
        val all = dao.allByStorage(storageId)
        val byParent = all.groupBy { it.parent_id ?: "" }
        val out = mutableListOf(rootId)
        val queue = ArrayDeque(listOf(rootId))
        while (queue.isNotEmpty()) {
            byParent[queue.removeFirst()]?.forEach { c ->
                out += c.id
                queue.add(c.id)
            }
        }
        return out
    }
}
