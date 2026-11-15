package ru.vldkr.shkaff.features.loans

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import java.time.LocalDate
import java.time.ZoneId
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-024: невалидная дата «Вернуть до» молча превращалась в выдачу без срока
// (напоминание не сработает), а «30.02.2026» ещё и роняла приложение
// (LocalDate.of бросает DateTimeException). Диалог обязан подсказывать формат
// и не давать подтвердить выдачу с нераспознанной датой — как «Срок годности»
// в ItemForm.
@RunWith(RobolectricTestRunner::class)
class LendDialogDateTest {

    @get:Rule
    val rule = createComposeRule()

    private class Confirmed(val borrower: String, val note: String, val dueAt: Long?)

    private fun showDialog(): ArrayList<Confirmed> {
        val confirmed = ArrayList<Confirmed>()
        rule.setContent {
            ShkaffTheme {
                LendDialog(
                    title = "Выдать временно",
                    onDismiss = {},
                    onConfirm = { b, n, d -> confirmed.add(Confirmed(b, n, d)) }
                )
            }
        }
        return confirmed
    }

    private fun fillBorrower() =
        rule.onNodeWithText("Кому").performTextInput("Иван")

    private fun fillDue(text: String) =
        rule.onNodeWithText("Вернуть до: ДД.ММ.ГГГГ (необязательно)").performTextInput(text)

    private fun pressLend() = rule.onNodeWithText("Выдать").performClick()

    @Test
    fun `мусорная дата не создаёт выдачу без срока и подсказывает формат`() {
        val confirmed = showDialog()
        fillBorrower()
        fillDue("завтра")
        pressLend()

        assertEquals("Выдача с мусорной датой не должна подтверждаться", 0, confirmed.size)
        rule.onNodeWithText("Не распознал «Вернуть до». Формат: ДД.ММ.ГГГГ").assertExists()
    }

    @Test
    fun `несуществующая дата не роняет диалог и блокирует подтверждение`() {
        val confirmed = showDialog()
        fillBorrower()
        fillDue("30.02.2026")
        pressLend()

        assertEquals("Выдача с несуществующей датой не должна подтверждаться", 0, confirmed.size)
        rule.onNodeWithText("Не распознал «Вернуть до». Формат: ДД.ММ.ГГГГ").assertExists()
    }

    @Test
    fun `корректная дата уходит в колбэк эпохой начала суток`() {
        val confirmed = showDialog()
        fillBorrower()
        fillDue("01.03.2026")
        pressLend()

        assertEquals(1, confirmed.size)
        val expected = LocalDate.of(2026, 3, 1)
            .atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
        assertNotNull(confirmed[0].dueAt)
        assertEquals(expected, confirmed[0].dueAt)
    }

    @Test
    fun `пустая дата остаётся выдачей без срока`() {
        val confirmed = showDialog()
        fillBorrower()
        pressLend()

        assertEquals(1, confirmed.size)
        assertNull(confirmed[0].dueAt)
    }
}
