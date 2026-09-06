package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase

class AttributeRepository(private val db: ShkaffDatabase) {

    private val dao get() = db.attributeDao()

    fun observeAll(): Flow<List<AttributeDefEntity>> = dao.observeAll()

    suspend fun forScope(scope: String): List<AttributeDefEntity> = dao.forScope(scope)

    suspend fun byId(id: String): AttributeDefEntity? = dao.byId(id)

    suspend fun upsert(a: AttributeDefEntity) {
        dao.upsert(a)
    }

    suspend fun remove(id: String) {
        dao.delete(id)
    }

    suspend fun count(): Int = dao.count()
}
