package ru.vldkr.shkaff.features.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.locations.LocationPlacement
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ErrorState
import ru.vldkr.shkaff.ui.components.ItemCard
import ru.vldkr.shkaff.ui.components.ListSkeleton
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.SearchClearIcon
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.components.itemStatus
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.ui.state.ListFeed
import ru.vldkr.shkaff.ui.state.UiState
import ru.vldkr.shkaff.ui.state.mergeFeeds
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.util.Expiry
import java.time.LocalDate

// Продукты — магазинные вещи с рыночным штрихкодом (EAN); уличены отдельным
// экраном-каталогом, но в базе это те же item (ean заполнен).
class ProductsVm : ViewModel() {
    data class Ui(
        val allItems: List<ItemEntity> = emptyList(),
        val query: String = "",
        // T-042: активные выдачи вещей — как на «Вещах»: без неё выданный
        // продукт на карточке выглядел свободным.
        val loansByItem: Map<String, LoanEntity> = emptyMap(),
        // T-040: «Продуктов пока нет» показывалось и до первой эмиссии БД, и после сбоя
        // подписки — теперь загрузка и сбой это отдельные ветки.
        val loading: Boolean = true,
        val error: String? = null,
    )

    val ui = MutableStateFlow(Ui())

    private val itemsFeed = ListFeed(viewModelScope) { Deps.items.observeAll() }
    private val loansFeed = ListFeed(viewModelScope) { Deps.loans.observeActive() }
    private val feeds = listOf(itemsFeed, loansFeed)

    val list =
        ui
            .map { u ->
                val t = u.query.trim()
                var l = u.allItems.filter { it.ean?.isNotBlank() == true }
                if (t.isNotEmpty()) {
                    l =
                        l.filter {
                            it.name.contains(t, true) ||
                                it.code.contains(t, true) ||
                                (it.ean ?: "").contains(t, true) ||
                                it.description.contains(t, true) ||
                                it.attributes.contains(t, true)
                        }
                }
                l
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        feeds.forEach { it.start() }
        viewModelScope.launch {
            mergeFeeds(feeds).collect { g ->
                ui.value =
                    ui.value.copy(
                        loading = g is UiState.Loading,
                        error = (g as? UiState.Error)?.message,
                    )
            }
        }
        viewModelScope.launch {
            itemsFeed.state.collect { s -> if (s is UiState.Success) ui.value = ui.value.copy(allItems = s.data) }
        }
        // T-042: карта активных выдач по вещам — зеркало ItemsVm (ключ — entity_id вещи).
        viewModelScope.launch {
            loansFeed.state.collect { s ->
                if (s is UiState.Success) {
                    ui.value = ui.value.copy(loansByItem = s.data.filter { it.entity_type == "item" }.associateBy { it.entity_id })
                }
            }
        }
    }

    /** «Повторить» в error-состоянии: переподписка к потоку списка. */
    fun retry() {
        feeds.forEach { it.retry() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(nav: NavController) {
    val vm: ProductsVm =
        androidx.lifecycle.viewmodel.compose
            .viewModel()
    val list by vm.list.collectAsState()
    val ui by vm.ui.collectAsState()
    val locations = LocationMap()
    var queryText by remember { mutableStateOf(vm.ui.value.query) }
    val role = rememberRole()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Продукты") },
                actions = {
                    if (Access.can(role, Access.CREATE)) {
                        IconButton(onClick = { nav.navigate("item-wizard") }) {
                            Icon(Icons.Filled.Add, contentDescription = "Новый продукт")
                        }
                    }
                },
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(
                    onClick = { nav.navigate("item-wizard") },
                    containerColor = Ozon.Blue,
                    contentColor = Ozon.TextPrimary,
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Новый продукт")
                }
            }
        },
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            TextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.ui.value = vm.ui.value.copy(query = it)
                },
                modifier =
                    Modifier
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp)),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Ozon.Blue) },
                trailingIcon = {
                    SearchClearIcon(queryText) {
                        queryText = ""
                        vm.ui.value = vm.ui.value.copy(query = "")
                    }
                },
                placeholder = { Text("Название, код или EAN…", color = Ozon.TextSecondary) },
                singleLine = true,
                colors =
                    TextFieldDefaults.colors(
                        focusedContainerColor = Ozon.Search,
                        unfocusedContainerColor = Ozon.Search,
                        disabledContainerColor = Ozon.Search,
                        focusedTextColor = Ozon.TextPrimary,
                        unfocusedTextColor = Ozon.TextPrimary,
                        cursorColor = Ozon.Blue,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                    ),
            )
            // T-040: сбой подписки и загрузка — отдельные ветки, «пока нет» только по факту пустоты.
            val error = ui.error
            if (error != null) {
                ErrorState(error) { vm.retry() }
            } else if (ui.loading) {
                ListSkeleton(rows = 6)
            } else if (list.isEmpty()) {
                if (queryText.isBlank()) {
                    val canAdd = Access.can(role, Access.CREATE)
                    EmptyState(
                        "Продуктов пока нет.\nПродукт — вещь с рыночным штрихкодом (EAN).",
                        actionLabel = if (canAdd) "Добавить продукт" else null,
                        onAction =
                            if (canAdd) {
                                { nav.navigate("item-wizard") }
                            } else {
                                null
                            },
                    )
                } else {
                    EmptyState(
                        "Ничего не найдено по «$queryText».",
                        actionLabel = EmptyStateCta.RESET_SEARCH,
                        onAction = {
                            queryText = ""
                            vm.ui.value = vm.ui.value.copy(query = "")
                        },
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 96.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items(list, key = { it.id }) { it ->
                        val date = Expiry.parse(it.expiry_date)
                        val today = LocalDate.now()
                        val days = date?.let { d -> Expiry.daysUntil(d, today) }
                        // T-042: общая ItemCard со статусом по активной выдаче — как на «Вещах»;
                        // «место» считаем по живым ящикам (T-041), «призрак» — не место.
                        val status =
                            itemStatus(
                                it,
                                hasLocation = LocationPlacement.hasPlace(it.location_id, locations.keys),
                                loan = ui.loansByItem[it.id],
                            )
                        ItemCard(
                            it,
                            locations[it.location_id]?.displayLabel(),
                            { nav.navigate("item/${it.id}") },
                            expiryText = date?.let { d -> Expiry.label(d, today) },
                            expiryColor = if ((days ?: 1) < 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                            status = status,
                            ean = it.ean,
                        )
                    }
                }
            }
        }
    }
}
