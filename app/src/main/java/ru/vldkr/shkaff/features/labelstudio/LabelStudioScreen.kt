package ru.vldkr.shkaff.features.labelstudio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps
import ru.vldkr.shkaff.features.labelstudio.domain.PageSettings
import ru.vldkr.shkaff.features.labelstudio.domain.PaletteType
import ru.vldkr.shkaff.ui.components.EmptyState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelStudioScreen(
    nav: NavController,
    deps: LabelStudioDeps,
    kind: String,
    subjectId: String,
    templateId: String?
) {
    val vm: LabelStudioVm = viewModel(factory = LabelStudioVm.Factory(deps, kind, subjectId, templateId))
    val ui by vm.ui.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(ui.subject?.name ?: "Этикетка") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = vm::toggleTemplates) {
                        Icon(Icons.Filled.Description, contentDescription = "Шаблоны")
                    }
                    IconButton(onClick = vm::togglePrinters) {
                        Icon(Icons.Filled.Print, contentDescription = "Принтер")
                    }
                    IconButton(onClick = vm::toggleInspector) {
                        Icon(Icons.Filled.Tune, contentDescription = "Свойства")
                    }
                    TextButton(onClick = vm::save, enabled = ui.dirty) { Text("Сохранить") }
                }
            )
        }
    ) { padding ->
        when {
            ui.loading -> Box(
                Modifier.fillMaxSize().padding(padding),
                contentAlignment = Alignment.Center
            ) { CircularProgressIndicator() }

            ui.error != null -> EmptyState(ui.error!!)

            ui.doc != null -> Column(Modifier.fillMaxSize().padding(padding)) {
                Box(Modifier.weight(1f).fillMaxWidth()) {
                    WysiwygCanvas(
                        doc = ui.doc!!,
                        bindings = ui.bindings,
                        selectedId = ui.selectedId,
                        zoom = ui.zoom,
                        onSelect = vm::select,
                        onMove = vm::moveSelected,
                        onResize = vm::resizeSelected
                    )
                    Column(
                        Modifier.align(Alignment.BottomEnd).padding(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        FilledTonalIconButton(onClick = vm::zoomIn) {
                            Icon(Icons.Filled.Add, contentDescription = "Приблизить")
                        }
                        FilledTonalIconButton(onClick = vm::zoomOut) {
                            Icon(Icons.Filled.Remove, contentDescription = "Отдалить")
                        }
                    }
                }
                HorizontalDivider()
                Row(
                    Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    PaletteType.entries.forEach { t ->
                        FilterChip(
                            selected = false,
                            onClick = { vm.addElement(t) },
                            label = { Text(paletteLabel(t)) }
                        )
                    }
                }
                PrintQueuePanel(
                    printers = ui.printers,
                    selectedPrinterId = ui.selectedPrinterId,
                    onSelectPrinter = vm::selectPrinter,
                    printing = ui.printing,
                    result = ui.printResult,
                    onPrint = vm::print,
                    onTestPrint = vm::testPrint
                )
            }
        }
    }

    if (ui.showInspector) {
        InspectorSheet(
            element = ui.doc?.elements?.find { it.id == ui.selectedId },
            page = ui.doc?.page ?: PageSettings(),
            onUpdateElement = vm::updateElement,
            onUpdatePage = vm::updatePage,
            onDelete = vm::deleteSelected,
            onDuplicate = vm::duplicateSelected,
            onDismiss = vm::toggleInspector
        )
    }

    if (ui.showPrinters) {
        ModalBottomSheet(onDismissRequest = vm::togglePrinters) {
            PrinterSettingsPanel(ui.printers.find { it.id == ui.selectedPrinterId })
        }
    }

    if (ui.showTemplates) {
        ModalBottomSheet(onDismissRequest = vm::toggleTemplates) {
            Column(Modifier.fillMaxWidth().padding(bottom = 32.dp)) {
                Text(
                    "Шаблоны",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
                ListItem(
                    headlineContent = { Text("Новая этикетка") },
                    modifier = Modifier.clickable { vm.newDoc() }
                )
                ui.templates.forEach { t ->
                    ListItem(
                        headlineContent = { Text(t.name) },
                        modifier = Modifier.clickable { vm.applyTemplate(t) }
                    )
                }
            }
        }
    }
}

private fun paletteLabel(t: PaletteType): String = when (t) {
    PaletteType.QR -> "QR"
    PaletteType.BARCODE -> "Штрихкод"
    PaletteType.TEXT -> "Текст"
    PaletteType.FIELD -> "Поле"
    PaletteType.IMAGE -> "Картинка"
    PaletteType.LINE -> "Линия"
    PaletteType.RECT -> "Прямоугольник"
}