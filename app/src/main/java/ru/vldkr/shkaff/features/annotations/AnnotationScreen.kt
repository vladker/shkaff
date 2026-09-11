package ru.vldkr.shkaff.features.annotations

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color as GColor
import android.graphics.RectF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.LocationData
import ru.vldkr.shkaff.domain.visual.SchematicLayout
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.PhotoCapture
import ru.vldkr.shkaff.util.PhotoPickers
import ru.vldkr.shkaff.util.SchematicRenderer
import ru.vldkr.shkaff.util.rememberPhotoPickers
import ru.vldkr.shkaff.util.newId
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.text.rememberTextMeasurer
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class AnnotationVm(val storageId: String) : ViewModel() {

    data class Ann(
        val id: String,
        val locationId: String?,
        val label: String,
        val rect: RectF,
        val color: Int
    )

    data class Ui(
        val storage: StorageEntity? = null,
        val photoUri: String? = null,
        val aspectRatio: Float = 4f / 3f,
        val anns: List<Ann> = emptyList(),
        val locations: List<LocationEntity> = emptyList(),
        val drawingMode: Boolean = false,
        val schematicMode: Boolean = false,
        val selectedAnnId: String? = null
    )

    // режим рисования: схема используется, пока фото нет или выбрана вручную
    val schematic: Boolean get() = ui.value.schematicMode || ui.value.photoUri == null

    val ui = MutableStateFlow(Ui())

    class Factory(private val storageId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T = AnnotationVm(storageId) as T
    }

    private fun update(f: (Ui) -> Ui) { ui.value = f(ui.value) }

    init {
        viewModelScope.launch {
            val s = Deps.storages.byId(storageId)
            val ar = withContext(Dispatchers.IO) { photoAspect(s?.photo_path) }
        update {
            it.copy(
                    storage = s,
                    photoUri = s?.photo_path,
                    aspectRatio = ar
                )
            }
        }
        viewModelScope.launch {
            Deps.db.annotationDao().observeByStorage(storageId).collect { list ->
                update { it.copy(anns = list.map { a -> a.toAnn() }) }
            }
        }
        viewModelScope.launch {
            Deps.locations.observeByStorage(storageId).collect { list ->
                update { it.copy(locations = list) }
            }
        }
    }

    private fun photoAspect(path: String?): Float {
        if (path.isNullOrBlank()) return 4f / 3f
        return try {
            val opts = BitmapFactory.Options().apply { inJustDecodeBounds = true }
            BitmapFactory.decodeFile(path, opts)
            if (opts.outWidth > 0 && opts.outHeight > 0) opts.outWidth / opts.outHeight.toFloat() else 4f / 3f
        } catch (e: Exception) {
            4f / 3f
        }
    }

    fun setPhoto(path: String) {
        viewModelScope.launch {
            Deps.storages.setPhoto(storageId, path)
            val ar = withContext(Dispatchers.IO) { photoAspect(path) }
            update { it.copy(photoUri = path, aspectRatio = ar) }
        }
    }

    fun toggleDrawing() {
        update { it.copy(drawingMode = !it.drawingMode, selectedAnnId = null) }
    }

    fun toggleView() {
        update { it.copy(schematicMode = !it.schematicMode, drawingMode = false, selectedAnnId = null) }
    }

    fun select(id: String?) {
        update { it.copy(selectedAnnId = id) }
    }

    fun handleTap(norm: Offset): Ann? {
        val hit = ui.value.anns.firstOrNull { a ->
            a.rect.contains(norm.x, norm.y)
        }
        hit?.let { select(it.id) }
        return hit
    }

    fun finalizeRect(start: Offset, end: Offset) {
        val l = minOf(start.x, end.x).coerceIn(0f, 1f)
        val t = minOf(start.y, end.y).coerceIn(0f, 1f)
        val r = maxOf(start.x, end.x).coerceIn(0f, 1f)
        val b = maxOf(start.y, end.y).coerceIn(0f, 1f)
        val rect = RectF(
            (l * 1000).toInt() / 1000f,
            (t * 1000).toInt() / 1000f,
            (r * 1000).toInt() / 1000f,
            (b * 1000).toInt() / 1000f
        )
        if (rect.width() < 0.02f || rect.height() < 0.02f) {
            update { it.copy(drawingMode = false) }
            return
        }
        viewModelScope.launch {
            val existing = ui.value.anns.firstOrNull { a ->
                a.locationId != null &&
                    rectDiff(a.rect, rect) < 0.03f &&
                    Deps.locations.byId(a.locationId) != null
            }
            val loc = existing?.locationId?.let { Deps.locations.byId(it) } ?: createLocation()
            val now = System.currentTimeMillis()
            val e = AnnotationEntity(
                id = newId(),
                storage_id = storageId,
                location_id = loc.id,
                shape = "rect",
                points = """[[${rect.left},${rect.top}],[${rect.right},${rect.bottom}]]""",
                label = loc.label.ifBlank { loc.name },
                color = "#FFB300",
                z_order = 0,
                created_at = now,
                updated_at = now,
                deleted_at = null,
                device_last_modified = Deps.deviceId
            )
            Deps.db.annotationDao().upsert(e)
            update { it.copy(drawingMode = false) }
        }
    }

    private fun rectDiff(a: RectF, b: RectF): Float =
        max(abs(a.centerX() - b.centerX()), abs(a.centerY() - b.centerY()))

    private suspend fun createLocation(): LocationEntity {
        val n = Deps.locations.allByStorage(storageId).size + 1
        return Deps.locations.create(
            LocationData(storageId = storageId, label = "Ящик $n", name = "")
        )
    }

    fun deleteAnn(id: String) {
        viewModelScope.launch {
            Deps.db.annotationDao().softDelete(id, System.currentTimeMillis(), Deps.deviceId)
            update { it.copy(selectedAnnId = null) }
        }
    }
}

private fun AnnotationEntity.toAnn(): AnnotationVm.Ann {
    val pts = try {
        val arr = JSONArray(points)
        (0 until arr.length()).map { i ->
            val p = arr.getJSONArray(i)
            Offset(p.getDouble(0).toFloat(), p.getDouble(1).toFloat())
        }
    } catch (e: Exception) {
        emptyList()
    }
    val rect = if (pts.size >= 2) {
        RectF(
            minOf(pts[0].x, pts[1].x),
            minOf(pts[0].y, pts[1].y),
            maxOf(pts[0].x, pts[1].x),
            maxOf(pts[0].y, pts[1].y)
        )
    } else RectF(0.1f, 0.1f, 0.4f, 0.3f)
    return AnnotationVm.Ann(
        id = id,
        locationId = location_id,
        label = label,
        rect = rect,
        color = try {
            GColor.parseColor(color)
        } catch (e: Exception) {
            0xFFFFB300.toInt()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnotationScreen(nav: NavController, storageId: String) {
    val vm: AnnotationVm = viewModel(factory = AnnotationVm.Factory(storageId))
    val ui by vm.ui.collectAsState()
    var actionAnn by remember { mutableStateOf<AnnotationVm.Ann?>(null) }
    var showPhotoDialog by remember { mutableStateOf(false) }

    val pickers: PhotoPickers = rememberPhotoPickers(
        onCaptured = { f -> vm.setPhoto(f.absolutePath) },
        onPicked = { f -> vm.setPhoto(f.absolutePath) }
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Разметка: ${ui.storage?.name ?: "хранилище"}") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = { showPhotoDialog = true }) {
                        Text("Фото", style = MaterialTheme.typography.labelLarge)
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
            if (ui.photoUri == null) {
                Card(Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Column(Modifier.padding(16.dp)) {
                        Text("Сфотографируйте шкаф, полку или стол", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(4.dp))
                        Text(
                            "Пока фото нет, ящики отрисовываются стандартными блоками — разметку можно рисовать и на схеме.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(Modifier.height(12.dp))
                        Button(onClick = { showPhotoDialog = true }, modifier = Modifier.fillMaxWidth()) {
                            Text("Добавить фото")
                        }
                    }
                }
            }

            if (ui.photoUri != null) {
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.padding(vertical = 8.dp)) {
                    FilterChip(selected = !ui.schematicMode, onClick = { if (ui.schematicMode) vm.toggleView() }, label = { Text("Фото") })
                    FilterChip(selected = ui.schematicMode, onClick = { if (!ui.schematicMode) vm.toggleView() }, label = { Text("Схема") })
                }
            }

            AnnotationPhotoArea(vm, ui, onAction = { actionAnn = it })

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = { vm.toggleDrawing() },
                    modifier = Modifier.weight(1f),
                    enabled = ui.photoUri != null || ui.locations.isNotEmpty()
                ) {
                    Text(if (ui.drawingMode) "Готово" else "Нарисовать ящик")
                }
                OutlinedButton(
                    onClick = { vm.deleteAnn(ui.selectedAnnId!!) },
                    enabled = ui.selectedAnnId != null,
                    modifier = Modifier.weight(1f)
                ) { Text("Стереть") }
            }

            if (ui.anns.isNotEmpty()) {
                Spacer(Modifier.height(16.dp))
                SectionTitle("Ящики в разметке")
                ui.anns.forEach { a ->
                    val selected = a.id == ui.selectedAnnId
                    Card(
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clip(MaterialTheme.shapes.medium)
                            .border(
                                width = if (selected) 2.dp else 0.dp,
                                color = if (selected) MaterialTheme.colorScheme.primary else Color.Transparent
                            )
                    ) {
                        Row(Modifier.padding(12.dp)) {
                            Box(
                                Modifier
                                    .size(14.dp)
                                    .clip(RoundedCornerShape(4.dp))
                                    .background(Color(a.color))
                            )
                            Column(Modifier.padding(start = 10.dp).weight(1f)) {
                                Text(a.label.ifBlank { "Ящик" }, style = MaterialTheme.typography.titleSmall)
                                Text(
                                    if (a.locationId != null) "связан с ящиком" else "не связан",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            TextButton(onClick = { vm.select(a.id) }) { Text("Выбрать") }
                        }
                    }
                }
            }

            Text(
                "Подсказка: коснитесь ящика на фото или схеме — откроются действия: добавить вещь, открыть ящик, этикетка.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        actionAnn?.let { a ->
            AnnActionsDialog(
                ann = a,
                nav = nav,
                onDismiss = { actionAnn = null }
            )
        }

        if (showPhotoDialog) {
            AlertDialog(
                onDismissRequest = { showPhotoDialog = false },
                title = { Text("Фото хранилища") },
                text = { Text("Сфотографировать сейчас или выбрать из галереи?") },
                confirmButton = {
                    TextButton(onClick = {
                        showPhotoDialog = false
                        pickers.takePhoto()
                    }) { Text("Камера") }
                },
                dismissButton = {
                    TextButton(onClick = {
                        showPhotoDialog = false
                        pickers.pickFromGallery()
                    }) { Text("Галерея") }
                }
            )
        }
    }
}

@Composable
fun AnnotationPhotoArea(
    vm: AnnotationVm,
    ui: AnnotationVm.Ui,
    onAction: (AnnotationVm.Ann) -> Unit
) {
    val anns = ui.anns
    val drawingMode = ui.drawingMode
    val selectedId = ui.selectedAnnId
    val showSchema = ui.schematicMode || ui.photoUri == null
    val key = "${ui.photoUri}|${ui.schematicMode}|${ui.locations.joinToString { l -> l.id } }"

    var bmp by remember(key) { mutableStateOf<Bitmap?>(null) }
    var err by remember { mutableStateOf<String?>(null) }
    LaunchedEffect(key) {
        bmp = withContext(Dispatchers.IO) {
            try {
                if (showSchema) {
                    val blocks = SchematicLayout.layout(
                        ui.locations.map { l -> l.id to (l.label.ifBlank { l.name }.ifBlank { "Ящик" }) }
                    )
                    SchematicRenderer.render(blocks, 1080, 810)
                } else {
                    val path = ui.photoUri ?: return@withContext null
                    PhotoCapture.maxBmp(BitmapFactory.decodeFile(path))
                }
            } catch (e: Exception) {
                err = e.message
                null
            }
        }
    }
    val b = bmp
    if (b == null) {
        Text(err ?: "Загрузка…", style = MaterialTheme.typography.bodyMedium)
        return
    }

    var drawing by remember { mutableStateOf(RectF()) }
    var drawStart by remember { mutableStateOf<Offset?>(null) }
    var displaySize by remember { mutableStateOf(Size(0f, 0f)) }
    val textMeasurer = rememberTextMeasurer()

    Box(
        Modifier
            .fillMaxWidth()
            .aspectRatio(ui.aspectRatio)
            .clip(MaterialTheme.shapes.medium)
            .onSizeChanged { displaySize = Size(it.width.toFloat(), it.height.toFloat()) }
    ) {
        Image(
            bitmap = b.asImageBitmap(),
            contentDescription = "Фото хранилища",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

        Canvas(Modifier.fillMaxSize()) {
            val s = displaySize
            if (s.width == 0f) return@Canvas
            fun normRect(r: RectF): RectF = RectF(
                r.left * s.width, r.top * s.height, r.right * s.width, r.bottom * s.height
            )

            anns.forEach { a ->
                val r = normRect(a.rect)
                val isSel = a.id == selectedId
                val c = Color(a.color)
                val strokeC = if (isSel) Color(0xFF2196F3) else c
                drawRect(color = c, topLeft = Offset(r.left, r.top), size = Size(r.width(), r.height()), alpha = 0.18f)
                drawRect(
                    color = strokeC,
                    topLeft = Offset(r.left, r.top),
                    size = Size(r.width(), r.height()),
                    style = Stroke(if (isSel) 4f else 3f)
                )
                if (a.label.isNotBlank()) {
                    val pad = 10f
                    val fontSize = (r.height() * 0.24f).coerceIn(14f, 44f)
                    val style = TextStyle(color = Color.White, fontSize = fontSize.sp)
                    val textW = textMeasurer.measure(a.label, style).size.width
                    val w = minOf(r.width(), textW + pad * 2)
                    val h = fontSize + pad * 0.8f
                    drawRoundRect(
                        color = strokeC,
                        topLeft = Offset(r.left, r.top),
                        size = Size(w, h),
                        cornerRadius = CornerRadius(6f)
                    )
                    drawText(textMeasurer, text = a.label, topLeft = Offset(r.left + pad, r.top + pad * 0.6f), style = style)
                }
            }

            if (drawingMode && drawing.width() > 0f && drawing.height() > 0f) {
                drawRect(color = Color(0xFFFFB300), topLeft = Offset(drawing.left, drawing.top), size = Size(drawing.width(), drawing.height()), alpha = 0.25f)
                drawRect(
                    color = Color(0xFFFFB300),
                    topLeft = Offset(drawing.left, drawing.top),
                    size = Size(drawing.width(), drawing.height()),
                    style = Stroke(3f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f), 0f))
                )
            }
        }

        Box(
            Modifier
                .fillMaxSize()
                .pointerInput(drawingMode) {
                    if (drawingMode) {
                        detectDragGestures(
                            onDragStart = { start ->
                                drawStart = start
                                drawing = RectF(start.x, start.y, start.x, start.y)
                            },
                            onDrag = { change, _ ->
                                val st = drawStart ?: return@detectDragGestures
                                drawing = RectF(
                                    minOf(st.x, change.position.x),
                                    minOf(st.y, change.position.y),
                                    maxOf(st.x, change.position.x),
                                    maxOf(st.y, change.position.y)
                                )
                            },
                            onDragEnd = {
                                if (displaySize.width > 0f && drawing.width() > 0f && drawing.height() > 0f) {
                                    val nst = Offset(drawing.left / displaySize.width, drawing.top / displaySize.height)
                                    val nend = Offset(drawing.right / displaySize.width, drawing.bottom / displaySize.height)
                                    vm.finalizeRect(nst, nend)
                                }
                                drawStart = null
                                drawing = RectF()
                            },
                            onDragCancel = {
                                drawStart = null
                                drawing = RectF()
                            }
                        )
                    } else {
                        detectTapGestures { pos ->
                            if (displaySize.width > 0f) {
                                val norm = Offset(pos.x / displaySize.width, pos.y / displaySize.height)
                                vm.handleTap(norm)?.let { onAction(it) }
                            }
                        }
                    }
                }
        )
    }
}

@Composable
fun AnnActionsDialog(
    ann: AnnotationVm.Ann,
    nav: NavController,
    onDismiss: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(ann.label.ifBlank { "Ящик" }) },
        text = {
            Text(
                if (ann.locationId != null) "Связан с ящиком в базе" else "Ящик ещё не создан в базе",
                style = MaterialTheme.typography.bodyMedium
            )
        },
        confirmButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                TextButton(
                    onClick = {
                        onDismiss()
                        if (ann.locationId != null) nav.navigate("location/${ann.locationId}")
                    },
                    enabled = ann.locationId != null
                ) { Text("Ящик") }
                TextButton(
                    onClick = {
                        onDismiss()
                        if (ann.locationId != null) nav.navigate("item-form/0/${ann.locationId}")
                    },
                    enabled = ann.locationId != null
                ) { Text("Вещь") }
                TextButton(
                    onClick = {
                        onDismiss()
                        nav.navigate("labels/0/0")
                    }
                ) { Text("Этикетка") }
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Закрыть") }
        }
    )
}
