package ru.vldkr.shkaff.features.labelstudio

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc
import ru.vldkr.shkaff.features.labelstudio.domain.LabelElement
import ru.vldkr.shkaff.features.labelstudio.domain.LabelRenderer
import ru.vldkr.shkaff.features.labelstudio.domain.boundsMm
import kotlin.math.roundToInt

private enum class DragMode {
    None, Move,
    ResizeTL, ResizeT, ResizeTR, ResizeR, ResizeBR, ResizeB, ResizeBL, ResizeL
}

/**
 * WYSIWYG-холст: рисует превью через LabelRenderer.render (тот же рендер, что и печать),
 * поверх — рамка страницы, печатная область, выделение и 8 ручек ресайза.
 * Зум — кнопками (pinch — в polish). Координаты везде в мм.
 */
@Composable
fun WysiwygCanvas(
    doc: LabelDoc,
    bindings: Map<String, String>,
    selectedId: String?,
    zoom: Float,
    onSelect: (String?) -> Unit,
    onMove: (Float, Float) -> Unit,
    onResize: (String, Float, Float, Float, Float) -> Unit
) {
    val page = doc.page
    val labelHeight = if (page.labelHeightMm > 0f) page.labelHeightMm else
        (doc.elements.maxOfOrNull { it.yMm + it.heightMm } ?: page.marginTopMm) + page.marginBottomMm

    val preview = remember(doc, bindings) {
        LabelRenderer.render(doc, bindings, dpi = 203)
    }

    var canvasW by remember { mutableStateOf(0) }
    val scale = if (canvasW == 0) 1f else canvasW / page.printableWidthMm * zoom

    val selected = doc.elements.find { it.id == selectedId }
    val accent = MaterialTheme.colorScheme.primary

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(page.printableWidthMm / labelHeight)
            .onSizeChanged { canvasW = it.width }
            .pointerInput(doc, selectedId, scale) {
                detectTapGestures { offset ->
                    val mm = Offset(offset.x / scale, offset.y / scale)
                    val el = doc.elements
                        .sortedByDescending { it.zIndex }
                        .firstOrNull { it.boundsMm().contains(mm) }
                    onSelect(el?.id)
                }
            }
            .pointerInput(doc, selectedId, scale) {
                var mode = DragMode.None
                detectDragGestures(
                    onDragStart = { offset ->
                        val mm = Offset(offset.x / scale, offset.y / scale)
                        val sel = selected
                        mode = if (sel != null) {
                            handleAt(sel, mm, scale)
                                ?: if (sel.boundsMm().contains(mm)) DragMode.Move else DragMode.None
                        } else DragMode.None
                    },
                    onDrag = { change, dragAmount ->
                        change.consume()
                        val dx = dragAmount.x / scale
                        val dy = dragAmount.y / scale
                        val sel = selected
                        when (mode) {
                            DragMode.Move -> onMove(dx, dy)
                            DragMode.ResizeTL, DragMode.ResizeT, DragMode.ResizeTR,
                            DragMode.ResizeR, DragMode.ResizeBR, DragMode.ResizeB,
                            DragMode.ResizeBL, DragMode.ResizeL -> {
                                if (sel != null) {
                                    val b = resizeBounds(sel, mode, dx, dy)
                                    if (b != null) onResize(sel.id, b.x, b.y, b.w, b.h)
                                }
                            }
                            DragMode.None -> {}
                        }
                    }
                )
            }
    ) {
        val dstW = page.printableWidthMm * scale
        val dstH = labelHeight * scale
        drawImage(
            preview.asImageBitmap(),
            dstOffset = IntOffset(0, 0),
            dstSize = IntSize(dstW.roundToInt(), dstH.roundToInt())
        )

        // Рамка страницы (пунктир) и печатная область (сплошная).
        drawRect(
            color = Color.Gray,
            style = androidx.compose.ui.graphics.drawscope.Stroke(
                width = 1.dp.toPx(),
                pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 8f))
            )
        )
        drawRect(
            color = Color.Black,
            style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx())
        )

        if (selected != null) {
            val r = selected.boundsMm()
            val left = r.left * scale
            val top = r.top * scale
            val right = r.right * scale
            val bottom = r.bottom * scale
            drawRect(
                color = accent,
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 2.dp.toPx()),
                topLeft = Offset(left, top),
                size = Size(right - left, bottom - top)
            )
            val hs = 8.dp.toPx()
            for (h in handlePositions(selected, scale)) {
                drawRect(
                    color = Color.White,
                    topLeft = Offset(h.x - hs / 2f, h.y - hs / 2f),
                    size = Size(hs, hs)
                )
                drawRect(
                    color = accent,
                    style = androidx.compose.ui.graphics.drawscope.Stroke(width = 1.dp.toPx()),
                    topLeft = Offset(h.x - hs / 2f, h.y - hs / 2f),
                    size = Size(hs, hs)
                )
            }
        }
    }
}

private fun handlePositions(el: LabelElement, scale: Float): List<Offset> {
    val r = el.boundsMm()
    val cx = r.center.x
    val cy = r.center.y
    return listOf(
        Offset(r.left, r.top), Offset(cx, r.top), Offset(r.right, r.top),
        Offset(r.right, cy), Offset(r.right, r.bottom), Offset(cx, r.bottom),
        Offset(r.left, r.bottom), Offset(r.left, cy)
    ).map { Offset(it.x * scale, it.y * scale) }
}

private fun handleAt(el: LabelElement, mm: Offset, scale: Float): DragMode? {
    val r = el.boundsMm()
    val cx = r.center.x
    val cy = r.center.y
    val rad = 24f / scale
    fun near(p: Offset) = (p - mm).getDistance() <= rad
    return when {
        near(Offset(r.left, r.top)) -> DragMode.ResizeTL
        near(Offset(cx, r.top)) -> DragMode.ResizeT
        near(Offset(r.right, r.top)) -> DragMode.ResizeTR
        near(Offset(r.right, cy)) -> DragMode.ResizeR
        near(Offset(r.right, r.bottom)) -> DragMode.ResizeBR
        near(Offset(cx, r.bottom)) -> DragMode.ResizeB
        near(Offset(r.left, r.bottom)) -> DragMode.ResizeBL
        near(Offset(r.left, cy)) -> DragMode.ResizeL
        else -> null
    }
}

private data class Bounds(val x: Float, val y: Float, val w: Float, val h: Float)

private fun resizeBounds(el: LabelElement, mode: DragMode, dx: Float, dy: Float): Bounds? {
    val r = el.boundsMm()
    var x = r.left
    var y = r.top
    var w = r.width
    var h = r.height
    when (mode) {
        DragMode.ResizeTL -> { x += dx; w -= dx; y += dy; h -= dy }
        DragMode.ResizeT -> { y += dy; h -= dy }
        DragMode.ResizeTR -> { w += dx; y += dy; h -= dy }
        DragMode.ResizeR -> { w += dx }
        DragMode.ResizeBR -> { w += dx; h += dy }
        DragMode.ResizeB -> { h += dy }
        DragMode.ResizeBL -> { x += dx; w -= dx; h += dy }
        DragMode.ResizeL -> { x += dx; w -= dx }
        else -> return null
    }
    val minW = 2f
    val minH = 2f
    if (w < minW) w = minW
    if (h < minH) h = minH
    return Bounds(x, y, w, h)
}