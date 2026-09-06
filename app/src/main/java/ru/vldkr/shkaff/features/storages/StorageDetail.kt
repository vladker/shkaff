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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.SectionTitle

class StorageDetailVm(val storageId: String) : ViewModel() {

    val storage = MutableStateFlow<StorageEntity?>(null)
    val locations = MutableStateFlow<List<LocationEntity>>(emptyList())
    val itemCounts = MutableStateFlow<Map<String, Int>>(emptyMap())

    class Factory(private val storageId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            StorageDetailVm(storageId) as T
    }

    init {
        viewModelScope.launch {
            storage.value = Deps.storages.byId(storageId)
        }
        viewModelScope.launch {
            Deps.locations.observeByStorage(storageId).collect { locs ->
                locations.value = locs
                val counts = HashMap<String, Int>()
                for (l in locs) counts[l.id] = Deps.items.countByLocation(l.id)
                itemCounts.value = counts
            }
        }
    }

    fun softDelete() {
        viewModelScope.launch { Deps.storages.softDelete(storageId) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StorageDetailScreen(nav: NavController, storageId: String) {
    val vm: StorageDetailVm = viewModel(factory = StorageDetailVm.Factory(storageId))
    val storage by vm.storage.collectAsState()
    val locations by vm.locations.collectAsState()
    val itemCounts by vm.itemCounts.collectAsState()
    var showDelete by remember { mutableStateOf(false) }

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
                    IconButton(onClick = { nav.navigate("storage-form/$storageId") }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                    }
                    IconButton(onClick = { showDelete = true }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Удалить")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("location-form/$storageId/0") }) {
                Icon(Icons.Filled.Add, contentDescription = "Новый ящик")
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
                }
            }
            item {
                Card(Modifier.fillMaxWidth().padding(vertical = 12.dp)) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.PhotoCamera,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.width(12.dp))
                        Column(Modifier.weight(1f)) {
                            Text("Фото хранилища с разметкой ящиков", style = MaterialTheme.typography.bodyLarge)
                            Text("Рисуйте ящики прямо на фото", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = { nav.navigate("annotations/$storageId") }) {
                            Text("Разметка")
                        }
                    }
                }
            }
            item { SectionTitle("Ящики (${locations.size})") }
            if (locations.isEmpty()) {
                item { EmptyState("Ящиков пока нет.\nНажмите «+», чтобы добавить первый ящик.") }
            } else {
                items(locations, key = { it.id }) { l ->
                    val label = l.label.ifBlank { l.name }.ifBlank { "Ящик" }
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .clickable { nav.navigate("location/${l.id}") }
                            .padding(vertical = 10.dp, horizontal = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(label, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
                            Text(
                                "${itemCounts[l.id] ?: 0} вещей",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
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
    }
}
