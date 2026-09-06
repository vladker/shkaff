package ru.vldkr.shkaff.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StorageDao {
    @Query("SELECT * FROM storage WHERE deleted_at IS NULL ORDER BY name COLLATE LOCALIZED")
    fun observeAll(): Flow<List<StorageEntity>>

    @Query("SELECT * FROM storage WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): StorageEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(s: StorageEntity)

    @Query("UPDATE storage SET deleted_at = :now, updated_at = :now, device_last_modified = :dev WHERE id = :id")
    suspend fun softDelete(id: String, now: Long, dev: String)

    @Query("DELETE FROM storage WHERE id = :id")
    suspend fun hardDelete(id: String)

    @Query("SELECT COUNT(*) FROM storage WHERE deleted_at IS NULL")
    suspend fun count(): Int

    @Query("SELECT * FROM storage")
    suspend fun allWithDeleted(): List<StorageEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<StorageEntity>)
}

@Dao
interface LocationDao {
    @Query("SELECT * FROM location WHERE deleted_at IS NULL ORDER BY label COLLATE LOCALIZED, name COLLATE LOCALIZED")
    fun observeAll(): Flow<List<LocationEntity>>

    @Query("SELECT * FROM location WHERE storage_id = :storageId AND deleted_at IS NULL ORDER BY label COLLATE LOCALIZED, name COLLATE LOCALIZED")
    fun observeByStorage(storageId: String): Flow<List<LocationEntity>>

    @Query("SELECT * FROM location WHERE storage_id = :storageId AND deleted_at IS NULL")
    suspend fun allByStorage(storageId: String): List<LocationEntity>

    @Query("SELECT * FROM location WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): LocationEntity?

    @Query("SELECT * FROM location WHERE parent_id = :parentId AND deleted_at IS NULL")
    suspend fun children(parentId: String): List<LocationEntity>

    @Query("SELECT * FROM location WHERE parent_id = :parentId AND deleted_at IS NULL ORDER BY label COLLATE LOCALIZED, name COLLATE LOCALIZED")
    fun observeChildren(parentId: String): Flow<List<LocationEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(l: LocationEntity)

    @Query("UPDATE location SET deleted_at = :now, updated_at = :now, device_last_modified = :dev WHERE id = :id")
    suspend fun softDelete(id: String, now: Long, dev: String)

    @Query("DELETE FROM location WHERE id = :id")
    suspend fun hardDelete(id: String)

    @Query("SELECT COUNT(*) FROM location WHERE deleted_at IS NULL")
    suspend fun count(): Int

    @Query("SELECT COUNT(*) FROM location WHERE storage_id = :storageId AND deleted_at IS NULL")
    suspend fun countByStorage(storageId: String): Int

    @Query("SELECT * FROM location")
    suspend fun allWithDeleted(): List<LocationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<LocationEntity>)
}

@Dao
interface ItemDao {
    @Query("SELECT * FROM item WHERE deleted_at IS NULL ORDER BY updated_at DESC")
    fun observeAll(): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE deleted_at IS NULL ORDER BY updated_at DESC LIMIT :limit")
    suspend fun recent(limit: Int): List<ItemEntity>

    @Query("SELECT * FROM item WHERE location_id = :locationId AND deleted_at IS NULL ORDER BY updated_at DESC")
    fun observeByLocation(locationId: String): Flow<List<ItemEntity>>

    @Query("SELECT * FROM item WHERE code = :code AND deleted_at IS NULL LIMIT 1")
    suspend fun byCode(code: String): ItemEntity?

    @Query("SELECT * FROM item WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): ItemEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(i: ItemEntity)

    @Query("UPDATE item SET deleted_at = :now, updated_at = :now, device_last_modified = :dev WHERE id = :id")
    suspend fun softDelete(id: String, now: Long, dev: String)

    @Query("DELETE FROM item WHERE id = :id")
    suspend fun hardDelete(id: String)

    @Query("SELECT COUNT(*) FROM item WHERE deleted_at IS NULL")
    suspend fun count(): Int

    @Query("SELECT COUNT(*) FROM item WHERE location_id = :locationId AND deleted_at IS NULL")
    suspend fun countByLocation(locationId: String): Int

    @Query(
        "SELECT * FROM item WHERE deleted_at IS NULL AND " +
            "(name LIKE '%' || :q || '%' OR description LIKE '%' || :q || '%' OR code LIKE '%' || :q || '%' OR attributes LIKE '%' || :q || '%') " +
            "ORDER BY updated_at DESC LIMIT 100"
    )
    suspend fun likeSearch(q: String): List<ItemEntity>

    @Query("SELECT * FROM item WHERE deleted_at IS NULL AND expiry_date IS NOT NULL AND expiry_date != '' LIMIT 1000")
    suspend fun withExpiry(): List<ItemEntity>

    @Query("SELECT * FROM item")
    suspend fun allWithDeleted(): List<ItemEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<ItemEntity>)
}

@Dao
interface AttributeDao {
    @Query("SELECT * FROM attribute_def WHERE deleted_at IS NULL AND (scope = :scope OR scope = '*') ORDER BY scope, sort_order, label COLLATE LOCALIZED")
    suspend fun forScope(scope: String): List<AttributeDefEntity>

    @Query("SELECT * FROM attribute_def WHERE deleted_at IS NULL ORDER BY scope, sort_order, label COLLATE LOCALIZED")
    fun observeAll(): Flow<List<AttributeDefEntity>>

    @Query("SELECT * FROM attribute_def WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): AttributeDefEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(a: AttributeDefEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<AttributeDefEntity>)

    @Query("SELECT * FROM attribute_def")
    suspend fun allWithDeleted(): List<AttributeDefEntity>

    @Query("DELETE FROM attribute_def WHERE id = :id")
    suspend fun delete(id: String)

    @Query("SELECT COUNT(*) FROM attribute_def")
    fun count(): Int
}

@Dao
interface AnnotationDao {
    @Query("SELECT * FROM annotation WHERE storage_id = :storageId AND deleted_at IS NULL ORDER BY z_order, created_at")
    fun observeByStorage(storageId: String): Flow<List<AnnotationEntity>>

    @Query("SELECT * FROM annotation WHERE location_id = :locationId AND deleted_at IS NULL LIMIT 1")
    suspend fun byLocation(locationId: String): AnnotationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(a: AnnotationEntity)

    @Query("SELECT * FROM annotation")
    suspend fun allWithDeleted(): List<AnnotationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<AnnotationEntity>)

    @Query("UPDATE annotation SET deleted_at = :now, updated_at = :now, device_last_modified = :dev WHERE id = :id")
    suspend fun softDelete(id: String, now: Long, dev: String)

    @Query("DELETE FROM annotation WHERE id = :id")
    suspend fun hardDelete(id: String)

    @Query("SELECT * FROM annotation WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): AnnotationEntity?
}

@Dao
interface LabelTemplateDao {
    @Query("SELECT * FROM label_template WHERE deleted_at IS NULL ORDER BY name COLLATE LOCALIZED")
    fun observeAll(): Flow<List<LabelTemplateEntity>>

    @Query("SELECT * FROM label_template WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): LabelTemplateEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(t: LabelTemplateEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<LabelTemplateEntity>)

    @Query("SELECT * FROM label_template")
    suspend fun allWithDeleted(): List<LabelTemplateEntity>

    @Query("SELECT COUNT(*) FROM label_template")
    fun count(): Int

    @Query("UPDATE label_template SET deleted_at = :now, updated_at = :now, device_last_modified = :dev WHERE id = :id")
    suspend fun softDelete(id: String, now: Long, dev: String)

    @Query("DELETE FROM label_template WHERE id = :id")
    suspend fun hardDelete(id: String)
}

@Dao
interface PrinterDao {
    @Query("SELECT * FROM printer_profile WHERE deleted_at IS NULL ORDER BY name COLLATE LOCALIZED")
    fun observeAll(): Flow<List<PrinterProfileEntity>>

    @Query("SELECT * FROM printer_profile WHERE id = :id LIMIT 1")
    suspend fun byId(id: String): PrinterProfileEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(p: PrinterProfileEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(list: List<PrinterProfileEntity>)

    @Query("SELECT * FROM printer_profile")
    suspend fun allWithDeleted(): List<PrinterProfileEntity>

    @Query("UPDATE printer_profile SET deleted_at = :now, updated_at = :now, device_last_modified = :dev WHERE id = :id")
    suspend fun softDelete(id: String, now: Long, dev: String)

    @Query("DELETE FROM printer_profile WHERE id = :id")
    suspend fun hardDelete(id: String)
}

@Dao
interface ConflictDao {
    @Query("SELECT * FROM conflict_log ORDER BY resolved_at DESC LIMIT :limit")
    suspend fun recent(limit: Int): List<ConflictLogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(c: ConflictLogEntity)

    @Query("DELETE FROM conflict_log")
    suspend fun clear()
}

@Dao
interface MetaDao {
    @Query("SELECT value FROM schema_meta WHERE key = :key LIMIT 1")
    fun get(key: String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(m: SchemaMetaEntity)

    @Query("SELECT * FROM schema_meta ORDER BY key")
    suspend fun all(): List<SchemaMetaEntity>
}
