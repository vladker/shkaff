package ru.vldkr.shkaff.features.dashboard

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.util.Expiry
import java.time.LocalDate
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemCard
import ru.vldkr.shkaff.ui.components.ItemRow
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.components.itemStatus
import ru.vldkr.shkaff.ui.theme.Ozon

class DashboardVm : ViewModel() {

    data class Ui(
        val itemsCount: Int = 0,
        val locationsCount: Int = 0,
        val storagesCount: Int = 0,
        val recent: List<ItemEntity> = emptyList(),
        val expiringSoon: List<ItemEntity> = emptyList(),
        val tagDist: List<Pair<String, Int>> = emptyList(),
        val activeLoans: Int = 0,
        val overdueLoans: Int = 0,
        val loansByItem: Map<String, LoanEntity> = emptyMap(),
        val canCreate: Boolean = true,
        val activeProfile: String? = null
    )

    val ui = MutableStateFlow(Ui())

    fun refresh() {
        viewModelScope.launch {
            val items = Deps.items.all()
            // US-I5: топ-5 тегов по числу вещей
            val tagMap = mutableMapOf<String, Int>()
            for (i in items) {
                for (t in TagsJson.toList(i.tags)) tagMap[t] = (tagMap[t] ?: 0) + 1
            }
            val tagDist = tagMap.entries.sortedByDescending { it.value }.take(5).map { it.key to it.value }
            val role = Role.parse(Deps.users.activeUser()?.role ?: "view")
            val now = System.currentTimeMillis()
            val loans = Deps.loans.observeActive().first()
            val itemLoans = loans.filter { it.entity_type == "item" }.associateBy { it.entity_id }
            ui.value = Ui(
                itemsCount = items.size,
                locationsCount = Deps.locations.count(),
                storagesCount = Deps.storages.count(),
                recent = items.take(8),
                expiringSoon = Deps.items.expiringSoon(Deps.expiryThresholdDays()),
                tagDist = tagDist,
                activeLoans = loans.size,
                overdueLoans = loans.count { it.due_at != null && it.due_at < now },
                loansByItem = itemLoans,
                canCreate = Access.can(role, Access.CREATE),
                activeProfile = Deps.users.activeUser()?.name
            )
        }
    }
}

@Composable
fun DashboardScreen(nav: NavController) {
    val vm: DashboardVm = viewModel()
    val ui by vm.ui.collectAsState()
    LaunchedEffect(Unit) { vm.refresh() }
    val locations = LocationMap()

    Scaffold(
        floatingActionButton = {
            if (ui.canCreate) {
                FloatingActionButton(
                    onClick = { nav.navigate("item-form/0/0") },
                    containerColor = Ozon.Blue,
                    contentColor = Ozon.TextPrimary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Новая вещь")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 96.dp)
        ) {
            item {
                DashboardHeader(ui.activeProfile, onScan = { nav.navigate("scan") }, onSettings = { nav.navigate("settings") })
            }
            item {
                OzonSearch(nav)
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.padding(top = 4.dp)
                ) {
                    StatCard(ui.itemsCount, "вещей", Modifier.weight(1f)) { nav.navigate("items/0") }
                    StatCard(ui.locationsCount, "ящиков", Modifier.weight(1f)) { nav.navigate("storages") }
                    StatCard(ui.storagesCount, "хранилищ", Modifier.weight(1f)) { nav.navigate("storages") }
                }
            }
            if (ui.activeLoans > 0) {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { nav.navigate("loans") }
                            .padding(top = 10.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
                        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                    ) {
                        Row(
                            Modifier.padding(start = 16.dp, top = 14.dp, bottom = 14.dp, end = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                if (ui.overdueLoans > 0)
                                    "Выдано: ${ui.activeLoans} · просрочено: ${ui.overdueLoans}"
                                else
                                    "Выдано временно: ${ui.activeLoans}",
                                style = MaterialTheme.typography.titleSmall,
                                color = if (ui.overdueLoans > 0) Ozon.Pink else Ozon.TextPrimary,
                                modifier = Modifier.weight(1f)
                            )
                            Text("Подробнее", style = MaterialTheme.typography.labelLarge, color = Ozon.Blue,
                                modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
            if (ui.canCreate) {
                item { SectionTitle("Быстрые действия") }
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        QuickAction("Добавить вещь", Icons.Filled.Add, Modifier.weight(1f)) { nav.navigate("item-form/0/0") }
                        QuickAction("Хранилище", Icons.Filled.Storage, Modifier.weight(1f)) { nav.navigate("storage-form/0") }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        QuickAction("Ящик", Icons.Filled.Inventory2, Modifier.weight(1f)) { nav.navigate("storages") }
                        QuickAction("Стеки", Icons.Filled.Layers, Modifier.weight(1f)) { nav.navigate("stacks") }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        QuickAction("Корзина извлечения", Icons.Filled.ShoppingBasket, Modifier.weight(1f)) { nav.navigate("basket") }
                        QuickAction("Серия вещей", Icons.Filled.PlaylistAdd, Modifier.weight(1f)) { nav.navigate("batch") }
                    }
                }
            }
            if (ui.tagDist.isNotEmpty()) {
                item { SectionTitle("Категории") }
                item {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(bottom = 4.dp),
                        horizontalArrangement = Arrangement.spacedBy(14.dp)
                    ) {
                        ui.tagDist.forEachIndexed { idx, (t, c) ->
                            CategoryTile(
                                label = t,
                                count = c,
                                icon = CATEGORY_ICONS[idx % CATEGORY_ICONS.size],
                                tint = CATEGORY_COLORS[idx % CATEGORY_COLORS.size],
                                onClick = { nav.navigate("items/${Uri.encode(t)}") }
                            )
                        }
                    }
                }
            }
            if (ui.expiringSoon.isNotEmpty()) {
                item { SectionTitle("Скоро истечёт") }
                items(ui.expiringSoon, key = { "exp-${it.id}" }) { it ->
                    val date = Expiry.parse(it.expiry_date)
                    val today = LocalDate.now()
                    val days = date?.let { Expiry.daysUntil(it, today) } ?: 0
                    ItemRow(
                        it,
                        locations[it.location_id]?.displayLabel(),
                        { nav.navigate("item/${it.id}") },
                        expiryText = Expiry.label(date, today),
                        expiryColor = if (days < 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                    )
                }
            }
            item { SectionTitle("Недавно добавленные") }
            if (ui.recent.isEmpty()) {
                item { EmptyState("Пока нет вещей.\nДобавьте первую — с номером, фото и ящиком хранения.") }
            } else {
                item {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.padding(bottom = 8.dp)
                    ) {
                        items(ui.recent, key = { it.id }) { r ->
                            ItemCard(
                                r,
                                locations[r.location_id]?.displayLabel(),
                                { nav.navigate("item/${r.id}") },
                                status = itemStatus(r, hasLocation = r.location_id != null, loan = ui.loansByItem[r.id]),
                                modifier = Modifier.width(168.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

// Иконки и цвета категорий из тегов: циклично, как категории в Ozon.
private val CATEGORY_ICONS = listOf(
    Icons.Filled.Inventory2,
    Icons.Filled.Home,
    Icons.Filled.Storage,
    Icons.Filled.Layers,
    Icons.Filled.ShoppingBasket,
    Icons.Filled.Settings
)

private val CATEGORY_COLORS = listOf(
    Ozon.Blue,
    Ozon.Purple,
    Ozon.Teal,
    Ozon.Orange,
    Ozon.Green,
    Ozon.Pink
)

// Круглая плитка категории: цветной круг с иконкой + подпись и счётчик.
@Composable
private fun CategoryTile(label: String, count: Int, icon: ImageVector, tint: Color, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Box(
            Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(tint.copy(alpha = 0.18f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                icon,
                contentDescription = label,
                modifier = Modifier.size(26.dp),
                tint = tint
            )
        }
        Text(
            label,
            style = MaterialTheme.typography.labelMedium,
            color = Ozon.TextPrimary,
            maxLines = 1,
            modifier = Modifier
                .width(72.dp)
                .padding(top = 6.dp),
            textAlign = TextAlign.Center
        )
        Text(
            "$count",
            style = MaterialTheme.typography.labelSmall,
            color = Ozon.TextSecondary
        )
    }
}

@Composable
private fun DashboardHeader(profile: String?, onScan: () -> Unit, onSettings: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, bottom = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(Modifier.weight(1f)) {
            Text("Шкаф", style = MaterialTheme.typography.headlineMedium, color = Ozon.TextPrimary)
            if (profile != null) {
                Text(
                    "Профиль: $profile",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Ozon.TextSecondary
                )
            }
        }
        IconButton(onClick = onScan) {
            Icon(Icons.Filled.QrCodeScanner, contentDescription = "Сканер", tint = Ozon.Blue)
        }
        IconButton(onClick = onSettings) {
            Icon(Icons.Filled.Settings, contentDescription = "Настройки", tint = Ozon.TextSecondary)
        }
    }
}

// Поле поиска как в Ozon: тёмная «пилюля», синяя лупа, справа — иконки сканера и камеры.
// Поиск ведёт на каталог вещей, сканер — на экран сканирования.
@Composable
private fun OzonSearch(nav: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Ozon.Search)
            .clickable { nav.navigate("items/0") }
            .padding(horizontal = 14.dp, vertical = 13.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.Search,
            contentDescription = null,
            tint = Ozon.Blue
        )
        Spacer(Modifier.width(10.dp))
        Text(
            "Искать: вещь, код, ящик…",
            style = MaterialTheme.typography.bodyLarge,
            color = Ozon.TextSecondary,
            modifier = Modifier.weight(1f),
            maxLines = 1
        )
        IconButton(onClick = { nav.navigate("scan") }) {
            Icon(
                Icons.Filled.QrCodeScanner,
                contentDescription = "Сканировать код",
                tint = Ozon.TextSecondary
            )
        }
        IconButton(onClick = { nav.navigate("item-form/0/0") }) {
            Icon(
                Icons.Filled.PhotoCamera,
                contentDescription = "Сфотографировать",
                tint = Ozon.TextSecondary
            )
        }
    }
}

@Composable
private fun StatCard(value: Int, label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$value", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = Ozon.TextPrimary)
            Text(
                label,
                style = MaterialTheme.typography.bodySmall,
                color = Ozon.TextSecondary
            )
        }
    }
}

// Плитка быстрых действий в стиле Ozon: иконка в тёмно-синем квадрате + белая подпись.
@Composable
private fun QuickAction(label: String, icon: ImageVector, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Box(
                Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    icon,
                    contentDescription = null,
                    modifier = Modifier.size(22.dp),
                    tint = Ozon.Blue
                )
            }
            Text(
                label,
                style = MaterialTheme.typography.titleSmall,
                color = Ozon.TextPrimary,
                maxLines = 1,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}