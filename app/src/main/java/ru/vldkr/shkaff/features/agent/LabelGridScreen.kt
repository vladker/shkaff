package ru.vldkr.shkaff.features.agent

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color as UiColor
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import java.io.File
import kotlin.math.roundToInt
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.labels.GridSpec
import ru.vldkr.shkaff.domain.labels.GridRegion
import ru.vldkr.shkaff.domain.labels.LabelGrid
import ru.vldkr.shkaff.domain.printer.LabelMath
import ru.vldkr.shkaff.features.labels.LabelGenerator
import ru.vldkr.shkaff.util.PhotoCapture
import ru.vldkr.shkaff.util.newId
import ru.vldkr.shkaff.util.rememberPhotoPickers

class LabelGridVm : ViewModel() {

    enum class Step(val label: String) {
        Size("Размеры"), Select("Зоны"), Layout("Раскладка"), Done("Готово")
    }

    // Одна зона печати = набор плотных ячеек + собственные настройки раскладки.
    data class Zone(
        val name: String,
        val cells: Set<Int>,
        val layoutMode: String = "auto",
        val qrCount: Int = 1,
        val qrScale: Float = 1f,
        val fontSize: Float = 12f
    )

    data class Ui(
        val step: Step = Step.Size,
        val printers: List<PrinterProfileEntity> = emptyList(),
        val printerId: String? = null,
        val baseName: String? = null,
        val width: String = "58",
        val height: String = "40",
        val margin: String = "2",
        val cell: String = "5",
        val photo: File? = null,
        // Текущий (рабочий) выбор ячеек для следующей зоны.
        val selected: Set<Int> = emptySet(),
        // Сохранённые зоны А/Б/В.
        val zones: List<Zone> = emptyList(),
        val activeZone: Int = 0,
        val previewBmp: Bitmap? = null,
        val createdNames: List<String> = emptyList()
    )

    val ui = MutableStateFlow(Ui())
    val busy = MutableStateFlow(false)
    val error = MutableStateFlow<String?>(null)

    private var baseTemplate: LabelTemplateEntity? = null

    /** Сетка под текущие размеры: целое число клеток вписывается в область минус поля. */
    val spec: GridSpec
        get() {
            val u = ui.value
            return GridSpec.fromArea(
                (u.width.toDoubleOrNull() ?: 58.0).coerceIn(20.0, 100.0),
                (u.height.toDoubleOrNull() ?: 40.0).coerceIn(20.0, 100.0),
                (u.cell.toDoubleOrNull() ?: 5.0).coerceIn(2.0, 10.0),
                (u.margin.toDoubleOrNull() ?: 0.0).coerceIn(0.0, 5.0)
            )
        }

    fun init() {
        viewModelScope.launch {
            val printers = Deps.db.printerDao().observeAll().first()
            val templates = Deps.db.labelTemplateDao().observeAll().first()
            val base = templates.firstOrNull()
            baseTemplate = base
            val def = printers.firstOrNull { it.is_default } ?: printers.firstOrNull()
            ui.value = ui.value.copy(
                printers = printers,
                printerId = def?.id,
                baseName = base?.name,
                width = base?.width_mm?.toInt()?.toString() ?: "58",
                height = base?.height_mm?.toInt()?.toString() ?: "40"
            )
        }
    }

    private fun currentPrinter(): PrinterProfileEntity? =
        ui.value.printers.firstOrNull { it.id == ui.value.printerId }

    fun selectPrinter(id: String) {
        ui.value = ui.value.copy(printerId = id)
    }

    fun setWidth(s: String) {
        ui.value = ui.value.copy(width = s)
    }

    fun setHeight(s: String) {
        ui.value = ui.value.copy(height = s)
    }

    fun setMargin(s: String) {
        ui.value = ui.value.copy(margin = s)
    }

    fun setCell(s: String) {
        ui.value = ui.value.copy(cell = s)
    }

    fun printGrid() {
        val p = currentPrinter()
        if (p == null) {
            error.value = "Нет профиля принтера — создайте его в разделе «Принтеры»"
            return
        }
        if (busy.value) return
        error.value = null
        busy.value = true
        viewModelScope.launch {
            try {
                val s = spec
                val bmp = LabelGenerator.renderGrid(s, dpi = LabelMath.DPI)
                val all = (0 until (s.rows * s.cols)).toSet()
                ui.value = ui.value.copy(
                    step = Step.Select,
                    selected = all,
                    previewBmp = null
                )
                // Печать сетки без масштабирования (мм → px одинаково с зонами):
                // иначе клетки отклоняются от номинала и позиции зон не совпадут.
                val gridMm = s.widthMm + 2 * s.marginMm
                PrintManager.printBitmap(p, bmp, Color.BLACK, Color.WHITE, widthMm = gridMm).onFailure { e ->
                    error.value = "Печать не удалась: ${e.message}"
                }
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка печати"
            } finally {
                busy.value = false
            }
        }
    }

    fun toSelect() {
        val s = spec
        ui.value = ui.value.copy(
            step = Step.Select,
            selected = (0 until (s.rows * s.cols)).toSet(),
            previewBmp = null
        )
    }

    fun onPhoto(file: File) {
        ui.value = ui.value.copy(photo = file)
    }

    fun toggleCell(idx: Int) {
        if (ui.value.step != Step.Select) return
        val next = ui.value.selected.toMutableSet().apply {
            if (idx in this) remove(idx) else add(idx)
        }
        ui.value = ui.value.copy(selected = next)
    }

    fun markAll() {
        if (ui.value.step != Step.Select) return
        val s = spec
        ui.value = ui.value.copy(selected = (0 until (s.rows * s.cols)).toSet())
    }

    fun clearSelection() {
        if (ui.value.step != Step.Select) return
        ui.value = ui.value.copy(selected = emptySet())
    }

    fun toLayout() {
        if (ui.value.zones.isEmpty()) return
        ui.value = ui.value.copy(step = Step.Layout)
        refreshPreview()
    }

    fun toSize() {
        ui.value = ui.value.copy(step = Step.Size, previewBmp = null)
    }

    // Назад к выбору зон — без сброса рабочего выбора.
    fun backToSelect() {
        ui.value = ui.value.copy(step = Step.Select)
    }

    // Сохранить текущий выбор ячеек как ещё одну зону (Зона А, Б, В…).
    fun saveZone() {
        val u = ui.value
        if (u.selected.isEmpty()) return
        ui.value = u.copy(
            zones = u.zones + Zone(name = zoneLetter(u.zones.size), cells = u.selected),
            activeZone = u.zones.size
        )
    }

    // Загрузить сохранённую зону в рабочий выбор для правки.
    fun loadZone(i: Int) {
        val z = ui.value.zones.getOrNull(i) ?: return
        ui.value = ui.value.copy(selected = z.cells)
    }

    fun removeZone(i: Int) {
        val u = ui.value
        val zones = u.zones.filterIndexed { idx, _ -> idx != i }
        ui.value = u.copy(
            zones = zones,
            activeZone = u.activeZone.coerceIn(0, (zones.size - 1).coerceAtLeast(0))
        )
    }

    fun selectActiveZone(i: Int) {
        val u = ui.value
        if (i !in u.zones.indices) return
        ui.value = u.copy(activeZone = i)
        refreshPreview()
    }

    private fun activeIdx(): Int =
        ui.value.activeZone.coerceIn(0, (ui.value.zones.size - 1).coerceAtLeast(0))

    private fun active(): Zone? = ui.value.zones.getOrNull(activeIdx())

    private fun updateActive(block: (Zone) -> Zone) {
        if (ui.value.step != Step.Layout) return
        val u = ui.value
        val i = activeIdx()
        val zones = u.zones.toMutableList()
        zones[i] = block(zones[i])
        ui.value = u.copy(zones = zones)
        refreshPreview()
    }

    fun setLayoutMode(mode: String) { updateActive { it.copy(layoutMode = mode) } }

    fun setQrCount(n: Int) { updateActive { it.copy(qrCount = n.coerceIn(1, 2)) } }

    fun setQrScale(f: Float) { updateActive { it.copy(qrScale = f) } }

    fun setFontSize(f: Float) { updateActive { it.copy(fontSize = f) } }

    private fun zoneLetter(i: Int): String =
        if (i < 26) "Зона ${('A' + i).toString()}" else "Зона ${i + 1}"

    /** Шаблон под зону: размеры её области, без внутренних полей, её же раскладка. */
    private fun templateFor(z: Zone): Pair<LabelTemplateEntity, GridRegion>? {
        val base = baseTemplate ?: return null
        val region = LabelGrid.regionOf(spec, z.cells) ?: return null
        val (w, h) = LabelGrid.regionMm(spec, region)
        return base.copy(
            width_mm = w,
            height_mm = h,
            margin_mm = 0.0,
            layout_mode = z.layoutMode,
            qr_count = z.qrCount,
            qr_scale = z.qrScale.toDouble(),
            font_size = maxOf(LabelGrid.MIN_FONT_PT, z.fontSize.toDouble())
        ) to region
    }

    fun refreshPreview() {
        if (ui.value.step != Step.Layout) return
        val z = active() ?: return
        val r = templateFor(z) ?: return
        val bmp = LabelGenerator.generateLayout(r.first, "DEMO-123", "Демо-вещь", dpi = 150)
        ui.value = ui.value.copy(previewBmp = bmp)
    }

    fun printTest() {
        val p = currentPrinter()
        if (p == null) {
            error.value = "Нет профиля принтера — создайте его в разделе «Принтеры»"
            return
        }
        if (busy.value) return
        val z = active()
            ?: run { error.value = "Нет зоны — на шаге «Зоны» сохраните хотя бы одну"; return }
        error.value = null
        busy.value = true
        viewModelScope.launch {
            try {
                val r = templateFor(z)
                    ?: run { error.value = "Не удалось построить шаблон зоны"; return@launch }
                val bmp = LabelGenerator.generateLayout(r.first, "DEMO-123", "Демо-вещь", dpi = LabelMath.DPI)
                    ?: run { error.value = "Не удалось отрисовать этикетку"; return@launch }
                // Позиция зоны на листе: растр кладётся не в (0,0), а со сдвигом.
                // Сетка печатается без масштабирования (см. printGrid), поэтому мм → px одинаковы.
                val (oxMm, oyMm) = LabelGrid.regionOrigin(spec, r.second)
                PrintManager.printBitmap(
                    p, bmp,
                    Color.BLACK, Color.WHITE,
                    offsetXpx = LabelMath.px(oxMm),
                    offsetYpx = LabelMath.px(oyMm),
                    widthMm = r.first.width_mm
                ).onFailure { e -> error.value = "Печать не удалась: ${e.message}" }
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка печати"
            } finally {
                busy.value = false
            }
        }
    }

    // Пустая полоска высотой mm — «протаскивает» ленту вперёд на величину полоски.
    // Принтер подаёт ленту только вперёд (откат по команде не выполняется), поэтому
    // малые перемещения ленты делаются печатью короткой пустой метки.
    fun printBlankStrip(mm: Int) {
        val p = currentPrinter()
        if (p == null) {
            error.value = "Нет профиля принтера — создайте его в разделе «Принтеры»"
            return
        }
        if (busy.value) return
        error.value = null
        busy.value = true
        viewModelScope.launch {
            try {
                val widthMm = ui.value.width.toDoubleOrNull() ?: 58.0
                val bmp = Bitmap.createBitmap(
                    (widthMm * 8f).roundToInt().coerceAtLeast(8),
                    (mm * 8f).roundToInt().coerceAtLeast(8),
                    Bitmap.Config.ARGB_8888
                )
                Canvas(bmp).drawColor(Color.WHITE)
                PrintManager.printBitmap(
                    p, bmp,
                    Color.BLACK, Color.WHITE,
                    widthMm = widthMm
                ).onFailure { e -> error.value = "Печать не удалась: ${e.message}" }
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка печати"
            } finally {
                busy.value = false
            }
        }
    }

    fun save() {
        val u = ui.value
        val base = baseTemplate
        if (base == null || u.zones.isEmpty() || busy.value) return
        error.value = null
        busy.value = true
        viewModelScope.launch {
            try {
                val now = System.currentTimeMillis()
                val names = mutableListOf<String>()
                for (z in u.zones) {
                    val r = templateFor(z) ?: continue
                    val t = r.first
                    val name = "${z.name} ${t.width_mm.toInt()}×${t.height_mm.toInt()} мм"
                    val existing = Deps.db.labelTemplateDao().byName(name)
                    val row = existing?.copy(
                        width_mm = t.width_mm, height_mm = t.height_mm, margin_mm = t.margin_mm,
                        layout_mode = t.layout_mode, qr_count = t.qr_count, qr_scale = t.qr_scale,
                        font_size = t.font_size,
                        updated_at = now,
                        device_last_modified = Deps.deviceId
                    ) ?: base.copy(
                        id = newId(),
                        name = name,
                        width_mm = t.width_mm, height_mm = t.height_mm, margin_mm = t.margin_mm,
                        layout_mode = t.layout_mode, qr_count = t.qr_count, qr_scale = t.qr_scale,
                        font_size = t.font_size,
                        created_at = now,
                        updated_at = now,
                        device_last_modified = Deps.deviceId
                    )
                    Deps.db.labelTemplateDao().upsert(row)
                    names += name
                }
                ui.value = u.copy(step = Step.Done, createdNames = names)
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка сохранения"
            } finally {
                busy.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelGridScreen(nav: NavController) {
    val vm: LabelGridVm = viewModel()
    val ui by vm.ui.collectAsState()
    val busy by vm.busy.collectAsState()
    val error by vm.error.collectAsState()
    LaunchedEffect(Unit) { vm.init() }

    val pickers = rememberPhotoPickers(
        onCaptured = { vm.onPhoto(it) },
        onPicked = { vm.onPhoto(it) }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Этикетка по сетке") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item { GridStepper(ui.step) }
            when (ui.step) {
                LabelGridVm.Step.Size -> item { SizeStep(vm, ui, busy) }
                LabelGridVm.Step.Select -> item {
                    SelectStep(
                        vm = vm,
                        ui = ui,
                        spec = vm.spec,
                        onShoot = { pickers.takePhoto() },
                        onPick = { pickers.pickFromGallery() }
                    )
                }
                LabelGridVm.Step.Layout -> item { LayoutStep(vm, ui, busy) }
                LabelGridVm.Step.Done -> item { DoneStep(ui) { nav.popBackStack() } }
            }
            error?.let { e ->
                item {
                    Text(
                        e,
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

@Composable
private fun MmField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
    )
}

@Composable
private fun SizeStep(vm: LabelGridVm, ui: LabelGridVm.Ui, busy: Boolean) {
    val preview = remember(vm.spec) { LabelGenerator.renderGrid(vm.spec, dpi = 50) }
    val region = vm.spec
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "1) Напечатайте шаблон-шахматку под свой принтер.\n" +
                "2) Посмотрите напечатанное и отметьте клетки, где печать плотная.\n" +
                "3) Настройте раскладку QR и текста под эту зону — и сохраните как шаблон.",
            style = MaterialTheme.typography.bodyMedium
        )
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MmField("Ширина, мм", ui.width, vm::setWidth)
            MmField("Длина, мм", ui.height, vm::setHeight)
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            MmField("Поля, мм", ui.margin, vm::setMargin)
            MmField("Клетка, мм", ui.cell, vm::setCell)
        }
        Text(
            "Сетка: ${region.cols}×${region.rows} клеток = ${region.widthMm.toInt()}×${region.heightMm.toInt()} мм",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Image(
            preview.asImageBitmap(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            contentScale = ContentScale.Fit
        )
        if (ui.printers.isEmpty()) {
            Text(
                "Профилей принтеров нет — создайте в разделе «Принтеры» или напечатайте шаблон на другом принтере.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            Text("Принтер:", style = MaterialTheme.typography.bodyMedium)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                ui.printers.forEach { p ->
                    FilterChip(
                        selected = p.id == ui.printerId,
                        onClick = { vm.selectPrinter(p.id) },
                        label = { Text(p.name) }
                    )
                }
            }
            Button(
                onClick = { vm.printGrid() },
                enabled = !busy && ui.printerId != null,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Напечатать шаблон") }
        }
        Button(
            onClick = { vm.toSelect() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Далее: отмечать клетки") }
    }
}

@Composable
private fun GridStepper(step: LabelGridVm.Step) {
    val steps = LabelGridVm.Step.values()
    val idx = steps.indexOf(step)
    Row(Modifier.fillMaxWidth()) {
        steps.forEach { s ->
            val si = steps.indexOf(s)
            val active = s == step
            val done = si < idx
            val color = if (active) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurfaceVariant
            Column(
                Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    if (done) "✓" else (si + 1).toString(),
                    style = MaterialTheme.typography.labelLarge,
                    color = color
                )
                Text(
                    s.label,
                    style = MaterialTheme.typography.labelSmall,
                    color = color,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
private fun FileImage(file: File?, modifier: Modifier = Modifier) {
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

/**
 * Кликабельная шахматка:
 * - клетки сохранённых зон — цвет своей зоны (полупрозрачный);
 * - рабочий выбор — цвет будущей (следующей) зоны;
 * - свободные клетки — нейтральная «застенка».
 */
@Composable
private fun CheckerboardGrid(
    spec: GridSpec,
    selected: Set<Int>,
    zones: List<Set<Int>>,
    onCell: (Int) -> Unit
) {
    val cell = (spec.cellMm * 1.5f).dp.coerceIn(14.dp, 36.dp)
    val neutral = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.5f)
    val nextColor = zoneColor(zones.size)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        for (r in 0 until spec.rows) {
            Row {
                for (c in 0 until spec.cols) {
                    val idx = LabelGrid.cellIndex(spec, r, c)
                    val zoneIdx = zones.indexOfFirst { idx in it }
                    val fill: UiColor
                    val borderC: UiColor
                    if (zoneIdx >= 0) {
                        val zc = zoneColor(zoneIdx)
                        fill = zc.copy(alpha = 0.7f)
                        borderC = zc
                    } else if (idx in selected) {
                        fill = nextColor.copy(alpha = 0.55f)
                        borderC = nextColor
                    } else {
                        fill = neutral
                        borderC = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)
                    }
                    Box(
                        modifier = Modifier
                            .size(cell)
                            .background(if ((r + c) % 2 == 0) UiColor.Black else UiColor.White)
                            .background(fill)
                            .border(1.dp, borderC)
                            .clickable { onCell(idx) }
                    )
                }
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
private fun SelectStep(
    vm: LabelGridVm,
    ui: LabelGridVm.Ui,
    spec: GridSpec,
    onShoot: () -> Unit,
    onPick: () -> Unit
) {
    val region = LabelGrid.regionOf(spec, ui.selected)
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Сравните с напечатанным листом и отметьте клетки, где печать плотная — они подсвечиваются цветом новой зоны. " +
                "Нажмите «Сохранить зону» и отметьте следующую: она получит другой цвет, чтобы зоны не смешивались.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            CheckerboardGrid(spec, ui.selected, ui.zones.map { it.cells }, vm::toggleCell)
        }
        if (region != null) {
            val (w, h) = LabelGrid.regionMm(spec, region)
            Card(Modifier.fillMaxWidth()) {
                Text(
                    "Рабочий выбор: ${w.toInt()}×${h.toInt()} мм (${ui.selected.size} кл.)",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(12.dp)
                )
            }
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
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(zoneColor(i))
                        )
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
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = { vm.toSize() }, modifier = Modifier.weight(1f)) {
                Text("Назад")
            }
            Button(
                onClick = { vm.toLayout() },
                enabled = ui.zones.isNotEmpty(),
                modifier = Modifier.weight(2f)
            ) {
                Text("Далее: раскладка")
            }
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
        ui.photo?.let { file ->
            FileImage(file, Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun LayoutStep(vm: LabelGridVm, ui: LabelGridVm.Ui, busy: Boolean) {
    val z = ui.zones.getOrNull(ui.activeZone)
    val zr = z?.let { LabelGrid.regionOf(vm.spec, it.cells) }
    val w = zr?.let { LabelGrid.regionMm(vm.spec, it).first } ?: 0.0
    val h = zr?.let { LabelGrid.regionMm(vm.spec, it).second } ?: 0.0
    val mode = z?.layoutMode ?: "auto"
    val qrCount = z?.qrCount ?: 1
    val qrScale = z?.qrScale ?: 1f
    val fontSize = z?.fontSize ?: 12f
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            "Зона: ${w.toInt()}×${h.toInt()} мм — код и текст займут всю выбранную область (без внутренних полей). " +
                "QR — не меньше 10×10 мм, шрифт — не меньше 6 pt; текст, который не влезает, обрезается.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (ui.zones.size > 1) {
            Text("Зона для печати:", style = MaterialTheme.typography.bodyMedium)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.horizontalScroll(rememberScrollState())
            ) {
                ui.zones.forEachIndexed { i, zz ->
                    FilterChip(
                        selected = i == ui.activeZone,
                        onClick = { vm.selectActiveZone(i) },
                        label = { Text(zz.name) }
                    )
                }
            }
        }
        Text("Раскладка:", style = MaterialTheme.typography.bodyMedium)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = mode == "auto",
                onClick = { vm.setLayoutMode("auto") },
                label = { Text("Авто по форме") }
            )
            FilterChip(
                selected = mode == "v",
                onClick = { vm.setLayoutMode("v") },
                label = { Text("QR сверху") }
            )
            FilterChip(
                selected = mode == "h",
                onClick = { vm.setLayoutMode("h") },
                label = { Text("QR сбоку") }
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            FilterChip(
                selected = qrCount == 1,
                onClick = { vm.setQrCount(1) },
                label = { Text("1 код") }
            )
            FilterChip(
                selected = qrCount == 2,
                onClick = { vm.setQrCount(2) },
                label = { Text("2 кода (вещь + репозиторий)") }
            )
        }
        val maxQrMm = minOf(w, h).toInt()
        if (maxQrMm > 10) {
            val qrMm = (qrScale * maxQrMm).roundToInt().coerceIn(10, maxQrMm)
            Column {
                Text(
                    "Размер кода: $qrMm мм (база 10×10 мм, максимум — сторона зоны ${maxQrMm} мм)",
                    style = MaterialTheme.typography.bodyMedium
                )
                Slider(
                    value = qrMm.toFloat(),
                    onValueChange = { mm -> vm.setQrScale(mm / maxQrMm) },
                    valueRange = 10f..maxQrMm.toFloat(),
                    steps = maxQrMm - 11
                )
            }
        } else {
            Text(
                "Зона меньше 10 мм — код будет напечатан в 10×10 мм и вылезет за зону. " +
                    "Выберите зону покрупнее.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.error
            )
        }
        Column {
            Text("Шрифт: ${fontSize.toInt()} pt", style = MaterialTheme.typography.bodyMedium)
            Slider(
                value = fontSize,
                onValueChange = { vm.setFontSize(it) },
                valueRange = 6f..24f,
                steps = 17
            )
        }
        ui.previewBmp?.let { bmp ->
            Text("Превью:", style = MaterialTheme.typography.bodyMedium)
            Image(
                bmp.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Fit
            )
        }
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text("Подача ленты (для вертикальных зон):", style = MaterialTheme.typography.bodyMedium)
                Text(
                    "Этот принтер подаёт ленту только вперёд — откат по команде не выполняется. " +
                        "Чтобы протащить ленту на 5 мм, напечатайте пустую полоску высотой 5 мм.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                OutlinedButton(
                    onClick = { vm.printBlankStrip(5) },
                    enabled = !busy && ui.printerId != null,
                    modifier = Modifier.fillMaxWidth()
                ) { Text("Протащить ленту 5 мм (пустая полоска)") }
            }
        }
        Button(
            onClick = { vm.printTest() },
            enabled = !busy && ui.printerId != null,
            modifier = Modifier.fillMaxWidth()
        ) { Text("Напечатать тестовую этикетку") }
        Button(
            onClick = { vm.save() },
            enabled = !busy && ui.zones.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        ) { Text("Сохранить зоны как шаблоны") }
        Text(
            "Для каждой зоны будет создан шаблон вида «Зона А 58×20 мм» — при печати в «Этикетках» выбирайте зону, в которой печатаете.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        OutlinedButton(
            onClick = { vm.backToSelect() },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Назад: к зонам") }
    }
}

@Composable
private fun DoneStep(ui: LabelGridVm.Ui, onDone: () -> Unit) {
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Готово", style = MaterialTheme.typography.titleLarge)
        if (ui.createdNames.isEmpty()) {
            Text("Зоны не сохранены.", style = MaterialTheme.typography.bodyMedium)
        } else {
            ui.createdNames.forEach { n ->
                Text(
                    "Шаблон «$n» готов — в «Этикетках» выберите его и зону, в которой печатаете.",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Button(onClick = onDone, modifier = Modifier.fillMaxWidth()) { Text("Назад к агенту") }
    }
}
