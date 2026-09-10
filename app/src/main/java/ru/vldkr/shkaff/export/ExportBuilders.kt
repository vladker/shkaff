package ru.vldkr.shkaff.export

import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

// Сборка таблиц из сущностей. Пути — «корень › … › текущий», с защитой от циклов
object ExportBuilders {

    fun items(
        items: List<ItemEntity>,
        locations: List<LocationEntity>,
        storages: List<StorageEntity>
    ): Sheet {
        val locById = locations.associateBy { it.id }
        val storById = storages.associateBy { it.id }
        val headers = listOf("Название", "Код", "Штрихкод (EAN)", "Описание", "Шкаф", "Ящик", "Теги", "Срок годности", "Создана", "Изменена")
        val rows = items
            .filter { it.deleted_at == null }
            .sortedWith(compareBy({ it.name }, { it.code }))
            .map { i ->
                val loc = i.location_id?.let { id -> locById[id] }
                listOf(
                    i.name,
                    i.code,
                    i.ean.orEmpty(),
                    i.description,
                    storagePath(loc?.storage_id, storById),
                    locationChain(loc, locById),
                    TagsJson.toList(i.tags).joinToString("; "),
                    i.expiry_date.orEmpty(),
                    fmt(i.created_at),
                    fmt(i.updated_at)
                )
            }
        return Sheet("Вещи", headers, rows)
    }

    fun locations(
        locations: List<LocationEntity>,
        storages: List<StorageEntity>
    ): Sheet {
        val locById = locations.associateBy { it.id }
        val storById = storages.associateBy { it.id }
        val headers = listOf("Название", "Метка", "Шкаф", "Родительский ящик", "Создан", "Изменён")
        val rows = locations
            .filter { it.deleted_at == null }
            .sortedWith(compareBy({ storagePath(it.storage_id, storById) }, { it.label.ifBlank { it.name } }))
            .map { l ->
                listOf(
                    l.name,
                    l.label,
                    storagePath(l.storage_id, storById),
                    l.parent_id?.let { id -> locById[id] }?.let { it.label.ifBlank { it.name } }.orEmpty(),
                    fmt(l.created_at),
                    fmt(l.updated_at)
                )
            }
        return Sheet("Ящики", headers, rows)
    }

    // «Корень › Средний › Шкаф»
    fun storagePath(storageId: String?, storById: Map<String, StorageEntity>): String {
        if (storageId == null) return ""
        val parts = mutableListOf<String>()
        val seen = mutableSetOf<String>()
        var cur: StorageEntity? = storById[storageId]
        while (cur != null && seen.add(cur.id)) {
            parts.add(0, cur.name)
            cur = cur.parent_id?.let { storById[it] }
        }
        return parts.joinToString(" › ")
    }

    // «Корневой ящик › … › текущий»
    fun locationChain(loc: LocationEntity?, locById: Map<String, LocationEntity>): String {
        if (loc == null) return ""
        val parts = mutableListOf<String>()
        val seen = mutableSetOf<String>()
        var cur = loc
        while (cur != null && seen.add(cur.id)) {
            parts.add(0, cur.label.ifBlank { cur.name }.ifBlank { "Ящик" })
            cur = cur.parent_id?.let { locById[it] }
        }
        return parts.joinToString(" › ")
    }

    private val FMT: DateTimeFormatter =
        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").withZone(ZoneId.systemDefault())

    private fun fmt(ts: Long): String = try {
        FMT.format(Instant.ofEpochMilli(ts))
    } catch (e: Exception) {
        ""
    }
}
