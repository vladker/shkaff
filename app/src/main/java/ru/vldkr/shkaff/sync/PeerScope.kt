package ru.vldkr.shkaff.sync

// Область доверия (US-G2): сервер отдаёт пиру только данные доверенных хранилищ.
// Поддерево хранилища (вложенные шкафы, ящики, вещи, разметка) держим целиком —
// иначе сломаются связи. Глобальные таблицы (словари, шаблоны, теги, пользователи,
// выдачи, стеки, корзины) синхронизируются всегда, но срезаны по вложенным объектам.
object PeerScope {

    fun isAll(trust: PeerTrust): Boolean = trust.scope == PeerTrust.SCOPE_ALL

    // Доверенные хранилища + все их вложенные потомки.
    fun allowedStorages(input: MergeInput, trust: PeerTrust): Set<String> {
        if (isAll(trust)) return input.storages.map { it.id }.toSet()
        val children = input.storages.groupBy { it.parent_id }
        val out = mutableSetOf<String>()
        fun walk(id: String) {
            if (!out.add(id)) return
            children[id]?.forEach { walk(it.id) }
        }
        trust.storages.forEach { walk(it) }
        return out
    }

    fun apply(input: MergeInput, trust: PeerTrust): MergeInput {
        if (isAll(trust)) return input
        val storages = input.storages.filter { it.id in allowedStorages(input, trust) }
        val storageIds = storages.map { it.id }.toSet()
        // Родитель мог попасть вне области — выносим наверх, как в MergeSanitizer.
        val storagesFixed = storages.map { s ->
            if (s.parent_id != null && s.parent_id !in storageIds) s.copy(parent_id = null) else s
        }

        val locations = input.locations.filter { it.storage_id in storageIds }
        val locationIds = locations.map { it.id }.toSet()
        val locationsFixed = locations.map { l ->
            if (l.parent_id != null && l.parent_id !in locationIds) l.copy(parent_id = null) else l
        }

        val items = input.items.filter { it.location_id == null || it.location_id in locationIds }
        val itemIds = items.map { it.id }.toSet()

        val annotations = input.annotations.filter {
            it.storage_id in storageIds && it.location_id in locationIds
        }

        // Стеки: член стека жив, только если его объект внутри области.
        val stackIds = input.stacks.map { it.id }.toSet()
        val stackMembers = input.stackMembers.filter {
            it.stack_id in stackIds &&
                ((it.entity_type == "item" && it.entity_id in itemIds) ||
                    (it.entity_type != "item" && it.entity_id in storageIds))
        }
        val memberStackIds = stackMembers.map { it.stack_id }.toSet()
        val stacks = input.stacks.filter { it.id in memberStackIds }

        // Выдачи и корзины: привязаны к вещам/хранилищам внутри области.
        val loans = input.loans.filter {
            (it.entity_type == "item" && it.entity_id in itemIds) ||
                (it.entity_type == "storage" && it.entity_id in storageIds)
        }
        val basketItems = input.basketItems.filter { it.item_id in itemIds }
        val basketIds = basketItems.map { it.basket_id }.toSet()
        val baskets = input.baskets.filter { it.id in basketIds }

        return input.copy(
            storages = storagesFixed,
            locations = locationsFixed,
            items = items,
            annotations = annotations,
            stacks = stacks,
            stackMembers = stackMembers,
            loans = loans,
            baskets = baskets,
            basketItems = basketItems
        )
    }
}
