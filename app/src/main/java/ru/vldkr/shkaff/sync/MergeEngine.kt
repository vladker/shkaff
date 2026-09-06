package ru.vldkr.shkaff.sync

import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.db.StorageEntity

data class MergeInput(
    val attributeDefs: List<AttributeDefEntity> = emptyList(),
    val storages: List<StorageEntity> = emptyList(),
    val locations: List<LocationEntity> = emptyList(),
    val items: List<ItemEntity> = emptyList(),
    val annotations: List<AnnotationEntity> = emptyList(),
    val labelTemplates: List<LabelTemplateEntity> = emptyList(),
    val printers: List<PrinterProfileEntity> = emptyList(),
    val lastModified: Long = 0L
)

data class Conflict(
    val table: String,
    val id: String,
    val label: String,
    val localRow: String,
    val remoteRow: String,
    val resolution: String
)

data class MergeStats(
    val added: Int = 0,
    val changed: Int = 0,
    val deleted: Int = 0,
    val kept: Int = 0
)

data class MergeResult(
    val merged: MergeInput,
    val conflicts: List<Conflict>,
    val stats: MergeStats
)

object MergeEngine {

    private data class TableStats(var added: Int = 0, var changed: Int = 0, var deleted: Int = 0, var kept: Int = 0)

    private fun <T> mergeTable(
        table: String,
        local: List<T>,
        remote: List<T>,
        idOf: (T) -> String,
        tsOf: (T) -> Long,
        delOf: (T) -> Long?,
        labelOf: (T) -> String,
        remoteWins: Boolean
    ): Triple<List<T>, List<Conflict>, TableStats> {
        val conflicts = mutableListOf<Conflict>()
        val stats = TableStats()
        val l = local.associateBy { idOf(it) }
        val r = remote.associateBy { idOf(it) }
        val out = LinkedHashMap<String, T>()

        for (id in (l.keys + r.keys).toSortedSet()) {
            val a = l[id]
            val b = r[id]

            when {
                a != null && b == null -> {
                    out[id] = a
                    if (delOf(a) != null) stats.kept++ else stats.kept++
                }
                a == null && b != null -> {
                    out[id] = b
                    stats.added++
                }
                else -> {
                    val x = a!!
                    val y = b!!
                    val xDel = delOf(x)
                    val yDel = delOf(y)
                    val xTs = tsOf(x)
                    val yTs = tsOf(y)
                    val xRow = x.toString()
                    val yRow = y.toString()
                    val xDeleted = xDel != null
                    val yDeleted = yDel != null

                    val winner: T
                    val conflict: Conflict?

                    when {
                        !xDeleted && !yDeleted -> {
                            if (xTs == yTs) {
                                if (xRow != yRow) {
                                    winner = if (remoteWins) y else x
                                    conflict = Conflict(
                                        table, id, labelOf(winner),
                                        if (remoteWins) xRow else yRow,
                                        if (remoteWins) yRow else xRow,
                                        if (remoteWins) "remote" else "local"
                                    )
                                } else {
                                    winner = x
                                    conflict = null
                                }
                            } else {
                                winner = if (yTs > xTs) y else x
                                conflict = null
                            }
                        }
                        xDeleted && !yDeleted -> {
                            // удалено локально, живо удалённо: если удаление новее — остаётся удалённым
                            winner = if (xDel!! > yTs) x else y
                            conflict = null
                        }
                        !xDeleted && yDeleted -> {
                            winner = if (yDel!! > xTs) y else x
                            conflict = null
                        }
                        else -> {
                            winner = if (yDel!! >= xDel!!) y else x
                            conflict = null
                        }
                    }

                    conflict?.let { conflicts.add(it) }
                    out[id] = winner

                    if (winner === x && xRow == yRow) stats.kept++
                    else if (delOf(winner) != null && !xDeleted) stats.deleted++
                    else if (winner.toString() != xRow) stats.changed++
                    else stats.kept++
                }
            }
        }

        return Triple(out.values.toList(), conflicts, stats)
    }

    fun merge(local: MergeInput, remote: MergeInput, remoteWins: Boolean): MergeResult {
        val allConflicts = mutableListOf<Conflict>()
        val stats = MergeStats()

        val (defs, c1, s1) = mergeTable(
            "attribute_defs", local.attributeDefs, remote.attributeDefs,
            { it.id }, { it.updated_at }, { it.deleted_at }, { it.label }, remoteWins
        )
        allConflicts += c1

        val (stors, c2, s2) = mergeTable(
            "storages", local.storages, remote.storages,
            { it.id }, { it.updated_at }, { it.deleted_at }, { it.name }, remoteWins
        )
        allConflicts += c2

        val (locs, c3, s3) = mergeTable(
            "locations", local.locations, remote.locations,
            { it.id }, { it.updated_at }, { it.deleted_at },
            { it.label.ifBlank { it.name }.ifBlank { "Ящик" } }, remoteWins
        )
        allConflicts += c3

        val (items, c4, s4) = mergeTable(
            "items", local.items, remote.items,
            { it.id }, { it.updated_at }, { it.deleted_at }, { it.name }, remoteWins
        )
        allConflicts += c4

        val (anns, c5, s5) = mergeTable(
            "annotations", local.annotations, remote.annotations,
            { it.id }, { it.updated_at }, { it.deleted_at }, { it.label.ifBlank { "Рамка" } }, remoteWins
        )
        allConflicts += c5

        val (tpls, c6, s6) = mergeTable(
            "label_templates", local.labelTemplates, remote.labelTemplates,
            { it.id }, { it.updated_at }, { it.deleted_at }, { it.name }, remoteWins
        )
        allConflicts += c6

        val (printers, c7, s7) = mergeTable(
            "printers", local.printers, remote.printers,
            { it.id }, { it.updated_at }, { it.deleted_at }, { it.name }, remoteWins
        )
        allConflicts += c7

        val all = listOf(s1, s2, s3, s4, s5, s6, s7)
        val total = MergeStats(
            added = all.sumOf { it.added },
            changed = all.sumOf { it.changed },
            deleted = all.sumOf { it.deleted },
            kept = all.sumOf { it.kept }
        )

        val lastModified = maxOf(local.lastModified, remote.lastModified, System.currentTimeMillis())

        val merged = MergeInput(
            attributeDefs = defs,
            storages = stors,
            locations = locs,
            items = items,
            annotations = anns,
            labelTemplates = tpls,
            printers = printers,
            lastModified = lastModified
        )

        return MergeResult(
            merged = merged,
            conflicts = allConflicts,
            stats = total
        )
    }
}
