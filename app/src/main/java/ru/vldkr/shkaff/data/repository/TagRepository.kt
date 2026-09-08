package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.TagEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

class TagRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.tagDao()

    fun observeAll(): Flow<List<TagEntity>> = dao.observeAll()

    suspend fun all(): List<TagEntity> = dao.all()

    suspend fun count(): Int = dao.count()

    // Возвращает существующий тег с таким именем (без учёта регистра) или создаёт новый
    suspend fun add(name: String): TagEntity {
        val t = name.trim()
        if (t.isEmpty()) throw IllegalArgumentException("Пустое имя тега")
        dao.all().firstOrNull { it.name.equals(t, ignoreCase = true) }?.let { return it }
        val now = System.currentTimeMillis()
        val e = TagEntity(newId(), t, now, null, deviceId())
        dao.upsert(e)
        return e
    }

    suspend fun remove(id: String) {
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
    }

    suspend fun upsertAll(list: List<TagEntity>) {
        dao.upsertAll(list)
    }
}
