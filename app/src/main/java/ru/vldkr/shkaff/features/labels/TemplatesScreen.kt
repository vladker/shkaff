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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.newId

class TemplatesVm : ViewModel() {

    val templates = MutableStateFlow<List<LabelTemplateEntity>>(emptyList())

    data class Form(
        val id: String? = null,
        var name: String = "",
        var format: String = "QR",
        var widthMm: String = "58",
        var heightMm: String = "40",
        var marginMm: String = "3",
        var showText: Boolean = true,
        var textContent: String = "{name}",
        var textPosition: String = "bottom",
        var showNumber: Boolean = true,
        var appLink: Boolean = false,
        var fontSize: String = "12",
        var textColor: String = "#000000",
        var bgColor: String = "#FFFFFF",
        var invert: Boolean = false,
        var quietZone: Boolean = true
    )

    var form: Form? by mutableStateOf(null)
    val error = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            Deps.db.labelTemplateDao().observeAll().collect { templates.value = it }
        }
    }

    fun openNew() {
        error.value = null
        form = Form()
    }

    fun openEdit(t: LabelTemplateEntity) {
        error.value = null
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
    }

    fun closeForm() { form = null }

    fun save() {
        val f = form ?: return
        val w = f.widthMm.toDoubleOrNull()
        val h = f.heightMm.toDoubleOrNull()
        val m = f.marginMm.toDoubleOrNull()
        val fs = f.fontSize.toDoubleOrNull()
        if (f.name.isBlank()) { error.value = "Введите название шаблона"; return }
        if (w == null || h == null || w < 10 || h < 10) { error.value = "Ширина/высота — число от 10 мм"; return }
        if (m == null || m < 0) { error.value = "Поля — число от 0 мм"; return }
        if (fs == null || fs < 6) { error.value = "Размер шрифта — число от 6"; return }
        if (f.bgColor.isBlank() || f.textColor.isBlank()) { error.value = "Укажите цвета"; return }
        if (f.textPosition != "top" && f.textPosition != "bottom") { error.value = "Выберите расположение текста"; return }
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            val dev = Deps.deviceId
            val id = f.id ?: newId()
            val t = LabelTemplateEntity(
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
                logo_path = null,
                quiet_zone = f.quietZone,
                created_at = Deps.db.labelTemplateDao().byId(id)?.created_at ?: now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = dev
            )
            Deps.db.labelTemplateDao().upsert(t)
            form = null
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
    val list by vm.templates.collectAsState()
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
        if (vm.form != null) {
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
            if (list.isEmpty()) {
                item {
                    Text(
                        "Шаблонов пока нет. Нажмите «+» чтобы создать.",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(vertical = 24.dp)
                    )
                }
            }
            items(list, key = { it.id }) { t ->
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
    val f = vm.form!!
    val error by vm.error.collectAsState()
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        SectionTitle(if (f.id == null) "Новый шаблон" else "Шаблон")
        OutlinedTextField(
            value = f.name,
            onValueChange = { f.name = it },
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
                OutlinedButton(onClick = { f.format = fmt }, modifier = Modifier.weight(1f)) {
                    Text(fmt, style = MaterialTheme.typography.labelSmall)
                }
            }
        }
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
                value = f.widthMm,
                onValueChange = { f.widthMm = it },
                label = { Text("Ширина, мм") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = f.heightMm,
                onValueChange = { f.heightMm = it },
                label = { Text("Высота, мм") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
            OutlinedTextField(
                value = f.marginMm,
                onValueChange = { f.marginMm = it },
                label = { Text("Поля, мм") },
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }
        Spacer(Modifier.height(12.dp))
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = f.showText, onCheckedChange = { f.showText = it })
            Text("Текст на этикетке", style = MaterialTheme.typography.bodyMedium)
        }
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = f.showNumber, onCheckedChange = { f.showNumber = it })
            Text("Номер объекта (код) вместе с кодом", style = MaterialTheme.typography.bodyMedium)
        }
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Checkbox(checked = f.appLink, onCheckedChange = { f.appLink = it })
            Text("QR — ссылка на приложение (открывает «Шкаф» по скану)", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(Modifier.height(4.dp))
        Text("Расположение надписей", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.height(4.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = { f.textPosition = "top" }, modifier = Modifier.weight(1f)) {
                Text("Над кодом", style = MaterialTheme.typography.labelLarge)
            }
            OutlinedButton(onClick = { f.textPosition = "bottom" }, modifier = Modifier.weight(1f)) {
                Text("Под кодом", style = MaterialTheme.typography.labelLarge)
            }
        }
        if (f.showText) {
            OutlinedTextField(
                value = f.textContent,
                onValueChange = { f.textContent = it },
                label = { Text("Текст") },
                supportingText = { Text("Плейсхолдеры: {name}, {code}") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))
            OutlinedTextField(
                value = f.fontSize,
                onValueChange = { f.fontSize = it },
                label = { Text("Размер шрифта, pt") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(
                    value = f.textColor,
                    onValueChange = { f.textColor = it },
                    label = { Text("Цвет текста") },
                    supportingText = { Text("HEX, напр. #000000") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                OutlinedTextField(
                    value = f.bgColor,
                    onValueChange = { f.bgColor = it },
                    label = { Text("Цвет фона") },
                    supportingText = { Text("HEX, напр. #FFFFFF") },
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(checked = f.invert, onCheckedChange = { f.invert = it })
                Text("Инвертировать (белый код на тёмном)", style = MaterialTheme.typography.bodyMedium)
            }
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(checked = f.quietZone, onCheckedChange = { f.quietZone = it })
                Text("Тихая зона (поля) у кода", style = MaterialTheme.typography.bodyMedium)
            }
        }
        error?.let {
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
