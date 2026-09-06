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
    val list = MutableStateFlow<List<StorageEntity>>(emptyList())
    val locationsCount = MutableStateFlow<Map<String, Int>>(emptyMap())

    init {
        viewModelScope.launch {
            Deps.storages.observeAll().collect { list.value = it }
        }
        viewModelScope.launch {
            Deps.locations.observeAll().collect { locs ->
                locationsCount.value = locs.groupBy { it.storage_id }.mapValues { e -> e.value.size }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoragesScreen(nav: NavController) {
    val vm: StoragesVm = viewModel()
    val list by vm.list.collectAsState()
    val counts by vm.locationsCount.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Хранилища") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("storage-form/0") }) {
                Icon(Icons.Filled.Add, contentDescription = "Новое хранилище")
            }
        }
    ) { padding ->
        if (list.isEmpty()) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                EmptyState("Добавьте первое хранилище: шкаф, стеллаж, комод.\nПотом — ящики и вещи внутри.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 96.dp)
            ) {
                items(list, key = { it.id }) { s ->
                    StorageRow(s, counts[s.id] ?: 0) { nav.navigate("storage/${s.id}") }
                }
            }
        }
    }
}

@Composable
private fun StorageRow(storage: StorageEntity, locationsCount: Int, onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp, horizontal = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                storage.name,
                style = MaterialTheme.typography.titleMedium,
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
