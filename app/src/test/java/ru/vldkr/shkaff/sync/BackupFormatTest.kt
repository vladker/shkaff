package ru.vldkr.shkaff.sync

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ItemEntity
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
}
