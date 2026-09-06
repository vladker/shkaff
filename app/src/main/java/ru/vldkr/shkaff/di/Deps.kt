package ru.vldkr.shkaff.di

import android.content.Context
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.repository.AttributeRepository
import ru.vldkr.shkaff.data.repository.ItemRepository
import ru.vldkr.shkaff.data.repository.LocationRepository
import ru.vldkr.shkaff.data.repository.StorageRepository
import ru.vldkr.shkaff.util.newId
import java.util.UUID

object Deps {

    lateinit var db: ShkaffDatabase
        private set
    lateinit var deviceId: String
        private set
    lateinit var items: ItemRepository
        private set
    lateinit var locations: LocationRepository
        private set
    lateinit var storages: StorageRepository
        private set
    lateinit var attributes: AttributeRepository
        private set

    private var ready = false

    fun init(ctx: Context) {
        if (ready) return
        val app = ctx.applicationContext
        db = ShkaffDatabase.build(app)
        val meta = db.metaDao()
        deviceId = meta.get("deviceId")
            ?: UUID.randomUUID().toString().also { id ->
                meta.upsert(SchemaMetaEntity("deviceId", id))
            }
        meta.upsert(SchemaMetaEntity("schemaVersion", ShkaffDatabase.SCHEMA_VERSION))
        items = ItemRepository(db)
        locations = LocationRepository(db)
        storages = StorageRepository(db)
        attributes = AttributeRepository(db)
        seedDefaultAttributes()
        ready = true
    }

    private fun seedDefaultAttributes() {
        if (db.attributeDao().count() > 0) return
        val now = System.currentTimeMillis()
        val dev = deviceId
        val defs = listOf(
            AttributeDefEntity(newId(), "*", "note", "Заметка", "text", "[]", 0, false, now, now, null, dev),
            AttributeDefEntity(newId(), "item", "category", "Категория", "select", """["Электроника","Инструменты","Канцелярия","Запчасти","Прочее"]""", 1, false, now, now, null, dev),
            AttributeDefEntity(newId(), "item", "material", "Материал", "text", "[]", 2, false, now, now, null, dev),
            AttributeDefEntity(newId(), "item", "size", "Размер", "text", "[]", 3, false, now, now, null, dev),
            AttributeDefEntity(newId(), "item", "price", "Цена", "number", "[]", 4, false, now, now, null, dev),
            AttributeDefEntity(newId(), "item", "purchase_date", "Дата покупки", "date", "[]", 5, false, now, now, null, dev),
            AttributeDefEntity(newId(), "storage", "room", "Комната", "text", "[]", 1, false, now, now, null, dev),
            AttributeDefEntity(newId(), "location", "zone", "Зона", "text", "[]", 1, false, now, now, null, dev)
        )
        for (d in defs) db.attributeDao().upsert(d)
    }
}
