package ru.vldkr.shkaff.features.labels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.newId

class TemplatesVm : ViewModel() {

    data class Ui(
        val templates: List<LabelTemplateEntity> = emptyList(),
        val error: String? = null,
        // T-046: форма живёт в Ui-state. Раньше Form c plain var держалась в
        // mutableStateOf отдельно — держатель отслеживал только смену ссылки,
        // запись в поле (чекбокс/формат) не инвалидировала композицию.
        // Форма неизменяемая: каждая правка — copy и новый экземпляр Ui.
        val form: Form? = null
    )

    val ui = MutableStateFlow(Ui())

    data class Form(
        val id: String? = null,
        val name: String = "",
        val format: String = "QR",
        val widthMm: String = "58",
        val heightMm: String = "40",
        val marginMm: String = "3",
        val showText: Boolean = true,
        val textContent: String = "{name}",
        val textPosition: String = "bottom",
        val showNumber: Boolean = true,
        val appLink: Boolean = false,
        val fontSize: String = "12",
        val textColor: String = "#000000",
        val bgColor: String = "#FFFFFF",
        val invert: Boolean = false,
        val quietZone: Boolean = true
    )

    init {
        viewModelScope.launch {
            Deps.db.labelTemplateDao().observeAll().collect { ui.value = ui.value.copy(templates = it) }
        }
    }

    fun openNew() {
        ui.value = ui.value.copy(error = null, form = Form())
    }

    fun openEdit(t: LabelTemplateEntity) {
        ui.value = ui.value.copy(
            error = null,
            form = Form(
                id = t.id,
                name = t.name,
                format = t.format,
                widthMm = t.width_mm.toString(),
                heightMm = t.height_mm.toString(),
                marginMm = t.margin_mm.toString(),
                showText = t.show_text,
                textContent = t.text_content,
                textPosition = t.text_position,
                showNumber = t.show_number,
                appLink = t.app_link,
                fontSize = t.font_size.toString(),
                textColor = t.text_color,
                bgColor = t.bg_color,
                invert = t.invert,
                quietZone = t.quiet_zone
            )
        )
    }

    fun closeForm() { ui.value = ui.value.copy(form = null) }

    // Единственная точка правки формы: copy -> новый Ui -> инвалидация композиции.
    fun editForm(edit: (Form) -> Form) {
        val f = ui.value.form ?: return
        ui.value = ui.value.copy(form = edit(f))
    }

    fun save() {
        val f = ui.value.form ?: return
        val w = f.widthMm.toDoubleOrNull()
        val h = f.heightMm.toDoubleOrNull()
        val m = f.marginMm.toDoubleOrNull()
        val fs = f.fontSize.toDoubleOrNull()
        if (f.name.isBlank()) { ui.value = ui.value.copy(error = "Введите название шаблона"); return }
        if (w == null || h == null || w < 10 || h < 10) { ui.value = ui.value.copy(error = "Ширина/высота — число от 10 мм"); return }
        if (m == null || m < 0) { ui.value = ui.value.copy(error = "Поля — число от 0 мм"); return }
        if (fs == null || fs < 6) { ui.value = ui.value.copy(error = "Размер шрифта — число от 6"); return }
        if (f.bgColor.isBlank() || f.textColor.isBlank()) { ui.value = ui.value.copy(error = "Укажите цвета"); return }
        if (f.textPosition != "top" && f.textPosition != "bottom") { ui.value = ui.value.copy(error = "Выберите расположение текста"); return }
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            val dev = Deps.deviceId
            val id = f.id ?: newId()
            val dao = Deps.db.labelTemplateDao()
            val existing = dao.byId(id)
            // T-045: форма покрывает только часть полей. У существующего шаблона
            // (upsert — REPLACE) остальные поля обязаны переписаться из сохранённой
            // записи, иначе правка имени зонального шаблона молча возвращает
            // layout_mode=classic, qr_count=1, qr_scale=1, обнуляет смещения на
            // листе, label_attrs и logo_path.
            val t = if (existing != null) existing.copy(
                name = f.name.trim(),
                format = f.format,
                width_mm = w,
                height_mm = h,
                margin_mm = m,
                show_text = f.showText,
                text_content = f.textContent,
                text_position = f.textPosition,
                show_number = f.showNumber,
                app_link = f.appLink,
                font_size = fs,
                text_color = f.textColor,
                bg_color = f.bgColor,
                invert = f.invert,
                quiet_zone = f.quietZone,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev
            ) else LabelTemplateEntity(
                id = id,
                name = f.name.trim(),
                format = f.format,
                width_mm = w,
                height_mm = h,
                margin_mm = m,
                show_text = f.showText,
                text_content = f.textContent,
                text_position = f.textPosition,
                show_number = f.showNumber,
                app_link = f.appLink,
                font_size = fs,
                text_color = f.textColor,
                bg_color = f.bgColor,
                invert = f.invert,
                quiet_zone = f.quietZone,
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev
            )
            dao.upsert(t)
            ui.value = ui.value.copy(form = null)
        }
    }

    fun delete(t: LabelTemplateEntity) {
        viewModelScope.launch {
            Deps.db.labelTemplateDao().softDelete(t.id, System.currentTimeMillis(), Deps.deviceId)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TemplatesScreen(nav: NavController) {
    val vm: TemplatesVm = viewModel()
    val ui by vm.ui.collectAsState()
    var confirmDelete by remember { mutableStateOf<LabelTemplateEntity?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Шаблоны этикеток") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { vm.openNew() }) {
                        Icon(Icons.Filled.Add, contentDescription = "Добавить")
                    }
                }
            )
        }
    ) { padding ->
        if (ui.form != null) {
            TemplateFormContent(vm)
            return@Scaffold
        }
        LazyColumn(
            Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp)
        ) {
            if (ui.templates.isEmpty()) {
                // П1.4: пустой список шаблонов — один CTA «создать шаблон» (тот же vm.openNew, что и «+»).
                item {
                    EmptyState(
                        "Шаблонов пока нет.\nШаблон задаёт размер этикетки, QR и подписи — по нему печатаются все наклейки.",
                        actionLabel = EmptyStateCta.NEW_TEMPLATE,
                        onAction = { vm.openNew() }
                    )
                }
            }
            items(ui.templates, key = { it.id }) { t ->
                Card(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
                    Row(Modifier.padding(12.dp)) {
                        Column(Modifier.weight(1f)) {
                            Text(t.name, style = MaterialTheme.typography.titleMedium)
                            Text(
                                "${t.format} · ${t.width_mm.toInt()}×${t.height_mm.toInt()} мм · ${if (t.show_text) "с текстом" else "без текста"} · ${if (t.text_position == "top") "текст сверху" else "текст снизу"} · ${if (t.app_link) "ссылка" else "код"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        TextButton(onClick = { vm.openEdit(t) }) { Text("Изменить") }
                        TextButton(onClick = { confirmDelete = t }) {
                            Text("Удалить", color = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            }
        }

        confirmDelete?.let { t ->
            AlertDialog(
                onDismissRequest = { confirmDelete = null },
                title = { Text("Удалить шаблон?") },
                text = { Text("«${t.name}» исчезнет из списка шаблонов.") },
                confirmButton = {
                    TextButton(onClick = {
                        confirmDelete = null
                        vm.delete(t)
                    }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
                },
                dismissButton = {
                    TextButton(onClick = { confirmDelete = null }) { Text("Отмена") }
                }
            )
        }
    }
}

@Composable
private fun TemplateFormContent(vm: TemplatesVm) {
    val ui by vm.ui.collectAsState()
    val f = ui.form ?: return
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SectionTitle(if (f.id == null) "Новый шаблон" else "Шаблон")
        OutlinedTextField(
            value = f.name,
            onValueChange = { v -> vm.editForm { it.copy(name = v) } },
            label = { Text("Название *") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(Modifier.height(12.dp))
        Text("Формат", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.height(4.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            LabelGenerator.FORMATS.forEach { fmt ->
                val selected = f.format == fmt
                OutlinedButton(
                    onClick = { vm.editForm { it.copy(format = fmt) } },
                    modifier = Modifier.weight(1f),
                    // T-046: выбранный формат подсвечен (ср. LabelsScreen),
                    // раньше val selected нигде не использовался.
                    colors = if (selected) ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                            else ButtonDefaults.outlinedButtonColors()
                ) {
                    Text(fmt, style = MaterialTheme.typography.labelSmall)
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = f.widthMm,
                onValueChange = { v -> vm.editForm { it.copy(widthMm = v) } },
                label = { Text("Ширина, мм") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = f.heightMm,
                onValueChange = { v -> vm.editForm { it.copy(heightMm = v) } },
                label = { Text("Высота, мм") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = f.marginMm,
                onValueChange = { v -> vm.editForm { it.copy(marginMm = v) } },
                label = { Text("Поля, мм") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }
        Spacer(Modifier.height(12.dp))
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = f.showText, onCheckedChange = { v -> vm.editForm { it.copy(showText = v) } })
            Text("Текст на этикетке", style = MaterialTheme.typography.bodyMedium)
        }
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = f.showNumber, onCheckedChange = { v -> vm.editForm { it.copy(showNumber = v) } })
            Text("Номер объекта (код) вместе с кодом", style = MaterialTheme.typography.bodyMedium)
        }
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = f.appLink, onCheckedChange = { v -> vm.editForm { it.copy(appLink = v) } })
            Text("QR — ссылка на приложение (открывает «Шкаф» по скану)", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(4.dp))
        Text("Расположение надписей", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.height(4.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(
                onClick = { vm.editForm { it.copy(textPosition = "top") } },
                modifier = Modifier.weight(1f),
                colors = if (f.textPosition == "top") ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        else ButtonDefaults.outlinedButtonColors()
            ) {
                Text("Над кодом", style = MaterialTheme.typography.labelLarge)
            }
            OutlinedButton(
                onClick = { vm.editForm { it.copy(textPosition = "bottom") } },
                modifier = Modifier.weight(1f),
                colors = if (f.textPosition == "bottom") ButtonDefaults.outlinedButtonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                        else ButtonDefaults.outlinedButtonColors()
            ) {
                Text("Под кодом", style = MaterialTheme.typography.labelLarge)
            }
        }
        if (f.showText) {
            OutlinedTextField(
                value = f.textContent,
                onValueChange = { v -> vm.editForm { it.copy(textContent = v) } },
                label = { Text("Текст") },
                supportingText = { Text("Плейсхолдеры: {name}, {code}") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = f.fontSize,
                onValueChange = { v -> vm.editForm { it.copy(fontSize = v) } },
                label = { Text("Размер шрифта, pt") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = f.textColor,
                    onValueChange = { v -> vm.editForm { it.copy(textColor = v) } },
                    label = { Text("Цвет текста") },
                    supportingText = { Text("HEX, напр. #000000") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = f.bgColor,
                    onValueChange = { v -> vm.editForm { it.copy(bgColor = v) } },
                    label = { Text("Цвет фона") },
                    supportingText = { Text("HEX, напр. #FFFFFF") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(checked = f.invert, onCheckedChange = { v -> vm.editForm { it.copy(invert = v) } })
                Text("Инвертировать (белый код на тёмном)", style = MaterialTheme.typography.bodyMedium)
            }
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(checked = f.quietZone, onCheckedChange = { v -> vm.editForm { it.copy(quietZone = v) } })
                Text("Тихая зона (поля) у кода", style = MaterialTheme.typography.bodyMedium)
            }
        }
        ui.error?.let {
            Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 12.dp))
        }
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { vm.save() }, modifier = Modifier.weight(1f)) { Text("Сохранить") }
            OutlinedButton(onClick = { vm.closeForm() }, modifier = Modifier.weight(1f)) { Text("Отмена") }
        }
    }
}

@Composable
fun TemplatePickerDialog(
    templates: List<LabelTemplateEntity>,
    currentId: String?,
    onPick: (String) -> Unit,
    onManage: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Шаблон этикетки") },
        text = {
            Column {
                templates.forEach { t ->
                    Row(Modifier.padding(vertical = 4.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                        Text(
                            "${t.name}  ·  ${t.format}",
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        if (t.id == currentId) {
                            Text("•", color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleMedium)
                        }
                    }
                    TextButton(onClick = { onPick(t.id) }, modifier = Modifier.fillMaxWidth()) {
                        Text(if (t.id == currentId) "Выбран" else "Выбрать")
                    }
                }
                if (templates.isEmpty()) {
                    Text("Шаблонов нет", style = MaterialTheme.typography.bodyLarge)
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onManage) { Text("Управлять шаблонами") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}
