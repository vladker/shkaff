package ru.vldkr.shkaff.features.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.di.Deps

class SettingsVm : ViewModel() {
    val deviceId = MutableStateFlow(Deps.deviceId)
    val expiryThreshold = MutableStateFlow(Deps.expiryThresholdDays())

    fun setExpiryThreshold(days: Int) {
        Deps.setExpiryThresholdDays(days)
        expiryThreshold.value = days
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(nav: NavController) {
    val vm: SettingsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val deviceId by vm.deviceId.collectAsState()
    var showExpiryDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Настройки") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
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
            contentPadding = androidx.compose.foundation.layout.PaddingValues(bottom = 24.dp)
        ) {
            item { Section("Сроки годности") }
            item {
                SettingRow(
                    "Напоминать о сроках",
                    "В дашборде подсвечиваются вещи, истекающие за ${vm.expiryThreshold.value} дн.",
                    { showExpiryDialog = true }
                )
            }
            item { Section("Данные") }
            item {
                SettingRow("Словарь атрибутов", "Типы и варианты полей", { nav.navigate("attrdefs") })
            }
            item {
                SettingRow(
                    "Экспорт / импорт",
                    "Один файл базы; обмен с другим устройством; слияние с выбором конфликтов",
                    { nav.navigate("backup") }
                )
            }
            item {
                SettingRow(
                    "Принтеры",
                    "58-мм ESC/POS: TCP (IP:9100) и Bluetooth; тестовая печать",
                    { nav.navigate("printers") }
                )
            }
            item {
                SettingRow("Облако (Yandex/Dropbox/Drive)", "Автоматическая синхронизация — в планах (M11)", null)
            }
            item { Section("Об устройстве") }
            item {
                Row(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text("ID устройства", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                    Text(deviceId.take(13) + "…", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            item { Section("О приложении") }
            item {
                Text(
                    "Шкаф — локальный инвентарь вещей, ящиков и хранилищ. База хранится на устройстве; экспорт в один файл и синхронизация добавляются в следующих этапах.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }

        if (showExpiryDialog) {
            AlertDialog(
                onDismissRequest = { showExpiryDialog = false },
                title = { Text("За сколько дней напоминать?") },
                text = {
                    Column {
                        listOf(30, 60, 90).forEach { n ->
                            Row(
                                Modifier
                                    .clickable {
                                        vm.setExpiryThreshold(n)
                                        showExpiryDialog = false
                                    }
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(selected = vm.expiryThreshold.value == n, onClick = {
                                    vm.setExpiryThreshold(n)
                                    showExpiryDialog = false
                                })
                                Spacer(Modifier.width(12.dp))
                                Text("за $n дн.", style = MaterialTheme.typography.bodyLarge)
                            }
                        }
                    }
                },
                confirmButton = {
                    TextButton(onClick = { showExpiryDialog = false }) { Text("Закрыть") }
                }
            )
        }
    }
}

@Composable
private fun Section(title: String) {
    Text(title, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(vertical = 12.dp))
}

@Composable
private fun SettingRow(title: String, subtitle: String, onClick: (() -> Unit)?) {
    Column(
        Modifier
            .fillMaxWidth()
            .then(if (onClick != null) Modifier.clickable { onClick() } else Modifier)
            .padding(vertical = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(title, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
            if (onClick != null) Text("›", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}
