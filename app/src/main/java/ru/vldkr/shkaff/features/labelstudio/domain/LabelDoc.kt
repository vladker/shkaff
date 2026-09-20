package ru.vldkr.shkaff.features.labelstudio.domain

import androidx.compose.ui.geometry.Rect
import ru.vldkr.shkaff.util.newId

/**
 * WYSIWYG-документ этикетки (LabelStudio): один документ = одна этикетка.
 * Не «шаблон» и не «зона»: полный макет с размерами бумаги, печатной областью
 * и элементами (QR, штрихкод, текст, поле, картинка, фигуры).
 */
data class LabelDoc(
    val id: String = newId(),
    val name: String = "Новая этикетка",
    val page: PageSettings = PageSettings(),
    val elements: List<LabelElement> = emptyList(),
    val updatedAt: Long = System.currentTimeMillis()
)

/**
 * Параметры страницы/печати. labelHeightMm = 0 — автовысота (по содержимому).
 * printableWidthMm отдельно от paperWidthMm: ESC/POS 58 мм часто печатает 48 мм (384 px @203 dpi).
 */
data class PageSettings(
    val paperWidthMm: Float = 58f,
    val printableWidthMm: Float = 48f,
    val labelHeightMm: Float = 0f,
    val minHeightMm: Float = 10f,
    val maxHeightMm: Float = 200f,
    val gapMm: Float = 2.5f,
    val marginTopMm: Float = 2f,
    val marginBottomMm: Float = 2f,
    val marginLeftMm: Float = 0f,
    val marginRightMm: Float = 0f,
    val invert: Boolean = false,
    val darkness: Int = 8,
    val feedLines: Int = 3
)

sealed interface LabelElement {
    val id: String
    val xMm: Float
    val yMm: Float
    val widthMm: Float
    val heightMm: Float
    val rotationDeg: Int
    val zIndex: Int
    val locked: Boolean
}

data class QrElement(
    override val id: String = newId(),
    override val xMm: Float = 4f,
    override val yMm: Float = 4f,
    override val widthMm: Float = 20f,
    override val heightMm: Float = 20f,
    override val rotationDeg: Int = 0,
    override val zIndex: Int = 0,
    override val locked: Boolean = false,
    val content: ContentSource = ContentSource.Field("code"),
    val ecLevel: String = "M",
    val quietZoneModules: Int = 4,
    val scale: Float = 1f
) : LabelElement

data class BarcodeElement(
    override val id: String = newId(),
    override val xMm: Float = 4f,
    override val yMm: Float = 4f,
    override val widthMm: Float = 40f,
    override val heightMm: Float = 10f,
    override val rotationDeg: Int = 0,
    override val zIndex: Int = 0,
    override val locked: Boolean = false,
    val content: ContentSource = ContentSource.Field("code"),
    val symbology: String = "CODE128",
    val showText: Boolean = true
) : LabelElement

data class TextElement(
    override val id: String = newId(),
    override val xMm: Float = 4f,
    override val yMm: Float = 26f,
    override val widthMm: Float = 40f,
    override val heightMm: Float = 8f,
    override val rotationDeg: Int = 0,
    override val zIndex: Int = 1,
    override val locked: Boolean = false,
    val content: ContentSource = ContentSource.Field("name"),
    val fontName: String = "sans",
    val sizeMm: Float = 3.5f,
    val bold: Boolean = false,
    val align: TextAlign = TextAlign.LEFT,
    val verticalAlign: VAlign = VAlign.TOP,
    val lineHeight: Float = 1.2f,
    val maxLines: Int = 3,
    val background: Boolean = false
) : LabelElement

data class FieldElement(
    override val id: String = newId(),
    override val xMm: Float = 4f,
    override val yMm: Float = 34f,
    override val widthMm: Float = 40f,
    override val heightMm: Float = 5f,
    override val rotationDeg: Int = 0,
    override val zIndex: Int = 2,
    override val locked: Boolean = false,
    val key: String = "code",
    val label: String = "Код:",
    val fallback: String = "",
    val sizeMm: Float = 2.5f,
    val showLabel: Boolean = true
) : LabelElement

data class ImageElement(
    override val id: String = newId(),
    override val xMm: Float = 4f,
    override val yMm: Float = 4f,
    override val widthMm: Float = 15f,
    override val heightMm: Float = 15f,
    override val rotationDeg: Int = 0,
    override val zIndex: Int = 3,
    override val locked: Boolean = false,
    val path: String = "",
    val scaleMode: ScaleMode = ScaleMode.FIT,
    val dither: Boolean = true,
    val threshold: Int = 128
) : LabelElement

data class ShapeElement(
    override val id: String = newId(),
    override val xMm: Float = 4f,
    override val yMm: Float = 4f,
    override val widthMm: Float = 40f,
    override val heightMm: Float = 0.5f,
    override val rotationDeg: Int = 0,
    override val zIndex: Int = -1,
    override val locked: Boolean = false,
    val shape: ShapeType = ShapeType.LINE,
    val strokeMm: Float = 0.3f,
    val filled: Boolean = false
) : LabelElement

/** Источник содержимого элемента: статичный текст, поле объекта или шаблон строки. */
sealed interface ContentSource {
    data class Static(val value: String) : ContentSource
    data class Field(val key: String, val fallback: String = "") : ContentSource
    data class Template(val pattern: String) : ContentSource
}

enum class TextAlign { LEFT, CENTER, RIGHT }
enum class VAlign { TOP, CENTER, BOTTOM }
enum class ScaleMode { FIT, FILL, STRETCH }
enum class ShapeType { LINE, RECT, ELLIPSE }

enum class PaletteType {
    QR, BARCODE, TEXT, FIELD, IMAGE, LINE, RECT
}

fun LabelElement.withPosition(x: Float, y: Float): LabelElement = when (this) {
    is QrElement -> copy(xMm = x, yMm = y)
    is BarcodeElement -> copy(xMm = x, yMm = y)
    is TextElement -> copy(xMm = x, yMm = y)
    is FieldElement -> copy(xMm = x, yMm = y)
    is ImageElement -> copy(xMm = x, yMm = y)
    is ShapeElement -> copy(xMm = x, yMm = y)
}

fun LabelElement.withSize(w: Float, h: Float): LabelElement = when (this) {
    is QrElement -> copy(widthMm = w, heightMm = h)
    is BarcodeElement -> copy(widthMm = w, heightMm = h)
    is TextElement -> copy(widthMm = w, heightMm = h)
    is FieldElement -> copy(widthMm = w, heightMm = h)
    is ImageElement -> copy(widthMm = w, heightMm = h)
    is ShapeElement -> copy(widthMm = w, heightMm = h)
}

fun LabelElement.boundsMm(): Rect = Rect(xMm, yMm, xMm + widthMm, yMm + heightMm)