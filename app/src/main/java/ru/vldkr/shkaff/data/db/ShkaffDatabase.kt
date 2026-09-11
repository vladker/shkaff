package ru.vldkr.shkaff.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.migration.Migration
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [
        StorageEntity::class,
        LocationEntity::class,
        ItemEntity::class,
        AnnotationEntity::class,
        LabelTemplateEntity::class,
        AttributeDefEntity::class,
        PrinterProfileEntity::class,
        ConflictLogEntity::class,
        SchemaMetaEntity::class,
        TagEntity::class,
        DraftEntity::class,
        UserEntity::class,
        LoanEntity::class,
        ActionLogEntity::class,
        StackEntity::class,
        StackMemberEntity::class,
        BasketEntity::class,
        BasketItemEntity::class
    ],
    version = 12,
    exportSchema = true
)
abstract class ShkaffDatabase : RoomDatabase() {

    abstract fun storageDao(): StorageDao
    abstract fun locationDao(): LocationDao
    abstract fun itemDao(): ItemDao
    abstract fun annotationDao(): AnnotationDao
    abstract fun attributeDao(): AttributeDao
    abstract fun labelTemplateDao(): LabelTemplateDao
    abstract fun printerDao(): PrinterDao
    abstract fun conflictDao(): ConflictDao
    abstract fun metaDao(): MetaDao
    abstract fun tagDao(): TagDao
    abstract fun draftDao(): DraftDao
    abstract fun userDao(): UserDao
    abstract fun loanDao(): LoanDao
    abstract fun actionLogDao(): ActionLogDao
    abstract fun stackDao(): StackDao
    abstract fun stackMemberDao(): StackMemberDao
    abstract fun basketDao(): BasketDao
    abstract fun basketItemDao(): BasketItemDao

    companion object {
        const val DB_NAME = "shkaff.db"
        const val SCHEMA_VERSION = "12"

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE item ADD COLUMN expiry_date TEXT")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE storage ADD COLUMN code TEXT NOT NULL DEFAULT ''")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                // IF NOT EXISTS: безопасный повторный запуск после ранее неудачной миграции
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `tag` (`id` TEXT NOT NULL, `name` TEXT NOT NULL, " +
                        "`created_at` INTEGER NOT NULL, `deleted_at` INTEGER, " +
                        "`device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_tag_name` ON `tag` (`name`)")
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `draft` (`id` TEXT NOT NULL, `entity_type` TEXT NOT NULL, " +
                        "`entity_id` TEXT, `form_json` TEXT NOT NULL, `saved_at` INTEGER NOT NULL, " +
                        "PRIMARY KEY(`id`))"
                )
                // tags: добавляем колонку, если её ещё нет (безопасно при повторном запуске)
                var hasTags = false
                db.query("PRAGMA table_info(item)").use { c ->
                    while (c.moveToNext()) {
                        if (c.getString(1) == "tags") {
                            hasTags = true
                            break
                        }
                    }
                }
                if (!hasTags) {
                    db.execSQL("ALTER TABLE item ADD COLUMN tags TEXT NOT NULL DEFAULT '[]'")
                }
                // Таблицы tag и draft появились в v4 — создаём их (IF NOT EXISTS — идемпотентно)
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS tag (" +
                        "id TEXT NOT NULL, " +
                        "name TEXT NOT NULL, " +
                        "created_at INTEGER NOT NULL, " +
                        "deleted_at INTEGER, " +
                        "device_last_modified TEXT NOT NULL, " +
                        "PRIMARY KEY(id))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS index_tag_name ON tag (name)")
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS draft (" +
                        "id TEXT NOT NULL, " +
                        "entity_type TEXT NOT NULL, " +
                        "entity_id TEXT, " +
                        "form_json TEXT NOT NULL, " +
                        "saved_at INTEGER NOT NULL, " +
                        "PRIMARY KEY(id))"
                )
                // Уникальный частичный индекс на code НЕ создаём: Room не умеет partial index
                // в аннотациях, а любой индекс, отсутствующий в @Entity, роняет верификацию
                // схемы после миграции (IllegalStateException «Migration didn't properly handle»).
                // Уникальность кодов обеспечивается на уровне приложения.
                // Если индекс уже закоммитился в «грязном» состоянии — убираем его.
                val hasIdx = db.query(
                    "SELECT name FROM sqlite_master WHERE type='index' AND name='idx_item_code_unique'"
                ).use { cur -> cur.moveToFirst() }
                if (hasIdx) {
                    db.execSQL("DROP INDEX idx_item_code_unique")
                }
            }
        }

        val MIGRATION_4_5 = object : Migration(4, 5) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE storage ADD COLUMN capacity_volume REAL")
                db.execSQL("ALTER TABLE storage ADD COLUMN capacity_weight REAL")
                db.execSQL("ALTER TABLE storage ADD COLUMN dont_fill_to_brim INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE storage ADD COLUMN is_full INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE location ADD COLUMN capacity_volume REAL")
                db.execSQL("ALTER TABLE location ADD COLUMN capacity_weight REAL")
                db.execSQL("ALTER TABLE location ADD COLUMN dont_fill_to_brim INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE location ADD COLUMN is_full INTEGER NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE item ADD COLUMN volume_liters REAL NOT NULL DEFAULT 0")
                db.execSQL("ALTER TABLE item ADD COLUMN weight_kg REAL NOT NULL DEFAULT 0")
            }
        }

        // v6 (M10 — «Люди и аудит»): профили, выдачи, журнал действий.
        val MIGRATION_5_6 = object : Migration(5, 6) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `user` (" +
                        "`id` TEXT NOT NULL, `name` TEXT NOT NULL, `role` TEXT NOT NULL, " +
                        "`permissions` TEXT NOT NULL, `created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, " +
                        "`deleted_at` INTEGER, `device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `loan` (" +
                        "`id` TEXT NOT NULL, `entity_type` TEXT NOT NULL, `entity_id` TEXT NOT NULL, " +
                        "`borrower` TEXT NOT NULL, `note` TEXT NOT NULL, `lent_at` INTEGER NOT NULL, " +
                        "`due_at` INTEGER, `returned_at` INTEGER, `created_at` INTEGER NOT NULL, " +
                        "`updated_at` INTEGER NOT NULL, `device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `action_log` (" +
                        "`id` TEXT NOT NULL, `user_id` TEXT, `user_name` TEXT NOT NULL, `action` TEXT NOT NULL, " +
                        "`entity_type` TEXT NOT NULL, `entity_id` TEXT NOT NULL, `detail` TEXT NOT NULL, " +
                        "`at` INTEGER NOT NULL, `device_id` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_loan_entity_id` ON `loan` (`entity_id`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_loan_returned_at` ON `loan` (`returned_at`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_loan_due_at` ON `loan` (`due_at`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_action_log_action` ON `action_log` (`action`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_action_log_at` ON `action_log` (`at`)")
            }
        }

        // v7 (M11 — «Умный ввод»): поле ean у вещи (US-B2).
        val MIGRATION_6_7 = object : Migration(6, 7) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE item ADD COLUMN ean TEXT")
            }
        }

        // v8 (M12 — «Структура и группировка»): уровень иерархии у хранилищ и ящиков (US-C1).
        val MIGRATION_7_8 = object : Migration(7, 8) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE storage ADD COLUMN level TEXT NOT NULL DEFAULT ''")
                db.execSQL("ALTER TABLE location ADD COLUMN level TEXT NOT NULL DEFAULT ''")
            }
        }

        // v9 (M12): стеки (US-E2) — группы вещей/хранилищ без потери оригинальной информации.
        val MIGRATION_8_9 = object : Migration(8, 9) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `stack` (" +
                        "`id` TEXT NOT NULL, `name` TEXT NOT NULL, `description` TEXT NOT NULL, `code` TEXT NOT NULL, " +
                        "`created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `deleted_at` INTEGER, " +
                        "`device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_stack_code` ON `stack` (`code`)")
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `stack_member` (" +
                        "`id` TEXT NOT NULL, `stack_id` TEXT NOT NULL, `entity_type` TEXT NOT NULL, " +
                        "`entity_id` TEXT NOT NULL, `sort_order` INTEGER NOT NULL, " +
                        "`created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `deleted_at` INTEGER, " +
                        "`device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_stack_member_stack_id` ON `stack_member` (`stack_id`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_stack_member_entity_id` ON `stack_member` (`entity_id`)")
            }
        }

        // v10 (M12): корзина извлечения (US-E1) — списки вещей на вынос.
        val MIGRATION_9_10 = object : Migration(9, 10) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `basket` (" +
                        "`id` TEXT NOT NULL, `name` TEXT NOT NULL, `status` TEXT NOT NULL, " +
                        "`created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `deleted_at` INTEGER, " +
                        "`device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_basket_name` ON `basket` (`name`)")
                db.execSQL(
                    "CREATE TABLE IF NOT EXISTS `basket_item` (" +
                        "`id` TEXT NOT NULL, `basket_id` TEXT NOT NULL, `item_id` TEXT NOT NULL, " +
                        "`picked_ts` INTEGER, " +
                        "`created_at` INTEGER NOT NULL, `updated_at` INTEGER NOT NULL, `deleted_at` INTEGER, " +
                        "`device_last_modified` TEXT NOT NULL, PRIMARY KEY(`id`))"
                )
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_basket_item_basket_id` ON `basket_item` (`basket_id`)")
                db.execSQL("CREATE INDEX IF NOT EXISTS `index_basket_item_item_id` ON `basket_item` (`item_id`)")
            }
        }

        // v11 (метки): расположение текста над/под кодом, вывод номера объекта.
        val MIGRATION_10_11 = object : Migration(10, 11) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE label_template ADD COLUMN text_position TEXT NOT NULL DEFAULT 'bottom'")
                db.execSQL("ALTER TABLE label_template ADD COLUMN show_number INTEGER NOT NULL DEFAULT 1")
            }
        }

        // v12 (метки): QR/штрихкод может кодировать ссылку приложения (US-I3).
        val MIGRATION_11_12 = object : Migration(11, 12) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE label_template ADD COLUMN app_link INTEGER NOT NULL DEFAULT 0")
            }
        }

        fun build(context: Context): ShkaffDatabase =
            Room.databaseBuilder(context, ShkaffDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, MIGRATION_8_9, MIGRATION_9_10, MIGRATION_10_11, MIGRATION_11_12)
                .addCallback(
                    object : RoomDatabase.Callback() {
                        override fun onOpen(db: SupportSQLiteDatabase) {
                            db.execSQL("PRAGMA foreign_keys = ON")
                        }
                    }
                )
                .build()
    }
}
