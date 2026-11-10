package ru.vldkr.shkaff.sync

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import java.io.File
import java.util.zip.ZipFile

// T-064: форма копирует фото из галереи в filesDir/item_photos/, фото штрихкода — в
// filesDir/barcode_photos/, а бэкап искал файлы по имени только в filesDir/photos.
// Фото в БД — абсолютный путь, он одинаков на любом устройстве для того же пакета,
// поэтому архив обязан везти файл по самому пути, а импорт — вернуть его в свою папку.
@RunWith(RobolectricTestRunner::class)
class BackupPhotoPathsTest {

    private val ctx get() = ApplicationProvider.getApplicationContext<Application>()

    private fun freshRoot(name: String): File =
        File(ctx.cacheDir, name).apply { deleteRecursively(); mkdirs() }

    private fun item(photoPath: String?, barcodePhoto: String?) =
        ItemEntity(
            id = "i1",
            name = "Дрель",
            code = "DR-1",
            description = "",
            attributes = "{}",
            location_id = null,
            photo_path = photoPath,
            created_at = 1L,
            updated_at = 2L,
            deleted_at = null,
            device_last_modified = "dev",
        ).copy(barcode_photo_path = barcodePhoto)

    private fun storage(photoPath: String?) =
        StorageEntity(
            id = "s1",
            name = "Гараж",
            description = "",
            attributes = "{}",
            parent_id = null,
            photo_path = photoPath,
            created_at = 1L,
            updated_at = 2L,
            deleted_at = null,
            device_last_modified = "dev",
        )

    private fun zipEntryNames(zip: File): List<String> =
        ZipFile(zip).use { zf -> zf.entries().toList().map { it.name } }

    @Test
    fun galleryAndBarcodePhotosRideAlongInTheZip() {
        val root = freshRoot("t064-zip")
        val photosDir = File(root, "photos").apply { mkdirs() }
        val gallery = File(root, "item_photos").apply { mkdirs() }
        val barcodes = File(root, "barcode_photos").apply { mkdirs() }
        val storages = File(root, "storage_photos").apply { mkdirs() }
        File(gallery, "g1.jpg").writeBytes(byteArrayOf(1, 2, 3))
        File(barcodes, "b1.jpg").writeBytes(byteArrayOf(4, 5))
        File(storages, "s1.jpg").writeBytes(byteArrayOf(6))
        val input =
            MergeInput(
                items =
                    listOf(
                        item(
                            File(gallery, "g1.jpg").absolutePath,
                            File(barcodes, "b1.jpg").absolutePath,
                        )
                    ),
                storages = listOf(storage(File(storages, "s1.jpg").absolutePath)),
            )
        val zip = File(root, "bk.zip")
        Backup.exportToFile(input, zip, photosDir)
        val names = zipEntryNames(zip)
        assertTrue("photos/g1.jpg missing in $names", names.contains("photos/g1.jpg"))
        assertTrue("photos/b1.jpg missing in $names", names.contains("photos/b1.jpg"))
        assertTrue("photos/s1.jpg missing in $names", names.contains("photos/s1.jpg"))
        ZipFile(zip).use { zf ->
            assertArrayEquals(byteArrayOf(1, 2, 3), zf.getInputStream(zf.getEntry("photos/g1.jpg")).readBytes())
            assertArrayEquals(byteArrayOf(4, 5), zf.getInputStream(zf.getEntry("photos/b1.jpg")).readBytes())
            assertArrayEquals(byteArrayOf(6), zf.getInputStream(zf.getEntry("photos/s1.jpg")).readBytes())
        }
    }

    // Запасной вариант из старого кода должен жить: если файла по пути из БД нет
    // (переехал/пропал), он по-прежнему ищется по имени в photosDir.
    @Test
    fun deadDbPathStillResolvesByNameInPhotosDir() {
        val root = freshRoot("t064-fallback")
        val photosDir = File(root, "photos").apply { mkdirs() }
        File(photosDir, "x.jpg").writeBytes(byteArrayOf(7, 7))
        val dead = File(root, "elsewhere/deep/x.jpg").absolutePath
        val input = MergeInput(items = listOf(item(dead, null)))
        val zip = File(root, "bk.zip")
        Backup.exportToFile(input, zip, photosDir)
        val names = zipEntryNames(zip)
        assertTrue("photos/x.jpg missing in $names", names.contains("photos/x.jpg"))
    }

    // «Восстановление на другом устройстве»: файлов на диске нет, есть только архив.
    // Фото из item_photos/ обязано вернуться ровно по пути из backup.json.
    @Test
    fun restoredPhotoReturnsToItsOwnDbPath() {
        val root = freshRoot("t064-restore")
        val photosDir = File(root, "photos").apply { mkdirs() }
        val gallery = File(root, "item_photos").apply { mkdirs() }
        val galleryPhoto = File(gallery, "g1.jpg").apply { writeBytes(byteArrayOf(1, 2, 3)) }
        val input = MergeInput(items = listOf(item(galleryPhoto.absolutePath, null)))
        val zip = File(root, "bk.zip")
        Backup.exportToFile(input, zip, photosDir)
        assertTrue(galleryPhoto.delete())
        val back = Backup.importFromFile(zip, photosDir)
        assertEquals("Дрель", back.items.single().name)
        assertTrue(
            "photo not restored at ${galleryPhoto.absolutePath}",
            galleryPhoto.isFile,
        )
        assertArrayEquals(byteArrayOf(1, 2, 3), galleryPhoto.readBytes())
    }
}
