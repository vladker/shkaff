package ru.vldkr.shkaff.features.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemRow
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.displayLabel

class ItemsVm : ViewModel() {

    val allItems = MutableStateFlow<List<ItemEntity>>(emptyList())
    val query = MutableStateFlow("")

    val list = combine(allItems, query) { all, q ->
        val t = q.trim()
        if (t.isEmpty()) all
        else all.filter {
            it.name.contains(t, true) ||
                it.code.contains(t, true) ||
                it.description.contains(t, true) ||
                it.attributes.contains(t, true)
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            Deps.items.observeAll().collect { allItems.value = it }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(nav: NavController) {
    val vm: ItemsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val list by vm.list.collectAsState()
    val locations = LocationMap()
    var queryText by remember { mutableStateOf(vm.query.value) }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Вещи") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { nav.navigate("item-form/0/0") }) {
                Icon(Icons.Filled.Add, contentDescription = "Новая вещь")
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).padding(horizontal = 16.dp).fillMaxSize()) {
            OutlinedTextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.query.value = it
                },
                modifier = Modifier.padding(vertical = 8.dp),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                placeholder = { Text("Поиск: название, код, атрибуты…") },
                singleLine = true
            )
            if (list.isEmpty()) {
                EmptyState(
                    if (queryText.isBlank()) "Список пуст. Добавьте первую вещь." else "Ничего не найдено по «$queryText»."
                )
            } else {
                LazyColumn(contentPadding = PaddingValues(bottom = 96.dp)) {
                    items(list, key = { it.id }) { it ->
                        ItemRow(it, locations[it.location_id]?.displayLabel()) { nav.navigate("item/${it.id}") }
                    }
                }
            }
        }
    }
}
