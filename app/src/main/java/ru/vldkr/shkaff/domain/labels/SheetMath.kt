package ru.vldkr.shkaff.domain.labels

import ru.vldkr.shkaff.domain.printer.LabelMath
import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToLong

// Геометрия листа этикеток: привязка к сетке 5 мм, мм<->px (через LabelMath, 203 dpi),
// проверка/приведение слота к границам бумаги и авто-раскладка сеткой.
// Чистые значения (без ссылок на сущности БД) — как LabelGrid.
object SheetMath {

    const val SNAP_MM = 5.0

    /** Привязка координаты/размера к сетке 5 мм: Math.round(v/5)*5. */
    fun snap(mm: Double): Double = (mm / SNAP_MM).roundToLong() * SNAP_MM

    // Мм -> px (203 dpi = 8 точек/мм).
    fun px(mm: Double): Int = LabelMath.px(mm)

    fun sizePx(wMm: Double, hMm: Double): Pair<Int, Int> = LabelMath.sizePx(wMm, hMm)

    // px -> мм.
    fun pxToMm(px: Int): Double = LabelMath.mm(px)

    fun rect(x: Double, y: Double, w: Double, h: Double): RectMm = RectMm(x, y, w, h)

    /** Влезает ли слот в бумагу с учётом полей. */
    fun withinPaper(r: RectMm, paperW: Double, paperH: Double, margin: Double = 0.0): Boolean {
        val x0 = margin
        val y0 = margin
        val x1 = paperW - margin
        val y1 = paperH - margin
        return r.x >= x0 && r.y >= y0 && (r.x + r.w) <= x1 && (r.y + r.h) <= y1
    }

    /** Приводит слот внутрь бумаги (с полями): не растягивает, только сдвигает.
     *  Если слот больше доступной области — ставим в поле (не выталкиваем за бумагу). */
    fun clampToPaper(r: RectMm, paperW: Double, paperH: Double, margin: Double = 0.0): RectMm {
        val maxX = (paperW - margin) - r.w
        val maxY = (paperH - margin) - r.h
        val x = r.x.coerceIn(margin, max(margin, maxX))
        val y = r.y.coerceIn(margin, max(margin, maxY))
        return RectMm(x, y, r.w, r.h)
    }

    // Авто-раскладка: сетка слотов labelW×labelH с зазором gap, вписанная в бумагу (с полями).
    // Возвращает позиции (x, y) в порядке заполнения слева-направо, сверху-вниз.
    fun gridSlots(
        paperW: Double,
        paperH: Double,
        labelW: Double,
        labelH: Double,
        margin: Double = 0.0,
        gap: Double = 0.0
    ): List<RectMm> {
        if (labelW <= 0.0 || labelH <= 0.0) return emptyList()
        val availW = (paperW - 2 * margin).coerceAtLeast(0.0)
        val availH = (paperH - 2 * margin).coerceAtLeast(0.0)
        if (availW < labelW || availH < labelH) return emptyList()
        val cols = ((availW + gap) / (labelW + gap)).toInt().coerceAtLeast(1)
        val rows = ((availH + gap) / (labelH + gap)).toInt().coerceAtLeast(1)
        val result = ArrayList<RectMm>(cols * rows)
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                val x = margin + col * (labelW + gap)
                val y = margin + row * (labelH + gap)
                result += RectMm(snap(x), snap(y), labelW, labelH)
            }
        }
        return result
    }
}
