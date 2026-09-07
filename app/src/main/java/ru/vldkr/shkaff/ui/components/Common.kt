package ru.vldkr.shkaff.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps

@Composable
fun SectionTitle(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier.padding(vertical = 12.dp)
    )
}

@Composable
fun EmptyState(text: String) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ConfirmDialog(
    title: String,
    message: String,
    confirmLabel: String = "Удалить",
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            TextButton(onClick = { onConfirm(); onDismiss() }) {
                Text(confirmLabel, color = MaterialTheme.colorScheme.error)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

@Composable
fun FieldRow(
    label: String,
    required: Boolean = false,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(Modifier.padding(vertical = 4.dp)) {
        Text(
            label + if (required) " *" else "",
            style = MaterialTheme.typography.labelLarge
        )
        content()
    }
}

fun parseOptions(json: String?): List<String> = AttrJson.parseOptions(json)

@Composable
fun AttrFields(
    defs: List<AttributeDefEntity>,
    values: Map<String, String>,
    onChange: (String, String) -> Unit
) {
    if (defs.isEmpty()) return
    Column(Modifier.fillMaxWidth()) {
        defs.forEach { def ->
            val v = values[def.key] ?: ""
            when (def.type) {
                "number" -> FieldRow(def.label, def.required) {
                    OutlinedTextField(
                        value = v,
                        onValueChange = { onChange(def.key, it) },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true
                    )
                }

                "bool" -> Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(def.label, modifier = Modifier.weight(1f))
                    Switch(checked = v == "true" || v == "1", onCheckedChange = { onChange(def.key, if (it) "true" else "") })
                }

                "select" -> SelectField(def, v, onChange)

                "date" -> FieldRow(def.label, def.required) {
                    OutlinedTextField(
                        value = v,
                        onValueChange = { onChange(def.key, it) },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("ГГГГ-ММ-ДД") },
                        singleLine = true
                    )
                }

                else -> FieldRow(def.label, def.required) {
                    OutlinedTextField(
                        value = v,
                        onValueChange = { onChange(def.key, it) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }
            }
        }
    }
}

@Composable
private fun SelectField(def: AttributeDefEntity, value: String, onChange: (String, String) -> Unit) {
    val options = remember(def.options) { parseOptions(def.options) }
    val scope = rememberCoroutineScope()
    var adding by remember { mutableStateOf(false) }
    var newOption by remember { mutableStateOf("") }
    val busy = remember { mutableStateOf(false) }

    fun commitOption() {
        val t = newOption.trim()
        if (t.isEmpty() || busy.value) return
        busy.value = true
        scope.launch {
            try {
                Deps.attributes.addOption(def.id, t, Deps.deviceId)
            } finally {
                busy.value = false
            }
        }
        onChange(def.key, t)
        newOption = ""
        adding = false
    }

    Column(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(
            def.label + if (def.required) " *" else "",
            style = MaterialTheme.typography.labelLarge
        )
        if (adding) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            ) {
                OutlinedTextField(
                    value = newOption,
                    onValueChange = { newOption = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Новое значение") },
                    singleLine = true
                )
                TextButton(onClick = { commitOption() }, modifier = Modifier.padding(start = 4.dp)) {
                    Text("Добавить")
                }
                IconButton(onClick = { adding = false; newOption = "" }) {
                    Icon(Icons.Filled.Close, contentDescription = "Отмена")
                }
            }
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                options.forEach { opt ->
                    FilterChip(
                        selected = value == opt,
                        onClick = { onChange(def.key, if (value == opt) "" else opt) },
                        label = { Text(opt) },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                FilterChip(
                    selected = false,
                    onClick = { adding = true },
                    label = { Text("+ значение") },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }
}

// IDs самого узла и всех его потомков — чтобы при выборе родителя исключить цикл
fun <T> subtreeIds(
    rootId: String,
    all: List<T>,
    idOf: (T) -> String,
    parentOf: (T) -> String?
): Set<String> {
    val byParent = all.groupBy { parentOf(it) ?: "" }
    val result = mutableSetOf<String>()
    val queue = ArrayDeque<String>()
    queue.add(rootId)
    while (queue.isNotEmpty()) {
        byParent[queue.removeFirst()]?.forEach { child ->
            val cid = idOf(child)
            if (result.add(cid)) queue.add(cid)
        }
    }
    return result
}

private data class PickerRow(val text: String, val id: String?, val depth: Int)

// Плоский список строк дерева (сироты — на верхнем уровне, защита от циклов)
private fun <T> treeRows(
    all: List<T>,
    labelOf: (T) -> String,
    idOf: (T) -> String,
    parentOf: (T) -> String?
): List<PickerRow> {
    val byId = all.associateBy { idOf(it) }
    val byParent = all.groupBy { parentOf(it) ?: "" }
    val out = mutableListOf<PickerRow>()
    val seen = mutableSetOf<String>()
    fun rec(id: String, depth: Int) {
        if (!seen.add(id)) return
        byId[id]?.let { out += PickerRow(labelOf(it), id, depth) }
        (byParent[id] ?: emptyList()).forEach { rec(idOf(it), depth + 1) }
    }
    all.forEach { node ->
        val pid = parentOf(node)
        if (pid == null || pid !in byId) rec(idOf(node), 0)
    }
    return out
}

@Composable
fun LocationPickerDialog(
    locations: List<LocationEntity>,
    currentId: String?,
    onPick: (String?) -> Unit,
    onDismiss: () -> Unit,
    title: String = "Где хранится?",
    emptyLabel: String = "— без ящика —",
    excludeIds: Set<String> = emptySet()
) {
    val visible = locations.filter { it.id !in excludeIds }
    val rows = treeRows(
        visible,
        { loc -> loc.label.ifBlank { loc.name }.ifBlank { "Ящик" } },
        { loc -> loc.id },
        { loc -> loc.parent_id }
    )
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                LocationOption(emptyLabel, null, currentId, onPick, 0)
                rows.forEach { r -> LocationOption(r.text, r.id, currentId, onPick, r.depth) }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}

@Composable
fun StoragePickerDialog(
    storages: List<StorageEntity>,
    currentId: String?,
    onPick: (String?) -> Unit,
    onDismiss: () -> Unit,
    title: String = "Родительское хранилище",
    emptyLabel: String = "— без родителя —",
    excludeIds: Set<String> = emptySet()
) {
    val visible = storages.filter { it.id !in excludeIds }
    val rows = treeRows(
        visible,
        { s -> s.name },
        { s -> s.id },
        { s -> s.parent_id }
    )
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                LocationOption(emptyLabel, null, currentId, onPick, 0)
                rows.forEach { r -> LocationOption(r.text, r.id, currentId, onPick, r.depth) }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}

@Composable
private fun LocationOption(text: String, id: String?, currentId: String?, onPick: (String?) -> Unit, depth: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp * depth, top = 6.dp, bottom = 6.dp)
            .clickable { onPick(id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, modifier = Modifier.weight(1f))
        if (id == currentId) {
            Text("✓", color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun LocationMap(): Map<String, LocationEntity> {
    val map = remember { mutableStateOf<Map<String, LocationEntity>>(emptyMap()) }
    LaunchedEffect(Unit) {
        Deps.locations.observeAll().collect { list ->
            map.value = list.associateBy { it.id }
        }
    }
    return map.value
}
