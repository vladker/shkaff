package ru.vldkr.shkaff.features.storages

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.capacity.CapacityUsage
import ru.vldkr.shkaff.domain.levels.Levels
import ru.vldkr.shkaff.features.annotations.StorageVisualization
import ru.vldkr.shkaff.features.loans.LendDialog
import ru.vldkr.shkaff.ui.components.CapacitySection
import ru.vldkr.shkaff.ui.components.CrumbPath
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.FormBus
import ru.vldkr.shkaff.util.formatDate

class StorageDetailVm(val storageId: String) : ViewModel() {

    data class LocRow(val location: LocationEntity, val depth: Int)

    val storage = MutableStateFlow<StorageEntity?>(null)
    val breadcrumb = MutableStateFlow<List<String>>(emptyList())
    val locRows = MutableStateFlow<List<LocRow>>(emptyList())
    val itemCounts = MutableStateFlow<Map<String, Int>>(emptyMap())
    val usage = MutableStateFlow<CapacityUsage?>(null)
    val activeLoan = MutableStateFlow<LoanEntity?>(null)
    val role = MutableStateFlow(Role.VIEW)

    class Factory(private val storageId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            StorageDetailVm(storageId) as T
    }

    init {
        viewModelScope.launch {
            Deps.storages.observeAll().collect { all ->
                val byId = all.associateBy { it.id }
                storage.value = byId[storageId]
                breadcrumb.value = Levels.chainToRoot(byId[storageId]?.parent_id, byId, { it.name }, { it.parent_id })
            }
        }
        viewModelScope.launch {
            usage.value = Deps.storages.usage(storageId)
        }
        viewModelScope.launch {
            Deps.locations.observeByStorage(storageId).collect { locs ->
                locRows.value = flatten(locs)
                val counts = HashMap<String, Int>()
                for (l in locs) counts[l.id] = Deps.items.countByLocation(l.id)
                itemCounts.value = counts
            }
        }
    }

    // верхние ящики первыми, вложенные — вглубь; сироты (родитель удалён) — на верхнем уровне
    private fun flatten(locs: List<LocationEntity>): List<LocRow> {
        val byId = locs.associateBy { it.id }
        val byParent = locs.groupBy { it.parent_id ?: "" }
        val out = mutableListOf<LocRow>()
        val seen = mutableSetOf<String>()
        fun rec(id: String, depth: Int) {
            if (!seen.add(id)) return
            byId[id]?.let { out += LocRow(it, depth) }
            (byParent[id] ?: emptyList()).forEach { rec(it.id, depth + 1) }
        }
        locs.forEach { l ->
            val pid = l.parent_id
            if (pid == null || pid !in byId) rec(l.id, 0)
        }
        return out
    }

    fun softDelete() {
        viewModelScope.launch { Deps.storages.softDelete(storageId) }
    }

    init {
        viewModelScope.launch {
            role.value = Role.parse(Deps.users.activeUser()?.role ?: "view")
        }
        viewModelScope.launch {
            activeLoan.value = Deps.loans.activeForEntity("storage", storageId)
        }
    }

    fun lend(borrower: String, note: String, dueAt: Long?) {
        viewModelScope.launch { Deps.loans.lend("storage", storageId, borrower, note, dueAt) }
    }

    fun returnActiveLoan() {
        val id = activeLoan.value?.id ?: return
        viewModelScope.launch {
            Deps.loans.returnLoan(id)
            activeLoan.value = null
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StorageDetailScreen(nav: NavController, storageId: String) {
    val vm: StorageDetailVm = viewModel(factory = StorageDetailVm.Factory(storageId))
    val storage by vm.storage.collectAsState()
    val breadcrumb by vm.breadcrumb.collectAsState()
    val locRows by vm.locRows.collectAsState()
    val itemCounts by vm.itemCounts.collectAsState()
    val usage by vm.usage.collectAsState()
    var showDelete by remember { mutableStateOf(false) }
    val role by vm.role.collectAsState()
    val loan by vm.activeLoan.collectAsState()
    var showLend by remember { mutableStateOf(false) }

    val s = storage
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(s?.name ?: "Хранилище") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    if (Access.can(role, Access.EDIT)) {
                        IconButton(onClick = { nav.navigate("storage-form/$storageId") }) {
                            Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                        }
                        IconButton(onClick = { showDelete = true }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Удалить")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(onClick = { nav.navigate("location-form/$storageId/0") }) {
                    Icon(Icons.Filled.Add, contentDescription = "Новый ящик")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 96.dp)
        ) {
            if (s != null) {
                item {
                    if (breadcrumb.isNotEmpty()) {
                        CrumbPath(breadcrumb)
                    }
                    if (s.level.isNotBlank()) {
                        Text(
                            "Уровень: ${s.level}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                    if (s.description.isNotBlank()) {
                        Text(
                            s.description,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                    val attrs = AttrJson.toMap(s.attributes)
                    if (attrs.isNotEmpty()) {
                        Column(Modifier.padding(top = 8.dp)) {
                            attrs.forEach { (k, v) ->
                                if (v.isNotBlank()) {
                                    Row(Modifier.padding(vertical = 2.dp)) {
                                        Text("$k: ", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text(v, style = MaterialTheme.typography.bodyMedium)
                                    }
                                }
                            }
                        }
                    }
                    val u = usage
                    if (u != null) {
                        CapacitySection(u, Modifier.padding(top = 8.dp))
                    }
                }
            }
            item {
                StorageVisualization(
                    storageId = storageId,
                    onOpenLocation = { nav.navigate("location/$it") },
                    onEdit = { nav.navigate("annotations/$storageId") },
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
            item { SectionTitle("Ящики (${locRows.size})") }
            if (Access.can(role, Access.LEND)) {
                item {
                    Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        val l = loan
                        if (l != null) {
                            val due = l.due_at
                            val overdue = due != null && due < System.currentTimeMillis()
                            Text(
                                "Выдано: ${l.borrower}${due?.let { " · возврат до ${formatDate(it)}" } ?: ""}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = if (overdue) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(bottom = 4.dp)
                            )
                            OutlinedButton(onClick = { vm.returnActiveLoan() }, modifier = Modifier.fillMaxWidth()) {
                                Text("Вернуть")
                            }
                        } else {
                            Button(onClick = { showLend = true }, modifier = Modifier.fillMaxWidth()) {
                                Text("Выдать хранилище временно")
                            }
                        }
                    }
                }
            }
            if (locRows.isEmpty()) {
                item { EmptyState("Ящиков пока нет.\nНажмите «+», чтобы добавить первый ящик. Ящики можно вкладывать друг в друга.") }
            } else {
                items(locRows, key = { it.location.id }) { r ->
                    val l = r.location
                    val label = l.label.ifBlank { l.name }.ifBlank { "Ящик" }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .clickable { nav.navigate("location/${l.id}") }
                            .padding(start = 16.dp * r.depth + 4.dp, top = 10.dp, end = 4.dp, bottom = 10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            if (r.depth > 0) {
                                Text("↳ ", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Text(
                                label,
                                style = if (r.depth == 0) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.weight(1f)
                            )
                            Text(
                                "${itemCounts[l.id] ?: 0} вещей",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            if (Access.can(role, Access.CREATE)) {
                                IconButton(onClick = {
                                    FormBus.locationParentPreset = l.id
                                    nav.navigate("location-form/$storageId/0")
                                }) {
                                    Icon(Icons.Filled.AddCircle, contentDescription = "Вложенный ящик в «$label»")
                                }
                            }
                        }
                        Spacer(Modifier.height(6.dp))
                        HorizontalDivider()
                    }
                }
            }
        }

        if (showDelete) {
            AlertDialog(
                onDismissRequest = { showDelete = false },
                title = { Text("Удалить хранилище?") },
                text = { Text("«${s?.name ?: ""}» будет скрыто. Ящики останутся в базе, но вещи из них — «без ящика» при жёстком удалении.") },
                confirmButton = {
                    TextButton(onClick = {
                        showDelete = false
                        vm.softDelete()
                        nav.popBackStack()
                    }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
                },
                dismissButton = {
                    TextButton(onClick = { showDelete = false }) { Text("Отмена") }
                }
            )
        }

        if (showLend) {
            LendDialog(
                title = "Выдать хранилище",
                onDismiss = { showLend = false },
                onConfirm = { b, n, d ->
                    showLend = false
                    vm.lend(b, n, d)
                }
            )
        }
    }
}
