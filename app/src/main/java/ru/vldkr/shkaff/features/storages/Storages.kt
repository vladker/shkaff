package ru.vldkr.shkaff.features.storages

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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState

class StoragesVm : ViewModel() {

    data class Row(val storage: StorageEntity, val depth: Int)

    val rows = MutableStateFlow<List<Row>>(emptyList())
    val locationsCount = MutableStateFlow<Map<String, Int>>(emptyMap())
    private val all = MutableStateFlow<List<StorageEntity>>(emptyList())

    init {
        viewModelScope.launch {
            Deps.storages.observeAll().collect { l ->
                all.value = l
                rows.value = flatten(l)
            }
        }
        viewModelScope.launch {
            Deps.locations.observeAll().collect { locs ->
                locationsCount.value = locs.groupBy { it.storage_id }.mapValues { e -> e.value.size }
            }
        }
    }

    // старшие хранилища первыми, вложенные — вглубь; сироты (родитель удалён) — на верхнем уровне
    private fun flatten(all: List<StorageEntity>): List<Row> {
        val byId = all.associateBy { it.id }
        val byParent = all.groupBy { it.parent_id ?: "" }
        val out = mutableListOf<Row>()
        val seen = mutableSetOf<String>()
        fun rec(id: String, depth: Int) {
            if (!seen.add(id)) return
            byId[id]?.let { out += Row(it, depth) }
            (byParent[id] ?: emptyList()).forEach { rec(it.id, depth + 1) }
        }
        all.forEach { s ->
            val pid = s.parent_id
            if (pid == null || pid !in byId) rec(s.id, 0)
        }
        return out
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoragesScreen(nav: NavController) {
    val vm: StoragesVm = viewModel()
    val rows by vm.rows.collectAsState()
    val counts by vm.locationsCount.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Хранилища") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("storage-form/0") }) {
                Icon(Icons.Filled.Add, contentDescription = "Новое хранилище")
            }
        }
    ) { padding ->
        if (rows.isEmpty()) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                EmptyState("Добавьте первое хранилище: шкаф, стеллаж, комод.\nХранилища можно вкладывать друг в друга, потом — ящики и вещи внутри.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 96.dp)
            ) {
                items(rows, key = { it.storage.id }) { r ->
                    StorageRow(r.storage, r.depth, counts[r.storage.id] ?: 0) { nav.navigate("storage/${r.storage.id}") }
                }
            }
        }
    }
}

@Composable
private fun StorageRow(storage: StorageEntity, depth: Int, locationsCount: Int, onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(start = 16.dp * depth + 4.dp, top = 12.dp, end = 4.dp, bottom = 12.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (depth > 0) {
                Text("↳ ", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Text(
                storage.name,
                style = if (depth == 0) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Text(
                "$locationsCount яшк.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
        if (storage.description.isNotBlank()) {
            Text(
                storage.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
