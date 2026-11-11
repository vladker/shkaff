package ru.vldkr.shkaff.domain.search

import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity

// Подписи строк глобального поиска (T-043): подпись ящика — имя шкафа, в котором он лежит.
// Карту шкафов строим из ПОЛНОГО списка (ui.storages): results.storages —
// только совпадения с запросом, обрезанные .take(50), поэтому у шкафа, не задетого
// запросом, подпись терялась.
object SearchSubtitles {

    fun storageById(storages: List<StorageEntity>): Map<String, StorageEntity> =
        storages.associateBy { it.id }

    fun locationStorageName(
        location: LocationEntity,
        storageById: Map<String, StorageEntity>
    ): String? = storageById[location.storage_id]?.name
}
