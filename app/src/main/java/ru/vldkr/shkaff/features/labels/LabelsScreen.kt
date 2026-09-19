package ru.vldkr.shkaff.features.labels

import android.content.Context
import android.content.Intent
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color as ComposeColor
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.json.JSONArray
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.data.printer.UsbPermission
import ru.vldkr.shkaff.data.printer.UsbPermissionPendingException
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.labels.GridRegion
import ru.vldkr.shkaff.domain.labels.GridSpec
import ru.vldkr.shkaff.domain.labels.LabelGrid
import ru.vldkr.shkaff.domain.printer.LabelMath
import ru.vldkr.shkaff.features.printers.PrinterPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.util.newId
import ru.vldkr.shkaff.util.newUlid
import ru.vldkr.shkaff.util.rememberPhotoPickers
import java.io.File
import kotlin.math.roundToInt

/**
 * Единый экран этикеток.
 * Шаг 0 — «Этикетка и зоны»: содержимое кода, базовые настройки печати,
 *        калибровка зон под принтер (шахматка, выбор клеток, фото).
 * Шаг 1 — «Раскладка и печать»: выбор зоны, раскладка кода внутри зоны,
 *        предпросмотр, быстрая/тестовая печать, сохранение зон как шаблоны.
 */
class LabelsVm(
    val entityKind: String = "item", // "item" | "location" | "storage" — что именно маркируем.
    private val entityId: String?,
    private val templateId: String?
) : ViewModel() {

    // Субъект этикетки: название, код (для QR) и карта атрибутов для рендера.
    data class Subject(
        val kind: String,
        val id: String,
        val name: String,
        val code: String,
        val attrs: Map<String, String>
    )

    data class Zone(
        val name: String,
        val cells: Set<Int>,
        val layoutMode: String = "auto",
        val qrCount: Int = 1,
        val qrScale: Float = 1f,
        val fontSize: Float = 12f,
        // Одна зона — одна вещь: id вещи, которую печатаем в этой области листа (null — зона пуста).
        val itemId: String? = null
    )

    enum class SaveMode { OVERWRITE, SAVE_AS, SET_DEFAULT }

    data class Ui(
        // — этикетка (шаг 0) —
        val subject: Subject? = null,
        val code: String = "",
        val name: String = "",
        val templates: List<LabelTemplateEntity> = emptyList(),
        val template: LabelTemplateEntity? = null,
        val attrDefs: List<AttributeDefEntity> = emptyList(),
        val bitmap: Bitmap? = null,
        val savedMsg: String? = null,
        val profiles: List<PrinterProfileEntity> = emptyList(),
        val printMsg: String? = null,
        val printError: String? = null,
        val sizeW: String = "",
        val sizeH: String = "",
        val textPosition: String = "bottom",
        val showText: Boolean = true,
        val showNumber: Boolean = true,
        val fontSize: String = "",
        val marginMm: String = "",
        val format: String = "",
        val showSaveDialog: Boolean = false,
        val saveAsName: String = "",
        val saveMode: SaveMode = SaveMode.OVERWRITE,
        // — зоны (шаг 0) —
        val step: Int = 0,
        val gridCell: String = "5",
        val gridMargin: String = "2",
        val gridPrinterId: String? = null,
        val busy: Boolean = false,
        val gridPhoto: File? = null,
        val selected: Set<Int> = emptySet(),
        val zones: List<Zone> = emptyList(),
        // — раскладка и печать (шаг 1) —
        val activeZone: Int = 0,
        val previewBmp: Bitmap? = null,
        val createdNames: List<String> = emptyList(),
        // — вещи в зонах (батч) —
        val unlabelled: List<ItemEntity> = emptyList(),
        // Кэш вещей, назначенных в зоны (id → сущность): имена остаются видимыми,
        // даже когда вещь уже вышла из очереди «без этикетки».
        val itemCache: Map<String, ItemEntity> = emptyMap(),
        val showAddDialog: Boolean = false
    )

    val ui = MutableStateFlow(Ui())

    /** Текущая сетка из полей «Размер этикетки» + «Клетка». */
    val spec: GridSpec
        get() {
            val u = ui.value
            return GridSpec.fromArea(
                (u.sizeW.toDoubleOrNull() ?: 58.0).coerceIn(20.0, 100.0),
                (u.sizeH.toDoubleOrNull() ?: 40.0).coerceIn(20.0, 100.0),
                (u.gridCell.toDoubleOrNull() ?: 5.0).coerceIn(2.0, 10.0),
                (u.gridMargin.toDoubleOrNull() ?: 0.0).coerceIn(0.0, 5.0)
            )
        }

    private fun update(fn: (Ui) -> Ui) { ui.value = fn(ui.value) }

    private fun active(): Zone? = ui.value.zones.getOrNull(ui.value.activeZone)

    private fun currentPrinter(): PrinterProfileEntity? =
        ui.value.profiles.firstOrNull { it.id == ui.value.gridPrinterId }
            ?: ui.value.profiles.firstOrNull { it.is_default }
            ?: ui.value.profiles.firstOrNull()

    // ==================== Этикетка (шаг 0) ====================

    fun setTemplate(id: String) {
        val t = ui.value.templates.firstOrNull { it.id == id } ?: return
        update {
            it.copy(
                template = t,
                sizeW = if (it.sizeW.isEmpty()) t.width_mm.toInt().toString() else it.sizeW,
                sizeH = if (it.sizeH.isEmpty()) t.height_mm.toInt().toString() else it.sizeH
            )
        }
        regenerate()
    }

    fun setCode(c: String) {
        update { it.copy(code = c, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setSize(w: String, h: String) {
        update { it.copy(sizeW = w, sizeH = h, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setTextPosition(p: String) {
        if (p != "top" && p != "bottom") return
        update { it.copy(textPosition = p, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setShowText(v: Boolean) {
        update { it.copy(showText = v, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setShowNumber(v: Boolean) {
        update { it.copy(showNumber = v, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setFontSize(s: String) {
        update { it.copy(fontSize = s, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setMarginMm(m: String) {
        update { it.copy(marginMm = m, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setFormat(f: String) {
        update { it.copy(format = f, bitmap = null, savedMsg = null) }
        regenerate()
    }

    /** Ключи атрибутов, отмеченные в шаблоне (template.label_attrs — JSON-массив ключей). */
    fun selectedAttrKeys(): Set<String> =
        ui.value.template?.let { AttrJson.parseOptions(it.label_attrs) }?.toSet() ?: emptySet()

    /** Включить/выключить атрибут в наборе печатаемых и переписать template.label_attrs (порядок словаря). */
    fun toggleAttr(key: String) {
        val t = ui.value.template ?: return
        val sel = selectedAttrKeys().toMutableSet()
        if (key in sel) sel.remove(key) else sel.add(key)
        val base = ui.value.attrDefs.map { it.key }.filter { it in sel }
        val ordered = base + sel.filter { it !in base }
        val arr = JSONArray()
        ordered.forEach { arr.put(it) }
        update { it.copy(template = t.copy(label_attrs = arr.toString()), bitmap = null, savedMsg = null) }
        regenerate()
    }

    fun resetOverrides() {
        val t = ui.value.template ?: return
        update {
            it.copy(
                sizeW = t.width_mm.toInt().toString(),
                sizeH = t.height_mm.toInt().toString(),
                textPosition = t.text_position,
                showText = t.show_text,
                showNumber = t.show_number,
                fontSize = t.font_size.toString(),
                marginMm = t.margin_mm.toString(),
                format = t.format,
                bitmap = null,
                savedMsg = null
            )
        }
        regenerate()
    }

    fun effectiveTemplate(): LabelTemplateEntity? {
        val u = ui.value
        val t = u.template ?: return null
        return t.copy(
            width_mm = (u.sizeW.toDoubleOrNull() ?: t.width_mm).coerceIn(10.0, 120.0),
            height_mm = (u.sizeH.toDoubleOrNull() ?: t.height_mm).coerceIn(10.0, 120.0),
            text_position = u.textPosition,
            show_text = u.showText,
            show_number = u.showNumber,
            font_size = (u.fontSize.toDoubleOrNull() ?: t.font_size).coerceIn(4.0, 72.0),
            margin_mm = (u.marginMm.toDoubleOrNull() ?: t.margin_mm).coerceIn(0.0, 15.0),
            format = u.format.ifBlank { t.format }
        )
    }

    fun openSaveDialog(mode: SaveMode) {
        update {
            it.copy(showSaveDialog = true, saveMode = mode, saveAsName = if (mode == SaveMode.SAVE_AS) it.template?.name.orEmpty() + " (копия)" else "")
        }
    }

    fun closeSaveDialog() { update { it.copy(showSaveDialog = false, saveAsName = "") } }
    fun setSaveAsName(s: String) { update { it.copy(saveAsName = s) } }

    fun saveCurrentSettings() {
        val t = ui.value.template ?: return
        val eff = effectiveTemplate() ?: return
        val mode = ui.value.saveMode
        viewModelScope.launch {
            when (mode) {
                SaveMode.OVERWRITE -> {
                    // Перезаписываем текущий шаблон
                    val updated = t.copy(
                        width_mm = eff.width_mm,
                        height_mm = eff.height_mm,
                        text_position = eff.text_position,
                        show_text = eff.show_text,
                        show_number = eff.show_number,
                        font_size = eff.font_size,
                        margin_mm = eff.margin_mm,
                        format = eff.format,
                        updated_at = System.currentTimeMillis(),
                        device_last_modified = Deps.deviceId
                    )
                    Deps.db.labelTemplateDao().upsert(updated)
                    update { it.copy(showSaveDialog = false, savedMsg = "Шаблон обновлён") }
                }
                SaveMode.SAVE_AS -> {
                    // Сохраняем как новый кастомный шаблон
                    val name = ui.value.saveAsName.ifBlank { "Копия ${t.name}" }
                    val newId = newId()
                    val now = System.currentTimeMillis()
                    val newT = eff.copy(
                        id = newId,
                        name = name,
                        created_at = now,
                        updated_at = now,
                        device_last_modified = Deps.deviceId
                    )
                    Deps.db.labelTemplateDao().upsert(newT)
                    update { it.copy(showSaveDialog = false, savedMsg = "Сохранено как: $name", template = newT) }
                }
                SaveMode.SET_DEFAULT -> {
                    // Делаем текущие настройки основным шаблоном по умолчанию
                    val defaultName = "Основной шаблон"
                    val existingDefault = Deps.db.labelTemplateDao().byName(defaultName)
                    val now = System.currentTimeMillis()
                    val newT = eff.copy(
                        id = existingDefault?.id ?: newId(),
                        name = defaultName,
                        created_at = existingDefault?.created_at ?: now,
                        updated_at = now,
                        device_last_modified = Deps.deviceId
                    )
                    Deps.db.labelTemplateDao().upsert(newT)
                    update { it.copy(showSaveDialog = false, savedMsg = "Установлен как основной шаблон") }
                }
            }
        }
    }

    // Атрибуты текущего субъекта (для печати на этикетке); пустая карта, если субъект не загружен.
    private fun currentAttrs(): Map<String, String> =
        ui.value.subject?.attrs ?: emptyMap()

    // ==================== Вещи в зонах (батч: одна зона — одна вещь) ====================

    /** Очередь вещей, которым ещё не напечатана этикетка — для заполнения зон. */
    fun loadUnlabelled() {
        viewModelScope.launch {
            val list = Deps.items.recentUnlabelled(200).toMutableList()
            // Текущая вещь (для которой открыт экран) всегда доступна к назначению.
            val s = ui.value.subject
            if (s != null && s.kind == "item") {
                val cur = Deps.items.byId(s.id)
                if (cur != null && list.none { it.id == cur.id }) list.add(0, cur)
            }
            update { it.copy(unlabelled = list, itemCache = list.associateBy { it.id }) }
        }
    }

    fun openAddDialog() {
        loadUnlabelled()
        update { it.copy(showAddDialog = true) }
    }

    fun closeAddDialog() {
        update { it.copy(showAddDialog = false) }
    }

    /** Назначить вещь активной зоне (одна зона — одна вещь; повторный выбор заменяет). */
    fun assignItemToActiveZone(itemId: String) {
        if (ui.value.step != 1) return
        updateActive { it.copy(itemId = itemId) }
        closeAddDialog()
    }

    /** Убрать вещь из зоны. */
    fun clearZoneItem(i: Int) {
        val list = ui.value.zones.toMutableList()
        if (!list.indices.contains(i)) return
        list[i] = list[i].copy(itemId = null)
        update { it.copy(zones = list) }
    }

    /** Сколько зон заполнено вещью. */
    fun filledZoneCount(): Int = ui.value.zones.count { it.itemId != null }

    fun regenerate() {
        val t = effectiveTemplate() ?: return
        val bmp = LabelGenerator.generateLayout(t, ui.value.code, ui.value.name, attrs = currentAttrs())
        update { it.copy(bitmap = bmp, savedMsg = null) }
    }

    fun saveToGallery(ctx: Context) {
        val bmp = ui.value.bitmap ?: return
        val name = ui.value.name.ifBlank { "label" }
        val uri = LabelGenerator.saveToGallery(ctx, bmp, "${LabelGenerator.sanitizeFileName(name)}.png")
        update { it.copy(savedMsg = if (uri != null) "Сохранено в галерею" else "Не удалось сохранить") }
    }

    fun share(ctx: Context) {
        val bmp = ui.value.bitmap ?: return
        val name = ui.value.name.ifBlank { "label" }
        val file = LabelGenerator.saveToInternal(ctx, bmp, name)
        val uri = LabelGenerator.fileShareUri(ctx, file)
        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "image/png"
            putExtra(Intent.EXTRA_STREAM, uri)
            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        }
        ctx.startActivity(Intent.createChooser(intent, "Поделиться этикеткой"))
    }

    fun print(profile: PrinterProfileEntity) {
        val t = effectiveTemplate() ?: return
        val code = ui.value.code
        if (code.isBlank()) { update { it.copy(printError = "Пустой код — нечего печатать") }; return }
        update { it.copy(busy = true, printMsg = null, printError = null) }
        viewModelScope.launch {
            val r = try { PrintManager.printLabel(profile, t, code, ui.value.name) }
            catch (e: Exception) { Result.failure(e) }
            val e = r.exceptionOrNull()
            when {
                e == null -> update { it.copy(busy = false, printError = null, printMsg = "Отправлено на печать: ${PrintManager.describe(profile)}") }
                e is UsbPermissionPendingException -> {
                    val msg = UsbPermission.failureMessage(e) { print(profile) }
                    update { it.copy(busy = false, printMsg = msg) }
                }
                else -> update { it.copy(busy = false, printError = "Ошибка: ${e.message ?: "не удалось напечатать"}") }
            }
        }
    }

    // ==================== Зоны (шаг 0) ====================

    fun onPhoto(file: File) { update { it.copy(gridPhoto = file) } }
    fun selectGridPrinter(id: String) { update { it.copy(gridPrinterId = id) } }
    fun setGridCell(s: String) { update { it.copy(gridCell = s) } }
    fun setGridMargin(s: String) { update { it.copy(gridMargin = s) } }

    fun printGrid() {
        val p = currentPrinter()
        if (p == null) { update { it.copy(printError = "Нет профиля принтера — создайте в разделе «Принтеры»") }; return }
        if (ui.value.busy) return
        update { it.copy(busy = true, printError = null) }
        viewModelScope.launch {
            try {
                val s = spec
                val bmp = LabelGenerator.renderGrid(s, dpi = LabelMath.DPI)
                    ?: throw IllegalStateException("не удалось отрисовать сетку")
                val gridMm = s.cols * s.cellMm
                val res = PrintManager.printBitmap(p, bmp, Color.BLACK, Color.WHITE, widthMm = gridMm)
                val e = res.exceptionOrNull()
                when {
                    e == null -> update { it.copy(printMsg = "Отправлен шаблон-шахматка") }
                    else -> update { it.copy(printError = "Не удалось напечатать: ${e.message}") }
                }
            } catch (e: Exception) {
                update { it.copy(printError = e.message ?: "Ошибка печати") }
            } finally {
                update { it.copy(busy = false) }
            }
        }
    }

    fun toggleCell(idx: Int) {
        if (ui.value.step != 0) return
        update {
            val sel = it.selected.toMutableSet()
            if (sel.contains(idx)) sel.remove(idx) else sel.add(idx)
            it.copy(selected = sel)
        }
    }

    /** Прямоугольный выбор между двумя углами (тащ пальцем по шахматке). */
    fun selectRect(a: Int, b: Int) {
        if (ui.value.step != 0) return
        val s = spec
        val (ar, ac) = LabelGrid.rowOf(s, a) to LabelGrid.colOf(s, a)
        val (br, bc) = LabelGrid.rowOf(s, b) to LabelGrid.colOf(s, b)
        val cells = (minOf(ar, br)..maxOf(ar, br)).flatMap { r ->
            (minOf(ac, bc)..maxOf(ac, bc)).map { c -> LabelGrid.cellIndex(s, r, c) }
        }.toSet()
        update { it.copy(selected = cells) }
    }

    fun markAll() {
        if (ui.value.step != 0) return
        update { it.copy(selected = (0 until spec.rows * spec.cols).toSet()) }
    }

    fun clearSelection() {
        if (ui.value.step != 0) return
        update { it.copy(selected = emptySet()) }
    }

    fun saveZone() {
        if (ui.value.step != 0) return
        val sel = ui.value.selected
        if (sel.isEmpty()) return
        val z = Zone(name = "Зона ${ui.value.zones.size + 1}", cells = sel)
        update { it.copy(zones = it.zones + z) }
    }

    fun loadZone(i: Int) {
        if (ui.value.step != 0) return
        val z = ui.value.zones.getOrNull(i) ?: return
        update { it.copy(selected = z.cells) }
    }

    fun removeZone(i: Int) {
        if (ui.value.step != 0) return
        val z = ui.value.zones.getOrNull(i) ?: return
        update { it.copy(zones = it.zones - z) }
    }

    // ==================== Раскладка и печать (шаг 1) ====================

    fun next() {
        if (ui.value.step != 0 || ui.value.zones.isEmpty()) return
        update { it.copy(step = 1, activeZone = 0, previewBmp = null) }
        refreshPreview()
    }

    fun back() {
        if (ui.value.step != 1) return
        update { it.copy(step = 0, previewBmp = null) }
    }

    fun selectActiveZone(i: Int) {
        if (ui.value.step != 1) return
        update { it.copy(activeZone = i) }
        refreshPreview()
    }

    private fun updateActive(fn: (Zone) -> Zone) {
        if (ui.value.step != 1) return
        val i = ui.value.activeZone
        val list = ui.value.zones.toMutableList()
        if (!list.indices.contains(i)) return
        list[i] = fn(list[i])
        update { it.copy(zones = list) }
        refreshPreview()
    }

    fun setLayoutMode(m: String) { updateActive { it.copy(layoutMode = m) } }
    fun setQrCount(n: Int) { updateActive { it.copy(qrCount = n) } }
    fun setQrScale(s: Float) { updateActive { it.copy(qrScale = s) } }
    fun setZoneFontSize(v: Float) { updateActive { it.copy(fontSize = v) } }

    fun refreshPreview() {
        if (ui.value.step != 1) return
        val z = active() ?: return
        val r = templateFor(z) ?: return
        val code = ui.value.code.ifBlank { "DEMO-123" }
        val name = ui.value.name.ifBlank { "Демо-вещь" }
        val bmp = LabelGenerator.generateLayout(r.first, code, name, dpi = 150, attrs = currentAttrs())
        update { it.copy(previewBmp = bmp) }
    }

    /** Шаблон зоны: базовый с размером/положением под выбранную область. */
    private fun templateFor(z: Zone): Pair<LabelTemplateEntity, GridRegion>? {
        val base = ui.value.template ?: ui.value.templates.firstOrNull() ?: return null
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

    /** Печать активного содержимого кода в активной зоне (с её смещением). */
    // Отметить субъект (вещь/ящик/хранилище) как «этикетка напечатана».
    private suspend fun markSubjectLabelled() {
        val s = ui.value.subject ?: return
        when (s.kind) {
            "location" -> Deps.locations.markLabelled(s.id)
            "storage" -> Deps.storages.markLabelled(s.id)
            else -> Deps.items.markLabelled(s.id)
        }
    }

    fun quickPrint() {
        val p = currentPrinter()
        if (p == null) { update { it.copy(printError = "Нет профиля принтера — создайте в разделе «Принтеры»") }; return }
        if (ui.value.busy) return
        val z = active()
        if (z == null) { update { it.copy(printError = "Нет зоны — сохраните хотя бы одну на шаге «Этикетка»") }; return }
        if (ui.value.code.isBlank()) { update { it.copy(printError = "Пустой код — нечего печатать") }; return }
        update { it.copy(busy = true, printMsg = null, printError = null) }
        viewModelScope.launch {
            try {
                val r = templateFor(z) ?: throw IllegalStateException("не удалось построить шаблон зоны")
                val bmp = LabelGenerator.generateLayout(r.first, ui.value.code, ui.value.name, dpi = LabelMath.DPI, attrs = currentAttrs())
                    ?: throw IllegalStateException("не удалось отрисовать этикетку")
                val (oxMm, oyMm) = LabelGrid.regionOrigin(spec, r.second)
                val res = PrintManager.printBitmap(
                    p, bmp, Color.BLACK, Color.WHITE,
                    offsetXpx = LabelMath.px(oxMm),
                    offsetYpx = LabelMath.px(oyMm),
                    widthMm = r.first.width_mm
                )
                val e = res.exceptionOrNull()
                when {
                    e == null -> {
                        markSubjectLabelled()
                        update { it.copy(printMsg = "Отправлено на печать: ${PrintManager.describe(p)}") }
                    }
                    else -> update { it.copy(printError = "Не удалось напечатать: ${e.message}") }
                }
            } catch (e: Exception) {
                update { it.copy(printError = e.message ?: "Ошибка печати") }
            } finally {
                update { it.copy(busy = false) }
            }
        }
    }

    /** Тестовая печать демо-кода в активной зоне. */
    fun printTest() {
        if (ui.value.step != 1) return
        val p = currentPrinter()
        if (p == null) { update { it.copy(printError = "Нет профиля принтера — создайте в разделе «Принтеры»") }; return }
        if (ui.value.busy) return
        val z = active() ?: return
        update { it.copy(busy = true, printMsg = null, printError = null) }
        viewModelScope.launch {
            try {
                val r = templateFor(z) ?: throw IllegalStateException("не удалось построить шаблон зоны")
                val code = ui.value.code.ifBlank { "DEMO-123" }
                val name = ui.value.name.ifBlank { "Демо-вещь" }
                val bmp = LabelGenerator.generateLayout(r.first, code, name, dpi = LabelMath.DPI)
                    ?: throw IllegalStateException("не удалось отрисовать этикетку")
                val (oxMm, oyMm) = LabelGrid.regionOrigin(spec, r.second)
                val res = PrintManager.printBitmap(
                    p, bmp, Color.BLACK, Color.WHITE,
                    offsetXpx = LabelMath.px(oxMm),
                    offsetYpx = LabelMath.px(oyMm),
                    widthMm = r.first.width_mm
                )
                val e = res.exceptionOrNull()
                when {
                    e == null -> update { it.copy(printMsg = "Тестовая полоска отправлена ($code)") }
                    else -> update { it.copy(printError = "Не удалось напечатать: ${e.message}") }
                }
            } catch (e: Exception) {
                update { it.copy(printError = e.message ?: "Ошибка печати") }
            } finally {
                update { it.copy(busy = false) }
            }
        }
    }

    /** Пустая полоска высотой [mm] — для подстройки смещения ленты. */
    fun printBlankStrip(mm: Int) {
        val p = currentPrinter()
        if (p == null) { update { it.copy(printError = "Нет профиля принтера — создайте в разделе «Принтеры»") }; return }
        if (ui.value.busy) return
        update { it.copy(busy = true, printMsg = null, printError = null) }
        viewModelScope.launch {
            try {
                val wpx = LabelMath.px(ui.value.sizeW.toDoubleOrNull() ?: 58.0)
                val hpx = LabelMath.px(mm.toDouble())
                val bmp = Bitmap.createBitmap(wpx, hpx, Bitmap.Config.ARGB_8888)
                Canvas(bmp).drawColor(Color.WHITE)
                val res = PrintManager.printBitmap(
                    p, bmp, Color.BLACK, Color.WHITE,
                    widthMm = ui.value.sizeW.toDoubleOrNull() ?: 58.0
                )
                val e = res.exceptionOrNull()
                when {
                    e == null -> update { it.copy(printMsg = "Напечатана пустая полоска ${mm} мм — проверьте смещение и вернитесь") }
                    else -> update { it.copy(printError = "Не удалось напечатать: ${e.message}") }
                }
            } catch (e: Exception) {
                update { it.copy(printError = e.message ?: "Ошибка печати") }
            } finally {
                update { it.copy(busy = false) }
            }
        }
    }

    /**
     * Батч-печать: каждая заполненная зона печатает свою вещь в своей области листа.
     * Собираем один растр на весь лист (зоны не пересекаются) и отправляем одним кадром —
     * так позиционирование работает и для TSC, и для ESC/POS. Пустые зоны пропускаем.
     */
    fun printSheet() {
        val p = currentPrinter()
        if (p == null) { update { it.copy(printError = "Нет профиля принтера — создайте в разделе «Принтеры»") }; return }
        if (ui.value.busy) return
        if (filledZoneCount() == 0) { update { it.copy(printError = "Зоны пусты — добавьте вещи (кнопка «Добавить вещь»)") }; return }
        update { it.copy(busy = true, printMsg = null, printError = null) }
        viewModelScope.launch {
            // Зона + шаблон/область + вещь для печати.
            data class Job(val tmpl: LabelTemplateEntity, val region: GridRegion, val item: ItemEntity)
            try {
                val jobs = mutableListOf<Job>()
                val skipped = mutableListOf<String>()
                for (z in ui.value.zones) {
                    val id = z.itemId
                    if (id == null) continue
                    val item = Deps.items.byId(id)
                    if (item == null) { skipped += "${z.name}: вещь не найдена"; continue }
                    val pair = templateFor(z)
                    if (pair == null) { skipped += "${z.name}: нет области зоны (пустые координаты)"; continue }
                    jobs += Job(pair.first, pair.second, item)
                }
                if (jobs.isEmpty()) throw IllegalStateException(skipped.joinToString("; ").ifBlank { "нет ни одной заполненной зоны" })

                // Цвета из базового шаблона (логика как в PrintManager.printLabel).
                val base = ui.value.template ?: ui.value.templates.firstOrNull()
                val fg = LabelGenerator.parseColor(base?.text_color ?: "#000000")
                val bg = LabelGenerator.parseColor(base?.bg_color ?: "#FFFFFF")
                val dark = if (base?.invert == true) bg else fg
                val light = if (base?.invert == true) fg else bg

                // Размер листа — покрывает все области зон (ширина — не меньше бумаги).
                val sheetW = maxOf(p.paper_width_mm, jobs.maxOf {
                    LabelGrid.regionOrigin(spec, it.region).first + LabelGrid.regionMm(spec, it.region).first
                })
                val sheetH = jobs.maxOf {
                    LabelGrid.regionOrigin(spec, it.region).second + LabelGrid.regionMm(spec, it.region).second
                }
                val sheet = Bitmap.createBitmap(
                    LabelMath.px(sheetW).coerceAtLeast(32),
                    LabelMath.px(sheetH).coerceAtLeast(16),
                    Bitmap.Config.ARGB_8888
                )
                val canvas = Canvas(sheet)
                canvas.drawColor(light)

                val printedIds = mutableListOf<String>()
                for (job in jobs) {
                    val bmp = LabelGenerator.generateLayout(
                        job.tmpl, job.item.code, job.item.name,
                        dpi = LabelMath.DPI, attrs = AttrJson.toMap(job.item.attributes)
                    )
                    if (bmp != null) {
                        val (oxMm, oyMm) = LabelGrid.regionOrigin(spec, job.region)
                        canvas.drawBitmap(bmp, LabelMath.px(oxMm).toFloat(), LabelMath.px(oyMm).toFloat(), null)
                        printedIds += job.item.id
                    }
                }
                if (printedIds.isEmpty()) throw IllegalStateException("не удалось отрисовать ни одну этикетку")

                val res = PrintManager.printBitmap(p, sheet, dark, light, widthMm = sheetW)
                val e = res.exceptionOrNull()
                when {
                    e == null -> {
                        for (id in printedIds) Deps.items.markLabelled(id)
                        // Лист напечатан: очищаем назначения и обновляем очередь unlabeled.
                        update { cur -> cur.copy(zones = cur.zones.map { z -> z.copy(itemId = null) }) }
                        loadUnlabelled()
                        val skipNote = if (skipped.isEmpty()) "" else " Пропущено: " + skipped.joinToString("; ")
                        update { it.copy(printMsg = "Отправлено на печать: ${printedIds.size} вещь(ей) — ${PrintManager.describe(p)}.$skipNote") }
                    }
                    else -> update { it.copy(printError = "Не удалось напечатать: ${e.message}") }
                }
            } catch (e: Exception) {
                update { it.copy(printError = e.message ?: "Ошибка печати") }
            } finally {
                update { it.copy(busy = false) }
            }
        }
    }

    /** Сохранить все зоны как шаблоны (с размером и смещением на листе). */
    fun saveZones() {
        val u = ui.value
        val base = u.template ?: u.templates.firstOrNull()
        if (base == null || u.zones.isEmpty() || u.busy) return
        update { it.copy(busy = true, printError = null) }
        viewModelScope.launch {
            try {
                val now = System.currentTimeMillis()
                val names = mutableListOf<String>()
                for (z in u.zones) {
                    val region = LabelGrid.regionOf(spec, z.cells) ?: continue
                    val (w, h) = LabelGrid.regionMm(spec, region)
                    val (oxMm, oyMm) = LabelGrid.regionOrigin(spec, region)
                    val name = "${z.name} ${w.toInt()}×${h.toInt()} мм"
                    val existing = Deps.db.labelTemplateDao().byName(name)
                    val row = existing?.copy(
                        width_mm = w, height_mm = h, margin_mm = 0.0,
                        layout_mode = z.layoutMode,
                        qr_count = z.qrCount,
                        qr_scale = z.qrScale.toDouble(),
                        font_size = maxOf(LabelGrid.MIN_FONT_PT, z.fontSize.toDouble()),
                        offset_x_mm = oxMm, offset_y_mm = oyMm,
                        updated_at = now, device_last_modified = Deps.deviceId
                    ) ?: base.copy(
                        id = newId(), name = name,
                        width_mm = w, height_mm = h, margin_mm = 0.0,
                        layout_mode = z.layoutMode,
                        qr_count = z.qrCount,
                        qr_scale = z.qrScale.toDouble(),
                        font_size = maxOf(LabelGrid.MIN_FONT_PT, z.fontSize.toDouble()),
                        offset_x_mm = oxMm, offset_y_mm = oyMm,
                        created_at = now, updated_at = now, device_last_modified = Deps.deviceId
                    )
                    Deps.db.labelTemplateDao().upsert(row)
                    names += name
                }
                update {
                    it.copy(
                        busy = false,
                        createdNames = names,
                        savedMsg = if (names.isEmpty()) "Не было зон для сохранения"
                                  else "Сохранено зон: ${names.size} (с размером и смещением на листе): " + names.joinToString(", ")
                    )
                }
            } catch (e: Exception) {
                update { it.copy(busy = false, printError = e.message ?: "Ошибка сохранения") }
            }
        }
    }

    init {
        viewModelScope.launch {
            Deps.db.printerDao().observeAll().collect { list ->
                update { cur ->
                    val defId = cur.gridPrinterId?.takeIf { id -> list.any { it.id == id } }
                        ?: list.firstOrNull { it.is_default }?.id
                        ?: list.firstOrNull()?.id
                    cur.copy(profiles = list, gridPrinterId = defId)
                }
            }
        }
        viewModelScope.launch {
            Deps.db.labelTemplateDao().observeAll().collect { list ->
                val cur = ui.value
                val t = list.firstOrNull { it.id == (templateId ?: cur.template?.id) } ?: list.firstOrNull()
                if (t == null) {
                    update { it.copy(templates = list, template = null) }
                    return@collect
                }
                update { cur ->
                    // Оверрайды инициализируем из шаблона один раз, при первом выборе.
                    if (cur.sizeW.isEmpty()) {
                        cur.copy(
                            templates = list,
                            template = t,
                            sizeW = t.width_mm.toInt().toString(),
                            sizeH = t.height_mm.toInt().toString(),
                            textPosition = t.text_position,
                            showText = t.show_text,
                            showNumber = t.show_number
                        )
                    } else {
                        cur.copy(templates = list, template = t)
                    }
                }
                regenerate()
            }
        }
        viewModelScope.launch {
            // Словарь атрибутов субъекта (scope = item/storage/location + глобальные *). Пикер «Атрибуты на этикетке».
            Deps.attributes.observeAll().collect { all ->
                update { it.copy(attrDefs = all.filter { d -> d.scope == entityKind || d.scope == "*" }) }
            }
        }
        if (entityId != null) {
            viewModelScope.launch {
                when (entityKind) {
                    "location" -> Deps.locations.byId(entityId)?.let { f ->
                        val name = f.name.ifBlank { f.label }.ifBlank { "Ящик" }
                        val code = f.label.ifBlank { newUlid() }
                        update {
                            it.copy(
                                subject = Subject("location", f.id, name, code, AttrJson.toMap(f.attributes)),
                                code = code,
                                name = name
                            )
                        }
                        regenerate()
                    }
                    "storage" -> Deps.storages.byId(entityId)?.let { f ->
                        val name = f.name.ifBlank { "Хранилище" }
                        val code = f.code.ifBlank { newUlid() }
                        update {
                            it.copy(
                                subject = Subject("storage", f.id, name, code, AttrJson.toMap(f.attributes)),
                                code = code,
                                name = name
                            )
                        }
                        regenerate()
                    }
                    else -> Deps.items.byId(entityId)?.let { found ->
                        // Код вещи → отсканированный → ULID (сохраняем, если вещь без кода).
                        val code = found.code.ifBlank {
                            ScanBus.lastCode?.also { ScanBus.lastCode = null }
                        }.orEmpty().ifBlank { newUlid() }
                        if (code != found.code) Deps.items.setCode(entityId, code)
                        update {
                            it.copy(
                                subject = Subject("item", found.id, found.name, code, AttrJson.toMap(found.attributes)),
                                code = code,
                                name = found.name
                            )
                        }
                        regenerate()
                    }
                }
            }
        }
        if (ui.value.code.isEmpty() && ui.value.subject == null) {
            val scanned = ScanBus.lastCode
            val code = scanned ?: newUlid()
            if (scanned != null) ScanBus.lastCode = null
            update { it.copy(code = code) }
            regenerate()
        }
    }

    class Factory(
        private val entityKind: String = "item",
        private val entityId: String?,
        private val templateId: String?
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            LabelsVm(entityKind, entityId, templateId) as T
    }
}

// ==================== Экран ====================

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelsScreen(nav: NavController, itemId: String, templateId: String, entityKind: String = "item") {
    val vm: LabelsVm = viewModel(factory = LabelsVm.Factory(entityKind, itemId, templateId))
    val ui by vm.ui.collectAsState()
    val ctx = LocalContext.current
    var showTemplatePicker by remember { mutableStateOf(false) }
    var showPrintPicker by remember { mutableStateOf(false) }

    val pickers = rememberPhotoPickers(
        onCaptured = { vm.onPhoto(it) },
        onPicked = { vm.onPhoto(it) }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (ui.subject == null) "Этикетка" else "Этикетка: ${ui.subject?.name}") },
                navigationIcon = {
                    IconButton(onClick = { if (ui.step > 0) vm.back() else nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { showTemplatePicker = true }) {
                        Text("Шаблон", style = MaterialTheme.typography.labelLarge)
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Stepper(ui.step)
            Spacer(Modifier.height(12.dp))

            when (ui.step) {
                0 -> {
                    OutlinedTextField(
                        value = ui.code,
                        onValueChange = { vm.setCode(it) },
                        label = { Text("Код (QR / штрихкод)") },
                        supportingText = { Text("Содержимое штрихкода. Пусто — присваивается ULID (26 символов)") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(Modifier.height(16.dp))
                    BasicSettingsCard(vm, ui)
                    Spacer(Modifier.height(16.dp))
                    AttributePickerCard(vm, ui)
                    Spacer(Modifier.height(16.dp))
                    // Предпросмотр одиночной этикетки + действия
                    SectionTitle("Предпросмотр")
                    val w = ui.sizeW.toDoubleOrNull() ?: ui.template?.width_mm ?: 58.0
                    val h = ui.sizeH.toDoubleOrNull() ?: ui.template?.height_mm ?: 40.0
                    ui.bitmap?.let { bmp ->
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .aspectRatio(bmp.width.toFloat() / bmp.height)
                                .padding(vertical = 8.dp)
                        ) {
                            LabelPreviewWithRulers(bitmap = bmp, widthMm = w, heightMm = h)
                        }
                    } ?: Card(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        Text("Выберите шаблон и введите код", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium)
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                        OutlinedButton(onClick = { vm.saveToGallery(ctx) }, enabled = ui.bitmap != null && !ui.busy, modifier = Modifier.weight(1f)) { Text("Сохранить") }
                        OutlinedButton(onClick = { vm.share(ctx) }, enabled = ui.bitmap != null && !ui.busy, modifier = Modifier.weight(1f)) { Text("Поделиться") }
                        OutlinedButton(onClick = { showPrintPicker = true }, enabled = ui.bitmap != null && !ui.busy, modifier = Modifier.weight(1f)) { Text("Печать") }
                    }
                    ui.savedMsg?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary) }
                    ui.printMsg?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary) }
                    ui.printError?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error) }
                    Spacer(Modifier.height(16.dp))
                    // Зоны (калибровка)
                    ZoneSetupCard(vm, ui, onShoot = { pickers.takePhoto() }, onPick = { pickers.pickFromGallery() })
                    Spacer(Modifier.height(16.dp))
                    Button(
                        onClick = { vm.next() },
                        enabled = ui.zones.isNotEmpty(),
                        modifier = Modifier.fillMaxWidth()
                    ) { Text("Далее: раскладка и печать") }
                    if (ui.zones.isEmpty()) {
                        Text(
                            "Сохраните хотя бы одну зону, чтобы перейти к раскладке.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                1 -> {
                    if (ui.zones.size > 1) {
                        Text("Зона для печати:", style = MaterialTheme.typography.bodyMedium)
                        Spacer(Modifier.height(4.dp))
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier.horizontalScroll(rememberScrollState())
                        ) {
                            ui.zones.forEachIndexed { i, z ->
                                FilterChip(
                                    selected = i == ui.activeZone,
                                    onClick = { vm.selectActiveZone(i) },
                                    label = { Text(z.name) }
                                )
                            }
                        }
                        Spacer(Modifier.height(8.dp))
                    }
                    // Вещи в зонах: одна зона — одна вещь. Заполняем все или часть и печатаем лист.
                    // Только для item-режима: у ящика/хранилища субъект один — сам объект.
                    if (vm.entityKind == "item") {
                        Card(Modifier.fillMaxWidth()) {
                            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                SectionTitle("Вещи в зонах")
                                ui.zones.forEachIndexed { i, z ->
                                    val it = z.itemId?.let { id -> ui.itemCache[id] }
                                    val isActive = i == ui.activeZone
                                    // Тап по строке выбирает зону: «Добавить вещь» пойдёт именно в неё.
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(if (isActive) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f) else ComposeColor.Transparent)
                                            .clickable { vm.selectActiveZone(i) }
                                    ) {
                                        Column(Modifier.weight(1f).padding(vertical = 6.dp)) {
                                            Text(
                                                z.name,
                                                style = MaterialTheme.typography.labelLarge,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                            Text(
                                                it?.name?.ifBlank { "Вещь" } ?: "пусто",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = if (it == null) MaterialTheme.colorScheme.onSurfaceVariant
                                                else MaterialTheme.colorScheme.onSurface,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        if (it != null) {
                                            TextButton(onClick = { vm.clearZoneItem(i) }) { Text("Снять") }
                                        }
                                        if (isActive) {
                                            Icon(
                                                Icons.Filled.Check,
                                                contentDescription = "Выбрано",
                                                tint = MaterialTheme.colorScheme.primary
                                            )
                                        }
                                    }
                                }
                                Text(
                                    "Добавлять вещь в зону: «${ui.zones.getOrNull(ui.activeZone)?.name ?: "—"}»",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    OutlinedButton(onClick = { vm.openAddDialog() }, modifier = Modifier.weight(1f)) {
                                        Text("Добавить вещь")
                                    }
                                    Button(
                                        onClick = { vm.printSheet() },
                                        enabled = !ui.busy && vm.filledZoneCount() > 0,
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Text("Печать листа (${vm.filledZoneCount()})")
                                    }
                                }
                            }
                        }
                        Spacer(Modifier.height(12.dp))
                    }
                    val z = ui.zones.getOrNull(ui.activeZone)
                    val zr = z?.let { LabelGrid.regionOf(vm.spec, it.cells) }
                    val zw = zr?.let { LabelGrid.regionMm(vm.spec, it).first } ?: 0.0
                    val zh = zr?.let { LabelGrid.regionMm(vm.spec, it).second } ?: 0.0
                    val mode = z?.layoutMode ?: "auto"
                    val qrCount = z?.qrCount ?: 1
                    val qrScale = z?.qrScale ?: 1f
                    val zoneFontSize = z?.fontSize ?: 12f
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("Раскладка: зона ${zw.toInt()}×${zh.toInt()} мм", style = MaterialTheme.typography.titleSmall)
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                FilterChip(selected = mode == "auto", onClick = { vm.setLayoutMode("auto") }, label = { Text("Авто по форме") })
                                FilterChip(selected = mode == "v", onClick = { vm.setLayoutMode("v") }, label = { Text("QR сверху") })
                                FilterChip(selected = mode == "h", onClick = { vm.setLayoutMode("h") }, label = { Text("QR сбоку") })
                            }
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                FilterChip(selected = qrCount == 1, onClick = { vm.setQrCount(1) }, label = { Text("1 код") })
                                FilterChip(selected = qrCount == 2, onClick = { vm.setQrCount(2) }, label = { Text("2 кода (вещь + репозиторий)") })
                            }
                            val maxQrMm = minOf(zw, zh).toInt()
                            if (maxQrMm > 10) {
                                val qrMm = (qrScale * maxQrMm).roundToInt().coerceIn(10, maxQrMm)
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
                            } else {
                                Text(
                                    "Зона меньше 10 мм — код будет напечатан в 10×10 мм и вылезет за зону.",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.error
                                )
                            }
                            Text("Шрифт: ${zoneFontSize.toInt()} pt", style = MaterialTheme.typography.bodyMedium)
                            Slider(
                                value = zoneFontSize,
                                onValueChange = { vm.setZoneFontSize(it) },
                                valueRange = 6f..24f,
                                steps = 17
                            )
                        }
                    }
                    Spacer(Modifier.height(12.dp))
                    // Предпросмотр зоны
                    ui.previewBmp?.let { bmp ->
                        SectionTitle("Предпросмотр зоны")
                        Box(
                            Modifier
                                .fillMaxWidth()
                                .aspectRatio(bmp.width.toFloat() / bmp.height)
                                .padding(vertical = 8.dp)
                        ) {
                            LabelPreviewWithRulers(bitmap = bmp, widthMm = zw, heightMm = zh)
                        }
                    } ?: Card(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        Text("Нет зоны для предпросмотра", modifier = Modifier.padding(16.dp), style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(Modifier.height(8.dp))
                    ui.savedMsg?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary) }
                    ui.printMsg?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary) }
                    ui.printError?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error) }
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { vm.quickPrint() }, enabled = !ui.busy, modifier = Modifier.fillMaxWidth()) {
                        Text("Быстрая печать (активная зона)")
                    }
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { vm.printTest() }, enabled = !ui.busy, modifier = Modifier.weight(1f)) { Text("Тестовая (DEMO)") }
                        OutlinedButton(onClick = { vm.printBlankStrip(5) }, enabled = !ui.busy, modifier = Modifier.weight(1f)) { Text("Протащить 5 мм") }
                    }
                    Spacer(Modifier.height(8.dp))
                    Button(onClick = { vm.saveZones() }, enabled = !ui.busy && ui.zones.isNotEmpty(), modifier = Modifier.fillMaxWidth()) {
                        Text("Сохранить зоны как шаблоны")
                    }
                    Spacer(Modifier.height(8.dp))
                    OutlinedButton(onClick = { vm.back() }, modifier = Modifier.fillMaxWidth()) {
                        Text("Назад: к зонам")
                    }
                }
            }
            Spacer(Modifier.height(8.dp))
            Text(
                "Сохранение — PNG в галерею; «Печать» — на 58-мм принтер (TCP/BT, ESC/POS или TSC); «Поделиться» — печать из стороннего приложения.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        if (showTemplatePicker) {
            TemplatePickerDialog(
                templates = ui.templates,
                currentId = ui.template?.id,
                onPick = { vm.setTemplate(it) },
                onManage = {
                    showTemplatePicker = false
                    nav.navigate("templates") { launchSingleTop = true }
                },
                onDismiss = { showTemplatePicker = false }
            )
        }
        if (showPrintPicker) {
            PrinterPickerDialog(
                profiles = ui.profiles,
                onPick = { p ->
                    vm.print(p)
                    showPrintPicker = false
                },
                onManage = {
                    showPrintPicker = false
                    nav.navigate("printers") { launchSingleTop = true }
                },
                onDismiss = { showPrintPicker = false }
            )
        }
        if (ui.showSaveDialog) {
            SaveTemplateDialog(
                mode = ui.saveMode,
                templateName = ui.template?.name ?: "",
                saveAsName = ui.saveAsName,
                onNameChange = { vm.setSaveAsName(it) },
                onConfirm = { vm.saveCurrentSettings() },
                onDismiss = { vm.closeSaveDialog() }
            )
        }
        if (ui.showAddDialog) {
            AddItemDialog(
                items = ui.unlabelled,
                activeZone = ui.zones.getOrNull(ui.activeZone),
                onPick = { vm.assignItemToActiveZone(it.id) },
                onDismiss = { vm.closeAddDialog() }
            )
        }
    }
}

// ==================== Вспомогательные composables ====================

@Composable
private fun Stepper(step: Int) {
    val steps = listOf("Этикетка и зоны", "Раскладка и печать")
    Row(Modifier.fillMaxWidth()) {
        steps.forEachIndexed { i, label ->
            val active = i == step
            val done = i < step
            val color = if (active || done) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
            Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    if (done) "✓" else (i + 1).toString(),
                    style = MaterialTheme.typography.labelLarge,
                    color = color
                )
                Text(label, style = MaterialTheme.typography.labelSmall, color = color, maxLines = 1)
            }
        }
    }
}

@Composable
private fun BasicSettingsCard(vm: LabelsVm, ui: LabelsVm.Ui) {
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp)) {
            Text("Настройки печати", style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = ui.sizeW,
                    onValueChange = { vm.setSize(it, ui.sizeH) },
                    label = { Text("Ширина, мм") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = ui.sizeH,
                    onValueChange = { vm.setSize(ui.sizeW, it) },
                    label = { Text("Высота, мм") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = { vm.setTextPosition("top") }, modifier = Modifier.weight(1f)) { Text("Над кодом", style = MaterialTheme.typography.labelLarge) }
                OutlinedButton(onClick = { vm.setTextPosition("bottom") }, modifier = Modifier.weight(1f)) { Text("Под кодом", style = MaterialTheme.typography.labelLarge) }
            }
            Spacer(Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = ui.fontSize,
                    onValueChange = { vm.setFontSize(it) },
                    label = { Text("Шрифт, pt") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = ui.marginMm,
                    onValueChange = { vm.setMarginMm(it) },
                    label = { Text("Поля, мм") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            Spacer(Modifier.height(4.dp))
            Text("Формат кода", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Spacer(Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                LabelGenerator.FORMATS.take(5).forEach { fmt ->
                    val selected = ui.format == fmt || (ui.format.isEmpty() && ui.template?.format == fmt)
                    OutlinedButton(
                        onClick = { vm.setFormat(fmt) },
                        modifier = Modifier.weight(1f),
                        colors = if (selected) ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                else ButtonDefaults.outlinedButtonColors()
                    ) { Text(fmt, style = MaterialTheme.typography.labelSmall) }
                }
            }
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = ui.showText, onCheckedChange = vm::setShowText)
                Text("Надписи на этикетке", style = MaterialTheme.typography.bodyMedium)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = ui.showNumber, onCheckedChange = vm::setShowNumber)
                Text("Номер объекта (код)", style = MaterialTheme.typography.bodyMedium)
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = { vm.resetOverrides() }, modifier = Modifier.weight(1f)) { Text("Сбросить") }
                TextButton(onClick = { vm.openSaveDialog(LabelsVm.SaveMode.OVERWRITE) }, modifier = Modifier.weight(1f)) { Text("Перезаписать") }
                TextButton(onClick = { vm.openSaveDialog(LabelsVm.SaveMode.SAVE_AS) }, modifier = Modifier.weight(1f)) { Text("Как новый") }
            }
            TextButton(onClick = { vm.openSaveDialog(LabelsVm.SaveMode.SET_DEFAULT) }, modifier = Modifier.fillMaxWidth()) {
                Text("Сделать основным шаблоном")
            }
        }
    }
}

/** Выбор атрибутов вещи, которые печатаются под кодом (из словаря scope=item). */
@Composable
private fun AttributePickerCard(vm: LabelsVm, ui: LabelsVm.Ui) {
    val defs = ui.attrDefs
    if (defs.isEmpty()) return
    val selected = vm.selectedAttrKeys()
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp)) {
            Text("Атрибуты на этикетке", style = MaterialTheme.typography.titleSmall)
            Spacer(Modifier.height(2.dp))
            Text(
                "Какие атрибуты вещи печатать под кодом. Сохраняется в шаблон.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(4.dp))
            defs.forEach { def ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = def.key in selected, onCheckedChange = { vm.toggleAttr(def.key) })
                    Text(def.label, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

/** Предпросмотр с линейками сверху (ширина) и слева (высота). */
@Composable
private fun LabelPreviewWithRulers(bitmap: Bitmap, widthMm: Double, heightMm: Double) {
    val rulerW = 16.dp
    val rulerH = 16.dp
    val step = when { widthMm <= 30 -> 5.0; widthMm <= 60 -> 10.0; else -> 20.0 }
    Row(verticalAlignment = Alignment.Top) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.heightIn((heightMm / 25.4 * 24.0).toFloat().dp)) {
            Text(
                "${heightMm.toInt()}\nмм",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Column(modifier = Modifier.fillMaxWidth().height(rulerH), verticalArrangement = Arrangement.Center) {
                HorizontalRuler(widthMm = widthMm, step = step)
            }
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(bitmap.width.toFloat() / bitmap.height)
                    .border(1.dp, MaterialTheme.colorScheme.outline),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}

@Composable
private fun HorizontalRuler(widthMm: Double, step: Double) {
    Box(modifier = Modifier.fillMaxWidth().height(16.dp).background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f))) {
        val total = (widthMm / step).toInt()
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 2.dp), horizontalArrangement = Arrangement.SpaceBetween) {
            (0..total).forEach { i ->
                Text(
                    text = (i * step).toInt().toString(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 1.dp)
                )
            }
        }
    }
}

@Composable
private fun SaveTemplateDialog(
    mode: LabelsVm.SaveMode,
    templateName: String,
    saveAsName: String,
    onNameChange: (String) -> Unit,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                when (mode) {
                    LabelsVm.SaveMode.OVERWRITE -> "Перезаписать шаблон?"
                    LabelsVm.SaveMode.SAVE_AS -> "Сохранить как новый шаблон"
                    LabelsVm.SaveMode.SET_DEFAULT -> "Сделать основным шаблоном?"
                }
            )
        },
        text = {
            Column {
                Text(
                    when (mode) {
                        LabelsVm.SaveMode.OVERWRITE -> "Текущий шаблон «$templateName» будет обновлён новыми настройками."
                        LabelsVm.SaveMode.SAVE_AS -> "Введите название для нового шаблона:"
                        LabelsVm.SaveMode.SET_DEFAULT -> "Текущие настройки будут сохранены как основной шаблон по умолчанию."
                    },
                    style = MaterialTheme.typography.bodyMedium
                )
                if (mode == LabelsVm.SaveMode.SAVE_AS) {
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = saveAsName,
                        onValueChange = onNameChange,
                        label = { Text("Название") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(if (mode == LabelsVm.SaveMode.SAVE_AS) "Сохранить" else "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

/** Выбор вещи из очереди «без этикетки» для назначения в активную зону. */
@Composable
private fun AddItemDialog(
    items: List<ItemEntity>,
    activeZone: LabelsVm.Zone?,
    onPick: (ItemEntity) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text("Добавить вещь" + (activeZone?.let { " → зона «${it.name}»" } ?: ""))
        },
        text = {
            if (items.isEmpty()) {
                Text(
                    "Нет вещей без напечатанной этикетки. Создайте вещь или печатайте заново.",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                Column {
                    items.forEach { item ->
                        TextButton(onClick = { onPick(item) }, modifier = Modifier.fillMaxWidth()) {
                            Column(Modifier.fillMaxWidth()) {
                                Text(
                                    item.name.ifBlank { "Вещь" },
                                    style = MaterialTheme.typography.bodyLarge,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                                if (item.code.isNotBlank()) {
                                    Text(
                                        item.code,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}
