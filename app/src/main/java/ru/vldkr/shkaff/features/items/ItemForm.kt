package ru.vldkr.shkaff.features.items

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.TagsJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.util.Expiry
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.ItemPhoto
import ru.vldkr.shkaff.ui.components.LocationPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.util.rememberPhotoPickers
import java.io.File

class ItemFormVm(
    private val itemId: String?,
    private val preselectLocationId: String?
) : ViewModel() {

    var name by mutableStateOf("")
    var code by mutableStateOf("")
    var description by mutableStateOf("")
    var locationId by mutableStateOf<String?>(null)
    var photoPath by mutableStateOf<String?>(null)
    var expiryDate by mutableStateOf("")
    var attrs by mutableStateOf<Map<String, String>>(emptyMap())
    var tags by mutableStateOf<List<String>>(emptyList())
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())
    val locations = MutableStateFlow<List<LocationEntity>>(emptyList())
    val tagDict = MutableStateFlow<List<String>>(emptyList())
    val error = MutableStateFlow<String?>(null)
    val saving = MutableStateFlow(false)
    val loaded = MutableStateFlow(false)

    class Factory(private val itemId: String, private val preselectLocationId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            ItemFormVm(
                if (itemId == "0") null else itemId,
                if (preselectLocationId == "0" || preselectLocationId.isEmpty()) null else preselectLocationId
            ) as T
    }

    init {
        viewModelScope.launch {
            Deps.attributes.observeAll().collect { all ->
                attrDefs.value = all.filter { it.scope == "item" || it.scope == "*" }
            }
        }
        viewModelScope.launch {
            Deps.locations.observeAll().collect { l ->
                locations.value = l.sortedBy { it.label.ifEmpty { it.name } }
            }
        }
        viewModelScope.launch {
            Deps.tags.observeAll().collect { t ->
                tagDict.value = t.map { it.name }.distinct().sorted()
            }
        }
        if (itemId == null) {
            locationId = preselectLocationId
            val scanned = ScanBus.lastCode
            if (scanned != null) {
                code = scanned
                ScanBus.lastCode = null
            }
        }
        viewModelScope.launch {
            if (itemId != null) {
                Deps.items.byId(itemId)?.let {
                    name = it.name
                    code = it.code
                    description = it.description
                    locationId = it.location_id
                    photoPath = it.photo_path
                    expiryDate = it.expiry_date ?: ""
                    attrs = AttrJson.toMap(it.attributes)
                    tags = TagsJson.toList(it.tags)
                }
            }
            // US-A4: черновик формы, если есть — поверх загруженных значений
            val d = Deps.drafts.get(draftKey())
            if (d != null && d.form_json.isNotBlank()) applyDraft(d.form_json)
            loaded.value = true
            startAutosave()
        }
    }

    fun locationName(): String? {
        val id = locationId ?: return null
        return locations.value.firstOrNull { it.id == id }?.let { it.label.ifBlank { it.name } }
    }

    fun save(onDone: (String) -> Unit) {
        if (name.isBlank()) {
            error.value = "Введите название вещи"
            return
        }
        val rawExpiry = expiryDate.trim()
        if (rawExpiry.isNotEmpty() && Expiry.parse(rawExpiry) == null) {
            error.value = "Не распознал «Срок годности». Формат: ДД.ММ.ГГГГ"
            return
        }
        viewModelScope.launch {
            saving.value = true
            error.value = null
            val d = ItemData(
                name = name,
                code = code,
                description = description,
                attributes = attrs,
                locationId = locationId,
                photoPath = photoPath,
                expiryDate = if (rawExpiry.isEmpty()) null else Expiry.normalize(rawExpiry),
                tags = tags
            )
            try {
                val id = if (itemId == null) {
                    Deps.items.create(d).id
                } else {
                    Deps.items.update(itemId, d)?.id ?: throw IllegalStateException("Вещь не найдена")
                }
                Deps.drafts.clear(draftKey())
                onDone(id)
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                saving.value = false
            }
        }
    }

    // US-I5: фото вещи — копируем в storageDir/item_photos, чтобы файл не зависел
    // от жизненного цикла Uri (документы могут быть очищены системой)
    fun setPhoto(path: String) {
        try {
            val dest = File(Deps.app.filesDir, "item_photos/${itemId ?: "new"}.jpg")
            dest.parentFile?.mkdirs()
            val src = File(path)
            if (src.exists()) {
                if (dest.exists()) dest.delete()
                src.copyTo(dest, overwrite = true)
                photoPath = dest.absolutePath
                src.delete()
            }
        } catch (_: Exception) {
        }
    }

    fun removePhoto() {
        photoPath?.let {
            try {
                File(it).delete()
            } catch (_: Exception) {
            }
        }
        photoPath = null
    }

    // US-A4: автосохранение полного состояния формы под ключом "item/new" или "item/{id}".
    // Debounce 600 мс: отменяем предыдущий отложенный сейв, пока поля ещё меняются.
    private fun startAutosave() {
        viewModelScope.launch {
            var job: Job? = null
            snapshotFlow { FormSnap(name, code, description, locationId, photoPath, expiryDate, attrs, tags) }
                .collect {
                    job?.cancel()
                    job = launch {
                        delay(600L)
                        if (hasFormContent()) Deps.drafts.save(draftKey(), "item", itemId, formJson())
                    }
                }
        }
    }

    private data class FormSnap(
        val name: String, val code: String, val description: String,
        val locationId: String?, val photoPath: String?, val expiryDate: String,
        val attrs: Map<String, String>, val tags: List<String>
    )

    private fun draftKey(): String = if (itemId == null) "item/new" else "item/$itemId"

    private fun hasFormContent(): Boolean =
        name.isNotBlank() || code.isNotBlank() || description.isNotBlank() ||
            locationId != null || photoPath != null || expiryDate.isNotBlank() || tags.isNotEmpty() || attrs.isNotEmpty()

    private fun formJson(): String {
        val o = JSONObject()
        o.put("name", name).put("code", code).put("description", description)
        o.put("locationId", locationId ?: "")
        o.put("photoPath", photoPath ?: "")
        o.put("expiryDate", expiryDate)
        val t = JSONArray()
        tags.forEach { t.put(it) }
        o.put("tags", t)
        val a = JSONObject()
        attrs.forEach { (k, v) -> a.put(k, v) }
        o.put("attrs", a)
        return o.toString()
    }

    private fun applyDraft(json: String) {
        val o = JSONObject(json)
        name = o.optString("name")
        code = o.optString("code")
        description = o.optString("description")
        locationId = o.optString("locationId").takeIf { it.isNotBlank() }
        if (o.has("photoPath")) photoPath = o.optString("photoPath").takeIf { it.isNotBlank() }
        expiryDate = o.optString("expiryDate")
        tags = TagsJson.toList(o.optString("tags", ""))
        val a = o.optJSONObject("attrs") ?: return
        val m = mutableMapOf<String, String>()
        a.keys().forEach { k ->
            val v = a.optString(k)
            if (v.isNotBlank()) m[k] = v
        }
        attrs = m
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemFormScreen(nav: NavController, id: String, locationId: String) {
    val isNew = id == "0"
    val vm: ItemFormVm = viewModel(factory = ItemFormVm.Factory(id, locationId))
    val error by vm.error.collectAsState()
    val saving by vm.saving.collectAsState()
    val defs by vm.attrDefs.collectAsState()
    val loaded by vm.loaded.collectAsState()
    val locations by vm.locations.collectAsState()
    var showLocationPicker by remember { mutableStateOf(false) }

    val locName = vm.locationName()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isNew) "Новая вещь" else "Вещь") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        vm.save { newId ->
                            if (isNew) nav.navigate("item/$newId") { popUpTo("dashboard") }
                            else nav.popBackStack()
                        }
                    }, enabled = !saving) {
                        Icon(Icons.Filled.Save, contentDescription = "Сохранить")
                    }
                }
            )
        }
    ) { padding ->
        if (!loaded) {
            Column(Modifier.padding(padding).padding(32.dp)) {
                Text("Загрузка…", style = MaterialTheme.typography.bodyLarge)
            }
            return@Scaffold
        }
        Column(
            Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            PhotoField(vm)
            FieldRow("Название *") {
                OutlinedTextField(
                    value = vm.name,
                    onValueChange = { vm.name = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: Дрель Makita") },
                    singleLine = true
                )
            }
            FieldRow("Код / номер (можно от руки)") {
                OutlinedTextField(
                    value = vm.code,
                    onValueChange = { vm.code = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: T-001") },
                    supportingText = { Text("Пусто — сгенерируется автоматически") },
                    singleLine = true
                )
            }
            FieldRow("Описание") {
                OutlinedTextField(
                    value = vm.description,
                    onValueChange = { vm.description = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Комментарий") }
                )
            }
            FieldRow("Где хранится") {
                Column {
                    OutlinedButton(onClick = { showLocationPicker = true }, modifier = Modifier.fillMaxWidth()) {
                        Text(locName ?: "— без ящика —")
                    }
                    if (locName != null) {
                        TextButton(onClick = { vm.locationId = null }) {
                            Text("Сбросить", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
            FieldRow("Срок годности") {
                OutlinedTextField(
                    value = vm.expiryDate,
                    onValueChange = { vm.expiryDate = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("ДД.ММ.ГГГГ") },
                    singleLine = true
                )
            }
            TagChipsField(vm)
            if (defs.isNotEmpty()) {
                SectionTitle("Атрибуты")
                AttrFields(defs, vm.attrs) { k, v ->
                    vm.attrs = if (v.isEmpty()) vm.attrs - k else vm.attrs + (k to v)
                }
            }
            error?.let {
                Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(top = 12.dp))
            }
        }

        if (showLocationPicker) {
            LocationPickerDialog(
                locations = locations,
                currentId = vm.locationId,
                onPick = { vm.locationId = it },
                onDismiss = { showLocationPicker = false }
            )
        }
    }
}

@Composable
private fun TagChipsField(vm: ItemFormVm) {
    val scope = rememberCoroutineScope()
    var newTag by remember { mutableStateOf("") }
    val dict by vm.tagDict.collectAsState()

    fun commitTag(raw: String) {
        val t = raw.trim()
        if (t.isEmpty()) return
        vm.tags = if (vm.tags.none { it.equals(t, ignoreCase = true) }) vm.tags + t else vm.tags
        scope.launch {
            try {
                Deps.tags.add(t)
            } catch (_: Exception) {
            }
        }
        newTag = ""
    }

    FieldRow("Теги") {
        if (vm.tags.isNotEmpty()) {
            Row(Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
                vm.tags.forEach { t ->
                    FilterChip(
                        selected = true,
                        onClick = { vm.tags = vm.tags.filterNot { it.equals(t, ignoreCase = true) } },
                        label = { Text(t) },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp)
        ) {
            OutlinedTextField(
                value = newTag,
                onValueChange = { newTag = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Новый тег") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = { commitTag(newTag) })
            )
            TextButton(onClick = { commitTag(newTag) }, modifier = Modifier.padding(start = 4.dp)) {
                Text("+")
            }
        }
        val suggestions = dict.filter { d -> vm.tags.none { it.equals(d, ignoreCase = true) } }.take(8)
        if (suggestions.isNotEmpty()) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(top = 4.dp)
            ) {
                suggestions.forEach { s ->
                    FilterChip(
                        selected = false,
                        onClick = {
                            vm.tags = if (vm.tags.none { it.equals(s, ignoreCase = true) }) vm.tags + s else vm.tags
                        },
                        label = { Text(s) },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                }
            }
        }
    }
}

// US-I5: фото вещи — как у товара в маркетплейсе: снимок камеры или файл из галереи
@Composable
private fun PhotoField(vm: ItemFormVm) {
    val pickers = rememberPhotoPickers(
        onCaptured = { f -> vm.setPhoto(f.absolutePath) },
        onPicked = { f -> vm.setPhoto(f.absolutePath) }
    )
    FieldRow("Фото") {
        val path = vm.photoPath
        if (path == null) {
            Row(Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = { pickers.takePhoto() }) {
                    Icon(Icons.Filled.CameraAlt, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Снять")
                }
                OutlinedButton(
                    onClick = { pickers.pickFromGallery() },
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Icon(Icons.Filled.PhotoLibrary, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Из галереи")
                }
            }
        } else {
            Column(Modifier.fillMaxWidth()) {
                ItemPhoto(
                    path,
                    Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(12.dp))
                )
                Row(Modifier.padding(top = 8.dp)) {
                    TextButton(onClick = { pickers.pickFromGallery() }) {
                        Text("Заменить")
                    }
                    TextButton(onClick = { vm.removePhoto() }) {
                        Text("Удалить", color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }
    }
}
