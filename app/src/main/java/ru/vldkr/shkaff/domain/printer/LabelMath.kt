package ru.vldkr.shkaff.domain.printer

import kotlin.math.roundToInt

// Мм <-> пиксели для термопечати. 203 dpi = 8 точек/мм: 58 мм = 464 px, 40 мм = 320 px.
object LabelMath {

    const val DPI = 203

    fun px(widthMm: Double, dpi: Int = DPI): Int =
        if (dpi == DPI) (widthMm * 8.0).roundToInt() else (widthMm * dpi / 25.4).roundToInt()

    fun sizePx(widthMm: Double, heightMm: Double, dpi: Int = DPI): Pair<Int, Int> =
        px(widthMm, dpi) to px(heightMm, dpi)

    fun mm(widthPx: Int, dpi: Int = DPI): Double =
        if (dpi == DPI) widthPx / 8.0 else widthPx * 25.4 / dpi
}
