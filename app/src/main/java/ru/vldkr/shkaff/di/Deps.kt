package ru.vldkr.shkaff.di

import android.content.Context
import kotlinx.coroutines.runBlocking
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.repository.ActionLogRepository
import ru.vldkr.shkaff.data.repository.AttributeRepository
import ru.vldkr.shkaff.data.repository.DraftRepository
import ru.vldkr.shkaff.data.repository.ItemRepository
import ru.vldkr.shkaff.data.repository.LocationRepository
import ru.vldkr.shkaff.data.repository.LoansRepository
import ru.vldkr.shkaff.data.repository.NumberingService
import ru.vldkr.shkaff.data.repository.StorageRepository
import ru.vldkr.shkaff.data.repository.TagRepository
import ru.vldkr.shkaff.data.repository.UsersRepository
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.util.Expiry
import ru.vldkr.shkaff.util.newId
import java.util.UUID

object Deps {

    lateinit var app: Context
        private set
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
    lateinit var numbering: NumberingService
        private set
    lateinit var tags: TagRepository
        private set
    lateinit var drafts: DraftRepository
        private set
    lateinit var users: UsersRepository
        private set
    lateinit var loans: LoansRepository
        private set
    lateinit var actionLog: ActionLogRepository
        private set

    private var ready = false

    fun init(ctx: Context) {
        if (ready) return
        val app = ctx.applicationContext
        this.app = app
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
        numbering = NumberingService(db)
        tags = TagRepository(db)
        drafts = DraftRepository(db)
        users = UsersRepository(db)
        loans = LoansRepository(db)
        actionLog = ActionLogRepository(db)
        seedDefaultAttributes()
        seedDefaultTemplate()
        backfillExpiryDates()
        seedTagDictionaryOnce()
        seedDefaultProfile()
        pruneJournal()
        ready = true
    }

    fun expiryThresholdDays(): Int =
        meta().get("expiryThresholdDays")?.toIntOrNull()?.coerceIn(1, 365) ?: 90

    fun setExpiryThresholdDays(days: Int) {
        meta().upsert(SchemaMetaEntity("expiryThresholdDays", days.toString()))
    }

    fun numberingAuto(): Boolean = meta().get("numberingAuto") != "false"

    fun setNumberingAuto(on: Boolean) {
        meta().upsert(SchemaMetaEntity("numberingAuto", if (on) "true" else "false"))
    }

    // Профиль (US-G1): при первом запуске заводим «Админ», чтобы было с кого начать.
    private fun seedDefaultProfile() {
        if (db.userDao().count() > 0) return
        runBlocking { users.create("Админ", Role.ADMIN) }
    }

    private fun pruneJournal() {
        runBlocking { actionLog.prune() }
    }

    private fun meta() = db.metaDao()

    // Словарь тегов (US-I4) — справочник для подсказок; источник истины — item.tags,
    // поэтому словарь досевается из вещей один раз (повторный запуск безопасен).
    private fun seedTagDictionaryOnce() {
        if (meta().get("tagsDictSeeded") == "1") return
        val items = runBlocking { db.itemDao().allWithDeleted() }
        for (i in items) {
            for (t in TagsJson.toList(i.tags)) {
                runBlocking { tags.add(t) }
            }
        }
        meta().upsert(SchemaMetaEntity("tagsDictSeeded", "1"))
    }

    private fun backfillExpiryDates() {
        if (meta().get("expiryBackfilled") == "1") return
        // одноразово копируем срок из атрибута «Срок годности» (expired) в отдельное поле
        val now = System.currentTimeMillis()
        val dev = deviceId
        val items = runBlocking { db.itemDao().allWithDeleted() }
        for (i in items) {
            if (i.expiry_date != null) continue
            val attrs = AttrJson.toMap(i.attributes)
            val raw = attrs["expired"] ?: continue
            val iso = Expiry.normalize(raw) ?: continue
            runBlocking {
                db.itemDao().upsert(i.copy(
                    expiry_date = iso,
                    updated_at = now,
                    device_last_modified = dev
                ))
            }
        }
        meta().upsert(SchemaMetaEntity("expiryBackfilled", "1"))
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
