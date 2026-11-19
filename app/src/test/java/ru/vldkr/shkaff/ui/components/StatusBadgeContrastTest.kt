package ru.vldkr.shkaff.ui.components
import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.ui.theme.Ozon
import kotlin.math.pow

// T-061: текст на цветной плашке статуса выбирается по WCAG-контрасту к её фону.
class StatusBadgeContrastTest {
    private fun lin(v: Float) = if (v <= 0.04041f) v / 12.92f else ((v + 0.055f) / 1.055f).pow(2.4f).toFloat()

    private fun lum(c: Color) = 0.2126f * lin(c.red) + 0.7152f * lin(c.green) + 0.0722f * lin(c.blue)

    private fun ratio(
        a: Color,
        b: Color,
    ): Float {
        val hi = maxOf(lum(a), lum(b))
        val lo = minOf(lum(a), lum(b))
        return (hi + 0.05f) / (lo + 0.05f)
    }

    private val badgeColors =
        listOf(Ozon.Blue, Ozon.Pink, Ozon.Orange, Ozon.Green, Ozon.TextMuted, Color.White)

    @Test
    fun `text on every badge color has enough contrast`() {
        for (bg in badgeColors) {
            val on = textColorFor(bg)
            assertTrue("$bg -> контраст ${ratio(on, bg)}", ratio(on, bg) >= 4.5f)
        }
    }

    @Test
    fun `gray badge picks the readable text color in both themes`() {
        val grayLight = Color(0xFF8A8A96) // Ozon.TextMuted, светлая тема — случай из карточки T-061
        val grayDark = Color(0xFF6B6B7B) // Ozon.TextMuted, тёмная тема
        assertTrue("белый на сером светлой темы нечитаем", ratio(Color.White, grayLight) < 4.5f)
        assertTrue("на сером светлой темы текст тёмный", textColorFor(grayLight) == Color.Black)
        assertTrue("на сером тёмной темы текст светлый", textColorFor(grayDark) == Color.White)
    }
}
