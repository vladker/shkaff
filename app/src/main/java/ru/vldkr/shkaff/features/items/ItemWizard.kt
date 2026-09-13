package ru.vldkr.shkaff.features.items

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.links.CodeResolver
import ru.vldkr.shkaff.domain.recommend.RecommendLlm
import ru.vldkr.shkaff.features.labels.LabelGenerator
import ru.vldkr.shkaff.features.labels.TemplatePickerDialog
import ru.vldkr.shkaff.features.printers.PrinterPickerDialog
import ru.vldkr.shkaff.features.scan.ScanCameraPreview
import ru.vldkr.shkaff.util.newUlid
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.LocationPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle

// Пошаговый мастер добавления вещи: фото → название/код → ИИ-заполнение →
// этикетка/QR → хранилище (вручную / по QR / ИИ) → серия.
enum class WStep(val label: String) {
    PHOTO("Фото"),
    INFO("Название"),
    CONFIRM("Поля"),
    LABEL("Этикетка"),
    STORAGE("Хранение"),
    DONE("Готово"),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemWizardScreen(nav: NavController) {
    val vm: ItemFormVm = viewModel(factory = ItemFormVm.Factory("0", "0"))
    val scope = rememberCoroutineScope()
    val ctx = LocalContext.current
    val loaded by vm.loaded.collectAsState()
    val error by vm.error.collectAsState()
    val saving by vm.saving.collectAsState()
    val defs by vm.attrDefs.collectAsState()
    val locations by vm.locations.collectAsState()

    var step by remember { mutableStateOf(WStep.PHOTO) }

    // Этикетка
    val templates = remember { mutableStateOf(emptyList<LabelTemplateEntity>()) }
    val printers = remember { mutableStateOf(emptyList<PrinterProfileEntity>()) }
    var selTemplateId by remember { mutableStateOf<String?>(null) }
    var showTemplatePicker by remember { mutableStateOf(false) }
    var showPrinterPicker by remember { mutableStateOf(false) }
    var labelMsg by remember { mutableStateOf<String?>(null) }
    var labelErr by remember { mutableStateOf<String?>(null) }

    // Хранение: AI-рекомендации
    var showLocationPicker by remember { mutableStateOf(false) }
    var showScanBox by remember { mutableStateOf(false) }
    var aiRecs by remember { mutableStateOf(emptyList<RecommendLlm.Recommendation>()) }
    var aiRecBusy by remember { mutableStateOf(false) }
    var scanMsg by remember { mutableStateOf<String?>(null) }

    // Сохранено
    var savedId by remember { mutableStateOf<String?>(null) }
    var savedName by remember { mutableStateOf("") }

    // Ответ ИИ получен → применяем найденные поля и переходим к заполнению.
    val smartResult by vm.smartSearchResult.collectAsState()
    LaunchedEffect(smartResult) {
        if (smartResult != null) {
            vm.applyAllSmartSearch()
            step = WStep.CONFIRM
        }
    }

    // QR ящика: резолвим в локацию (по её коду или по коду вещи → её ящик).
    fun handleScan(code: String) {
        scanMsg = null
        scope.launch {
            val loc = try {
                CodeResolver.resolveLocation(
                    code,
                    locationByLabel = { label ->
                        Deps.locations.observeAll().first()
                            .firstOrNull { it.label.equals(label, true) || it.name.equals(label, true) }
                    },
                    locationOfItemCode = { c ->
                        Deps.items.byCode(c)?.location_id?.let { Deps.locations.byId(it) }
                    }
                )
            } catch (_: Exception) {
                null
            }
            if (loc != null) {
                vm.locationId = loc.id
                scanMsg = "Ящик: ${loc.label.ifBlank { loc.name }}"
            } else {
                scanMsg = "Ящик по этому коду не найден"
            }
        }
    }

    LaunchedEffect(Unit) {
        Deps.db.labelTemplateDao().observeAll().collect { templates.value = it }
    }
    LaunchedEffect(Unit) {
        Deps.db.printerDao().observeAll().collect { printers.value = it }
    }

    if (!loaded) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Загрузка…", style = MaterialTheme.typography.bodyLarge)
        }
        return
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Новая вещь") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    // Настройки ИИ (провайдер/модель) прямо из мастера.
                    IconButton(onClick = { nav.navigate("agent") }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Настройки ИИ")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            WizardStepper(step)
            Spacer(Modifier.height(12.dp))

            when (step) {
                WStep.PHOTO -> PhotoStep(vm, onNext = { step = WStep.INFO }, onAi = { vm.aiFill() })

                WStep.INFO -> InfoStep(vm, onBack = { step = WStep.PHOTO }, onNext = { step = WStep.CONFIRM })

                WStep.CONFIRM -> ConfirmStep(vm, defs, onBack = { step = WStep.INFO }, onNext = {
                    if (vm.code.isBlank()) vm.code = newUlid()
                    step = WStep.LABEL
                })

                WStep.LABEL -> LabelStep(
                    vm = vm,
                    ctx = ctx,
                    scope = scope,
                    templates = templates.value,
                    selTemplateId = selTemplateId,
                    onPickTemplate = { selTemplateId = it },
                    onOpenTemplates = { showTemplatePicker = true },
                    onOpenPrinters = { showPrinterPicker = true },
                    msg = labelMsg,
                    err = labelErr,
                    onMsg = { labelMsg = it },
                    onErr = { labelErr = it },
                    onBack = { step = WStep.CONFIRM },
                    onNext = { step = WStep.STORAGE }
                )

                WStep.STORAGE -> StorageStep(
                    vm = vm,
                    locations = locations,
                    aiRecs = aiRecs,
                    aiRecBusy = aiRecBusy,
                    scanMsg = scanMsg,
                    onAiRec = {
                        aiRecBusy = true
                        scope.launch {
                            aiRecs = try { vm.aiRecommendLocations() } catch (_: Exception) { emptyList() }
                            aiRecBusy = false
                        }
                    },
                    onPickLocation = { showLocationPicker = true },
                    onScanBox = { showScanBox = true },
                    onBack = { step = WStep.LABEL },
                    onSave = {
                        vm.save { id ->
                            savedId = id
                            savedName = vm.name
                            step = WStep.DONE
                        }
                    }
                )

                WStep.DONE -> DoneStep(
                    savedName,
                    onAnother = {
                        // Сброс формы и к началу.
                        vm.name = ""; vm.code = ""; vm.ean = ""; vm.description = ""
                        vm.volumeLiters = ""; vm.weightKg = ""; vm.expiryDate = ""
                        vm.attrs = emptyMap(); vm.tags = emptyList()
                        vm.locationId = null; vm.photoPath = null; vm.barcodePhotoPath = null
                        aiRecs = emptyList(); scanMsg = null; labelMsg = null; labelErr = null
                        savedId = null; savedName = ""
                        step = WStep.PHOTO
                    },
                    onSeries = {
                        savedId?.let { nav.navigate("batch?from=$it") }
                    },
                    onDone = { nav.popBackStack() }
                )
            }

            error?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 12.dp))
            }
            if (saving) {
                Text("Сохраняем…", color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodySmall)
            }
        }

        if (showTemplatePicker) {
            TemplatePickerDialog(
                templates = templates.value,
                currentId = selTemplateId,
                onPick = { selTemplateId = it },
                onManage = { showTemplatePicker = false; nav.navigate("templates") },
                onDismiss = { showTemplatePicker = false }
            )
        }
        if (showPrinterPicker) {
            PrinterPickerDialog(
                profiles = printers.value,
                onPick = { p ->
                    showPrinterPicker = false
                    val t = templates.value.firstOrNull { it.id == selTemplateId } ?: templates.value.firstOrNull()
                    if (t == null) { labelErr = "Нет шаблона"; return@PrinterPickerDialog }
                    if (vm.code.isBlank()) { labelErr = "Укажите код для печати"; return@PrinterPickerDialog }
                    labelMsg = null
                    scope.launch {
                        val r = try {
                            PrintManager.printLabel(p, t, vm.code, vm.name)
                        } catch (e: Exception) {
                            Result.failure(e)
                        }
                        if (r.isSuccess) labelMsg = "Отправлено: ${PrintManager.describe(p)}"
                        else labelErr = "Ошибка: ${r.exceptionOrNull()?.message ?: "не удалось напечатать"}"
                    }
                },
                onManage = { showPrinterPicker = false; nav.navigate("printers") },
                onDismiss = { showPrinterPicker = false }
            )
        }
        if (showLocationPicker) {
            LocationPickerDialog(
                locations = locations,
                currentId = vm.locationId,
                onPick = { vm.locationId = it },
                onDismiss = { showLocationPicker = false }
            )
        }
        if (showScanBox) {
            ScanBoxDialog(
                onDetected = { code ->
                    showScanBox = false
                    handleScan(code)
                },
                onDismiss = { showScanBox = false }
            )
        }
    }
}

@Composable
private fun WizardStepper(step: WStep) {
    val idx = WStep.entries.indexOf(step)
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        WStep.entries.forEach { s ->
            val active = s == step
            val done = WStep.entries.indexOf(s) < idx
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.weight(1f)) {
                Text(
                    if (done) "✓" else (WStep.entries.indexOf(s) + 1).toString(),
                    style = MaterialTheme.typography.labelLarge,
                    color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    s.label,
                    style = MaterialTheme.typography.labelSmall,
                    color = if (active) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1
                )
            }
        }
    }
}

@Composable
private fun PhotoStep(vm: ItemFormVm, onNext: () -> Unit, onAi: () -> Unit) {
    val busy by vm.smartSearchBusy.collectAsState()
    Text(
        "Сфотографируйте вещь (опционально). ИИ прочитает текст на фото (а если его нет — опишет внешний вид) и найдёт вещь в интернете, либо введите поля вручную.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(Modifier.height(12.dp))
    PhotoField(vm)
    Spacer(Modifier.height(16.dp))

    if (busy) {
        // Идёт распознавание: остаёмся на фото и показываем процесс, пока поля не заполнены.
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                "ИИ читает фото и ищет вещь в интернете — пока вводить ничего не нужно.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                CircularProgressIndicator(modifier = Modifier.size(20.dp), strokeWidth = 2.dp)
                Spacer(Modifier.width(12.dp))
                Text(
                    vm.smartSearchStep.collectAsState().value?.ifBlank { null } ?: "ИИ думает…",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        Spacer(Modifier.height(12.dp))
    }

    vm.smartSearchError.collectAsState().value?.let {
        Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
        Spacer(Modifier.height(8.dp))
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = onAi, modifier = Modifier.fillMaxWidth(), enabled = !busy) {
            Text("Найти с ИИ")
        }
        OutlinedButton(onClick = onNext, modifier = Modifier.fillMaxWidth(), enabled = !busy) {
            Text("Ввести информацию")
        }
    }
}

@Composable
private fun InfoStep(vm: ItemFormVm, onBack: () -> Unit, onNext: () -> Unit) {
    FieldRow("Название *") {
        Column {
            OutlinedTextField(
                value = vm.name,
                onValueChange = { vm.name = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Например: Дрель Makita") },
                singleLine = true
            )
            if (vm.smartSearchBusy.collectAsState().value) {
                Text(vm.smartSearchStep.collectAsState().value?.ifBlank { null } ?: "ИИ думает…", style = MaterialTheme.typography.bodySmall)
            } else {
                OutlinedButton(onClick = { vm.aiFill() }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                    Text("Заполнить с ИИ")
                }
            }
            vm.smartSearchError.collectAsState().value?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
    FieldRow("Код / номер (модель)") {
        OutlinedTextField(
            value = vm.code,
            onValueChange = { vm.code = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Например: T-001") },
            supportingText = { Text("Пусто — присвоится ULID (26 символов)") },
            singleLine = true
        )
    }
    FieldRow("Штрихкод (EAN)") {
        OutlinedTextField(
            value = vm.ean,
            onValueChange = { vm.ean = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("4607001234567") },
            singleLine = true
        )
    }
    Spacer(Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Назад") }
        Button(onClick = onNext, modifier = Modifier.weight(2f), enabled = vm.name.isNotBlank()) { Text("Далее") }
    }
}

@Composable
private fun ConfirmStep(vm: ItemFormVm, defs: List<ru.vldkr.shkaff.data.db.AttributeDefEntity>, onBack: () -> Unit, onNext: () -> Unit) {
    Text(
        "Проверьте поля. Измените вручную или примите предложение ИИ.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(Modifier.height(12.dp))
    FieldRow("Описание") {
        Column {
            OutlinedTextField(value = vm.description, onValueChange = { vm.description = it }, modifier = Modifier.fillMaxWidth(), placeholder = { Text("Комментарий") })
            if (!vm.photoPath.isNullOrBlank()) {
                if (vm.descAiBusy.collectAsState().value) {
                    Text(
                        vm.descAiStep.collectAsState().value ?: "ИИ пишет описание…",
                        style = MaterialTheme.typography.bodySmall
                    )
                } else {
                    OutlinedButton(onClick = { vm.aiDescription() }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                        Text("Описание с ИИ по фото")
                    }
                }
                vm.descAiError.collectAsState().value?.let {
                    Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                }
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        FieldRow("Объём (л)") {
            OutlinedTextField(
                value = vm.volumeLiters, onValueChange = { vm.volumeLiters = it },
                modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), singleLine = true
            )
        }
        FieldRow("Масса (кг)") {
            OutlinedTextField(
                value = vm.weightKg, onValueChange = { vm.weightKg = it },
                modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal), singleLine = true
            )
        }
    }
    FieldRow("Срок годности") {
        OutlinedTextField(value = vm.expiryDate, onValueChange = { vm.expiryDate = it }, modifier = Modifier.fillMaxWidth(), placeholder = { Text("ДД.ММ.ГГГГ") }, singleLine = true)
    }
    TagChipsField(vm)
    if (defs.isNotEmpty()) {
        SectionTitle("Атрибуты")
        AttrFields(defs, vm.attrs) { k, v ->
            vm.attrs = if (v.isEmpty()) vm.attrs - k else vm.attrs + (k to v)
        }
    }
    Spacer(Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Назад") }
        Button(onClick = onNext, modifier = Modifier.weight(2f)) { Text("Далее") }
    }
}

@Composable
private fun LabelStep(
    vm: ItemFormVm,
    ctx: Context,
    scope: kotlinx.coroutines.CoroutineScope,
    templates: List<LabelTemplateEntity>,
    selTemplateId: String?,
    onPickTemplate: (String) -> Unit,
    onOpenTemplates: () -> Unit,
    onOpenPrinters: () -> Unit,
    msg: String?,
    err: String?,
    onMsg: (String) -> Unit,
    onErr: (String) -> Unit,
    onBack: () -> Unit,
    onNext: () -> Unit,
) {
    val sel = templates.firstOrNull { it.id == selTemplateId } ?: templates.firstOrNull()
    val code = vm.code
    val name = vm.name
    val bmp = remember(sel, code, name) {
        if (sel != null && code.isNotBlank()) {
            runCatching { LabelGenerator.generate(sel, code, name) }.getOrNull()
        } else null
    }

    Text(
        "Этикетка с QR. Код нужен для кода/печати. Сохраните в галерею или отправьте на принтер.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(Modifier.height(12.dp))
    FieldRow("Код для этикетки") {
        OutlinedTextField(
            value = code, onValueChange = { vm.code = it },
            modifier = Modifier.fillMaxWidth(),
            supportingText = { Text("Присвоен автоматически — можно заменить") },
            singleLine = true
        )
    }
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text("Шаблон: ${sel?.name ?: "нет"}", modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
        TextButton(onClick = onOpenTemplates) { Text("Сменить") }
    }
    if (sel != null) {
        if (bmp != null) {
            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(bitmap = bmp.asImageBitmap(), contentDescription = "Этикетка", modifier = Modifier.height(160.dp))
            }
        } else {
            Text("Введите код, чтобы увидеть этикетку.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
    Spacer(Modifier.height(12.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(
            onClick = {
                if (bmp == null) { onErr("Нет этикетки: укажите код"); return@OutlinedButton }
                val uri = LabelGenerator.saveToGallery(ctx, bmp, "${LabelGenerator.sanitizeFileName(name.ifBlank { "label" })}.png")
                if (uri != null) onMsg("Сохранено в галерею") else onErr("Не удалось сохранить")
            },
            enabled = sel != null,
            modifier = Modifier.weight(1f)
        ) { Text("В галерею") }
        OutlinedButton(onClick = onOpenPrinters, enabled = sel != null && code.isNotBlank(), modifier = Modifier.weight(1f)) { Text("Печать") }
    }
    msg?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary) }
    err?.let { Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error) }
    Spacer(Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Назад") }
        Button(onClick = onNext, modifier = Modifier.weight(2f)) { Text("Пропустить / Далее") }
    }
}

@Composable
private fun StorageStep(
    vm: ItemFormVm,
    locations: List<ru.vldkr.shkaff.data.db.LocationEntity>,
    aiRecs: List<RecommendLlm.Recommendation>,
    aiRecBusy: Boolean,
    scanMsg: String?,
    onAiRec: () -> Unit,
    onPickLocation: () -> Unit,
    onScanBox: () -> Unit,
    onBack: () -> Unit,
    onSave: () -> Unit,
) {
    val locName = vm.locationName()
    Text(
        "Куда положить: выберите ящик, отсканируйте QR ящика или попросите ИИ.",
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
    Spacer(Modifier.height(12.dp))
    FieldRow("Где хранится") {
        Column {
            OutlinedButton(onClick = onPickLocation, modifier = Modifier.fillMaxWidth()) {
                Text(locName ?: "— без ящика —")
            }
            if (locName != null) {
                TextButton(onClick = { vm.locationId = null }) { Text("Сбросить", color = MaterialTheme.colorScheme.onSurfaceVariant) }
            }
        }
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(onClick = onScanBox, modifier = Modifier.weight(1f)) { Text("QR ящика") }
        OutlinedButton(onClick = onAiRec, enabled = !aiRecBusy, modifier = Modifier.weight(1f)) { Text(if (aiRecBusy) "Думаем…" else "ИИ-подсказка") }
    }
    scanMsg?.let { Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant) }
    if (aiRecs.isNotEmpty()) {
        Spacer(Modifier.height(8.dp))
        SectionTitle("Подходит для этой вещи")
        aiRecs.forEach { r ->
            val selected = r.id == vm.locationId
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { vm.locationId = r.id }
                    .padding(vertical = 6.dp)
            ) {
                Text(
                    if (selected) "✓ " else "＋ ",
                    color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                )
                Column(Modifier.weight(1f)) {
                    Text(r.name, style = MaterialTheme.typography.bodyLarge)
                    Text(r.reason, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 2)
                }
            }
        }
    }
    Spacer(Modifier.height(16.dp))
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        OutlinedButton(onClick = onBack, modifier = Modifier.weight(1f)) { Text("Назад") }
        Button(onClick = onSave, modifier = Modifier.weight(2f), enabled = vm.name.isNotBlank()) { Text("Сохранить") }
    }
}

@Composable
private fun DoneStep(savedName: String, onAnother: () -> Unit, onSeries: () -> Unit, onDone: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(vertical = 24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Filled.Check, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(64.dp))
        Spacer(Modifier.height(12.dp))
        Text("Готово!", style = MaterialTheme.typography.titleLarge)
        if (savedName.isNotBlank()) {
            Text("«$savedName» добавлена", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Spacer(Modifier.height(24.dp))
        Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onAnother, modifier = Modifier.fillMaxWidth()) { Text("Добавить ещё") }
            OutlinedButton(onClick = onSeries, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Add, contentDescription = null, modifier = Modifier.size(18.dp).padding(end = 8.dp))
                Text("Серия таких вещей")
            }
            TextButton(onClick = onDone, modifier = Modifier.fillMaxWidth()) { Text("Готово, закрыть") }
        }
    }
}

// Диалог сканирования QR ящика камерой.
@Composable
private fun ScanBoxDialog(onDetected: (String) -> Unit, onDismiss: () -> Unit) {
    var scanning by remember { mutableStateOf(true) }
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Сканировать QR ящика") },
        text = {
            Box(Modifier.fillMaxWidth().height(360.dp), contentAlignment = Alignment.Center) {
                if (scanning) {
                    ScanCameraPreview(enabled = true, onDetected = { code ->
                        scanning = false
                        onDetected(code)
                    })
                } else {
                    Text("Сканирую…", style = MaterialTheme.typography.bodyMedium)
                }
            }
        },
        confirmButton = {},
        dismissButton = { TextButton(onClick = onDismiss) { Text("Закрыть") } }
    )
}
