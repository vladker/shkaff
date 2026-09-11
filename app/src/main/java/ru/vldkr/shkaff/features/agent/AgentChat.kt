package ru.vldkr.shkaff.features.agent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage

data class AgentMsg(val role: String, val content: String)

class AgentVm : ViewModel() {

    val messages = MutableStateFlow<List<AgentMsg>>(emptyList())
    val busy = MutableStateFlow(false)
    val error = MutableStateFlow<String?>(null)
    val settings = MutableStateFlow(Deps.agentSettings())
    var showSettings = MutableStateFlow(true)

    private val history = mutableListOf<ChatMessage>()

    fun send(text: String) {
        val t = text.trim()
        if (t.isEmpty() || busy.value) return
        messages.value = messages.value + AgentMsg("user", t)
        history.add(ChatMessage("user", t))
        busy.value = true
        error.value = null
        viewModelScope.launch {
            try {
                val system = ChatMessage("system", buildSystemPrompt())
                val reply = ChatClient.complete(
                    settings.value,
                    listOf(system) + history
                )
                val content = if (reply.isBlank()) "Нет ответа от модели" else reply
                messages.value = messages.value + AgentMsg("assistant", content)
                history.add(ChatMessage("assistant", content))
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка запроса к модели"
            } finally {
                busy.value = false
            }
        }
    }

    fun saveSettings(s: AgentSettings) {
        settings.value = s
        Deps.saveAgentSettings(s)
    }

    fun clear() {
        messages.value = emptyList()
        history.clear()
    }

    private suspend fun buildSystemPrompt(): String {
        val storages = Deps.storages.observeAll().first()
        val locations = Deps.locations.observeAll().first()
        val items = Deps.items.observeAll().first()
        val locById = locations.associateBy { it.id }
        val stById = storages.associateBy { it.id }

        val sb = StringBuilder()
        sb.append(
            "Ты — LLM-агент «Шкаф», помогаешь владельцу базы вещей.\n" +
            "База локальная (Room на устройстве), Вот текущий снимок.\n" +
            "Отвечай по-русски, кратко и по делу.\n\n"
        )
        sb.append("== Шкафы (${storages.size}) ==\n")
        storages.forEach { sb.append("- ").append(it.name).append("\n") }
        sb.append("\n== Ящики/полки (${locations.size}) ==\n")
        locations.forEach { loc ->
            sb.append("- ").append(loc.name.ifBlank { loc.label })
            loc.storage_id?.let { sid ->
                stById[sid]?.let { sb.append("  [в «").append(it.name).append("»]") }
            }
            sb.append("\n")
        }
        sb.append("\n== Вещи (${items.size}) ==\n")
        items.take(400).forEach { it.appendTo(sb, locById) }
        return sb.toString()
    }

    private fun ItemEntity.appendTo(sb: StringBuilder, locById: Map<String, LocationEntity>) {
        sb.append("- ").append(name)
        if (code.isNotBlank()) sb.append(" [код ").append(code).append("]")
        if (ean?.isNotBlank() == true) sb.append(" (EAN ").append(ean).append(")")
        location_id?.let { lid ->
            locById[lid]?.let { sb.append(" → в «").append(it.name.ifBlank { it.label }).append("»") }
        }
        if (expiry_date?.isNotBlank() == true) sb.append(", срок ").append(expiry_date)
        if (!expiry_date.isNullOrBlank()) sb.append(", истекает ").append(expiry_date)
        if (photo_path != null) sb.append(", фото есть")
        sb.append("\n")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentScreen(nav: NavController) {
    val vm: AgentVm = viewModel()
    val messages by vm.messages.collectAsState()
    val busy by vm.busy.collectAsState()
    val error by vm.error.collectAsState()
    val settings by vm.settings.collectAsState()
    var input by remember { mutableStateOf("") }
    var showSettings by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    // варианты для диалога настроек
    var sProvider by remember { mutableStateOf(settings.provider) }
    var sBaseUrl by remember { mutableStateOf(settings.baseUrl) }
    var sApiKey by remember { mutableStateOf(settings.apiKey) }
    var sModel by remember { mutableStateOf(settings.model) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("LLM-агент") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { showSettings = true }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Настройки агента")
                    }
                }
            )
        },
        bottomBar = {
            Column {
                HorizontalDivider()
                Row(
                    Modifier
                        .fillMaxWidth()
                        .imePadding()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = input,
                        onValueChange = { input = it },
                        modifier = Modifier.weight(1f),
                        placeholder = { Text("Спросите агента…") },
                        enabled = !busy,
                        maxLines = 4
                    )
                    Spacer(Modifier.width(8.dp))
                    IconButton(
                        onClick = { vm.send(input); input = "" },
                        enabled = !busy && input.isNotBlank()
                    ) {
                        Icon(Icons.Filled.Send, contentDescription = "Отправить", tint = MaterialTheme.colorScheme.primary)
                    }
                }
            }
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(top = 12.dp, bottom = 12.dp)
        ) {
            item { Text("""
Помогает по вашей базе: «где лежит мука», «что скоро истечёт», «куда положить банку 2 л». 
Агент видит вещи, шкафы и ящики. Настройки провайдера — по шестерёнке.
""".trimIndent(), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant) }
            item {
                OutlinedButton(
                    onClick = { nav.navigate("agent-volumes") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ) {
                    Icon(Icons.Filled.Inventory2, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Оценить объёмы вещей")
                }
            }
            items(messages) { m -> Bubble(m) }
            if (busy) {
                item {
                    Text("Агент думает…", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        }
    }

    if (showSettings) {
        val dialog = AlertDialog(
            onDismissRequest = { showSettings = false },
            title = { Text("Агент") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(
                        value = sProvider,
                        onValueChange = { sProvider = it },
                        label = { Text("Провайдер: cloud / local") },
                        supportingText = { Text("cloud — OpenAI-совместимый API; local — Ollama") }
                    )
                    OutlinedTextField(
                        value = sBaseUrl,
                        onValueChange = { sBaseUrl = it },
                        label = { Text("Base URL") },
                        placeholder = { Text(ChatClient.DEFAULT_BASE_URL) }
                    )
                    OutlinedTextField(
                        value = sApiKey,
                        onValueChange = { sApiKey = it },
                        label = { Text("API Key") }
                    )
                    OutlinedTextField(
                        value = sModel,
                        onValueChange = { sModel = it },
                        label = { Text("Модель") },
                        placeholder = { Text("gpt-4o-mini / qwen2.5:7b") }
                    )
                }
            },
            confirmButton = {
                TextButton(onClick = {
                    vm.saveSettings(
                        AgentSettings(
                            provider = sProvider.trim(),
                            baseUrl = sBaseUrl.trim(),
                            apiKey = sApiKey.trim(),
                            model = sModel.trim()
                        )
                    )
                    showSettings = false
                }) { Text("Сохранить") }
            },
            dismissButton = {
                TextButton(onClick = { showSettings = false }) { Text("Отмена") }
            }
        )
        dialog
    }
}

@Composable
private fun Bubble(m: AgentMsg) {
    val isUser = m.role == "user"
    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = if (isUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Text(
            m.content,
            modifier = Modifier
                .widthIn(max = 320.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(
                    if (isUser) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.surfaceVariant
                )
                .padding(horizontal = 12.dp, vertical = 10.dp),
            color = if (isUser) MaterialTheme.colorScheme.onPrimary
            else MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
