package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.UserEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.util.newId

// Профили (US-G1). Активный профиль живёт в schema_meta (ключ activeUserId).
class UsersRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.userDao()
    private val meta get() = db.metaDao()

    fun observeAll(): Flow<List<UserEntity>> = dao.observeAll()

    suspend fun byId(id: String): UserEntity? = dao.byId(id)

    suspend fun all(): List<UserEntity> = dao.all()

    suspend fun activeUser(): UserEntity? {
        val id = meta.get("activeUserId") ?: return null
        val u = dao.byId(id) ?: return null
        return if (u.deleted_at == null) u else null
    }

    suspend fun setActive(id: String) {
        if (dao.byId(id) == null) return
        meta.upsert(SchemaMetaEntity("activeUserId", id))
    }

    suspend fun create(name: String, role: Role): UserEntity {
        val now = System.currentTimeMillis()
        val e = UserEntity(
            id = newId(),
            name = name.trim(),
            role = role.preset,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId()
        )
        dao.upsert(e)
        // Первый профиль становится активным автоматически.
        if (meta.get("activeUserId") == null) meta.upsert(SchemaMetaEntity("activeUserId", e.id))
        return e
    }

    suspend fun update(id: String, name: String, role: Role): UserEntity? {
        val e = dao.byId(id) ?: return null
        val u = e.copy(
            name = name.trim(),
            role = role.preset,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        return u
    }

    suspend fun softDelete(id: String) {
        // Нельзя оставить приложение без активного профиля и без последнего.
        if (dao.byId(id)?.deleted_at == null) {
            if (dao.count() <= 1) return
            if (activeUser()?.id == id) {
                val others = dao.all().filter { it.id != id && it.deleted_at == null }
                if (others.isEmpty()) return
                setActive(others.first().id)
            }
        }
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
    }
}