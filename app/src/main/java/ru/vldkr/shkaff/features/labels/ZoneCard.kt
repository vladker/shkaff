package ru.vldkr.shkaff.features.labels

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color as UiColor
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import java.io.File
import ru.vldkr.shkaff.domain.labels.GridSpec
import ru.vldkr.shkaff.domain.labels.LabelGrid
import ru.vldkr.shkaff.util.PhotoCapture

/**
 * Карточка калибровки зон (шаг «Этикетка»):
 * 1) напечатать шаблон-шахматку, 2) отметить клетки, где печать плотная,
 * 3) «Сохранить зоны» — для каждой зоны появится шаблон с её размером
 *    и позицией (offset_x/y) на листе.
 */
@Composable
fun ZoneSetupCard(
    vm: LabelsVm,
    ui: LabelsVm.Ui,
    onShoot: () -> Unit,
    onPick: () -> Unit
) {
    val spec = vm.spec
    val preview = remember(spec) { LabelGenerator.renderGrid(spec, dpi = 50) }
    val region = LabelGrid.regionOf(spec, ui.selected)
    Card(Modifier.fillMaxWidth()) {
        Column(
            Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text("Зоны (калибровка под принтер)", style = MaterialTheme.typography.titleSmall)
            Text(
                "1) Напечатайте шаблон-шахматку под свой принтер. " +
                    "2) Проведите пальцем по диагонали — выделится прямоугольная зона, где печать плотная (тап — одна клетка). " +
                    "3) «Сохранить зоны» — для каждой появится шаблон с её размером и позицией на листе; " +
                    "на шаге «Раскладка» выбирайте зону, в которой печатаете.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = ui.gridCell,
                    onValueChange = vm::setGridCell,
                    label = { Text("Клетка, мм") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = ui.gridMargin,
                    onValueChange = vm::setGridMargin,
                    label = { Text("Поля сетки, мм") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            Text(
                "Сетка: ${spec.cols}×${spec.rows} клеток = ${spec.widthMm.toInt()}×${spec.heightMm.toInt()} мм " +
                    "(в пределах ${ui.sizeW.ifBlank { "58" }}×${ui.sizeH.ifBlank { "40" }} мм, поля сетки ${spec.marginMm.toInt()} мм)",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Image(
                preview.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp),
                contentScale = ContentScale.Fit
            )
            if (ui.profiles.isEmpty()) {
                Text(
                    "Профилей принтеров нет — создайте в разделе «Принтеры».",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            } else {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ui.profiles.forEach { p ->
                        FilterChip(
                            selected = p.id == ui.gridPrinterId,
                            onClick = { vm.selectGridPrinter(p.id) },
                            label = { Text(p.name) }
                        )
                    }
                }
                Button(
                    onClick = { vm.printGrid() },
                    enabled = !ui.busy,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Напечатать шаблон-шахматку") }
                OutlinedButton(
                    onClick = { vm.printBlankStrip(5) },
                    enabled = !ui.busy,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Протащить ленту на 5 мм (пустая полоска)") }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Text(
                    "Проведите пальцем от угла к углу — между ними выделится прямоугольная зона. Тап — одна клетка:",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                CheckerboardGrid(spec, ui.selected, ui.zones.map { it.cells }, vm::toggleCell, vm::selectRect)
            }
            region?.let { r ->
                val (w, h) = LabelGrid.regionMm(spec, r)
                Text(
                    "Рабочий выбор: ${w.toInt()}×${h.toInt()} мм (${ui.selected.size} кл.)",
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = { vm.markAll() }, modifier = Modifier.weight(1f)) {
                    Text("Все")
                }
                OutlinedButton(onClick = { vm.clearSelection() }, modifier = Modifier.weight(1f)) {
                    Text("Сброс")
                }
                Button(
                    onClick = { vm.saveZone() },
                    enabled = ui.selected.isNotEmpty(),
                    modifier = Modifier.weight(2f)
                ) {
                    Text("Сохранить зону")
                }
            }
            if (ui.zones.isNotEmpty()) {
                Text("Сохранённые зоны:", style = MaterialTheme.typography.bodyMedium)
                ui.zones.forEachIndexed { i, z ->
                    val zr = LabelGrid.regionOf(spec, z.cells)
                    val zw = zr?.let { LabelGrid.regionMm(spec, it).first } ?: 0.0
                    val zh = zr?.let { LabelGrid.regionMm(spec, it).second } ?: 0.0
                    Card(Modifier.fillMaxWidth()) {
                        Row(
                            Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.size(16.dp).background(zoneColor(i)))
                            Spacer(Modifier.width(8.dp))
                            Column(Modifier.weight(1f)) {
                                Text(z.name, style = MaterialTheme.typography.titleSmall)
                                Text(
                                    "${zw.toInt()}×${zh.toInt()} мм · ${z.cells.size} кл.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            OutlinedButton(onClick = { vm.loadZone(i) }) { Text("Открыть") }
                            IconButton(onClick = { vm.removeZone(i) }) {
                                Icon(Icons.Filled.Delete, contentDescription = "Удалить зону")
                            }
                        }
                    }
                }
                Button(
                    onClick = { vm.saveZones() },
                    enabled = !ui.busy,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Сохранить зоны как шаблоны") }
            }
            Text(
                "Фото напечатанного (для сравнения):",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = onShoot, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.PhotoCamera, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Камера")
                }
                OutlinedButton(onClick = onPick, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Filled.PhotoLibrary, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Галерея")
                }
            }
            ui.gridPhoto?.let { file ->
                FileImage(file, Modifier.fillMaxWidth())
            }
        }
    }
}

/**
 * Интерактивная шахматка (Canvas + жесты):
 * - тащ пальцем от угла к углу — между ними формируется прямоугольная зона (живой предпросмотр);
 * - тап — переключает одну клетку (точная доводка);
 * - клетки сохранённых зон — цвет своей зоны (полупрозрачный);
 * - рабочий выбор — цвет будущей (следующей) зоны;
 * - свободные клетки — нейтральная «застенка».
 */
@Composable
private fun CheckerboardGrid(
    spec: GridSpec,
    selected: Set<Int>,
    zones: List<Set<Int>>,
    onCell: (Int) -> Unit,
    onRect: (Int, Int) -> Unit
) {
    val cell = (spec.cellMm * 1.5).dp.coerceIn(14.dp, 36.dp)
    val cellPx = with(LocalDensity.current) { cell.toPx() }
    val scheme = MaterialTheme.colorScheme
    val neutral = scheme.outlineVariant.copy(alpha = 0.5f)
    val nextColor = zoneColor(zones.size)
    // Палитра считана в composable-области: draw-лямбда Canvas не может вызывать @Composable.
    val palette = listOf(
        scheme.primary,
        scheme.tertiary,
        scheme.secondary,
        scheme.error
    )

    fun cellAt(p: Offset): Int {
        val c = (p.x / cellPx).toInt().coerceIn(0, spec.cols - 1)
        val r = (p.y / cellPx).toInt().coerceIn(0, spec.rows - 1)
        return r * spec.cols + c
    }

    Canvas(
        modifier = Modifier
            .size(cell * spec.cols, cell * spec.rows)
            .pointerInput(spec) {
                awaitEachGesture {
                    val down = awaitFirstDown()
                    down.consume()
                    val a = cellAt(down.position)
                    var moved = false
                    while (true) {
                        val ev = awaitPointerEvent()
                        val ch = ev.changes.firstOrNull() ?: break
                        if (ev.type == PointerEventType.Move) {
                            moved = true
                            ch.consume()
                            onRect(a, cellAt(ch.position))
                        } else {
                            break // Up / Cancel
                        }
                    }
                    if (!moved) onCell(a) // тап — переключить одну клетку
                }
            }
    ) {
        for (r in 0 until spec.rows) {
            for (c in 0 until spec.cols) {
                val idx = LabelGrid.cellIndex(spec, r, c)
                val zoneIdx = zones.indexOfFirst { idx in it }
                val left = c * cellPx
                val top = r * cellPx
                drawRect(
                    if ((r + c) % 2 == 0) UiColor.Black else UiColor.White,
                    Offset(left, top),
                    Size(cellPx, cellPx)
                )
                val (fill, borderC) = when {
                    zoneIdx >= 0 -> palette[zoneIdx % palette.size].copy(alpha = 0.7f) to
                        palette[zoneIdx % palette.size]
                    idx in selected -> nextColor.copy(alpha = 0.55f) to nextColor
                    else -> neutral to scheme.outline.copy(alpha = 0.5f)
                }
                drawRect(fill, Offset(left, top), Size(cellPx, cellPx))
                drawRect(borderC, Offset(left, top), Size(cellPx, cellPx), style = Stroke(width = 1.dp.toPx()))
            }
        }
    }
}

// Цвета зон (только MaterialTheme): у каждой зоны свой цвет, следующий за сохранёнными.
@Composable
private fun zoneColor(index: Int): UiColor {
    val palette = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.error
    )
    return palette[index % palette.size]
}

@Composable
private fun FileImage(file: File, modifier: Modifier = Modifier) {
    val bmp = remember(file) {
        file?.let { f ->
            runCatching { android.graphics.BitmapFactory.decodeFile(f.absolutePath) }
                .getOrNull()
                ?.let { PhotoCapture.maxBmp(it) }
        }
    }
    if (bmp != null) {
        Image(
            bmp.asImageBitmap(),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}
