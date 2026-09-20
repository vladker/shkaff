package ru.vldkr.shkaff.features.labelstudio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.features.labelstudio.domain.BarcodeElement
import ru.vldkr.shkaff.features.labelstudio.domain.ContentSource
import ru.vldkr.shkaff.features.labelstudio.domain.FieldElement
import ru.vldkr.shkaff.features.labelstudio.domain.ImageElement
import ru.vldkr.shkaff.features.labelstudio.domain.LabelElement
import ru.vldkr.shkaff.features.labelstudio.domain.PageSettings
import ru.vldkr.shkaff.features.labelstudio.domain.QrElement
import ru.vldkr.shkaff.features.labelstudio.domain.ScaleMode
import ru.vldkr.shkaff.features.labelstudio.domain.ShapeElement
import ru.vldkr.shkaff.features.labelstudio.domain.ShapeType
import ru.vldkr.shkaff.features.labelstudio.domain.TextAlign
import ru.vldkr.shkaff.features.labelstudio.domain.TextElement
import ru.vldkr.shkaff.features.labelstudio.domain.VAlign
import ru.vldkr.shkaff.features.labelstudio.domain.withPosition
import ru.vldkr.shkaff.features.labelstudio.domain.withSize

/**
 * Нижняя панель свойств: без выделения — параметры страницы/печати,
 * с выделением — свойства выбранного элемента.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InspectorSheet(
    element: LabelElement?,
    page: PageSettings,
    onUpdateElement: (LabelElement) -> Unit,
    onUpdatePage: (PageSettings) -> Unit,
    onDelete: () -> Unit,
    onDuplicate: () -> Unit,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (element == null) {
                PageEditor(page, onUpdatePage)
            } else {
                ElementEditor(element, onUpdateElement)
                HorizontalDivider()
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = onDuplicate) { Text("Дублировать") }
                    OutlinedButton(onClick = onDelete) { Text("Удалить") }
                }
            }
        }
    }
}

@Composable
private fun PageEditor(page: PageSettings, onUpdate: (PageSettings) -> Unit) {
    Text("Этикетка", style = MaterialTheme.typography.titleMedium)
    MmSlider("Ширина бумаги, мм", page.paperWidthMm, 40f, 80f) { onUpdate(page.copy(paperWidthMm = it)) }
    MmSlider("Печатная ширина, мм", page.printableWidthMm, 32f, 72f) { onUpdate(page.copy(printableWidthMm = it)) }
    MmSlider("Высота, мм (0 = авто)", page.labelHeightMm, 0f, 200f) { onUpdate(page.copy(labelHeightMm = it)) }
    MmSlider("Зазор между этикетками, мм", page.gapMm, 0f, 10f) { onUpdate(page.copy(gapMm = it)) }
    MmSlider("Отступ сверху, мм", page.marginTopMm, 0f, 10f) { onUpdate(page.copy(marginTopMm = it)) }
    MmSlider("Отступ снизу, мм", page.marginBottomMm, 0f, 10f) { onUpdate(page.copy(marginBottomMm = it)) }
    MmSlider("Плотность (1–15)", page.darkness.toFloat(), 1f, 15f) { onUpdate(page.copy(darkness = it.toInt())) }
    MmSlider("Подача после печати, строк", page.feedLines.toFloat(), 0f, 10f) { onUpdate(page.copy(feedLines = it.toInt())) }
    SwitchRow("Инвертировать (белое на чёрном)", page.invert) { onUpdate(page.copy(invert = it)) }
}

@Composable
private fun ElementEditor(el: LabelElement, onUpdate: (LabelElement) -> Unit) {
    Text(el.javaClass.simpleName, style = MaterialTheme.typography.titleMedium)
    MmSlider("X, мм", el.xMm, 0f, 58f) { onUpdate(el.withPosition(it, el.yMm)) }
    MmSlider("Y, мм", el.yMm, 0f, 200f) { onUpdate(el.withPosition(el.xMm, it)) }
    MmSlider("Ширина, мм", el.widthMm, 2f, 58f) { onUpdate(el.withSize(it, el.heightMm)) }
    MmSlider("Высота, мм", el.heightMm, 2f, 200f) { onUpdate(el.withSize(el.widthMm, it)) }

    when (el) {
        is QrElement -> {
            ContentSourceEditor(el.content) { onUpdate(el.copy(content = it)) }
            EnumChips("EC", listOf("L", "M", "Q", "H"), el.ecLevel) { onUpdate(el.copy(ecLevel = it)) }
            MmSlider("Масштаб", el.scale, 0.5f, 2f) { onUpdate(el.copy(scale = it)) }
            SwitchRow("Тихая зона", el.quietZoneModules > 0) { onUpdate(el.copy(quietZoneModules = if (it) 4 else 0)) }
        }
        is BarcodeElement -> {
            ContentSourceEditor(el.content) { onUpdate(el.copy(content = it)) }
            EnumChips(
                "Символика",
                listOf("CODE128", "CODE39", "EAN13", "EAN8", "DATAMATRIX", "PDF417"),
                el.symbology
            ) { onUpdate(el.copy(symbology = it)) }
            SwitchRow("Текст под кодом", el.showText) { onUpdate(el.copy(showText = it)) }
        }
        is TextElement -> {
            ContentSourceEditor(el.content) { onUpdate(el.copy(content = it)) }
            MmSlider("Размер, мм", el.sizeMm, 1.5f, 8f) { onUpdate(el.copy(sizeMm = it)) }
            EnumChips("Выравнивание", TextAlign.entries.map { it.name }, el.align.name) {
                onUpdate(el.copy(align = TextAlign.valueOf(it)))
            }
            EnumChips("По вертикали", VAlign.entries.map { it.name }, el.verticalAlign.name) {
                onUpdate(el.copy(verticalAlign = VAlign.valueOf(it)))
            }
            MmSlider("Строк (макс)", el.maxLines.toFloat(), 1f, 6f) { onUpdate(el.copy(maxLines = it.toInt())) }
            SwitchRow("Жирный", el.bold) { onUpdate(el.copy(bold = it)) }
            SwitchRow("Инверсный блок", el.background) { onUpdate(el.copy(background = it)) }
        }
        is FieldElement -> {
            TextFieldRow("Ключ поля", el.key) { onUpdate(el.copy(key = it)) }
            TextFieldRow("Подпись", el.label) { onUpdate(el.copy(label = it)) }
            TextFieldRow("Запасное значение", el.fallback) { onUpdate(el.copy(fallback = it)) }
            MmSlider("Размер, мм", el.sizeMm, 1.5f, 8f) { onUpdate(el.copy(sizeMm = it)) }
            SwitchRow("Показывать подпись", el.showLabel) { onUpdate(el.copy(showLabel = it)) }
        }
        is ImageElement -> {
            TextFieldRow("Путь к файлу", el.path) { onUpdate(el.copy(path = it)) }
            EnumChips("Масштаб", ScaleMode.entries.map { it.name }, el.scaleMode.name) {
                onUpdate(el.copy(scaleMode = ScaleMode.valueOf(it)))
            }
            SwitchRow("Дизеринг", el.dither) { onUpdate(el.copy(dither = it)) }
            MmSlider("Порог, 0–255", el.threshold.toFloat(), 0f, 255f) { onUpdate(el.copy(threshold = it.toInt())) }
        }
        is ShapeElement -> {
            EnumChips("Фигура", ShapeType.entries.map { it.name }, el.shape.name) {
                onUpdate(el.copy(shape = ShapeType.valueOf(it)))
            }
            MmSlider("Толщина, мм", el.strokeMm, 0.1f, 2f) { onUpdate(el.copy(strokeMm = it)) }
            SwitchRow("Заливка", el.filled) { onUpdate(el.copy(filled = it)) }
        }
    }
}

@Composable
private fun ContentSourceEditor(source: ContentSource, onChange: (ContentSource) -> Unit) {
    var type by remember(source) {
        mutableStateOf(
            when (source) {
                is ContentSource.Static -> "static"
                is ContentSource.Field -> "field"
                is ContentSource.Template -> "template"
            }
        )
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        FilterChip(selected = type == "static", onClick = { type = "static" }, label = { Text("Текст") })
        FilterChip(selected = type == "field", onClick = { type = "field" }, label = { Text("Поле") })
        FilterChip(selected = type == "template", onClick = { type = "template" }, label = { Text("Шаблон") })
    }
    when (type) {
        "static" -> TextFieldRow("Текст", (source as? ContentSource.Static)?.value ?: "") {
            onChange(ContentSource.Static(it))
        }
        "field" -> TextFieldRow("Ключ поля (name, code, …)", (source as? ContentSource.Field)?.key ?: "code") {
            onChange(ContentSource.Field(it))
        }
        "template" -> TextFieldRow("Шаблон, напр. {{name}} #{{code}}", (source as? ContentSource.Template)?.pattern ?: "") {
            onChange(ContentSource.Template(it))
        }
    }
}

@Composable
private fun MmSlider(label: String, value: Float, min: Float, max: Float, onChange: (Float) -> Unit) {
    Column {
        Text("$label: ${if (value == value.toInt().toFloat()) value.toInt() else String.format("%.1f", value)}",
            style = MaterialTheme.typography.bodySmall)
        Slider(
            value = value.coerceIn(min, max),
            onValueChange = onChange,
            valueRange = min..max
        )
    }
}

@Composable
private fun SwitchRow(label: String, checked: Boolean, onChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.bodyMedium)
        Switch(checked = checked, onCheckedChange = onChange)
    }
}

@Composable
private fun TextFieldRow(label: String, value: String, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = { Text(label) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
private fun EnumChips(label: String, options: List<String>, current: String, onChange: (String) -> Unit) {
    Column {
        Text(label, style = MaterialTheme.typography.bodySmall)
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            options.forEach { opt ->
                FilterChip(selected = opt == current, onClick = { onChange(opt) }, label = { Text(opt) })
            }
        }
    }
}