package ru.vldkr.shkaff.features.items

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Numbers
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.util.Expiry
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.ui.components.ItemCard
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.displayLabel
import java.time.LocalDate

class ItemsVm : ViewModel() {

    val allItems = MutableStateFlow<List<ItemEntity>>(emptyList())
    val query = MutableStateFlow("")
    val tagFilter = MutableStateFlow("")
    val tagOptions = MutableStateFlow<List<String>>(emptyList())

    val list = combine(allItems, query, tagFilter) { all, q, tag ->
        val t = q.trim()
        var l = if (t.isEmpty()) all else all.filter {
            it.name.contains(t, true) ||
                it.code.contains(t, true) ||
                it.description.contains(t, true) ||
                it.attributes.contains(t, true)
        }
        // US-I3: фильтр по тегам — совпадение без учёта регистра
        if (tag.isNotEmpty()) {
            l = l.filter { i ->
                TagsJson.toList(i.tags).any { tn -> tn.equals(tag, ignoreCase = true) }
            }
        }
        l
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            Deps.items.observeAll().collect { allItems.value = it }
        }
        viewModelScope.launch {
            Deps.tags.observeAll().collect { tags ->
                tagOptions.value = tags.map { e -> e.name }.distinct().sorted()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(nav: NavController) {
    val vm: ItemsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val list by vm.list.collectAsState()
    val tagOptions by vm.tagOptions.collectAsState()
    val locations = LocationMap()
    var queryText by remember { mutableStateOf(vm.query.value) }
    var activeTag by remember { mutableStateOf(vm.tagFilter.value) }
    val role = rememberRole()
    LaunchedEffect(Unit) {
        ScanBus.lastCode?.let { code ->
            queryText = code
            vm.query.value = code
            ScanBus.lastCode = null
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Вещи") },
                actions = {
                    if (Access.can(role, Access.CREATE)) {
                        IconButton(onClick = { nav.navigate("batch") }) {
                            Icon(Icons.Filled.Numbers, contentDescription = "Серия вещей")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(onClick = { nav.navigate("item-form/0/0") }) {
                    Icon(Icons.Filled.Add, contentDescription = "Новая вещь")
                }
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            OutlinedTextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.query.value = it
                },
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                placeholder = { Text("Поиск: название, код, атрибуты…") },
                singleLine = true
            )
            if (tagOptions.isNotEmpty()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    FilterChip(
                        selected = activeTag.isEmpty(),
                        onClick = { activeTag = ""; vm.tagFilter.value = "" },
                        label = { Text("Все") },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    tagOptions.forEach { t ->
                        FilterChip(
                            selected = activeTag.equals(t, ignoreCase = true),
                            onClick = {
                                val next = if (activeTag.equals(t, ignoreCase = true)) "" else t
                                activeTag = next
                                vm.tagFilter.value = next
                            },
                            label = { Text(t) },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
            }
            if (list.isEmpty()) {
                EmptyState(
                    if (queryText.isBlank()) "Список пуст. Добавьте первую вещь." else "Ничего не найдено по «$queryText»."
                )
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 96.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(list, key = { it.id }) { it ->
                        val date = Expiry.parse(it.expiry_date)
                        val today = LocalDate.now()
                        ItemCard(
                            it,
                            locations[it.location_id]?.displayLabel(),
                            { nav.navigate("item/${it.id}") },
                            expiryText = date?.let { d -> Expiry.label(d, today) },
                            expiryColor = if (date != null && Expiry.daysUntil(date, today) < 0)
                                MaterialTheme.colorScheme.error
                            else
                                MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}
