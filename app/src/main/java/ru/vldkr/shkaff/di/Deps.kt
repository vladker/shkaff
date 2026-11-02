package ru.vldkr.shkaff.di

import android.content.Context
import kotlinx.coroutines.runBlocking
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.catalog.AttributeCatalog
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.llm.ModelStore
import ru.vldkr.shkaff.data.repository.ActionLogRepository
import ru.vldkr.shkaff.data.repository.AttributeRepository
import ru.vldkr.shkaff.data.repository.BasketRepository
import ru.vldkr.shkaff.data.repository.DraftRepository
import ru.vldkr.shkaff.data.repository.ItemRepository
import ru.vldkr.shkaff.data.repository.LocationRepository
import ru.vldkr.shkaff.data.repository.LoansRepository
import ru.vldkr.shkaff.data.repository.SheetRepository
import ru.vldkr.shkaff.data.repository.StacksRepository
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
    lateinit var stacks: StacksRepository
        private set
    lateinit var baskets: BasketRepository
        private set
    lateinit var sheets: SheetRepository
        private set
    lateinit var modelStore: ModelStore
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
        tags = TagRepository(db)
        drafts = DraftRepository(db)
        users = UsersRepository(db)
        loans = LoansRepository(db)
        actionLog = ActionLogRepository(db)
        stacks = StacksRepository(db)
        baskets = BasketRepository(db)
        sheets = SheetRepository(db)
        modelStore = ModelStore(app)
        seedDefaultAttributes()
        seedClimateAttributeDefs()
        seedAvitoPriceAttribute()
        seedAttributeCatalogOnce()
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

    // Тема UI: тёмная — по умолчанию; «light» — светлая (инвертированная белая).
    fun themeIsLight(): Boolean = meta().get("themeMode") == "light"

    fun setThemeLight(light: Boolean) {
        meta().upsert(SchemaMetaEntity("themeMode", if (light) "light" else "dark"))
    }

    // LLM-агент (US-B3): облако / локаль (Ollama), OpenAI-совместимый API.
    fun agentSettings(): ru.vldkr.shkaff.domain.agent.AgentSettings {
        val m = meta()
        // Нет сохранённого значения → преднастроенный домашний Qwen 27B;
        // сохранённая пустая строка — уважает намеренно очищенное поле.
        return ru.vldkr.shkaff.domain.agent.AgentSettings(
            enabled = m.get("agentEnabled") == "1",
            provider = m.get("agentProvider") ?: "cloud",
            baseUrl = m.get("agentBaseUrl") ?: "http://192.168.56.1:1234/v1",
            apiKey = m.get("agentApiKey").orEmpty(),
            model = m.get("agentModel") ?: "qwen/qwen3.8-27b"
        )
    }

    fun saveAgentSettings(s: ru.vldkr.shkaff.domain.agent.AgentSettings) {
        val m = meta()
        m.upsert(SchemaMetaEntity("agentEnabled", if (s.enabled && !s.model.isBlank()) "1" else "0"))
        m.upsert(SchemaMetaEntity("agentProvider", s.provider))
        m.upsert(SchemaMetaEntity("agentBaseUrl", s.baseUrl))
        m.upsert(SchemaMetaEntity("agentApiKey", s.apiKey))
        m.upsert(SchemaMetaEntity("agentModel", s.model))
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
            AttributeDefEntity(newId(), "*", "note", "Заметка", "text", "[]", 0, false, now, now, null, dev, "*", "free"),
            AttributeDefEntity(newId(), "item", "category", "Категория", "select", AttributeCatalog.itemCategoriesJson(), 1, true, now, now, null, dev, "*", "min"),
            AttributeDefEntity(newId(), "item", "material", "Материал", "text", "[]", 2, false, now, now, null, dev, "*", "rec"),
            AttributeDefEntity(newId(), "item", "size", "Размер", "text", "[]", 3, false, now, now, null, dev, "*", "rec"),
            AttributeDefEntity(newId(), "item", "price", "Цена", "number", "[]", 4, false, now, now, null, dev, "*", "rec"),
            AttributeDefEntity(newId(), "item", "purchase_date", "Дата покупки", "date", "[]", 5, false, now, now, null, dev, "*", "free"),
            AttributeDefEntity(newId(), "storage", "room", "Комната", "text", "[]", 1, false, now, now, null, dev, "*", "rec"),
            AttributeDefEntity(newId(), "location", "zone", "Зона", "text", "[]", 1, false, now, now, null, dev, "*", "rec")
        )
        for (d in defs) db.attributeDao().upsert(d)
    }

    // US-C5: атрибуты климата хранилища спорятся один раз (и для пустой, и для
    // существующей базы); источник копируется также, как и в пустую базу — не из сида.
    private fun seedClimateAttributeDefs() {
        if (meta().get("climateDefsSeeded") == "1") return
        val now = System.currentTimeMillis()
        val dev = deviceId
        val defs = listOf(
            AttributeDefEntity(newId(), "storage", "temperature_c", "Температура, °C", "number", "[]", 2, false, now, now, null, dev, "*", "rec"),
            AttributeDefEntity(newId(), "storage", "humidity_pct", "Влажность, %", "number", "[]", 3, false, now, now, null, dev, "*", "rec")
        )
        for (d in defs) db.attributeDao().upsert(d)
        meta().upsert(SchemaMetaEntity("climateDefsSeeded", "1"))
    }

    // Новое поле «Цена Авито, ₽» добираем отдельным one-shot флагом: общий каталог
    // (attrCatalogV2Seeded) на установленных базах уже сидирован и не перезапускается.
    private fun seedAvitoPriceAttribute() {
        if (meta().get("avitoPriceSeeded") == "1") return
        val now = System.currentTimeMillis()
        val dao = db.attributeDao()
        val exists = runBlocking { dao.allWithDeleted() }.any { it.scope == "item" && it.key == "avito_price" }
        if (!exists) {
            dao.upsert(
                AttributeDefEntity(
                    id = newId(), scope = "item", key = "avito_price", label = "Цена Авито, ₽",
                    type = "number", options = "[]", sort_order = 17, required = false,
                    created_at = now, updated_at = now, deleted_at = null,
                    device_last_modified = deviceId, category = "*", tier = "rec"
                )
            )
        }
        meta().upsert(SchemaMetaEntity("avitoPriceSeeded", "1"))
    }

    // Справочник атрибутов (категории + уровни min/rec/free) досевается один раз.
    // Существующие пользовательские атрибуты не затираются.
    private fun seedAttributeCatalogOnce() {
        if (meta().get("attrCatalogV2Seeded") == "1") return
        val now = System.currentTimeMillis()
        val dev = deviceId
        val dao = db.attributeDao()
        val allRows = runBlocking { dao.allWithDeleted() }
        val live = allRows.filter { it.deleted_at == null }
        val allByKey = allRows.associateBy { Pair(it.scope, it.key) }

        // Категория вещей: обязательный select по справочнику.
        // Если пользователь удалил атрибут — восстанавливаем его, чтобы форма вещи работала.
        val itemCategory = live.firstOrNull { it.scope == "item" && it.key == "category" }
            ?: allRows.firstOrNull { it.scope == "item" && it.key == "category" }
        if (itemCategory != null) {
            dao.upsert(itemCategory.copy(
                options = AttributeCatalog.itemCategoriesJson(),
                category = "*",
                tier = "min",
                required = true,
                deleted_at = null,
                updated_at = now,
                device_last_modified = dev
            ))
        } else {
            dao.upsert(AttributeDefEntity(
                id = newId(), scope = "item", key = "category", label = "Категория",
                type = "select", options = AttributeCatalog.itemCategoriesJson(),
                sort_order = 1, required = true, created_at = now, updated_at = now,
                deleted_at = null, device_last_modified = dev, category = "*", tier = "min"
            ))
        }

        // Категория хранилищ: обязательный select по справочнику.
        val storageCategory = live.firstOrNull { it.scope == "storage" && it.key == "category" }
            ?: allRows.firstOrNull { it.scope == "storage" && it.key == "category" }
        if (storageCategory != null) {
            dao.upsert(storageCategory.copy(
                options = AttributeCatalog.storageCategoriesJson(),
                category = "*",
                tier = "min",
                required = true,
                deleted_at = null,
                updated_at = now,
                device_last_modified = dev
            ))
        } else {
            dao.upsert(AttributeDefEntity(
                id = newId(), scope = "storage", key = "category", label = "Категория",
                type = "select", options = AttributeCatalog.storageCategoriesJson(),
                sort_order = 1, required = true, created_at = now, updated_at = now,
                deleted_at = null, device_last_modified = dev, category = "*", tier = "min"
            ))
        }

        for (s in AttributeCatalog.specs) {
            val k = s.scope to s.key
            // Мягко удалённые пользователем атрибуты не восстанавливаем.
            if (allByKey.containsKey(k)) continue
            dao.upsert(AttributeDefEntity(
                id = newId(),
                scope = s.scope,
                key = s.key,
                label = s.label,
                type = s.type,
                options = AttributeCatalog.optionsJson(s.options),
                sort_order = s.sort_order,
                required = s.tier == "min",
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev,
                category = s.category,
                tier = s.tier
            ))
        }

        meta().upsert(SchemaMetaEntity("attrCatalogV2Seeded", "1"))
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
            text_content = "{name}",
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
