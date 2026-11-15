package ru.vldkr.shkaff.ui.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.capacity.CapacityUsage
import ru.vldkr.shkaff.domain.levels.Levels

@Composable
fun SectionTitle(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier.padding(top = 16.dp, bottom = 4.dp)
    )
}

@Composable
fun EmptyState(
    text: String,
    actionLabel: String? = null,
    onAction: (() -> Unit)? = null
) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
            // US-O8: пустое состояние подсказывает, что делать дальше
            if (actionLabel != null && onAction != null) {
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = onAction,
                    modifier = Modifier
                        .heightIn(min = 48.dp)
                        .padding(horizontal = 8.dp)
                ) {
                    Text(actionLabel)
                }
            }
        }
    }
}

// T-040: сбой подписки (Room/DAO) — не пустой список: показываем причину и «Повторить».
@Composable
fun ErrorState(message: String, onRetry: (() -> Unit)? = null) {
    Box(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 40.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                Icons.Filled.Warning,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.error
            )
            Spacer(Modifier.height(8.dp))
            Text(
                message,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center
            )
            if (onRetry != null) {
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = onRetry,
                    modifier = Modifier
                        .heightIn(min = 48.dp)
                        .padding(horizontal = 8.dp)
                ) {
                    Text("Повторить")
                }
            }
        }
    }
}

@Composable
fun ConfirmDialog(
    title: String,
    message: String,
    confirmLabel: String = "Удалить",
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            TextButton(onClick = { onConfirm(); onDismiss() }) {
                Text(confirmLabel, color = MaterialTheme.colorScheme.error)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Отмена") }
        }
    )
}

@Composable
fun FieldRow(
    label: String,
    required: Boolean = false,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(Modifier.padding(vertical = 4.dp)) {
        Text(
            label + if (required) " *" else "",
            style = MaterialTheme.typography.labelLarge
        )
        content()
    }
}

fun parseOptions(json: String?): List<String> = AttrJson.parseOptions(json)

@Composable
fun CategoryPicker(
    options: List<String>,
    value: String,
    onChange: (String) -> Unit,
    blankLabel: String = "Без категории"
) {
    Column(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            FilterChip(
                selected = value.isEmpty(),
                onClick = { onChange("") },
                label = { Text(blankLabel) },
                modifier = Modifier.padding(end = 8.dp)
            )
            options.forEach { opt ->
                FilterChip(
                    selected = value == opt,
                    onClick = { onChange(if (value == opt) "" else opt) },
                    label = { Text(opt) },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }
}

// Категория — выпадающий список (этап «Поля» мастера добавления).
@Composable
fun CategoryDropdown(
    options: List<String>,
    value: String,
    onChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        OutlinedButton(onClick = { expanded = true }, modifier = Modifier.weight(1f)) {
            Text(value.ifBlank { "Без категории" }, modifier = Modifier.weight(1f), maxLines = 1)
            Spacer(Modifier.width(8.dp))
            Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
        }
        if (value.isNotEmpty()) {
            TextButton(onClick = { onChange("") }) { Text("Сбросить") }
        }
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(text = { Text("Без категории") }, onClick = { expanded = false; onChange("") })
        options.forEach { opt ->
            DropdownMenuItem(text = { Text(opt) }, onClick = { expanded = false; onChange(opt) })
        }
    }
}

@Composable
fun AttrFields(
    defs: List<AttributeDefEntity>,
    values: Map<String, String>,
    onRemove: ((AttributeDefEntity) -> Unit)? = null,
    onChange: (String, String) -> Unit
) {
    if (defs.isEmpty()) return
    Column(Modifier.fillMaxWidth()) {
        defs.forEach { def ->
            if (onRemove != null) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = { onRemove(def) }) {
                        Icon(Icons.Filled.Close, contentDescription = "Убрать поле")
                    }
                }
            }
            val v = values[def.key] ?: ""
            when (def.type) {
                "number" -> FieldRow(def.label, def.required) {
                    OutlinedTextField(
                        value = v,
                        onValueChange = { onChange(def.key, it) },
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = androidx.compose.foundation.text.KeyboardOptions(keyboardType = KeyboardType.Number),
                        singleLine = true
                    )
                }

                "bool" -> Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Text(def.label, modifier = Modifier.weight(1f))
                    Switch(checked = v == "true" || v == "1", onCheckedChange = { onChange(def.key, if (it) "true" else "") })
                }

                "select" -> SelectField(def, v, onChange)

                "date" -> FieldRow(def.label, def.required) {
                    OutlinedTextField(
                        value = v,
                        onValueChange = { onChange(def.key, it) },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("ГГГГ-ММ-ДД") },
                        singleLine = true
                    )
                }

                else -> FieldRow(def.label, def.required) {
                    OutlinedTextField(
                        value = v,
                        onValueChange = { onChange(def.key, it) },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                }
            }
        }
    }
}

@Composable
private fun SelectField(def: AttributeDefEntity, value: String, onChange: (String, String) -> Unit) {
    val options = remember(def.options) { parseOptions(def.options) }
    val scope = rememberCoroutineScope()
    var adding by remember { mutableStateOf(false) }
    var newOption by remember { mutableStateOf("") }
    val busy = remember { mutableStateOf(false) }
    var addError by remember { mutableStateOf<String?>(null) }

    fun commitOption() {
        val t = newOption.trim()
        if (t.isEmpty() || busy.value) return
        busy.value = true
        addError = null
        scope.launch {
            // T-023: запись словаря не должна ронять процесс и значение
            // применяется только после успешного addOption.
            val ok = try {
                Deps.attributes.addOption(def.id, t, Deps.deviceId)
            } catch (e: Exception) {
                false
            } finally {
                busy.value = false
            }
            if (ok) {
                onChange(def.key, t)
                newOption = ""
                adding = false
            } else {
                addError = "Словарь не обновлён — значение не применено"
            }
        }
    }

    Column(Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Text(
            def.label + if (def.required) " *" else "",
            style = MaterialTheme.typography.labelLarge
        )
        if (adding) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            ) {
                OutlinedTextField(
                    value = newOption,
                    onValueChange = { newOption = it },
                    modifier = Modifier.weight(1f),
                    placeholder = { Text("Новое значение") },
                    singleLine = true
                )
                TextButton(onClick = { commitOption() }, modifier = Modifier.padding(start = 4.dp)) {
                    Text("Добавить")
                }
                IconButton(onClick = { adding = false; newOption = ""; addError = null }) {
                    Icon(Icons.Filled.Close, contentDescription = "Отмена")
                }
            }
            addError?.let {
                Text(
                    it,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                options.forEach { opt ->
                    FilterChip(
                        selected = value == opt,
                        onClick = { onChange(def.key, if (value == opt) "" else opt) },
                        label = { Text(opt) },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
                FilterChip(
                    selected = false,
                    onClick = { adding = true },
                    label = { Text("+ значение") },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }
}

// IDs самого узла и всех его потомков — чтобы при выборе родителя исключить цикл
fun <T> subtreeIds(
    rootId: String,
    all: List<T>,
    idOf: (T) -> String,
    parentOf: (T) -> String?
): Set<String> {
    val byParent = all.groupBy { parentOf(it) ?: "" }
    val result = mutableSetOf<String>()
    val queue = ArrayDeque<String>()
    queue.add(rootId)
    while (queue.isNotEmpty()) {
        byParent[queue.removeFirst()]?.forEach { child ->
            val cid = idOf(child)
            if (result.add(cid)) queue.add(cid)
        }
    }
    return result
}

private data class PickerRow(val text: String, val id: String?, val depth: Int)

// Плоский список строк дерева (сироты — на верхнем уровне, защита от циклов)
private fun <T> treeRows(
    all: List<T>,
    labelOf: (T) -> String,
    idOf: (T) -> String,
    parentOf: (T) -> String?
): List<PickerRow> {
    val byId = all.associateBy { idOf(it) }
    val byParent = all.groupBy { parentOf(it) ?: "" }
    val out = mutableListOf<PickerRow>()
    val seen = mutableSetOf<String>()
    fun rec(id: String, depth: Int) {
        if (!seen.add(id)) return
        byId[id]?.let { out += PickerRow(labelOf(it), id, depth) }
        (byParent[id] ?: emptyList()).forEach { rec(idOf(it), depth + 1) }
    }
    all.forEach { node ->
        val pid = parentOf(node)
        if (pid == null || pid !in byId) rec(idOf(node), 0)
    }
    return out
}

@Composable
fun LocationPickerDialog(
    locations: List<LocationEntity>,
    currentId: String?,
    onPick: (String?) -> Unit,
    onDismiss: () -> Unit,
    title: String = "Где хранится?",
    emptyLabel: String = "— без ящика —",
    excludeIds: Set<String> = emptySet()
) {
    val visible = locations.filter { it.id !in excludeIds }
    val rows = treeRows(
        visible,
        { loc -> loc.label.ifBlank { loc.name }.ifBlank { "Ящик" } },
        { loc -> loc.id },
        { loc -> loc.parent_id }
    )
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                LocationOption(emptyLabel, null, currentId, onPick, 0)
                rows.forEach { r -> LocationOption(r.text, r.id, currentId, onPick, r.depth) }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}

@Composable
fun StoragePickerDialog(
    storages: List<StorageEntity>,
    currentId: String?,
    onPick: (String?) -> Unit,
    onDismiss: () -> Unit,
    title: String = "Родительское хранилище",
    emptyLabel: String = "— без родителя —",
    excludeIds: Set<String> = emptySet()
) {
    val visible = storages.filter { it.id !in excludeIds }
    val rows = treeRows(
        visible,
        { s -> s.name },
        { s -> s.id },
        { s -> s.parent_id }
    )
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            Column {
                LocationOption(emptyLabel, null, currentId, onPick, 0)
                rows.forEach { r -> LocationOption(r.text, r.id, currentId, onPick, r.depth) }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}

@Composable
private fun LocationOption(text: String, id: String?, currentId: String?, onPick: (String?) -> Unit, depth: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp * depth, top = 6.dp, bottom = 6.dp)
            .clickable { onPick(id) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text, modifier = Modifier.weight(1f))
        if (id == currentId) {
            Text("✓", color = MaterialTheme.colorScheme.primary)
        }
    }
}

@Composable
fun LocationMap(): Map<String, LocationEntity> {
    val map = remember { mutableStateOf<Map<String, LocationEntity>>(emptyMap()) }
    LaunchedEffect(Unit) {
        Deps.locations.observeAll().collect { list ->
            map.value = list.associateBy { it.id }
        }
    }
    return map.value
}

// Заполненность хранилища/ящика (US-C3/C4): полосы объёма и массы + статус.
// T-006: «добавление блокировано» для ящика — правда: ItemRepository.create/update/moveTo
// отказывают, когда ящик помечен «полным». Для хранилища пометка только информационная.
@Composable
fun CapacitySection(usage: CapacityUsage, modifier: Modifier = Modifier, isLocation: Boolean = true) {
    Column(modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        val volText = usage.capacityVolumeLiters?.let {
            "Объём: ${fmt1(usage.volumeLiters)} / ${fmt1(it)} л"
        } ?: "Объём: ${fmt1(usage.volumeLiters)} л (ёмкость не задана)"
        val wtText = usage.capacityWeightKg?.let {
            "Масса: ${fmt1(usage.weightKg)} / ${fmt1(it)} кг"
        } ?: "Масса: ${fmt1(usage.weightKg)} кг (грузоподъёмность не задана)"

        val over = usage.overLimit()
        val overColor = if (over) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
        val labelStyle = MaterialTheme.typography.bodyMedium.copy(color = overColor)

        Text(volText, style = labelStyle)
        usage.volumeRatio()?.let { ratio ->
            LinearProgressIndicator(
                progress = { ratio.toFloat().coerceIn(0f, 1f) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                color = if (ratio >= 1.0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
        Text(wtText, style = labelStyle, modifier = Modifier.padding(top = 4.dp))
        usage.weightRatio()?.let { ratio ->
            LinearProgressIndicator(
                progress = { ratio.toFloat().coerceIn(0f, 1f) },
                modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp),
                color = if (ratio >= 1.0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }
        if (usage.isFull) {
            Text(
                if (isLocation) "Ящик помечен «полным» — добавление и перекладка вещей блокированы"
                else "Хранилище помечено «полным»",
                style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.error
            )
        } else if (usage.dontFillToBrim) {
            Text("«Не набивать до упора» — резерв места", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

private fun fmt1(v: Double): String = if (v >= 100) v.toInt().toString() else "%.1f".format(v)

// Активная роль (US-G1, П0.2/T-009): наблюдаемое состояние ActiveRole — UI перестраивается
// сразу при смене профиля и не мигает VIEW до загрузки.
@Composable
fun rememberRole(): Role = ActiveRole.role.collectAsState().value

// Уровень иерархии (US-C1): чипы с базовой цепочкой + свободный ввод своего уровня.
// Одно поле ввода — единый источник значения; чип подставляет/убирает предустановку.
@Composable
fun LevelPicker(current: String, onChange: (String) -> Unit) {
    var custom by remember(current) { mutableStateOf(current) }
    Column(Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = custom,
            onValueChange = { s ->
                custom = s
                onChange(s)
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(Levels.chain.joinToString(" / ")) },
            singleLine = true
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(top = 4.dp)
        ) {
            Levels.chain.forEach { lvl ->
                FilterChip(
                    selected = custom == lvl,
                    onClick = {
                        custom = if (custom == lvl) "" else lvl
                        onChange(custom)
                    },
                    label = { Text(lvl) },
                    modifier = Modifier.padding(end = 8.dp)
                )
            }
        }
    }
}

// Хлебные крошки пути: «Корень › Шкаф › Полка».
@Composable
fun CrumbPath(chain: List<String>) {
    if (chain.isEmpty()) return
    Text(
        chain.joinToString(" › "),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        modifier = Modifier.padding(top = 4.dp)
    )
}

// US-L21: Undo деструктивного действия — Snackbar «ОТМЕНИТЬ» на ~5 секунд.
// showSnackbar с длительностью Long (≈5.5с) сам закрывается по таймауту или по нажатию
// действия. Возвращает true, если пользователь успел нажать «ОТМЕНИТЬ» (тогда onUndo
// уже выполнен, напр. restore).
suspend fun SnackbarHostState.undo(
    message: String,
    onUndo: suspend () -> Unit
): Boolean {
    val result = showSnackbar(
        message = message,
        actionLabel = "ОТМЕНИТЬ",
        duration = SnackbarDuration.Long
    )
    return if (result == SnackbarResult.ActionPerformed) {
        onUndo()
        true
    } else {
        false
    }
}

// US-O8: skeleton loading (shimmer) без новых зависимостей — пульсирующий блок.
@Composable
fun ShimmerBar(modifier: Modifier = Modifier) {
    val transition = rememberInfiniteTransition(label = "shimmer")
    val alpha by transition.animateFloat(
        initialValue = 0.35f,
        targetValue = 0.85f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 900),
            repeatMode = RepeatMode.Reverse
        ),
        label = "shimmerAlpha"
    )
    Box(
        modifier
            .alpha(alpha)
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(6.dp))
    )
}

// US-O8: skeleton строки списка вещей — фото 1:1 + две строки текста.
@Composable
fun ItemSkeletonRow(modifier: Modifier = Modifier) {
    Row(
        modifier.fillMaxWidth().padding(vertical = 8.dp, horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ShimmerBar(Modifier.size(56.dp))
        Spacer(Modifier.width(12.dp))
        Column(Modifier.weight(1f).padding(vertical = 3.dp)) {
            ShimmerBar(Modifier.fillMaxWidth().height(14.dp))
            Spacer(Modifier.height(6.dp))
            ShimmerBar(Modifier.width(160.dp).height(12.dp))
        }
    }
}

// US-O8: список skeleton-строк вместо «Загрузка…».
@Composable
fun ListSkeleton(rows: Int = 5, modifier: Modifier = Modifier) {
    Column(modifier) {
        repeat(rows) { ItemSkeletonRow() }
    }
}

// T-040: sealed UiState(Loading|Error|Success) переехал в ui/state/ListFeed.kt — там он
// реально используется подписками списков (был объявлен и не применялся нигде).
