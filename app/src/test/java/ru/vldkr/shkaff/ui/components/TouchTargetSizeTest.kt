package ru.vldkr.shkaff.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.features.items.tagChip
import ru.vldkr.shkaff.features.labels.LabelGenerator
import ru.vldkr.shkaff.features.labels.formatsRow
import ru.vldkr.shkaff.features.search.searchRow
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-059: минимальный тач-таргет 48dp (M3/WCAG) для чипов фильтра, кликабельных
// строк поиска и кнопок формата в редакторе шаблонов. Плотность 1: px == dp,
// границы semantics-узлов сравниваем напрямую с нормой 48.
@RunWith(RobolectricTestRunner::class)
class TouchTargetSizeTest {
    @get:Rule
    val rule = createComposeRule()

    @Composable
    private fun AtDensity1(content: @Composable () -> Unit) {
        CompositionLocalProvider(LocalDensity provides Density(1f)) {
            ShkaffTheme { content() }
        }
    }

    @Test
    fun `search result row is not shorter than 48dp`() {
        rule.setContent {
            AtDensity1 {
                Box(Modifier.searchRow {}.padding(vertical = 10.dp)) {
                    Text("носки", style = MaterialTheme.typography.titleMedium)
                }
            }
        }
        val nodes = rule.onAllNodes(hasClickAction()).fetchSemanticsNodes()
        assertTrue("нет кликабельной строки", nodes.isNotEmpty())
        val h = nodes.maxOf { it.boundsInRoot.height }
        assertTrue("строка результата поиска ниже 48dp: $h", h >= 48f)
    }

    @Test
    fun `filter chip is not shorter than 48dp`() {
        rule.setContent {
            AtDensity1 {
                FilterChip(
                    selected = false,
                    onClick = {},
                    label = { Text("Все") },
                    modifier = Modifier.tagChip(),
                )
            }
        }
        val nodes = rule.onAllNodes(hasClickAction()).fetchSemanticsNodes()
        assertTrue("нет кликабельного чипа", nodes.isNotEmpty())
        val h = nodes.maxOf { it.boundsInRoot.height }
        assertTrue("чип фильтра ниже 48dp: $h", h >= 48f)
    }

    @Test
    fun `formats row scrolls horizontally instead of squeezing buttons`() {
        rule.setContent {
            AtDensity1 {
                Box(Modifier.width(320.dp)) {
                    Row(modifier = Modifier.formatsRow(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        LabelGenerator.FORMATS.forEach { fmt ->
                            OutlinedButton(onClick = {}) {
                                Text(fmt, style = MaterialTheme.typography.labelSmall, maxLines = 1)
                            }
                        }
                    }
                }
            }
        }
        // На Robolectric метрики текста ≈0, поэтому ширина кнопок тут бесмысленна —
        // проверяем сам механизм фикса: ряд с горизонтальным скроллом (ScrollBy),
        // а не семь колонок с weight(1f).
        val nodes = rule.onAllNodes(SemanticsMatcher.keyIsDefined(SemanticsProperties.HorizontalScrollAxisRange)).fetchSemanticsNodes()
        assertTrue("ряд кнопок формата не прокручивается горизонтально", nodes.isNotEmpty())
    }
}
