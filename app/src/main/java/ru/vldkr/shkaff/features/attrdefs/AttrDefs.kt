package ru.vldkr.shkaff.features.attrdefs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.parseOptions
import ru.vldkr.shkaff.util.newId

class AttrDefsVm : ViewModel() {

    val defs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())

    data class Draft(
        var scope: String = "item",
        var key: String = "",
        var label: String = "",
        var type: String = "text",
        var options: String = "",
        var required: Boolean = false
    )

    val draft = MutableStateFlow(Draft())
    val error = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            Deps.attributes.observeAll().collect { defs.value = it }
        }
    }

    fun saveDraft() {
        val d = draft.value
        if (d.key.isBlank() || d.label.isBlank()) {
            error.value = "Заполните код (key) и название"
            return
        }
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            val key = d.key.trim()
            val existing = defs.value.firstOrNull { it.scope == d.scope && it.key == key }
            val options = if (d.type == "select") {
                org.json.JSONArray(d.options.split("|").map { it.trim() }.filter { it.isNotEmpty() }).toString()
            } else "[]"
            if (existing != null) {
                Deps.attributes.upsert(
                    existing.copy(
                        label = d.label.trim(),
                        type = d.type,
                        options = options,
                        required = d.required,
                        updated_at = now,
                        device_last_modified = Deps.deviceId
                    )
                )
            } else {
                Deps.attributes.upsert(
                    AttributeDefEntity(
                        id = newId(),
                        scope = d.scope,
                        key = key,
                        label = d.label.trim(),
                        type = d.type,
                        options = options,
                        required = d.required,
                        sort_order = 0,
                        created_at = now,
                        updated_at = now,
                        deleted_at = null,
                        device_last_modified = Deps.deviceId
                    )
                )
            }
            draft.value = Draft(scope = d.scope)
            error.value = null
        }
    }

    fun remove(id: String) {
        viewModelScope.launch { Deps.attributes.remove(id) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttrDefsScreen(nav: NavController) {
    val vm: AttrDefsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val defs by vm.defs.collectAsState()
    val draft by vm.draft.collectAsState()
    val error by vm.error.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Словарь атрибутов") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp)
        ) {
            item { SectionTitle("Добавить атрибут") }
            item {
                Column(Modifier.fillMaxWidth()) {
                    Row {
                        ScopeChip("item", draft.scope, { vm.draft.value = draft.copy(scope = "item") })
                        ScopeChip("storage", draft.scope, { vm.draft.value = draft.copy(scope = "storage") })
                        ScopeChip("location", draft.scope, { vm.draft.value = draft.copy(scope = "location") })
                        ScopeChip("*", draft.scope, { vm.draft.value = draft.copy(scope = "*") })
                    }
                    AttrFieldRow("Код (key)", draft.key, { vm.draft.value = draft.copy(key = it) })
                    AttrFieldRow("Название", draft.label, { vm.draft.value = draft.copy(label = it) })
                    TypeChipRow(draft.type, { vm.draft.value = draft.copy(type = it) })
                    if (draft.type == "select") {
                        AttrFieldRow("Варианты через |", draft.options) { vm.draft.value = draft.copy(options = it) }
                    }
                    error?.let {
                        Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp))
                    }
                    TextButton(onClick = { vm.saveDraft() }, modifier = Modifier.padding(top = 4.dp)) {
                        Text("Сохранить атрибут")
                    }
                }
            }
            item { SectionTitle("Список (${defs.size})") }
            items(defs, key = { it.id }) { d ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text(d.label, style = MaterialTheme.typography.bodyLarge)
                        Text(
                            "${d.scope} · ${d.key} · ${d.type}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        val opts = parseOptions(d.options)
                        if (opts.isNotEmpty()) {
                            Text(opts.joinToString(", "), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    IconButton(onClick = { vm.remove(d.id) }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Удалить")
                    }
                }
            }
        }
    }
}

@Composable
private fun ScopeChip(scope: String, selected: String, onClick: () -> Unit) {
    androidx.compose.material3.FilterChip(
        selected = scope == selected,
        onClick = onClick,
        label = { Text(scope) },
        modifier = Modifier.padding(end = 6.dp)
    )
}

@Composable
private fun TypeChipRow(current: String, onChange: (String) -> Unit) {
    Row {
        listOf("text" to "Текст", "number" to "Число", "select" to "Список", "bool" to "Флаг", "date" to "Дата").forEach { (v, l) ->
            androidx.compose.material3.FilterChip(
                selected = current == v,
                onClick = { onChange(v) },
                label = { Text(l) },
                modifier = Modifier.padding(end = 6.dp)
            )
        }
    }
}

@Composable
private fun AttrFieldRow(label: String, value: String, onChange: (String) -> Unit) {
    Column(Modifier.padding(vertical = 4.dp)) {
        Text(label, style = MaterialTheme.typography.labelLarge)
        OutlinedTextField(
            value = value,
            onValueChange = onChange,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
    }
}
