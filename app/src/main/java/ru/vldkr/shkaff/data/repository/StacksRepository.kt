package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.numbering.Numbering
import ru.vldkr.shkaff.util.newId

// Стеки (US-E2): группа вещей/хранилищ с собственным номером. Члены не переносятся
// и сохраняют идентичность — стек лишь дополнительный взгляд на объекты.
class StacksRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId },
    private val numbering: () -> NumberingService = { Deps.numbering }
) {
    private val dao get() = db.stackDao()
    private val memberDao get() = db.stackMemberDao()

    fun observeAll(): Flow<List<StackEntity>> = dao.observeAll()

    suspend fun byId(id: String): StackEntity? = dao.byId(id)

    suspend fun count(): Int = dao.count()

    suspend fun members(stackId: String): List<StackMemberEntity> = memberDao.byStack(stackId)

    suspend fun groupsForEntity(entityType: String, entityId: String): List<StackMemberEntity> =
        memberDao.groupsForEntity(entityType, entityId)

    private suspend fun resolveCode(input: String): String {
        if (input.isEmpty()) return numbering().nextFreeCode(Numbering.SCOPE_STACK, dao.allCodes())
        if (dao.existsByCode(input) > 0) throw IllegalStateException("Номер уже занят: $input")
        return input
    }

    suspend fun create(name: String, code: String = "", members: List<Pair<String, String>> = emptyList()): StackEntity {
        val now = System.currentTimeMillis()
        val dev = deviceId()
        val e = StackEntity(
            id = newId(),
            name = name.trim(),
            code = resolveCode(code.trim()),
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = dev
        )
        dao.upsert(e)
        members.forEachIndexed { idx, (entityType, entityId) ->
            val m = StackMemberEntity(
                id = newId(),
                stack_id = e.id,
                entity_type = entityType,
                entity_id = entityId,
                sort_order = idx,
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev
            )
            memberDao.upsert(m)
        }
        Deps.actionLog.log("create", "stack", e.id, mapOf("name" to e.name, "code" to e.code, "members" to members.size.toString()))
        return e
    }

    suspend fun rename(id: String, name: String, code: String = ""): StackEntity? {
        val e = dao.byId(id) ?: return null
        val newCode = code.trim()
        if (newCode.isNotEmpty() && newCode != e.code && dao.existsByCode(newCode, id) > 0)
            throw IllegalStateException("Номер уже занят: $newCode")
        val u = e.copy(
            name = name.trim(),
            code = if (newCode.isEmpty()) e.code else newCode,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        Deps.actionLog.log("update", "stack", u.id, mapOf("name" to u.name))
        return u
    }

    suspend fun addMember(stackId: String, entityType: String, entityId: String) {
        val stack = dao.byId(stackId) ?: return
        val now = System.currentTimeMillis()
        val dev = deviceId()
        val existing = memberDao.byStack(stackId).any { it.entity_type == entityType && it.entity_id == entityId }
        if (existing) return
        val maxOrder = memberDao.byStack(stackId).maxOfOrNull { it.sort_order } ?: -1
        memberDao.upsert(
            StackMemberEntity(
                id = newId(),
                stack_id = stackId,
                entity_type = entityType,
                entity_id = entityId,
                sort_order = maxOrder + 1,
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev
            )
        )
        dao.upsert(stack.copy(updated_at = now, device_last_modified = dev))
        Deps.actionLog.log("update", "stack", stackId, mapOf("member" to "$entityType:$entityId"))
    }

    suspend fun removeMember(memberId: String, stackId: String) {
        memberDao.softDelete(memberId, System.currentTimeMillis(), deviceId())
        dao.byId(stackId)?.let { s ->
            dao.upsert(s.copy(updated_at = System.currentTimeMillis(), device_last_modified = deviceId()))
        }
    }

    suspend fun softDelete(id: String) {
        val e = dao.byId(id)
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("delete", "stack", id, mapOf("name" to it.name)) }
    }

    suspend fun hardDelete(id: String) {
        dao.hardDelete(id)
    }
}