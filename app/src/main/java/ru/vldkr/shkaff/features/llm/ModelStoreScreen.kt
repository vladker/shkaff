package ru.vldkr.shkaff.features.llm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.llm.ModelRow
import ru.vldkr.shkaff.data.llm.ModelState
import ru.vldkr.shkaff.di.Deps

class ModelStoreVm : ViewModel() {

    data class RowVm(
        val row: ModelRow,
        val got: Boolean,
        val mmprojGot: Boolean,
        val downloading: Boolean,
        val fraction: Float,
        val activeFile: String?,
    )

    data class Ui(
        val rows: List<RowVm> = emptyList(),
        val customUrl: String = "",
        val error: String? = null,
    )

    private val _ui = MutableStateFlow(Ui())
    val ui: StateFlow<Ui> = _ui

    init {
        viewModelScope.launch {
            Deps.modelStore.state.collect { s ->
                _ui.value = _ui.value.copy(
                    rows = s.rows.map { row ->
                        var fraction = 0f
                        var activeFile: String? = null
                        if (s.activeName == row.file || s.activeName == row.mmprojFile) {
                            activeFile = s.activeName
                            fraction = if (s.total > 0) (s.bytes.toFloat() / s.total).coerceIn(0f, 1f) else 0f
                        }
                        RowVm(
                            row = row,
                            got = Deps.modelStore.isDownloaded(row),
                            mmprojGot = Deps.modelStore.mmprojDone(row),
                            downloading = activeFile != null,
                            fraction = fraction,
                            activeFile = activeFile,
                        )
                    }
                )
            }
        }
    }

    fun setCustomUrl(v: String) = _ui.update { it.copy(customUrl = v) }

    fun download(row: ModelRow) = Deps.modelStore.start(row)

    fun cancel() = Deps.modelStore.cancel()

    fun delete(row: ModelRow) = Deps.modelStore.delete(row)

    fun addCustom() {
        val url = _ui.value.customUrl
        if (url.isBlank()) return
        Deps.modelStore.addCustom(url)
            .onFailure { e -> _ui.update { it.copy(error = e.message) } }
        _ui.update { it.copy(customUrl = "") }
    }

    fun clearError() = _ui.update { it.copy(error = null) }

    private fun MutableStateFlow<Ui>.update(f: (Ui) -> Ui) {
        value = f(value)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModelStoreScreen(nav: NavController) {
    val vm: ModelStoreVm = viewModel()
    val ui by vm.ui.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Модели на устройстве") },
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
            item {
                Text(
                    "Модели скачиваются на устройство и работают без интернета. " +
                        "Скачивание идёт в фоне, даже если свернуть приложение.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 12.dp)
                )
            }
            items(ui.rows, key = { it.row.id }) { rv ->
                ModelCard(vm, rv)
            }
            item {
                HorizontalDivider(modifier = Modifier.padding(vertical = 12.dp))
                Text("Своя модель по ссылке", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(bottom = 8.dp))
            }
            item {
                OutlinedTextField(
                    value = ui.customUrl,
                    onValueChange = vm::setCustomUrl,
                    label = { Text("URL файла .gguf") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("https://huggingface.co/…/resolve/main/….gguf") }
                )
                Spacer(Modifier.height(8.dp))
                Button(onClick = vm::addCustom, modifier = Modifier.height(48.dp)) {
                    Text("Добавить в список")
                }
            }
            item {
                Text(
                    "Файлы лежат в «Папка приложения / models». Каталог не входит в бэкап и синхронизацию.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }

    ui.error?.let { message ->
        AlertDialog(
            onDismissRequest = vm::clearError,
            title = { Text("Не удалось добавить модель") },
            text = { Text(message) },
            confirmButton = { TextButton(onClick = vm::clearError) { Text("Ок") } }
        )
    }
}

@Composable
private fun ModelCard(vm: ModelStoreVm, rv: ModelStoreVm.RowVm) {
    val row = rv.row
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.weight(1f)) {
                Text(
                    row.name,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    description(rv),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(Modifier.width(12.dp))
            ActionButton(vm, rv, row)
        }
        if (rv.downloading) {
            Spacer(Modifier.height(6.dp))
            LinearProgressIndicator(
                progress = { rv.fraction },
                modifier = Modifier.fillMaxWidth()
            )
            val label = if (rv.activeFile == row.mmprojFile) "vision-файл (mmproj)" else "файл модели"
            Text(
                "$label: ${(rv.fraction * 100).toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        if (!rv.downloading && row.state == ModelState.ERROR) {
            Text(
                row.message ?: "Ошибка загрузки",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
        row.mmprojFile?.let {
            if (rv.got) {
                Text(
                    "vision: ${if (rv.mmprojGot) "готово" else "требуется mmproj — нажмите «Скачать» ещё раз"}",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (rv.mmprojGot) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
private fun ActionButton(vm: ModelStoreVm, rv: ModelStoreVm.RowVm, row: ModelRow) {
    when {
        rv.downloading -> OutlinedButton(onClick = vm::cancel, modifier = Modifier.height(48.dp)) {
            Text("Отмена")
        }
        rv.got && (row.mmprojFile == null || rv.mmprojGot) -> {
            Row {
                Text(
                    "Готово ✓",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(Modifier.width(8.dp))
                OutlinedButton(onClick = { vm.delete(row) }, modifier = Modifier.height(48.dp)) {
                    Text("Удалить")
                }
            }
        }
        else -> OutlinedButton(onClick = { vm.download(row) }, modifier = Modifier.height(48.dp)) {
            Text(if (rv.got) "Скачать mmproj" else "Скачать")
        }
    }
}

private fun description(rv: ModelStoreVm.RowVm): String {
    val row = rv.row
    val size = if (row.sizeBytes > 0) {
        if (row.sizeBytes >= 1e9) "%.1f ГБ".format(row.sizeBytes / 1e9) else "%.0f МБ".format(row.sizeBytes / 1e6)
    } else "размер неизвестен"
    val quantInfo = if (row.quantName.isNotEmpty()) " · ${row.quantName}" else ""
    return when {
        rv.got && rv.mmprojGot -> "$size$quantInfo · скачана, готова к использованию"
        rv.got -> "$size$quantInfo · файл есть (mmproj не хватает)"
        row.custom -> size
        else -> "$size$quantInfo · нет на устройстве"
    }
}