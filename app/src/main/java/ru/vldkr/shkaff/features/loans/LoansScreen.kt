package ru.vldkr.shkaff.features.loans

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.domain.ui.EmptyStateCta
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.util.formatDate

class LoansVm : ViewModel() {

    data class Ui(
        val loans: List<LoanEntity> = emptyList(),
        val storedNames: Map<String, String> = emptyMap()
    )

    val ui = MutableStateFlow(Ui())

    init {
        viewModelScope.launch {
            Deps.loans.observeActive().collect { loans -> ui.value = ui.value.copy(loans = loans) }
        }
        viewModelScope.launch {
            val names = HashMap<String, String>()
            Deps.items.all().forEach { i -> names["item:${i.id}"] = i.name }
            Deps.storages.observeAll().collect { ss ->
                ss.forEach { s -> names["storage:${s.id}"] = s.name }
                ui.value = ui.value.copy(storedNames = names.toMap())
            }
        }
    }

    // T-009: «Вернул» — действие выдачи (Access.LEND); по матрице доступно только
    // полному доступу. UI скрывает кнопку, VM не даёт закрыть выдачу в обход UI.
    fun canReturn(): Boolean = Access.can(ActiveRole.role.value, Access.LEND)

    fun returnLoan(l: LoanEntity) {
        if (!canReturn()) return
        viewModelScope.launch { Deps.loans.returnLoan(l.id) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoansScreen(nav: NavController) {
    val vm: LoansVm = viewModel()
    val ui by vm.ui.collectAsState()
    val role = rememberRole()
    val canManage = Access.can(role, Access.LEND)
    val now = System.currentTimeMillis()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Выдано временно") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    "Вещи и хранилища, выданные на время. Просроченные — в начале списка." +
                        if (canManage) "" else " Возврат оформляет профиль с правом выдачи.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            if (ui.loans.isEmpty()) {
                // П1.4: один CTA — выдача начинается с карточки вещи (US-D3), туда и ведём.
                val ctaLabel = EmptyStateCta.loansEmpty(canManage)
                item {
                    EmptyState(
                        "Нет активных выдач.\nВыдачу оформляют карточки вещи и хранилища: «Выдать временно».",
                        actionLabel = ctaLabel,
                        onAction = if (ctaLabel != null) { { nav.navigate("items/0") } } else null
                    )
                }
            } else {
                items(ui.loans, key = { it.id }) { l ->
                    val overdue = l.due_at != null && l.due_at < now
                    val name = ui.storedNames["${l.entity_type}:${l.entity_id}"] ?: "${l.entity_type}:${l.entity_id}"
                    Column(Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
                        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                            Column(Modifier.weight(1f)) {
                                Text(
                                    name,
                                    style = MaterialTheme.typography.bodyLarge,
                                    fontWeight = if (overdue) FontWeight.Bold else FontWeight.Normal,
                                    color = if (overdue) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    "Кому: ${l.borrower}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                if (l.note.isNotBlank()) {
                                    Text(l.note, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                                val dueText = l.due_at?.let { "возврат до ${formatDate(it)}" } ?: "без срока"
                                Text(
                                    if (overdue) "ПРОСРОЧЕНО · $dueText" else "$dueText · выдано ${formatDate(l.lent_at)}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = if (overdue) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            if (canManage) Button(onClick = { vm.returnLoan(l) }) { Text("Вернул") }
                        }
                    }
                    HorizontalDivider()
                }
            }
        }
    }
}

// Диалог выдачи: используется из карточки вещи и хранилища (US-D3).
@Composable
fun LendDialog(
    title: String,
    onDismiss: () -> Unit,
    onConfirm: (borrower: String, note: String, dueAt: Long?) -> Unit
) {
    var borrower by remember { mutableStateOf("") }
    var note by remember { mutableStateOf("") }
    var due by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                OutlinedTextField(
                    value = borrower,
                    onValueChange = { borrower = it },
                    label = { Text("Кому") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = note,
                    onValueChange = { note = it },
                    label = { Text("Заметка (необязательно)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                )
                OutlinedTextField(
                    value = due,
                    onValueChange = { due = it },
                    label = { Text("Вернуть до: ДД.ММ.ГГГГ (необязательно)") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
                )
            }
        },
        confirmButton = {
            TextButton(
                enabled = borrower.isNotBlank(),
                onClick = {
                    val dueAt = dateToEpoch(due)
                    onConfirm(borrower, note, dueAt)
                }
            ) { Text("Выдать") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

private fun dateToEpoch(ddMMyyyy: String): Long? {
    val p = ddMMyyyy.trim().split(".")
    if (p.size != 3) return null
    val d = p[0].toIntOrNull() ?: return null
    val m = p[1].toIntOrNull() ?: return null
    val y = p[2].toIntOrNull() ?: return null
    if (m !in 1..12 || d !in 1..31) return null
    return java.time.LocalDate.of(y, m, d).atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli()
}