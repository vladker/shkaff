package ru.vldkr.shkaff.features.stacks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.StackEntity
import ru.vldkr.shkaff.data.db.StackMemberEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.rememberRole

class StacksVm : ViewModel() {

    data class Row(val stack: StackEntity, val memberCount: Int)

    val rows = MutableStateFlow<List<Row>>(emptyList())

    init {
        viewModelScope.launch {
            Deps.stacks.observeAll().collect { all ->
                val counts = HashMap<String, Int>()
                for (s in all) counts[s.id] = Deps.stacks.members(s.id).size
                rows.value = all.map { Row(it, counts[it.id] ?: 0) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StacksScreen(nav: NavController) {
    val vm: StacksVm = viewModel()
    val rows by vm.rows.collectAsState()
    val role = rememberRole()
    var showCreate by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Стеки") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    if (Access.can(role, Access.CREATE)) {
                        IconButton(onClick = { showCreate = true }) {
                            Icon(Icons.Filled.Add, contentDescription = "Новый стек")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(onClick = { showCreate = true }) {
                    Icon(Icons.Filled.Add, contentDescription = "Новый стек")
                }
            }
        }
    ) { padding ->
        if (rows.isEmpty()) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                EmptyState("Стеки — группы вещей или хранилищ с собственным номером.\nОбъекты остаются на своих местах: стек не переносит, а группирует.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 96.dp)
            ) {
                items(rows, key = { it.stack.id }) { r ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable { nav.navigate("stack/${r.stack.id}") }
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text(r.stack.name, style = MaterialTheme.typography.titleMedium)
                            Text(
                                "№ ${r.stack.code} · ${r.memberCount} объектов",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text("открыть →", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    HorizontalDivider()
                }
            }
        }
    }

    if (showCreate) {
        NewStackDialog(
            onDismiss = { showCreate = false },
            onConfirm = { name ->
                showCreate = false
                scope.launch {
                    val s = Deps.stacks.create(name)
                    nav.navigate("stack/${s.id}")
                }
            }
        )
    }
}

@Composable
private fun NewStackDialog(onDismiss: () -> Unit, onConfirm: (name: String) -> Unit) {
    var name by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Новый стек") },
        text = {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Например: Инструменты для ремонта") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm(name.trim()) },
                enabled = name.isNotBlank()
            ) { Text("Создать") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StackDetailScreen(nav: NavController, stackId: String) {
    val role = rememberRole()
    var stack by remember { mutableStateOf<StackEntity?>(null) }
    var members by remember { mutableStateOf<List<StackMemberEntity>>(emptyList()) }
    val scope = rememberCoroutineScope()
    var showDelete by remember { mutableStateOf(false) }
    var showAddItem by remember { mutableStateOf(false) }
    var showAddStorage by remember { mutableStateOf(false) }

    val load: () -> Unit = {
        scope.launch {
            stack = Deps.stacks.byId(stackId)
            members = Deps.stacks.members(stackId)
        }
    }
    load()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stack?.name ?: "Стек") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    if (Access.can(role, Access.EDIT)) {
                        IconButton(onClick = { showDelete = true }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Удалить стек")
                        }
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
            contentPadding = PaddingValues(bottom = 96.dp)
        ) {
            item {
                Text(
                    "№ ${stack?.code ?: "—"} · группа без переноса: объекты остаются там, где лежат",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            item {
                Row(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    OutlinedButton(onClick = { showAddItem = true }, modifier = Modifier.weight(1f)) {
                        Text("Добавить вещь")
                    }
                    OutlinedButton(onClick = { showAddStorage = true }, modifier = Modifier.weight(1f)) {
                        Text("Добавить хранилище")
                    }
                }
            }
            item { Text("Члены стека (${members.size})", style = MaterialTheme.typography.titleLarge) }
            if (members.isEmpty()) {
                item {
                    Text(
                        "В стеке пока пусто. Добавьте вещи или хранилища — они останутся на своих местах, стек соберёт их в группу.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            } else {
                items(members, key = { it.id }) { m ->
                    MemberRow(m, stackId, role, scope, load)
                    HorizontalDivider()
                }
            }
        }
    }

    if (showAddItem) {
        AddMemberDialog(
            title = "Добавить вещи в стек",
            rows = rememberItems(),
            labelOf = { it.name.ifBlank { it.code } },
            idOf = { it.id },
            already = members.filter { it.entity_type == "item" }.map { it.entity_id }.toSet(),
            onPick = { ids ->
                ids.forEach { id -> scope.launch { Deps.stacks.addMember(stackId, "item", id) } }
                showAddItem = false
                load()
            },
            onDismiss = { showAddItem = false }
        )
    }
    if (showAddStorage) {
        AddMemberDialog(
            title = "Добавить хранилища в стек",
            rows = rememberStorages(),
            labelOf = { it.name },
            idOf = { it.id },
            already = members.filter { it.entity_type == "storage" }.map { it.entity_id }.toSet(),
            onPick = { ids ->
                ids.forEach { id -> scope.launch { Deps.stacks.addMember(stackId, "storage", id) } }
                showAddStorage = false
                load()
            },
            onDismiss = { showAddStorage = false }
        )
    }

    if (showDelete) {
        AlertDialog(
            onDismissRequest = { showDelete = false },
            title = { Text("Удалить стек?") },
            text = { Text("Стек — только группа. Объекты внутри не удаляются.") },
            confirmButton = {
                TextButton(onClick = {
                    showDelete = false
                    scope.launch {
                        Deps.stacks.softDelete(stackId)
                        nav.popBackStack()
                    }
                }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { showDelete = false }) { Text("Отмена") }
            }
        )
    }
}

@Composable
private fun MemberRow(m: StackMemberEntity, stackId: String, role: ru.vldkr.shkaff.domain.access.Role, scope: kotlinx.coroutines.CoroutineScope, reload: () -> Unit) {
    var label by remember(m.id) { mutableStateOf<String?>(null) }
    androidx.compose.runtime.LaunchedEffect(m.id) {
        label = when (m.entity_type) {
            "item" -> Deps.items.byId(m.entity_id)?.let { it.name.ifBlank { it.code } }
            "storage" -> Deps.storages.byId(m.entity_id)?.name
            else -> m.entity_id
        }
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(label ?: "…", style = MaterialTheme.typography.bodyLarge)
            Text(
                if (m.entity_type == "item") "вещь" else "хранилище",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        if (Access.can(role, Access.EDIT)) {
            TextButton(onClick = {
                scope.launch {
                    Deps.stacks.removeMember(m.id, stackId)
                    reload()
                }
            }) { Text("Убрать", color = MaterialTheme.colorScheme.error) }
        }
    }
}

@Composable
private fun rememberItems(): List<ItemEntity> {
    var items by remember { mutableStateOf<List<ItemEntity>>(emptyList()) }
    androidx.compose.runtime.LaunchedEffect(Unit) { items = Deps.items.all() }
    return items
}

@Composable
private fun rememberStorages(): List<StorageEntity> {
    var storages by remember { mutableStateOf<List<StorageEntity>>(emptyList()) }
    androidx.compose.runtime.LaunchedEffect(Unit) {
        Deps.storages.observeAll().collect { storages = it }
    }
    return storages
}

// Мультивыбор для состава стека: галочки + «Добавить N»
@Composable
private fun <T> AddMemberDialog(
    title: String,
    rows: List<T>,
    labelOf: (T) -> String,
    idOf: (T) -> String,
    already: Set<String>,
    onPick: (List<String>) -> Unit,
    onDismiss: () -> Unit
) {
    val selected = remember { mutableStateOf<MutableSet<String>>(mutableSetOf()) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column(Modifier.fillMaxWidth()) {
                if (rows.isEmpty()) {
                    Text("Список пуст", color = MaterialTheme.colorScheme.onSurfaceVariant)
                } else {
                    rows.forEach { r ->
                        val id = idOf(r)
                        if (id !in already) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        if (!selected.value.add(id)) selected.value.remove(id)
                                    }
                                    .padding(vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(checked = id in selected.value, onCheckedChange = {
                                    if (it) selected.value.add(id) else selected.value.remove(id)
                                })
                                Text(labelOf(r), modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onPick(selected.value.toList()) },
                enabled = selected.value.isNotEmpty()
            ) { Text("Добавить (${selected.value.size})") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}