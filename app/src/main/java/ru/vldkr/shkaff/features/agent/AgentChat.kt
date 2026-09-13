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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.CircularProgressIndicator
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
import ru.vldkr.shkaff.domain.agent.Agent
import ru.vldkr.shkaff.domain.agent.AgentSettings
import ru.vldkr.shkaff.domain.agent.ChatClient
import ru.vldkr.shkaff.domain.agent.ChatMessage
import ru.vldkr.shkaff.domain.agent.DeviceLlm
import ru.vldkr.shkaff.domain.agent.LlmDiscovery
import ru.vldkr.shkaff.domain.agent.LlmRuntime

data class AgentMsg(val role: String, val content: String)

class AgentVm : ViewModel() {

    val messages = MutableStateFlow<List<AgentMsg>>(emptyList())
    val busy = MutableStateFlow(false)
    val error = MutableStateFlow<String?>(null)
    val draft = MutableStateFlow("")
    val settings = MutableStateFlow(Deps.agentSettings())
    val modelLoad = LlmRuntime.load

    private val history = mutableListOf<ChatMessage>()

    fun send(text: String) {
        val t = text.trim()
        if (t.isEmpty() || busy.value) return
        if (Agent.isDevice(settings.value) && settings.value.model.isBlank()) {
            error.value = "Модель на устройстве не выбрана — откройте настройки (шестерёнка) и скачайте GGUF"
            return
        }
        messages.value = messages.value + AgentMsg("user", t)
        history.add(ChatMessage("user", t))
        busy.value = true
        error.value = null
        draft.value = ""
        viewModelScope.launch {
            try {
                val system = ChatMessage("system", buildSystemPrompt())
                val reply = Agent.complete(
                    settings.value,
                    listOf(system) + history,
                    onToken = { tok -> draft.value += tok }
                )
                val content = if (reply.isBlank()) "Нет ответа от модели" else reply
                messages.value = messages.value + AgentMsg("assistant", content)
                history.add(ChatMessage("assistant", content))
            } catch (e: Exception) {
                error.value = e.message ?: "Ошибка запроса к модели"
            } finally {
                draft.value = ""
                busy.value = false
            }
        }
    }

    fun stop() {
        if (Agent.isDevice(settings.value)) DeviceLlm.abort()
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
            "База локальная (Room на устройстве). Вот текущий снимок.\n" +
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
        if (photo_path != null) sb.append(", фото есть")
        sb.append("\n")
    }
}

private data class ProviderOption(val id: String, val title: String, val desc: String)

private val PROVIDERS = listOf(
    ProviderOption(Agent.PROVIDER_CLOUD, "Облако", "OpenAI-совместимый API (OpenRouter, Groq, …)"),
    ProviderOption(Agent.PROVIDER_LOCAL, "Локальная сеть", "Ollama / LM Studio на ПК рядом"),
    ProviderOption(Agent.PROVIDER_DEVICE, "На устройстве", "GGUF-модель офлайн, llama.cpp"),
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgentScreen(nav: NavController) {
    val vm: AgentVm = viewModel()
    val messages by vm.messages.collectAsState()
    val busy by vm.busy.collectAsState()
    val error by vm.error.collectAsState()
    val draft by vm.draft.collectAsState()
    val settings by vm.settings.collectAsState()
    val modelLoad by vm.modelLoad.collectAsState()
    var input by remember { mutableStateOf("") }
    var showSettings by remember { mutableStateOf(false) }

    // варианты для диалога настроек
    var sProvider by remember { mutableStateOf(settings.provider.ifBlank { Agent.PROVIDER_CLOUD }) }
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
                    if (busy) {
                        IconButton(
                            onClick = { vm.stop() },
                            enabled = Agent.isDevice(settings)
                        ) {
                            Icon(Icons.Filled.Stop, contentDescription = "Остановить", tint = MaterialTheme.colorScheme.error)
                        }
                    } else {
                        IconButton(
                            onClick = { vm.send(input); input = "" },
                            enabled = input.isNotBlank()
                        ) {
                            Icon(Icons.AutoMirrored.Filled.Send, contentDescription = "Отправить", tint = MaterialTheme.colorScheme.primary)
                        }
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
            item { Text(
                "Помогает по вашей базе: «где лежит мука», «что скоро истечёт», «куда положить банку 2 л».\n" +
                "Агент видит вещи, шкафы и ящики. Провайдер — по шестерёнке: облако, локальная сеть или модель на устройстве (офлайн).",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            ) }
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
            if (modelLoad.loading) {
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            "Загрузка модели… ${modelLoad.percent}%",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        androidx.compose.material3.LinearProgressIndicator(
                            progress = { modelLoad.percent / 100f },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
            if (busy && !modelLoad.loading) {
                item { Text("Агент думает…", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant) }
            }
            if (draft.isNotBlank()) {
                item { Bubble(AgentMsg("assistant", draft)) }
            }
            if (error != null) {
                item {
                    Text(error!!, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }

    if (showSettings) {
        SettingsDialog(
            initial = settings,
            onDismiss = { showSettings = false },
            onOpenCatalog = {
                showSettings = false
                nav.navigate("llm-models")
            },
            onSaved = { s ->
                vm.saveSettings(
                    s.copy(
                        provider = s.provider.ifBlank { Agent.PROVIDER_CLOUD },
                        enabled = s.model.isNotBlank()
                    )
                )
                showSettings = false
            }
        )
    }
}

@Composable
private fun SettingsDialog(
    initial: AgentSettings,
    onDismiss: () -> Unit,
    onOpenCatalog: () -> Unit,
    onSaved: (AgentSettings) -> Unit,
) {
    var sProvider by remember { mutableStateOf(initial.provider.ifBlank { Agent.PROVIDER_CLOUD }) }
    var sBaseUrl by remember { mutableStateOf(initial.baseUrl) }
    var sApiKey by remember { mutableStateOf(initial.apiKey) }
    var sModel by remember { mutableStateOf(initial.model) }
    var sStatus by remember { mutableStateOf<String?>(null) }
    val storeState by Deps.modelStore.state.collectAsState()
    val downloaded = remember(storeState) { storeState.rows.filter { Deps.modelStore.isDownloaded(it) } }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Агент") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                // Пресет задаёт только провайдера и модель; URL — через «Автопоиск»
                // (IP дома не постоянен, хардкод здесь ломал настройки).
                OutlinedButton(
                    onClick = {
                        sProvider = Agent.PROVIDER_CLOUD
                        sModel = "qwen/qwen3.8-27b"
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Пресет: Qwen 27B (URL — автопоиск)")
                }
                PROVIDERS.forEach { p ->
                    Row(
                        Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = sProvider == p.id,
                            onClick = { sProvider = p.id }
                        )
                        Column {
                            Text(p.title)
                            Text(p.desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }

                if (sProvider == Agent.PROVIDER_DEVICE) {
                    if (downloaded.isEmpty()) {
                        Text(
                            "Скачанных моделей нет. Скачайте GGUF в каталоге моделей.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        OutlinedButton(onClick = onOpenCatalog, modifier = Modifier.fillMaxWidth()) {
                            Text("Открыть каталог моделей")
                        }
                    } else {
                        Text("Модель на устройстве:", style = MaterialTheme.typography.bodySmall)
                        downloaded.forEach { row ->
                            Row(
                                Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = sModel == row.file,
                                    onClick = { sModel = row.file }
                                )
                                Text(row.name, modifier = Modifier.padding(start = 4.dp))
                            }
                        }
                        OutlinedButton(onClick = onOpenCatalog, modifier = Modifier.fillMaxWidth()) {
                            Text("Каталог моделей")
                        }
                    }
                } else {
                    AutoSearchRow(
                        baseUrl = sBaseUrl,
                        onResult = { url, models, msg ->
                            if (url != null) {
                                sBaseUrl = url
                                if (models.none { it == sModel }) sModel = models.first()
                            }
                            sStatus = msg
                        }
                    )
                    sStatus?.let { st ->
                        Text(st, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                    OutlinedTextField(
                        value = sBaseUrl,
                        onValueChange = { sBaseUrl = it; sStatus = null },
                        label = { Text("Base URL") },
                        placeholder = { Text("http://192.168.1.11:1234/v1") }
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
                        placeholder = { Text("qwen/qwen3.8-27b") }
                    )
                }
            }
        },
        confirmButton = {
            TextButton(onClick = {
                // device-провайдер: имя модели = имя GGUF-файла; старое имя
                // cloud-модели после переключения провайдера сбрасываем
                val model = if (sProvider == Agent.PROVIDER_DEVICE && downloaded.none { it.file == sModel }) {
                    ""
                } else sModel.trim()
                onSaved(
                    AgentSettings(
                        provider = sProvider,
                        baseUrl = sBaseUrl.trim(),
                        apiKey = sApiKey.trim(),
                        model = model
                    )
                )
            }) { Text("Сохранить") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

/**
 * «Автопоиск»: ищет LLM-сервер (GET /v1/models) в подсети телефона и на 127.0.0.1
 * (USB-отладка через `adb reverse tcp:1234 tcp:1234`), результат подставляется в форму.
 */
@Composable
private fun AutoSearchRow(
    baseUrl: String,
    onResult: (url: String?, models: List<String>, message: String) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var busy by remember { mutableStateOf(false) }
    OutlinedButton(
        onClick = {
            if (busy) return@OutlinedButton
            busy = true
            scope.launch {
                try {
                    val port = LlmDiscovery.portFromBaseUrl(baseUrl)
                    val found = LlmDiscovery.discover(port)
                    if (found == null) {
                        onResult(
                            null,
                            emptyList(),
                            "Сервер не найден. ПК с ИИ должен быть в той же Wi-Fi сети (порт $port) либо телефон подключён по USB с активным adb reverse tcp:$port tcp:$port."
                        )
                    } else {
                        onResult(found.baseUrl, found.models, "Найдено: ${found.baseUrl} (моделей: ${found.models.size})")
                    }
                } catch (e: Exception) {
                    onResult(null, emptyList(), "Ошибка автопоиска: ${e.message}")
                } finally {
                    busy = false
                }
            }
        },
        enabled = !busy,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (busy) {
            CircularProgressIndicator(
                modifier = Modifier.size(14.dp),
                strokeWidth = 2.dp
            )
            Spacer(Modifier.width(8.dp))
        }
        Text(if (busy) "Ищем сервер ИИ…" else "Автопоиск сервера ИИ")
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
