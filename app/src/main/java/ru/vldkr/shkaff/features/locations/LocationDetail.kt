package ru.vldkr.shkaff.features.locations

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
import androidx.compose.material3.AlertDialog
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
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemRow
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.SectionTitle

class LocationDetailVm(val locationId: String) : ViewModel() {

    val location = MutableStateFlow<LocationEntity?>(null)
    val storage = MutableStateFlow<StorageEntity?>(null)
    val items = MutableStateFlow<List<ItemEntity>>(emptyList())

    class Factory(private val locationId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            LocationDetailVm(locationId) as T
    }

    init {
        viewModelScope.launch {
            location.value = Deps.locations.byId(locationId)
        }
        viewModelScope.launch {
            val loc = Deps.locations.byId(locationId)
            if (loc != null) storage.value = Deps.storages.byId(loc.storage_id)
        }
        viewModelScope.launch {
            Deps.items.observeByLocation(locationId).collect { items.value = it }
        }
    }

    fun softDelete() {
        viewModelScope.launch { Deps.locations.softDelete(locationId) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationDetailScreen(nav: NavController, locationId: String) {
    val vm: LocationDetailVm = viewModel(factory = LocationDetailVm.Factory(locationId))
    val location by vm.location.collectAsState()
    val storage by vm.storage.collectAsState()
    val items by vm.items.collectAsState()
    val locations = LocationMap()
    var showDelete by remember { mutableStateOf(false) }

    val l = location
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        l?.let { it.label.ifBlank { it.name }.ifBlank { "Ящик" } } ?: "Ящик"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        if (l != null) nav.navigate("storage/${l.storage_id}") { popUpTo("dashboard") }
                        else nav.popBackStack()
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { nav.navigate("location-form/${l?.storage_id ?: "0"}/$locationId") }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                    }
                    IconButton(onClick = { showDelete = true }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Удалить")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("item-form/0/$locationId") }) {
                Icon(Icons.Filled.Add, contentDescription = "Новая вещь")
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
            if (l != null) {
                item {
                    Column(Modifier.padding(top = 4.dp)) {
                        storage?.let {
                            Text("Хранилище: ${it.name}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        val parent = l.parent_id?.let { locations[it] }
                        if (parent != null) {
                            Text(
                                "Внутри: ${parent.label.ifBlank { parent.name }}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        val attrs = AttrJson.toMap(l.attributes)
                        attrs.forEach { (k, v) ->
                            if (v.isNotBlank()) {
                                Row(Modifier.padding(top = 4.dp)) {
                                    Text("$k: ", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                    Text(v, style = MaterialTheme.typography.bodyMedium)
                                }
                            }
                        }
                    }
                }
            }
            item { SectionTitle("Вещи (${items.size})") }
            if (items.isEmpty()) {
                item { EmptyState("В ящике пока пусто.\nНажмите «+», чтобы положить первую вещь.") }
            } else {
                items(items, key = { it.id }) { it ->
                    ItemRow(it, l?.label?.ifBlank { l.name }, { nav.navigate("item/${it.id}") })
                }
            }
        }

        if (showDelete) {
            AlertDialog(
                onDismissRequest = { showDelete = false },
                title = { Text("Удалить ящик?") },
                text = { Text("Ящик будет скрыт. Вещи останутся в базе как «без ящика».") },
                confirmButton = {
                    TextButton(onClick = {
                        showDelete = false
                        vm.softDelete()
                        val sid = l?.storage_id
                        if (sid != null) nav.navigate("storage/$sid") { popUpTo("dashboard") }
                        else nav.popBackStack()
                    }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
                },
                dismissButton = {
                    TextButton(onClick = { showDelete = false }) { Text("Отмена") }
                }
            )
        }
    }
}
