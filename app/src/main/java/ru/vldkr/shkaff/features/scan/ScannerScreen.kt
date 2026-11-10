package ru.vldkr.shkaff.features.scan

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.AudioManager
import android.media.ToneGenerator
import android.net.Uri
import android.os.Handler
import android.os.Looper
import android.view.HapticFeedbackConstants
import android.view.View
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.zxing.BarcodeFormat
import com.google.zxing.BinaryBitmap
import com.google.zxing.MultiFormatReader
import com.google.zxing.RGBLuminanceSource
import com.google.zxing.common.HybridBinarizer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.actions.ActionCode
import ru.vldkr.shkaff.domain.actions.Relocation
import ru.vldkr.shkaff.domain.actions.RelocationFlow
import ru.vldkr.shkaff.domain.capacity.CapacityGate
import ru.vldkr.shkaff.domain.capacity.GateVerdict
import ru.vldkr.shkaff.domain.links.AppLink
import ru.vldkr.shkaff.ui.components.undo
import ru.vldkr.shkaff.util.ScanBus
import java.util.concurrent.Executors

private val SUPPORTED = listOf(
    BarcodeFormat.QR_CODE,
    BarcodeFormat.DATA_MATRIX,
    BarcodeFormat.CODE_128,
    BarcodeFormat.CODE_39,
    BarcodeFormat.EAN_13,
    BarcodeFormat.EAN_8,
    BarcodeFormat.UPC_A,
    BarcodeFormat.UPC_E
)

object BarcodeScanner {

    private val reader = MultiFormatReader().apply {
        setHints(mapOf(com.google.zxing.DecodeHintType.POSSIBLE_FORMATS to SUPPORTED))
    }

    @Synchronized
    fun decode(bmp: Bitmap): String? {
        val maxSide = 900f
        val scale = minOf(1f, maxSide / maxOf(bmp.width, bmp.height))
        val w = (bmp.width * scale).toInt().coerceAtLeast(1)
        val h = (bmp.height * scale).toInt().coerceAtLeast(1)
        val small = if (scale < 1f) Bitmap.createScaledBitmap(bmp, w, h, true) else bmp
        val pixels = IntArray(w * h)
        small.getPixels(pixels, 0, w, 0, 0, w, h)
        if (small !== bmp) small.recycle()
        val lum = IntArray(w * h)
        for (i in pixels.indices) {
            lum[i] = (pixels[i] shr 8) and 0xFF
        }
        reader.reset()
        return try {
            reader.decode(BinaryBitmap(HybridBinarizer(RGBLuminanceSource(w, h, lum))))?.text
        } catch (e: Exception) {
            null
        }
    }

    fun beep() {
        runCatching {
            val tg = ToneGenerator(AudioManager.STREAM_NOTIFICATION, 80)
            tg.startTone(ToneGenerator.TONE_PROP_BEEP, 120)
            Handler(Looper.getMainLooper()).postDelayed({ tg.release() }, 300)
        }
    }

    // US-L22: тактильный отклик — CONFIRM (успех) / REJECT (ошибка, «не та коробка»).
    fun haptic(view: View, success: Boolean = true) {
        runCatching {
            view.performHapticFeedback(
                if (success) HapticFeedbackConstants.CONFIRM else HapticFeedbackConstants.REJECT
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(nav: androidx.navigation.NavController) {
    val ctx = LocalContext.current
    var hasPermission by remember {
        mutableStateOf(
            ctx.checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        )
    }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted -> hasPermission = granted }
    var detected by remember { mutableStateOf<String?>(null) }
    val borderColor = MaterialTheme.colorScheme.primary
    // US-L22: View для performHapticFeedback (CONFIRM/REJECT).
    val hapticView = remember { View(ctx) }

    // П3.1/T-007: скан-цикл по служебному QR без объекта — цель выбирается сканом
    // (перекладка: QR вещи → QR ящика → подтверждение; выдача/удаление: QR вещи).
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val reloc = remember { RelocationFlow() }
    var cycleVerb by remember { mutableStateOf<String?>(null) }
    var cycleHint by remember { mutableStateOf<String?>(null) }
    var movePair by remember { mutableStateOf<Pair<ItemEntity, LocationEntity>?>(null) }
    var moveOverLimit by remember { mutableStateOf(false) } // П3.3: подтверждённое превышение ёмкости
    var moveConfirmText by remember { mutableStateOf("") }
    var deleteAsk by remember { mutableStateOf<ItemEntity?>(null) }
    var lendAsk by remember { mutableStateOf<ItemEntity?>(null) }
    var lendBorrower by remember { mutableStateOf("") }
    var itemPool by remember { mutableStateOf<List<ItemEntity>>(emptyList()) }
    var locPool by remember { mutableStateOf<List<LocationEntity>>(emptyList()) }
    LaunchedEffect(Unit) {
        itemPool = Deps.items.all()
        locPool = Deps.locations.observeAll().first()
    }
    fun endCycle() {
        cycleVerb = null
        cycleHint = null
        movePair = null
        deleteAsk = null
        lendAsk = null
        detected = null
        reloc.reset()
    }
    fun startCycle(verb: String) {
        detected = null
        cycleVerb = verb
        reloc.reset()
        cycleHint = when (verb) {
            ActionCode.Verb.MOVE -> "Шаг 1/2 — отсканируйте QR вещи"
            else -> "Отсканируйте QR вещи"
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Сканер штрихкода / QR") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            if (!hasPermission) {
                Column(
                    Modifier.align(Alignment.Center).padding(32.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Для сканирования нужен доступ к камере", style = MaterialTheme.typography.bodyLarge)
                    Button(onClick = { permissionLauncher.launch(Manifest.permission.CAMERA) }) {
                        Text("Дать разрешение")
                    }
                }
            } else {
                ScanCameraPreview(
                    enabled = detected == null && movePair == null && deleteAsk == null && lendAsk == null
                ) { code ->
                    BarcodeScanner.beep()
                    val verb = cycleVerb
                    if (verb == null) {
                        BarcodeScanner.haptic(hapticView, success = true) // US-L22: успех
                        detected = code
                    } else if (verb == ActionCode.Verb.MOVE && reloc.step == RelocationFlow.STEP_LOCATION) {
                        // Шаг 2 перекладки: ждём ящик.
                        if (reloc.scanLocation(code, locPool)) {
                            // П3.3/T-006: гейт ёмкости цели. «Полный» ящик — отказ (шаг ящика
                            // повторяется), превышение объёма/массы — предупреждение внутри
                            // подтверждения «Кладем X в Y?» (нажатие = согласие).
                            val loc = reloc.location!!
                            val it1 = reloc.item!!
                            scope.launch {
                                val ids = Deps.locations.subtreeIds(loc.id)
                                var u = Deps.locations.usage(loc.id)
                                if (it1.location_id in ids) {
                                    u = CapacityGate.excludingItem(u, it1.volume_liters, it1.weight_kg)
                                }
                                val dec = CapacityGate.checkPlacement(u, it1.volume_liters, it1.weight_kg)
                                when (dec.verdict) {
                                    GateVerdict.BLOCK -> {
                                        BarcodeScanner.haptic(hapticView, success = false) // «не влезет»
                                        cycleHint = dec.message ?: "Ящик помечен «полным»"
                                        reloc.clearLocation()
                                    }
                                    GateVerdict.CONFIRM -> {
                                        BarcodeScanner.haptic(hapticView, success = true)
                                        moveOverLimit = true
                                        moveConfirmText = reloc.confirmText() + "\n\n" + dec.message
                                        movePair = it1 to loc
                                    }
                                    GateVerdict.OK -> {
                                        BarcodeScanner.haptic(hapticView, success = true)
                                        moveOverLimit = false
                                        moveConfirmText = reloc.confirmText()
                                        movePair = it1 to loc
                                    }
                                }
                            }
                        } else {
                            BarcodeScanner.haptic(hapticView, success = false) // «не та коробка»
                            cycleHint = "Ящик не найден («${Relocation.keyOf(code)}») — отсканируйте QR ящика"
                        }
                    } else if (reloc.scanItem(code, itemPool)) {
                        BarcodeScanner.haptic(hapticView, success = true)
                        when (verb) {
                            ActionCode.Verb.MOVE -> cycleHint = "Вещь «${reloc.item!!.name}». Шаг 2/2 — отсканируйте QR ящика"
                            ActionCode.Verb.DELETE -> deleteAsk = reloc.item
                            ActionCode.Verb.LEND -> { lendBorrower = ""; lendAsk = reloc.item }
                        }
                    } else {
                        BarcodeScanner.haptic(hapticView, success = false)
                        cycleHint = "Вещь не найдена («${Relocation.keyOf(code)}») — отсканируйте QR вещи"
                    }
                }
                cycleVerb?.let { verb ->
                    Card(
                        Modifier
                            .align(Alignment.TopCenter)
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Column(Modifier.padding(12.dp)) {
                            Text(
                                when (verb) {
                                    ActionCode.Verb.MOVE -> if (reloc.step == RelocationFlow.STEP_LOCATION) "Перекладка · шаг 2/2" else "Перекладка · шаг 1/2"
                                    ActionCode.Verb.DELETE -> "Удаление по скану"
                                    ActionCode.Verb.LEND -> "Выдача по скану"
                                    else -> "Служебный QR"
                                },
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(Modifier.height(4.dp))
                            Text(cycleHint ?: "", style = MaterialTheme.typography.bodyMedium)
                            Spacer(Modifier.height(4.dp))
                            TextButton(onClick = { endCycle() }) { Text("Отменить цикл") }
                        }
                    }
                }
                Box(
                    Modifier
                        .align(Alignment.Center)
                        .size(260.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = borderColor,
                                topLeft = androidx.compose.ui.geometry.Offset(0f, 0f),
                                size = androidx.compose.ui.geometry.Size(size.width, size.height),
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(12.dp.toPx()),
                                style = Stroke(2.dp.toPx())
                            )
                        }
                )
                detected?.let { code ->
                    Card(
                        Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text("Найдено", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Spacer(Modifier.height(4.dp))
                            Text(code, style = MaterialTheme.typography.titleMedium)
                            Spacer(Modifier.height(12.dp))
                            if (ActionCode.isServiceCode(code)) {
                                ServiceCodeCard(
                                    nav,
                                    parsed = ActionCode.parse(code),
                                    onDone = { detected = null },
                                    onStartCycle = { verb -> startCycle(verb) },
                                    onMessage = { msg -> scope.launch { snackbarHostState.showSnackbar(msg) } }
                                )
                            } else if (AppLink.parse(code) != null) {
                                // QR «Шкаф» (US-I3): внутри приложения ссылку не открываем —
                                // сразу ищем вещь по коду.
                                val itemCode = AppLink.parse(code)!!
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Button(
                                        onClick = {
                                            ScanBus.lastCode = itemCode
                                            nav.navigate("items/0") { popUpTo("dashboard") }
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) { Text("В приложении") }
                                    OutlinedButton(
                                        onClick = {
                                            runCatching {
                                                ctx.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(code)))
                                            }
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) { Text("Открыть ссылку") }
                                }
                                Spacer(Modifier.height(8.dp))
                                Text(
                                    "Код: $itemCode",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            } else if (code.startsWith("https://") || code.startsWith("http://")) {
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    Button(
                                        onClick = {
                                            runCatching {
                                                ctx.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(code)))
                                            }
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) { Text("Открыть ссылку") }
                                    OutlinedButton(onClick = { detected = null }, modifier = Modifier.weight(1f)) { Text("Сканировать ещё") }
                                }
                            } else {
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    OutlinedButton(
                                        onClick = {
                                            ScanBus.lastCode = code
                                            nav.navigate("items/0") { popUpTo("dashboard") }
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) { Text("Найти") }
                                    Button(
                                        onClick = {
                                            ScanBus.lastCode = code
                                            nav.navigate("item-form/0/0") { popUpTo("dashboard") }
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) { Text("Новая вещь") }
                                    Button(
                                        onClick = {
                                            ScanBus.lastCode = code
                                            nav.navigate("labels/0/0") { popUpTo("dashboard") }
                                        },
                                        modifier = Modifier.weight(1f)
                                    ) { Text("Этикетка") }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // П3.1: подтверждение «Кладем X в Y?» — scan-как-валидация из WMS.
    movePair?.let { (it1, loc) ->
        AlertDialog(
            onDismissRequest = { movePair = null },
            title = { Text("Перекладка по скану") },
            text = { Text(moveConfirmText) },
            confirmButton = {
                Button(onClick = {
                    movePair = null
                    scope.launch {
                        val oldLocation = it1.location_id
                        try {
                            Deps.items.moveTo(it1.id, loc.id, allowOverCapacity = moveOverLimit)
                            // П3.2: после перекладки — undo-снак на 5 секунд.
                            snackbarHostState.undo("Переложили «${it1.name}» в «${Relocation.locationName(loc)}»") {
                                runCatching { Deps.items.moveTo(it1.id, oldLocation, allowOverCapacity = true) }
                            }
                            endCycle()
                        } catch (e: Exception) {
                            // Гонка: ящик успели пометить «полным» — честный отказ вместо записи.
                            cycleHint = e.message ?: "Не удалось переложить"
                            reloc.clearLocation()
                        }
                    }
                }) { Text("Кладем") }
            },
            dismissButton = {
                TextButton(onClick = { endCycle() }) { Text("Отмена") }
            }
        )
    }

    deleteAsk?.let { itm ->
        AlertDialog(
            onDismissRequest = { deleteAsk = null },
            title = { Text("Удалить вещь?") },
            text = { Text("«${itm.name}» будет скрыта из списков.") },
            confirmButton = {
                TextButton(onClick = {
                    deleteAsk = null
                    scope.launch {
                        Deps.items.softDelete(itm.id)
                        snackbarHostState.undo("«${itm.name}» удалена") {
                            Deps.items.restore(itm.id)
                        }
                        endCycle()
                    }
                }) { Text("Удалить", color = MaterialTheme.colorScheme.error) }
            },
            dismissButton = {
                TextButton(onClick = { endCycle() }) { Text("Отмена") }
            }
        )
    }

    lendAsk?.let { itm ->
        AlertDialog(
            onDismissRequest = { lendAsk = null },
            title = { Text("Выдать временно") },
            text = {
                Column {
                    Text("«${itm.name}» — кому выдаём? Срок и заметку можно уточнить в карточке вещи.")
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = lendBorrower,
                        onValueChange = { lendBorrower = it },
                        label = { Text("Кому") },
                        singleLine = true
                    )
                }
            },
            confirmButton = {
                Button(
                    enabled = lendBorrower.isNotBlank(),
                    onClick = {
                        lendAsk = null
                        scope.launch {
                            Deps.loans.lend("item", itm.id, lendBorrower.trim(), "", null)
                            snackbarHostState.showSnackbar("«${itm.name}» выдана: ${lendBorrower.trim()}")
                            endCycle()
                        }
                    }
                ) { Text("Выдать") }
            },
            dismissButton = {
                TextButton(onClick = { endCycle() }) { Text("Отмена") }
            }
        )
    }
}

@Composable
private fun ServiceCodeCard(
    nav: androidx.navigation.NavController,
    parsed: ActionCode.Parsed,
    onDone: () -> Unit,
    onStartCycle: (String) -> Unit,
    onMessage: (String) -> Unit
) {
    val scope = androidx.compose.runtime.rememberCoroutineScope()
    var denied by androidx.compose.runtime.remember { mutableStateOf(false) }
    val verbLabel = when (parsed.verb) {
        ActionCode.Verb.ADD -> "Добавить"
        ActionCode.Verb.MOVE -> "Переложить"
        ActionCode.Verb.DELETE -> "Удалить"
        ActionCode.Verb.LEND -> "Выдать временно"
        ActionCode.Verb.EXPORT -> "Экспорт базы"
        ActionCode.Verb.JOURNAL -> "Журнал действий"
        else -> parsed.verb
    }
    fun verbAction(): String = when (parsed.verb) {
        ActionCode.Verb.ADD -> Access.CREATE
        ActionCode.Verb.MOVE -> Access.MOVE
        ActionCode.Verb.DELETE -> Access.EDIT
        ActionCode.Verb.LEND -> Access.LEND
        ActionCode.Verb.EXPORT, ActionCode.Verb.JOURNAL -> Access.EXPORT
        else -> Access.VIEW
    }
    fun runAction() {
        // T-007: выполнение служебного QR отмечается в журнале действий меткой «service».
        scope.launch {
            Deps.actionLog.log("service", parsed.entityType, parsed.entityId, mapOf("verb" to verbLabel))
        }
        when (parsed.verb) {
            ActionCode.Verb.ADD -> {
                // T-007: ULID карточки из ADD-кода не теряется — им предзаполняется
                // «Код / номер» формы (обещание «у каждого QR свой ULID»).
                if (parsed.entityId.isNotBlank()) ScanBus.lastCode = parsed.entityId
                when (parsed.entityType) {
                    "item" -> nav.navigate("item-form/0/0")
                    "storage" -> nav.navigate("storage-form/0")
                    "location" -> nav.navigate("location-form/0/0")
                    else -> {
                        ScanBus.lastCode = null
                        onMessage("Служебный QR: неизвестный тип объекта «${parsed.entityType}»")
                    }
                }
            }
            ActionCode.Verb.EXPORT -> nav.navigate("export")
            ActionCode.Verb.JOURNAL -> nav.navigate("journal")
            ActionCode.Verb.MOVE, ActionCode.Verb.LEND, ActionCode.Verb.DELETE -> {
                if (parsed.entityId.isNotBlank()) {
                    when (parsed.entityType) {
                        "item" -> nav.navigate("item/${parsed.entityId}")
                        "storage" -> nav.navigate("storage/${parsed.entityId}")
                        "location" -> nav.navigate("location/${parsed.entityId}")
                        else -> onMessage("Служебный QR: неизвестный тип объекта «${parsed.entityType}»")
                    }
                } else {
                    // T-007: объект в QR не указан — больше не мёртвая кнопка:
                    // цель выбирается следующим сканом (перекладка/выдача/удаление по скану).
                    if (parsed.entityType.isBlank() || parsed.entityType == "item") {
                        onStartCycle(parsed.verb)
                    } else {
                        onMessage("Служебный QR без объекта: перекладка/выдача/удаление по скану — только для вещей, а не «${parsed.entityType}»")
                    }
                }
            }
            else -> onMessage("Служебный QR: неизвестное действие «${parsed.verb}»")
        }
    }
    if (denied) {
        Text(
            "Профиль без прав на «$verbLabel»",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.error
        )
        Spacer(Modifier.height(8.dp))
    } else {
        Text(
            "Служебный QR · $verbLabel",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        if (parsed.entityId.isNotBlank()) {
            Spacer(Modifier.height(4.dp))
            Text(
                parsed.entityId,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        Spacer(Modifier.height(8.dp))
    }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(
            onClick = {
                scope.launch {
                    val role = Role.parse(Deps.users.activeUser()?.role ?: "view")
                    if (Access.can(role, verbAction())) runAction() else denied = true
                }
            },
            modifier = Modifier.weight(1f)
        ) { Text("Выполнить") }
        OutlinedButton(onClick = onDone, modifier = Modifier.weight(1f)) { Text("Отмена") }
    }
}

@Composable
fun ScanCameraPreview(enabled: Boolean, onDetected: (String) -> Unit) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val previewView = remember { PreviewView(context) }
    val preview = remember { Preview.Builder().build() }
    val analysis = remember {
        ImageAnalysis.Builder()
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()
    }
    val executor = remember { Executors.newSingleThreadExecutor() }
    val enabledRef = remember { mutableStateOf(enabled) }
    enabledRef.value = enabled
    val onDetectedRef = remember { mutableStateOf(onDetected) }
    onDetectedRef.value = onDetected

    DisposableEffect(Unit) {
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
        scope.launch {
            runCatching {
                val provider = ProcessCameraProvider.getInstance(context).get()
                analysis.setAnalyzer(executor) { image: ImageProxy ->
                    try {
                        if (!enabledRef.value) return@setAnalyzer
                        val bmp = image.toBitmap()
                        val code = runCatching { BarcodeScanner.decode(bmp) }.getOrNull()
                        bmp.recycle()
                        if (code != null) {
                            Handler(Looper.getMainLooper()).post { onDetectedRef.value(code) }
                        }
                    } catch (e: Exception) {
                        // ignore frame errors
                    } finally {
                        image.close()
                    }
                }
                preview.surfaceProvider = previewView.surfaceProvider
                provider.bindToLifecycle(lifecycleOwner, CameraSelector.DEFAULT_BACK_CAMERA, preview, analysis)
            }
        }
        onDispose {
            scope.cancel()
            runCatching { analysis.clearAnalyzer() }
            executor.shutdown()
        }
    }

    AndroidView(
        factory = { previewView },
        modifier = Modifier.fillMaxSize()
    )
}
