package ru.vldkr.shkaff.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-042: «Продукты» рисуют общую ItemCard: на ней обязаны рисоваться статус
// активной выдачи и строка EAN (иначе удаление ProductCard теряет данные).
@RunWith(RobolectricTestRunner::class)
class ItemCardRenderTest {

    @get:Rule
    val rule = createComposeRule()

    private fun item(ean: String?) = ItemEntity(
        id = "card-" + System.nanoTime(), name = "Творог 5%", code = "PR-01", description = "",
        attributes = "{}", photo_path = null, location_id = "loc-1",
        created_at = 0, updated_at = 0, deleted_at = null, device_last_modified = "",
        ean = ean
    )

    @Test
    fun `loaned status is drawn on the shared card`() {
        val loan = LoanEntity(
            id = "l-" + System.nanoTime(), entity_type = "item", entity_id = "i-1",
            borrower = "Пётр", lent_at = 0, created_at = 0, updated_at = 0
        )
        val status = itemStatus(item(ean = null), hasLocation = true, loan = loan)
        rule.setContent {
            ShkaffTheme {
                ItemCard(item(ean = null), "Ящик А", {}, status = status)
            }
        }
        rule.onNodeWithText("Одолжено · Пётр").assertIsDisplayed()
    }

    @Test
    fun `ean line is drawn on the shared card`() {
        rule.setContent {
            ShkaffTheme {
                ItemCard(item(ean = "4600000000017"), "Ящик А", {}, ean = "4600000000017")
            }
        }
        rule.onNodeWithText("EAN 4600000000017").assertIsDisplayed()
    }
}
