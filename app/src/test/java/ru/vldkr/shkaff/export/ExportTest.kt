package ru.vldkr.shkaff.export

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.zip.ZipInputStream

@RunWith(RobolectricTestRunner::class)
class ExportTest {

    private fun storage(id: String, name: String, parent: String? = null) = StorageEntity(
        id = id, name = name, description = "", attributes = "{}", parent_id = parent,
        photo_path = null, created_at = 1L, updated_at = 2L, deleted_at = null, device_last_modified = "dev"
    )

    private fun location(id: String, storageId: String, parent: String?, label: String, name: String) = LocationEntity(
        id = id, storage_id = storageId, parent_id = parent, label = label, name = name,
        attributes = "{}", photo_path = null, created_at = 1L, updated_at = 2L,
        deleted_at = null, device_last_modified = "dev"
    )

    private fun item(id: String, name: String, code: String, locationId: String? = null, deleted: Long? = null) = ItemEntity(
        id = id, name = name, code = code, description = "", attributes = "{}",
        location_id = locationId, photo_path = null,
        created_at = 1L, updated_at = 2L, deleted_at = deleted, device_last_modified = "dev",
        expiry_date = "01.01.2027", tags = TagsJson.toJson(listOf("мастерская", "гараж"))
    )

    @Test
    fun csvEscapesQuotesCommasAndNewlines() {
        val sheet = Sheet("T", listOf("A", "B"), listOf(listOf("1,2", "say \"hi\"", "line1\nline2", "")))
        val expected = "A,B\r\n\"1,2\",\"say \"\"hi\"\"\",\"line1\nline2\",\r\n"
        assertEquals(expected, sheet.toCsv())
    }

    @Test
    fun csvBytesStartsWithUtf8Bom() {
        val b = Sheet("T", listOf("А"), emptyList()).csvBytes()
        assertEquals(0xEF.toByte(), b[0])
        assertEquals(0xBB.toByte(), b[1])
        assertEquals(0xBF.toByte(), b[2])
    }

    @Test
    fun xlsxContainsOoxmlPartsAndValues() {
        val sheet = Sheet("Вещи", listOf("Название", "Код"), listOf(listOf("1,2", "a<b\"c")))
        val out = ByteArrayOutputStream()
        sheet.toXlsx(out)

        val entries = mutableMapOf<String, String>()
        ZipInputStream(ByteArrayInputStream(out.toByteArray())).use { z ->
            var e = z.nextEntry
            while (e != null) {
                entries[e.name] = String(z.readBytes(), Charsets.UTF_8)
                e = z.nextEntry
            }
        }

        assertTrue(entries.containsKey("[Content_Types].xml"))
        assertTrue(entries.containsKey("_rels/.rels"))
        assertTrue(entries.containsKey("xl/workbook.xml"))
        assertTrue(entries.containsKey("xl/_rels/workbook.xml.rels"))
        assertTrue(entries.containsKey("xl/styles.xml"))
        assertTrue(entries.containsKey("xl/worksheets/sheet1.xml"))
        val sheetXml = entries.getValue("xl/worksheets/sheet1.xml")
        assertTrue(sheetXml.contains(">1,2<"))
        assertTrue(sheetXml.contains("a&lt;b&quot;c"))
        assertTrue(entries.getValue("xl/workbook.xml").contains("name=\"Вещи\""))
    }

    @Test
    fun itemsSheetBuildsPathsAndTags() {
        val s0 = storage("s0", "Дом")
        val s1 = storage("s1", "Гараж", parent = "s0")
        val l0 = location("l0", "s1", null, "A", "Коробка А")
        val l1 = location("l1", "s1", "l0", "A1", "Вкладыш")
        val i = item("i1", "Дрель", "DR-1", locationId = "l1")

        val sheet = ExportBuilders.items(listOf(i), listOf(l0, l1), listOf(s0, s1))
        assertEquals(listOf("Название", "Код", "Штрихкод (EAN)", "Описание", "Шкаф", "Ящик", "Теги", "Срок годности", "Создана", "Изменена"), sheet.headers)
        val row = sheet.rows.single()
        assertEquals("Дрель", row[0])
        assertEquals("DR-1", row[1])
        assertEquals("", row[2])
        assertEquals("Дом › Гараж", row[4])
        assertEquals("A › A1", row[5])
        assertEquals("мастерская; гараж", row[6])
        assertEquals("01.01.2027", row[7])
    }

    @Test
    fun locationsSheetIncludesParentAndStorage() {
        val s0 = storage("s0", "Дом")
        val s1 = storage("s1", "Гараж", parent = "s0")
        val l0 = location("l0", "s1", null, "A", "Коробка А")
        val l1 = location("l1", "s1", "l0", "A1", "Вкладыш")

        val sheet = ExportBuilders.locations(listOf(l1, l0), listOf(s0, s1))
        assertEquals(listOf("Название", "Метка", "Шкаф", "Родительский ящик", "Создан", "Изменён"), sheet.headers)
        assertEquals(2, sheet.rows.size)
        val top = sheet.rows[0]
        assertEquals("Коробка А", top[0])
        assertEquals("A", top[1])
        assertEquals("Дом › Гараж", top[2])
        assertEquals("", top[3])
        val child = sheet.rows[1]
        assertEquals("Вкладыш", child[0])
        assertEquals("A1", child[1])
        assertEquals("A", child[3])
    }

    @Test
    fun deletedItemsAreSkipped() {
        assertEquals(0, ExportBuilders.items(listOf(item("d", "Удалена", "D-1", deleted = 5L)), emptyList(), emptyList()).rows.size)
        assertEquals(0, ExportBuilders.locations(listOf(location("l", "s", null, "X", "Удалён").let { it.copy(deleted_at = 5L) }), emptyList()).rows.size)
    }

    @Test
    fun storagePathSurvivesCycle() {
        val a = storage("a", "A").let { it.copy(parent_id = "b") }
        val b = storage("b", "B").let { it.copy(parent_id = "a") }
        assertEquals("B › A", ExportBuilders.storagePath("a", mapOf("a" to a, "b" to b)))
    }
}
