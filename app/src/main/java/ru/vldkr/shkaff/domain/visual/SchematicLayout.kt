package ru.vldkr.shkaff.domain.visual

import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.math.sqrt

// Прямоугольник в нормализованных координатах 0..1 (без зависимостей от Android).
data class NormRect(
    val left: Float,
    val top: Float,
    val right: Float,
    val bottom: Float
) {
    val width: Float get() = right - left
    val height: Float get() = bottom - top

    fun contains(x: Float, y: Float): Boolean = x >= left && x <= right && y >= top && y <= bottom
}

data class SchematicBlock(
    val label: String,
    val locationId: String?,
    val rect: NormRect
)

// US-C2: раскладка хранилища стандартными блоками — сетка ящиков в нормализованных
// координатах. Один и тот же layout используется для «схемы», которую можно размечать
// аннотациями, и для кликабельной визуализации в карточке хранилища.
object SchematicLayout {

    fun layout(items: List<Pair<String?, String>>, maxCols: Int = 4): List<SchematicBlock> {
        if (items.isEmpty()) return emptyList()
        val n = items.size
        val cols = (ceil(sqrt(n.toDouble())).roundToInt()).coerceIn(1, maxCols)
        val rows = ceil(n / cols.toDouble()).roundToInt()
        val cw = 1f / cols
        val ch = 1f / rows
        val m = 0.035f // отступ от границы и между блоками (доля стороны)

        return items.mapIndexed { i, (id, label) ->
            val col = i % cols
            val row = i / cols
            SchematicBlock(
                label = label.ifBlank { "Ящик" },
                locationId = id,
                rect = NormRect(
                    left = col * cw + m,
                    top = row * ch + m,
                    right = (col + 1) * cw - m,
                    bottom = (row + 1) * ch - m
                )
            )
        }
    }
}