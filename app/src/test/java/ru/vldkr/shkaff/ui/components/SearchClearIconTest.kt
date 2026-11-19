package ru.vldkr.shkaff.ui.components
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-062: крестик «Очистить» в полях поиска («Вещи», «Продукты», «Хранилища», «Поиск»).
// Действие показано только когда в поле есть что стирать; нажатие вызывает колбэк сброса.
@RunWith(RobolectricTestRunner::class)
class SearchClearIconTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun `no clear action while the field is empty`() {
        var calls = 0
        rule.setContent { ShkaffTheme { SearchClearIcon("") { calls++ } } }
        rule.waitForIdle()
        assertEquals(0, rule.onAllNodesWithContentDescription("Очистить").fetchSemanticsNodes().size)
        assertEquals(0, calls)
    }

    @Test
    fun `clear action is shown and calls the reset callback`() {
        var calls = 0
        rule.setContent { ShkaffTheme { SearchClearIcon("носки") { calls++ } } }
        rule.onNodeWithContentDescription("Очистить").performClick()
        assertEquals(1, calls)
    }
}
