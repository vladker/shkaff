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
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.FilterChip
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.json.JSONArray
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LocationEntity
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

fun parseOptions(json: String?): List<String> = try {
    val a = JSONArray(json ?: "[]")
    (0 until a.length()).map { a.optString(it, "") }.filter { it.isNotBlank() }
} catch (e: Exception) {
    emptyList()
}

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
    Column(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(
            def.label + if (def.required) " *" else "",
            style = MaterialTheme.typography.labelLarge
        )
        if (options.isEmpty()) {
            OutlinedTextField(
                value = value,
                onValueChange = { onChange(def.key, it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )
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
            }
        }
    }
}

@Composable
fun LocationPickerDialog(
    locations: List<LocationEntity>,
    currentId: String?,
    onPick: (String?) -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Где хранится?") },
        text = {
            Column {
                LocationOption("— без ящика —", null, currentId, onPick)
                locations.forEach { loc ->
                    LocationOption(
                        loc.label.ifBlank { loc.name }.ifBlank { "Ящик" },
                        loc.id,
                        currentId,
                        onPick
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}

@Composable
private fun LocationOption(text: String, id: String?, currentId: String?, onPick: (String?) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
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
