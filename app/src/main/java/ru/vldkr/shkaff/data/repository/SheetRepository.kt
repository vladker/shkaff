package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.SheetLayoutEntity
import ru.vldkr.shkaff.data.db.SheetSlotEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

// Листы этикеток: мастер sheet_layout (бумага + поле) и слоты sheet_slot (этикетки на листе).
// Геометрия слота хранится в самом слоте; стиль — в связанном шаблоне этикетки (style_template_id).
// Удаление листа каскадно чистит его слоты (FK ON DELETE CASCADE + явная чистка в softDelete).
class SheetRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.sheetLayoutDao()
    private val slotDao get() = db.sheetSlotDao()

    fun observeLayouts(): Flow<List<SheetLayoutEntity>> = dao.observeAll()

    suspend fun byId(id: String): SheetLayoutEntity? = dao.byId(id)

    suspend fun count(): Int = dao.count()

    fun observeSlots(layoutId: String): Flow<List<SheetSlotEntity>> = slotDao.observeByLayout(layoutId)

    suspend fun slots(layoutId: String): List<SheetSlotEntity> = slotDao.byLayout(layoutId)

    suspend fun slotById(id: String): SheetSlotEntity? = slotDao.byId(id)

    suspend fun createLayout(name: String, paperWmm: Double, paperHmm: Double, marginMm: Double = 0.0): SheetLayoutEntity {
        val now = System.currentTimeMillis()
        val dev = deviceId()
        val e = SheetLayoutEntity(
            id = newId(),
            name = name.trim(),
            paper_w_mm = paperWmm,
            paper_h_mm = paperHmm,
            margin_mm = marginMm,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = dev
        )
        dao.upsert(e)
        Deps.actionLog.log("create", "sheet_layout", e.id, mapOf("name" to e.name))
        return e
    }

    suspend fun updateLayout(id: String, name: String, paperWmm: Double, paperHmm: Double, marginMm: Double): SheetLayoutEntity? {
        val e = dao.byId(id) ?: return null
        val u = e.copy(
            name = name.trim(),
            paper_w_mm = paperWmm,
            paper_h_mm = paperHmm,
            margin_mm = marginMm,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        dao.upsert(u)
        Deps.actionLog.log("update", "sheet_layout", u.id, mapOf("name" to u.name))
        return u
    }

    suspend fun addSlot(
        layoutId: String,
        xMm: Double,
        yMm: Double,
        wMm: Double,
        hMm: Double,
        styleTemplateId: String
    ): SheetSlotEntity {
        val layout = dao.byId(layoutId) ?: throw IllegalStateException("Нет листа: $layoutId")
        val now = System.currentTimeMillis()
        val dev = deviceId()
        val maxOrder = slotDao.byLayout(layoutId).maxOfOrNull { it.sort_order } ?: -1
        val s = SheetSlotEntity(
            id = newId(),
            layout_id = layoutId,
            x_mm = xMm,
            y_mm = yMm,
            w_mm = wMm,
            h_mm = hMm,
            style_template_id = styleTemplateId,
            sort_order = maxOrder + 1,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = dev
        )
        slotDao.upsert(s)
        dao.upsert(layout.copy(updated_at = now, device_last_modified = dev))
        Deps.actionLog.log("update", "sheet_layout", layoutId, mapOf("slot" to s.id))
        return s
    }

    suspend fun updateSlot(
        id: String,
        xMm: Double,
        yMm: Double,
        wMm: Double,
        hMm: Double,
        styleTemplateId: String
    ): SheetSlotEntity? {
        val s = slotDao.byId(id) ?: return null
        val u = s.copy(
            x_mm = xMm,
            y_mm = yMm,
            w_mm = wMm,
            h_mm = hMm,
            style_template_id = styleTemplateId,
            updated_at = System.currentTimeMillis(),
            device_last_modified = deviceId()
        )
        slotDao.upsert(u)
        dao.byId(s.layout_id)?.let { l ->
            dao.upsert(l.copy(updated_at = System.currentTimeMillis(), device_last_modified = deviceId()))
        }
        return u
    }

    // Перестановка слотов: orderedIds — полный список id слотов листа в новом порядке.
    suspend fun reorderSlots(layoutId: String, orderedIds: List<String>) {
        val now = System.currentTimeMillis()
        val dev = deviceId()
        val current = slotDao.byLayout(layoutId)
        orderedIds.forEachIndexed { idx, sid ->
            current.firstOrNull { it.id == sid }?.let {
                if (it.sort_order != idx) {
                    slotDao.upsert(it.copy(sort_order = idx, updated_at = now, device_last_modified = dev))
                }
            }
        }
        dao.byId(layoutId)?.let { l ->
            dao.upsert(l.copy(updated_at = now, device_last_modified = dev))
        }
    }

    suspend fun removeSlot(slotId: String, layoutId: String) {
        slotDao.softDelete(slotId, System.currentTimeMillis(), deviceId())
        dao.byId(layoutId)?.let { l ->
            dao.upsert(l.copy(updated_at = System.currentTimeMillis(), device_last_modified = deviceId()))
        }
    }

    suspend fun softDeleteLayout(id: String) {
        val e = dao.byId(id)
        val now = System.currentTimeMillis()
        val dev = deviceId()
        dao.softDelete(id, now, dev)
        // Мягко удаляем и слоты: FK-каскад срабатывает только на hard delete.
        slotDao.byLayout(id).forEach { slotDao.softDelete(it.id, now, dev) }
        e?.let { Deps.actionLog.log("delete", "sheet_layout", id, mapOf("name" to it.name)) }
    }

    suspend fun hardDeleteLayout(id: String) {
        // Явно чистим слоты, затем лист (FK-каскад — запасной путь).
        slotDao.hardDeleteByLayout(id)
        dao.hardDelete(id)
    }
}
