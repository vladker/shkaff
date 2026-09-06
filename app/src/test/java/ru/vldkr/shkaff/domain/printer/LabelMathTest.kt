package ru.vldkr.shkaff.domain.printer

import org.junit.Assert.assertEquals
import org.junit.Test

class LabelMathTest {

    @Test
    fun pxAt203dpi() {
        assertEquals(464, LabelMath.px(58.0))
        assertEquals(320, LabelMath.px(40.0))
        assertEquals(368, LabelMath.px(46.0))
    }

    @Test
    fun pxAt300dpi() {
        assertEquals(591, LabelMath.px(50.0, 300))
    }

    @Test
    fun mmRoundTrip() {
        assertEquals(58.0, LabelMath.mm(464), 0.01)
        assertEquals(40.0, LabelMath.mm(320), 0.01)
    }

    @Test
    fun sizePx() {
        assertEquals(Pair(464, 320), LabelMath.sizePx(58.0, 40.0))
    }
}
