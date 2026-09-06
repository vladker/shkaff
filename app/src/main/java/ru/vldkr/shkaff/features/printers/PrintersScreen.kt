package ru.vldkr.shkaff.features.printers

import android.Manifest
import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.os.Build
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.util.newId

class PrintersVm : ViewModel() {

    data class Ui(
        val profiles: List<PrinterProfileEntity> = emptyList(),
        val busy: Boolean = false,
        val busyText: String = "",
        val message: String? = null,
        val error: String? = null,
        val permRequest: Boolean = false,
        val bonded: List<String> = emptyList()
    )

    val ui = MutableStateFlow(Ui())

    private var pendingTestId: String? = null

    private fun update(f: (Ui) -> Ui) {
        ui.value = f(ui.value)
    }

    init {
        viewModelScope.launch {
            Deps.db.printerDao().observeAll().collect { list ->
                update { it.copy(profiles = list) }
            }
        }
    }

    fun btAllowed(ctx: Context): Boolean {
        val perm = if (Build.VERSION.SDK_INT >= 31) {
            Manifest.permission.BLUETOOTH_CONNECT
        } else {
            Manifest.permission.BLUETOOTH
        }
        return ContextCompat.checkSelfPermission(ctx, perm) == PackageManager.PERMISSION_GRANTED
    }

    fun loadBonded(ctx: Context) {
        val list = runCatching {
            val adapter = BluetoothAdapter.getDefaultAdapter() ?: return@runCatching emptyList()
            adapter.bondedDevices?.map { d -> "${d.name} — ${d.address}" } ?: emptyList()
        }.getOrDefault(emptyList())
        update { it.copy(bonded = list) }
    }

    fun save(p: PrinterProfileEntity) {
        viewModelScope.launch {
            update { it.copy(busy = true, busyText = "Сохранение…", message = null, error = null) }
            Deps.db.printerDao().upsert(p)
            update { it.copy(busy = false, message = "Принтер «${p.name}» сохранён") }
        }
    }

    fun delete(id: String) {
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            Deps.db.printerDao().softDelete(id, now, Deps.deviceId)
            update { it.copy(message = null, error = null) }
        }
    }

    fun test(ctx: Context, profileId: String) {
        val p = ui.value.profiles.firstOrNull { it.id == profileId } ?: return
        if (p.transport.lowercase() != "tcp" && !btAllowed(ctx)) {
            pendingTestId = profileId
            update { it.copy(permRequest = true, error = null) }
            return
        }
        doTest(profileId)
    }

    fun onPermissionResult(granted: Boolean) {
        val id = pendingTestId
        pendingTestId = null
        update { it.copy(permRequest = false) }
        if (granted && id != null) doTest(id)
        else if (!granted) {
            update { it.copy(error = "Нет разрешения «Близкие устройства» — без него Bluetooth-печать не работает") }
        }
    }

    private fun doTest(profileId: String) {
        val p = ui.value.profiles.firstOrNull { it.id == profileId } ?: return
        viewModelScope.launch {
            update { it.copy(busy = true, busyText = "Тестовая страница…", message = null, error = null) }
            PrintManager.testPrint(p).fold(
                onSuccess = {
                    update { it.copy(busy = false, message = "Отправлено: ${PrintManager.describe(p)}") }
                },
                onFailure = { e ->
                    update { it.copy(busy = false, error = "Ошибка: ${e.message ?: e.javaClass.simpleName}") }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrintersScreen(nav: NavController) {
    val ctx = LocalContext.current
    val vm: PrintersVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val ui by vm.ui.collectAsState()
    var formOpen by remember { mutableStateOf(false) }
    var editing by remember { mutableStateOf<PrinterProfileEntity?>(null) }
    var toDelete by remember { mutableStateOf<PrinterProfileEntity?>(null) }

    val permLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted -> vm.onPermissionResult(granted) }
    LaunchedEffect(ui.permRequest) {
        if (ui.permRequest) {
            permLauncher.launch(
                if (Build.VERSION.SDK_INT >= 31) Manifest.permission.BLUETOOTH_CONNECT
                else Manifest.permission.BLUETOOTH
            )
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Принтеры") },
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
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                Button(
                    onClick = { editing = null; formOpen = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(Icons.Filled.Add, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Добавить принтер")
                }
            }

            if (ui.profiles.isEmpty()) {
                item {
                    EmptyState("Принтеры не добавлены.\nTCP — IP-адрес и порт 9100; Bluetooth — сопряжённое устройство.")
                }
            }

            ui.profiles.forEach { p ->
                item(key = p.id) {
                    Card(Modifier.fillMaxWidth()) {
                        Column(Modifier.padding(12.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    if (p.transport.lowercase() == "tcp") Icons.Filled.NetworkCheck
                                    else Icons.Filled.Bluetooth,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary
                                )
                                Spacer(Modifier.width(8.dp))
                                Text(p.name, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
                            }
                            Text(
                                "${PrintManager.describe(p)} · бумага ${p.paper_width_mm.toInt()} мм",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(Modifier.height(8.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                OutlinedButton(
                                    onClick = { vm.test(ctx, p.id) },
                                    enabled = !ui.busy,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Text("Тест")
                                }
                                IconButton(onClick = { editing = p; formOpen = true }) {
                                    Icon(Icons.Filled.Edit, contentDescription = "Изменить")
                                }
                                IconButton(onClick = { toDelete = p }) {
                                    Icon(Icons.Filled.Delete, contentDescription = "Удалить", tint = MaterialTheme.colorScheme.error)
                                }
                            }
                        }
                    }
                }
            }

            item {
                Column(Modifier.padding(vertical = 8.dp)) {
                    if (ui.busy) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            CircularProgressIndicator(modifier = Modifier.width(16.dp).height(16.dp))
                            Spacer(Modifier.width(8.dp))
                            Text(ui.busyText, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                    ui.message?.let {
                        Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
                    }
                    ui.error?.let {
                        Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
                    }
                }
            }

            item {
                Text(
                    "Прямая печать — ESC/POS (203 dpi, 8 точек/мм). Если принтер не отвечает, гарантированный путь: этикетка → PNG → «Поделиться» → приложение принтера.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    if (formOpen) {
        PrinterFormDialog(
            initial = editing,
            bonded = ui.bonded,
            onBondedRefresh = { vm.loadBonded(ctx) },
            onSave = { p ->
                vm.save(p)
                formOpen = false
            },
            onDismiss = { formOpen = false }
        )
    }

    toDelete?.let { p ->
        AlertDialog(
            onDismissRequest = { toDelete = null },
            title = { Text("Удалить принтер?") },
            text = { Text("«${p.name}» будет удалён из списка. Данные на принтере не затрагиваются.") },
            confirmButton = {
                TextButton(onClick = { vm.delete(p.id); toDelete = null }) {
                    Text("Удалить", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { toDelete = null }) { Text("Отмена") }
            }
        )
    }
}

@Composable
fun PrinterFormDialog(
    initial: PrinterProfileEntity?,
    bonded: List<String>,
    onBondedRefresh: () -> Unit,
    onSave: (PrinterProfileEntity) -> Unit,
    onDismiss: () -> Unit
) {
    var name by remember { mutableStateOf(initial?.name ?: "") }
    var isTcp by remember { mutableStateOf(initial?.transport?.lowercase() == "tcp") }
    var host by remember { mutableStateOf(initial?.host ?: "") }
    var port by remember { mutableStateOf((initial?.port ?: 9100).toString()) }
    var mac by remember { mutableStateOf(initial?.bt_mac ?: "") }
    var paperW by remember { mutableStateOf((initial?.paper_width_mm ?: 58.0).toInt().toString()) }
    var error by remember { mutableStateOf<String?>(null) }
    var pickOpen by remember { mutableStateOf(false) }

    fun submit() {
        val w = paperW.toDoubleOrNull()
        val pr = port.toIntOrNull()
        when {
            name.isBlank() -> error = "Введите название"
            isTcp && host.isBlank() -> error = "Введите IP-адрес"
            isTcp && pr == null || pr !in 1..65535 -> error = "Порт: число 1–65535"
            !isTcp && mac.isBlank() -> error = "Выберите устройство или введите MAC"
            w == null || w !in 20.0..300.0 -> error = "Ширина бумаги: 20–300 мм"
            else -> {
                val now = System.currentTimeMillis()
                onSave(
                    PrinterProfileEntity(
                        id = initial?.id ?: newId(),
                        name = name.trim(),
                        transport = if (isTcp) "tcp" else "bluetooth",
                        host = if (isTcp) host.trim() else "",
                        port = pr ?: 9100,
                        bt_mac = if (isTcp) "" else mac.trim(),
                        protocol = "escpos",
                        paper_width_mm = w,
                        offset_x_mm = initial?.offset_x_mm ?: 0.0,
                        offset_y_mm = initial?.offset_y_mm ?: 0.0,
                        is_default = initial?.is_default ?: false,
                        created_at = initial?.created_at ?: now,
                        updated_at = now,
                        deleted_at = null,
                        device_last_modified = Deps.deviceId
                    )
                )
            }
        }
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(if (initial == null) "Новый принтер" else "Принтер") },
        text = {
            Column(Modifier.fillMaxWidth()) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Название") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(
                        selected = isTcp,
                        onClick = { isTcp = true },
                        label = { Text("TCP (IP:порт)") }
                    )
                    FilterChip(
                        selected = !isTcp,
                        onClick = { isTcp = false },
                        label = { Text("Bluetooth") }
                    )
                }
                Spacer(Modifier.height(12.dp))
                if (isTcp) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            value = host,
                            onValueChange = { host = it },
                            label = { Text("IP-адрес") },
                            supportingText = { Text("Напр. 192.168.1.50") },
                            modifier = Modifier.weight(1f),
                            singleLine = true
                        )
                        OutlinedTextField(
                            value = port,
                            onValueChange = { port = it },
                            label = { Text("Порт") },
                            modifier = Modifier.width(96.dp),
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                } else {
                    OutlinedTextField(
                        value = mac,
                        onValueChange = { mac = it },
                        label = { Text("MAC-адрес") },
                        placeholder = { Text("AA:BB:CC:DD:EE:FF") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    if (bonded.isNotEmpty()) {
                        TextButton(onClick = { pickOpen = true }) {
                            Text("Выбрать из сопряжённых (${bonded.size})")
                        }
                    } else {
                        TextButton(onClick = { onBondedRefresh() }) {
                            Text("Загрузить список сопряжённых")
                        }
                    }
                }
                Spacer(Modifier.height(12.dp))
                OutlinedTextField(
                    value = paperW,
                    onValueChange = { paperW = it },
                    label = { Text("Ширина бумаги, мм") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                error?.let {
                    Spacer(Modifier.height(8.dp))
                    Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.error)
                }
            }
        },
        confirmButton = {
            Button(onClick = { submit() }) { Text("Сохранить") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )

    if (pickOpen) {
        AlertDialog(
            onDismissRequest = { pickOpen = false },
            title = { Text("Сопряжённые устройства") },
            text = {
                Column {
                    bonded.forEach { d ->
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clickable { mac = d.substringAfter(" — "); pickOpen = false }
                                .padding(vertical = 6.dp)
                        ) {
                            Text(d)
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { pickOpen = false }) { Text("Закрыть") }
            }
        )
    }
}
