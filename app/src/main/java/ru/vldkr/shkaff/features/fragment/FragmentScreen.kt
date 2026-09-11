package ru.vldkr.shkaff.features.fragment

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.io.IOException
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.sync.Backup
import ru.vldkr.shkaff.sync.Fragment
import ru.vldkr.shkaff.sync.MergeInput
import ru.vldkr.shkaff.ui.components.SectionTitle
import java.time.LocalDate
import androidx.lifecycle.viewmodel.compose.viewModel

class FragmentVm : ViewModel() {

    data class Ui(
        val busy: Boolean = false,
        val message: String? = null,
        val error: String? = null,
        val storages: List<StorageEntity> = emptyList(),
        val locations: List<LocationEntity> = emptyList(),
        val windowDays: Int = 0, // 0 — всё время
        val selectedStorages: Set<String> = emptySet(),
        val selectedLocations: Set<String> = emptySet(),
        val preview: Fragment.Stats? = null
    )

    val ui = MutableStateFlow(Ui())
    var fullInput: MergeInput? = null
        private set

    private fun update(f: (Ui) -> Ui) {
        val next = f(ui.value)
        ui.value = next
        refreshPreview(next)
    }

    init {
        viewModelScope.launch {
            val storages = Deps.storages.observeAll().first()
            val locations = Deps.locations.observeAll().first()
            fullInput = Backup.buildInput(Deps.db)
            ui.value = ui.value.copy(storages = storages, locations = locations)
            refreshPreview(ui.value)
        }
    }

    private fun refreshPreview(u: Ui) {
        val input = fullInput ?: return
        val opts = Fragment.Options(
            locationIds = u.selectedLocations,
            storageIds = u.selectedStorages,
            windowDays = u.windowDays
        )
        ui.value = u.copy(preview = Fragment.preview(input, opts))
    }

    fun toggleStorage(id: String) {
        update {
            val sel = if (id in it.selectedStorages) it.selectedStorages - id else it.selectedStorages + id
            it.copy(selectedStorages = sel)
        }
    }

    fun toggleLocation(id: String) {
        update {
            val sel = if (id in it.selectedLocations) it.selectedLocations - id else it.selectedLocations + id
            it.copy(selectedLocations = sel)
        }
    }

    fun setWindow(days: Int) {
        update { it.copy(windowDays = days) }
    }

    fun exportToUri(ctx: Context, uri: Uri) {
        val input = fullInput ?: return
        update { it.copy(busy = true, message = null, error = null) }
        viewModelScope.launch {
            runCatching {
                    val fragment = Fragment.split(input, Fragment.Options(
                        locationIds = ui.value.selectedLocations,
                        storageIds = ui.value.selectedStorages,
                        windowDays = ui.value.windowDays
                    ))
                    val out = ctx.contentResolver.openOutputStream(uri)
                        ?: throw IOException("Не удалось открыть файл для записи")
                    Backup.exportZipToStream(fragment, out)
                Unit
            }.fold(
                onSuccess = { update { it.copy(busy = false, message = "Фрагмент сохранён. Это обычный бэкап — импортируйте его как обычно.") } },
                onFailure = { e -> update { it.copy(busy = false, error = e.message ?: "Ошибка экспорта") } }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FragmentScreen(nav: NavController) {
    val ctx = LocalContext.current
    val vm: FragmentVm = viewModel()
    val ui by vm.ui.collectAsState()
    val scope = rememberCoroutineScope()

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.CreateDocument("application/zip")
    ) { uri ->
        if (uri != null) scope.launch { vm.exportToUri(ctx, uri) }
    }

    val selectedAny = ui.selectedLocations.isNotEmpty() || ui.selectedStorages.isNotEmpty() || ui.windowDays > 0

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Фрагмент базы") },
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
            Text(
                "Выгрузка части базы (US-G3): выбранные ящики/хранилища и/или вещи за период. Фрагмент — тот же файл бэкапа, его можно слить с любой основой базой без потерь.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            SectionTitle("Период (вещи с изменением за срока)")
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                mapOf(0 to "Всё время", 1 to "День", 7 to "Неделя", 30 to "Месяц").forEach { (days, label) ->
                    FilterChip(
                        selected = ui.windowDays == days,
                        onClick = { vm.setWindow(days) },
                        label = { Text(label) }
                    )
                }
            }

            SectionTitle("Хранилища")
            ui.storages.forEach { s ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { vm.toggleStorage(s.id) }
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = s.id in ui.selectedStorages,
                        onCheckedChange = { vm.toggleStorage(s.id) }
                    )
                    Text(s.name, modifier = Modifier.weight(1f))
                }
            }

            SectionTitle("Ящики")
            ui.locations.forEach { l ->
                val parent = ui.locations.firstOrNull { it.id == l.parent_id }
                Row(
                    Modifier
                        .fillMaxWidth()
                        .clickable { vm.toggleLocation(l.id) }
                        .padding(start = if (parent != null) 16.dp else 0.dp, top = 2.dp, bottom = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = l.id in ui.selectedLocations,
                        onCheckedChange = { vm.toggleLocation(l.id) }
                    )
                    Text(l.label.ifBlank { l.name }.ifBlank { "Ящик" }, style = MaterialTheme.typography.bodyMedium)
                }
            }

            HorizontalDivider(Modifier.padding(vertical = 12.dp))

            ui.preview?.let { p ->
                Text(
                    "В фрагмент войдёт: шкафов ${p.storages}, ящиков ${p.locations}, вещей ${p.items}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            if (!selectedAny) {
                Text(
                    "Выберите хотя бы один ящик, хранилище или период",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(Modifier.height(8.dp))
            Button(
                onClick = { launcher.launch("shkaff-fragment-${LocalDate.now()}.zip") },
                enabled = selectedAny && !ui.busy,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Filled.CloudUpload, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Сохранить фрагмент…")
            }

            if (ui.busy) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 12.dp)
                ) {
                    CircularProgressIndicator(modifier = Modifier.height(20.dp).width(20.dp))
                    Spacer(Modifier.padding(horizontal = 8.dp))
                    Text("Экспорт…", style = MaterialTheme.typography.bodyMedium)
                }
            }
            ui.message?.let {
                Text(it, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 4.dp))
            }
            ui.error?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}