package ru.vldkr.shkaff.features.actions

import android.content.Intent
import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.actions.ActionCode
import ru.vldkr.shkaff.domain.actions.ActionCode.Verb
import ru.vldkr.shkaff.features.labels.LabelGenerator

// Служебные QR (US-F1): QR кодирует действие; скан в приложении его выполняет.
// Ссылка установки (US-I3): обычная HTTPS-ссылка — сканируется и без приложения.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActionsScreen(nav: NavController) {
    val ctx = LocalContext.current
    var dialogCode by remember { mutableStateOf<String?>(null) }
    var dialogBmp by remember { mutableStateOf<Bitmap?>(null) }
    var dialogTitle by remember { mutableStateOf("") }

    fun show(code: String, title: String) {
        dialogCode = code
        dialogTitle = title
        dialogBmp = LabelGenerator.generate(qrTemplate(), code, "")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Служебные QR") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {
            item {
                Text(
                    "QR-коды действий можно распечатать и повесить рядом с хранилищем. Скан внутри «Шкафа» выполнит действие с учётом прав профиля.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            item { ActionRow("Новая вещь", "add:item → открыть форму", { show(ActionCode.encode(Verb.ADD, "item"), "QR: новая вещь") }) }
            item { ActionRow("Новое хранилище", "add:storage → открыть форму", { show(ActionCode.encode(Verb.ADD, "storage"), "QR: новое хранилище") }) }
            item { ActionRow("Новый ящик", "add:location → открыть форму", { show(ActionCode.encode(Verb.ADD, "location"), "QR: новый ящик") }) }
            item { ActionRow("Экспорт базы", "export → экран экспорта", { show(ActionCode.encode(Verb.EXPORT), "QR: экспорт") }) }
            item { ActionRow("Журнал действий", "journal → открыть журнал", { show(ActionCode.encode(Verb.JOURNAL), "QR: журнал") }) }
            item { HorizontalDivider(Modifier.padding(vertical = 8.dp)) }
            item {
                Text(
                    "Установка без приложения (US-I3)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            item {
                Text(
                    "QR со ссылкой на установку «Шкафа». На устройстве без приложения откроется страница релиза.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
            item { ActionRow("Ссылка для установки", ActionCode.INSTALL_URL, { show(ActionCode.INSTALL_URL, "QR: установка") }) }
        }
    }

    if (dialogCode != null && dialogBmp != null) {
        AlertDialog(
            onDismissRequest = {
                dialogCode = null
                dialogBmp = null
            },
            title = { Text(dialogTitle) },
            text = {
                Column {
                    Image(dialogBmp!!.asImageBitmap(), contentDescription = dialogCode, modifier = Modifier.fillMaxWidth().height(260.dp))
                    Spacer(Modifier.height(8.dp))
                    Text(dialogCode!!, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            },
            confirmButton = {
                Button(onClick = {
                    val bmp = dialogBmp ?: return@Button
                    val file = LabelGenerator.saveToInternal(ctx, bmp, "service-qr")
                    val uri = LabelGenerator.fileShareUri(ctx, file)
                    val intent = Intent(Intent.ACTION_SEND).apply {
                        type = "image/png"
                        putExtra(Intent.EXTRA_STREAM, uri)
                        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    }
                    ctx.startActivity(Intent.createChooser(intent, "Поделиться QR"))
                }) { Text("Поделиться") }
            },
            dismissButton = {
                TextButton(onClick = {
                    dialogCode = null
                    dialogBmp = null
                }) { Text("Закрыть") }
            }
        )
    }
}

@Composable
private fun ActionRow(title: String, subtitle: String, onClick: () -> Unit) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {
        Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
            Text(title, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
            Button(onClick = onClick) { Text("QR") }
        }
        Text(subtitle, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
    HorizontalDivider()
}

// Временный шаблон: чистый QR без текстовой подписи (для служебных кодов).
private fun qrTemplate(): LabelTemplateEntity {
    val now = System.currentTimeMillis()
    return LabelTemplateEntity(
        id = "service-qr",
        name = "service",
        format = "QR",
        width_mm = 58.0,
        height_mm = 58.0,
        margin_mm = 2.0,
        show_text = false,
        text_content = "",
        font_size = 10.0,
        created_at = now,
        updated_at = now,
        deleted_at = null,
        device_last_modified = Deps.deviceId
    )
}