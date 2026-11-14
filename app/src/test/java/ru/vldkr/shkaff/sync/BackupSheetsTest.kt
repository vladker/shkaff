package ru.vldkr.shkaff.sync

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.SheetLayoutEntity
import ru.vldkr.shkaff.data.db.SheetSlotEntity
import ru.vldkr.shkaff.di.Deps

// T-069: листы этикеток (sheet_layout/sheet_slot) обязаны ехать в бэкап,
// слияние и пир-синхронизацию наравне с остальными таблицами.
@RunWith(RobolectricTestRunner::class)
class BackupSheetsTest {

    private fun layout(
        id: String,
        name: String,
        ts: Long,
        del: Long? = null,
    ) = SheetLayoutEntity(
        id = id, name = name,
        paper_w_mm = 100.0, paper_h_mm = 150.0, margin_mm = 5.0,
        created_at = 1000L, updated_at = ts, deleted_at = del,
        device_last_modified = "dev",
    )

    private fun slot(
        id: String,
        layoutId: String,
        ts: Long,
        x: Double = 1.0,
        style: String = "tpl1",
    ) = SheetSlotEntity(
        id = id, layout_id = layoutId,
        x_mm = x, y_mm = 2.0, w_mm = 40.0, h_mm = 25.0,
        style_template_id = style, sort_order = 3,
        created_at = 1000L, updated_at = ts, deleted_at = null,
        device_last_modified = "dev",
    )

    @Before
    fun clearDb() {
        runBlocking { Deps.db.clearAllTables() }
    }

    @Test
    fun sheetsSurviveJsonRoundTrip() {
        val input = MergeInput(
            sheetLayouts = listOf(layout("l1", "А4 2×3", 2000L)),
            sheetSlots = listOf(slot("s1", "l1", 2000L)),
        )
        val back = Backup.fromJson(Backup.toJson(input))
        val l = back.sheetLayouts.single()
        assertEquals("l1", l.id)
        assertEquals("А4 2×3", l.name)
        assertEquals(100.0, l.paper_w_mm, 0.0)
        assertEquals(150.0, l.paper_h_mm, 0.0)
        assertEquals(5.0, l.margin_mm, 0.0)
        assertEquals(2000L, l.updated_at)
        assertEquals("dev", l.device_last_modified)
        val s = back.sheetSlots.single()
        assertEquals("s1", s.id)
        assertEquals("l1", s.layout_id)
        assertEquals(1.0, s.x_mm, 0.0)
        assertEquals(2.0, s.y_mm, 0.0)
        assertEquals(40.0, s.w_mm, 0.0)
        assertEquals(25.0, s.h_mm, 0.0)
        assertEquals("tpl1", s.style_template_id)
        assertEquals(3, s.sort_order)
    }

    @Test
    fun deletedLayoutSurvivesJsonRoundTrip() {
        val input = MergeInput(sheetLayouts = listOf(layout("l1", "U", 2000L, del = 3000L)))
        val back = Backup.fromJson(Backup.toJson(input))
        assertEquals(3000L, back.sheetLayouts.single().deleted_at)
    }

    @Test
    fun buildInputIncludesSheetsFromDb() {
        runBlocking {
            Deps.db.sheetLayoutDao().upsert(layout("l1", "А4", 1000L))
            Deps.db.sheetSlotDao().upsert(slot("s1", "l1", 1000L))
            val input = Backup.buildInput(Deps.db)
            assertEquals(1, input.sheetLayouts.size)
            assertEquals(1, input.sheetSlots.size)
            assertEquals("l1", input.sheetSlots.single().layout_id)
        }
    }

    @Test
    fun applyMergeWritesSheetsInFkOrder() {
        val merged = MergeInput(
            sheetLayouts = listOf(layout("l1", "А4", 1000L)),
            sheetSlots = listOf(slot("s1", "l1", 1000L)),
        )
        runBlocking {
            Backup.applyMerge(MergeResult(merged, emptyList(), MergeStats()), Deps.db)
            assertEquals(1, Deps.db.sheetLayoutDao().allWithDeleted().size)
            assertEquals(1, Deps.db.sheetSlotDao().allWithDeleted().size)
        }
    }

    @Test
    fun mergeEngineMergesSheetsNewerWins() {
        val local = MergeInput(sheetLayouts = listOf(layout("l1", "старый", 1000L)))
        val remote = MergeInput(
            sheetLayouts = listOf(layout("l1", "новый", 2000L)),
            sheetSlots = listOf(slot("s1", "l1", 2000L)),
        )
        val r = MergeEngine.merge(local, remote, remoteWins = false)
        assertEquals("новый", r.merged.sheetLayouts.single().name)
        assertEquals(1, r.merged.sheetSlots.size)
        assertTrue(r.conflicts.isEmpty())
    }

    @Test
    fun sanitizerDropsOrphanSheetSlot() {
        val input = MergeInput(
            sheetLayouts = listOf(layout("l1", "А4", 1000L)),
            sheetSlots = listOf(slot("s1", "l1", 1000L), slot("s2", "нет-такого", 1000L)),
        )
        val r = MergeSanitizer.sanitize(input)
        assertEquals(listOf("s1"), r.merged.sheetSlots.map { it.id })
        assertTrue(r.warnings.any { it.contains("слот") })
    }
}
