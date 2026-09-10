package ru.vldkr.shkaff.features.profiles

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.UserEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.ui.components.rememberRole

class ProfilesVm : ViewModel() {

    val users = MutableStateFlow<List<UserEntity>>(emptyList())
    val activeId = MutableStateFlow<String?>(null)
    var edit: UserEntity? by mutableStateOf(null)
    var showEditor by mutableStateOf(false)

    init {
        viewModelScope.launch {
            refresh()
        }
    }

    suspend fun refresh() {
        users.value = Deps.users.all()
        activeId.value = Deps.users.activeUser()?.id
    }

    fun select(u: UserEntity) {
        viewModelScope.launch {
            Deps.users.setActive(u.id)
            Deps.actionLog.log("profile", "user", u.id, mapOf("name" to u.name))
            refresh()
        }
    }

    fun openNew() {
        edit = null
        showEditor = true
    }

    fun openEdit(u: UserEntity) {
        edit = u
        showEditor = true
    }

    fun save(name: String, role: Role) {
        viewModelScope.launch {
            if (name.isBlank()) return@launch
            val u = edit
            if (u == null) {
                val created = Deps.users.create(name, role)
                if (Deps.users.activeUser() == null) Deps.users.setActive(created.id)
            } else {
                Deps.users.update(u.id, name, role)
            }
            Deps.actionLog.log("profile", "user", u?.id ?: name, mapOf("name" to name, "role" to role.preset))
            showEditor = false
            refresh()
        }
    }

    fun delete(u: UserEntity) {
        viewModelScope.launch {
            Deps.users.softDelete(u.id)
            Deps.actionLog.log("profile", "user", u.id, mapOf("name" to u.name, "action" to "delete"))
            refresh()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfilesScreen(nav: NavController) {
    val vm: ProfilesVm = viewModel()
    val users by vm.users.collectAsState()
    val activeId by vm.activeId.collectAsState()
    val role = rememberRole()
    val isAdmin = Access.can(role, Access.ADMIN)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Профили") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        },
        floatingActionButton = {
            if (isAdmin) {
                FloatingActionButton(onClick = { vm.openNew() }) {
                    Icon(Icons.Filled.Add, contentDescription = "Новый профиль")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    "Роли ограничивают действия: админ — всё, «добавление» — только новые объекты, «перекладка» — переносы внутри хранилищ, «просмотр» — только чтение.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 10.dp)
                )
            }
            items(users, key = { it.id }) { u ->
                val isActive = u.id == activeId
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { vm.select(u) }
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        if (isActive) "● " else "○ ",
                        color = if (isActive) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Column(Modifier.weight(1f)) {
                        Text(u.name, style = MaterialTheme.typography.bodyLarge)
                        Text(Access.label(Role.parse(u.role)), style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    if (isActive) {
                        Text("активен", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                    }
                    if (isAdmin) {
                        IconButton(onClick = { vm.openEdit(u) }) {
                            Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                        }
                        IconButton(onClick = { vm.delete(u) }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Удалить", tint = MaterialTheme.colorScheme.error)
                        }
                    }
                }
            }
        }
    }

    if (vm.showEditor) {
        ProfileEditorDialog(vm)
    }
}

@Composable
private fun ProfileEditorDialog(vm: ProfilesVm) {
    val editing = vm.edit
    var name by remember { mutableStateOf(editing?.name ?: "") }
    var role by remember { mutableStateOf(Role.parse(editing?.role ?: "view")) }

    AlertDialog(
        onDismissRequest = { vm.showEditor = false },
        title = { Text(if (editing == null) "Новый профиль" else "Редактировать профиль") },
        text = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Имя") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.width(0.dp))
                Role.entries.forEach { r ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable { role = r }
                            .padding(vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = role == r, onClick = { role = r })
                        Spacer(Modifier.width(10.dp))
                        Text(Access.label(r), style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { vm.save(name, role) }) { Text("Сохранить") }
        },
        dismissButton = {
            TextButton(onClick = { vm.showEditor = false }) { Text("Отмена") }
        }
    )
}