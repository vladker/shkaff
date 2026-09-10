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
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ActionLogEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.util.formatDate

class JournalVm : ViewModel() {

    val entries = MutableStateFlow<List<ActionLogEntity>>(emptyList())
    val filter = MutableStateFlow<String?>(null)

    init {
        viewModelScope.launch {
            filter.flatMapLatest { f -> Deps.actionLog.observeFiltered(f, null, null, 100) }
                .collect { entries.value = it }
        }
    }

    fun setFilter(a: String?) {
        filter.value = a
    }
}

// Подписи действий для журнала и экспорта.
fun actionLabel(a: String): String = when (a) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JournalScreen(nav: NavController) {
    val vm: JournalVm = viewModel()
    val entries by vm.entries.collectAsState()
    val filter by vm.filter.collectAsState()
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
                        val body = entries.joinToString("\n") { e ->
                            "${formatDate(e.at)} · ${e.user_name.ifBlank { "—" }} · ${actionLabel(e.action)} · ${e.entity_type} ${e.entity_id}"
                        }
                        val send = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_TEXT, "Журнал действий «Шкаф»\n\n$body")
                        }
                        ctx.startActivity(Intent.createChooser(send, "Журнал"))
                    }) {
                        Icon(Icons.Filled.Share, contentDescription = "Поделиться журналом")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            Row(Modifier.padding(vertical = 8.dp)) {
                listOf<String?>(null, "lend", "delete", "move").forEach { a ->
                    FilterChip(
                        selected = filter == a,
                        onClick = { vm.setFilter(a) },
                        label = {
                            Text(
                                when (a) {
                                    null -> "Все"
                                    "lend" -> "Выдача"
                                    "delete" -> "Удаление"
                                    else -> "Перекладка"
                                }
                            )
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
            LazyColumn(Modifier.fillMaxSize()) {
                if (entries.isEmpty()) {
                    item { EmptyState("Журнал пуст.\nДействия начнут записываться после первого изменения.") }
                } else {
                    items(entries, key = { it.id }) { e ->
                        Column(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                            Row {
                                Text(
                                    actionLabel(e.action),
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.weight(1f)
                                )
                                Text(formatDate(e.at), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Text(
                                "${e.user_name.ifBlank { "—" }} · ${e.entity_id.ifBlank { "—" }}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        HorizontalDivider()
                    }
                }
            }
        }
    }
}