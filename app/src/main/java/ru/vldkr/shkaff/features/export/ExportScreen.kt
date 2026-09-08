package ru.vldkr.shkaff.features.export

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.export.ExportBuilders
import ru.vldkr.shkaff.export.Sheet
import ru.vldkr.shkaff.export.csvBytes
import ru.vldkr.shkaff.export.toXlsx
import java.io.File
import java.time.LocalDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

const val MIME_XLSX = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
const val MIME_CSV = "text/csv"

class ExportVm : ViewModel() {

    enum class Kind { ITEMS, LOCATIONS }
    enum class Fmt { XLSX, CSV }

    val busy = MutableStateFlow(false)
    val message = MutableStateFlow<String?>(null)
    val error = MutableStateFlow<String?>(null)

    fun exportToUri(ctx: Context, uri: Uri, kind: Kind, fmt: Fmt) {
        viewModelScope.launch {
            busy.value = true
            error.value = null
            try {
                val sheet = sheet(kind)
                ctx.contentResolver.openOutputStream(uri)?.use { os ->
                    when (fmt) {
                        Fmt.XLSX -> sheet.toXlsx(os)
                        Fmt.CSV -> os.write(sheet.csvBytes())
                    }
                } ?: throw IllegalStateException("Не удалось открыть файл для записи")
                message.value = "«${sheet.title}» сохранено (${fmt.label()})"
            } catch (e: Exception) {
                error.value = "Ошибка экспорта: ${e.message}"
            } finally {
                busy.value = false
            }
        }
    }

    fun share(ctx: Context, kind: Kind, fmt: Fmt) {
        viewModelScope.launch {
            busy.value = true
            error.value = null
            try {
                val file = writeToShareDir(ctx, kind, fmt)
                val uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", file)
                val send = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_STREAM, uri)
                    type = mime(fmt)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                ctx.startActivity(
                    Intent.createChooser(send, "Отправить «${kind.title()}»")
                        .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
                message.value = "Файл «${file.name}» готов к отправке"
            } catch (e: Exception) {
                error.value = "Ошибка: ${e.message}"
            } finally {
                busy.value = false
            }
        }
    }

    private suspend fun sheet(kind: Kind): Sheet {
        val (items, locations, storages) = loadAll()
        return if (kind == Kind.ITEMS) {
            ExportBuilders.items(items, locations, storages)
        } else {
            ExportBuilders.locations(locations, storages)
        }
    }

    private suspend fun loadAll(): Triple<List<ItemEntity>, List<LocationEntity>, List<StorageEntity>> {
        val items = Deps.items.all()
        val locations = Deps.locations.observeAll().first()
        val storages = Deps.storages.observeAll().first()
        return Triple(items, locations, storages)
    }

    private suspend fun writeToShareDir(ctx: Context, kind: Kind, fmt: Fmt): File {
        val dir = File(ctx.filesDir, "export").apply { mkdirs() }
        val base = if (kind == Kind.ITEMS) "shkaff-items" else "shkaff-locations"
        val file = File(dir, "$base-${LocalDate.now()}.${if (fmt == Fmt.XLSX) "xlsx" else "csv"}")
        val s = sheet(kind)
        withContext(Dispatchers.IO) {
            if (fmt == Fmt.XLSX) file.outputStream().use { s.toXlsx(it) }
            else file.writeBytes(s.csvBytes())
        }
        return file
    }
}

private fun ExportVm.Fmt.label(): String = if (this == ExportVm.Fmt.XLSX) "xlsx" else "csv"
private fun ExportVm.Kind.title(): String = if (this == ExportVm.Kind.ITEMS) "вещи" else "ящики"
private fun mime(fmt: ExportVm.Fmt): String = if (fmt == ExportVm.Fmt.XLSX) MIME_XLSX else MIME_CSV

private fun stamp(): String = LocalDate.now().toString()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExportScreen(nav: NavController) {
    val vm: ExportVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val ctx = LocalContext.current
    val busy by vm.busy.collectAsState()
    val message by vm.message.collectAsState()
    val error by vm.error.collectAsState()

    val saveItemsXlsx = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument(MIME_XLSX)) { uri ->
        if (uri != null) vm.exportToUri(ctx, uri, ExportVm.Kind.ITEMS, ExportVm.Fmt.XLSX)
    }
    val saveItemsCsv = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument(MIME_CSV)) { uri ->
        if (uri != null) vm.exportToUri(ctx, uri, ExportVm.Kind.ITEMS, ExportVm.Fmt.CSV)
    }
    val saveLocXlsx = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument(MIME_XLSX)) { uri ->
        if (uri != null) vm.exportToUri(ctx, uri, ExportVm.Kind.LOCATIONS, ExportVm.Fmt.XLSX)
    }
    val saveLocCsv = rememberLauncherForActivityResult(ActivityResultContracts.CreateDocument(MIME_CSV)) { uri ->
        if (uri != null) vm.exportToUri(ctx, uri, ExportVm.Kind.LOCATIONS, ExportVm.Fmt.CSV)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Экспорт в Excel/CSV") },
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
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item { Section("Вещи") }
            item {
                Button(
                    onClick = { saveItemsXlsx.launch("shkaff-items-${stamp()}.xlsx") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Сохранить Excel (xlsx)…") }
            }
            item {
                Button(
                    onClick = { saveItemsCsv.launch("shkaff-items-${stamp()}.csv") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Сохранить CSV…") }
            }
            item {
                OutlinedButton(
                    onClick = { vm.share(ctx, ExportVm.Kind.ITEMS, ExportVm.Fmt.XLSX) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Поделиться (xlsx)") }
            }
            item {
                OutlinedButton(
                    onClick = { vm.share(ctx, ExportVm.Kind.ITEMS, ExportVm.Fmt.CSV) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Поделиться (csv)") }
            }

            item { Section("Ящики") }
            item {
                Button(
                    onClick = { saveLocXlsx.launch("shkaff-locations-${stamp()}.xlsx") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Сохранить Excel (xlsx)…") }
            }
            item {
                Button(
                    onClick = { saveLocCsv.launch("shkaff-locations-${stamp()}.csv") },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Сохранить CSV…") }
            }
            item {
                OutlinedButton(
                    onClick = { vm.share(ctx, ExportVm.Kind.LOCATIONS, ExportVm.Fmt.XLSX) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Поделиться (xlsx)") }
            }
            item {
                OutlinedButton(
                    onClick = { vm.share(ctx, ExportVm.Kind.LOCATIONS, ExportVm.Fmt.CSV) },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp),
                    enabled = !busy
                ) { Text("Поделиться (csv)") }
            }

            item {
                Text(
                    "Вещи: название, код, описание, путь по шкафу и ящикам, теги, срок годности, даты. " +
                        "Ящики: название, метка, шкаф, родительский ящик, даты. " +
                        "CSV открывается в Excel с кириллицей (BOM + UTF-8).",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            if (busy) {
                item {
                    Text("Готовим файл…", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            message?.let {
                item {
                    Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
                }
            }
            error?.let {
                item {
                    Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error)
                }
            }
        }
    }
}

@Composable
private fun Section(title: String) {
    Text(title, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(vertical = 12.dp))
}
