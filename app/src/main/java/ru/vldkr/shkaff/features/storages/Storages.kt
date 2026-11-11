package ru.vldkr.shkaff.features.storages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ErrorState
import ru.vldkr.shkaff.ui.components.ListSkeleton
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.ui.state.ListFeed
import ru.vldkr.shkaff.ui.state.UiState
import ru.vldkr.shkaff.ui.state.mergeFeeds
import ru.vldkr.shkaff.ui.theme.Ozon

class StoragesVm : ViewModel() {

    data class Row(val storage: StorageEntity, val depth: Int)
    // Наполненность хранилища: использовано/ёмкость (л) по ящикам внутри него.
    data class Usage(val used: Double, val capacity: Double)

    data class Ui(
        val rows: List<Row> = emptyList(),
        val locationsCount: Map<String, Int> = emptyMap(),
        val usage: Map<String, Usage> = emptyMap(),
        val query: String = "",
        // T-040: «Хранилищ пока нет» враньё и до первой эмиссии БД, и после сбоя подписки.
        val loading: Boolean = true,
        val error: String? = null
    )

    val ui = MutableStateFlow(Ui())
    private val all = MutableStateFlow<List<StorageEntity>>(emptyList())
    private val locs = MutableStateFlow<List<ru.vldkr.shkaff.data.db.LocationEntity>>(emptyList())
    private val items = MutableStateFlow<List<ru.vldkr.shkaff.data.db.ItemEntity>>(emptyList())

    private val storagesFeed = ListFeed(viewModelScope) { Deps.storages.observeAll() }
    private val locationsFeed = ListFeed(viewModelScope) { Deps.locations.observeAll() }
    private val itemsFeed = ListFeed(viewModelScope) { Deps.items.observeAll() }
    private val feeds = listOf(storagesFeed, locationsFeed, itemsFeed)

    init {
        feeds.forEach { it.start() }
        viewModelScope.launch {
            mergeFeeds(feeds).collect { g ->
                ui.value = ui.value.copy(
                    loading = g is UiState.Loading,
                    error = (g as? UiState.Error)?.message
                )
            }
        }
        viewModelScope.launch {
            storagesFeed.state.collect { s ->
                if (s is UiState.Success) {
                    all.value = s.data
                    ui.value = ui.value.copy(rows = flatten(s.data))
                    recomputeUsage()
                }
            }
        }
        viewModelScope.launch {
            locationsFeed.state.collect { s ->
                if (s is UiState.Success) {
                    locs.value = s.data
                    ui.value = ui.value.copy(locationsCount = s.data.groupBy { it.storage_id }.mapValues { e -> e.value.size })
                    recomputeUsage()
                }
            }
        }
        viewModelScope.launch {
            itemsFeed.state.collect { s ->
                if (s is UiState.Success) {
                    items.value = s.data
                    recomputeUsage()
                }
            }
        }
    }

    /** «Повторить» в error-состоянии: переподписка ко всем потокам экрана. */
    fun retry() {
        feeds.forEach { it.retry() }
    }

    // Суммируем по каждому хранилищу ёмкость его ящиков и занятое объёмом вещей.
    private fun recomputeUsage() {
        val l = locs.value
        val its = items.value
        if (l.isEmpty()) return
        // ящик → используемый объём (сумма volume_liters вещей внутри)
        val usedByLoc = its.groupBy { it.location_id }.mapValues { e -> e.value.sumOf { it.volume_liters } }
        val byStorage = HashMap<String, Usage>()
        for (loc in l) {
            val used = usedByLoc[loc.id] ?: 0.0
            val cap = loc.capacity_volume ?: 0.0
            val cur = byStorage[loc.storage_id] ?: Usage(0.0, 0.0)
            byStorage[loc.storage_id] = Usage(cur.used + used, cur.capacity + cap)
        }
        ui.value = ui.value.copy(usage = byStorage)
    }

    fun setQuery(q: String) {
        ui.value = ui.value.copy(query = q)
    }

    // старшие хранилища первыми, вложенные — вглубь; сироты (родитель удалён) — на верхнем уровне
    private fun flatten(all: List<StorageEntity>): List<Row> {
        val byId = all.associateBy { it.id }
        val byParent = all.groupBy { it.parent_id ?: "" }
        val out = mutableListOf<Row>()
        val seen = mutableSetOf<String>()
        fun rec(id: String, depth: Int) {
            if (!seen.add(id)) return
            byId[id]?.let { out += Row(it, depth) }
            (byParent[id] ?: emptyList()).forEach { rec(it.id, depth + 1) }
        }
        all.forEach { s ->
            val pid = s.parent_id
            if (pid == null || pid !in byId) rec(s.id, 0)
        }
        return out
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StoragesScreen(nav: NavController) {
    val vm: StoragesVm = viewModel()
    val ui by vm.ui.collectAsState()
    val role = rememberRole()
    var queryText by remember { mutableStateOf(ui.query) }

    val q = ui.query.trim()
    val visible = if (q.isEmpty()) ui.rows else ui.rows.filter { r ->
        r.storage.name.contains(q, true) ||
            r.storage.level.contains(q, true) ||
            r.storage.code.contains(q, true) ||
            r.storage.description.contains(q, true)
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Хранилища") }) },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(onClick = { nav.navigate("storage-form/0") }) {
                    Icon(Icons.Filled.Add, contentDescription = "Новое хранилище")
                }
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            TextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.setQuery(it)
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Ozon.Blue) },
                placeholder = { Text("Поиск: название, уровень, код…", color = Ozon.TextSecondary) },
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
            // T-040: сбой подписки и загрузка — отдельные ветки, «пока нет» только по факту пустоты.
            val error = ui.error
            if (error != null) {
                ErrorState(error) { vm.retry() }
            } else if (ui.loading) {
                ListSkeleton(rows = 6)
            } else if (ui.rows.isEmpty()) {
                val canCreate = Access.can(role, Access.CREATE)
                EmptyState(
                    "Хранилищ пока нет.\nДобавьте первое: шкаф, стеллаж, комод. Хранилища можно вкладывать друг в друга, потом — ящики и вещи внутри.",
                    actionLabel = if (canCreate) "Создать хранилище" else null,
                    onAction = if (canCreate) { { nav.navigate("storage-form/0") } } else null
                )
            } else if (visible.isEmpty()) {
                EmptyState(
                    "Ничего не найдено по «$q».",
                    actionLabel = EmptyStateCta.RESET_SEARCH,
                    onAction = {
                        queryText = ""
                        vm.setQuery("")
                    }
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxSize(),
                    contentPadding = PaddingValues(bottom = 96.dp)
                ) {
                    items(visible, key = { it.storage.id }) { r ->
                        val usage = ui.usage[r.storage.id]
                        StorageRow(
                            r.storage, r.depth, ui.locationsCount[r.storage.id] ?: 0,
                            usage?.used ?: 0.0, usage?.capacity ?: 0.0
                        ) { nav.navigate("storage/${r.storage.id}") }
                    }
                }
            }
        }
    }
}

// Цвет индикатора наполненности: без ёмкости — нейтральный, иначе по доле заполнения.
private fun fillColor(capacity: Double, used: Double): Color {
    if (capacity <= 0) return Ozon.TextMuted
    val r = used / capacity
    return when {
        r < 0.6 -> Ozon.Green
        r < 0.9 -> Ozon.Orange
        else -> Ozon.Pink
    }
}

@Composable
private fun StorageRow(
    storage: StorageEntity,
    depth: Int,
    locationsCount: Int,
    used: Double,
    capacity: Double,
    onClick: () -> Unit
) {
    val fill = fillColor(capacity, used)
    val hasCapacity = capacity > 0
    val ratio = if (hasCapacity) (used / capacity).toFloat().coerceIn(0f, 1f) else 0f
    Row(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(start = 4.dp, top = 12.dp, end = 4.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Индикатор наполненности: цветная полоса слева.
        Box(
            Modifier
                .width(4.dp)
                .height(34.dp)
                .clip(RoundedCornerShape(2.dp))
                .background(fill)
        )
        Column(Modifier.padding(start = 12.dp).weight(1f)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (depth > 0) {
                    Text("↳ ", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
                Text(
                    storage.name,
                    style = if (depth == 0) MaterialTheme.typography.titleMedium else MaterialTheme.typography.bodyLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
                if (storage.level.isNotBlank()) {
                    Text(
                        storage.level,
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(start = 6.dp, end = 6.dp)
                    )
                }
                Text(
                    "$locationsCount яшк.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            if (storage.description.isNotBlank()) {
                Text(
                    storage.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            if (hasCapacity) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 6.dp)) {
                    LinearProgressIndicator(
                        progress = { ratio },
                        modifier = Modifier.weight(1f).height(4.dp).clip(RoundedCornerShape(2.dp)),
                        color = fill,
                        trackColor = Ozon.Line
                    )
                    Text(
                        "${(ratio * 100).toInt()}%",
                        style = MaterialTheme.typography.labelSmall,
                        color = fill,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}
