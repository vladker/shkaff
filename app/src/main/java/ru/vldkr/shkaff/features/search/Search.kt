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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.search.ItemMatch
import ru.vldkr.shkaff.domain.search.SearchSubtitles
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ErrorState
import ru.vldkr.shkaff.ui.components.ListSkeleton
import ru.vldkr.shkaff.ui.components.SearchClearIcon
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.state.ListFeed
import ru.vldkr.shkaff.ui.state.UiState
import ru.vldkr.shkaff.ui.state.mergeFeeds
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.util.ScanBus

// Глобальный поиск: одно поле — вещи, ящики и шкафы (поиск без учёта регистра).
class SearchVm : ViewModel() {
    data class Ui(
        val items: List<ItemEntity> = emptyList(),
        val locations: List<LocationEntity> = emptyList(),
        val storages: List<StorageEntity> = emptyList(),
        val query: String = "",
        // T-040: без этих флагов до первой эмиссии БД экран врал «Ничего не найдено».
        val loading: Boolean = true,
        val error: String? = null,
    )

    data class Results(
        val items: List<ItemEntity> = emptyList(),
        val locations: List<LocationEntity> = emptyList(),
        val storages: List<StorageEntity> = emptyList(),
        val itemsTotal: Int = 0,
        val locationsTotal: Int = 0,
        val storagesTotal: Int = 0,
    )

    val ui = MutableStateFlow(Ui())

    // T-040: подписки через ListFeed — до первой эмиссии loading (skeleton), сбой потока
    // (Room/DAO) превращается в error вместо «пустого» списка.
    private val itemsFeed = ListFeed(viewModelScope) { Deps.items.observeAll() }
    private val locationsFeed = ListFeed(viewModelScope) { Deps.locations.observeAll() }
    private val storagesFeed = ListFeed(viewModelScope) { Deps.storages.observeAll() }
    private val feeds = listOf(itemsFeed, locationsFeed, storagesFeed)

    val results =
        ui
            .map { u ->
                val t = u.query.trim()
                if (t.isEmpty()) return@map Results()
                // T-044: полные числа идут в заголовки секций, на экран — только первые SEARCH_LIMIT.
                val items = u.items.filter { ItemMatch.matches(it, t) }
                val locations =
                    u.locations
                        .filter { it.label.contains(t, true) || it.name.contains(t, true) }
                val storages =
                    u.storages
                        .filter {
                            it.name.contains(t, true) ||
                                it.code.contains(t, true) ||
                                it.description.contains(t, true)
                        }
                Results(
                    items = items.take(SEARCH_LIMIT),
                    locations = locations.take(SEARCH_LIMIT),
                    storages = storages.take(SEARCH_LIMIT),
                    itemsTotal = items.size,
                    locationsTotal = locations.size,
                    storagesTotal = storages.size,
                )
            }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Results())

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
            itemsFeed.state.collect { s -> if (s is UiState.Success) ui.value = ui.value.copy(items = s.data) }
        }
        viewModelScope.launch {
            locationsFeed.state.collect { s -> if (s is UiState.Success) ui.value = ui.value.copy(locations = s.data) }
        }
        viewModelScope.launch {
            storagesFeed.state.collect { s -> if (s is UiState.Success) ui.value = ui.value.copy(storages = s.data) }
        }
    }

    /** «Повторить» в error-состоянии: переподписка ко всем потокам экрана. */
    fun retry() {
        feeds.forEach { it.retry() }
    }
}

// T-044: глобальный поиск показывает первые N совпадений; полное число — в заголовке секции.
const val SEARCH_LIMIT = 50

fun countLabel(
    shown: Int,
    total: Int,
): String = if (total > shown) "$shown из $total" else "$total"

fun searchHint(truncated: Boolean): String? =
    if (truncated) "Показаны первые $SEARCH_LIMIT совпадений — уточните запрос." else null

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(nav: NavController) {
    val vm: SearchVm =
        androidx.lifecycle.viewmodel.compose
            .viewModel()
    val results by vm.results.collectAsState()
    val ui by vm.ui.collectAsState()
    var queryText by remember { mutableStateOf(vm.ui.value.query) }
    // T-043: карта строится из полных ui.storages, а не из results.storages (только
    // совпадения + .take(50)) — иначе у ящика шкафа, не задетого запросом, подпись теряется.
    val storageNames = remember(ui.storages) { SearchSubtitles.storageById(ui.storages) }
    // Scan-first (PLAN_ONBOARDING П1.1): скан с камеры/диплинка/HID прямо здесь становится запросом.
    LaunchedEffect(Unit) {
        ScanBus.lastCode?.let { code ->
            queryText = code
            vm.ui.value = vm.ui.value.copy(query = code)
            ScanBus.lastCode = null
        }
        ScanBus.codes.collect { code ->
            queryText = code
            vm.ui.value = vm.ui.value.copy(query = code)
            ScanBus.lastCode = null
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Поиск") }) },
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
                placeholder = { Text("Вещи, ящики, шкафы…", color = Ozon.TextSecondary) },
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
            val q = queryText.trim()
            // T-040: сбой подписки и загрузка — отдельные ветки; «Ничего не найдено» только
            // когда данные реально пришли и совпадений нет.
            val error = ui.error
            if (error != null) {
                ErrorState(error) { vm.retry() }
            } else if (q.isEmpty()) {
                // Крупное скан-действие вместо голой подсказки: скан = глагол (WMS-подход).
                EmptyState(
                    "Введите название, код, EAN или номер — поищем по всем сущностям.",
                    actionLabel = "Сканировать",
                    onAction = { nav.navigate("scan") },
                )
            } else if (ui.loading) {
                ListSkeleton(rows = 5)
            } else if (results.items.isEmpty() && results.locations.isEmpty() && results.storages.isEmpty()) {
                EmptyState(
                    "Ничего не найдено по «$q».",
                    actionLabel = EmptyStateCta.RESET_SEARCH,
                    onAction = {
                        queryText = ""
                        vm.ui.value = vm.ui.value.copy(query = "")
                    },
                )
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding =
                        androidx.compose.foundation.layout
                            .PaddingValues(horizontal = 16.dp, vertical = 4.dp),
                ) {
                    val truncated =
                        results.itemsTotal > results.items.size ||
                            results.locationsTotal > results.locations.size ||
                            results.storagesTotal > results.storages.size
                    searchHint(truncated)?.let { hint ->
                        item {
                            Text(
                                hint,
                                style = MaterialTheme.typography.bodySmall,
                                color = Ozon.TextSecondary,
                                modifier = Modifier.padding(vertical = 6.dp),
                            )
                        }
                    }
                    if (results.items.isNotEmpty()) {
                        item { SectionTitle("Вещи · ${countLabel(results.items.size, results.itemsTotal)}") }
                        items(results.items, key = { "i-${it.id}" }) { it ->
                            SearchItemRow(it) { nav.navigate("item/${it.id}") }
                        }
                    }
                    if (results.locations.isNotEmpty()) {
                        item { SectionTitle("Ящики · ${countLabel(results.locations.size, results.locationsTotal)}") }
                        items(results.locations, key = { "l-${it.id}" }) { it ->
                            SearchRow(
                                title = it.displayLabel(),
                                subtitle = SearchSubtitles.locationStorageName(it, storageNames),
                                onClick = { nav.navigate("location/${it.id}") },
                            )
                        }
                    }
                    if (results.storages.isNotEmpty()) {
                        item { SectionTitle("Шкафы · ${countLabel(results.storages.size, results.storagesTotal)}") }
                        items(results.storages, key = { "s-${it.id}" }) { it ->
                            SearchRow(
                                title = it.name,
                                subtitle = it.code.ifBlank { null },
                                onClick = { nav.navigate("storage/${it.id}") },
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchItemRow(
    item: ItemEntity,
    onClick: () -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                item.name,
                style = MaterialTheme.typography.titleMedium,
                color = Ozon.TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            val sub =
                buildList {
                    if (item.code.isNotBlank()) add(item.code)
                    item.ean?.let { add("EAN $it") }
                    if (item.description.isNotBlank()) add(item.description.take(50))
                }.joinToString(" · ")
            if (sub.isNotEmpty()) {
                Text(
                    sub,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Ozon.TextSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
private fun SearchRow(
    title: String,
    subtitle: String?,
    onClick: () -> Unit,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(Modifier.weight(1f)) {
            Text(
                title,
                style = MaterialTheme.typography.titleMedium,
                color = Ozon.TextPrimary,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            if (subtitle != null) {
                Text(
                    subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Ozon.TextSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}
