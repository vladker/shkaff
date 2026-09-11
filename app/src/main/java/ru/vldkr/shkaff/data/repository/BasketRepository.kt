package ru.vldkr.shkaff.data.repository

import kotlinx.coroutines.flow.Flow
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.newId

// Корзина извлечения (US-E1): список вещей «на вынос» с чеклистом по месту.
// Объекты в корзину только добавляются — сама корзина ничего не перемещает.
class BasketRepository(
    private val db: ShkaffDatabase,
    private val deviceId: () -> String = { Deps.deviceId }
) {
    private val dao get() = db.basketDao()
    private val itemDao get() = db.basketItemDao()

    fun observeAll(): Flow<List<BasketEntity>> = dao.observeAll()

    fun observeActive(): Flow<List<BasketEntity>> = dao.observeActive()

    suspend fun byId(id: String): BasketEntity? = dao.byId(id)

    suspend fun items(basketId: String): List<BasketItemEntity> = itemDao.byBasket(basketId)

    suspend fun countItems(basketId: String): Int = itemDao.countByBasket(basketId)

    suspend fun countPicked(basketId: String): Int = itemDao.countPickedByBasket(basketId)

    suspend fun create(name: String, status: String = "active"): BasketEntity {
        val now = System.currentTimeMillis()
        val dev = deviceId()
        val e = BasketEntity(
            id = newId(),
            name = name.trim().ifBlank { "Корзина" },
            status = status,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = dev
        )
        dao.upsert(e)
        Deps.actionLog.log("create", "basket", e.id, mapOf("name" to e.name))
        return e
    }

    suspend fun rename(id: String, name: String) {
        val e = dao.byId(id) ?: return
        dao.upsert(e.copy(name = name.trim(), updated_at = System.currentTimeMillis(), device_last_modified = deviceId()))
        Deps.actionLog.log("update", "basket", id, mapOf("name" to name.trim()))
    }

    suspend fun setStatus(id: String, status: String) {
        val e = dao.byId(id) ?: return
        dao.upsert(e.copy(status = status, updated_at = System.currentTimeMillis(), device_last_modified = deviceId()))
        Deps.actionLog.log("update", "basket", id, mapOf("status" to status))
    }

    // Добавить вещь в корзину; повторное добавление той же вещи игнорируется.
    suspend fun addItem(basketId: String, itemId: String): Boolean {
        val basket = dao.byId(basketId) ?: return false
        if (itemDao.exists(basketId, itemId) > 0) return false
        val now = System.currentTimeMillis()
        val dev = deviceId()
        itemDao.upsert(
            BasketItemEntity(
                id = newId(),
                basket_id = basketId,
                item_id = itemId,
                picked_ts = null,
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev
            )
        )
        dao.upsert(basket.copy(updated_at = now, device_last_modified = dev))
        Deps.actionLog.log("update", "basket", basketId, mapOf("member" to "item:$itemId"))
        return true
    }

    suspend fun removeItem(basketItemId: String, basketId: String) {
        itemDao.softDelete(basketItemId, System.currentTimeMillis(), deviceId())
        dao.byId(basketId)?.let { b ->
            dao.upsert(b.copy(updated_at = System.currentTimeMillis(), device_last_modified = deviceId()))
        }
    }

    suspend fun setPicked(basketItemId: String, picked: Boolean) {
        val now = System.currentTimeMillis()
        itemDao.updatePicked(basketItemId, if (picked) now else null, now, deviceId())
    }

    suspend fun softDelete(id: String) {
        val e = dao.byId(id)
        dao.softDelete(id, System.currentTimeMillis(), deviceId())
        e?.let { Deps.actionLog.log("delete", "basket", id, mapOf("name" to it.name)) }
    }

    suspend fun hardDelete(id: String) {
        itemDao.hardDeleteByBasket(id)
        dao.hardDelete(id)
    }
}