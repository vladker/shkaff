package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import org.json.JSONObject
import ru.vldkr.shkaff.data.db.ActionLogEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

// Журнал действий (US-F2): пишем «кто — что — над чем — когда — с какого устройства».
class ActionLogRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.actionLogDao()

    fun observeRecent(limit: Int = 100): Flow<List<ActionLogEntity>> = dao.observeRecent(limit)

    fun observeFiltered(action: String?, from: Long?, to: Long?, limit: Int = 100): Flow<List<ActionLogEntity>> =
        dao.observeFiltered(action, from, to, limit)

    suspend fun log(
        action: String,
        entityType: String = "",
        entityId: String = "",
        detail: Map<String, String> = emptyMap()
    ) {
        val now = System.currentTimeMillis()
        val user = db.userDao().run {
            metaActive?.let { byId(it) }
        }
        dao.upsert(
            ActionLogEntity(
                id = newId(),
                user_id = user?.id,
                user_name = user?.name ?: "",
                action = action,
                entity_type = entityType,
                entity_id = entityId,
                detail = JSONObject(detail).toString(),
                at = now,
                device_id = deviceId()
            )
        )
    }

    // Ограничиваем рост журнала: храним последние ~3 месяца.
    suspend fun prune() {
        val cutoff = System.currentTimeMillis() - 90L * 24 * 3600 * 1000
        dao.deleteOlderThan(cutoff)
    }

    private val metaActive: String?
        get() = db.metaDao().get("activeUserId")
}