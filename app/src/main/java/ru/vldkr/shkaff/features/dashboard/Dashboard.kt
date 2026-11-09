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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Label
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.material3.pulltorefresh.pullToRefreshIndicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.capacity.BRIM_RESERVE_RATIO
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.onboarding.OnbStep
import ru.vldkr.shkaff.domain.onboarding.Onboarding
import ru.vldkr.shkaff.util.Expiry
import java.time.LocalDate
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemCard
import ru.vldkr.shkaff.ui.components.ItemRow
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.ListSkeleton
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.components.itemStatus
import ru.vldkr.shkaff.ui.theme.Ozon

// Стандартная переносная коробка: 60×40×40 см = 96 л.
// Используется в метриках «объём, кор.» и «кор. к закупке».
private const val BOX_LITERS = 96.0

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
        val activeProfile: String? = null,
        // ── Метрики «Сводка» ──
        val draftsCount: Int = 0,
        val noLocationCount: Int = 0,
        val avitoValue: Double = 0.0,
        val totalWeightKg: Double = 0.0,
        val totalVolumeLiters: Double = 0.0,
        val boxesCount: Int = 0,
        val repairCount: Int = 0,
        val expiredCount: Int = 0,
        val freeCapacityLiters: Double = 0.0,
        val hasCapacity: Boolean = false,
        val boxesToBuy: Int = 0,
        // Чек-лист первого запуска (PLAN_ONBOARDING П0.1).
        val onbSteps: List<OnbStep> = emptyList(),
        val onbDismissed: Boolean = false
    )

    val ui = MutableStateFlow(Ui())
    // US-O8: true на время первой загрузки и pull-to-refresh — показываем skeleton.
    val loading = MutableStateFlow(true)

    fun refresh() {
        viewModelScope.launch {
            loading.value = true
            try {
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
            // Порядок вещей на «Главной» — по степени «требует внимания»:
            // 1) без места; 2) без кода/этикетки; 3) без важных (обязательных) атрибутов;
            // 4) одолжены или срок истекает; 5) остальные. Внутри группы — свежее первыми.
            val today = LocalDate.now()
            val threshold = Deps.expiryThresholdDays()
            // «Важные» атрибуты вещи — обязательные из словаря (scope=item, required).
            val requiredAttrKeys = Deps.attributes.forScope("item")
                .filter { it.required && it.deleted_at == null }
                .map { it.key }
                .toSet()
            fun ItemEntity.missingRequiredAttrs(): Boolean {
                if (requiredAttrKeys.isEmpty()) return false
                val attrs = AttrJson.toMap(attributes)
                return requiredAttrKeys.any { k -> attrs[k].isNullOrBlank() }
            }
            fun ItemEntity.needsAttention(): Boolean {
                if (itemLoans[id] != null) return true
                val exp = expiry_date?.let { Expiry.parse(it) } ?: return false
                return Expiry.daysUntil(exp, today) <= threshold
            }
            fun attentionRank(i: ItemEntity): Int = when {
                i.location_id == null -> 0
                i.code.isBlank() -> 1
                i.missingRequiredAttrs() -> 2
                i.needsAttention() -> 3
                else -> 4
            }
            val orderedItems = items.sortedWith(compareBy({ attentionRank(it) }, { -it.updated_at }))
            val noLocation = orderedItems.filter { it.location_id == null }

            // ── Метрики «Сводка» ──
            val draftsCount = Deps.drafts.count()
            val noLocationCount = noLocation.size
            // Состояние «требует ремонта» — фиксированный набор значений атрибута condition.
            val repairStates = setOf("Б/у, с дефектом", "На запчасти")
            var avitoValue = 0.0
            var repairCount = 0
            var expiredCount = 0
            var totalVolumeLiters = 0.0
            var totalWeightKg = 0.0
            for (i in items) {
                totalVolumeLiters += i.volume_liters
                totalWeightKg += i.weight_kg
                val attrs = AttrJson.toMap(i.attributes)
                avitoValue += attrs["avito_price"]?.toDoubleOrNull() ?: 0.0
                if (attrs["condition"] in repairStates) repairCount++
                val exp = i.expiry_date?.let { Expiry.parse(it) }
                if (exp != null && Expiry.daysUntil(exp, today) < 0) expiredCount++
            }
            val boxesCount = if (totalVolumeLiters > 0)
                kotlin.math.ceil(totalVolumeLiters / BOX_LITERS).toInt() else 0

            // Свободное место: сумма остатка объёма «внутренних» ящиков с ёмкостью.
            // Ящик внутри ящика не учитывается дважды: считаем только самое внутреннее
            // звено, где задана ёмкость, — его лимит уже покрывает вложенные.
            val locations = Deps.locations.observeAll().first()
            val locById = locations.associateBy { it.id }
            fun effLimit(l: LocationEntity): Double? = l.capacity_volume?.let {
                if (it <= 0) null else if (l.dont_fill_to_brim) it * BRIM_RESERVE_RATIO else it
            }
            fun isCountable(l: LocationEntity): Boolean {
                if (effLimit(l) == null) return false
                var p = l.parent_id
                while (p != null) {
                    val a = locById[p] ?: break
                    if (effLimit(a) != null) return false
                    p = a.parent_id
                }
                return true
            }
            val countable = locations.filter { isCountable(it) }
            val countableIds = countable.mapTo(mutableSetOf()) { it.id }
            fun ownerBox(locationId: String?): String? {
                var p = locationId
                while (p != null) {
                    if (p in countableIds) return p
                    p = locById[p]?.parent_id
                }
                return null
            }
            val usedInCountable = mutableMapOf<String, Double>()
            for (i in items) {
                val owner = ownerBox(i.location_id) ?: continue
                usedInCountable[owner] = (usedInCountable[owner] ?: 0.0) + i.volume_liters
            }
            var freeCapacityLiters = 0.0
            var totalCapacityLiters = 0.0
            for (l in countable) {
                val lim = effLimit(l) ?: continue
                totalCapacityLiters += lim
                freeCapacityLiters += (lim - (usedInCountable[l.id] ?: 0.0)).coerceAtLeast(0.0)
            }
            val hasCapacity = countable.isNotEmpty()
            // К закупке: дефицит объёма сверх суммарной ёмкости ящиков, в коробках.
            val deficit = (totalVolumeLiters - totalCapacityLiters).coerceAtLeast(0.0)
            val boxesToBuy = if (deficit > 0) kotlin.math.ceil(deficit / BOX_LITERS).toInt() else 0

            ui.value = Ui(
                itemsCount = items.size,
                locationsCount = Deps.locations.count(),
                storagesCount = Deps.storages.count(),
                recent = orderedItems.take(8),
                expiringSoon = Deps.items.expiringSoon(Deps.expiryThresholdDays()),
                tagDist = tagDist,
                activeLoans = loans.size,
                overdueLoans = loans.count { it.due_at != null && it.due_at < now },
                loansByItem = itemLoans,
                canCreate = Access.can(role, Access.CREATE),
                activeProfile = Deps.users.activeUser()?.name,
                draftsCount = draftsCount,
                noLocationCount = noLocationCount,
                avitoValue = avitoValue,
                totalWeightKg = totalWeightKg,
                totalVolumeLiters = totalVolumeLiters,
                boxesCount = boxesCount,
                repairCount = repairCount,
                expiredCount = expiredCount,
                freeCapacityLiters = freeCapacityLiters,
                hasCapacity = hasCapacity,
                boxesToBuy = boxesToBuy,
                onbSteps = Onboarding.steps(Deps.storages.count(), Deps.locations.count(), items.size),
                onbDismissed = Deps.onboardingDismissed()
            )
            } finally {
                loading.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(nav: NavController) {
    val vm: DashboardVm = viewModel()
    val ui by vm.ui.collectAsState()
    val loading by vm.loading.collectAsState()
    val scope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    val pullState = rememberPullToRefreshState()
    // US-O8: skeleton только на первой загрузке без данных (не при pull-to-refresh).
    val showSkeleton = loading && ui.itemsCount == 0 && ui.recent.isEmpty()
    LaunchedEffect(Unit) { vm.refresh() }
    val locations = LocationMap()
    var showAddMenu by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            if (ui.canCreate) {
                Box {
                    FloatingActionButton(
                        onClick = { showAddMenu = true },
                        containerColor = Ozon.Blue,
                        contentColor = Ozon.TextPrimary
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = "Добавить")
                    }
                    DropdownMenu(
                        expanded = showAddMenu,
                        onDismissRequest = { showAddMenu = false }
                    ) {
                        // П1.2: scan-first — «Сканировать вещь» первым пунктом FAB-меню.
                        DropdownMenuItem(
                            text = { Text("Сканировать вещь") },
                            leadingIcon = { Icon(Icons.Filled.QrCodeScanner, contentDescription = null) },
                            onClick = {
                                showAddMenu = false
                                nav.navigate("scan")
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Добавить вещь") },
                            leadingIcon = { Icon(Icons.Filled.Inventory2, contentDescription = null) },
                            onClick = {
                                showAddMenu = false
                                nav.navigate("item-wizard")
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Добавить хранилище") },
                            leadingIcon = { Icon(Icons.Filled.Storage, contentDescription = null) },
                            onClick = {
                                showAddMenu = false
                                nav.navigate("storage-form/0")
                            }
                        )
                    }
                }
            }
        }
    ) { padding ->
        if (showSkeleton) {
            Column(
                Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                ListSkeleton(rows = 5)
            }
        } else {
            Box(Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier
                        .padding(padding)
                        .fillMaxSize()
                        .pullToRefresh(
                            enabled = true,
                            state = pullState,
                            isRefreshing = refreshing,
                            onRefresh = {
                                scope.launch {
                                    refreshing = true
                                    vm.refresh()
                                    refreshing = false
                                }
                            }
                        )
                        .pullToRefreshIndicator(
                            state = pullState,
                            isRefreshing = refreshing
                        ),
                    contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 96.dp)
                ) {
            item {
                DashboardHeader(
                    ui.activeProfile,
                    onScan = { nav.navigate("scan") },
                    onAgent = { nav.navigate("agent") },
                    onSettings = { nav.navigate("settings") }
                )
            }
            item {
                OzonSearch(nav)
            }
            // Чек-лист «Начните работать»: гасится по мере появления реальных объектов (П0.1).
            if (Onboarding.showChecklist(ui.onbSteps, ui.onbDismissed)) {
                item {
                    OnboardingCard(
                        steps = ui.onbSteps,
                        onStep = { nav.navigate(it.route) },
                        onDismiss = {
                            Deps.setOnboardingDismissed(true)
                            vm.refresh()
                        }
                    )
                }
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
            item {
                SectionTitle("Сводка")
            }
            item {
                val toItems: () -> Unit = { nav.navigate("items/0") }
                val toStorages: () -> Unit = { nav.navigate("storages") }
                SummaryGrid(
                    listOf(
                        SumMetric(ui.draftsCount.toString(), "черновиков", toItems),
                        SumMetric(ui.noLocationCount.toString(), "без ящика", toItems),
                        SumMetric(formatMoney(ui.avitoValue), "стоимость Авито", toItems),
                        SumMetric(formatKg(ui.totalWeightKg), "масса", toItems),
                        SumMetric(ui.boxesCount.toString(), "объём, кор.", toItems),
                        SumMetric(ui.repairCount.toString(), "к ремонту", toItems),
                        SumMetric(ui.expiredCount.toString(), "просрочено", toItems),
                        SumMetric(ui.freeCapacityLiters.roundToInt().toString(), "свободно, л", toStorages),
                        SumMetric(ui.boxesToBuy.toString(), "кор. к закупке", toStorages)
                    )
                )
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
                // П1.2: «Сканировать вещь» — сразу рядом с «Добавить вещь»; сетка плиток 2×4.
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        QuickAction("Добавить вещь", Icons.Filled.Add, Modifier.weight(1f)) { nav.navigate("item-wizard") }
                        QuickAction("Сканировать вещь", Icons.Filled.QrCodeScanner, Modifier.weight(1f)) { nav.navigate("scan") }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        QuickAction("Хранилище", Icons.Filled.Storage, Modifier.weight(1f)) { nav.navigate("storage-form/0") }
                        QuickAction("Ящик", Icons.Filled.Inventory2, Modifier.weight(1f)) { nav.navigate("storages") }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        QuickAction("Стеки", Icons.Filled.Layers, Modifier.weight(1f)) { nav.navigate("stacks") }
                        QuickAction("Корзина извлечения", Icons.Filled.ShoppingBasket, Modifier.weight(1f)) { nav.navigate("basket") }
                    }
                }
                item {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp),
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        QuickAction("Серия вещей", Icons.Filled.PlaylistAdd, Modifier.weight(1f)) { nav.navigate("batch") }
                        QuickAction("Этикетки", Icons.Filled.Label, Modifier.weight(1f)) { nav.navigate("labels/0/0") }
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
            item { SectionTitle("Вещи") }
            if (ui.recent.isEmpty()) {
                item {
                    EmptyState(
                        "Пока нет вещей.\nДобавьте первую — с номером, фото и ящиком хранения.",
                        actionLabel = if (ui.canCreate) "Добавить вещь" else null,
                        onAction = if (ui.canCreate) { { nav.navigate("item-wizard") } } else null
                    )
                }
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
    }
}

// Карточка-чеклист первого запуска (PLAN_ONBOARDING П0.1): прогресс X/3, шаги-переходы
// в формы, авто-погашение по числу объектов в БД.
@Composable
private fun OnboardingCard(steps: List<OnbStep>, onStep: (OnbStep) -> Unit, onDismiss: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Начните работать",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Ozon.TextPrimary,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    Onboarding.progress(steps),
                    style = MaterialTheme.typography.labelLarge,
                    color = Ozon.Blue
                )
            }
            steps.forEach { s ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onStep(s) }
                        .padding(vertical = 10.dp)
                ) {
                    Icon(
                        if (s.done) Icons.Filled.Check else Icons.Filled.ChevronRight,
                        contentDescription = null,
                        tint = if (s.done) Ozon.Green else Ozon.Blue,
                        modifier = Modifier.size(22.dp)
                    )
                    Spacer(Modifier.width(12.dp))
                    Column(Modifier.weight(1f)) {
                        Text(
                            s.title,
                            style = MaterialTheme.typography.bodyLarge,
                            color = if (s.done) Ozon.TextSecondary else Ozon.TextPrimary
                        )
                        if (!s.done) {
                            Text(
                                s.hint,
                                style = MaterialTheme.typography.bodySmall,
                                color = Ozon.TextSecondary,
                                maxLines = 2
                            )
                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = onDismiss) {
                    Text("Больше не показывать", color = Ozon.TextSecondary)
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
private fun DashboardHeader(profile: String?, onScan: () -> Unit, onAgent: () -> Unit, onSettings: () -> Unit) {
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
        IconButton(onClick = onAgent) {
            Icon(Icons.Filled.Chat, contentDescription = "LLM-агент", tint = Ozon.Blue)
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
        IconButton(onClick = { nav.navigate("item-wizard") }) {
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

// ── Секция «Сводка»: сетка компактных метрик ──

private data class SumMetric(val value: String, val label: String, val onClick: () -> Unit)

// Две метрики в ряд; последняя (нечётная) занимает всю ширину.
@Composable
private fun SummaryGrid(metrics: List<SumMetric>) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        metrics.chunked(2).forEach { row ->
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                row.forEach { m ->
                    SumCard(m, Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun SumCard(m: SumMetric, modifier: Modifier = Modifier) {
    Card(
        onClick = m.onClick,
        modifier = modifier,
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                m.value,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Ozon.TextPrimary,
                maxLines = 1
            )
            Text(
                m.label,
                style = MaterialTheme.typography.bodySmall,
                color = Ozon.TextSecondary,
                maxLines = 1
            )
        }
    }
}

// Короткое форматирование для метрик: деньги и масса без дробного хвоста, если велико.
private fun formatMoney(v: Double): String =
    if (v <= 0) "0 ₽" else "${v.roundToLong()} ₽"

private fun formatKg(v: Double): String =
    if (v <= 0) "0 кг" else if (v < 10) "%.1f кг".format(v) else "${v.roundToLong()} кг"