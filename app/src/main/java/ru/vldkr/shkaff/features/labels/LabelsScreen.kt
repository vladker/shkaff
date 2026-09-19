package ru.vldkr.shkaff.features.labels

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
import org.json.JSONObject
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.data.printer.UsbPermission
import ru.vldkr.shkaff.data.printer.UsbPermissionPendingException
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.labels.GridRegion
import ru.vldkr.shkaff.domain.labels.GridSpec
import ru.vldkr.shkaff.domain.labels.LabelGrid
import ru.vldkr.shkaff.domain.printer.LabelMath
import ru.vldkr.shkaff.features.printers.PrinterPickerDialog
import ru.vldkr.shkaff.ui.components.ItemCard
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
        // Кэш вещей для пикера и назначенных в зоны (id → сущность): имена остаются видимыми.
        val itemCache: Map<String, ItemEntity> = emptyMap(),
        // — пикер вещи для зоны (каталог + поиск) —
        val pickerZone: Int? = null,
        val catalog: List<ItemEntity> = emptyList(),
        val catalogQuery: String = ""
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
        applySavedAttrs()
        regenerate()
    }

    fun setCode(c: String) {
        update { it.copy(code = c, bitmap = null, savedMsg = null) }
        regenerate()
    }
    fun setSize(w: String, h: String) {
        update { it.copy(sizeW = w, sizeH = h, bitmap = null, savedMsg = null) }
        persistSettings()
        regenerate()
    }
    fun setTextPosition(p: String) {
        if (p != "top" && p != "bottom") return
        update { it.copy(textPosition = p, bitmap = null, savedMsg = null) }
        persistSettings()
        regenerate()
    }
    fun setShowText(v: Boolean) {
        update { it.copy(showText = v, bitmap = null, savedMsg = null) }
        persistSettings()
        regenerate()
    }
    fun setShowNumber(v: Boolean) {
        update { it.copy(showNumber = v, bitmap = null, savedMsg = null) }
        persistSettings()
        regenerate()
    }
    fun setFontSize(s: String) {
        update { it.copy(fontSize = s, bitmap = null, savedMsg = null) }
        persistSettings()
        regenerate()
    }
    fun setMarginMm(m: String) {
        update { it.copy(marginMm = m, bitmap = null, savedMsg = null) }
        persistSettings()
        regenerate()
    }
    fun setFormat(f: String) {
        update { it.copy(format = f, bitmap = null, savedMsg = null) }
        persistSettings()
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
        persistAttrs()
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
        persistSettings()
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

    // ==================== Сохранённые настройки (schema_meta, per вид/категория) ====================

    private fun metaGet(key: String): String? = Deps.db.metaDao().get(key)

    private fun metaPut(key: String, value: String) {
        Deps.db.metaDao().upsert(SchemaMetaEntity(key, value))
    }

    /** Категория вещи (атрибут «category»; «*» если нет) — настройки хранятся per категория. */
    fun subjectCategory(): String {
        val s = ui.value.subject
        if (s == null || s.kind != "item") return "*"
        return (s.attrs["category"] ?: "*").ifBlank { "*" }
    }

    /** Кандидаты атрибутов: словарь по scope, отфильтрованный по категории субъекта («*» — все). */
    fun candidateAttrs(): List<AttributeDefEntity> {
        val cat = subjectCategory()
        return ui.value.attrDefs
            .filter { d -> d.category == "*" || d.category == cat }
            .sortedBy { it.sort_order }
    }

    /** Восстановить набор атрибутов печати, сохранённый для вида+категории (в template.label_attrs). */
    fun applySavedAttrs() {
        val saved = metaGet("labelAttrs:$entityKind:${subjectCategory()}") ?: return
        val keys = AttrJson.parseOptions(saved)
        if (keys.isEmpty()) return
        val arr = JSONArray()
        keys.forEach { arr.put(it) }
        val json = arr.toString()
        update {
            val t = it.template ?: return@update it
            it.copy(template = t.copy(label_attrs = json))
        }
    }

    /** Сохранить текущий набор атрибутов печати для вида+категории. */
    fun persistAttrs() {
        val keys = ui.value.template?.let { AttrJson.parseOptions(it.label_attrs) } ?: return
        val arr = JSONArray()
        keys.forEach { arr.put(it) }
        metaPut("labelAttrs:$entityKind:${subjectCategory()}", arr.toString())
    }

    /** Настройки печати восстановлены — не переопределять пользовательские изменения. */
    private var settingsRestored = false

    /** Восстановить настройки печати, сохранённые для вида (размер, сетка, принтер) — один раз за сессию. */
    fun applySavedSettings() {
        if (settingsRestored) return
        settingsRestored = true
        val json = metaGet("labelSettings:$entityKind") ?: return
        val o = try { JSONObject(json) } catch (e: Exception) { return }
        update { it.copy(
            sizeW = if (o.has("sizeW")) o.optString("sizeW") else it.sizeW,
            sizeH = if (o.has("sizeH")) o.optString("sizeH") else it.sizeH,
            textPosition = if (o.has("textPosition")) o.optString("textPosition") else it.textPosition,
            showText = if (o.has("showText")) o.optBoolean("showText") else it.showText,
            showNumber = if (o.has("showNumber")) o.optBoolean("showNumber") else it.showNumber,
            fontSize = if (o.has("fontSize")) o.optString("fontSize") else it.fontSize,
            marginMm = if (o.has("marginMm")) o.optString("marginMm") else it.marginMm,
            format = if (o.has("format")) o.optString("format") else it.format,
            gridCell = if (o.has("gridCell")) o.optString("gridCell") else it.gridCell,
            gridMargin = if (o.has("gridMargin")) o.optString("gridMargin") else it.gridMargin,
            gridPrinterId = if (o.has("gridPrinterId")) o.optString("gridPrinterId").ifBlank { null } else it.gridPrinterId
        ) }
    }

    /** Сохранить текущие настройки печати для вида в schema_meta. */
    fun persistSettings() {
        val u = ui.value
        val o = JSONObject()
        o.put("sizeW", u.sizeW)
        o.put("sizeH", u.sizeH)
        o.put("textPosition", u.textPosition)
        o.put("showText", u.showText)
        o.put("showNumber", u.showNumber)
        o.put("fontSize", u.fontSize)
        o.put("marginMm", u.marginMm)
        o.put("format", u.format)
        o.put("gridCell", u.gridCell)
        o.put("gridMargin", u.gridMargin)
        o.put("gridPrinterId", u.gridPrinterId ?: JSONObject.NULL)
        metaPut("labelSettings:$entityKind", o.toString())
    }

    // ==================== Вещи в зонах (батч: одна зона — одна вещь) ====================

    /** Буква зоны (A, B, C, …) — для визуального листа. */
    fun zoneLetter(i: Int): String = ('A' + (i % 26)).toString()

    /** Вещь, назначенная в зону [i] (null — зона пуста). Из кэша, без запроса к БД. */
    fun zoneItem(i: Int): ItemEntity? {
        val id = ui.value.zones.getOrNull(i)?.itemId ?: return null
        return ui.value.itemCache[id]
    }

    /** Размер канваса (мм) — размер указанной этикетки (sizeW×sizeH); зоны лежат внутри неё. */
    fun sheetSize(): Pair<Double, Double> {
        val u = ui.value
        return (u.sizeW.toDoubleOrNull() ?: 58.0).coerceIn(20.0, 100.0) to
            (u.sizeH.toDoubleOrNull() ?: 40.0).coerceIn(20.0, 100.0)
    }

    /** Открыть пикер вещи для зоны [i]. */
    fun openZonePicker(i: Int) {
        if (ui.value.step != 1) return
        update { it.copy(pickerZone = i) }
        loadCatalog(ui.value.catalogQuery)
    }

    fun closePicker() {
        update { it.copy(pickerZone = null) }
    }

    /** Поиск по каталогу в пикере. */
    fun setCatalogQuery(q: String) {
        update { it.copy(catalogQuery = q) }
        loadCatalog(q)
    }

    /** Каталог пикера: свежие вещи (или результаты поиска) + кэш для отображения в зонах. */
    private fun loadCatalog(q: String) {
        viewModelScope.launch {
            val list = if (q.isBlank()) Deps.items.recentCreated(200)
            else Deps.items.search(q).take(200)
            val cache = ui.value.itemCache.toMutableMap()
            list.forEach { cache[it.id] = it }
            update { it.copy(catalog = list, itemCache = cache) }
        }
    }

    /** Назначить вещь зоне [i] (одна зона — одна вещь; повторный выбор заменяет). */
    fun assignItemToZone(i: Int, itemId: String) {
        if (ui.value.step != 1) return
        val list = ui.value.zones
        if (!list.indices.contains(i)) return
        val zones = list.toMutableList()
        zones[i] = list[i].copy(itemId = itemId)
        val cache = ui.value.itemCache.toMutableMap()
        ui.value.catalog.firstOrNull { it.id == itemId }?.let { cache[it.id] = it }
        val isActive = i == ui.value.activeZone
        update { it.copy(zones = zones, itemCache = cache, pickerZone = null) }
        if (isActive) refreshPreview()
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
    fun selectGridPrinter(id: String) { update { it.copy(gridPrinterId = id) }; persistSettings() }
    fun setGridCell(s: String) { update { it.copy(gridCell = s) }; persistSettings() }
    fun setGridMargin(s: String) { update { it.copy(gridMargin = s) }; persistSettings() }

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
        // Вещь зоны (если назначена) — иначе субъект экрана или демо.
        val item = zoneItem(ui.value.activeZone)
        val code = item?.code?.ifBlank { null } ?: ui.value.code.ifBlank { "DEMO-123" }
        val name = item?.name?.ifBlank { null } ?: ui.value.name.ifBlank { "Демо-вещь" }
        val attrs = item?.let { AttrJson.toMap(it.attributes) } ?: currentAttrs()
        val bmp = LabelGenerator.generateLayout(r.first, code, name, dpi = 150, attrs = attrs)
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
        // Вещь активной зоны (если назначена) — иначе субъект экрана.
        val item = zoneItem(ui.value.activeZone)
        val code = item?.code?.ifBlank { null } ?: ui.value.code
        if (code.isBlank()) { update { it.copy(printError = "Пустой код — нечего печатать") }; return }
        val name = item?.name ?: ui.value.name
        val attrs = item?.let { AttrJson.toMap(it.attributes) } ?: currentAttrs()
        update { it.copy(busy = true, printMsg = null, printError = null) }
        viewModelScope.launch {
            try {
                val r = templateFor(z) ?: throw IllegalStateException("не удалось построить шаблон зоны")
                val bmp = LabelGenerator.generateLayout(r.first, code, name, dpi = LabelMath.DPI, attrs = attrs)
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
                        // Назначенная вещь — отмечена напечатанной; иначе — субъект экрана.
                        if (item != null) Deps.items.markLabelled(item.id) else markSubjectLabelled()
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
                        // Лист напечатан: очищаем назначения зон.
                        update { cur -> cur.copy(zones = cur.zones.map { z -> z.copy(itemId = null) }) }
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
                // Сохранённые настройки (размер, сетка, принтер) — один раз за сессию.
                applySavedSettings()
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
                // Сохранённые настройки/атрибуты (если субъект уже известен) — перед перерисовкой.
                applySavedSettings()
                applySavedAttrs()
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
                        applySavedAttrs()
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
                        applySavedAttrs()
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
                        applySavedAttrs()
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
            applySavedAttrs()
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
                    // Вещи в зонах: визуальный лист — зона = её область на бумаге (буквы A, B, C…).
                    // Только для item-режима: у ящика/хранилища субъект один — сам объект.
                    if (vm.entityKind == "item") {
                        SheetBuilder(vm, ui)
                        Spacer(Modifier.height(8.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            OutlinedButton(onClick = { vm.openZonePicker(ui.activeZone) }, modifier = Modifier.weight(1f)) {
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
        ui.pickerZone?.let { zi ->
            ZonePickerDialog(
                vm = vm,
                ui = ui,
                zoneIndex = zi,
                onDismiss = { vm.closePicker() }
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
    // Выбранные атрибуты — в порядке шаблона (label_attrs), без дублей.
    val selected = ui.template?.let { AttrJson.parseOptions(it.label_attrs) } ?: emptyList()
    var showAddAttr by remember { mutableStateOf(false) }
    Card(Modifier.fillMaxWidth()) {
        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text("Атрибуты на этикетке", style = MaterialTheme.typography.titleSmall)
            Text(
                "Какие атрибуты вещи печатать под кодом. Сохраняется по категории вещи и восстанавливается при следующем визите.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            selected.forEach { key ->
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        ui.attrDefs.firstOrNull { it.key == key }?.label ?: key,
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.weight(1f),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    IconButton(onClick = { vm.toggleAttr(key) }, modifier = Modifier.size(32.dp)) {
                        Icon(Icons.Filled.Close, contentDescription = "Убрать", modifier = Modifier.size(16.dp))
                    }
                }
            }
            if (selected.isEmpty()) {
                Text(
                    "Атрибуты не выбраны — на этикетке будет только код.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            TextButton(onClick = { showAddAttr = true }) { Text("Добавить атрибут") }
        }
    }
    if (showAddAttr) {
        val selectedKeys = selected.toSet()
        AddAttributeDialog(
            candidates = vm.candidateAttrs().filter { it.key !in selectedKeys },
            onPick = { vm.toggleAttr(it.key) },
            onDismiss = { showAddAttr = false }
        )
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

/** Пульсация 0.35..1.0 — для подсветки активной зоны на визуальном листе. */
@Composable
private fun rememberGlow(): Float {
    val transition = rememberInfiniteTransition(label = "zoneGlow")
    return transition.animateFloat(
        initialValue = 0.35f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 900),
            repeatMode = RepeatMode.Reverse
        ),
        label = "zoneGlow"
    ).value
}

/**
 * Визуальный канвас этикетки: канвас = размер указанной этикетки (sizeW×sizeH),
 * зоны лежат внутри по своим областям (как при печати). Пропорции — реальные,
 * на экране канвас вписан в ширину (без скролла). Буквы A, B, C… — подсказка
 * «вещь для зоны B». Тап по зоне — выбор вещи в неё.
 */
@Composable
private fun SheetBuilder(vm: LabelsVm, ui: LabelsVm.Ui) {
    val (sheetW, sheetH) = vm.sheetSize()
    val ratio = (sheetW / sheetH).toFloat()
    val zonesCount = ui.zones.size
    val zonesHint = if (zonesCount > 1) "зоны ${vm.zoneLetter(0)}..${vm.zoneLetter(zonesCount - 1)}"
    else if (zonesCount == 1) "зона ${vm.zoneLetter(0)}"
    else "зоны не заданы"
    Card(
        Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.25f))
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                "Этикетка ${sheetW.toInt()}×${sheetH.toInt()} мм — $zonesHint",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(ratio)
                    .clip(RoundedCornerShape(8.dp))
                    .background(MaterialTheme.colorScheme.surface)
                    .border(1.dp, MaterialTheme.colorScheme.outline, RoundedCornerShape(8.dp))
            ) {
                BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
                    val maxW = constraints.maxWidth
                    val maxH = constraints.maxHeight
                    if (maxW > 0 && maxH > 0) {
                        val scale = minOf(maxW / sheetW, maxH / sheetH)
                        ui.zones.forEachIndexed { i, z ->
                            val region = LabelGrid.regionOf(vm.spec, z.cells) ?: return@forEachIndexed
                            val (ox, oy) = LabelGrid.regionOrigin(vm.spec, region)
                            val (zw, zh) = LabelGrid.regionMm(vm.spec, region)
                            ZoneBlock(
                                vm = vm,
                                index = i,
                                zone = z,
                                active = i == ui.activeZone,
                                modifier = Modifier
                                    .offset(x = (ox * scale).dp, y = (oy * scale).dp)
                                    .size(width = (zw * scale).dp, height = (zh * scale).dp)
                                    .padding(3.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

/** Зона на визуальном листе: буква, вещь (или «пусто»), «✕» и «+». */
@Composable
private fun ZoneBlock(
    vm: LabelsVm,
    index: Int,
    zone: LabelsVm.Zone,
    active: Boolean,
    modifier: Modifier
) {
    val item = vm.zoneItem(index)
    val glow = rememberGlow()
    val border = if (active) MaterialTheme.colorScheme.primary.copy(alpha = glow)
    else MaterialTheme.colorScheme.outlineVariant
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
            .background(
                if (active) MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)
                else ComposeColor.Transparent
            )
            .border(1.dp, border, RoundedCornerShape(6.dp))
            .clickable { vm.openZonePicker(index) }
    ) {
        Column(Modifier.padding(4.dp), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    vm.zoneLetter(index),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.weight(1f))
                IconButton(
                    onClick = { vm.clearZoneItem(index) },
                    enabled = item != null,
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(Icons.Filled.Close, contentDescription = "Убрать вещь", modifier = Modifier.size(16.dp))
                }
                IconButton(onClick = { vm.openZonePicker(index) }, modifier = Modifier.size(28.dp)) {
                    Icon(Icons.Filled.Add, contentDescription = "Добавить вещь", modifier = Modifier.size(16.dp))
                }
            }
            Text(
                item?.name?.ifBlank { "Вещь" } ?: "пусто",
                style = MaterialTheme.typography.bodySmall,
                color = if (item == null) MaterialTheme.colorScheme.onSurfaceVariant
                else MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

/** Пикер вещи для зоны: поиск + каталог (свежие вещи первыми). Выбор — назначение в зону. */
@Composable
private fun ZonePickerDialog(
    vm: LabelsVm,
    ui: LabelsVm.Ui,
    zoneIndex: Int,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Вещь для зоны ${vm.zoneLetter(zoneIndex)}") },
        text = {
            Column {
                OutlinedTextField(
                    value = ui.catalogQuery,
                    onValueChange = { vm.setCatalogQuery(it) },
                    label = { Text("Поиск") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.height(8.dp))
                if (ui.catalog.isEmpty()) {
                    Text("Ничего не найдено.", style = MaterialTheme.typography.bodyMedium)
                } else {
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        ui.catalog.forEach { item ->
                            ItemCard(
                                item = item,
                                locationLabel = null,
                                onClick = { vm.assignItemToZone(zoneIndex, item.id) }
                            )
                        }
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("Закрыть") } }
    )
}

/** Добавление атрибута на этикетку: словарь по scope+категории без уже выбранных. */
@Composable
private fun AddAttributeDialog(
    candidates: List<AttributeDefEntity>,
    onPick: (AttributeDefEntity) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Добавить атрибут") },
        text = {
            if (candidates.isEmpty()) {
                Text(
                    "Все подходящие атрибуты уже добавлены.",
                    style = MaterialTheme.typography.bodyMedium
                )
            } else {
                Column {
                    candidates.forEach { def ->
                        TextButton(onClick = { onPick(def) }, modifier = Modifier.fillMaxWidth()) {
                            Text(def.label, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = onDismiss) { Text("Закрыть") } }
    )
}
