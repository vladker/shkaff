package ru.vldkr.shkaff.sync

import android.content.Context
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.ConflictLogEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelDocEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.data.db.TagEntity
import ru.vldkr.shkaff.data.db.UserEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

data class PendingMerge(
    val local: MergeInput,
    val remote: MergeInput,
    val result: MergeResult,
    val warnings: List<String>
)

object MergeSession {

    var pending: PendingMerge? = null
        private set

    fun start(local: MergeInput, remote: MergeInput, result: MergeResult, warnings: List<String>) {
        pending = PendingMerge(local, remote, result, warnings)
    }

    fun clear() {
        pending = null
    }

    fun resolutionKey(table: String, id: String): String = "$table/$id"

    fun applyResolutions(
        merged: MergeInput,
        local: MergeInput,
        remote: MergeInput,
        resolutions: Map<String, String>
    ): MergeInput {
        var out = merged
        for ((key, choice) in resolutions) {
            val sep = key.indexOf('/')
            if (sep <= 0) continue
            val table = key.substring(0, sep)
            val id = key.substring(sep + 1)
            val row = when (choice) {
                "remote" -> rowOf(remote, table, id) ?: continue
                else -> rowOf(local, table, id) ?: continue
            }
            out = replaceRow(out, table, id, row)
        }
        return out
    }

    suspend fun commitMerge(ctx: Context, p: PendingMerge, resolutions: Map<String, String>) {
        val merged = applyResolutions(p.result.merged, p.local, p.remote, resolutions)
        Backup.applyMerge(p.result.copy(merged = merged), Deps.db)

        val now = System.currentTimeMillis()
        for (c in p.result.conflicts) {
            val chosen = resolutions[resolutionKey(c.table, c.id)] ?: c.resolution
            Deps.db.conflictDao().upsert(
                ConflictLogEntity(
                    id = newId(),
                    entity_type = c.table,
                    entity_id = c.id,
                    field = "*",
                    value_a = c.localRow,
                    value_b = c.remoteRow,
                    chosen = chosen,
                    resolved_at = now,
                    device_id = Deps.deviceId
                )
            )
        }
        Deps.db.metaDao().upsert(SchemaMetaEntity("lastSyncWatermark", now.toString()))
    }

    fun rowOf(input: MergeInput, table: String, id: String): Any? = when (table) {
        "attribute_defs" -> input.attributeDefs.firstOrNull { it.id == id }
        "storages" -> input.storages.firstOrNull { it.id == id }
        "locations" -> input.locations.firstOrNull { it.id == id }
        "items" -> input.items.firstOrNull { it.id == id }
        "annotations" -> input.annotations.firstOrNull { it.id == id }
        "label_templates" -> input.labelTemplates.firstOrNull { it.id == id }
        "label_docs" -> input.labelDocs.firstOrNull { it.id == id }
        "printers" -> input.printers.firstOrNull { it.id == id }
        // T-066: движок конфликтует и эти таблицы — без веток выбор пользователя
        // молча пропадал (applyResolutions уходил в continue по rowOf == null).
        "tags" -> input.tags.firstOrNull { it.id == id }
        "users" -> input.users.firstOrNull { it.id == id }
        "loans" -> input.loans.firstOrNull { it.id == id }
        "stacks" -> input.stacks.firstOrNull { it.id == id }
        "stack_members" -> input.stackMembers.firstOrNull { it.id == id }
        "baskets" -> input.baskets.firstOrNull { it.id == id }
        "basket_items" -> input.basketItems.firstOrNull { it.id == id }
        else -> null
    }

    private fun replaceRow(input: MergeInput, table: String, id: String, row: Any): MergeInput = when (table) {
        "attribute_defs" -> input.copy(attributeDefs = input.attributeDefs.map { if (it.id == id) row as AttributeDefEntity else it })
        "storages" -> input.copy(storages = input.storages.map { if (it.id == id) row as StorageEntity else it })
        "locations" -> input.copy(locations = input.locations.map { if (it.id == id) row as LocationEntity else it })
        "items" -> input.copy(items = input.items.map { if (it.id == id) row as ItemEntity else it })
        "annotations" -> input.copy(annotations = input.annotations.map { if (it.id == id) row as AnnotationEntity else it })
        "label_templates" -> input.copy(labelTemplates = input.labelTemplates.map { if (it.id == id) row as LabelTemplateEntity else it })
        "label_docs" -> input.copy(labelDocs = input.labelDocs.map { if (it.id == id) row as LabelDocEntity else it })
        "printers" -> input.copy(printers = input.printers.map { if (it.id == id) row as PrinterProfileEntity else it })
        "tags" -> input.copy(tags = input.tags.map { if (it.id == id) row as TagEntity else it })
        "users" -> input.copy(users = input.users.map { if (it.id == id) row as UserEntity else it })
        "loans" -> input.copy(loans = input.loans.map { if (it.id == id) row as LoanEntity else it })
        "stacks" -> input.copy(stacks = input.stacks.map { if (it.id == id) row as StackEntity else it })
        "stack_members" -> input.copy(stackMembers = input.stackMembers.map { if (it.id == id) row as StackMemberEntity else it })
        "baskets" -> input.copy(baskets = input.baskets.map { if (it.id == id) row as BasketEntity else it })
        "basket_items" -> input.copy(basketItems = input.basketItems.map { if (it.id == id) row as BasketItemEntity else it })
        else -> input
    }
}
