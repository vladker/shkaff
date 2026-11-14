package ru.vldkr.shkaff.sync

import androidx.room.withTransaction
import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelDocEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.db.SheetLayoutEntity
import ru.vldkr.shkaff.data.db.SheetSlotEntity
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
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

object Backup {

    const val FORMAT = "shkaff-backup"
    const val VERSION = 1

    // T-068: снимок всех таблиц — в одной транзакции, иначе правка, попавшая между
    // чтениями, уходит в бэкап/PULL смешанной версией (вещь со старым location_id при
    // уже новой локации и т. п.). Для сравнения applyMerge уже обёрнут в withTransaction.
    suspend fun buildInput(db: ShkaffDatabase): MergeInput = db.withTransaction {
        MergeInput(
            attributeDefs = db.attributeDao().allWithDeleted(),
            storages = db.storageDao().allWithDeleted(),
            locations = db.locationDao().allWithDeleted(),
            items = db.itemDao().allWithDeleted(),
            annotations = db.annotationDao().allWithDeleted(),
            labelTemplates = db.labelTemplateDao().allWithDeleted(),
            labelDocs = db.labelDocDao().allWithDeleted(),
            sheetLayouts = db.sheetLayoutDao().allWithDeleted(),
            sheetSlots = db.sheetSlotDao().allWithDeleted(),
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
    }

    private fun o(e: AttributeDefEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("scope", e.scope); put("key", e.key); put("label", e.label)
        put("type", e.type); put("options", e.options)
        put("sort_order", e.sort_order); put("required", e.required)
        put("category", e.category); put("tier", e.tier)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun attr(j: JSONObject): AttributeDefEntity = AttributeDefEntity(
        id = j.getString("id"), scope = j.optString("scope", "*"),
        key = j.getString("key"), label = j.getString("label"),
        type = j.optString("type", "text"), options = j.optString("options", "[]"),
        sort_order = j.optInt("sort_order", 0), required = j.optBoolean("required", false),
        category = j.optString("category", "*"), tier = j.optString("tier", "rec"),
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
        put("labelled_at", e.labelled_at ?: 0)
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
        labelled_at = j.optLong("labelled_at", 0L).takeIf { it > 0 },
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
        put("labelled_at", e.labelled_at ?: 0)
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
        labelled_at = j.optLong("labelled_at", 0L).takeIf { it > 0 },
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: ItemEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("code", e.code)
        put("description", e.description); put("attributes", e.attributes)
        put("location_id", e.location_id ?: ""); put("photo_path", e.photo_path ?: "")
        put("barcode_photo_path", e.barcode_photo_path ?: "")
        put("volume_liters", e.volume_liters)
        put("weight_kg", e.weight_kg)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
        put("expiry_date", e.expiry_date ?: "")
        put("ean", e.ean ?: "")
        put("tags", e.tags)
        put("labelled_at", e.labelled_at ?: 0)
    }

    private fun item(j: JSONObject): ItemEntity = ItemEntity(
        id = j.getString("id"), name = j.getString("name"),
        code = j.optString("code", ""), description = j.optString("description", ""),
        attributes = j.optString("attributes", "{}"),
        location_id = j.optString("location_id", "").takeIf { it.isNotBlank() },
        photo_path = j.optString("photo_path", "").takeIf { it.isNotBlank() },
        barcode_photo_path = j.optString("barcode_photo_path", "").takeIf { it.isNotBlank() },
        volume_liters = j.optDouble("volume_liters", 0.0),
        weight_kg = j.optDouble("weight_kg", 0.0),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", ""),
        expiry_date = j.optString("expiry_date", "").takeIf { it.isNotBlank() },
        ean = j.optString("ean", "").takeIf { it.isNotBlank() },
        tags = j.optString("tags", "[]"),
        labelled_at = j.optLong("labelled_at", 0L).takeIf { it > 0 }
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
        put("text_position", e.text_position); put("show_number", e.show_number)
        put("app_link", e.app_link)
        put("layout_mode", e.layout_mode); put("qr_count", e.qr_count); put("qr_scale", e.qr_scale)
        put("offset_x_mm", e.offset_x_mm); put("offset_y_mm", e.offset_y_mm)
        put("label_attrs", e.label_attrs)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun tpl(j: JSONObject): LabelTemplateEntity = LabelTemplateEntity(
        id = j.getString("id"), name = j.getString("name"), format = j.optString("format", "QR"),
        width_mm = j.optDouble("width_mm", 58.0), height_mm = j.optDouble("height_mm", 40.0),
        margin_mm = j.optDouble("margin_mm", 3.0),
        show_text = j.optBoolean("show_text", true), text_content = j.optString("text_content", "{name}"),
        font_size = j.optDouble("font_size", 12.0),
        text_color = j.optString("text_color", "#000000"), bg_color = j.optString("bg_color", "#FFFFFF"),
        invert = j.optBoolean("invert", false),
        logo_path = j.optString("logo_path", "").takeIf { it.isNotBlank() },
        quiet_zone = j.optBoolean("quiet_zone", true),
        text_position = j.optString("text_position", "bottom"),
        show_number = j.optBoolean("show_number", true),
        app_link = j.optBoolean("app_link", false),
        layout_mode = j.optString("layout_mode", "classic"),
        qr_count = j.optInt("qr_count", 1),
        qr_scale = j.optDouble("qr_scale", 1.0),
        offset_x_mm = j.optDouble("offset_x_mm", 0.0),
        offset_y_mm = j.optDouble("offset_y_mm", 0.0),
        label_attrs = j.optString("label_attrs", "[]"),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: LabelDocEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("entity_kind", e.entity_kind)
        put("doc_json", e.doc_json); put("is_default", e.is_default)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun doc(j: JSONObject): LabelDocEntity = LabelDocEntity(
        id = j.getString("id"), name = j.optString("name", ""),
        entity_kind = j.optString("entity_kind", "item"),
        doc_json = j.optString("doc_json", "[]"),
        is_default = j.optBoolean("is_default", false),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: SheetLayoutEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name)
        put("paper_w_mm", e.paper_w_mm); put("paper_h_mm", e.paper_h_mm)
        put("margin_mm", e.margin_mm)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun sheetLayout(j: JSONObject): SheetLayoutEntity = SheetLayoutEntity(
        id = j.getString("id"), name = j.optString("name", ""),
        paper_w_mm = j.optDouble("paper_w_mm", 0.0), paper_h_mm = j.optDouble("paper_h_mm", 0.0),
        margin_mm = j.optDouble("margin_mm", 0.0),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: SheetSlotEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("layout_id", e.layout_id)
        put("x_mm", e.x_mm); put("y_mm", e.y_mm); put("w_mm", e.w_mm); put("h_mm", e.h_mm)
        put("style_template_id", e.style_template_id); put("sort_order", e.sort_order)
        put("created_at", e.created_at); put("updated_at", e.updated_at)
        put("deleted_at", e.deleted_at ?: 0); put("device", e.device_last_modified)
    }

    private fun sheetSlot(j: JSONObject): SheetSlotEntity = SheetSlotEntity(
        id = j.getString("id"), layout_id = j.getString("layout_id"),
        x_mm = j.optDouble("x_mm", 0.0), y_mm = j.optDouble("y_mm", 0.0),
        w_mm = j.optDouble("w_mm", 0.0), h_mm = j.optDouble("h_mm", 0.0),
        style_template_id = j.optString("style_template_id", ""),
        sort_order = j.optInt("sort_order", 0),
        created_at = j.optLong("created_at", 0L), updated_at = j.optLong("updated_at", 0L),
        deleted_at = j.optLong("deleted_at", 0L).takeIf { it > 0 },
        device_last_modified = j.optString("device", "")
    )

    private fun o(e: PrinterProfileEntity): JSONObject = JSONObject().apply {
        put("id", e.id); put("name", e.name); put("transport", e.transport)
        put("host", e.host); put("port", e.port); put("bt_mac", e.bt_mac); put("protocol", e.protocol)
        put("paper_width_mm", e.paper_width_mm); put("offset_x_mm", e.offset_x_mm)
        put("offset_y_mm", e.offset_y_mm); put("is_default", e.is_default)
        put("printable_width_mm", e.printable_width_mm); put("paper_type", e.paper_type)
        put("gap_mm", e.gap_mm); put("feed_lines", e.feed_lines)
        put("darkness", e.darkness); put("dpi", e.dpi)
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
        printable_width_mm = j.optDouble("printable_width_mm", 48.0),
        paper_type = j.optString("paper_type", "continuous"),
        gap_mm = j.optDouble("gap_mm", 2.5),
        feed_lines = j.optInt("feed_lines", 3),
        darkness = j.optInt("darkness", 8),
        dpi = j.optInt("dpi", 203),
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
        root.put("label_docs", JSONArray().apply { input.labelDocs.forEach { put(o(it)) } })
        root.put("sheet_layouts", JSONArray().apply { input.sheetLayouts.forEach { put(o(it)) } })
        root.put("sheet_slots", JSONArray().apply { input.sheetSlots.forEach { put(o(it)) } })
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
            labelDocs = arr("label_docs") { doc(it) },
            sheetLayouts = arr("sheet_layouts") { sheetLayout(it) },
            sheetSlots = arr("sheet_slots") { sheetSlot(it) },
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

    // Фото лежат в разных каталогах внутренней памяти (photos/, item_photos/,
    // barcode_photos/), а в базе — абсолютный путь к файлу. Для одного и того же пакета
    // этот путь одинаков на любом устройстве, поэтому при экспорте файл берется прямо по
    // пути из базы, а при импорте возвращается в свою папку — пересохранять пути не нужно.
    // Поиск по имени в photosDir остается запасным вариантом (сдвинутые/старые файлы).
    private const val PHOTO_ENTRY_DIR = "photos"

    private fun photoPaths(input: MergeInput): List<String> {
        val paths = LinkedHashSet<String>()
        fun add(path: String?) = if (!path.isNullOrBlank()) paths += path else Unit
        input.items.forEach { add(it.photo_path); add(it.barcode_photo_path) }
        input.storages.forEach { add(it.photo_path) }
        input.locations.forEach { add(it.photo_path) }
        input.labelTemplates.forEach { add(it.logo_path) }
        // Макет LabelStudio ссылается на картинку элементом {"path": …} (LabelDocCodec).
        input.labelDocs.forEach { d ->
            Regex("\"path\"\\s*:\\s*\"([^\"]+)\"").findAll(d.doc_json)
                .forEach { add(it.groupValues[1]) }
        }
        return paths.toList()
    }

    private fun photoFiles(input: MergeInput, dir: File): List<File> {
        val byName = LinkedHashMap<String, File>()
        for (p in photoPaths(input)) {
            val db = File(p)
            val f = if (db.isFile) db else File(dir, db.name).takeIf { it.isFile } ?: continue
            byName.putIfAbsent(f.name, f)
        }
        return byName.values.toList()
    }

    private fun writeZip(input: MergeInput, zos: ZipOutputStream, photosDir: File?) {
        zos.putNextEntry(ZipEntry("backup.json"))
        zos.write(toJson(input).toByteArray(Charsets.UTF_8))
        zos.closeEntry()
        if (photosDir == null) return
        for (f in photoFiles(input, photosDir)) {
            zos.putNextEntry(ZipEntry("$PHOTO_ENTRY_DIR/${f.name}"))
            f.inputStream().use { it.copyTo(zos) }
            zos.closeEntry()
        }
    }

    fun exportToFile(input: MergeInput, file: File, photosDir: File? = null) {
        val json = toJson(input)
        if (file.extension.lowercase() == "zip") {
            ZipOutputStream(file.outputStream()).use { writeZip(input, it, photosDir) }
        } else {
            file.parentFile?.mkdirs()
            file.writeText(json, Charsets.UTF_8)
        }
    }

    fun exportZipToStream(input: MergeInput, out: java.io.OutputStream, photosDir: File? = null) {
        ZipOutputStream(out.buffered()).use { writeZip(input, it, photosDir) }
    }

    fun importFromFile(file: File, photosDir: File? = null): MergeInput {
        return when (file.extension.lowercase()) {
            "zip" -> {
                val input = ZipFile(file).use { zf ->
                    val je = zf.getEntry("backup.json")
                        ?: throw IllegalArgumentException("В архиве нет backup.json")
                    fromJson(zf.getInputStream(je).readBytes().toString(Charsets.UTF_8))
                }
                if (photosDir != null) ZipFile(file).use { restorePhotos(input, photosDir, it) }
                input
            }
            else -> fromJson(file.readText(Charsets.UTF_8))
        }
    }

    // Фото возвращается в тот каталог, на который указывает путь из backup.json:
    // абсолютный путь одинаков на любом устройстве для этого пакета. В photosDir
    // пишутся только записи, которых нет среди путей базы (старые архивы, голые имена).
    private fun restorePhotos(input: MergeInput, photosDir: File, zf: ZipFile) {
        val targets = LinkedHashMap<String, MutableList<File>>()
        for (p in photoPaths(input)) {
            val f = File(p)
            if (f.isAbsolute) targets.getOrPut(f.name) { mutableListOf() } += f
        }
        val entries = zf.entries()
        while (entries.hasMoreElements()) {
            val e = entries.nextElement()
            if (e.isDirectory || !e.name.startsWith("$PHOTO_ENTRY_DIR/")) continue
            val name = File(e.name).name
            val dests = (targets[name] ?: listOf(File(photosDir, name)))
                .distinctBy { it.absolutePath }
            for (dest in dests) {
                if (!dest.exists()) {
                    dest.parentFile?.mkdirs()
                    zf.getInputStream(e).use { inp -> dest.outputStream().use { inp.copyTo(it) } }
                }
            }
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
            db.labelDocDao().upsertAll(m.labelDocs)
            db.sheetLayoutDao().upsertAll(m.sheetLayouts) // слоты ссылаются на листы — листы первыми
            db.sheetSlotDao().upsertAll(m.sheetSlots)
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
