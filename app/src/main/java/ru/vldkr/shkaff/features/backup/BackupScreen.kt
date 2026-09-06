package ru.vldkr.shkaff.features.backup

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.FileDownload
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.SchemaMetaEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.sync.Backup
import ru.vldkr.shkaff.sync.MergeEngine
import ru.vldkr.shkaff.sync.MergeInput
import ru.vldkr.shkaff.sync.MergeResult
import ru.vldkr.shkaff.sync.MergeSanitizer
import ru.vldkr.shkaff.sync.MergeSession
import ru.vldkr.shkaff.sync.MergeStats
import ru.vldkr.shkaff.ui.components.SectionTitle
import java.io.File
import java.io.IOException
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import androidx.lifecycle.viewmodel.compose.viewModel

class BackupVm : ViewModel() {

    data class Ui(
        val busy: Boolean = false,
        val busyText: String = "",
        val message: String? = null,
        val error: String? = null,
        val lastSyncAt: Long? = null,
        val lastStats: MergeStats? = null,
        val warnings: List<String> = emptyList()
    )

    val ui = MutableStateFlow(Ui())

    private fun update(f: (Ui) -> Ui) {
        ui.value = f(ui.value)
    }

    private data class Prepared(
        val local: MergeInput,
        val remote: MergeInput,
        val result: MergeResult,
        val warnings: List<String>
    )

    init {
        viewModelScope.launch {
            val wm = Deps.db.metaDao().get("lastSyncWatermark")
            if (wm != null) update { it.copy(lastSyncAt = wm.toLongOrNull()) }
        }
    }

    fun exportToUri(ctx: Context, uri: Uri) {
        viewModelScope.launch {
            update { it.copy(busy = true, busyText = "Экспорт…", message = null, error = null) }
            runCatching {
                val input = Backup.buildInput(Deps.db)
                val out = ctx.contentResolver.openOutputStream(uri)
                    ?: throw IOException("Не удалось открыть файл для записи")
                Backup.exportZipToStream(input, out)
                Unit
            }.fold(
                onSuccess = { update { it.copy(busy = false, message = "База экспортирована в выбранный файл") } },
                onFailure = { e -> update { it.copy(busy = false, error = e.message ?: "Ошибка экспорта") } }
            )
        }
    }

    fun shareBackup(ctx: Context) {
        viewModelScope.launch {
            update { it.copy(busy = true, busyText = "Подготовка файла…", message = null, error = null) }
            runCatching {
                val input = Backup.buildInput(Deps.db)
                val dir = File(ctx.filesDir, "backup").apply { mkdirs() }
                val f = File(dir, "shkaff-backup-${LocalDate.now()}.zip")
                Backup.exportToFile(input, f)
                val uri = FileProvider.getUriForFile(ctx, "${ctx.packageName}.fileprovider", f)
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "application/zip"
                    putExtra(Intent.EXTRA_STREAM, uri)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
                ctx.startActivity(Intent.createChooser(intent, "Поделиться базой"))
            }.fold(
                onSuccess = { update { it.copy(busy = false) } },
                onFailure = { e -> update { it.copy(busy = false, error = e.message ?: "Ошибка экспорта") } }
            )
        }
    }

    suspend fun prepareImport(ctx: Context, uri: Uri): Boolean {
        update { it.copy(busy = true, busyText = "Чтение файла…", message = null, error = null) }
        return runCatching {
            val tmp = File(ctx.cacheDir, "shkaff-import-${System.currentTimeMillis()}.zip")
            val input = ctx.contentResolver.openInputStream(uri)
                ?: throw IOException("Не удалось открыть файл")
            input.use { i -> tmp.outputStream().use { o -> i.copyTo(o) } }
            val remote = Backup.importFromFile(tmp)
            tmp.delete()
            val local = Backup.buildInput(Deps.db)
            val result = MergeEngine.merge(local, remote, remoteWins = false)
            val sanitized = MergeSanitizer.sanitize(result.merged)
            Prepared(local, remote, result.copy(merged = sanitized.merged), sanitized.warnings)
        }.fold(
            onSuccess = { p ->
                if (p.result.conflicts.isNotEmpty()) {
                    MergeSession.start(p.local, p.remote, p.result, p.warnings)
                    update { it.copy(busy = false) }
                    true
                } else {
                    commitDirect(p.result, p.warnings)
                    false
                }
            },
            onFailure = { e ->
                update { it.copy(busy = false, error = e.message ?: "Не удалось прочитать файл") }
                false
            }
        )
    }

    private suspend fun commitDirect(result: MergeResult, warnings: List<String>) {
        Backup.applyMerge(result, Deps.db)
        val now = System.currentTimeMillis()
        Deps.db.metaDao().upsert(SchemaMetaEntity("lastSyncWatermark", now.toString()))
        val s = result.stats
        update {
            it.copy(
                busy = false,
                message = "Слияние применено: добавлено ${s.added}, изменено ${s.changed}, удалено ${s.deleted}",
                lastSyncAt = now,
                lastStats = result.stats,
                warnings = warnings
            )
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
fun BackupScreen(nav: NavController) {
    val ctx = LocalContext.current
    val vm: BackupVm = viewModel()
    val ui by vm.ui.collectAsState()
    val scope = rememberCoroutineScope()

    val exportLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument("application/zip")
    ) { uri ->
        if (uri != null) scope.launch { vm.exportToUri(ctx, uri) }
    }

    val importLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.OpenDocument()
    ) { uri ->
        if (uri == null) return@rememberLauncherForActivityResult
        scope.launch {
            if (vm.prepareImport(ctx, uri)) nav.navigate("conflicts")
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Экспорт / импорт") },
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
            SectionTitle("Экспорт")
            Button(
                onClick = { exportLauncher.launch("shkaff-backup-${LocalDate.now()}.zip") },
                enabled = !ui.busy,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.CloudUpload, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Сохранить файл бэкапа…")
            }
            Spacer(Modifier.height(8.dp))
            OutlinedButton(onClick = { vm.shareBackup(ctx) }, enabled = !ui.busy, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Filled.Share, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Поделиться файлом")
            }
            Spacer(Modifier.height(8.dp))
            Text(
                "Один ZIP-файл со всей базой (без фото). Место выбираете сами: локальная папка, сетевая папка, облако. «Поделиться» — в мессенджер, на другой телефон и т.п.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            SectionTitle("Импорт")
            Button(
                onClick = { importLauncher.launch(arrayOf("*/*")) },
                enabled = !ui.busy,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.FileDownload, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Импортировать файл…")
            }
            Spacer(Modifier.height(8.dp))
            Text(
                "Слияние с этой базой: новое — добавится, изменения — по более новой дате, конфликты — выбор вручную. Ничего не удаляется без вашего решения.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            if (ui.busy) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
                ) {
                    CircularProgressIndicator(modifier = Modifier.width(20.dp).height(20.dp))
                    Spacer(Modifier.width(12.dp))
                    Text(ui.busyText, style = MaterialTheme.typography.bodyMedium)
                }
            }

            ui.message?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(vertical = 8.dp))
            }
            ui.error?.let {
                Text(it, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(vertical = 8.dp))
            }
            ui.warnings.forEach { w ->
                Text(w, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.error, modifier = Modifier.padding(vertical = 2.dp))
            }

            val syncAt = ui.lastSyncAt
            if (syncAt != null || ui.lastStats != null) {
                SectionTitle("Последнее слияние")
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        if (syncAt != null) {
                            Text(
                                "Слит ${fmtTime(syncAt)}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        ui.lastStats?.let { s ->
                            Text(
                                "Добавлено: ${s.added} · Изменено: ${s.changed} · Удалено: ${s.deleted} · Без изменений: ${s.kept}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        }
    }
}
