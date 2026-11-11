package ru.vldkr.shkaff.features.items

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import ru.vldkr.shkaff.data.db.LocationEntity

// П1.3: мастер вещи, шаг «QR ящика» — подсказка «распечатать этикетку ящика»,
// когда сканировать нечего: у выбранного ящика нет напечатанной этикетки либо
// ни один ящик ещё не маркировался.
class ItemWizardQrPrintHintTest {

    private fun loc(id: String, labelledAt: Long?): LocationEntity = LocationEntity(
        id = id,
        storage_id = "storage-1",
        label = id,
        created_at = 0L,
        updated_at = 0L,
        labelled_at = labelledAt
    )

    @Test
    fun `no locations - no hint, empty-boxes warning covers it`() {
        assertNull(qrPrintHintLocationId(emptyList(), null))
        assertNull(qrPrintHintLocationId(emptyList(), "l1"))
    }

    @Test
    fun `none labelled and nothing selected - suggest first box`() {
        val a = loc("l1", null)
        val b = loc("l2", null)
        assertEquals("l1", qrPrintHintLocationId(listOf(a, b), null))
    }

    @Test
    fun `selected unlabelled box - hint even if other boxes are labelled`() {
        val printed = loc("l1", 100L)
        val bare = loc("l2", null)
        assertEquals("l2", qrPrintHintLocationId(listOf(printed, bare), "l2"))
    }

    @Test
    fun `selected printed box - no hint even if other boxes lack labels`() {
        val printed = loc("l1", 100L)
        val bare = loc("l2", null)
        assertNull(qrPrintHintLocationId(listOf(printed, bare), "l1"))
    }

    @Test
    fun `nothing selected but some boxes already printed - no hint`() {
        val printed = loc("l1", 100L)
        val bare = loc("l2", null)
        assertNull(qrPrintHintLocationId(listOf(printed, bare), null))
    }
}
