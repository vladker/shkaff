package ru.vldkr.shkaff.features.labels

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.data.printer.UsbPermission
import ru.vldkr.shkaff.data.printer.UsbPermissionPendingException
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.features.printers.PrinterPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.util.newId
import android.content.Intent

class LabelsVm(
    private val itemId: String?,
    templateId: String?
) : ViewModel() {

    data class Ui(
        val item: ItemEntity? = null,
        val code: String = "",
        val name: String = "",
        val templates: List<LabelTemplateEntity> = emptyList(),
        val template: LabelTemplateEntity? = null,
        val bitmap: Bitmap? = null,
        val savedMsg: String? = null,
        val profiles: List<PrinterProfileEntity> = emptyList(),
        val printBusy: Boolean = false,
        val printMsg: String? = null,
        val printError: String? = null,
        // Быстрые настройки печати (оверрайды в текущей сессии; пусто — значение из шаблона).
        val sizeW: String = "",
        val sizeH: String = "",
        val textPosition: String = "bottom",
        val showText: Boolean = true,
        val showNumber: Boolean = true,
        val fontSize: String = "",
        val marginMm: String = "",
        val format: String = "",
        // Для диалога сохранения
        val showSaveDialog: Boolean = false,
        val saveAsName: String = "",
        val saveMode: SaveMode = SaveMode.OVERWRITE
    )

    enum class SaveMode {
        OVERWRITE,   // Перезаписать текущий
        SAVE_AS,     // Сохранить как новый кастомный
        SET_DEFAULT  // Сделать основным шаблоном
    }

    val ui = MutableStateFlow(Ui())

    class Factory(private val itemId: String, private val templateId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = LabelsVm(
            if (itemId == "0") null else itemId,
            if (templateId == "0" || templateId.isEmpty()) null else templateId
        ) as T
    }

    private fun update(f: (Ui) -> Ui) {
        ui.value = f(ui.value)
    }

    fun setTemplate(id: String) {
        update { it.copy(template = ui.value.templates.firstOrNull { t -> t.id == id }) }
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
        val t = ui.value.template ?: return null
        val w = ui.value.sizeW.toDoubleOrNull()?.takeIf { it >= 10.0 } ?: t.width_mm
        val h = ui.value.sizeH.toDoubleOrNull()?.takeIf { it >= 10.0 } ?: t.height_mm
        val fs = ui.value.fontSize.toDoubleOrNull() ?: t.font_size
        val m = ui.value.marginMm.toDoubleOrNull()?.takeIf { it >= 0.0 } ?: t.margin_mm
        val fmt = ui.value.format.ifBlank { t.format }
        return t.copy(
            width_mm = w,
            height_mm = h,
            text_position = ui.value.textPosition,
            show_text = ui.value.showText,
            show_number = ui.value.showNumber,
            font_size = fs,
            margin_mm = m,
            format = fmt
        )
    }

    fun openSaveDialog(mode: SaveMode) {
        update { it.copy(showSaveDialog = true, saveMode = mode, saveAsName = "") }
    }

    fun closeSaveDialog() {
        update { it.copy(showSaveDialog = false) }
    }

    fun setSaveAsName(name: String) {
        update { it.copy(saveAsName = name) }
    }

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

    fun regenerate() {
        val t = effectiveTemplate() ?: return
        val bmp = LabelGenerator.generate(t, ui.value.code, ui.value.name)
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
        if (code.isBlank()) {
            update { it.copy(printError = "Пустой код — нечего печатать") }
            return
        }
        viewModelScope.launch {
            update { it.copy(printBusy = true, printMsg = null, printError = null) }
            val r = try {
                PrintManager.printLabel(profile, t, code, ui.value.name)
            } catch (e: Exception) {
                Result.failure(e)
            }
            val e = r.exceptionOrNull()
            when {
                e == null -> update { it.copy(printBusy = false, printError = null, printMsg = "Отправлено на печать: ${PrintManager.describe(profile)}") }
                e is UsbPermissionPendingException -> {
                    val msg = UsbPermission.failureMessage(e) { print(profile) }
                    update { it.copy(printBusy = false, printMsg = msg) }
                }
                else -> update { it.copy(printBusy = false, printError = "Ошибка: ${e.message ?: "не удалось напечатать"}") }
            }
        }
    }

    init {
        viewModelScope.launch {
            Deps.db.printerDao().observeAll().collect { list ->
                update { it.copy(profiles = list) }
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
        if (itemId != null) {
            viewModelScope.launch {
                Deps.items.byId(itemId)?.let { found ->
                    update {
                        it.copy(
                            item = found,
                            code = if (found.code.isNotBlank()) found.code else (ScanBus.lastCode ?: found.code),
                            name = found.name
                        )
                    }
                    regenerate()
                }
            }
        }
        if (ui.value.code.isEmpty() && ui.value.item == null) {
            val scanned = ScanBus.lastCode
            if (scanned != null) {
                update { it.copy(code = scanned) }
                ScanBus.lastCode = null
                regenerate()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelsScreen(nav: NavController, itemId: String, templateId: String) {
    val ctx = LocalContext.current
    val vm: LabelsVm = viewModel(factory = LabelsVm.Factory(itemId, templateId))
    val ui by vm.ui.collectAsState()
    var showTemplatePicker by remember { mutableStateOf(false) }
    var showPrintPicker by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (ui.item == null) "Этикетка" else "Этикетка: ${ui.item?.name}") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
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
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            OutlinedTextField(
                value = ui.code,
                onValueChange = { vm.setCode(it) },
                label = { Text("Код (QR / штрихкод)") },
                supportingText = { Text("Содержимое штрихкода. Пусто — сгенерировать нельзя") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(16.dp))
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
                        OutlinedButton(onClick = { vm.setTextPosition("top") }, modifier = Modifier.weight(1f)) {
                            Text("Над кодом", style = MaterialTheme.typography.labelLarge)
                        }
                        OutlinedButton(onClick = { vm.setTextPosition("bottom") }, modifier = Modifier.weight(1f)) {
                            Text("Под кодом", style = MaterialTheme.typography.labelLarge)
                        }
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
                                colors = if (selected) androidx.compose.material3.ButtonDefaults.outlinedButtonColors(
                                    containerColor = MaterialTheme.colorScheme.primaryContainer
                                ) else androidx.compose.material3.ButtonDefaults.outlinedButtonColors()
                            ) {
                                Text(fmt, style = MaterialTheme.typography.labelSmall)
                            }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                        Checkbox(checked = ui.showText, onCheckedChange = vm::setShowText)
                        Text("Надписи на этикетке", style = MaterialTheme.typography.bodyMedium)
                    }
                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                        Checkbox(checked = ui.showNumber, onCheckedChange = vm::setShowNumber)
                        Text("Номер объекта (код)", style = MaterialTheme.typography.bodyMedium)
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
                        TextButton(onClick = { vm.resetOverrides() }, modifier = Modifier.weight(1f)) {
                            Text("Сбросить")
                        }
                        TextButton(onClick = { vm.openSaveDialog(LabelsVm.SaveMode.OVERWRITE) }, modifier = Modifier.weight(1f)) {
                            Text("Перезаписать")
                        }
                        TextButton(onClick = { vm.openSaveDialog(LabelsVm.SaveMode.SAVE_AS) }, modifier = Modifier.weight(1f)) {
                            Text("Как новый")
                        }
                    }
                    TextButton(onClick = { vm.openSaveDialog(LabelsVm.SaveMode.SET_DEFAULT) }, modifier = Modifier.fillMaxWidth()) {
                        Text("Сделать основным шаблоном")
                    }
                }
            }
            Spacer(Modifier.height(16.dp))
            SectionTitle("Предпросмотр")
            // Предпросмотр с линейками
            ui.bitmap?.let { bmp ->
                Box(
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(bmp.width.toFloat() / bmp.height)
                        .padding(vertical = 8.dp)
                ) {
                    // Рисуем превью с миллиметровыми линейками
                    LabelPreviewWithRulers(
                        bitmap = bmp,
                        widthMm = ui.sizeW.toDoubleOrNull() ?: ui.template?.width_mm ?: 58.0,
                        heightMm = ui.sizeH.toDoubleOrNull() ?: ui.template?.height_mm ?: 40.0
                    )
                }
            } ?: Card(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text(
                    "Выберите шаблон и введите код",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            ui.savedMsg?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            }
            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { vm.saveToGallery(ctx) }, enabled = ui.bitmap != null, modifier = Modifier.weight(1f)) {
                    Text("Сохранить")
                }
                OutlinedButton(onClick = { vm.share(ctx) }, enabled = ui.bitmap != null, modifier = Modifier.weight(1f)) {
                    Text("Поделиться")
                }
                OutlinedButton(onClick = { showPrintPicker = true }, enabled = ui.bitmap != null && !ui.printBusy, modifier = Modifier.weight(1f)) {
                    Text("Печать")
                }
            }
            ui.printMsg?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
            }
            ui.printError?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
            }
            Spacer(Modifier.height(8.dp))
            Text(
                "Сохранение — PNG в галерею; «Печать» — напрямую на 58-мм принтер (TCP/BT, ESC/POS); «Поделиться» — печать из стороннего приложения.",
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
                    nav.navigate("templates")
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
                    nav.navigate("printers")
                },
                onDismiss = { showPrintPicker = false }
            )
        }

        // Диалог сохранения настроек шаблона
        if (ui.showSaveDialog) {
            SaveTemplateDialog(
                mode = ui.saveMode,
                templateName = ui.template?.name ?: "",
                saveAsName = ui.saveAsName,
                onSave = { name ->
                    vm.setSaveAsName(name)
                    vm.saveCurrentSettings()
                },
                onDismiss = { vm.closeSaveDialog() }
            )
        }
    }
}

@Composable
fun LabelPreviewWithRulers(bitmap: Bitmap, widthMm: Double, heightMm: Double) {
    Box(contentAlignment = Alignment.Center) {
        // Основной контейнер с линейками
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            // Верхняя горизонтальная линейка
            HorizontalRuler(widthMm = widthMm, modifier = Modifier.fillMaxWidth())
            Row(verticalAlignment = Alignment.Top) {
                // Левая вертикальная линейка
                VerticalRuler(heightMm = heightMm, modifier = Modifier.weight(0.15f))
                // Изображение этикетки
                Box(
                    Modifier
                        .weight(0.85f)
                        .aspectRatio(bitmap.width.toFloat() / bitmap.height)
                        .padding(4.dp)
                ) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Этикетка",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@Composable
fun HorizontalRuler(widthMm: Double, modifier: Modifier = Modifier) {
    val mmPerPixel = widthMm / 100.0 // условно 100 пикселей на всю ширину
    Canvas(modifier.height(24.dp).fillMaxWidth()) {
        val w = size.width
        val h = size.height
        // Рисуем линию
        drawLine(
            color = androidx.compose.ui.graphics.Color(0xFF666666),
            start = Offset(0f, h - 2.dp.toPx()),
            end = Offset(w, h - 2.dp.toPx()),
            strokeWidth = 1.dp.toPx()
        )
        // Рисуем деления каждые 5 мм и 10 мм
        val stepPx = w / widthMm.toFloat()
        for (mm in 0..widthMm.toInt()) {
            val x = mm * stepPx
            val isMajor = mm % 10 == 0
            val isMedium = mm % 5 == 0 && !isMajor
            val lineH = if (isMajor) h else if (isMedium) h * 0.6f else h * 0.3f
            drawLine(
                color = androidx.compose.ui.graphics.Color(0xFF666666),
                start = Offset(x, h - lineH),
                end = Offset(x, h),
                strokeWidth = if (isMajor) 1.5.dp.toPx() else 0.5.dp.toPx()
            )
            if (isMajor && mm > 0) {
                // Можно добавить текст, но для простоты пока только линии
            }
        }
    }
}

@Composable
fun VerticalRuler(heightMm: Double, modifier: Modifier = Modifier) {
    Canvas(modifier.width(24.dp).fillMaxHeight()) {
        val w = size.width
        val h = size.height
        // Рисуем линию
        drawLine(
            color = androidx.compose.ui.graphics.Color(0xFF666666),
            start = Offset(w - 2.dp.toPx(), 0f),
            end = Offset(w - 2.dp.toPx(), h),
            strokeWidth = 1.dp.toPx()
        )
        // Рисуем деления каждые 5 мм и 10 мм
        val stepPx = h / heightMm.toFloat()
        for (mm in 0..heightMm.toInt()) {
            val y = mm * stepPx
            val isMajor = mm % 10 == 0
            val isMedium = mm % 5 == 0 && !isMajor
            val lineW = if (isMajor) w else if (isMedium) w * 0.6f else w * 0.3f
            drawLine(
                color = androidx.compose.ui.graphics.Color(0xFF666666),
                start = Offset(w - lineW, y),
                end = Offset(w, y),
                strokeWidth = if (isMajor) 1.5.dp.toPx() else 0.5.dp.toPx()
            )
        }
    }
}

@Composable
fun SaveTemplateDialog(
    mode: LabelsVm.SaveMode,
    templateName: String,
    saveAsName: String,
    onSave: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val title = when (mode) {
        LabelsVm.SaveMode.OVERWRITE -> "Перезаписать шаблон?"
        LabelsVm.SaveMode.SAVE_AS -> "Сохранить как новый шаблон"
        LabelsVm.SaveMode.SET_DEFAULT -> "Сделать основным шаблоном?"
    }
    val text = when (mode) {
        LabelsVm.SaveMode.OVERWRITE -> "Текущий шаблон «$templateName» будет обновлён новыми настройками."
        LabelsVm.SaveMode.SAVE_AS -> "Введите название для нового шаблона:"
        LabelsVm.SaveMode.SET_DEFAULT -> "Текущие настройки будут сохранены как основной шаблон по умолчанию."
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                Text(text, style = MaterialTheme.typography.bodyMedium)
                if (mode == LabelsVm.SaveMode.SAVE_AS) {
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = saveAsName,
                        onValueChange = onSave,
                        label = { Text("Название шаблона") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onSave(saveAsName) }) {
                Text(if (mode == LabelsVm.SaveMode.SAVE_AS) "Сохранить" else "OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}
