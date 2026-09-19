package ru.vldkr.shkaff.domain.labels

import kotlin.math.min

/** Калибровочная сетка: шахматка rows×cols клеток внутри заданной области. */
data class GridSpec(
    val cols: Int,
    val rows: Int,
    val cellMm: Double,
    val marginMm: Double = 0.0
) {
    val widthMm: Double get() = cols * cellMm
    val heightMm: Double get() = rows * cellMm

    companion object {
        // Сетка вписывается в область (ширина/высота минус поля) целым числом клеток.
        fun fromArea(widthMm: Double, heightMm: Double, cellMm: Double, marginMm: Double = 0.0): GridSpec {
            val w = (widthMm - 2 * marginMm).coerceAtLeast(cellMm)
            val h = (heightMm - 2 * marginMm).coerceAtLeast(cellMm)
            val cols = (w / cellMm).toInt().coerceAtLeast(1)
            val rows = (h / cellMm).toInt().coerceAtLeast(1)
            return GridSpec(cols, rows, cellMm, marginMm)
        }
    }
}

data class GridRegion(
    val minRow: Int,
    val maxRow: Int,
    val minCol: Int,
    val maxCol: Int
)

/** Прямоугольник в мм от левого верхнего угла этикетки. */
data class RectMm(
    val x: Double,
    val y: Double,
    val w: Double,
    val h: Double
)

/** План раскладки кода(ов) и текста в мм. */
data class LayoutPlan(
    val orientation: String,
    val qrSideMm: Double,
    val codeItem: RectMm,
    val codeGithub: RectMm?,
    val text: RectMm
)

object LabelGrid {

    const val MIN_QR_MM = 10.0
    const val MIN_FONT_PT = 6.0
    const val GITHUB_URL = "https://github.com/vladker/shkaff"
    private const val MIN_TEXT_BAND = 3.0
    private const val MIN_TEXT_WIDTH = 12.0

    fun cellIndex(spec: GridSpec, row: Int, col: Int) = row * spec.cols + col
    fun rowOf(spec: GridSpec, idx: Int) = idx / spec.cols
    fun colOf(spec: GridSpec, idx: Int) = idx % spec.cols

    fun regionOf(spec: GridSpec, cells: Set<Int>): GridRegion? {
        if (cells.isEmpty()) return null
        var minR = Int.MAX_VALUE
        var maxR = Int.MIN_VALUE
        var minC = Int.MAX_VALUE
        var maxC = Int.MIN_VALUE
        for (i in cells) {
            val r = rowOf(spec, i)
            val c = colOf(spec, i)
            if (r < minR) minR = r
            if (r > maxR) maxR = r
            if (c < minC) minC = c
            if (c > maxC) maxC = c
        }
        return GridRegion(minR, maxR, minC, maxC)
    }

    fun regionMm(spec: GridSpec, region: GridRegion): Pair<Double, Double> =
        ((region.maxCol - region.minCol + 1) * spec.cellMm) to
            ((region.maxRow - region.minRow + 1) * spec.cellMm)

    // Координата (x, y) левого верхнего угла области на листе, в мм (от края бумаги).
    fun regionOrigin(spec: GridSpec, region: GridRegion): Pair<Double, Double> =
        (spec.marginMm + region.minCol * spec.cellMm) to
            (spec.marginMm + region.minRow * spec.cellMm)

    /** Ориентация по форме: широкая область (w ≥ 1.4h) — горизонтальная, иначе вертикальная. */
    fun orientationFor(widthMm: Double, heightMm: Double): String =
        if (widthMm >= heightMm * 1.4) "h" else "v"

    fun resolveMode(mode: String, widthMm: Double, heightMm: Double): String =
        if (mode.equals("auto", ignoreCase = true)) orientationFor(widthMm, heightMm)
        else if (mode.equals("h", ignoreCase = true)) "h"
        else "v"

    /**
     * Раскладка кода и текста, «вписанная» в этикетку:
     * — квадратный код занимает сторону S (не меньше 10×10 мм, не больше области);
     * — «v»: код сверху (полная ширина, высота S), текст снизу;
     * — «h»: код слева (ширина S, полная высота), текст справа;
     * — два кода: по одному по краям, текст между ними.
     * Если у текста не остаётся минимальной полосы, S уменьшается (но не ниже 10 мм).
     */
    fun plan(
        widthMm: Double,
        heightMm: Double,
        marginMm: Double,
        mode: String,
        qrCount: Int,
        qrScale: Double
    ): LayoutPlan {
        val m = marginMm.coerceAtLeast(0.0)
        val iw = (widthMm - 2 * m).coerceAtLeast(1.0)
        val ih = (heightMm - 2 * m).coerceAtLeast(1.0)
        val orient = resolveMode(mode, widthMm, heightMm)
        val two = qrCount >= 2
        // Зафиксированный зазор код↔текст 2 мм (по требованию — не процент от области).
        val gap = 2.0
        val minText = if (orient == "v") MIN_TEXT_BAND else MIN_TEXT_WIDTH

        // Максимальная сторона кода с учётом раскладки (не меньше нуля).
        val cap = when {
            orient == "v" && two -> minOf(ih, (iw - gap) / 2)
            orient == "h" && two -> minOf(ih, (iw - 2 * gap - minText) / 2)
            else -> minOf(iw, ih)
        }.coerceAtLeast(0.0)
        // База — 10×10 мм, больше — до размера области (qrScale = доля от максимума).
        var side = (cap * qrScale).coerceIn(MIN_QR_MM, cap.coerceAtLeast(MIN_QR_MM))

        // Обеспечиваем полосу под текст (одна строка 6pt ≈ 3 мм / 12 мм в ширину).
        val textBand = if (orient == "v") ih - side - gap else iw - side - gap
        if (textBand < minText) {
            side = maxOf(MIN_QR_MM, if (orient == "v") ih - gap - minText else iw - gap - minText)
            side = side.coerceAtMost(cap.coerceAtLeast(MIN_QR_MM))
        }

        val codeItem: RectMm
        val codeGithub: RectMm?
        val text: RectMm
        if (orient == "v") {
            val bandH = (ih - side - gap).coerceAtLeast(0.0)
            if (two) {
                val total = 2 * side + gap
                val x0 = m + (iw - total) / 2
                codeItem = RectMm(x0, m, side, side)
                codeGithub = RectMm(x0 + side + gap, m, side, side)
            } else {
                codeItem = RectMm(m, m, iw, side)
                codeGithub = null
            }
            text = RectMm(m, m + side + gap, iw, bandH)
        } else {
            if (two) {
                codeItem = RectMm(m, m, side, ih)
                codeGithub = RectMm(m + iw - side, m, side, ih)
                val tw = (iw - 2 * side - 2 * gap).coerceAtLeast(0.0)
                text = RectMm(m + side + gap, m, tw, ih)
            } else {
                codeItem = RectMm(m, m, side, ih)
                codeGithub = null
                text = RectMm(m + side + gap, m, (iw - side - gap).coerceAtLeast(0.0), ih)
            }
        }
        // Страховка: на вырожденных (очень узких/низких) областях прямоугольники
        // не должны вылезать за края этикетки.
        fun fit(r: RectMm): RectMm {
            val x = r.x.coerceIn(0.0, widthMm)
            val y = r.y.coerceIn(0.0, heightMm)
            val ww = r.w.coerceIn(0.0, (widthMm - x).coerceAtLeast(0.0))
            val hh = r.h.coerceIn(0.0, (heightMm - y).coerceAtLeast(0.0))
            return RectMm(x, y, ww, hh)
        }
        return LayoutPlan(orient, side, fit(codeItem), codeGithub?.let { fit(it) }, fit(text))
    }
}
