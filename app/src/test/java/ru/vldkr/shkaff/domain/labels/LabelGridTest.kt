package ru.vldkr.shkaff.domain.labels

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class LabelGridTest {

    private val spec = GridSpec.fromArea(58.0, 40.0, 5.0, 2.0)

    @Test
    fun fromArea_fits_integer_cells_into_area() {
        assertEquals(10, spec.cols)
        assertEquals(7, spec.rows)
        assertEquals(50.0, spec.widthMm, 0.0001)
        assertEquals(35.0, spec.heightMm, 0.0001)
        // 59×41 с полями 2 мм: (55/5)=11, (37/5)=7
        val s2 = GridSpec.fromArea(59.0, 41.0, 5.0, 2.0)
        assertEquals(11, s2.cols)
        assertEquals(7, s2.rows)
    }

    @Test
    fun region_of_full_and_corner() {
        val full = (0 until (spec.rows * spec.cols)).toSet()
        assertEquals(GridRegion(0, spec.rows - 1, 0, spec.cols - 1), LabelGrid.regionOf(spec, full))
        val one = setOf(LabelGrid.cellIndex(spec, 2, 3))
        assertEquals(GridRegion(2, 2, 3, 3), LabelGrid.regionOf(spec, one))
        assertNull(LabelGrid.regionOf(spec, emptySet()))
    }

    @Test
    fun region_mm_uses_cell_size() {
        val region = GridRegion(0, 0, 0, 4) // 5 клеток по ширине, 1 по высоте
        val (w, h) = LabelGrid.regionMm(spec, region)
        assertEquals(5 * spec.cellMm, w, 0.0001)
        assertEquals(1 * spec.cellMm, h, 0.0001)
    }

    @Test
    fun region_origin_uses_margin_and_cell_index() {
        val region = GridRegion(2, 3, 3, 4) // строки 2-3, колонки 3-4
        val (x, y) = LabelGrid.regionOrigin(spec, region)
        assertEquals(spec.marginMm + 3 * spec.cellMm, x, 0.0001)
        assertEquals(spec.marginMm + 2 * spec.cellMm, y, 0.0001)
    }

    @Test
    fun region_origin_from_cell_indices() {
        val idx = LabelGrid.cellIndex(spec, 1, 2)
        val r = LabelGrid.regionOf(spec, setOf(idx))
        val (x, y) = LabelGrid.regionOrigin(spec, r!!)
        assertEquals(spec.marginMm + 2 * spec.cellMm, x, 0.0001)
        assertEquals(spec.marginMm + 1 * spec.cellMm, y, 0.0001)
    }

    @Test
    fun orientation_by_shape() {
        assertEquals("h", LabelGrid.orientationFor(40.0, 25.0))
        assertEquals("v", LabelGrid.orientationFor(25.0, 40.0))
        assertEquals("v", LabelGrid.orientationFor(20.0, 20.0))
        assertEquals("v", LabelGrid.resolveMode("auto", 20.0, 30.0))
        assertEquals("h", LabelGrid.resolveMode("auto", 40.0, 25.0))
        assertEquals("h", LabelGrid.resolveMode("H", 10.0, 10.0))
        assertEquals("v", LabelGrid.resolveMode("v", 40.0, 25.0))
    }

    @Test
    fun plan_vertical_one_code_fills_area() {
        val p = LabelGrid.plan(40.0, 25.0, 1.0, "v", 1, 1.0)
        assertEquals("v", p.orientation)
        assertTrue(p.qrSideMm >= LabelGrid.MIN_QR_MM)
        // Код сверху: полная ширина, высота = сторона.
        assertEquals(38.0, p.codeItem.w, 0.0001)
        assertEquals(1.0, p.codeItem.y, 0.0001)
        assertEquals(p.qrSideMm, p.codeItem.h, 0.0001)
        assertNull(p.codeGithub)
        // Текст снизу, остаётся полоса не меньше одной строки.
        assertTrue(p.text.h >= 2.5)
        assertEquals(38.0, p.text.w, 0.0001)
        assertTrue(p.text.y > p.codeItem.y + p.codeItem.h)
    }

    @Test
    fun plan_horizontal_one_code_code_on_side() {
        val p = LabelGrid.plan(40.0, 25.0, 1.0, "h", 1, 1.0)
        assertEquals("h", p.orientation)
        assertEquals(23.0, p.codeItem.h, 0.0001) // полная высота области
        assertEquals(1.0, p.codeItem.x, 0.0001)
        assertNull(p.codeGithub)
        assertTrue(p.text.w >= 10.0)
        assertEquals(23.0, p.text.h, 0.0001)
        assertTrue(p.text.x > p.codeItem.x + p.codeItem.w)
    }

    @Test
    fun plan_two_codes_text_between() {
        val p = LabelGrid.plan(50.0, 20.0, 1.0, "h", 2, 1.0)
        assertNotNull(p.codeGithub)
        // Коды по краям, текст между ними.
        assertEquals(1.0, p.codeItem.x, 0.0001)
        assertEquals(49.0, p.codeGithub!!.x + p.codeGithub!!.w, 0.0001)
        assertTrue(p.text.x > p.codeItem.x + p.codeItem.w)
        assertTrue(p.text.x + p.text.w < p.codeGithub!!.x)
        assertTrue(p.text.w >= 11.0)
    }

    @Test
    fun plan_tiny_area_respects_min_qr_size() {
        val p = LabelGrid.plan(15.0, 12.0, 0.0, "v", 1, 1.0)
        assertEquals(LabelGrid.MIN_QR_MM, p.qrSideMm, 0.0001)
    }

    @Test
    fun plan_qr_scale_shrinks_code_keeps_text_band() {
        val full = LabelGrid.plan(30.0, 30.0, 1.0, "v", 1, 1.0)
        val half = LabelGrid.plan(30.0, 30.0, 1.0, "v", 1, 0.5)
        assertTrue(half.qrSideMm < full.qrSideMm)
        assertTrue(half.text.h > full.text.h)
        // В обоих случаях остаётся место под текст.
        assertTrue(full.text.h > 0)
        assertTrue(half.text.h > 0)
    }

    @Test
    fun plan_never_exceeds_area() {
        for (w in listOf(15.0, 30.0, 58.0)) {
            for (h in listOf(12.0, 25.0, 80.0)) {
                for (mode in listOf("v", "h", "auto")) {
                    for (n in listOf(1, 2)) {
                        val p = LabelGrid.plan(w, h, 1.0, mode, n, 1.0)
                        assertTrue(p.codeItem.x >= 0 && p.codeItem.x + p.codeItem.w <= w + 0.0001)
                        assertTrue(p.codeItem.y >= 0 && p.codeItem.y + p.codeItem.h <= h + 0.0001)
                        p.codeGithub?.let {
                            assertTrue(it.x >= 0 && it.x + it.w <= w + 0.0001)
                            assertTrue(it.y >= 0 && it.y + it.h <= h + 0.0001)
                        }
                        assertTrue(p.text.x >= 0 && p.text.x + p.text.w <= w + 0.0001)
                        assertTrue(p.text.y >= 0 && p.text.y + p.text.h <= h + 0.0001)
                        if (n == 1) assertTrue(p.qrSideMm >= LabelGrid.MIN_QR_MM - 0.0001)
                    }
                }
            }
        }
    }
}
