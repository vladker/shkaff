package ru.vldkr.shkaff.features.batch

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.batch.BatchPlan
import ru.vldkr.shkaff.features.labels.LabelGenerator
import ru.vldkr.shkaff.features.labels.TemplatePickerDialog
import ru.vldkr.shkaff.features.printers.PrinterPickerDialog
import ru.vldkr.shkaff.ui.components.ConfirmDialog
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.LocationPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.parseOptions

class BatchVm : ViewModel() {

    enum class Phase { SETUP, LOOP, DONE }

    data class Ui(
        val phase: Phase = Phase.SETUP,
        val namePattern: String = "",
        val description: String = "",
        val locationId: String? = null,
        val attrs: Map<String, String> = emptyMap(),
        val perItemKeys: Set<String> = emptySet(),
        val count: String = "10",
        val index: Int = 1,
        val totalCount: Int = 0,
        val curName: String = "",
        val curAttrs: Map<String, String> = emptyMap(),
        val created: List<ItemEntity> = emptyList(),
        val error: String? = null,
        val busy: Boolean = false,
        val galleryMsg: String? = null,
        val printMsg: String? = null,
        val printError: String? = null,
        val templates: List<LabelTemplateEntity> = emptyList(),
        val template: LabelTemplateEntity? = null,
        val profiles: List<PrinterProfileEntity> = emptyList()
    )

    val ui = MutableStateFlow(Ui())
    val locations = MutableStateFlow<List<LocationEntity>>(emptyList())
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())

    private fun update(f: (Ui) -> Ui) {
        ui.value = f(ui.value)
    }

    fun locationName(): String? {
        val id = ui.value.locationId ?: return null
        return locations.value.firstOrNull { it.id == id }?.let { it.label.ifBlank { it.name } }
    }

    fun setName(s: String) = update { it.copy(namePattern = s, error = null) }

    fun setDescription(s: String) = update { it.copy(description = s) }

    fun setCount(s: String) = update { it.copy(count = s) }

    fun setSetupAttr(key: String, value: String) = update {
        it.copy(attrs = if (value.isEmpty()) it.attrs - key else it.attrs + (key to value))
    }

    fun togglePerItem(key: String) = update {
        val cur = it.perItemKeys
        it.copy(perItemKeys = if (key in cur) cur - key else cur + key)
    }

    fun setCurAttr(key: String, value: String) = update {
        it.copy(curAttrs = if (value.isEmpty()) it.curAttrs - key else it.curAttrs + (key to value))
    }

    fun setLocation(id: String?) = update { it.copy(locationId = id) }

    fun setTemplate(id: String) = update {
        it.copy(template = it.templates.firstOrNull { t -> t.id == id })
    }

    fun start() {
        val u = ui.value
        val n = u.count.trim().toIntOrNull()
        when {
            u.namePattern.isBlank() -> update { it.copy(error = "Укажите название (можно с {n})") }
            n == null || n < 1 -> update { it.copy(error = "Количество: целое число от 1 до ${BatchPlan.MAX_SERIES}") }
            n > BatchPlan.MAX_SERIES -> update { it.copy(error = "Слишком много: максимум ${BatchPlan.MAX_SERIES} за серию") }
            else -> update {
                it.copy(
                    error = null,
                    phase = Phase.LOOP,
                    index = 1,
                    totalCount = n,
                    curName = BatchPlan.expandName(u.namePattern, 1),
                    curAttrs = u.attrs.filterKeys { k -> k in u.perItemKeys }
                )
            }
        }
    }

    fun next() {
        val u = ui.value
        if (u.busy) return
        viewModelScope.launch {
            update { it.copy(busy = true, error = null, galleryMsg = null) }
            val attrs = BatchPlan.mergeValues(
                BatchPlan.copiedAttrs(u.attrs, u.perItemKeys),
                u.curAttrs
            )
            try {
                val e = Deps.items.create(
                    ItemData(
                        name = BatchPlan.expandName(u.namePattern, u.index).trim(),
                        code = "",
                        description = u.description.trim(),
                        attributes = attrs,
                        locationId = u.locationId
                    )
                )
                val created = ui.value.created + e
                if (u.index >= u.totalCount) {
                    update { it.copy(created = created, phase = Phase.DONE, busy = false) }
                } else {
                    update {
                        it.copy(
                            created = created,
                            index = it.index + 1,
                            curName = BatchPlan.expandName(it.namePattern, it.index + 1),
                            curAttrs = it.attrs.filterKeys { k -> k in it.perItemKeys },
                            busy = false
                        )
                    }
                }
            } catch (ex: Exception) {
                update { it.copy(error = ex.message ?: "Не удалось создать вещь", busy = false) }
            }
        }
    }

    fun saveLabelsToGallery(ctx: Context) {
        val u = ui.value
        val t = u.template
        if (t == null || u.created.isEmpty()) return
        viewModelScope.launch {
            update { it.copy(galleryMsg = null, printMsg = null, printError = null) }
            var ok = 0
            for (e in u.created) {
                val bmp = LabelGenerator.generate(t, e.code, e.name) ?: continue
                val uri = LabelGenerator.saveToGallery(
                    ctx, bmp,
                    "${LabelGenerator.sanitizeFileName(e.name)}_${e.code}.png"
                )
                if (uri != null) ok++
            }
            update {
                it.copy(
                    galleryMsg = if (ok == u.created.size)
                        "Сохранено этикеток: $ok"
                    else "Сохранено $ok из ${u.created.size}"
                )
            }
        }
    }

    fun printAll(profile: PrinterProfileEntity) {
        val u = ui.value
        val t = u.template
        if (t == null || u.created.isEmpty()) return
        viewModelScope.launch {
            update { it.copy(printMsg = null, printError = null) }
            var ok = 0
            var firstErr: String? = null
            for (e in u.created) {
                val r = PrintManager.printLabel(profile, t, e.code, e.name)
                if (r.isSuccess) ok++
                else if (firstErr == null) firstErr = r.exceptionOrNull()?.message
            }
            if (ok == u.created.size) {
                update { it.copy(printMsg = "Отправлено на печать: $ok шт (${PrintManager.describe(profile)})") }
            } else {
                update {
                    it.copy(
                        printError = "Напечатано $ok из ${u.created.size}" +
                            (firstErr?.let { " — " + it } ?: "")
                    )
                }
            }
        }
    }

    fun backToSetup() {
        update {
            it.copy(phase = Phase.SETUP, error = null, galleryMsg = null, printMsg = null, printError = null)
        }
    }

    init {
        viewModelScope.launch {
            attrDefs.value = Deps.attributes.forScope("item")
        }
        viewModelScope.launch {
            Deps.locations.observeAll().collect { l ->
                locations.value = l.sortedBy { it.label.ifEmpty { it.name } }
            }
        }
        viewModelScope.launch {
            Deps.db.labelTemplateDao().observeAll().collect { list ->
                val cur = ui.value
                val t = list.firstOrNull { it.id == cur.template?.id } ?: list.firstOrNull()
                update { it.copy(templates = list, template = t) }
            }
        }
        viewModelScope.launch {
            Deps.db.printerDao().observeAll().collect { list ->
                update { it.copy(profiles = list) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BatchEntryScreen(nav: NavController) {
    val vm: BatchVm = viewModel()
    val ui by vm.ui.collectAsState()
    val defs by vm.attrDefs.collectAsState()
    val locations by vm.locations.collectAsState()
    val ctx = LocalContext.current
    var showLocationPicker by remember { mutableStateOf(false) }
    var showTemplatePicker by remember { mutableStateOf(false) }
    var showPrintPicker by remember { mutableStateOf(false) }
    var showCancelConfirm by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Серия вещей") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        when (ui.phase) {
            BatchVm.Phase.SETUP -> SetupPhase(vm, ui, defs) { showLocationPicker = true }
            BatchVm.Phase.LOOP -> LoopPhase(vm, ui, defs) { showCancelConfirm = true }
            BatchVm.Phase.DONE -> DonePhase(
                vm, ui, ctx, nav,
                onPickTemplate = { showTemplatePicker = true },
                onPrint = {
                    if (ui.profiles.size == 1) vm.printAll(ui.profiles.first())
                    else showPrintPicker = true
                }
            )
        }
    }

    if (showLocationPicker) {
        LocationPickerDialog(
            locations = locations,
            currentId = ui.locationId,
            onPick = { id -> vm.setLocation(id) },
            onDismiss = { showLocationPicker = false }
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
                vm.printAll(p)
                showPrintPicker = false
            },
            onManage = {
                showPrintPicker = false
                nav.navigate("printers")
            },
            onDismiss = { showPrintPicker = false }
        )
    }
    if (showCancelConfirm) {
        ConfirmDialog(
            title = "Прервать серию?",
            message = if (ui.created.isEmpty())
                "Серия будет отменена."
            else
                "Уже созданные вещи (${ui.created.size}) останутся в базе.",
            confirmLabel = "Прервать",
            onConfirm = { vm.backToSetup() },
            onDismiss = { showCancelConfirm = false }
        )
    }
}

@Composable
private fun SetupPhase(vm: BatchVm, ui: BatchVm.Ui, defs: List<AttributeDefEntity>, onPickLocation: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Однотипные вещи одной серией: автонумерация продолжается, общие поля копируются.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(Modifier.height(12.dp))
        FieldRow("Название (шаблон) *") {
            OutlinedTextField(
                value = ui.namePattern,
                onValueChange = { vm.setName(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Напр.: Гвозди 3×70 или Батарея AA {n}") },
                supportingText = { Text("{n} — номер позиции в серии") },
                singleLine = true
            )
        }
        FieldRow("Где хранится") {
            OutlinedButton(onClick = onPickLocation, modifier = Modifier.fillMaxWidth()) {
                Text(vm.locationName() ?: "— без ящика —")
            }
            if (vm.locationName() != null) {
                TextButton(onClick = { vm.setLocation(null) }) {
                    Text("Сбросить", color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
        FieldRow("Описание (общее)") {
            OutlinedTextField(
                value = ui.description,
                onValueChange = { vm.setDescription(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Комментарий для всех вещей серии") }
            )
        }
        FieldRow("Количество") {
            OutlinedTextField(
                value = ui.count,
                onValueChange = { vm.setCount(it) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )
        }
        if (defs.isNotEmpty()) {
            SectionTitle("Атрибуты")
            Text(
                "Галочка «для каждого» — поле вводится заново для каждой вещи. Остальные копируются.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(4.dp))
            defs.forEach { def ->
                BatchAttrField(
                    def = def,
                    value = ui.attrs[def.key] ?: "",
                    perItem = def.key in ui.perItemKeys,
                    onChange = { v -> vm.setSetupAttr(def.key, v) },
                    onTogglePerItem = { vm.togglePerItem(def.key) }
                )
            }
        }
        ui.error?.let {
            Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 12.dp))
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { vm.start() }, modifier = Modifier.fillMaxWidth()) {
            Text("Начать серию")
        }
    }
}

@Composable
private fun BatchAttrField(
    def: AttributeDefEntity,
    value: String,
    perItem: Boolean,
    onChange: (String) -> Unit,
    onTogglePerItem: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(def.label, modifier = Modifier.weight(1f), style = MaterialTheme.typography.labelLarge)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = perItem,
                    onCheckedChange = { onTogglePerItem() },
                    modifier = Modifier
                        .width(32.dp)
                        .height(32.dp)
                )
                Text(
                    "для каждого",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        when (def.type) {
            "bool" -> Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    if (value == "true" || value == "1") "Да" else "Нет",
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(Modifier.width(8.dp))
                Switch(
                    checked = value == "true" || value == "1",
                    onCheckedChange = { onChange(if (it) "true" else "") }
                )
            }

            "select" -> {
                val options = remember(def.options) { parseOptions(def.options) }
                if (options.isEmpty()) {
                    OutlinedTextField(
                        value = value,
                        onValueChange = onChange,
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                } else {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 2.dp)
                    ) {
                        options.forEach { opt ->
                            FilterChip(
                                selected = value == opt,
                                onClick = { onChange(if (value == opt) "" else opt) },
                                label = { Text(opt) },
                                modifier = Modifier.padding(end = 8.dp)
                            )
                        }
                    }
                }
            }

            else -> OutlinedTextField(
                value = value,
                onValueChange = onChange,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = if (def.type == "number") KeyboardType.Number else KeyboardType.Text
                ),
                singleLine = true
            )
        }
    }
}

@Composable
private fun LoopPhase(vm: BatchVm, ui: BatchVm.Ui, defs: List<AttributeDefEntity>, onCancel: () -> Unit) {
    val perItemDefs = defs.filter { it.key in ui.perItemKeys }
    val isLast = ui.index >= ui.totalCount
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Вещь ${ui.index} из ${ui.totalCount}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            ui.curName,
            style = MaterialTheme.typography.titleMedium
        )
        if (ui.created.isNotEmpty()) {
            Text(
                "Уже создано: ${ui.created.size}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(Modifier.height(12.dp))
        if (perItemDefs.isEmpty()) {
            Text(
                "Все атрибуты общие — просто подтверждайте создание.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            Text(
                "Поля серии «для каждого»:",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(4.dp))
            perItemDefs.forEach { def ->
                BatchAttrField(
                    def = def,
                    value = ui.curAttrs[def.key] ?: "",
                    perItem = true,
                    onChange = { v -> vm.setCurAttr(def.key, v) },
                    onTogglePerItem = { }
                )
            }
        }
        ui.error?.let {
            Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 12.dp))
        }
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick = { onCancel() },
                enabled = !ui.busy,
                modifier = Modifier.weight(1f)
            ) {
                Text("Отмена")
            }
            Button(
                onClick = { vm.next() },
                enabled = !ui.busy,
                modifier = Modifier.weight(2f)
            ) {
                Text(if (isLast) "Создать (последняя)" else "Далее")
            }
        }
    }
}

@Composable
private fun DonePhase(
    vm: BatchVm,
    ui: BatchVm.Ui,
    ctx: Context,
    nav: NavController,
    onPickTemplate: () -> Unit,
    onPrint: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Серия завершена — создано ${ui.created.size} вещей",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp),
            contentPadding = PaddingValues(vertical = 4.dp)
        ) {
            items(ui.created, key = { it.id }) { e ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 2.dp)
                        .clickable { nav.navigate("item/${e.id}") }
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(e.name, style = MaterialTheme.typography.bodyLarge, maxLines = 1)
                        Text(
                            e.code,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        Spacer(Modifier.height(8.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                "Шаблон: ${ui.template?.name ?: "нет шаблона"}",
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium
            )
            TextButton(onClick = { onPickTemplate() }) {
                Text("Сменить")
            }
        }
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { vm.saveLabelsToGallery(ctx) },
                enabled = ui.template != null,
                modifier = Modifier.weight(1f)
            ) {
                Text("Этикетки в галерею")
            }
            OutlinedButton(
                onClick = { onPrint() },
                enabled = ui.template != null && ui.profiles.isNotEmpty(),
                modifier = Modifier.weight(1f)
            ) {
                Text("Печать")
            }
        }
        ui.galleryMsg?.let {
            Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
        }
        ui.printMsg?.let {
            Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
        }
        ui.printError?.let {
            Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = { vm.backToSetup() }, modifier = Modifier.fillMaxWidth()) {
            Text("Ещё одна серия")
        }
    }
}
