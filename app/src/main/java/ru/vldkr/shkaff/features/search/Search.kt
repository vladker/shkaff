package ru.vldkr.shkaff.features.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.theme.Ozon

// Глобальный поиск: одно поле — вещи, ящики и шкафы (поиск без учёта регистра).
class SearchVm : ViewModel() {

    data class Results(
        val items: List<ItemEntity> = emptyList(),
        val locations: List<LocationEntity> = emptyList(),
        val storages: List<StorageEntity> = emptyList()
    )

    private val itemsF = MutableStateFlow<List<ItemEntity>>(emptyList())
    private val locationsF = MutableStateFlow<List<LocationEntity>>(emptyList())
    private val storagesF = MutableStateFlow<List<StorageEntity>>(emptyList())
    val query = MutableStateFlow("")

    val results = combine(itemsF, locationsF, storagesF, query) { items, locations, storages, q ->
        val t = q.trim()
        if (t.isEmpty()) return@combine Results()
        Results(
            items = items.filter {
                it.name.contains(t, true) ||
                    it.code.contains(t, true) ||
                    (it.ean ?: "").contains(t, true) ||
                    it.description.contains(t, true) ||
                    it.attributes.contains(t, true)
            }.take(50),
            locations = locations.filter {
                it.label.contains(t, true) || it.name.contains(t, true)
            }.take(50),
            storages = storages.filter {
                it.name.contains(t, true) || it.code.contains(t, true) || it.description.contains(t, true)
            }.take(50)
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Results())

    init {
        viewModelScope.launch { Deps.items.observeAll().collect { itemsF.value = it } }
        viewModelScope.launch { Deps.locations.observeAll().collect { locationsF.value = it } }
        viewModelScope.launch { Deps.storages.observeAll().collect { storagesF.value = it } }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(nav: NavController) {
    val vm: SearchVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val results by vm.results.collectAsState()
    var queryText by remember { mutableStateOf(vm.query.value) }
    val storageNames = remember(results.storages) { results.storages.associateBy { it.id } }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Поиск") }) }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            TextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.query.value = it
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Ozon.Blue) },
                trailingIcon = {
                    if (queryText.isNotEmpty()) {
                        IconButton(onClick = {
                            queryText = ""
                            vm.query.value = ""
                        }) {
                            Icon(Icons.Filled.Close, contentDescription = "Очистить")
                        }
                    }
                },
                placeholder = { Text("Вещи, ящики, шкафы…", color = Ozon.TextSecondary) },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Ozon.Search,
                    unfocusedContainerColor = Ozon.Search,
                    disabledContainerColor = Ozon.Search,
                    focusedTextColor = Ozon.TextPrimary,
                    unfocusedTextColor = Ozon.TextPrimary,
                    cursorColor = Ozon.Blue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            val q = queryText.trim()
            if (q.isEmpty()) {
                EmptyState("Введите название, код, EAN или номер — поищем по всем сущностям.")
            } else if (results.items.isEmpty() && results.locations.isEmpty() && results.storages.isEmpty()) {
                EmptyState("Ничего не найдено по «$q».")
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    if (results.items.isNotEmpty()) {
                        item { SectionTitle("Вещи · ${results.items.size}") }
                        items(results.items, key = { "i-${it.id}" }) { it ->
                            SearchItemRow(it) { nav.navigate("item/${it.id}") }
                        }
                    }
                    if (results.locations.isNotEmpty()) {
                        item { SectionTitle("Ящики · ${results.locations.size}") }
                        items(results.locations, key = { "l-${it.id}" }) { it ->
                            SearchRow(
                                title = it.displayLabel(),
                                subtitle = storageNames[it.storage_id]?.name,
                                onClick = { nav.navigate("location/${it.id}") }
                            )
                        }
                    }
                    if (results.storages.isNotEmpty()) {
                        item { SectionTitle("Шкафы · ${results.storages.size}") }
                        items(results.storages, key = { "s-${it.id}" }) { it ->
                            SearchRow(
                                title = it.name,
                                subtitle = it.code.ifBlank { null },
                                onClick = { nav.navigate("storage/${it.id}") }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchItemRow(item: ItemEntity, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                item.name,
                style = MaterialTheme.typography.titleMedium,
                color = Ozon.TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            val sub = buildList {
                if (item.code.isNotBlank()) add(item.code)
                item.ean?.let { add("EAN $it") }
                if (item.description.isNotBlank()) add(item.description.take(50))
            }.joinToString(" · ")
            if (sub.isNotEmpty()) {
                Text(sub, style = MaterialTheme.typography.bodyMedium, color = Ozon.TextSecondary, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}

@Composable
private fun SearchRow(title: String, subtitle: String?, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                title,
                style = MaterialTheme.typography.titleMedium,
                color = Ozon.TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            if (subtitle != null) {
                Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = Ozon.TextSecondary, maxLines = 1, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}
