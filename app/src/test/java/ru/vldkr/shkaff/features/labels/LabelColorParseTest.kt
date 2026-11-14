package ru.vldkr.shkaff.features.labels

import android.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

// T-048: parseColor прятал битый цвет в Color.BLACK — печать уходила в чёрный
// без всякого сигнала. Теперь: parseColorOrNull -> null (явный сигнал),
// а parseColor требует явный fallback от вызывающей стороны.
@RunWith(RobolectricTestRunner::class)
class LabelColorParseTest {

    @Test
    fun `parseColorOrNull parses valid hex`() {
        assertEquals(0xFFFF8800.toInt(), LabelGenerator.parseColorOrNull("#FF8800"))
        assertEquals(Color.BLACK, LabelGenerator.parseColorOrNull("#000000"))
        // android.graphics.Color.parseColor понимает и имена — это его семантика,
        // форма шаблона (ColorHex) к ним строже: только #RRGGBB.
        assertEquals(Color.RED, LabelGenerator.parseColorOrNull("red"))
    }

    @Test
    fun `parseColorOrNull returns null for broken hex`() {
        assertNull(LabelGenerator.parseColorOrNull("ggg"))
        assertNull(LabelGenerator.parseColorOrNull("#GG8800"))
        assertNull(LabelGenerator.parseColorOrNull(""))
    }

    @Test
    fun `parseColor applies caller-provided fallback on broken hex`() {
        // Фон битый -> белый, а не чёрный; текст битый -> чёрный.
        assertEquals(Color.WHITE, LabelGenerator.parseColor("ggg", Color.WHITE))
        assertEquals(Color.BLACK, LabelGenerator.parseColor("#GG", Color.BLACK))
        // Валидный цвет игнорирует fallback.
        assertEquals(0xFFFF8800.toInt(), LabelGenerator.parseColor("#FF8800", Color.WHITE))
    }
}
