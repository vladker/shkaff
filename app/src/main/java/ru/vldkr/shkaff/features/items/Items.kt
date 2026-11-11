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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import ru.vldkr.shkaff.domain.search.ItemMatch
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ErrorState
import ru.vldkr.shkaff.ui.components.ListSkeleton
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.ui.components.itemStatus
import ru.vldkr.shkaff.ui.state.ListFeed
import ru.vldkr.shkaff.ui.state.UiState
import ru.vldkr.shkaff.ui.state.mergeFeeds
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.ui.components.ItemCard
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.theme.Ozon

class ItemsVm : ViewModel() {

    data class Ui(
        val allItems: List<ItemEntity> = emptyList(),
        val query: String = "",
        val tagFilter: String = "",
        val tagOptions: List<String> = emptyList(),
        val loansByItem: Map<String, LoanEntity> = emptyMap(),
        // US-O8: true до первой выдачи списка — показываем skeleton.
        val loading: Boolean = true,
        // T-040: сбой подписки (Room/DAO) — текст причины на экране + «Повторить».
        val error: String? = null
    )

    val ui = MutableStateFlow(Ui())

    // T-040: подписки идут через ListFeed, а не голым collect: без catch упавший поток
    // молча умирал, loading оставался true и экран крутил skeleton вечно.
    private val itemsFeed = ListFeed(viewModelScope) { Deps.items.observeAll() }
    private val tagsFeed = ListFeed(viewModelScope) { Deps.tags.observeAll() }
    private val loansFeed = ListFeed(viewModelScope) { Deps.loans.observeActive() }
    private val feeds = listOf(itemsFeed, tagsFeed, loansFeed)

    val list = ui.map { u ->
        val t = u.query.trim()
        var l = if (t.isEmpty()) u.allItems else u.allItems.filter { ItemMatch.matches(it, t) }
        // US-I3: фильтр по тегам — совпадение без учёта регистра
        if (u.tagFilter.isNotEmpty()) {
            l = l.filter { ItemMatch.matchesTag(it, u.tagFilter) }
        }
        l
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        feeds.forEach { it.start() }
        // T-040: общий гейт подписок экрана: loading пока хоть одна грузится, error — если любая упала.
        viewModelScope.launch {
            mergeFeeds(feeds).collect { g ->
                ui.value = ui.value.copy(
                    loading = g is UiState.Loading,
                    error = (g as? UiState.Error)?.message
                )
            }
        }
        viewModelScope.launch {
            itemsFeed.state.collect { s -> if (s is UiState.Success) ui.value = ui.value.copy(allItems = s.data) }
        }
        viewModelScope.launch {
            tagsFeed.state.collect { s ->
                if (s is UiState.Success) ui.value = ui.value.copy(tagOptions = s.data.map { e -> e.name }.distinct().sorted())
            }
        }
        viewModelScope.launch {
            loansFeed.state.collect { s ->
                if (s is UiState.Success) {
                    ui.value = ui.value.copy(loansByItem = s.data.filter { it.entity_type == "item" }.associateBy { it.entity_id })
                }
            }
        }
    }

    /** «Повторить» в error-состоянии: переподписка ко всем потокам экрана. */
    fun retry() {
        feeds.forEach { it.retry() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(nav: NavController, tag: String = "") {
    val vm: ItemsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val list by vm.list.collectAsState()
    val ui by vm.ui.collectAsState()
    val locations = LocationMap()
    // «0» — служебное значение для роута items/{tag}, когда тега нет
    val effectiveTag = if (tag.isEmpty() || tag == "0") "" else tag
    var queryText by remember { mutableStateOf(vm.ui.value.query) }
    var activeTag by remember { mutableStateOf(effectiveTag) }
    val role = rememberRole()
    LaunchedEffect(Unit) {
        if (effectiveTag.isNotEmpty()) vm.ui.value = vm.ui.value.copy(tagFilter = effectiveTag)
        ScanBus.lastCode?.let { code ->
            queryText = code
            vm.ui.value = vm.ui.value.copy(query = code)
            ScanBus.lastCode = null
        }
        // Живой скан HID-сканером прямо на экране «Вещи»: код сразу становится запросом.
        ScanBus.codes.collect { code ->
            queryText = code
            vm.ui.value = vm.ui.value.copy(query = code)
            ScanBus.lastCode = null
        }
    }
    LaunchedEffect(effectiveTag) { if (effectiveTag.isNotEmpty()) vm.ui.value = vm.ui.value.copy(tagFilter = effectiveTag) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Вещи") }
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(
                    onClick = { nav.navigate("item-wizard") },
                    containerColor = Ozon.Blue,
                    contentColor = Ozon.TextPrimary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Новая вещь")
                }
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            TextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.ui.value = vm.ui.value.copy(query = it)
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Ozon.Blue) },
                placeholder = { Text("Поиск: название, код, атрибуты…", color = Ozon.TextSecondary) },
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
            if (ui.tagOptions.isNotEmpty()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 4.dp)
                        .horizontalScroll(rememberScrollState())
                ) {
                    FilterChip(
                        selected = activeTag.isEmpty(),
                        onClick = { activeTag = ""; vm.ui.value = vm.ui.value.copy(tagFilter = "") },
                        label = { Text("Все") },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    ui.tagOptions.forEach { t ->
                        FilterChip(
                            selected = activeTag.equals(t, ignoreCase = true),
                            onClick = {
                                val next = if (activeTag.equals(t, ignoreCase = true)) "" else t
                                activeTag = next
                                vm.ui.value = vm.ui.value.copy(tagFilter = next)
                            },
                            label = { Text(t) },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
            }
            // T-040: сначала сбой подписки (он важнее «пусто»), потом загрузка, потом пустота.
            val error = ui.error
            if (error != null) {
                ErrorState(error) { vm.retry() }
            } else if (ui.loading) {
                ListSkeleton(rows = 6)
            } else if (list.isEmpty()) {
                if (queryText.isBlank()) {
                    // П1.4: при активном фильтре тега существующие вещи скрыты — первым делом снять фильтр,
                    // иначе (с правом CREATE) — мастер вещи.
                    val filterActive = ui.tagFilter.isNotEmpty()
                    val canAdd = Access.can(role, Access.CREATE)
                    EmptyState(
                        if (filterActive) "Под фильтр «${ui.tagFilter}» ничего нет." else "Список пуст.",
                        actionLabel = EmptyStateCta.itemsEmpty(filterActive, canAdd),
                        onAction = if (filterActive) {
                            { activeTag = ""; vm.ui.value = vm.ui.value.copy(tagFilter = "") }
                        } else if (canAdd) {
                            { nav.navigate("item-wizard") }
                        } else null
                    )
                } else {
                    EmptyState(
                        "Ничего не найдено по «$queryText».",
                        actionLabel = EmptyStateCta.RESET_SEARCH,
                        onAction = {
                            queryText = ""
                            vm.ui.value = vm.ui.value.copy(query = "")
                        }
                    )
                }
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 96.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(list, key = { it.id }) { it ->
                        val status = itemStatus(it, hasLocation = LocationPlacement.hasPlace(it.location_id, locations.keys), loan = ui.loansByItem[it.id])
                        ItemCard(
                            it,
                            locations[it.location_id]?.displayLabel(),
                            { nav.navigate("item/${it.id}") },
                            status = status
                        )
                    }
                }
            }
        }
    }
}
