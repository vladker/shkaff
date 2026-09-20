package ru.vldkr.shkaff.features.labelstudio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.features.labelstudio.domain.LabelStudioDeps

/** Панель печати: выбор принтера, печать, тестовая печать, статус. */
@Composable
fun PrintQueuePanel(
    printers: List<LabelStudioDeps.PrinterProfile>,
    selectedPrinterId: String?,
    onSelectPrinter: (String) -> Unit,
    printing: Boolean,
    result: String?,
    onPrint: () -> Unit,
    onTestPrint: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text("Печать", style = MaterialTheme.typography.titleMedium)
        PrinterDropdown(printers, selectedPrinterId, onSelectPrinter)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = onPrint, enabled = !printing && printers.isNotEmpty()) {
                Text(if (printing) "Печать…" else "Печать")
            }
            OutlinedButton(onClick = onTestPrint, enabled = !printing && printers.isNotEmpty()) {
                Text("Тест")
            }
        }
        result?.let {
            Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
        }
    }
}

/** Информация о выбранном принтере (параметры профиля, read-only). */
@Composable
fun PrinterSettingsPanel(profile: LabelStudioDeps.PrinterProfile?) {
    if (profile == null) return
    Card(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) {
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(profile.name, style = MaterialTheme.typography.titleSmall)
            Text("Транспорт: ${profile.transport}", style = MaterialTheme.typography.bodySmall)
            Text("Бумага: ${profile.physicalPaperWidthMm} мм, печать ${profile.printableWidthMm} мм", style = MaterialTheme.typography.bodySmall)
            Text("Тип: ${profile.paperType}, зазор ${profile.gapMm} мм, dpi ${profile.dpi}", style = MaterialTheme.typography.bodySmall)
            Text("Сдвиг: X ${profile.offsetXmm} мм, Y ${profile.offsetYmm} мм", style = MaterialTheme.typography.bodySmall)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PrinterDropdown(
    printers: List<LabelStudioDeps.PrinterProfile>,
    selectedId: String?,
    onSelect: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val selected = printers.find { it.id == selectedId } ?: printers.firstOrNull()
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        OutlinedTextField(
            value = selected?.name ?: "Нет принтеров",
            onValueChange = {},
            readOnly = true,
            label = { Text("Принтер") },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
        )
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            printers.forEach { p ->
                DropdownMenuItem(
                    text = { Text(p.name) },
                    onClick = {
                        onSelect(p.id)
                        expanded = false
                    }
                )
            }
        }
    }
}