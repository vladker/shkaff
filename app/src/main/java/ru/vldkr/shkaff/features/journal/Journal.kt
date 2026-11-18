package ru.vldkr.shkaff.features.journal

import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ActionLogEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ErrorState
import ru.vldkr.shkaff.ui.components.ListSkeleton
import ru.vldkr.shkaff.ui.state.ListFeed
import ru.vldkr.shkaff.ui.state.UiState
import ru.vldkr.shkaff.ui.state.mergeFeeds
import ru.vldkr.shkaff.util.formatDate

class JournalVm : ViewModel() {
    data class Ui(
        val entries: List<ActionLogEntity> = emptyList(),
        val filter: String? = null,
        // T-040b: «Журнал пуст» показывалось и до первой эмиссии БД, и после сбоя
        // подписки — теперь загрузка и сбой это отдельные ветки.
        val loading: Boolean = true,
        val error: String? = null,
    )

    val ui = MutableStateFlow(Ui())

    // Фильтр читается в момент подписки: смена фильтра = retry() с новым срезом.
    private val entriesFeed =
        ListFeed(viewModelScope) {
            Deps.actionLog.observeFiltered(ui.value.filter, null, null, 100)
        }
    private val feeds = listOf(entriesFeed)

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
            entriesFeed.state.collect { s -> if (s is UiState.Success) ui.value = ui.value.copy(entries = s.data) }
        }
    }

    fun setFilter(a: String?) {
        ui.value = ui.value.copy(filter = a)
        entriesFeed.retry()
    }

    fun retry() {
        feeds.forEach { it.retry() }
    }
}

// Подписи действий для журнала и экспорта.
fun actionLabel(a: String): String =
    when (a) {
        "create" -> "создано"
        "update" -> "изменено"
        "delete" -> "удалено"
        "move" -> "переложено"
        "lend" -> "выдано"
        "return" -> "возвращено"
        "export" -> "экспорт"
        "import" -> "импорт"
        "print" -> "печать"
        "profile" -> "профиль"
        "service" -> "служебный QR"
        else -> a
    }

// Подписи типов сущностей для журнала и экспорта.
fun entityLabel(t: String): String =
    when (t) {
        "item" -> "вещь"
        "storage" -> "хранилище"
        "location" -> "ящик"
        "stack" -> "стек"
        "basket" -> "корзина"
        "loan" -> "выдача"
        "sheet_layout" -> "разметка"
        "printer" -> "принтер"
        "template" -> "шаблон"
        "peer" -> "пир"
        "user" -> "профиль"
        "schema" -> "схема"
        else -> t
    }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreen(nav: NavController) {
    val vm: JournalVm = viewModel()
    val ui by vm.ui.collectAsState()
    val ctx = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Журнал действий") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        val body =
                            ui.entries.joinToString("\n") { e ->
                                "${formatDate(
                                    e.at,
                                )} · ${e.user_name.ifBlank { "—" }} · ${actionLabel(
                                    e.action,
                                )} · ${entityLabel(e.entity_type)} ${e.entity_id}"
                            }
                        val send =
                            Intent(Intent.ACTION_SEND).apply {
                                type = "text/plain"
                                putExtra(Intent.EXTRA_TEXT, "Журнал действий «Шкаф»\n\n$body")
                            }
                        ctx.startActivity(Intent.createChooser(send, "Журнал"))
                    }) {
                        Icon(Icons.Filled.Share, contentDescription = "Поделиться журналом")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
        ) {
            Row(Modifier.padding(vertical = 8.dp)) {
                listOf<String?>(null, "lend", "delete", "move").forEach { a ->
                    FilterChip(
                        selected = ui.filter == a,
                        onClick = { vm.setFilter(a) },
                        label = {
                            Text(
                                when (a) {
                                    null -> "Все"
                                    "lend" -> "Выдача"
                                    "delete" -> "Удаление"
                                    else -> "Перекладка"
                                },
                            )
                        },
                        modifier = Modifier.padding(end = 8.dp),
                    )
                }
            }
            val error = ui.error
            LazyColumn(Modifier.fillMaxSize()) {
                if (error != null) {
                    item { ErrorState(error) { vm.retry() } }
                } else if (ui.loading) {
                    item { ListSkeleton(rows = 6, modifier = Modifier.padding(top = 8.dp)) }
                } else if (ui.entries.isEmpty()) {
                    item {
                        // П1.4: под фильтром журнал не пуст — пуст срез; CTA снимает фильтр.
                        val filterActive = ui.filter != null
                        EmptyState(
                            if (filterActive) "Под этот фильтр записей нет." else "Журнал пуст.\nДействия начнут записываться после первого изменения.",
                            actionLabel = EmptyStateCta.journalEmpty(filterActive),
                            onAction =
                                if (filterActive) {
                                    { vm.setFilter(null) }
                                } else {
                                    { nav.navigate("item-wizard") }
                                },
                        )
                    }
                } else {
                    items(ui.entries, key = { it.id }) { e ->
                        Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                            Row {
                                Text(
                                    actionLabel(e.action),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.weight(1f),
                                )
                                Text(
                                    formatDate(e.at),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                )
                            }
                            Text(
                                "${e.user_name.ifBlank { "—" }} · ${e.entity_id.ifBlank { "—" }}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            )
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}
