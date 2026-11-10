package ru.vldkr.shkaff.domain.locations

/**
 * T-041: местоположение вещи определяется только по живым ящикам.
 * Ссылка `location_id` на мягко удалённый ящик — «призрак»: такое осталось в старых
 * базах (удаление ящика не снимало ссылку) и приходит из слияний/бэкапов. Везде, где
 * решается «есть ли у вещи место», призрак считается отсутствием места.
 */
object LocationPlacement {

    /** Действительная локация вещи: null, если ссылки нет или ящик не жив. */
    fun resolve(itemLocationId: String?, liveLocationIds: Set<String>): String? =
        itemLocationId?.takeIf { it in liveLocationIds }

    fun hasPlace(itemLocationId: String?, liveLocationIds: Set<String>): Boolean =
        resolve(itemLocationId, liveLocationIds) != null
}
