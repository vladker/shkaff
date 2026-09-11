package ru.vldkr.shkaff.features.dashboard

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.PlaylistAdd
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingBasket
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
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
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.util.Expiry
import java.time.LocalDate
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemRow
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.displayLabel

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
            ui.value = Ui(
                itemsCount = items.size,
                locationsCount = Deps.locations.count(),
                storagesCount = Deps.storages.count(),
                recent = items.take(5),
                expiringSoon = Deps.items.expiringSoon(Deps.expiryThresholdDays()),
                tagDist = tagDist,
                activeLoans = loans.size,
                overdueLoans = loans.count { it.due_at != null && it.due_at < now },
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
                FloatingActionButton(onClick = { nav.navigate("item-form/0/0") }) {
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
                    StatCard(ui.itemsCount, "вещей", Modifier.weight(1f)) { nav.navigate("items") }
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
                            .padding(top = 10.dp)
                    ) {
                        Row(
                            Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                if (ui.overdueLoans > 0)
                                    "Выдано: ${ui.activeLoans} · просрочено: ${ui.overdueLoans}"
                                else
                                    "Выдано временно: ${ui.activeLoans}",
                                style = MaterialTheme.typography.titleSmall,
                                color = if (ui.overdueLoans > 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface,
                                modifier = Modifier.weight(1f)
                            )
                            Text("Подробнее", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
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
                item { SectionTitle("Теги") }
                item {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState())
                            .padding(bottom = 4.dp)
                    ) {
                        ui.tagDist.forEach { (t, c) ->
                            FilterChip(
                                selected = false,
                                onClick = {},
                                label = { Text("$t · $c") },
                                modifier = Modifier.padding(end = 8.dp)
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
            item { SectionTitle("Недавно изменённые") }
            if (ui.recent.isEmpty()) {
                item { EmptyState("Пока нет вещей.\nДобавьте первую — с номером, фото и ящиком хранения.") }
            } else {
                items(ui.recent, key = { it.id }) { it ->
                    ItemRow(it, locations[it.location_id]?.displayLabel(), { nav.navigate("item/${it.id}") })
                }
            }
        }
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
            Text("Шкаф", style = MaterialTheme.typography.headlineMedium)
            if (profile != null) {
                Text(
                    "Профиль: $profile",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        IconButton(onClick = onScan) {
            Icon(Icons.Filled.QrCodeScanner, contentDescription = "Сканер", tint = MaterialTheme.colorScheme.primary)
        }
        IconButton(onClick = onSettings) {
            Icon(Icons.Filled.Settings, contentDescription = "Настройки")
        }
    }
}

// Поле поиска в стиле Ozon: белая «пилюля» с синим увеличительным стеклом — ведёт на каталог вещей.
@Composable
private fun OzonSearch(nav: NavController) {
    Row(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(MaterialTheme.colorScheme.surface)
            .border(1.dp, MaterialTheme.colorScheme.outlineVariant, RoundedCornerShape(14.dp))
            .clickable { nav.navigate("items") }
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Filled.Search,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.width(10.dp))
        Text(
            "Найти вещь, код или ящик…",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun StatCard(value: Int, label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$value", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(
                label,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

// Плитка быстрых действий: синяя иконка в светлом квадрате + подпись, как «категории» в Ozon.
@Composable
private fun QuickAction(label: String, icon: ImageVector, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
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
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                label,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}