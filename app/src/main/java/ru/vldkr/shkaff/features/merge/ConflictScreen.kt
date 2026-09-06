package ru.vldkr.shkaff.features.merge

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.sync.Conflict
import ru.vldkr.shkaff.sync.MergeSession
import ru.vldkr.shkaff.sync.PendingMerge
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import androidx.lifecycle.viewmodel.compose.viewModel

class ConflictsVm : ViewModel() {

    data class Ui(
        val pending: PendingMerge? = null,
        val resolutions: Map<String, String> = emptyMap(),
        val busy: Boolean = false,
        val error: String? = null
    )

    val ui = MutableStateFlow(Ui())

    private fun update(f: (Ui) -> Ui) {
        ui.value = f(ui.value)
    }

    init {
        val p = MergeSession.pending
        if (p != null) update { it.copy(pending = p) }
    }

    fun resolve(conflict: Conflict, choice: String) {
        val key = MergeSession.resolutionKey(conflict.table, conflict.id)
        update { it.copy(resolutions = it.resolutions + (key to choice)) }
    }

    fun applyMerge(ctx: Context, onApplied: () -> Unit) {
        viewModelScope.launch {
            val p = ui.value.pending ?: return@launch
            if (ui.value.resolutions.size < p.result.conflicts.size) return@launch
            update { it.copy(busy = true, error = null) }
            runCatching {
                MergeSession.commitMerge(ctx, p, ui.value.resolutions)
            }.fold(
                onSuccess = {
                    MergeSession.clear()
                    update { it.copy(busy = false) }
                    onApplied()
                },
                onFailure = { e ->
                    update { it.copy(busy = false, error = e.message ?: "Ошибка применения слияния") }
                }
            )
        }
    }
}

private fun ts(t: Long?): String {
    if (t == null || t <= 0) return "—"
    return try {
        Instant.ofEpochMilli(t).atZone(ZoneId.systemDefault())
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
    } catch (e: Exception) {
        t.toString()
    }
}

private fun yesNo(b: Boolean): String = if (b) "да" else "нет"

private fun attrText(json: String?): String {
    val m = AttrJson.toMap(json)
    if (m.isEmpty()) return "—"
    return m.entries.joinToString("; ") { "${it.key}: ${it.value}" }
}

private fun locationLabels(p: PendingMerge): Map<String, String> {
    val out = LinkedHashMap<String, String>()
    (p.local.locations + p.remote.locations).forEach { l ->
        out[l.id] = l.label.ifBlank { l.name }.ifBlank { "Ящик" }
    }
    return out
}

private fun tableTitle(table: String): String = when (table) {
    "items" -> "Вещь"
    "storages" -> "Хранилище"
    "locations" -> "Ящик"
    "attribute_defs" -> "Словарь"
    "annotations" -> "Разметка"
    "label_templates" -> "Шаблон"
    "printers" -> "Принтер"
    else -> table
}

private fun fieldsOf(local: Any?, remote: Any?, locations: Map<String, String>): List<Triple<String, String, String>> = when {
    local is ItemEntity || remote is ItemEntity -> {
        val l = local as? ItemEntity
        val r = remote as? ItemEntity
        fun loc(id: String?): String = id?.let { locations[it] ?: it } ?: "—"
        listOf(
            Triple("Название", l?.name?.takeIf { it.isNotBlank() } ?: "—", r?.name?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Код", l?.code?.takeIf { it.isNotBlank() } ?: "—", r?.code?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Описание", l?.description?.takeIf { it.isNotBlank() } ?: "—", r?.description?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Ящик", loc(l?.location_id), loc(r?.location_id)),
            Triple("Атрибуты", attrText(l?.attributes), attrText(r?.attributes)),
            Triple("Удалена", yesNo(l?.deleted_at != null), yesNo(r?.deleted_at != null)),
            Triple("Изменена", ts(l?.updated_at), ts(r?.updated_at))
        )
    }

    local is StorageEntity || remote is StorageEntity -> {
        val l = local as? StorageEntity
        val r = remote as? StorageEntity
        listOf(
            Triple("Название", l?.name?.takeIf { it.isNotBlank() } ?: "—", r?.name?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Описание", l?.description?.takeIf { it.isNotBlank() } ?: "—", r?.description?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Атрибуты", attrText(l?.attributes), attrText(r?.attributes)),
            Triple("Удалено", yesNo(l?.deleted_at != null), yesNo(r?.deleted_at != null)),
            Triple("Изменено", ts(l?.updated_at), ts(r?.updated_at))
        )
    }

    local is LocationEntity || remote is LocationEntity -> {
        val l = local as? LocationEntity
        val r = remote as? LocationEntity
        listOf(
            Triple("Обозначение", l?.label?.takeIf { it.isNotBlank() } ?: "—", r?.label?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Имя", l?.name?.takeIf { it.isNotBlank() } ?: "—", r?.name?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Атрибуты", attrText(l?.attributes), attrText(r?.attributes)),
            Triple("Удалён", yesNo(l?.deleted_at != null), yesNo(r?.deleted_at != null)),
            Triple("Изменён", ts(l?.updated_at), ts(r?.updated_at))
        )
    }

    local is AttributeDefEntity || remote is AttributeDefEntity -> {
        val l = local as? AttributeDefEntity
        val r = remote as? AttributeDefEntity
        listOf(
            Triple("Поле", "${l?.key} / ${l?.label}", "${r?.key} / ${r?.label}"),
            Triple("Тип", l?.type ?: "—", r?.type ?: "—"),
            Triple("Варианты", l?.options ?: "—", r?.options ?: "—"),
            Triple("Обязательное", yesNo(l?.required == true), yesNo(r?.required == true))
        )
    }

    local is LabelTemplateEntity || remote is LabelTemplateEntity -> {
        val l = local as? LabelTemplateEntity
        val r = remote as? LabelTemplateEntity
        listOf(
            Triple("Имя", l?.name ?: "—", r?.name ?: "—"),
            Triple("Формат", l?.format ?: "—", r?.format ?: "—"),
            Triple("Размер, мм", "${l?.width_mm}×${l?.height_mm}", "${r?.width_mm}×${r?.height_mm}"),
            Triple("Текст", l?.text_content ?: "—", r?.text_content ?: "—")
        )
    }

    local is AnnotationEntity || remote is AnnotationEntity -> {
        val l = local as? AnnotationEntity
        val r = remote as? AnnotationEntity
        listOf(
            Triple("Подпись", l?.label?.takeIf { it.isNotBlank() } ?: "—", r?.label?.takeIf { it.isNotBlank() } ?: "—"),
            Triple("Форма", l?.shape ?: "—", r?.shape ?: "—"),
            Triple("Цвет", l?.color ?: "—", r?.color ?: "—")
        )
    }

    local is PrinterProfileEntity || remote is PrinterProfileEntity -> {
        val l = local as? PrinterProfileEntity
        val r = remote as? PrinterProfileEntity
        listOf(
            Triple("Имя", l?.name ?: "—", r?.name ?: "—"),
            Triple("Транспорт", l?.transport ?: "—", r?.transport ?: "—"),
            Triple("Адрес", (l?.host ?: "") + if ((l?.port ?: 0) > 0) ":${l?.port}" else "", (r?.host ?: "") + if ((r?.port ?: 0) > 0) ":${r?.port}" else ""),
            Triple("BT MAC", l?.bt_mac?.takeIf { it.isNotBlank() } ?: "—", r?.bt_mac?.takeIf { it.isNotBlank() } ?: "—")
        )
    }

    else -> emptyList()
}

@Composable
private fun ConflictCard(
    conflict: Conflict,
    localRow: Any?,
    remoteRow: Any?,
    choice: String?,
    locations: Map<String, String>,
    onPick: (String) -> Unit
) {
    Card(Modifier.fillMaxWidth().padding(vertical = 6.dp)) {
        Column(Modifier.padding(12.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    conflict.label.ifBlank { conflict.id },
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.weight(1f),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    tableTitle(conflict.table),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.height(8.dp))
            Row(Modifier.fillMaxWidth()) {
                Text("Эта база", style = MaterialTheme.typography.labelLarge, modifier = Modifier.weight(1f))
                Text("Из файла", style = MaterialTheme.typography.labelLarge, modifier = Modifier.weight(1f))
            }
            fieldsOf(localRow, remoteRow, locations).forEach { (label, lv, rv) ->
                Column(Modifier.padding(vertical = 4.dp)) {
                    Text(label, style = MaterialTheme.typography.labelLarge)
                    Row(Modifier.fillMaxWidth()) {
                        Text(lv, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f), maxLines = 2, overflow = TextOverflow.Ellipsis)
                        Spacer(Modifier.width(12.dp))
                        Text(rv, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.weight(1f), maxLines = 2, overflow = TextOverflow.Ellipsis)
                    }
                }
            }
            Spacer(Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (choice == "local") {
                    Button(onClick = { onPick("local") }, modifier = Modifier.weight(1f)) { Text("Эта база") }
                } else {
                    OutlinedButton(onClick = { onPick("local") }, modifier = Modifier.weight(1f)) { Text("Эта база") }
                }
                if (choice == "remote") {
                    Button(onClick = { onPick("remote") }, modifier = Modifier.weight(1f)) { Text("Из файла") }
                } else {
                    OutlinedButton(onClick = { onPick("remote") }, modifier = Modifier.weight(1f)) { Text("Из файла") }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConflictsScreen(nav: NavController) {
    val ctx = LocalContext.current
    val vm: ConflictsVm = viewModel()
    val ui by vm.ui.collectAsState()
    val pending = ui.pending
    val conflicts = pending?.result?.conflicts ?: emptyList()
    val resolved = ui.resolutions.size
    val locations = pending?.let { locationLabels(it) } ?: emptyMap()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Конфликты слияния") },
                navigationIcon = {
                    IconButton(onClick = {
                        MergeSession.clear()
                        nav.popBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Отменить импорт")
                    }
                }
            )
        }
    ) { padding ->
        if (pending == null) {
            Column(
                Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Text(
                    "Нет активного слияния. Импортируйте файл бэкапа на экране «Экспорт / импорт».",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            Column(
                Modifier
                    .padding(padding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    "Разрешено $resolved из ${conflicts.size}. По каждой записи выберите, что оставить: версию из этой базы или из файла.",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                if (pending.warnings.isNotEmpty()) {
                    pending.warnings.forEach { w ->
                        Text(w, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.error)
                    }
                    Spacer(Modifier.height(8.dp))
                }
                conflicts.forEach { c ->
                    ConflictCard(
                        conflict = c,
                        localRow = MergeSession.rowOf(pending.local, c.table, c.id),
                        remoteRow = MergeSession.rowOf(pending.remote, c.table, c.id),
                        choice = ui.resolutions[MergeSession.resolutionKey(c.table, c.id)],
                        locations = locations,
                        onPick = { vm.resolve(c, it) }
                    )
                }
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { vm.applyMerge(ctx) { nav.popBackStack() } },
                    enabled = resolved == conflicts.size && !ui.busy,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (ui.busy) {
                        CircularProgressIndicator(modifier = Modifier.size(20.dp))
                        Spacer(Modifier.width(8.dp))
                    }
                    Text("Применить слияние")
                }
                ui.error?.let {
                    Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(top = 8.dp))
                }
            }
        }
    }
}
