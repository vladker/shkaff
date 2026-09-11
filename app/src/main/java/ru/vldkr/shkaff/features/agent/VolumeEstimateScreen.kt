package ru.vldkr.shkaff.features.agent

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage
import ru.vldkr.shkaff.domain.agent.FitReport
import ru.vldkr.shkaff.domain.agent.VolumeEstimate
import ru.vldkr.shkaff.domain.agent.VolumeItemLine
import ru.vldkr.shkaff.domain.agent.VolumeProposal
import ru.vldkr.shkaff.ui.components.displayLabel

class VolumeVm : ViewModel() {

    data class FitRow(val container: String, val text: String, val over: Boolean)

    sealed class Ui {
        data class Select(val items: List<ItemEntity>, val selected: Set<String>) : Ui()
        data class Asking(val count: Int) : Ui()
        data class Proposals(val proposals: List<VolumeProposal>, val checked: Set<String>) : Ui()
        data class Done(val applied: Int, val fit: List<FitRow>) : Ui()
    }

    val ui = MutableStateFlow<Ui>(Ui.Select(emptyList(), emptySet()))
    val busy = MutableStateFlow(false)
    val error = MutableStateFlow<String?>(null)

    private var allItems: List<ItemEntity> = emptyList()

    fun init() {
        if (allItems.isNotEmpty()) return
        viewModelScope.launch {
            allItems = Deps.items.all().sortedBy { it.name.lowercase() }
            // По умолчанию — вещи, у которых объём ещё не задан.
            val noVolume = allItems.filter { it.volume_liters <= 0 && it.weight_kg <= 0 }
                .map { it.id }.toSet()
            ui.value = Ui.Select(allItems, noVolume)
        }
    }

    fun select(ids: Set<String>) {
        (ui.value as? Ui.Select)?.let { ui.value = it.copy(selected = ids) }
    }

    fun estimate() {
        val s = ui.value as? Ui.Select ?: return
        if (busy.value) return
        val lines = allItems.filter { it.id in s.selected }.map { toLine(it) }
        if (lines.isEmpty()) return
        error.value = null
        ui.value = Ui.Asking(lines.size)
        viewModelScope.launch {
            try {
                val settings = Deps.agentSettings()
                if (settings.model.isBlank()) {
                    throw IllegalStateException("Агент не настроен: задайте модель в агенте (шестерёнка).")
                }
                val reply = ChatClient.complete(
                    settings = settings,
                    messages = listOf(ChatMessage("user", VolumeEstimate.buildPrompt(lines)))
                )
                val proposals = VolumeEstimate.parse(reply, allItems.associate { it.id to it.name })
                if (proposals.isEmpty()) {
                    throw IllegalStateException("Не удалось разобрать ответ модели. Попробуйте ещё раз.")
                }
                ui.value = Ui.Proposals(proposals, proposals.map { it.itemId }.toSet())
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка запроса к модели"
                ui.value = s
            } finally {
                busy.value = false
            }
        }
    }

    fun toggleProposal(id: String) {
        val p = ui.value as? Ui.Proposals ?: return
        val next = p.checked.toMutableSet().apply { if (id in this) remove(id) else add(id) }
        ui.value = p.copy(checked = next)
    }

    fun apply() {
        val p = ui.value as? Ui.Proposals ?: return
        if (busy.value) return
        val toApply = p.proposals.filter { it.itemId in p.checked }
        if (toApply.isEmpty()) return
        error.value = null
        busy.value = true
        viewModelScope.launch {
            try {
                val byItem = allItems.associateBy { it.id }
                val locIds = linkedSetOf<String>()
                var applied = 0
                for (prop in toApply) {
                    if (Deps.items.applyVolume(prop.itemId, prop.volumeLiters, prop.weightKg)) {
                        applied++
                        byItem[prop.itemId]?.location_id?.let { locIds.add(it) }
                    }
                }
                // Fit-отчёт: как изменилась заполненность ящиков затронутых вещей (US-C3).
                val fit = locIds.map { lid ->
                    val loc = Deps.locations.byId(lid)
                    val u = Deps.locations.usage(lid)
                    FitRow(loc?.displayLabel() ?: "ящик", FitReport.fitText(u), u.overLimit())
                }
                ui.value = Ui.Done(applied, fit)
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка записи"
            } finally {
                busy.value = false
            }
        }
    }

    fun backToSelect() {
        val items = allItems
        if (items.isEmpty()) {
            ui.value = Ui.Select(emptyList(), emptySet())
        } else {
            val noVolume = items.filter { it.volume_liters <= 0 && it.weight_kg <= 0 }.map { it.id }.toSet()
            ui.value = Ui.Select(items, noVolume)
        }
    }

    private fun toLine(it: ItemEntity): VolumeItemLine {
        val attrs = AttrJson.toMap(it.attributes)
        return VolumeItemLine(
            id = it.id,
            name = it.name,
            code = it.code,
            category = attrs["category"].orEmpty(),
            size = attrs["size"].orEmpty(),
            description = it.description
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VolumeEstimateScreen(nav: NavController) {
    val vm: VolumeVm = viewModel()
    val ui by vm.ui.collectAsState()
    val busy by vm.busy.collectAsState()
    val error by vm.error.collectAsState()
    LaunchedEffect(Unit) { vm.init() }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Оценка объёмов") },
                navigationIcon = {
                    IconButton(onClick = {
                        if (ui is VolumeVm.Ui.Done || ui is VolumeVm.Ui.Asking) nav.popBackStack()
                        else when (ui) {
                            is VolumeVm.Ui.Proposals -> vm.backToSelect()
                            is VolumeVm.Ui.Select -> nav.popBackStack()
                            else -> {}
                        }
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (val s = ui) {
                is VolumeVm.Ui.Select -> SelectStep(vm, s, busy)
                is VolumeVm.Ui.Asking -> AskingStep(s.count)
                is VolumeVm.Ui.Proposals -> ProposalsStep(vm, s, busy)
                is VolumeVm.Ui.Done -> DoneStep(s, onDone = { nav.popBackStack() })
            }
            error?.let {
                Text(
                    it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
private fun SelectStep(vm: VolumeVm, s: VolumeVm.Ui.Select, busy: Boolean) {
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Text(
                "Выберите вещи, которым агент оценит объём и массу. По умолчанию — без заданного объёма.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(
                    selected = s.items.isNotEmpty() && s.selected.size == s.items.size,
                    onClick = { vm.select(s.items.map { i -> i.id }.toSet()) },
                    label = { Text("Все") }
                )
                FilterChip(
                    selected = s.items.isNotEmpty() && s.selected.size != s.items.size,
                    onClick = {
                        vm.select(s.items.filter { it.volume_liters <= 0 && it.weight_kg <= 0 }.map { i -> i.id }.toSet())
                    },
                    label = { Text("Без объёма") }
                )
            }
            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { vm.estimate() },
                enabled = !busy && s.selected.isNotEmpty(),
                modifier = Modifier.fillMaxWidth()
            ) { Text("Оценить (${s.selected.size})") }
            Spacer(Modifier.height(8.dp))
        }
        items(s.items, key = { it.id }) { it ->
            val checked = it.id in s.selected
            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        val next = s.selected.toMutableSet()
                        if (checked) next.remove(it.id) else next.add(it.id)
                        vm.select(next)
                    }
                    .padding(vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(checked = checked, onCheckedChange = { c ->
                    val next = s.selected.toMutableSet()
                    if (c) next.add(it.id) else next.remove(it.id)
                    vm.select(next)
                })
                Column(Modifier.padding(start = 4.dp)) {
                    Text(it.name, style = MaterialTheme.typography.bodyLarge, maxLines = 1)
                    val hasVol = it.volume_liters > 0
                    Text(
                        if (hasVol) "уже задан объём: ${"%.1f".format(it.volume_liters)} л"
                        else "объём не задан",
                        style = MaterialTheme.typography.bodySmall,
                        color = if (hasVol) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun AskingStep(count: Int) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Агент оценивает объёмы ($count)…", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        Text(
            "Модель оценивает объём/массу по названию, категории и описанию. Обычно это занимает до десятка секунд.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun ProposalsStep(vm: VolumeVm, s: VolumeVm.Ui.Proposals, busy: Boolean) {
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                "Предложения агента. Отметьте, какие применить — в базу попадут только отмеченные.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(4.dp))
        }
        items(s.proposals, key = { it.itemId }) { p ->
            Card(Modifier.fillMaxWidth()) {
                Row(
                    Modifier
                        .clickable { vm.toggleProposal(p.itemId) }
                        .padding(horizontal = 4.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(checked = p.itemId in s.checked, onCheckedChange = { vm.toggleProposal(p.itemId) })
                    Column(Modifier.padding(start = 4.dp, end = 8.dp)) {
                        Text(p.name, style = MaterialTheme.typography.titleSmall, maxLines = 1)
                        Text(
                            buildString {
                                append("≈ ").append("%.1f".format(p.volumeLiters)).append(" л")
                                if (p.weightKg > 0) append(" · ").append("%.2f".format(p.weightKg)).append(" кг")
                                if (p.reason.isNotBlank()) append(" — ").append(p.reason)
                            },
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
        item {
            Spacer(Modifier.height(4.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { vm.apply() },
                    enabled = !busy && s.checked.isNotEmpty(),
                    modifier = Modifier.weight(1f)
                ) { Text("Применить (${s.checked.size})") }
                OutlinedButton(onClick = { vm.backToSelect() }, enabled = !busy, modifier = Modifier.weight(1f)) {
                    Text("Отмена")
                }
            }
        }
    }
}

@Composable
private fun DoneStep(s: VolumeVm.Ui.Done, onDone: () -> Unit) {
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text("Применено: ${s.applied}", style = MaterialTheme.typography.titleMedium)
            if (s.fit.isEmpty()) {
                Spacer(Modifier.height(8.dp))
                Text(
                    "У этих вещей не задана локация — заполненность ящиков не пересчитана.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        if (s.fit.isNotEmpty()) {
            item {
                Text(
                    "Заполненность ящиков после применения:",
                    style = MaterialTheme.typography.titleSmall
                )
            }
            items(s.fit, key = { it.container + it.text }) { row ->
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        Text(row.container, style = MaterialTheme.typography.titleSmall, maxLines = 1)
                        Text(
                            row.text,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (row.over) MaterialTheme.colorScheme.error
                            else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
        item {
            Spacer(Modifier.height(8.dp))
            Button(onClick = onDone, modifier = Modifier.fillMaxWidth()) { Text("Готово") }
        }
    }
}
