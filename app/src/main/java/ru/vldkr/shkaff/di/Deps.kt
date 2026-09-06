package ru.vldkr.shkaff.di

import android.content.Context
import kotlinx.coroutines.runBlocking
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
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
        seedDefaultTemplate()
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

    private fun seedDefaultTemplate() {
        if (db.labelTemplateDao().count() > 0) return
        val now = System.currentTimeMillis()
        val t = LabelTemplateEntity(
            id = newId(),
            name = "QR 58×40",
            format = "QR",
            width_mm = 58.0,
            height_mm = 40.0,
            margin_mm = 3.0,
            show_text = true,
            text_content = "{name} {code}",
            font_size = 12.0,
            text_color = "#000000",
            bg_color = "#FFFFFF",
            invert = false,
            logo_path = null,
            quiet_zone = true,
            created_at = now,
            updated_at = now,
            deleted_at = null,
            device_last_modified = deviceId
        )
        runBlocking { db.labelTemplateDao().upsert(t) }
    }
}
