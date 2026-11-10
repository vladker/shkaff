package ru.vldkr.shkaff.domain.actions

import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.domain.links.AppLink

// П3.1: перекладка по скану (scan-как-валидация из WMS): QR вещи → QR ящика →
// подтверждение «Кладем X в Y?». Разрешение отсканированного кода в сущность и
// шаги сессии — чистый Kotlin, тестируется без Android (RelocationTest).
object Relocation {

    // Ключ объекта из любого вида кода: служебный QR → его entityId (ULID карточки),
    // deep-link «Шкафа» → code из ссылки, обычный код → он сам. Пустой entityId
    // (QR глагола без объекта) ключа не даёт.
    fun keyOf(raw: String): String {
        val parsed = ActionCode.parse(raw)
        if (parsed.valid) return parsed.entityId
        AppLink.parse(raw)?.let { return it }
        return raw
    }

    // Вещь ищется по id, коду карточки и рыночному штрихкоду; удалённые невидимы.
    fun resolveItem(raw: String, items: List<ItemEntity>): ItemEntity? {
        val key = keyOf(raw)
        if (key.isEmpty()) return null
        return items.firstOrNull {
            it.deleted_at == null && (it.id == key || it.code == key || it.ean == key)
        }
    }

    // Ящик — по id и коду метки; удалённые невидимы.
    fun resolveLocation(raw: String, locations: List<LocationEntity>): LocationEntity? {
        val key = keyOf(raw)
        if (key.isEmpty()) return null
        return locations.firstOrNull {
            it.deleted_at == null && (it.id == key || it.label == key)
        }
    }

    fun locationName(l: LocationEntity): String = l.label.ifBlank { l.name }
}

// Сессия перекладки: шаг 1 — ждём вещь, шаг 2 — ящик, шаг 3 — подтверждение.
// Повторный скан вещи на шаге 2 уточняет выбор (человек назвал не ту коробку).
class RelocationFlow {
    companion object {
        const val STEP_ITEM = "item"
        const val STEP_LOCATION = "location"
        const val STEP_CONFIRM = "confirm"
    }

    var item: ItemEntity? = null
        private set
    var location: LocationEntity? = null
        private set

    val step: String
        get() = when {
            item == null -> STEP_ITEM
            location == null -> STEP_LOCATION
            else -> STEP_CONFIRM
        }

    fun scanItem(raw: String, items: List<ItemEntity>): Boolean {
        val found = Relocation.resolveItem(raw, items) ?: return false
        item = found
        return true
    }

    fun scanLocation(raw: String, locations: List<LocationEntity>): Boolean {
        if (item == null) return false
        val found = Relocation.resolveLocation(raw, locations) ?: return false
        location = found
        return true
    }

    // П3.3: ящик отклонён гейтом ёмкости («полный») — возвращаемся к шагу ящика,
    // выбранную вещь помним.
    fun clearLocation() {
        location = null
    }

    fun confirmText(): String =
        "Кладем «${item?.name ?: ""}» в «${location?.let { Relocation.locationName(it) } ?: ""}»?"

    fun reset() {
        item = null
        location = null
    }
}
