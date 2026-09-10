package ru.vldkr.shkaff.data.db

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.ForeignKey.Companion.SET_NULL
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "storage",
    foreignKeys = [
        ForeignKey(entity = StorageEntity::class, parentColumns = ["id"], childColumns = ["parent_id"], onDelete = SET_NULL)
    ],
    indices = [Index("parent_id")]
)
data class StorageEntity(
    @PrimaryKey val id: String,
    val name: String,
    val code: String = "",
    val description: String = "",
    val attributes: String = "{}",
    val photo_path: String? = null,
    val parent_id: String? = null,
    // Ёмкость, л; грузоподъёмность, кг. null = не задано (ограничений нет).
    val capacity_volume: Double? = null,
    val capacity_weight: Double? = null,
    // «Не набивать под завязку» — резервируем часть объёма/массы.
    val dont_fill_to_brim: Boolean = false,
    // Принудительно «полное» — блокирует добавление независимо от расчёта.
    val is_full: Boolean = false,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

@Entity(
    tableName = "location",
    foreignKeys = [
        ForeignKey(entity = LocationEntity::class, parentColumns = ["id"], childColumns = ["parent_id"], onDelete = SET_NULL),
        ForeignKey(entity = StorageEntity::class, parentColumns = ["id"], childColumns = ["storage_id"], onDelete = CASCADE)
    ],
    indices = [Index("parent_id"), Index("storage_id")]
)
data class LocationEntity(
    @PrimaryKey val id: String,
    val storage_id: String,
    val parent_id: String? = null,
    val label: String = "",
    val name: String = "",
    val attributes: String = "{}",
    val photo_path: String? = null,
    // Ёмкость, л; грузоподъёмность, кг. null = не задано (ограничений нет).
    val capacity_volume: Double? = null,
    val capacity_weight: Double? = null,
    val dont_fill_to_brim: Boolean = false,
    val is_full: Boolean = false,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

@Entity(
    tableName = "item",
    foreignKeys = [
        ForeignKey(entity = LocationEntity::class, parentColumns = ["id"], childColumns = ["location_id"], onDelete = SET_NULL)
    ],
    indices = [Index("location_id"), Index("code")]
)
data class ItemEntity(
    @PrimaryKey val id: String,
    val name: String,
    val code: String,
    val description: String,
    val attributes: String,
    val photo_path: String?,
    val location_id: String?,
    // Габариты вещи: объём, л; масса, кг — для расчёта занятости ёмкости.
    val volume_liters: Double = 0.0,
    val weight_kg: Double = 0.0,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long?,
    val device_last_modified: String,
    val expiry_date: String? = null,
    val tags: String = "[]"
)

@Entity(
    tableName = "annotation",
    foreignKeys = [
        ForeignKey(entity = StorageEntity::class, parentColumns = ["id"], childColumns = ["storage_id"], onDelete = CASCADE),
        ForeignKey(entity = LocationEntity::class, parentColumns = ["id"], childColumns = ["location_id"], onDelete = SET_NULL)
    ],
    indices = [Index("storage_id"), Index("location_id")]
)
data class AnnotationEntity(
    @PrimaryKey val id: String,
    val storage_id: String,
    val location_id: String,
    val shape: String = "rect",
    val points: String = "[]",
    val label: String = "",
    val color: String = "#FFB300",
    val z_order: Int = 0,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

@Entity(tableName = "label_template")
data class LabelTemplateEntity(
    @PrimaryKey val id: String,
    val name: String,
    val format: String = "QR",
    val width_mm: Double = 58.0,
    val height_mm: Double = 40.0,
    val margin_mm: Double = 3.0,
    val show_text: Boolean = true,
    val text_content: String = "{name} {code}",
    val font_size: Double = 12.0,
    val text_color: String = "#000000",
    val bg_color: String = "#FFFFFF",
    val invert: Boolean = false,
    val logo_path: String? = null,
    val quiet_zone: Boolean = true,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

@Entity(tableName = "attribute_def", indices = [Index(value = ["scope", "key"], unique = true)])
data class AttributeDefEntity(
    @PrimaryKey val id: String,
    val scope: String,
    val key: String,
    val label: String,
    val type: String,
    val options: String = "[]",
    val sort_order: Int = 0,
    val required: Boolean = false,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

@Entity(tableName = "printer_profile")
data class PrinterProfileEntity(
    @PrimaryKey val id: String,
    val name: String,
    val transport: String = "bluetooth",
    val host: String = "",
    val port: Int = 9100,
    val bt_mac: String = "",
    val protocol: String = "escpos",
    val paper_width_mm: Double = 58.0,
    val offset_x_mm: Double = 0.0,
    val offset_y_mm: Double = 0.0,
    val is_default: Boolean = true,
    val created_at: Long,
    val updated_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

@Entity(tableName = "conflict_log")
data class ConflictLogEntity(
    @PrimaryKey val id: String,
    val entity_type: String,
    val entity_id: String,
    val field: String,
    val value_a: String,
    val value_b: String,
    val chosen: String,
    val resolved_at: Long,
    val device_id: String
)

@Entity(tableName = "schema_meta")
data class SchemaMetaEntity(
    @PrimaryKey val key: String,
    val value: String
)

// Словарь тегов (US-I4): имена тегов хранятся в item.tags (JSON-массив),
// словарь нужен для подсказок в форме и фильтра в списке
@Entity(tableName = "tag", indices = [Index("name")])
data class TagEntity(
    @PrimaryKey val id: String,
    val name: String,
    val created_at: Long,
    val deleted_at: Long? = null,
    val device_last_modified: String = ""
)

// Черновик формы (US-A4): id — ключ вида "item/new" или "item/{id}"
@Entity(tableName = "draft")
data class DraftEntity(
    @PrimaryKey val id: String,
    val entity_type: String,
    val entity_id: String? = null,
    val form_json: String = "{}",
    val saved_at: Long = 0L
)
