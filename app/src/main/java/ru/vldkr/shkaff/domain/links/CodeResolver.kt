package ru.vldkr.shkaff.domain.links

import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StackEntity

// Разбор отсканированного кода (QR ящика/вещи) во внутренний код и в объект.
// Чистая логика без Android/DI — резолверы передаются извне, удобно тестировать.
object CodeResolver {

    // Внутренний код из deep-link (shkaff://...) либо исходная строка как есть.
    fun innerCode(scanned: String): String {
        val raw = scanned.trim()
        if (raw.isEmpty()) return ""
        return AppLink.parse(raw) ?: raw
    }

    // Ящик/локация: сначала по её коду (label), затем по коду вещи → её location_id.
    suspend fun resolveLocation(
        scanned: String,
        locationByLabel: suspend (String) -> LocationEntity?,
        locationOfItemCode: suspend (String) -> LocationEntity?,
    ): LocationEntity? {
        val code = innerCode(scanned)
        if (code.isEmpty()) return null
        return locationByLabel(code) ?: locationOfItemCode(code)
    }

    // Вещь: по её коду.
    suspend fun resolveItem(
        scanned: String,
        itemByCode: suspend (String) -> ItemEntity?,
    ): ItemEntity? {
        val code = innerCode(scanned)
        if (code.isEmpty()) return null
        return itemByCode(code)
    }

    // Стек (T-016, US-E2): сначала по номеру стека, затем по id карточки —
    // QR без номера (старые записи) резолвится через id.
    suspend fun resolveStack(
        scanned: String,
        stackByCode: suspend (String) -> StackEntity?,
        stackById: suspend (String) -> StackEntity?,
    ): StackEntity? {
        val code = innerCode(scanned)
        if (code.isEmpty()) return null
        return stackByCode(code) ?: stackById(code)
    }
}
