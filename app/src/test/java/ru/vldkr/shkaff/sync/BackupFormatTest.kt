package ru.vldkr.shkaff.sync

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelDocEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import java.io.ByteArrayOutputStream
import java.io.File

@RunWith(RobolectricTestRunner::class)
class BackupFormatTest {

    private val storage = StorageEntity(
        id = "s1", name = "Гараж", description = "", attributes = "{}", parent_id = null,
        photo_path = null, created_at = 1L, updated_at = 2L, deleted_at = null, device_last_modified = "dev"
    )

    private val item = ItemEntity(
        id = "i1", name = "Дрель", code = "DR-1", description = "", attributes = "{}",
        location_id = null, photo_path = null,
        created_at = 1L, updated_at = 2L, deleted_at = null, device_last_modified = "dev"
    )

    @Test
    fun jsonRoundTrip() {
        val input = MergeInput(storages = listOf(storage), items = listOf(item))
        val back = Backup.fromJson(Backup.toJson(input))
        assertEquals(1, back.storages.size)
        assertEquals("Гараж", back.storages.single().name)
        assertEquals("DR-1", back.items.single().code)
        assertEquals("dev", back.items.single().device_last_modified)
    }

    @Test
    fun expiryDateSurvivesRoundTrip() {
        val withExpiry = item.copy(expiry_date = "2026-12-15")
        val back = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(withExpiry))))
        assertEquals("2026-12-15", back.items.single().expiry_date)
        val without = item.copy(expiry_date = null)
        val back2 = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(without))))
        assertEquals("", back2.items.single().expiry_date ?: "")
    }

    @Test
    fun eanSurvivesRoundTrip() {
        val withEan = item.copy(ean = "4607001234567")
        val back = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(withEan))))
        assertEquals("4607001234567", back.items.single().ean)
        val without = item.copy(ean = null)
        val back2 = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(without))))
        assertEquals("", back2.items.single().ean ?: "")
    }

    @Test
    fun barcodePhotoSurvivesRoundTrip() {
        val withPhoto = item.copy(barcode_photo_path = "/data/user/0/app/barcode_photos/x.jpg")
        val back = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(withPhoto))))
        assertEquals("/data/user/0/app/barcode_photos/x.jpg", back.items.single().barcode_photo_path)
        val without = item.copy(barcode_photo_path = null)
        val back2 = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(without))))
        assertEquals(null, back2.items.single().barcode_photo_path)
    }

    @Test
    fun deletedRowSurvivesRoundTrip() {
        val gone = item.copy(deleted_at = 500L)
        val back = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(gone))))
        assertEquals(500L, back.items.single().deleted_at)
    }

    @Test
    fun tagsSurviveRoundTrip() {
        val tagged = item.copy(tags = """["электро","срочно"]""")
        val back = Backup.fromJson(Backup.toJson(MergeInput(items = listOf(tagged))))
        assertEquals("""["электро","срочно"]""", back.items.single().tags)
    }

    @Test
    fun zipFileRoundTrip() {
        val ctx = ApplicationProvider.getApplicationContext<Application>()
        val input = MergeInput(storages = listOf(storage), items = listOf(item))
        val f = File(ctx.cacheDir, "rt.zip")
        Backup.exportToFile(input, f)
        val back = Backup.importFromFile(f)
        assertEquals("Дрель", back.items.single().name)
        f.delete()
    }

    // Фото лежит в filesDir/photos, в базе — только имя файла, поэтому в zip
    // уезжает сам файл, а при импорте распаковывается в каталог фото.
    @Test
    fun photosRideAlongInTheZip() {
        val ctx = ApplicationProvider.getApplicationContext<Application>()
        val src = File(ctx.cacheDir, "photos-out").apply { mkdirs() }
        val dst = File(ctx.cacheDir, "photos-in").apply { mkdirs() }
        File(src, "a.jpg").writeBytes(byteArrayOf(1, 2, 3))
        File(src, "b.png").writeBytes(byteArrayOf(9, 9))
        File(src, "pic.png").writeBytes(byteArrayOf(7))
        val withPhotos = item.copy(photo_path = "photos/a.jpg", barcode_photo_path = "b.png")
        val doc = LabelDocEntity(
            id = "d1",
            name = "макет",
            entity_kind = "item",
            doc_json = """{"elements":[{"path":"pic.png"}]}""",
            created_at = 1L,
            updated_at = 2L,
        )
        val input = MergeInput(items = listOf(withPhotos), labelDocs = listOf(doc))
        val f = File(ctx.cacheDir, "photos.zip")
        Backup.exportToFile(input, f, src)
        val back = Backup.importFromFile(f, dst)
        assertEquals("Дрель", back.items.single().name)
        assertArrayEquals(byteArrayOf(1, 2, 3), File(dst, "a.jpg").readBytes())
        assertArrayEquals(byteArrayOf(9, 9), File(dst, "b.png").readBytes())
        assertArrayEquals(byteArrayOf(7), File(dst, "pic.png").readBytes())
        f.delete()
    }

    @Test
    fun zipStreamRoundTrip() {
        val input = MergeInput(storages = listOf(storage), items = listOf(item))
        val bytes = ByteArrayOutputStream().also { Backup.exportZipToStream(input, it) }.toByteArray()
        assertTrue(bytes.isNotEmpty())
        val f = File.createTempFile("shkaff", ".zip").also { it.writeBytes(bytes) }
        val back = Backup.importFromFile(f)
        assertEquals(1, back.storages.size)
        f.delete()
    }

    @Test(expected = IllegalArgumentException::class)
    fun wrongFormatRejected() {
        Backup.fromJson("""{"format":"other","version":1}""")
    }

    @Test
    fun attributeDefCategoryTierSurviveRoundTrip() {
        val def = AttributeDefEntity(
            id = "a1", scope = "item", key = "material", label = "Материал",
            type = "text", options = "[]", sort_order = 2, required = false,
            created_at = 1L, updated_at = 2L, deleted_at = null, device_last_modified = "dev",
            category = "Инструменты", tier = "min"
        )
        val back = Backup.fromJson(Backup.toJson(MergeInput(attributeDefs = listOf(def))))
        val d = back.attributeDefs.single()
        assertEquals("a1", d.id)
        assertEquals("Инструменты", d.category)
        assertEquals("min", d.tier)
    }

    @Test
    fun oldAttributeDefGetsDefaults() {
        val json = """
            {
              "format": "shkaff-backup",
              "version": 1,
              "attribute_defs": [
                {"id":"a1","scope":"item","key":"material","label":"Материал","type":"text","options":"[]","sort_order":2,"required":false,"created_at":1,"updated_at":2,"device_last_modified":"dev"}
              ]
            }
        """.trimIndent()
        val back = Backup.fromJson(json)
        val d = back.attributeDefs.single()
        assertEquals("*", d.category)
        assertEquals("rec", d.tier)
    }
}
