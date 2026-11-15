package ru.vldkr.shkaff.ui.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.theme.ShkaffTheme
import java.util.concurrent.CopyOnWriteArrayList

// T-023: inline-добавление значения словаря в AttrFields/SelectField:
// при провале записи значения оно НЕ применяется, а показывается короткий
// текст ошибки; при успехе значение применяется и словарь обновляется.
@RunWith(RobolectricTestRunner::class)
class SelectInlineAddTest {

    @get:Rule
    val rule = createComposeRule()

    @Before
    fun clearDb() {
        runBlocking { Deps.db.clearAllTables() }
    }

    private fun def(id: String) = AttributeDefEntity(
        id = id, scope = "item", key = "t023-color-$id", label = "Цвет T023",
        type = "select", options = "[]", created_at = 0, updated_at = 0
    )

    private fun errorNodes() =
        rule.onAllNodesWithText("Словарь не обновлён", substring = true).fetchSemanticsNodes()

    @Test
    fun `failed dictionary write shows error and does not apply value`() {
        val d = def("нет-в-бд-" + System.nanoTime()) // определения нет в БД — запись невозможна
        val applied = CopyOnWriteArrayList<Pair<String, String>>()
        rule.setContent {
            ShkaffTheme { AttrFields(listOf(d), emptyMap()) { k, v -> applied.add(k to v) } }
        }
        rule.onNodeWithText("+ значение").performClick()
        rule.onNodeWithText("Новое значение").performTextInput("Красный")
        rule.onNodeWithText("Добавить").performClick()
        // waitUntil бросает по таймауту: на старом коде текст ошибки не появляется.
        rule.waitUntil(4_000) { errorNodes().isNotEmpty() }
        assertEquals("значение применено несмотря на провал словаря", emptyList<Pair<String, String>>(), applied.toList())
    }

    @Test
    fun `successful inline add applies value and updates dictionary`() {
        val d = def("есть-" + System.nanoTime())
        runBlocking { Deps.attributes.upsert(d) }
        val applied = CopyOnWriteArrayList<Pair<String, String>>()
        rule.setContent {
            ShkaffTheme { AttrFields(listOf(d), emptyMap()) { k, v -> applied.add(k to v) } }
        }
        rule.onNodeWithText("+ значение").performClick()
        rule.onNodeWithText("Новое значение").performTextInput("Красный")
        rule.onNodeWithText("Добавить").performClick()
        rule.waitUntil(4_000) { applied.isNotEmpty() }
        assertEquals(d.key to "Красный", applied.first())
        val stored = runBlocking { Deps.attributes.byId(d.id) }!!
        assertTrue("значение не попало в словарь", stored.options.contains("Красный"))
        rule.onAllNodesWithText("Словарь не обновлён", substring = true)
            .fetchSemanticsNodes().let { assertTrue("ошибка показана при успехе", it.isEmpty()) }
        // после успеха строка ввода закрывается (при провале остаётся для повтора)
        rule.waitUntil(4_000) {
            rule.onAllNodesWithText("Новое значение").fetchSemanticsNodes().isEmpty()
        }
    }
}
