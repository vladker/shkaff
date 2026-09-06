package ru.vldkr.shkaff.features.printers

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.data.db.PrinterProfileEntity
import ru.vldkr.shkaff.data.printer.PrintManager

@Composable
fun PrinterPickerDialog(
    profiles: List<PrinterProfileEntity>,
    onPick: (PrinterProfileEntity) -> Unit,
    onManage: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Печать этикетки") },
        text = {
            Column {
                if (profiles.isEmpty()) {
                    Text(
                        "Принтеры не добавлены — добавьте TCP (IP:9100) или Bluetooth-принтер.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                profiles.forEach { p ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .clickable { onPick(p) }
                            .padding(vertical = 8.dp)
                    ) {
                        Text(p.name, modifier = Modifier.weight(1f))
                        Text(
                            PrintManager.describe(p),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onManage) { Text("Принтеры…") }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}
