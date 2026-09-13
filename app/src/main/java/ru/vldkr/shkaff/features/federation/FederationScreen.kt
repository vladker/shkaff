package ru.vldkr.shkaff.features.federation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.PeerEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.sync.PeerServer
import ru.vldkr.shkaff.sync.PeerSync
import ru.vldkr.shkaff.sync.PeerTrust
import ru.vldkr.shkaff.ui.components.SectionTitle
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

class FederationVm : ViewModel() {

    data class Ui(
        val serverRunning: Boolean = false,
        val serverPort: Int = 0,
        val serverError: String? = null,
        val serverPortInput: String = "8899",
        val lanIp: String? = null,
        val host: String = "",
        val port: String = "8899",
        val busy: Boolean = false,
        val message: String? = null,
        val error: String? = null,
        val peers: List<PeerEntity> = emptyList(),
        val storages: List<StorageEntity> = emptyList()
    )

    val ui = MutableStateFlow(Ui())

    private fun update(f: (Ui) -> Ui) {
        ui.value = f(ui.value)
    }

    init {
        viewModelScope.launch {
            val storages = Deps.db.storageDao().observeAll().first()
            val peers = Deps.db.peerDao().all()
            update { it.copy(storages = storages, peers = peers, lanIp = PeerServer.lanIp()) }
            refreshServer()
        }
    }

    fun refreshServer() {
        update {
            it.copy(
                serverRunning = PeerServer.running,
                serverPort = PeerServer.port,
                serverError = PeerServer.lastError
            )
        }
    }

    fun setServerPortInput(s: String) {
        update { it.copy(serverPortInput = s) }
    }

    fun setHost(s: String) {
        update { it.copy(host = s) }
    }

    fun setPort(s: String) {
        update { it.copy(port = s) }
    }

    fun startServer() {
        viewModelScope.launch {
            val port = ui.value.serverPortInput.toIntOrNull() ?: 8899
            update { it.copy(error = null) }
            PeerServer.start(port)
            refreshServer()
        }
    }

    fun stopServer() {
        PeerServer.stop()
        refreshServer()
    }

    fun refreshPeers() {
        viewModelScope.launch {
            val peers = Deps.db.peerDao().all()
            update { it.copy(peers = peers) }
        }
    }

    // true — нужно перейти на экран конфликтов.
    suspend fun sync(): Boolean {
        val host = ui.value.host.trim()
        if (host.isEmpty()) {
            update { it.copy(error = "Укажите IP-адрес устройства") }
            return false
        }
        val port = ui.value.port.toIntOrNull() ?: 8899
        update { it.copy(busy = true, message = null, error = null) }
        val r = runCatching { PeerSync.syncWith(host, port) }
        return r.fold(
            onSuccess = { res ->
                update {
                    it.copy(
                        busy = false,
                        message = if (res.conflicts) null else res.message,
                        error = if (res.ok || res.conflicts) null else res.message
                    )
                }
                refreshPeers()
                res.conflicts
            },
            onFailure = { e ->
                update { it.copy(busy = false, error = e.message ?: "Ошибка синхронизации") }
                false
            }
        )
    }

    fun saveTrust(peer: PeerEntity, trust: PeerTrust) {
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            Deps.db.peerDao().upsert(
                peer.copy(trust = PeerTrust.toJson(trust), updated_at = now, device_last_modified = Deps.deviceId)
            )
            Deps.actionLog.log(
                "profile", "peer", peer.peer_device_id,
                mapOf("trust" to PeerTrust.toJson(trust), "name" to peer.name)
            )
            refreshPeers()
        }
    }

    fun deletePeer(peer: PeerEntity) {
        viewModelScope.launch {
            val now = System.currentTimeMillis()
            Deps.db.peerDao().softDelete(peer.id, now, Deps.deviceId)
            Deps.actionLog.log("delete", "peer", peer.peer_device_id, mapOf("name" to peer.name))
            refreshPeers()
        }
    }
}

private fun fmtTime(ts: Long): String = try {
    Instant.ofEpochMilli(ts).atZone(ZoneId.systemDefault())
        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))
} catch (e: Exception) {
    ts.toString()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FederationScreen(nav: NavController) {
    val vm: FederationVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val ui by vm.ui.collectAsState()
    val scope = rememberCoroutineScope()
    var trustPeer by remember { mutableStateOf<PeerEntity?>(null) }
    var confirmDelete by remember { mutableStateOf<PeerEntity?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Федерация (LAN-синхронизация)") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            SectionTitle("Сервер на этом устройстве")
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            if (ui.serverRunning) "Включён — ждёт пиров" else "Выключен",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(Modifier.width(8.dp))
                        if (ui.serverRunning) {
                            Text("порт ${ui.serverPort}", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    val ip = ui.lanIp
                    if (ui.serverRunning && ip != null) {
                        Spacer(Modifier.height(6.dp))
                        Text(
                            "Введите на другом устройстве: $ip:${ui.serverPort}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                    ui.serverError?.let {
                        Spacer(Modifier.height(6.dp))
                        Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = ui.serverPortInput,
                            onValueChange = { vm.setServerPortInput(it) },
                            label = { Text("Порт") },
                            enabled = !ui.serverRunning,
                            modifier = Modifier.width(110.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                        Spacer(Modifier.width(10.dp))
                        if (ui.serverRunning) {
                            OutlinedButton(onClick = { vm.stopServer() }) { Text("Выключить") }
                        } else {
                            Button(onClick = { vm.startServer() }) { Text("Включить") }
                        }
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Пир видит только то, что разрешено его флагами доверия (роль + область по хранилищам).",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(Modifier.height(16.dp))
            SectionTitle("Подключиться к пиру")
            Card(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(12.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = ui.host,
                            onValueChange = { vm.setHost(it) },
                            label = { Text("IP пира") },
                            modifier = Modifier.weight(1f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri)
                        )
                        Spacer(Modifier.width(10.dp))
                        OutlinedTextField(
                            value = ui.port,
                            onValueChange = { vm.setPort(it) },
                            label = { Text("Порт") },
                            modifier = Modifier.width(90.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                if (vm.sync()) nav.navigate("conflicts")
                            }
                        },
                        enabled = !ui.busy,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Синхронизировать")
                    }
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Обмен двусторонний: пирам обмениваемся изменениями, при равных датах локальная запись выигрывает, конфликты — на выбор.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            if (ui.busy) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp)
                ) {
                    CircularProgressIndicator(modifier = Modifier.width(20.dp).height(20.dp))
                    Spacer(Modifier.width(12.dp))
                    Text("Синхронизация…", style = MaterialTheme.typography.bodyMedium)
                }
            }
            ui.message?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(vertical = 8.dp))
            }
            ui.error?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(vertical = 8.dp))
            }

            Spacer(Modifier.height(8.dp))
            SectionTitle("Доверенные устройства")
            if (ui.peers.isEmpty()) {
                Text(
                    "Пока нет. Пир появится сам, когда подключится к вашему серверу, или после вашей синхронизации с ним.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            ui.peers.forEach { p ->
                val trust = remember(p.id, p.updated_at) { PeerTrust.parse(p.trust) }
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        Text(p.name, style = MaterialTheme.typography.titleMedium)
                        Text(
                            "${Access.label(trust.role)} · ${PeerTrust.label(trust)}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        if (p.last_synced_at > 0) {
                            Text("Синхронизация: ${fmtTime(p.last_synced_at)}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        Spacer(Modifier.height(8.dp))
                        Row {
                            TextButton(onClick = { trustPeer = p }) { Text("Права…") }
                            TextButton(onClick = { confirmDelete = p }) { Text("Удалить") }
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
        }

        trustPeer?.let { p ->
            TrustDialog(
                peer = p,
                storages = ui.storages,
                onSave = { trust -> vm.saveTrust(p, trust) },
                onDismiss = { trustPeer = null }
            )
        }
        confirmDelete?.let { p ->
            androidx.compose.material3.AlertDialog(
                onDismissRequest = { confirmDelete = null },
                title = { Text("Удалить пир?") },
                text = { Text("«${p.name}» больше не сможет синхронизироваться с этим устройством.") },
                confirmButton = {
                    TextButton(onClick = {
                        vm.deletePeer(p)
                        confirmDelete = null
                    }) { Text("Удалить") }
                },
                dismissButton = {
                    TextButton(onClick = { confirmDelete = null }) { Text("Отмена") }
                }
            )
        }
    }
}

@Composable
private fun TrustDialog(peer: PeerEntity, storages: List<StorageEntity>, onSave: (PeerTrust) -> Unit, onDismiss: () -> Unit = {}) {
    val cur = remember(peer.id) { PeerTrust.parse(peer.trust) }
    var role by remember { mutableStateOf(cur.role) }
    var scope by remember { mutableStateOf(cur.scope) }
    var selected by remember { mutableStateOf(cur.storages.toMutableSet()) }

    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Права: ${peer.name}") },
        text = {
            Column(Modifier.fillMaxWidth()) {
                Text("Роль", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(vertical = 4.dp))
                Role.entries.forEach { r ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable { role = r }
                            .padding(vertical = 2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(selected = role == r, onClick = { role = r })
                        Spacer(Modifier.width(12.dp))
                        Text(Access.label(r), style = MaterialTheme.typography.bodyLarge)
                    }
                }
                Spacer(Modifier.height(8.dp))
                Text("Область", style = MaterialTheme.typography.titleSmall, modifier = Modifier.padding(vertical = 4.dp))
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { scope = PeerTrust.SCOPE_ALL }
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = scope == PeerTrust.SCOPE_ALL, onClick = { scope = PeerTrust.SCOPE_ALL })
                    Spacer(Modifier.width(12.dp))
                    Text("Вся база", style = MaterialTheme.typography.bodyLarge)
                }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { scope = PeerTrust.SCOPE_SOME }
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = scope == PeerTrust.SCOPE_SOME, onClick = { scope = PeerTrust.SCOPE_SOME })
                    Spacer(Modifier.width(12.dp))
                    Text("Выбранные хранилища (и их поддерево)", style = MaterialTheme.typography.bodyLarge)
                }
                if (scope == PeerTrust.SCOPE_SOME) {
                    Spacer(Modifier.height(8.dp))
                    if (storages.isEmpty()) {
                        Text("Хранилищ пока нет.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    storages.forEach { s ->
                        val name = s.name.ifBlank { s.code }.ifBlank { s.id.take(8) }
                        Row(
                            Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (s.id in selected) selected -= s.id else selected += s.id
                                }
                                .padding(vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            androidx.compose.material3.Checkbox(
                                checked = s.id in selected,
                                onCheckedChange = { v -> if (v) selected += s.id else selected -= s.id }
                            )
                            Spacer(Modifier.width(8.dp))
                            Text(name, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(
                enabled = scope != PeerTrust.SCOPE_SOME || selected.isNotEmpty(),
                onClick = {
                    onSave(
                        PeerTrust(
                            role = role,
                            scope = scope,
                            storages = if (scope == PeerTrust.SCOPE_SOME) selected.toList() else emptyList()
                        )
                    )
                    onDismiss()
                }
            ) { Text("Сохранить") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}
