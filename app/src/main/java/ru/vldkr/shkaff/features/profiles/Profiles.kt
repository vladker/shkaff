package ru.vldkr.shkaff.features.profiles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Backup
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SyncProblem
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.UserEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.ui.theme.Ozon

class ProfilesVm : ViewModel() {

    data class Stats(
        val itemsCount: Int = 0,
        val storagesCount: Int = 0,
        val activeLoans: Int = 0,
        val overdueLoans: Int = 0,
        val expiringCount: Int = 0
    )

    val users = MutableStateFlow<List<UserEntity>>(emptyList())
    val activeId = MutableStateFlow<String?>(null)
    val stats = MutableStateFlow(Stats())
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
        val loans = Deps.loans.observeActive().first()
        val now = System.currentTimeMillis()
        stats.value = Stats(
            itemsCount = Deps.items.all().size,
            storagesCount = Deps.storages.count(),
            activeLoans = loans.size,
            overdueLoans = loans.count { it.due_at != null && it.due_at < now },
            expiringCount = Deps.items.expiringSoon(Deps.expiryThresholdDays()).size
        )
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
    val stats by vm.stats.collectAsState()
    val role = rememberRole()
    val isAdmin = Access.can(role, Access.ADMIN)
    val active = users.firstOrNull { it.id == activeId }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Профиль", color = Ozon.TextPrimary) },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад", tint = Ozon.TextSecondary)
                    }
                },
                colors = androidx.compose.material3.TopAppBarDefaults.topAppBarColors(containerColor = Ozon.Bg)
            )
        },
        floatingActionButton = {
            if (isAdmin) {
                FloatingActionButton(
                    onClick = { vm.openNew() },
                    containerColor = Ozon.Blue,
                    contentColor = Ozon.TextPrimary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Новый профиль")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 96.dp)
        ) {
            // Шапка профиля: аватар-инициалы, имя, роль
            item {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, bottom = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        Modifier
                            .size(72.dp)
                            .clip(CircleShape)
                            .background(if (isAdmin) Ozon.Blue else Ozon.Purple),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            initials(active?.name),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    Text(
                        active?.name ?: "Гость",
                        style = MaterialTheme.typography.titleLarge,
                        color = Ozon.TextPrimary,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Text(
                        Access.label(role),
                        style = MaterialTheme.typography.bodyMedium,
                        color = Ozon.TextSecondary
                    )
                }
            }

            // Счётчики пользователя — как статистика в профиле Ozon
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    ProfileStat(stats.itemsCount, "вещей", Modifier.weight(1f))
                    ProfileStat(stats.storagesCount, "хранилищ", Modifier.weight(1f))
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    ProfileStat(stats.activeLoans, "выдано", Modifier.weight(1f), highlight = stats.overdueLoans > 0)
                    ProfileStat(stats.expiringCount, "истекает", Modifier.weight(1f))
                }
            }

            // Быстрые ссылки профиля
            item { SectionTitle("Мой профиль") }
            item {
                val links = listOf(
                    Triple(Icons.Filled.Settings, "Настройки", "settings"),
                    Triple(Icons.Filled.Backup, "Бэкап и восстановление", "backup"),
                    Triple(Icons.Filled.Upload, "Экспорт и выгрузка", "export"),
                    Triple(Icons.Filled.Label, "Шаблоны этикеток", "templates"),
                    Triple(Icons.Filled.History, "Журнал действий", "journal"),
                    Triple(Icons.Filled.SyncProblem, "Конфликты слияния", "conflicts")
                )
                Column {
                    links.forEachIndexed { idx, (icon, label, route) ->
                        ProfileLinkRow(icon, label) { nav.navigate(route) }
                        if (idx < links.lastIndex) HorizontalDivider(color = Ozon.Card, modifier = Modifier.padding(start = 40.dp))
                    }
                }
            }

            item { SectionTitle("Члены семьи") }
            if (users.isEmpty()) {
                item {
                    androidx.compose.material3.Text(
                        "Добавьте профили членов семьи — у каждого своя роль и права.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Ozon.TextSecondary,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
            items(users, key = { it.id }) { u ->
                val isActive = u.id == activeId
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { vm.select(u) }
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(if (isActive) Ozon.Blue.copy(alpha = 0.2f) else Ozon.Card),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            initials(u.name),
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = if (isActive) Ozon.Blue else Ozon.TextSecondary
                        )
                    }
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(u.name, style = MaterialTheme.typography.bodyLarge, color = Ozon.TextPrimary)
                        Text(Access.label(Role.parse(u.role)), style = MaterialTheme.typography.bodyMedium, color = Ozon.TextSecondary)
                    }
                    if (isActive) {
                        Box(
                            Modifier
                                .clip(CircleShape)
                                .background(Ozon.Blue.copy(alpha = 0.15f))
                                .padding(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text("активен", style = MaterialTheme.typography.labelMedium, color = Ozon.Blue)
                        }
                    }
                    if (isAdmin) {
                        IconButton(onClick = { vm.openEdit(u) }) {
                            Icon(Icons.Filled.Edit, contentDescription = "Изменить", tint = Ozon.TextSecondary)
                        }
                        IconButton(onClick = { vm.delete(u) }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Удалить", tint = Ozon.Pink)
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

// Инициалы имени для аватара (первая буква имени и фамилии, если есть).
private fun initials(name: String?): String {
    val parts = name?.trim()?.split(Regex("\\s+"))?.filter { it.isNotBlank() } ?: emptyList()
    return when (parts.size) {
        0 -> "?"
        1 -> parts[0].take(1).uppercase()
        else -> (parts[0].take(1) + parts[1].take(1)).uppercase()
    }
}

// Счётчик как плитка в стиле Ozon: значение крупно, подпись мелко.
@Composable
private fun ProfileStat(value: Int, label: String, modifier: Modifier = Modifier, highlight: Boolean = false) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 12.dp)
        ) {
            Text(
                "$value",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = if (highlight) Ozon.Pink else Ozon.TextPrimary
            )
            Text(
                label,
                style = MaterialTheme.typography.bodySmall,
                color = Ozon.TextSecondary,
                maxLines = 1
            )
        }
    }
}

// Строка-ссылка профиля: иконка в цветном квадрате + подпись + стрелка.
@Composable
private fun ProfileLinkRow(icon: ImageVector, label: String, onClick: () -> Unit) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(28.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Ozon.Search),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp), tint = Ozon.Blue)
        }
        Spacer(Modifier.width(12.dp))
        Text(
            label,
            style = MaterialTheme.typography.bodyLarge,
            color = Ozon.TextPrimary,
            modifier = Modifier.weight(1f)
        )
        Icon(Icons.Filled.ChevronRight, contentDescription = null, tint = Ozon.TextSecondary)
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