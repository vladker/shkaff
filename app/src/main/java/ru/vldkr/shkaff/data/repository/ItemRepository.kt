package ru.vldkr.shkaff.data.repository

import androidx.room.withTransaction
import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.domain.actions.BatchMoveResult
import ru.vldkr.shkaff.domain.actions.MoveUndo
import ru.vldkr.shkaff.domain.capacity.CapacityGate
import ru.vldkr.shkaff.domain.capacity.GateVerdict
import ru.vldkr.shkaff.domain.capacity.OverCapacityException
import ru.vldkr.shkaff.util.Expiry
import ru.vldkr.shkaff.util.newId
import ru.vldkr.shkaff.util.newUlid
import java.time.LocalDate

class ItemRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId },
) {
    private val dao get() = db.itemDao()

    fun observeAll(): Flow<List<ItemEntity>> = dao.observeAll()

    fun observeByLocation(locationId: String): Flow<List<ItemEntity>> = dao.observeByLocation(locationId)

    suspend fun recent(limit: Int): List<ItemEntity> = dao.recent(limit)

    suspend fun all(): List<ItemEntity> = dao.all()

    suspend fun byId(id: String): ItemEntity? = dao.byId(id)

    suspend fun byCode(code: String): ItemEntity? = dao.byCode(code.trim())

    suspend fun count(): Int = dao.count()

    suspend fun countByLocation(locationId: String): Int = dao.countByLocation(locationId)

    // Вещи, которым ещё не напечатана этикетка — очередь печати.
    suspend fun recentUnlabelled(limit: Int): List<ItemEntity> = dao.recentUnlabelled(limit)

    // Каталог вещей: от самой недавно добавленной к самым давним.
    suspend fun recentCreated(limit: Int): List<ItemEntity> = dao.recentCreated(limit)

    // Пометить, что этикетка напечатана.
    suspend fun markLabelled(id: String) {
        dao.markLabelled(id, System.currentTimeMillis(), deviceId())
    }

    suspend fun create(
        d: ItemData,
        allowOverCapacity: Boolean = false,
    ): ItemEntity {
        capacityGate(d.locationId, d.volumeLiters, d.weightKg, existing = null, allowOverCapacity)
        val now = System.currentTimeMillis()
        val e =
            ItemEntity(
                id = newId(),
                name = d.name.trim(),
                code = resolveCode(d.code.trim()),
                description = d.description.trim(),
                attributes = AttrJson.toJson(d.attributes),
                photo_path = d.photoPath,
                barcode_photo_path = d.barcodePhotoPath,
                location_id = d.locationId,
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = deviceId(),
                expiry_date = d.expiryDate,
                ean = d.ean,
                tags = TagsJson.toJson(d.tags),
                volume_liters = d.volumeLiters,
                weight_kg = d.weightKg,
            )
        dao.upsert(e)
        Deps.actionLog.log("create", "item", e.id, mapOf("name" to e.name))
        return e
    }

    suspend fun update(
        id: String,
        d: ItemData,
        allowOverCapacity: Boolean = false,
    ): ItemEntity? {
        val e = dao.byId(id) ?: return null
        val code = d.code.trim()
        if (code.isNotEmpty() && code != e.code && dao.existsByCode(code, id) > 0) {
            throw IllegalStateException("Номер уже занят: $code")
        }
        capacityGate(d.locationId, d.volumeLiters, d.weightKg, existing = e, allowOverCapacity)
        val u =
            e.copy(
                name = d.name.trim(),
                code = code,
                description = d.description.trim(),
                attributes = AttrJson.toJson(d.attributes),
                photo_path = d.photoPath,
                barcode_photo_path = d.barcodePhotoPath,
                location_id = d.locationId,
                updated_at = System.currentTimeMillis(),
                device_last_modified = deviceId(),
                expiry_date = d.expiryDate,
                ean = d.ean,
                tags = TagsJson.toJson(d.tags),
                volume_liters = d.volumeLiters,
                weight_kg = d.weightKg,
            )
        dao.upsert(u)
        if (u.location_id != e.location_id) {
            Deps.actionLog.log("move", "item", u.id, mapOf("name" to u.name, "to" to (u.location_id ?: "no-location")))
        } else {
            Deps.actionLog.log("update", "item", u.id, mapOf("name" to u.name))
        }
        return u
    }

    // П3.1: перекладка по скану — меняем только ящик, остальное как было.
    // Обновляем updated_at: от него зависит LWW при слиянии (AGENTS.md).
    suspend fun moveTo(
        id: String,
        locationId: String?,
        allowOverCapacity: Boolean = false,
    ): ItemEntity? {
        val e = dao.byId(id) ?: return null
        capacityGate(locationId, e.volume_liters, e.weight_kg, existing = e, allowOverCapacity)
        val u =
            e.copy(
                location_id = locationId,
                updated_at = System.currentTimeMillis(),
                device_last_modified = deviceId(),
            )
        dao.upsert(u)
        Deps.actionLog.log("move", "item", u.id, mapOf("name" to u.name, "to" to (locationId ?: "no-location")))
        return u
    }

    // US-R: пакетный перенос выбранных вещей в ящик. Гейт прав — тот же Access.MOVE, что у
    // П3.1/Relocation (Verb.MOVE -> Access.MOVE); проверка до любых записей.
    // updated_at++ обязателен для каждой вещи: от него зависит LWW при слиянии (AGENTS.md),
    // поэтому вещь уже в целевом ящике всё равно обновляется.
    suspend fun batchMove(
        itemIds: List<String>,
        locationId: String,
        allowOverCapacity: Boolean = false,
    ): BatchMoveResult {
        if (!Access.can(ActiveRole.role.value, Access.MOVE)) throw IllegalStateException("Профиль без прав на перекладку")
        val moved = mutableListOf<String>()
        val skipped = mutableListOf<String>()
        val undo = mutableListOf<MoveUndo>()
        db.withTransaction {
            val now = System.currentTimeMillis() // один момент времени на весь вызов
            for (id in itemIds.distinct()) {
                val e = dao.byId(id)
                if (e == null || e.deleted_at != null) {
                    skipped += id
                    continue
                }
                capacityGate(locationId, e.volume_liters, e.weight_kg, existing = e, allowOverCapacity)
                undo += MoveUndo(e.id, e.location_id, e.updated_at, e.device_last_modified)
                dao.upsert(e.copy(location_id = locationId, updated_at = now, device_last_modified = deviceId()))
                Deps.actionLog.log("move", "item", e.id, mapOf("name" to e.name, "to" to locationId))
                moved += id
            }
        }
        return BatchMoveResult(moved, skipped, undo)
    }

    // Undo для batchMove: возвращаем прежние location_id/updated_at/device_last_modified,
    // чтобы LWW-слияние после undo видело исходное состояние вещи.
    suspend fun undoBatchMove(undo: List<MoveUndo>) {
        if (!Access.can(ActiveRole.role.value, Access.MOVE)) throw IllegalStateException("Профиль без прав на перекладку")
        db.withTransaction {
            for (u in undo) {
                val e = dao.byId(u.itemId) ?: continue
                if (e.deleted_at != null) continue
                dao.upsert(
                    e.copy(
                        location_id = u.prevLocationId,
                        updated_at = u.prevUpdatedAt,
                        device_last_modified = u.prevDeviceLastModified,
                    ),
                )
                Deps.actionLog.log("move", "item", u.itemId, mapOf("undo" to "1", "to" to (u.prevLocationId ?: "no-location")))
            }
        }
    }

    // T-006 / П3.3: честная проверка ёмкости до записи. «Полный» ящик — запрет
    // (IllegalStateException), превышение объёма/массы — OverCapacityException, пока
    // вызывающий явно не подтвердит (allowOverCapacity). Вклад самой вещи вычитаем,
    // если она уже стоит в целевом поддереве (правка/перекладка не «съедает» место дважды).
    private suspend fun capacityGate(
        locationId: String?,
        volumeLiters: Double,
        weightKg: Double,
        existing: ItemEntity?,
        allowOverCapacity: Boolean,
    ) {
        val locId = locationId ?: return
        val locs = LocationRepository(db, deviceId)
        var usage = locs.usage(locId)
        if (existing != null && existing.location_id in locs.subtreeIds(locId)) {
            usage = CapacityGate.excludingItem(usage, existing.volume_liters, existing.weight_kg)
        }
        val dec = CapacityGate.checkPlacement(usage, volumeLiters, weightKg)
        when (dec.verdict) {
            GateVerdict.BLOCK -> {
                throw IllegalStateException(dec.message)
            }

            GateVerdict.CONFIRM -> {
                if (!allowOverCapacity) throw OverCapacityException(dec.message ?: "Ёмкость ящика будет превышена")
            }

            GateVerdict.OK -> {
                Unit
            }
        }
    }

    // Пустой код → ULID (если включена автогенерация); заданный → проверка дубля.
    private suspend fun resolveCode(input: String): String {
        if (input.isEmpty()) {
            if (Deps.numberingAuto()) return newUlid()
            return input
        }
        if (dao.existsByCode(input) > 0) throw IllegalStateException("Номер уже занят: $input")
        return input
    }

    suspend fun setCode(
        id: String,
        code: String,
    ): ItemEntity? {
        val e = dao.byId(id) ?: return null
        val c = code.trim()
        if (c.isNotEmpty() && dao.existsByCode(c, id) > 0) throw IllegalStateException("Номер уже занят: $c")
        val u = e.copy(code = c, updated_at = System.currentTimeMillis(), device_last_modified = deviceId())
        dao.upsert(u)
        return u
    }

    suspend fun expiringSoon(
        thresholdDays: Int,
        today: LocalDate = LocalDate.now(),
        limit: Int = 20,
    ): List<ItemEntity> {
        return dao
            .withExpiry()
            .mapNotNull { i ->
                val d = Expiry.parse(i.expiry_date) ?: return@mapNotNull null
                Expiry.daysUntil(d, today) to i
            }.filter { (days, _) -> Expiry.isDueForSort(days, thresholdDays) }
            .sortedBy { (days, _) -> days }
            .take(limit)
            .map { it.second }
    }

    // US-I1: оценка объёма/массы от агента — пишется только после подтверждения пользователем.
    suspend fun applyVolume(
        id: String,
        volumeLiters: Double,
        weightKg: Double,
    ): Boolean {
        val e = dao.byId(id) ?: return false
        dao.upsert(
            e.copy(
                volume_liters = volumeLiters.coerceAtLeast(0.0),
                weight_kg = weightKg.coerceAtLeast(0.0),
                updated_at = System.currentTimeMillis(),
                device_last_modified = deviceId(),
            ),
        )
        Deps.actionLog.log(
            "volume",
            "item",
            id,
            mapOf("name" to e.name, "volume_liters" to volumeLiters.toString(), "weight_kg" to weightKg.toString()),
        )
        return true
    }

    // US-I2: найденные агентом атрибуты — слить в существующие (только непустые ключи),
    // писать только после подтверждения пользователем.
    suspend fun applyAttributes(
        id: String,
        attrs: Map<String, String>,
    ): Boolean {
        val clean = attrs.filterKeys { it.isNotBlank() }.filterValues { it.isNotBlank() }
        if (clean.isEmpty()) return false
        val e = dao.byId(id) ?: return false
        val merged = AttrJson.toMap(e.attributes).toMutableMap().apply { putAll(clean) }
        dao.upsert(
            e.copy(
                attributes = AttrJson.toJson(merged),
                updated_at = System.currentTimeMillis(),
                device_last_modified = deviceId(),
            ),
        )
        Deps.actionLog.log(
            "attributes",
            "item",
            id,
            mapOf("name" to e.name, "keys" to clean.keys.joinToString(",")),
        )
        return true
    }

    suspend fun softDelete(id: String) {
        val e = dao.byId(id)
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("delete", "item", id, mapOf("name" to it.name)) }
    }

    // Undo: возврат вещи после мягкого удаления.
    suspend fun restore(id: String) {
        val e = dao.byId(id)
        dao.restore(id, System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("restore", "item", id, mapOf("name" to it.name)) }
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
