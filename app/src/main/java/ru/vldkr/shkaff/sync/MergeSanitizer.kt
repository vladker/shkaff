package ru.vldkr.shkaff.sync

import ru.vldkr.shkaff.data.db.LocationEntity

data class SanitizeResult(
    val merged: MergeInput,
    val warnings: List<String>
)

object MergeSanitizer {

    fun sanitize(input: MergeInput): SanitizeResult {
        val warnings = mutableListOf<String>()
        val storageIds = input.storages.map { it.id }.toSet()

        var orphanStorageParents = 0
        val storages = input.storages.map { s ->
            if (s.parent_id != null && s.parent_id !in storageIds) {
                orphanStorageParents++
                s.copy(parent_id = null)
            } else s
        }

        var droppedLocations = 0
        val alive = input.locations.filter { l ->
            val ok = l.storage_id in storageIds
            if (!ok) droppedLocations++
            ok
        }
        val locationIds = alive.map { it.id }.toSet()
        var orphanLocationParents = 0
        val locations = alive.map { l ->
            if (l.parent_id != null && l.parent_id !in locationIds) {
                orphanLocationParents++
                l.copy(parent_id = null)
            } else l
        }

        var orphanItems = 0
        val items = input.items.map { i ->
            if (i.location_id != null && i.location_id !in locationIds) {
                orphanItems++
                i.copy(location_id = null)
            } else i
        }

        var droppedAnnotations = 0
        val annotations = input.annotations.filter { a ->
            val ok = a.storage_id in storageIds && a.location_id in locationIds
            if (!ok) droppedAnnotations++
            ok
        }

        if (orphanStorageParents > 0) warnings.add("$orphanStorageParents хранилищ(и) без родительского — вынесены наверх")
        if (droppedLocations > 0) warnings.add("$droppedLocations ящик(ов) без шкафа — не импортированы")
        if (orphanLocationParents > 0) warnings.add("$orphanLocationParents ящик(ов) без родительского ящика — вынесены наверх")
        if (orphanItems > 0) warnings.add("$orphanItems вещей без ящика — сохранены как «без локации»")
        if (droppedAnnotations > 0) warnings.add("$droppedAnnotations размеченных областей без владельца — отброшены")

        return SanitizeResult(
            input.copy(storages = storages, locations = locations, items = items, annotations = annotations),
            warnings
        )
    }
}
