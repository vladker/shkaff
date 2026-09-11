package ru.vldkr.shkaff.features.annotations

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.RectF
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import org.json.JSONArray
import ru.vldkr.shkaff.data.db.AnnotationEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.visual.SchematicBlock
import ru.vldkr.shkaff.domain.visual.SchematicLayout
import ru.vldkr.shkaff.util.PhotoCapture

// US-C2: «Визуализация хранилищ». Три режима: фото, загружаемое изображение (и фото,
// и изображение из галереи лежат в storage.photo_path) и отрисовка стандартными блоками
// прямо в приложении. Кликабельные области — аннотации из редактора разметки — работают
// поверх любого режима: тап по прямоугольнику или по блоку схемы открывает ящик.

private data class ViewerAnn(
    val id: String,
    val locationId: String?,
    val label: String,
    val rect: RectF,
    val color: Long
)

private fun AnnotationEntity.toViewerAnn(): ViewerAnn {
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
    return ViewerAnn(
        id = id,
        locationId = location_id,
        label = label,
        rect = rect,
        color = try {
            android.graphics.Color.parseColor(color).toLong()
        } catch (e: Exception) {
            0xFFFFB300
        }
    )
}

@Composable
fun StorageVisualization(
    storageId: String,
    onOpenLocation: (String) -> Unit,
    onEdit: () -> Unit,
    modifier: Modifier = Modifier
) {
    val storage by Deps.storages.observeAll().map { list -> list.firstOrNull { it.id == storageId } }.collectAsState(initial = null)
    val anns by Deps.db.annotationDao().observeByStorage(storageId).collectAsState(initial = emptyList())
    val locations by Deps.locations.observeByStorage(storageId).collectAsState(initial = emptyList())

    val photoPath = storage?.photo_path
    var mode by rememberSaveable { mutableStateOf("photo") }
    // если фото пропало — гарантированно показываем схему
    LaunchedEffect(photoPath) {
        if (photoPath.isNullOrBlank() && mode == "photo") mode = "schema"
    }
    val isSchema = mode == "schema"
    val showToggle = !photoPath.isNullOrBlank()

    val blocks = remember(locations) {
        SchematicLayout.layout(locations.map { l -> l.id to (l.label.ifBlank { l.name }.ifBlank { "Ящик" }) })
    }
    val viewAnns = remember(anns) { anns.map { it.toViewerAnn() } }

    Card(modifier.fillMaxWidth()) {
        Column(Modifier.fillMaxWidth().padding(16.dp)) {
            Row(Modifier.fillMaxWidth()) {
                Text(
                    if (photoPath.isNullOrBlank())
                        "Фото не задано — показываем схему ящиков."
                    else
                        "Кликните по ящику на фото или схеме, чтобы открыть его.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.padding(top = 12.dp))
            Row {
                Button(onClick = onEdit) { Text("Разметка ящиков") }
                if (showToggle) {
                    Spacer(Modifier.padding(start = 8.dp))
                    FilterChip(selected = !isSchema, onClick = { mode = "photo" }, label = { Text("Фото") })
                    Spacer(Modifier.padding(start = 8.dp))
                    FilterChip(selected = isSchema, onClick = { mode = "schema" }, label = { Text("Схема") })
                }
            }
            Spacer(Modifier.padding(top = 12.dp))

            if (isSchema) {
                SchematicView(blocks, viewAnns, onOpenLocation)
            } else {
                PhotoView(photoPath, viewAnns, onOpenLocation)
            }
        }
    }
}

@Composable
private fun SchematicView(
    blocks: List<SchematicBlock>,
    anns: List<ViewerAnn>,
    onOpenLocation: (String) -> Unit
) {
    var boxSize by remember { mutableStateOf(Size(0f, 0f)) }
    val textMeasurer = rememberTextMeasurer()
    Box(
        Modifier
            .fillMaxWidth()
            .aspectRatio(4f / 3f)
            .clip(MaterialTheme.shapes.medium)
            .onSizeChanged { boxSize = Size(it.width.toFloat(), it.height.toFloat()) }
    ) {
        Canvas(Modifier.fillMaxSize()) {
            val w = boxSize.width
            val h = boxSize.height
            if (w == 0f) return@Canvas
            blocks.forEach { b ->
                val r = RectF(b.rect.left * w, b.rect.top * h, b.rect.right * w, b.rect.bottom * h)
                drawRoundRect(
                    color = Color(0xFFE3F2FD),
                    topLeft = Offset(r.left, r.top),
                    size = Size(r.width(), r.height()),
                    cornerRadius = CornerRadius(10f)
                )
                drawRoundRect(
                    color = Color(0xFF90CAF9),
                    topLeft = Offset(r.left, r.top),
                    size = Size(r.width(), r.height()),
                    cornerRadius = CornerRadius(10f),
                    style = Stroke(2f)
                )
                val fontSize = (r.height() * 0.32f).coerceIn(12f, 44f)
                val style = TextStyle(color = Color(0xFF0D47A1), fontSize = fontSize.sp)
                val text = textMeasurer.measure(b.label, style)
                drawText(
                    textMeasurer,
                    text = b.label,
                    topLeft = Offset(r.centerX() - text.size.width / 2f, r.centerY() - text.size.height / 2f),
                    style = style,
                    maxLines = 1
                )
            }
        }
        Canvas(Modifier.fillMaxSize()) {
            drawAnnOverlay(anns, textMeasurer, boxSize)
        }
        Box(
            Modifier
                .fillMaxSize()
                .pointerInput(blocks, anns) {
                    detectTapGestures { pos ->
                        if (boxSize.width == 0f) return@detectTapGestures
                        val norm = Offset(pos.x / boxSize.width, pos.y / boxSize.height)
                        openTarget(norm, anns, blocks, onOpenLocation)
                    }
                }
        )
    }
}

@Composable
private fun PhotoView(
    photoPath: String?,
    anns: List<ViewerAnn>,
    onOpenLocation: (String) -> Unit
) {
    val path = photoPath
    if (path.isNullOrBlank()) {
        Text("Фото не задано", style = MaterialTheme.typography.bodyMedium)
        return
    }
    var bmp by remember(path) { mutableStateOf<Bitmap?>(null) }
    if (bmp == null) {
        LaunchedEffect(path) {
            bmp = withContext(Dispatchers.IO) {
                try {
                    PhotoCapture.maxBmp(BitmapFactory.decodeFile(path))
                } catch (e: Exception) {
                    null
                }
            }
        }
    }
    val b = bmp
    if (b == null) {
        Text("Не удалось загрузить фото", style = MaterialTheme.typography.bodyMedium)
        return
    }
    var boxSize by remember { mutableStateOf(Size(0f, 0f)) }
    val textMeasurer = rememberTextMeasurer()
    Box(
        Modifier
            .fillMaxWidth()
            .aspectRatio(b.width.toFloat() / b.height.toFloat())
            .clip(MaterialTheme.shapes.medium)
            .onSizeChanged { boxSize = Size(it.width.toFloat(), it.height.toFloat()) }
    ) {
        Image(
            bitmap = b.asImageBitmap(),
            contentDescription = "Фото хранилища",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Canvas(Modifier.fillMaxSize()) {
            drawAnnOverlay(anns, textMeasurer, boxSize)
        }
        Box(
            Modifier
                .fillMaxSize()
                .pointerInput(anns) {
                    detectTapGestures { pos ->
                        if (boxSize.width == 0f) return@detectTapGestures
                        val norm = Offset(pos.x / boxSize.width, pos.y / boxSize.height)
                        anns.lastOrNull { it.rect.contains(norm.x, norm.y) }?.let { a ->
                            if (a.locationId != null) onOpenLocation(a.locationId)
                        }
                    }
                }
        )
    }
}

// тап: сначала аннотация, затем (в режиме схемы) блок-ящик
private fun openTarget(
    norm: Offset,
    anns: List<ViewerAnn>,
    blocks: List<SchematicBlock>,
    onOpenLocation: (String) -> Unit
) {
    anns.lastOrNull { it.rect.contains(norm.x, norm.y) }?.let { a ->
        if (a.locationId != null) onOpenLocation(a.locationId)
        return
    }
    blocks.lastOrNull { it.rect.contains(norm.x, norm.y) }?.locationId?.let(onOpenLocation)
}

// общий слой разметки поверх фото и схемы (цвет, подпись)
private fun DrawScope.drawAnnOverlay(
    anns: List<ViewerAnn>,
    textMeasurer: TextMeasurer,
    boxSize: Size
) {
    val s = boxSize
    if (s.width == 0f) return
    fun normRect(r: RectF) = RectF(r.left * s.width, r.top * s.height, r.right * s.width, r.bottom * s.height)
    anns.forEach { a ->
        val r = normRect(a.rect)
        val c = Color(a.color)
        drawRect(color = c, topLeft = Offset(r.left, r.top), size = Size(r.width(), r.height()), alpha = 0.18f)
        drawRect(color = c, topLeft = Offset(r.left, r.top), size = Size(r.width(), r.height()), style = Stroke(3f))
        if (a.label.isNotBlank()) {
            val pad = 10f
            val fontSize = (r.height() * 0.24f).coerceIn(14f, 44f)
            val st = TextStyle(color = Color.White, fontSize = fontSize.sp)
            val textW = textMeasurer.measure(a.label, st).size.width
            val w = minOf(r.width(), textW + pad * 2)
            val h = fontSize + pad * 0.8f
            drawRoundRect(
                color = c,
                topLeft = Offset(r.left, r.top),
                size = Size(w, h),
                cornerRadius = CornerRadius(6f)
            )
            drawText(textMeasurer, text = a.label, topLeft = Offset(r.left + pad, r.top + pad * 0.6f), style = st)
        }
    }
}