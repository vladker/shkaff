package ru.vldkr.shkaff.features.basket

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.BasketItemEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.basket.BasketSort
import ru.vldkr.shkaff.domain.basket.PickPlanner
import ru.vldkr.shkaff.domain.basket.PickStep
import ru.vldkr.shkaff.domain.basket.PickTask
import ru.vldkr.shkaff.domain.levels.Levels
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.rememberRole

class BasketListVm : ViewModel() {

    data class Row(val basket: BasketEntity, val count: Int, val picked: Int)

    val rows = MutableStateFlow<List<Row>>(emptyList())

    init {
        viewModelScope.launch {
            Deps.baskets.observeAll().collect { all ->
                rows.value = all.map { b ->
                    Row(b, Deps.baskets.countItems(b.id), Deps.baskets.countPicked(b.id))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketScreen(nav: NavController) {
    val vm: BasketListVm = viewModel()
    val rows by vm.rows.collectAsState()
    val role = rememberRole()
    val scope = rememberCoroutineScope()
    var showCreate by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Корзина извлечения") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    if (Access.can(role, Access.CREATE)) {
                        IconButton(onClick = { showCreate = true }) {
                            Icon(Icons.Filled.Add, contentDescription = "Новая корзина")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(onClick = { showCreate = true }) {
                    Icon(Icons.Filled.Add, contentDescription = "Новая корзина")
                }
            }
        }
    ) { padding ->
        if (rows.isEmpty()) {
            Column(Modifier.padding(padding).padding(16.dp)) {
                EmptyState("Корзина — список вещей «на вынос». Соберите набор вещей, а приложение покажет план извлечения по местам: всё из одной коробки — один шаг.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(bottom = 96.dp)
            ) {
                items(rows, key = { it.basket.id }) { r ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable { nav.navigate("basket/${r.basket.id}") }
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(Modifier.weight(1f)) {
                            Text(r.basket.name, style = MaterialTheme.typography.titleMedium)
                            Text(
                                "${if (r.basket.status == "done") "Завершена" else "Активна"} · взято ${r.picked} из ${r.count}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        if (r.basket.status == "done") {
                            Icon(Icons.Filled.Check, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        } else {
                            Text("открыть →", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    HorizontalDivider()
                }
            }
        }
    }

    if (showCreate) {
        NewBasketDialog(
            onDismiss = { showCreate = false },
            onConfirm = { name ->
                showCreate = false
                scope.launch {
                    val b = Deps.baskets.create(name)
                    nav.navigate("basket/${b.id}")
                }
            }
        )
    }
}

@Composable
private fun NewBasketDialog(onDismiss: () -> Unit, onConfirm: (name: String) -> Unit) {
    var name by remember { mutableStateOf("") }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Новая корзина") },
        text = {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = { Text("Например: На выезд 12 сентября") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm(name.trim()) },
                enabled = name.isNotBlank()
            ) { Text("Создать") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketDetailScreen(nav: NavController, basketId: String) {
    val role = rememberRole()
    val scope = rememberCoroutineScope()
    var basket by remember { mutableStateOf<BasketEntity?>(null) }
    var raw by remember { mutableStateOf<List<BasketItemEntity>>(emptyList()) }
    var itemsById by remember { mutableStateOf<Map<String, ItemEntity>>(emptyMap()) }
    var storages by remember { mutableStateOf<Map<String, StorageEntity>>(emptyMap()) }
    var locations by remember { mutableStateOf<Map<String, LocationEntity>>(emptyMap()) }
    var sortKey by rememberSaveable { mutableStateOf(BasketSort.ADDITION_ORDER.name) }
    val sort = remember(sortKey) { BasketSort.valueOf(sortKey) }

    var showAddItems by remember { mutableStateOf(false) }
    var showDelete by remember { mutableStateOf(false) }

    LaunchedEffect(basketId) {
        basket = Deps.baskets.byId(basketId)
        raw = Deps.baskets.items(basketId)
        itemsById = Deps.items.all().associateBy { it.id }
    }
    LaunchedEffect(basketId) {
        storages = Deps.storages.observeAll().first().associateBy { it.id }
    }
    LaunchedEffect(basketId) {
        locations = Deps.locations.observeAll().first().associateBy { it.id }
    }

    val reload: () -> Unit = {
        scope.launch {
            basket = Deps.baskets.byId(basketId)
            raw = Deps.baskets.items(basketId)
        }
    }

    val steps = remember(storages, locations, itemsById, raw, sort) {
        PickPlanner.plan(
            raw.mapNotNull { bi ->
                val item = itemsById[bi.item_id] ?: return@mapNotNull null
                val loc = item.location_id?.let { locations[it] }
                PickTask(
                    key = bi.id,
                    itemId = item.id,
                    itemName = item.name.ifBlank { item.code },
                    locationId = item.location_id,
                    locationPath = pathFor(loc, storages, locations),
                    sizeLiters = item.volume_liters,
                    addedAt = bi.created_at
                )
            },
            sort
        )
    }
    val pickedKeys = remember(raw) { raw.filter { it.picked_ts != null }.map { it.id }.toSet() }
    val total = raw.size
    val picked = pickedKeys.size

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(basket?.name ?: "Корзина") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    if (Access.can(role, Access.EDIT)) {
                        if (basket?.status == "done") {
                            TextButton(onClick = { scope.launch { Deps.baskets.setStatus(basketId, "active"); reload() } }) {
                                Text("Открыть")
                            }
                        } else {
                            TextButton(onClick = { scope.launch { Deps.baskets.setStatus(basketId, "done"); reload() } }) {
                                Text("Завершить")
                            }
                        }
                        IconButton(onClick = { showDelete = true }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Удалить корзину")
                        }
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
            contentPadding = PaddingValues(bottom = 96.dp)
        ) {
            item {
                Text(
                    "Взято $picked из $total · всё из одного места — один шаг",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            item {
                Text("Сортировка", style = MaterialTheme.typography.labelLarge, modifier = Modifier.padding(top = 8.dp, bottom = 4.dp))
                SortChip("Порядок добавления", BasketSort.ADDITION_ORDER, sort) { sortKey = it.name }
                SortChip("Сначала — где больше вещей", BasketSort.BY_LOCATION_COUNT, sort) { sortKey = it.name }
                SortChip("Сначала мелкие", BasketSort.SMALL_FIRST, sort) { sortKey = it.name }
                SortChip("Сначала верхнее", BasketSort.SHALLOW_DEPTH, sort) { sortKey = it.name }
            }
            if (Access.can(role, Access.EDIT)) {
                item {
                    OutlinedButton(onClick = { showAddItems = true }, modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                        Text("Добавить вещи")
                    }
                }
            }
            if (steps.isEmpty()) {
                item {
                    Text(
                        if (total == 0) "В корзине пока пусто. Добавьте вещи — они соберутся в шаги по местам."
                        else "Не удалось собрать план: проверьте, что вещи на месте.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            } else {
                items(steps, key = { stepKey(it) }) { step ->
                    StepCard(step, pickedKeys, role, basketId, scope, reload)
                    HorizontalDivider()
                }
            }
        }
    }

    if (showAddItems) {
        AddItemsDialog(
            rows = rememberAllItems(),
            already = raw.map { it.item_id }.toSet(),
            onPick = { ids ->
                ids.forEach { id -> scope.launch { Deps.baskets.addItem(basketId, id) } }
                showAddItems = false
                reload()
            },
            onDismiss = { showAddItems = false }
        )
    }

    if (showDelete) {
        AlertDialog(
            onDismissRequest = { showDelete = false },
            title = { Text("Удалить корзину?") },
            text = { Text("Корзина — только список. Вещи внутри не удаляются.") },
            confirmButton = {
                TextButton(onClick = {
                    showDelete = false
                    scope.launch {
                        Deps.baskets.softDelete(basketId)
                        nav.popBackStack()
                    }
                }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { showDelete = false }) { Text("Отмена") }
            }
        )
    }
}

private fun stepKey(step: PickStep): String = step.locationId ?: "@none"

// Один шаг извлечения: карточка места + чеклист вещей.
@Composable
private fun StepCard(
    step: PickStep,
    pickedKeys: Set<String>,
    role: Role,
    basketId: String,
    scope: CoroutineScope,
    reload: () -> Unit
) {
    Column(Modifier.padding(vertical = 8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(
                "Шаг · ${step.label}",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.weight(1f)
            )
            Text(
                "вещей: ${step.tasks.size}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        step.tasks.forEach { t ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        scope.launch {
                            Deps.baskets.setPicked(t.key, !pickedKeys.contains(t.key))
                            reload()
                        }
                    }
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = pickedKeys.contains(t.key),
                    onCheckedChange = { checked ->
                        scope.launch {
                            Deps.baskets.setPicked(t.key, checked)
                            reload()
                        }
                    }
                )
                Column(Modifier.weight(1f)) {
                    Text(
                        t.itemName,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    if (t.sizeLiters > 0) {
                        Text(
                            "объём ${t.sizeLiters} л",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                if (Access.can(role, Access.EDIT)) {
                    TextButton(onClick = {
                        scope.launch {
                            Deps.baskets.removeItem(t.key, basketId)
                            reload()
                        }
                    }) { Text("Убрать", color = MaterialTheme.colorScheme.error) }
                }
            }
        }
    }
}

private fun pathFor(
    loc: LocationEntity?,
    storages: Map<String, StorageEntity>,
    locations: Map<String, LocationEntity>
): List<String> {
    if (loc == null) return emptyList()
    val storage = storages[loc.storage_id]
    val storagePath = storage?.let {
        Levels.chainToRoot(it.id, storages, { s -> s.name }, { s -> s.parent_id })
    } ?: emptyList()
    val locPath = Levels.chainToRoot(
        loc.id,
        locations,
        { l -> l.label.ifBlank { l.name }.ifBlank { "Ящик" } },
        { l -> l.parent_id }
    )
    return storagePath + locPath
}

@Composable
private fun rememberAllItems(): List<ItemEntity> {
    var items by remember { mutableStateOf<List<ItemEntity>>(emptyList()) }
    LaunchedEffect(Unit) { items = Deps.items.all() }
    return items
}

@Composable
private fun SortChip(label: String, value: BasketSort, current: BasketSort, onPick: (BasketSort) -> Unit) {
    FilterChip(
        selected = current == value,
        onClick = { onPick(value) },
        label = { Text(label) },
        modifier = Modifier.padding(vertical = 2.dp).fillMaxWidth()
    )
}

@Composable
private fun AddItemsDialog(
    rows: List<ItemEntity>,
    already: Set<String>,
    onPick: (List<String>) -> Unit,
    onDismiss: () -> Unit
) {
    val selected = remember { mutableStateOf<MutableSet<String>>(mutableSetOf()) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Добавить вещи в корзину") },
        text = {
            Column(Modifier.fillMaxWidth()) {
                if (rows.none { it.id !in already }) {
                    Text("Нет вещей для добавления", color = MaterialTheme.colorScheme.onSurfaceVariant)
                } else {
                    rows.forEach { r ->
                        if (r.id !in already) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        if (!selected.value.add(r.id)) selected.value.remove(r.id)
                                    }
                                    .padding(vertical = 2.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Checkbox(checked = r.id in selected.value, onCheckedChange = {
                                    if (it) selected.value.add(r.id) else selected.value.remove(r.id)
                                })
                                Text(r.name.ifBlank { r.code }, modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onPick(selected.value.toList()) },
                enabled = selected.value.isNotEmpty()
            ) { Text("Добавить (${selected.value.size})") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}