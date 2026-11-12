package ru.vldkr.shkaff.features.items

import android.content.Context
import android.content.Intent
import androidx.core.content.FileProvider
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.BasketEntity
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.locations.LocationPlacement
import ru.vldkr.shkaff.features.loans.LendDialog
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemCard
import ru.vldkr.shkaff.ui.components.ItemPhoto
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.StatusBadge
import ru.vldkr.shkaff.ui.components.itemStatus
import ru.vldkr.shkaff.ui.components.itemStatuses
import ru.vldkr.shkaff.ui.components.undo
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.util.formatDate
import java.io.File

class ItemDetailVm(val itemId: String) : ViewModel() {

    val item = MutableStateFlow<ItemEntity?>(null)
    // T-028: различать «ещё не загружено» и «загружено, но вещи нет» — по этому
    // флагу UI решает показать EmptyState вместо молчаливой пустой колонки.
    val loaded = MutableStateFlow(false)
    val locationLabel = MutableStateFlow<String?>(null)
    val storageName = MutableStateFlow<String?>(null)
    val activeLoan = MutableStateFlow<LoanEntity?>(null)
    val similar = MutableStateFlow<List<ItemEntity>>(emptyList())
    // T-009: роль — наблюдаемая (ActiveRole), а не одноразовое чтение в init:
    // после смены профиля кнопки карточки перестраиваются сами.
    val role: StateFlow<Role> get() = ActiveRole.role

    class Factory(private val itemId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ItemDetailVm(itemId) as T
    }

    init {
        viewModelScope.launch {
            val it = Deps.items.byId(itemId)
            item.value = it
            loaded.value = true // T-028: с этого момента null в item означает «вещи нет», а не «ещё грузится»
            it?.location_id?.let { lid ->
                // T-041: ящик мягко удалён — ссылка «призрак», карта ящика не видна.
                val loc = Deps.locations.byId(lid)?.takeIf { l -> l.deleted_at == null }
                if (loc != null) {
                    locationLabel.value = loc.label.ifBlank { loc.name }.ifBlank { "Ящик" }
                    storageName.value = Deps.storages.byId(loc.storage_id)?.name
                }
            }
            // «Похожие вещи»: общие теги с текущей, самые близкие — первыми.
            if (it != null) {
                val myTags = TagsJson.toList(it.tags).map { t -> t.lowercase() }.toSet()
                val scored = Deps.items.all()
                    .filter { o -> o.id != itemId }
                    .map { o -> o to myTags.intersect(TagsJson.toList(o.tags).map { t -> t.lowercase() }.toSet()).size }
                    .filter { e -> e.second > 0 }
                    .sortedByDescending { e -> e.second }
                similar.value = scored.take(8).map { e -> e.first }
            }
        }
        viewModelScope.launch {
            activeLoan.value = Deps.loans.activeForEntity("item", itemId)
        }
    }

    fun lend(borrower: String, note: String, dueAt: Long?) {
        viewModelScope.launch { Deps.loans.lend("item", itemId, borrower, note, dueAt) }
    }

    fun returnActiveLoan() {
        val id = activeLoan.value?.id ?: return
        viewModelScope.launch {
            Deps.loans.returnLoan(id)
            activeLoan.value = null
        }
    }

    fun softDelete() {
        viewModelScope.launch { Deps.items.softDelete(itemId) }
    }

    // Undo (US-L21): возврат вещи после мягкого удаления.
    fun restore() {
        viewModelScope.launch { Deps.items.restore(itemId) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemDetailScreen(nav: NavController, itemId: String) {
    val vm: ItemDetailVm = viewModel(factory = ItemDetailVm.Factory(itemId))
    val item by vm.item.collectAsState()
    val loaded by vm.loaded.collectAsState()
    val locationLabel by vm.locationLabel.collectAsState()
    val storageName by vm.storageName.collectAsState()
    val similar by vm.similar.collectAsState()
    var showDelete by remember { mutableStateOf(false) }
    val role by vm.role.collectAsState()
    val loan by vm.activeLoan.collectAsState()
    var showLend by remember { mutableStateOf(false) }
    var showBasket by remember { mutableStateOf(false) }
    var tab by remember { mutableIntStateOf(0) }
    val ctx = LocalContext.current
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    // T-041: «на месте» только если ящик жив: карта живых ящиков экрана.
    val liveLocations = LocationMap()

    val i = item
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text(i?.name ?: "Вещь") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    if (Access.can(role, Access.EDIT)) {
                        IconButton(onClick = { nav.navigate("item-form/$itemId/0") }) {
                            Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                        }
                        IconButton(onClick = { showDelete = true }) {
                            Icon(Icons.Filled.Delete, contentDescription = "Удалить")
                        }
                    }
                }
            )
        },
        bottomBar = {
            if (i != null) {
                Column {
                    HorizontalDivider(color = Ozon.Card, thickness = 1.dp)
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .background(Ozon.Bg)
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                    ) {
                        Button(
                            onClick = { nav.navigate("label-studio/item/$itemId/0") },
                            modifier = Modifier
                                .weight(1f)
                                .height(52.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Ozon.Blue)
                        ) {
                            Icon(Icons.Filled.QrCodeScanner, contentDescription = null)
                            Spacer(Modifier.width(8.dp))
                            Text("Этикетка: QR / штрихкод", fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            if (i == null) {
                // T-028: «загружено, но вещи нет» — отдельное состояние: честное
                // объяснение вместо молчаливой пустой колонки. Пока идёт загрузка — пусто.
                if (loaded) {
                    EmptyState(
                        text = "Вещь не найдена или удалена",
                        actionLabel = "Назад",
                        onAction = { nav.popBackStack() }
                    )
                }
                return@Column
            }

            ItemPhoto(
                i.photo_path,
                Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(top = 8.dp)
            )
            // US-B4: «поиск в сети» — открыть фото в системном просмотрщике и
            // запустить там обратный поиск (Яндекс/Google Lens), найти характеристики и вернуться
            if (!i.photo_path.isNullOrBlank() && File(i.photo_path).exists()) {
                OutlinedButton(
                    onClick = {
                        runCatching { openImageSearch(ctx, File(i.photo_path)) }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Icon(Icons.Filled.Public, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Поиск в сети")
                }
                Text(
                    "Откроем фото в просмотрщике: оттуда можно запустить обратный поиск картинки (Яндекс, Google Lens) и занести найденные характеристики в карточку.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            // Статусы вещи: выдана, срок, место — цветные бейджи как наличие в Ozon
            val statuses = itemStatuses(i, hasLocation = LocationPlacement.hasPlace(i.location_id, liveLocations.keys), loan = loan)
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(top = 14.dp)
            ) {
                statuses.forEach { s ->
                    StatusBadge(s.label, s.color)
                }
            }

            Text(
                i.name,
                style = MaterialTheme.typography.titleLarge,
                color = Ozon.TextPrimary,
                modifier = Modifier.padding(top = 14.dp)
            )
            if (i.code.isNotBlank()) {
                Text(
                    i.code,
                    style = MaterialTheme.typography.headlineMedium,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold,
                    color = Ozon.Pink,
                    maxLines = 1,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            if (!i.ean.isNullOrBlank()) {
                Text(
                    "EAN ${i.ean}",
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily.Monospace,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            // Фото рыночного штрихкода (отдельное поле у вещи)
            i.barcode_photo_path?.takeIf { it.isNotBlank() && File(it).exists() }?.let { p ->
                ItemPhoto(
                    p,
                    Modifier
                        .width(96.dp)
                        .height(96.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .padding(top = 8.dp)
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Icon(
                    Icons.Filled.Place,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = if (locationLabel == null) Ozon.Pink else Ozon.TextSecondary
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    if (locationLabel != null) {
                        "Хранится: ${locationLabel}${storageName?.let { " · $it" } ?: ""}"
                    } else {
                        "Хранится: без места"
                    },
                    style = MaterialTheme.typography.bodyLarge,
                    color = if (locationLabel == null) Ozon.Pink else Ozon.TextSecondary
                )
            }

            val itemTags = TagsJson.toList(i.tags)
            if (itemTags.isNotEmpty()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(top = 12.dp)
                ) {
                    itemTags.forEach { t ->
                        FilterChip(
                            selected = false,
                            onClick = {},
                            label = { Text(t) },
                            modifier = Modifier.padding(end = 8.dp)
                        )
                    }
                }
            }

            // Табы «Описание» / «Характеристики» — как на странице товара
            val titleAttr = i.description.isNotBlank()
            val hasAttr = AttrJson.toMap(i.attributes).isNotEmpty()
            Spacer(Modifier.height(18.dp))
                TabRow(
                    selectedTabIndex = tab,
                    containerColor = Ozon.Bg,
                    contentColor = Ozon.Blue,
                    divider = { HorizontalDivider(color = Ozon.Card, thickness = 1.dp) },
                    indicator = { TabRowDefaults.SecondaryIndicator(color = Ozon.Blue) }
                ) {
                    listOf("Описание", "Характеристики").forEachIndexed { idx, label ->
                        Tab(
                            selected = tab == idx,
                            onClick = { tab = idx },
                            text = {
                                Text(
                                    label,
                                    color = if (tab == idx) Ozon.Blue else Ozon.TextSecondary,
                                    fontWeight = if (tab == idx) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
                Spacer(Modifier.height(12.dp))
                when (tab) {
                    0 -> {
                        if (titleAttr) {
                            Text(i.description, style = MaterialTheme.typography.bodyLarge, color = Ozon.TextPrimary)
                        } else {
                            Text(
                                "Описания нет",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Ozon.TextMuted
                            )
                        }
                    }
                    else -> {
                        if (hasAttr) {
                            Column(Modifier.fillMaxWidth()) {
                                AttrJson.toMap(i.attributes).forEach { (k, v) ->
                                    if (v.isNotBlank()) {
                                        Row(
                                            Modifier.fillMaxWidth().padding(vertical = 10.dp),
                                            verticalAlignment = Alignment.Top
                                        ) {
                                            Text(
                                                k,
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = Ozon.TextSecondary,
                                                modifier = Modifier.weight(0.55f)
                                            )
                                            Text(
                                                v,
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.Medium,
                                                color = Ozon.TextPrimary,
                                                textAlign = TextAlign.End,
                                                modifier = Modifier.weight(0.45f)
                                            )
                                        }
                                        HorizontalDivider(color = Ozon.Card)
                                    }
                                }
                            }
                        } else {
                            Text(
                                "Характеристик нет",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Ozon.TextMuted
                            )
                        }
                    }
                }

            if (similar.isNotEmpty()) {
                SectionTitle("Похожие вещи")
                Text(
                    "Найдено ${similar.size} вещей с такими же тегами",
                    style = MaterialTheme.typography.bodySmall,
                    color = Ozon.TextSecondary
                )
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    items(similar, key = { it.id }) { s ->
                        ItemCard(
                            s,
                            null,
                            { nav.navigate("item/${s.id}") },
                            status = itemStatus(s, hasLocation = LocationPlacement.hasPlace(s.location_id, liveLocations.keys)),
                            modifier = Modifier.width(160.dp)
                        )
                    }
                }
            }

            SectionTitle("Действия")
            Column(Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
                if (Access.can(role, Access.LEND)) {
                    val l = loan
                    if (l != null) {
                        val due = l.due_at
                        val overdue = due != null && due < System.currentTimeMillis()
                        Text(
                            "Выдано: ${l.borrower}${due?.let { " · возврат до ${formatDate(it)}" } ?: ""}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (overdue) Ozon.Pink else Ozon.TextSecondary,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        OutlinedButton(
                            onClick = { vm.returnActiveLoan() },
                            modifier = Modifier.fillMaxWidth()
                        ) { Text("Вернуть") }
                    } else {
                        Button(
                            onClick = { showLend = true },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = Ozon.Blue)
                        ) { Text("Выдать временно") }
                    }
                    Spacer(Modifier.height(8.dp))
                }
                Spacer(Modifier.height(4.dp))
                OutlinedButton(
                    onClick = { showBasket = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("В корзину извлечения")
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
                    scope.launch {
                        val name = i?.name ?: ""
                        vm.softDelete()
                        // US-L21: даём 5 секунд на «ОТМЕНИТЬ»; если не отменили — уходим.
                        val undone = snackbarHostState.undo("«$name» удалена") {
                            vm.restore()
                        }
                        if (!undone) nav.popBackStack()
                    }
                }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { showDelete = false }) { Text("Отмена") }
            }
        )
    }

    if (showLend) {
        LendDialog(
            title = "Выдать вещь",
            onDismiss = { showLend = false },
            onConfirm = { b, n, d ->
                showLend = false
                vm.lend(b, n, d)
            }
        )
    }

    if (showBasket) {
        AddToBasketDialog(
            onDismiss = { showBasket = false },
            onConfirm = { basketId, newName ->
                showBasket = false
                scope.launch {
                    when {
                        newName.isNotBlank() -> {
                            val b = Deps.baskets.create(newName)
                            Deps.baskets.addItem(b.id, itemId)
                        }
                        basketId != null -> Deps.baskets.addItem(basketId, itemId)
                    }
                }
            }
        )
    }
}

// US-B4: открыть фото вещи в системном просмотрщике (ACTION_VIEW + FileProvider),
// откуда пользователь запускает обратный поиск картинки.
private fun openImageSearch(ctx: Context, photo: File) {
    val uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", photo)
    val intent = Intent(Intent.ACTION_VIEW).apply {
        setDataAndType(uri, "image/*")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        addCategory(Intent.CATEGORY_DEFAULT)
    }
    ctx.startActivity(Intent.createChooser(intent, "Открыть картинку"))
}

// US-E1: «В корзину извлечения» — выбрать активную корзину или создать новую с именем.
@Composable
private fun AddToBasketDialog(
    onDismiss: () -> Unit,
    onConfirm: (basketId: String?, newName: String) -> Unit
) {
    val baskets by Deps.baskets.observeActive().collectAsState(initial = emptyList())
    var selectedId by remember { mutableStateOf<String?>(null) }
    var newName by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Добавить в корзину") },
        text = {
            Column(Modifier.fillMaxWidth()) {
                if (baskets.isEmpty()) {
                    Text(
                        "Активных корзин нет — создайте новую.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                } else {
                    baskets.forEach { b: BasketEntity ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedId = b.id
                                    newName = ""
                                }
                                .padding(vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            androidx.compose.material3.RadioButton(
                                selected = selectedId == b.id,
                                onClick = {
                                    selectedId = b.id
                                    newName = ""
                                }
                            )
                            Column(Modifier.weight(1f)) {
                                Text(b.name, style = MaterialTheme.typography.bodyLarge)
                                Text(
                                    "активная",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
                OutlinedTextField(
                    value = newName,
                    onValueChange = { newName = it; selectedId = null },
                    placeholder = { Text("… или новая корзина с названием") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = { onConfirm(selectedId, newName.trim()) },
                enabled = newName.isNotBlank() || selectedId != null
            ) { Text("Добавить") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}