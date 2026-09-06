package ru.vldkr.shkaff.features.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.text.font.FontFamily
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
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.SectionTitle

class ItemDetailVm(val itemId: String) : ViewModel() {

    val item = MutableStateFlow<ItemEntity?>(null)
    val locationLabel = MutableStateFlow<String?>(null)
    val storageName = MutableStateFlow<String?>(null)

    class Factory(private val itemId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ItemDetailVm(itemId) as T
    }

    init {
        viewModelScope.launch {
            val it = Deps.items.byId(itemId)
            item.value = it
            it?.location_id?.let { lid ->
                val loc = Deps.locations.byId(lid)
                if (loc != null) {
                    locationLabel.value = loc.label.ifBlank { loc.name }.ifBlank { "Ящик" }
                    storageName.value = Deps.storages.byId(loc.storage_id)?.name
                }
            }
        }
    }

    fun softDelete() {
        viewModelScope.launch { Deps.items.softDelete(itemId) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen(nav: NavController, itemId: String) {
    val vm: ItemDetailVm = viewModel(factory = ItemDetailVm.Factory(itemId))
    val item by vm.item.collectAsState()
    val locationLabel by vm.locationLabel.collectAsState()
    val storageName by vm.storageName.collectAsState()
    var showDelete by remember { mutableStateOf(false) }

    val i = item
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(i?.name ?: "Вещь") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { nav.navigate("item-form/$itemId/0") }) {
                        Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                    }
                    IconButton(onClick = { showDelete = true }) {
                        Icon(Icons.Filled.Delete, contentDescription = "Удалить")
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
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            if (i != null) {
                item {
                    if (i.code.isNotBlank()) {
                        Card(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                            Column(Modifier.padding(16.dp)) {
                                Text("Код / номер", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                Text(
                                    i.code,
                                    style = MaterialTheme.typography.titleLarge,
                                    fontFamily = FontFamily.Monospace
                                )
                            }
                        }
                    }
                    if (locationLabel != null) {
                        Row(Modifier.padding(vertical = 4.dp), verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                "Хранится: ${locationLabel}${storageName?.let { " · $it" } ?: ""}",
                                style = MaterialTheme.typography.bodyLarge
                            )
                        }
                    } else {
                        Text(
                            "Хранится: без ящика",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                    if (i.description.isNotBlank()) {
                        Text(
                            i.description,
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
                val attrs = AttrJson.toMap(i.attributes)
                if (attrs.isNotEmpty()) {
                    item { SectionTitle("Атрибуты") }
                    item {
                        Column(Modifier.fillMaxWidth()) {
                            attrs.forEach { (k, v) ->
                                if (v.isNotBlank()) {
                                    Row(Modifier.padding(vertical = 3.dp)) {
                                        Text("$k: ", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.width(120.dp))
                                        Text(v, style = MaterialTheme.typography.bodyMedium)
                                    }
                                }
                            }
                        }
                    }
                }
                item { SectionTitle("Действия") }
                item {
                    Column(Modifier.fillMaxWidth()) {
                        Button(onClick = { nav.navigate("labels/$itemId/0") }, modifier = Modifier.fillMaxWidth()) {
                            Icon(Icons.Filled.QrCodeScanner, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Этикетка: QR / штрихкод")
                        }
                        ActionStub("Фотография и удаление фона", "M5")
                        ActionStub("Отсканировать код этой вещи", "M3")
                    }
                }
            }
        }

        if (showDelete) {
            AlertDialog(
                onDismissRequest = { showDelete = false },
                title = { Text("Удалить вещь?") },
                text = { Text("«${i?.name ?: ""}» будет скрыта из списков.") },
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

@Composable
private fun ActionStub(text: String, stage: String) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        Text(stage, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
