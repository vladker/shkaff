package ru.vldkr.shkaff.sync

import androidx.room.withTransaction
import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.db.ShkaffDatabase
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.data.db.TagEntity
import ru.vldkr.shkaff.data.db.UserEntity
import java.io.File
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

object Backup {

    const val FORMAT = "shkaff-backup"
    const val VERSION = 1

    suspend fun buildInput(db: ShkaffDatabase): MergeInput = MergeInput(
        attributeDefs = db.attributeDao().allWithDeleted(),
        storages = db.storageDao().allWithDeleted(),
        locations = db.locationDao().allWithDeleted(),
        items = db.itemDao().allWithDeleted(),
        annotations = db.annotationDao().allWithDeleted(),
        labelTemplates = db.labelTemplateDao().allWithDeleted(),
        printers = db.printerDao().allWithDeleted(),
        tags = db.tagDao().allWithDeleted(),
        users = db.userDao().allWithDeleted(),
        loans = db.loanDao().allWithDeleted(),
        stacks = db.stackDao().allWithDeleted(),
        stackMembers = db.stackMemberDao().allWithDeleted(),
        baskets = db.basketDao().allWithDeleted(),
        basketItems = db.basketItemDao().allWithDeleted(),
        lastModified = System.currentTimeMillis()
    )

    private fun o(e: AttributeDefEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("scope", e.scope); put("key", e.key); put("label", e.label)
        put("type", e.type); put("options", e.options)
        put("sort_order", e.sort_order); put("required", e.required)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun attr(j: JSONObject): AttributeDefEntity = AttributeDefEntity(
        id = j.getString("id"), scope = j.optString("scope", "*"),
        key = j.getString("key"), label = j.getString("label"),
        type = j.optString("type", "text"), options = j.optString("options", "[]"),
        sort_order = j.optInt("sort_order", 0), required = j.optBoolean("required", false),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: StorageEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("description", e.description)
        put("attributes", e.attributes); put("parent_id", e.parent_id ?: "")
        put("photo_path", e.photo_path ?: "")
        put("capacity_volume", e.capacity_volume ?: 0.0)
        put("capacity_weight", e.capacity_weight ?: 0.0)
        put("dont_fill_to_brim", e.dont_fill_to_brim)
        put("is_full", e.is_full)
        put("level", e.level)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun stor(j: JSONObject): StorageEntity = StorageEntity(
        id = j.getString("id"), name = j.getString("name"),
        description = j.optString("description", ""),
        attributes = j.optString("attributes", "{}"),
        parent_id = j.optString("parent_id", "").takeIf { it.isNotBlank() },
        photo_path = j.optString("photo_path", "").takeIf { it.isNotBlank() },
        capacity_volume = j.optDouble("capacity_volume", 0.0).takeIf { it > 0 },
        capacity_weight = j.optDouble("capacity_weight", 0.0).takeIf { it > 0 },
        dont_fill_to_brim = j.optBoolean("dont_fill_to_brim", false),
        is_full = j.optBoolean("is_full", false),
        level = j.optString("level", ""),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: LocationEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("storage_id", e.storage_id); put("parent_id", e.parent_id ?: "")
        put("label", e.label); put("name", e.name); put("attributes", e.attributes)
        put("photo_path", e.photo_path ?: "")
        put("capacity_volume", e.capacity_volume ?: 0.0)
        put("capacity_weight", e.capacity_weight ?: 0.0)
        put("dont_fill_to_brim", e.dont_fill_to_brim)
        put("is_full", e.is_full)
        put("level", e.level)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun loc(j: JSONObject): LocationEntity = LocationEntity(
        id = j.getString("id"), storage_id = j.getString("storage_id"),
        parent_id = j.optString("parent_id", "").takeIf { it.isNotBlank() },
        label = j.optString("label", ""), name = j.optString("name", ""),
        attributes = j.optString("attributes", "{}"),
        photo_path = j.optString("photo_path", "").takeIf { it.isNotBlank() },
        capacity_volume = j.optDouble("capacity_volume", 0.0).takeIf { it > 0 },
        capacity_weight = j.optDouble("capacity_weight", 0.0).takeIf { it > 0 },
        dont_fill_to_brim = j.optBoolean("dont_fill_to_brim", false),
        is_full = j.optBoolean("is_full", false),
        level = j.optString("level", ""),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: ItemEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("code", e.code)
        put("description", e.description); put("attributes", e.attributes)
        put("location_id", e.location_id ?: ""); put("photo_path", e.photo_path ?: "")
        put("volume_liters", e.volume_liters)
        put("weight_kg", e.weight_kg)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
        put("expiry_date", e.expiry_date ?: "")
        put("ean", e.ean ?: "")
        put("tags", e.tags)
    }

    private fun item(j: JSONObject): ItemEntity = ItemEntity(
        id = j.getString("id"), name = j.getString("name"),
        code = j.optString("code", ""), description = j.optString("description", ""),
        attributes = j.optString("attributes", "{}"),
        location_id = j.optString("location_id", "").takeIf { it.isNotBlank() },
        photo_path = j.optString("photo_path", "").takeIf { it.isNotBlank() },
        volume_liters = j.optDouble("volume_liters", 0.0),
        weight_kg = j.optDouble("weight_kg", 0.0),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", ""),
        expiry_date = j.optString("expiry_date", "").takeIf { it.isNotBlank() },
        ean = j.optString("ean", "").takeIf { it.isNotBlank() },
        tags = j.optString("tags", "[]")
    )

    private fun o(e: AnnotationEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("storage_id", e.storage_id); put("location_id", e.location_id)
        put("shape", e.shape); put("points", e.points); put("label", e.label)
        put("color", e.color); put("z_order", e.z_order)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun anno(j: JSONObject): AnnotationEntity = AnnotationEntity(
        id = j.getString("id"), storage_id = j.getString("storage_id"),
        location_id = j.getString("location_id"),
        shape = j.optString("shape", "rect"), points = j.optString("points", "[]"),
        label = j.optString("label", ""), color = j.optString("color", "#FFB300"),
        z_order = j.optInt("z_order", 0),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: LabelTemplateEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("format", e.format)
        put("width_mm", e.width_mm); put("height_mm", e.height_mm); put("margin_mm", e.margin_mm)
        put("show_text", e.show_text); put("text_content", e.text_content)
        put("font_size", e.font_size); put("text_color", e.text_color); put("bg_color", e.bg_color)
        put("invert", e.invert); put("logo_path", e.logo_path ?: ""); put("quiet_zone", e.quiet_zone)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun tpl(j: JSONObject): LabelTemplateEntity = LabelTemplateEntity(
        id = j.getString("id"), name = j.getString("name"), format = j.optString("format", "QR"),
        width_mm = j.optDouble("width_mm", 58.0), height_mm = j.optDouble("height_mm", 40.0),
        margin_mm = j.optDouble("margin_mm", 3.0),
        show_text = j.optBoolean("show_text", true), text_content = j.optString("text_content", "{name} {code}"),
        font_size = j.optDouble("font_size", 12.0),
        text_color = j.optString("text_color", "#000000"), bg_color = j.optString("bg_color", "#FFFFFF"),
        invert = j.optBoolean("invert", false),
        logo_path = j.optString("logo_path", "").takeIf { it.isNotBlank() },
        quiet_zone = j.optBoolean("quiet_zone", true),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: PrinterProfileEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("transport", e.transport)
        put("host", e.host); put("port", e.port); put("bt_mac", e.bt_mac); put("protocol", e.protocol)
        put("paper_width_mm", e.paper_width_mm); put("offset_x_mm", e.offset_x_mm)
        put("offset_y_mm", e.offset_y_mm); put("is_default", e.is_default)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun printer(j: JSONObject): PrinterProfileEntity = PrinterProfileEntity(
        id = j.getString("id"), name = j.getString("name"),
        transport = j.optString("transport", "bluetooth"),
        host = j.optString("host", ""), port = j.optInt("port", 9100),
        bt_mac = j.optString("bt_mac", ""), protocol = j.optString("protocol", "escpos"),
        paper_width_mm = j.optDouble("paper_width_mm", 58.0),
        offset_x_mm = j.optDouble("offset_x_mm", 0.0), offset_y_mm = j.optDouble("offset_y_mm", 0.0),
        is_default = j.optBoolean("is_default", true),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: TagEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name)
        put("created_at", e.created_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun tag(j: JSONObject): TagEntity = TagEntity(
        id = j.getString("id"), name = j.getString("name"),
        created_at = j.optLong("created_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: UserEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("role", e.role); put("permissions", e.permissions)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun user(j: JSONObject): UserEntity = UserEntity(
        id = j.getString("id"), name = j.getString("name"),
        role = j.optString("role", "view"),
        permissions = j.optString("permissions", "[]"),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: LoanEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("entity_type", e.entity_type); put("entity_id", e.entity_id)
        put("borrower", e.borrower); put("note", e.note)
        put("lent_at", e.lent_at); put("due_at", e.due_at ?: 0); put("returned_at", e.returned_at ?: 0)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("device", e.device_last_modified)
    }

    private fun loan(j: JSONObject): LoanEntity = LoanEntity(
        id = j.getString("id"), entity_type = j.optString("entity_type", "item"),
        entity_id = j.optString("entity_id", ""),
        borrower = j.optString("borrower", ""), note = j.optString("note", ""),
        lent_at = j.optLong("lent_at", 0L),
        due_at = j.optLong("due_at", 0L).takeIf { it > 0 },
        returned_at = j.optLong("returned_at", 0L).takeIf { it > 0 },
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: StackEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("description", e.description); put("code", e.code)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun stack(j: JSONObject): StackEntity = StackEntity(
        id = j.getString("id"), name = j.optString("name", ""),
        description = j.optString("description", ""), code = j.optString("code", ""),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: StackMemberEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("stack_id", e.stack_id)
        put("entity_type", e.entity_type); put("entity_id", e.entity_id); put("sort_order", e.sort_order)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun stackMember(j: JSONObject): StackMemberEntity = StackMemberEntity(
        id = j.getString("id"), stack_id = j.optString("stack_id", ""),
        entity_type = j.optString("entity_type", "item"), entity_id = j.optString("entity_id", ""),
        sort_order = j.optInt("sort_order", 0),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: BasketEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("status", e.status)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun basket(j: JSONObject): BasketEntity = BasketEntity(
        id = j.getString("id"), name = j.optString("name", ""), status = j.optString("status", "active"),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: BasketItemEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("basket_id", e.basket_id); put("item_id", e.item_id)
        put("picked_ts", e.picked_ts ?: 0)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun basketItem(j: JSONObject): BasketItemEntity = BasketItemEntity(
        id = j.getString("id"), basket_id = j.optString("basket_id", ""),
        item_id = j.optString("item_id", ""),
        picked_ts = j.optLong("picked_ts", 0L).takeIf { it > 0 },
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    fun toJson(input: MergeInput): String {
        val root = JSONObject()
        root.put("format", FORMAT)
        root.put("version", VERSION)
        root.put("exported_at", System.currentTimeMillis())
        root.put("attribute_defs", JSONArray().apply { input.attributeDefs.forEach { put(o(it)) } })
        root.put("storages", JSONArray().apply { input.storages.forEach { put(o(it)) } })
        root.put("locations", JSONArray().apply { input.locations.forEach { put(o(it)) } })
        root.put("items", JSONArray().apply { input.items.forEach { put(o(it)) } })
        root.put("annotations", JSONArray().apply { input.annotations.forEach { put(o(it)) } })
        root.put("label_templates", JSONArray().apply { input.labelTemplates.forEach { put(o(it)) } })
        root.put("printers", JSONArray().apply { input.printers.forEach { put(o(it)) } })
        root.put("tags", JSONArray().apply { input.tags.forEach { put(o(it)) } })
        root.put("users", JSONArray().apply { input.users.forEach { put(o(it)) } })
        root.put("loans", JSONArray().apply { input.loans.forEach { put(o(it)) } })
        root.put("stacks", JSONArray().apply { input.stacks.forEach { put(o(it)) } })
        root.put("stack_members", JSONArray().apply { input.stackMembers.forEach { put(o(it)) } })
        root.put("baskets", JSONArray().apply { input.baskets.forEach { put(o(it)) } })
        root.put("basket_items", JSONArray().apply { input.basketItems.forEach { put(o(it)) } })
        return root.toString()
    }

    fun fromJson(json: String): MergeInput {
        val root = JSONObject(json)
        if (root.optString("format") != FORMAT) {
            throw IllegalArgumentException("Это не файл резервной копии Shkaff")
        }
        fun <T> arr(key: String, conv: (JSONObject) -> T): List<T> {
            val a = root.optJSONArray(key) ?: return emptyList()
            return (0 until a.length()).map { conv(a.getJSONObject(it)) }
        }
        return MergeInput(
            attributeDefs = arr("attribute_defs") { attr(it) },
            storages = arr("storages") { stor(it) },
            locations = arr("locations") { loc(it) },
            items = arr("items") { item(it) },
            annotations = arr("annotations") { anno(it) },
            labelTemplates = arr("label_templates") { tpl(it) },
            printers = arr("printers") { printer(it) },
            tags = arr("tags") { tag(it) },
            users = arr("users") { user(it) },
            loans = arr("loans") { loan(it) },
            stacks = arr("stacks") { stack(it) },
            stackMembers = arr("stack_members") { stackMember(it) },
            baskets = arr("baskets") { basket(it) },
            basketItems = arr("basket_items") { basketItem(it) },
            lastModified = root.optLong("exported_at", 0L)
        )
    }

    fun exportToFile(input: MergeInput, file: File) {
        val json = toJson(input)
        if (file.extension.lowercase() == "zip") {
            ZipOutputStream(file.outputStream()).use { zos ->
                zos.putNextEntry(ZipEntry("backup.json"))
                zos.write(json.toByteArray(Charsets.UTF_8))
                zos.closeEntry()
            }
        } else {
            file.parentFile?.mkdirs()
            file.writeText(json, Charsets.UTF_8)
        }
    }

    fun exportZipToStream(input: MergeInput, out: java.io.OutputStream) {
        ZipOutputStream(out.buffered()).use { zos ->
            zos.putNextEntry(ZipEntry("backup.json"))
            zos.write(toJson(input).toByteArray(Charsets.UTF_8))
            zos.closeEntry()
        }
    }

    fun importFromFile(file: File): MergeInput {
        return when (file.extension.lowercase()) {
            "zip" -> {
                val json = ZipInputStream(file.inputStream()).use { zis ->
                    val e = zis.nextEntry ?: throw IllegalArgumentException("Пустой архив")
                    zis.readBytes().toString(Charsets.UTF_8)
                }
                fromJson(json)
            }
            else -> fromJson(file.readText(Charsets.UTF_8))
        }
    }

    suspend fun applyMerge(result: MergeResult, db: ShkaffDatabase) {
        val m = result.merged
        db.withTransaction {
            db.attributeDao().upsertAll(m.attributeDefs)
            db.storageDao().upsertAll(m.storages)
            db.locationDao().upsertAll(m.locations)
            db.itemDao().upsertAll(m.items)
            db.annotationDao().upsertAll(m.annotations)
            db.labelTemplateDao().upsertAll(m.labelTemplates)
            db.printerDao().upsertAll(m.printers)
            db.tagDao().upsertAll(m.tags)
            db.userDao().upsertAll(m.users)
            db.loanDao().upsertAll(m.loans)
            db.stackDao().upsertAll(m.stacks)
            db.stackMemberDao().upsertAll(m.stackMembers)
            db.basketDao().upsertAll(m.baskets)
            db.basketItemDao().upsertAll(m.basketItems)
        }
    }
}
