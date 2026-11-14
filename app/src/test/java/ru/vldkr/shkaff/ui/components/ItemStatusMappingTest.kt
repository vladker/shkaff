package ru.vldkr.shkaff.ui.components

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import java.time.LocalDate

// T-042: контракт статусной карты для карточек каталога (в т.ч. «Продуктов»):
// выдача из loansByItem — приоритетней срока, «на месте» на карточке не рисуется.
class ItemStatusMappingTest {

    private fun item(expiry: String? = null) = ItemEntity(
        id = "i-" + System.nanoTime(), name = "Дрель", code = "DR-01", description = "",
        attributes = "{}", photo_path = null, location_id = "loc-1",
        created_at = 0, updated_at = 0, deleted_at = null, device_last_modified = "",
        expiry_date = expiry
    )

    private fun loan(borrower: String = "Иван") = LoanEntity(
        id = "l-" + System.nanoTime(), entity_type = "item", entity_id = "i-1",
        borrower = borrower, lent_at = 0, created_at = 0, updated_at = 0
    )

    @Test
    fun `loan outranks expiry on card status`() {
        val st = itemStatus(
            item(expiry = "2020-01-01"), hasLocation = true,
            loan = loan(), today = LocalDate.of(2025, 1, 1)
        )
        assertEquals(ItemStatusKind.LOANED, st.kind)
        assertEquals("Одолжено · Иван", st.label)
    }

    @Test
    fun `loaned status is drawn on card`() {
        assertEquals(true, itemStatus(item(), hasLocation = true, loan = loan("Пётр")).showOnCard())
    }

    @Test
    fun `on-place status is not drawn on card`() {
        val st = itemStatus(item(), hasLocation = true)
        assertEquals(ItemStatusKind.OK, st.kind)
        assertEquals(false, st.showOnCard())
    }
}
