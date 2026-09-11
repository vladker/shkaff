package ru.vldkr.shkaff.sync

import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity

// US-G3: разрезание базы на фрагменты. Фрагмент — тот же формат бэкапа (Backup),
// но с подмножеством строк: выбранные локации с поддеревьями и/или вещи за окно.
// Словари (attribute_def, label_template, printer_profile, user) идут целиком —
// это глобальная конфигурация, её резать нельзя.
object Fragment {

    const val DAY_MS = 86_400_000L

    data class Options(
        // Корни локаций (включаются вместе с потомками); пусто — без локационного фильтра.
        val locationIds: Set<String> = emptySet(),
        // Хранилища (включаются со всеми своими ящиками); пусто — без фильтра по хранилищам.
        val storageIds: Set<String> = emptySet(),
        // Окно: вещи с updated_at свежее windowDays назад попадают обязательно.
        val windowDays: Int = 0
    ) {
        val isNoop: Boolean get() = locationIds.isEmpty() && storageIds.isEmpty() && windowDays <= 0
    }

    data class Stats(
        val storages: Int = 0,
        val locations: Int = 0,
        val items: Int = 0
    )

    fun preview(input: MergeInput, opts: Options): Stats {
        val r = split(input, opts)
        return Stats(
            storages = r.storages.size,
            locations = r.locations.size,
            items = r.items.size
        )
    }

    fun split(input: MergeInput, opts: Options): MergeInput {
        if (opts.isNoop) return input

        val since = if (opts.windowDays > 0) System.currentTimeMillis() - opts.windowDays.toLong() * DAY_MS else null
        val locById = input.locations.associateBy { it.id }
        val storById = input.storages.associateBy { it.id }
        val locByStorage = input.locations.groupBy { it.storage_id }

        // Вещи из оконного фильтра — изменённые за период.
        val windowItems = if (since != null) input.items.filter { it.updated_at >= since } else emptyList()
        val windowItemIds = windowItems.map { it.id }.toSet()

        // Локации: корни + потомки; по выбранным хранилищам — все их ящики;
        // ящики оконных вещей (чтобы путь не рвался); плюс родительские цепочки.
        var locIds = subtreeOf(input.locations, opts.locationIds)
        // Выбранное хранилище тянет вложенные в него хранилища (шкаф → вложенный ящик-шкаф).
        val selectedStorages = storageSubtreeOf(input.storages, opts.storageIds)
        for (sid in selectedStorages) {
            for (l in locByStorage[sid].orEmpty()) {
                locIds += subtreeOf(input.locations, setOf(l.id))
            }
        }
        for (i in windowItems) {
            i.location_id?.let { lid -> locIds += subtreeOf(input.locations, setOf(lid)) }
        }
        locIds = ancestorClosure(locById, locIds) { it.parent_id }

        val keptLocations = input.locations.filter { it.id in locIds }

        // Хранилища включённых ящиков + выбранные (с поддеревьями) + родительские цепочки.
        var storageIds = keptLocations.map { it.storage_id }.toSet() + selectedStorages
        storageIds = ancestorClosure(storById, storageIds) { it.parent_id }
        val keptStorages = input.storages.filter { it.id in storageIds }

        // Вещи: лежащие в включённых ящиках + оконные (могут быть и без локации).
        val itemIds = mutableSetOf<String>()
        val keptItems = mutableListOf<ItemEntity>()
        for (i in input.items) {
            val inLoc = i.location_id != null && i.location_id in locIds
            if (inLoc || i.id in windowItemIds) {
                keptItems.add(i)
                itemIds.add(i.id)
            }
        }

        // Разметка фото — только по включённым шкафам.
        val annotations = input.annotations.filter { it.storage_id in storageIds }

        // Выдачи по попавшим вещам/хранилищам.
        val loans = input.loans.filter { l ->
            (l.entity_type == "item" && l.entity_id in itemIds) ||
                (l.entity_type == "storage" && l.entity_id in storageIds)
        }

        // Стеки: участники из попавших объектов, к ним — все участники тех же стеков
        // (стеки — неделимые группы, полный состав сохраняет их смысл).
        val directlyHit = input.stackMembers.filter { m ->
            (m.entity_type == "item" && m.entity_id in itemIds) ||
                (m.entity_type == "storage" && m.entity_id in storageIds)
        }
        val stackIds = directlyHit.map { it.stack_id }.toSet()
        val keptStacks = input.stacks.filter { it.id in stackIds }
        val keptMembers = input.stackMembers.filter { it.stack_id in stackIds }

        // Корзины: только с попавшими вещами.
        val keptBasketItems = input.basketItems.filter { it.item_id in itemIds }
        val basketIds = keptBasketItems.map { it.basket_id }.toSet()
        val keptBaskets = input.baskets.filter { it.id in basketIds }

        // Словарь тегов — только те, что реально на попавших вещах.
        val usedTags = keptItems.flatMap { TagsJson.toList(it.tags) }.map { it.trim() }.toSet()
        val keptTags = input.tags.filter { it.name in usedTags }

        return input.copy(
            storages = keptStorages,
            locations = keptLocations,
            items = keptItems,
            annotations = annotations,
            loans = loans,
            stacks = keptStacks,
            stackMembers = keptMembers,
            baskets = keptBaskets,
            basketItems = keptBasketItems,
            tags = keptTags
        )
    }
private fun subtreeOf(all: List<LocationEntity>, roots: Set<String>): Set<String> {
        if (roots.isEmpty()) return emptySet()
        val byParent = all.groupBy { it.parent_id }
        val out = mutableSetOf<String>()
        val queue = ArrayDeque<String>()
        roots.forEach { if (out.add(it)) queue.add(it) }
        while (queue.isNotEmpty()) {
            byParent[queue.removeFirst()]?.forEach { l ->
                if (out.add(l.id)) queue.add(l.id)
            }
        }
        return out
    }

    private fun storageSubtreeOf(all: List<StorageEntity>, roots: Set<String>): Set<String> {
        if (roots.isEmpty()) return emptySet()
        val byParent = all.groupBy { it.parent_id }
        val out = mutableSetOf<String>()
        val queue = ArrayDeque<String>()
        roots.forEach { if (out.add(it)) queue.add(it) }
        while (queue.isNotEmpty()) {
            byParent[queue.removeFirst()]?.forEach { s ->
                if (out.add(s.id)) queue.add(s.id)
            }
        }
        return out
    }

    private fun <T> ancestorClosure(
        byId: Map<String, T>,
        ids: Set<String>,
        parentOf: (T) -> String?
    ): Set<String> {
        val out = ids.toMutableSet()
        val queue = ArrayDeque(ids)
        while (queue.isNotEmpty()) {
            val id = queue.removeFirst()
            val parent = byId[id]?.let { parentOf(it) } ?: continue
            if (out.add(parent)) queue.add(parent)
        }
        return out
    }
}