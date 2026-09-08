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
        DraftEntity::class
    ],
    version = 4,
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

    companion object {
        const val DB_NAME = "shkaff.db"
        const val SCHEMA_VERSION = "4"

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

        fun build(context: Context): ShkaffDatabase =
            Room.databaseBuilder(context, ShkaffDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4)
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
