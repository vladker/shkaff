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
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.ui.components.rememberRole
import androidx.compose.material3.Switch

class SettingsVm : ViewModel() {

    data class Ui(
        val deviceId: String = Deps.deviceId,
        val expiryThreshold: Int = Deps.expiryThresholdDays(),
        val numberingAuto: Boolean = Deps.numberingAuto(),
        val themeIsLight: Boolean = Deps.themeIsLight()
    )

    val ui = MutableStateFlow(Ui())

    // T-009: настройки — зона администратора (Access.ADMIN, «профили, настройки»).
    // UI гасит контролы, VM отклоняет правки и без UI — роль читается наблюдаемо.
    private fun isAdmin(): Boolean = Access.can(ActiveRole.role.value, Access.ADMIN)

    fun canEdit(): Boolean = isAdmin()

    fun setExpiryThreshold(days: Int) {
        if (!isAdmin()) return
        Deps.setExpiryThresholdDays(days)
        ui.value = ui.value.copy(expiryThreshold = days)
    }

    fun setNumberingAuto(on: Boolean) {
        if (!isAdmin()) return
        Deps.setNumberingAuto(on)
        ui.value = ui.value.copy(numberingAuto = on)
    }

    fun setTheme(light: Boolean) {
        if (!isAdmin()) return
        Deps.setThemeLight(light)
        ru.vldkr.shkaff.ui.theme.Ozon.mode =
            if (light) ru.vldkr.shkaff.ui.theme.ThemeMode.LIGHT
            else ru.vldkr.shkaff.ui.theme.ThemeMode.DARK
        ui.value = ui.value.copy(themeIsLight = light)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(nav: NavController) {
    val vm: SettingsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val ui by vm.ui.collectAsState()
    var showExpiryDialog by remember { mutableStateOf(false) }
    // T-009: экран доступен всем, но редактирующие секции — по правам (ADMIN / EXPORT).
    val role = rememberRole()
    val adminLock = if (Access.can(role, Access.ADMIN)) null else "нужен полный доступ"
    val exportLock = if (Access.can(role, Access.EXPORT)) null else "нужно право экспорта"

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
            item { Section("Внешний вид") }
            item {
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text("Светлая тема", style = MaterialTheme.typography.bodyLarge)
                        Text(
                            "«Инвертированная белая». По умолчанию — тёмная (как Ozon); акценты не меняются." +
                                (adminLock?.let { " · $it" } ?: ""),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Switch(
                        checked = ui.themeIsLight,
                        enabled = adminLock == null,
                        onCheckedChange = { vm.setTheme(it) }
                    )
                }
            }
            item { Section("Сроки годности") }
            item {
                SettingRow(
                    "Напоминать о сроках",
                    "В дашборде подсвечиваются вещи, истекающие за ${ui.expiryThreshold} дн.",
                    { showExpiryDialog = true },
                    locked = adminLock
                )
            }
            item { Section("Нумерация") }
            item {
                Row(
                    Modifier.fillMaxWidth().padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text("Автогенерация кодов", style = MaterialTheme.typography.bodyLarge)
                        Text(
                            "Пустое поле — присваивается ULID-код (26 символов): вещи, ящики, шкафы, стеки" +
                                (adminLock?.let { " · $it" } ?: ""),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Switch(
                        checked = ui.numberingAuto,
                        enabled = adminLock == null,
                        onCheckedChange = { vm.setNumberingAuto(it) }
                    )
                }
            }

            item { Section("Данные") }
            item {
                SettingRow("Словарь атрибутов", "Типы и варианты полей", { nav.navigate("attrdefs") }, locked = adminLock)
            }
            item {
                SettingRow(
                    "Экспорт / импорт",
                    "Один файл базы; обмен с другим устройством; слияние с выбором конфликтов",
                    { nav.navigate("backup") },
                    locked = exportLock
                )
            }
            item {
                SettingRow(
                    "Экспорт в Excel/CSV",
                    "Списки вещей и ящиков в xlsx или csv; на устройство или через «Поделиться»",
                    { nav.navigate("export") },
                    locked = exportLock
                )
            }
            item {
                SettingRow(
                    "Федерация (LAN-синхронизация)",
                    "Обмен базой с другим устройством по локальной сети; доверие — роль и область по хранилищам",
                    { nav.navigate("federation") },
                    locked = adminLock
                )
            }
            item {
                SettingRow(
                    "Принтеры",
                    "58-мм ESC/POS: TCP (IP:9100) и Bluetooth; тестовая печать",
                    { nav.navigate("printers") },
                    locked = adminLock
                )
            }
            item { Section("ИИ-агент") }
            item {
                SettingRow(
                    "Модели на устройстве",
                    "Скачивание GGUF-моделей (Qwen3) для работы без интернета",
                    { nav.navigate("llm-models") },
                    locked = adminLock
                )
            }
            item {
                SettingRow(
                    "LLM-чат",
                    "Агент по вашей базе: поиск, сводки, подсказки; провайдер — в настройках чата",
                    { nav.navigate("agent") }
                )
            }
            item { Section("Люди и аудит") }
            item {
                SettingRow(
                    "Профили и роли",
                    "Кто работает, и какие действия разрешены (админ / добавление / перекладка / просмотр)",
                    { nav.navigate("profiles") },
                    locked = adminLock
                )
            }
            item {
                SettingRow(
                    "Выдано временно",
                    "Активные выдачи вещей и хранилищ; просроченные — первыми",
                    { nav.navigate("loans") }
                )
            }
            item {
                SettingRow(
                    "Журнал действий",
                    "Кто, что и когда менял; фильтр и экспорт",
                    { nav.navigate("journal") }
                )
            }
            item {
                SettingRow(
                    "Служебные QR",
                    "QR-действия для печати рядом с хранилищами; ссылка для установки",
                    { nav.navigate("actions") }
                )
            }
            item {
                SettingRow("Облако (Yandex/Dropbox/Drive)", "Автоматическая синхронизация — в планах (M11)", null)
            }
            item { Section("Об устройстве") }
            item {
                Row(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Text("ID устройства", style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
                    Text(ui.deviceId.take(13) + "…", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
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
                                RadioButton(selected = ui.expiryThreshold == n, onClick = {
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
private fun SettingRow(title: String, subtitle: String, onClick: (() -> Unit)?, locked: String? = null) {
    // locked != null — строка показана, но не открывается: так честнее, чем прятать настройку.
    val open = onClick != null && locked == null
    Column(
        Modifier
            .fillMaxWidth()
            .then(if (open) Modifier.clickable { onClick!!() } else Modifier)
            .padding(vertical = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(title, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
            if (open) Text("›", style = MaterialTheme.typography.titleLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Text(
            if (locked != null) "$subtitle · $locked" else subtitle,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
