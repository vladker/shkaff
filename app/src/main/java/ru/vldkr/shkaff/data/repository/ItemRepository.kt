package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.numbering.Numbering
import ru.vldkr.shkaff.util.Expiry
import ru.vldkr.shkaff.util.newId
import java.time.LocalDate

class ItemRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId },
    private val numbering: () -> NumberingService = { Deps.numbering }
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

    suspend fun create(d: ItemData): ItemEntity {
        val now = System.currentTimeMillis()
        val e = ItemEntity(
            id = newId(),
            name = d.name.trim(),
            code = resolveCode(d.code.trim()),
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = d.photoPath,
            location_id = d.locationId,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId(),
            expiry_date = d.expiryDate,
            ean = d.ean,
            tags = TagsJson.toJson(d.tags),
            volume_liters = d.volumeLiters,
            weight_kg = d.weightKg
        )
        dao.upsert(e)
        Deps.actionLog.log("create", "item", e.id, mapOf("name" to e.name))
        return e
    }

    suspend fun update(id: String, d: ItemData): ItemEntity? {
        val e = dao.byId(id) ?: return null
        val code = d.code.trim()
        if (code.isNotEmpty() && code != e.code && dao.existsByCode(code, id) > 0)
            throw IllegalStateException("Номер уже занят: $code")
        val u = e.copy(
            name = d.name.trim(),
            code = code,
            description = d.description.trim(),
            attributes = AttrJson.toJson(d.attributes),
            photo_path = d.photoPath,
            location_id = d.locationId,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId(),
            expiry_date = d.expiryDate,
            ean = d.ean,
            tags = TagsJson.toJson(d.tags),
            volume_liters = d.volumeLiters,
            weight_kg = d.weightKg
        )
        dao.upsert(u)
        if (u.location_id != e.location_id) {
            Deps.actionLog.log("move", "item", u.id, mapOf("name" to u.name, "to" to (u.location_id ?: "no-location")))
        } else {
            Deps.actionLog.log("update", "item", u.id, mapOf("name" to u.name))
        }
        return u
    }

    // Пустой штрих-код → автонумерация серии; заданный → проверка дубля.
    private suspend fun resolveCode(input: String): String {
        if (input.isEmpty()) return numbering().nextFreeCode(Numbering.SCOPE_ITEM, dao.allCodes())
        if (dao.existsByCode(input) > 0) throw IllegalStateException("Номер уже занят: $input")
        return input
    }

    suspend fun expiringSoon(thresholdDays: Int, today: LocalDate = LocalDate.now(), limit: Int = 20): List<ItemEntity> {
        return dao.withExpiry()
            .mapNotNull { i ->
                val d = Expiry.parse(i.expiry_date) ?: return@mapNotNull null
                Expiry.daysUntil(d, today) to i
            }
            .filter { (days, _) -> Expiry.isDueForSort(days, thresholdDays) }
            .sortedBy { (days, _) -> days }
            .take(limit)
            .map { it.second }
    }

    suspend fun softDelete(id: String) {
        val e = dao.byId(id)
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("delete", "item", id, mapOf("name" to it.name)) }
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
