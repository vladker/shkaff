package ru.vldkr.shkaff.data.repository

import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.domain.numbering.Numbering

// Настройки автонумерации (префикс и ширина) по типам объектов; хранятся в schema_meta.
class NumberingService(private val db: ShkaffDatabase) {

    data class Settings(val prefix: String, val width: Int)

    private fun prefixKey(scope: String) = "numberPrefix_$scope"
    private fun widthKey(scope: String) = "numberWidth_$scope"

    suspend fun settings(scope: String): Settings {
        val meta = db.metaDao()
        val p = meta.get(prefixKey(scope))
        val w = meta.get(widthKey(scope))
        return Settings(
            prefix = if (p == null) defaultPrefix(scope) else p.trim(),
            width = w?.toIntOrNull()?.coerceIn(0, 20) ?: defaultWidth(scope)
        )
    }

    suspend fun saveSettings(scope: String, prefix: String, width: Int) {
        db.metaDao().upsert(SchemaMetaEntity(prefixKey(scope), prefix.trim()))
        db.metaDao().upsert(SchemaMetaEntity(widthKey(scope), width.coerceIn(0, 20).toString()))
    }

    fun defaultPrefix(scope: String): String = when (scope) {
        Numbering.SCOPE_ITEM -> "T"
        Numbering.SCOPE_LOCATION -> "B"
        Numbering.SCOPE_STORAGE -> "S"
        else -> ""
    }

    fun defaultWidth(scope: String): Int = when (scope) {
        Numbering.SCOPE_ITEM -> 3
        Numbering.SCOPE_LOCATION -> 2
        Numbering.SCOPE_STORAGE -> 2
        else -> 3
    }

    // Следующий свободный номер серии по списку уже занятых значений.
    suspend fun nextFreeCode(scope: String, existing: List<String>): String {
        val s = settings(scope)
        return Numbering.format(s.prefix, Numbering.nextAfter(existing, s.prefix), s.width)
    }
}
