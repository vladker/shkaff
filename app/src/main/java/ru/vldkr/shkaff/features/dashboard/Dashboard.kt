package ru.vldkr.shkaff.features.dashboard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(nav: NavController) {
    val vm: DashboardVm = viewModel()
    val ui by vm.ui.collectAsState()
    LaunchedEffect(Unit) { vm.refresh() }
    val locations = LocationMap()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Шкаф")
                        ui.activeProfile?.let {
                            Text(
                                "Профиль: $it",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = { nav.navigate("scan") }) {
                        Icon(Icons.Filled.QrCodeScanner, contentDescription = "Сканер")
                    }
                    IconButton(onClick = { nav.navigate("settings") }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Настройки")
                    }
                }
            )
        },
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
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(bottom = 96.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    StatCard(ui.itemsCount, "Вещи", Modifier.weight(1f)) { nav.navigate("items") }
                    StatCard(ui.locationsCount, "Ящики", Modifier.weight(1f)) { nav.navigate("storages") }
                    StatCard(ui.storagesCount, "Хранилища", Modifier.weight(1f)) { nav.navigate("storages") }
                }
            }
            if (ui.activeLoans > 0) {
                item {
                    Card(
                        Modifier
                            .fillMaxWidth()
                            .clickable { nav.navigate("loans") }
                            .padding(bottom = 8.dp)
                    ) {
                        Column(Modifier.padding(14.dp)) {
                            Text(
                                if (ui.overdueLoans > 0)
                                    "Выдано: ${ui.activeLoans} · просрочено: ${ui.overdueLoans}"
                                else
                                    "Выдано временно: ${ui.activeLoans}",
                                style = MaterialTheme.typography.titleMedium,
                                color = if (ui.overdueLoans > 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
            if (ui.canCreate) {
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedButton(onClick = { nav.navigate("storage-form/0") }, modifier = Modifier.weight(1f)) {
                            Icon(Icons.Filled.Storage, contentDescription = null)
                            Spacer(Modifier.width(6.dp))
                            Text("Хранилище")
                        }
                        OutlinedButton(onClick = { nav.navigate("storages") }, modifier = Modifier.weight(1f)) {
                            Text("Новый ящик")
                        }
                    }
                }
                item {
                    OutlinedButton(
                        onClick = { nav.navigate("batch") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                    ) {
                        Text("Серия однотипных вещей (массовый ввод)")
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
private fun StatCard(value: Int, label: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Card(modifier = modifier) {
        Column(
            Modifier
                .clickable { onClick() }
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("$value", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
