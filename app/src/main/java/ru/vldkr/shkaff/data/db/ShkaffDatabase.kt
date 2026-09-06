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
        SchemaMetaEntity::class
    ],
    version = 2,
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

    companion object {
        const val DB_NAME = "shkaff.db"
        const val SCHEMA_VERSION = "2"

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE item ADD COLUMN expiry_date TEXT")
            }
        }

        fun build(context: Context): ShkaffDatabase =
            Room.databaseBuilder(context, ShkaffDatabase::class.java, DB_NAME)
                .allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2)
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
