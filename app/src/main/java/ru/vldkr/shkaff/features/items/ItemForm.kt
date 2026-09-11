package ru.vldkr.shkaff.features.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.PhotoLibrary
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
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
import androidx.compose.runtime.LaunchedEffect
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
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.domain.recommend.Recommend
import ru.vldkr.shkaff.domain.recommend.RecommendCandidate
import ru.vldkr.shkaff.domain.recommend.StorageSuggestion
import ru.vldkr.shkaff.util.Expiry
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.ItemPhoto
import ru.vldkr.shkaff.ui.components.LocationPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.util.ImageDownload
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.util.newId
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
    var ean by mutableStateOf("")
    var attrs by mutableStateOf<Map<String, String>>(emptyMap())
    var tags by mutableStateOf<List<String>>(emptyList())
    var volumeLiters by mutableStateOf("")
    var weightKg by mutableStateOf("")
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())
    val locations = MutableStateFlow<List<LocationEntity>>(emptyList())
    val tagDict = MutableStateFlow<List<String>>(emptyList())
    val error = MutableStateFlow<String?>(null)
    val saving = MutableStateFlow(false)
    val loaded = MutableStateFlow(false)

    // US-B1: поиск по штрихкоду в интернете
    data class EanRow(val key: String, val value: String, val checked: Boolean)
    val eanLookupBusy = MutableStateFlow(false)
    val eanLookupResult = MutableStateFlow<List<EanRow>?>(null)
    val eanLookupError = MutableStateFlow<String?>(null)

    // US-I5: «ссылка — сохранить как картинку в базу» — после успеха диалог сам закроется
    val linkPhotoBusy = MutableStateFlow(false)
    val linkPhotoError = MutableStateFlow<String?>(null)
    val linkPhotoDone = MutableStateFlow(false)

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
            Deps.storages.observeAll().collect { s ->
                storages.value = s
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
                    ean = it.ean ?: ""
                    attrs = AttrJson.toMap(it.attributes)
                    tags = TagsJson.toList(it.tags)
                    volumeLiters = it.volume_liters.let { v -> if (v > 0) v.toString() else "" }
                    weightKg = it.weight_kg.let { v -> if (v > 0) v.toString() else "" }
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

    // US-C6: топ-подсказки, куда положить вещь. Пересчитывается по кнопке.
    val recommendations = MutableStateFlow<List<StorageSuggestion>>(emptyList())
    val storages = MutableStateFlow<List<StorageEntity>>(emptyList())

    fun refreshRecommendations() {
        viewModelScope.launch {
            val categoryKey = attrDefs.value.firstOrNull { it.label == "Категория" }?.key ?: "category"
            val category = attrs[categoryKey]?.trim()?.takeIf { it.isNotEmpty() }
            val volume = volumeLiters.toDoubleOrNull()?.takeIf { it > 0 } ?: 0.0
            val weight = weightKg.toDoubleOrNull()?.takeIf { it > 0 } ?: 0.0
            // Категории уже лежащих вещей по ящикам.
            val categoriesByLoc = HashMap<String, Set<String>>()
            Deps.items.all().forEach { it ->
                val cat = AttrJson.toMap(it.attributes)[categoryKey]?.trim()?.takeIf { c -> c.isNotEmpty() } ?: return@forEach
                val prev = categoriesByLoc[it.location_id ?: ""] ?: emptySet()
                categoriesByLoc[it.location_id ?: ""] = prev + cat
            }
            val storagesById = storages.value.associateBy { it.id }
            val candidates = locations.value.map { loc ->
                RecommendCandidate(
                    id = loc.id,
                    name = loc.label.ifBlank { loc.name }.ifBlank { "Ящик" },
                    usage = Deps.locations.usage(loc.id),
                    itemCount = Deps.items.countByLocation(loc.id),
                    presentCategories = categoriesByLoc[loc.id] ?: emptySet(),
                    pathPrefix = storagesById[loc.storage_id]?.name.orEmpty()
                )
            }
            recommendations.value = Recommend.rank(candidates, category, volume, weight)
        }
    }

    // US-B1: скан/ручной ввод EAN → данные из интернета (OpenFoodFacts, при неудаче — LLM).
    // В карточку попадают только подтверждённые пользователем поля.
    fun lookupEan() {
        val code = ean.trim()
        if (code.length < 8) {
            eanLookupError.value = "Штрихкод слишком короткий (нужен EAN-8/13 или UPC)"
            return
        }
        viewModelScope.launch {
            eanLookupBusy.value = true
            eanLookupError.value = null
            eanLookupResult.value = null
            val provider = ru.vldkr.shkaff.domain.ean.EanLookupFallback(
                llm = ru.vldkr.shkaff.domain.ean.EanLlm { Deps.agentSettings() }
            )
            val p = try {
                provider.lookup(code)
            } catch (e: Exception) {
                eanLookupError.value = "Не получилось: ${e.message}"
                null
            } finally {
                eanLookupBusy.value = false
            }
            if (p == null) {
                if (eanLookupError.value == null) {
                    eanLookupError.value = "Ничего не нашлось по штрихкоду $code"
                }
                return@launch
            }
            val rows = mutableListOf<EanRow>()
            if (p.name.isNotBlank()) rows += EanRow("Название", p.name, true)
            if (p.brand.isNotBlank()) rows += EanRow("Бренд", p.brand, true)
            if (p.categories.isNotBlank()) rows += EanRow("Категория", p.categories, true)
            if (p.quantity.isNotBlank()) rows += EanRow("Количество", p.quantity, true)
            p.extra.forEach { (k, v) -> if (v.isNotBlank()) rows += EanRow(k, v, true) }
            eanLookupResult.value = rows.takeIf { it.isNotEmpty() }
                ?: run {
                    eanLookupError.value = "Нашёлся товар, но без полезных полей"
                    null
                }
        }
    }

    fun toggleEanRow(key: String) {
        eanLookupResult.value = eanLookupResult.value?.map {
            if (it.key == key) it.copy(checked = !it.checked) else it
        }
    }

    // Перенос подтверждённых полей в форму; неизвестная категория дописывается в словарь.
    fun applyEan() {
        val rows = eanLookupResult.value ?: return
        val checked = rows.filter { it.checked && it.value.isNotBlank() }
        if (checked.isEmpty()) {
            eanLookupResult.value = null
            return
        }
        val byKey = checked.associate { it.key to it.value.trim() }
        byKey["Название"]?.let { name = it }
        val descriptionParts = mutableListOf<String>()
        if (description.isNotBlank()) descriptionParts += description
        byKey["Бренд"]?.let { v ->
            if (descriptionParts.none { it.contains(v, ignoreCase = true) }) descriptionParts += "Бренд: $v"
        }
        byKey["Количество"]?.let { v ->
            if (descriptionParts.none { it.contains(v, ignoreCase = true) }) descriptionParts += "Количество: $v"
        }
        byKey["Общее название"]?.let { v ->
            if (descriptionParts.none { it.contains(v, ignoreCase = true) }) descriptionParts += v
        }
        byKey["Ингредиенты"]?.let { v ->
            if (descriptionParts.none { it.contains(v, ignoreCase = true) }) descriptionParts += "Состав: $v"
        }
        description = descriptionParts.joinToString("\n")
        byKey["Категория"]?.let { v ->
            val categoryKey = attrDefs.value.firstOrNull { it.label == "Категория" }?.key ?: "category"
            attrs = attrs + (categoryKey to v)
            // US-B1: недостающие значения справочника добавляются в словарь
            val def = attrDefs.value.firstOrNull { it.label == "Категория" }
            if (def != null) {
                val opts = runCatching { org.json.JSONArray(def.options) }.getOrNull() ?: org.json.JSONArray()
                if ((0 until opts.length()).none { opts.optString(it).equals(v, ignoreCase = true) }) {
                    viewModelScope.launch {
                        try {
                            Deps.attributes.addOption(def.id, v, Deps.deviceId)
                        } catch (_: Exception) {
                        }
                    }
                }
            }
        }
        eanLookupResult.value = null
    }

    fun dismissEan() {
        eanLookupResult.value = null
        eanLookupError.value = null
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
            val role = Role.parse(Deps.users.activeUser()?.role ?: "view")
            val need = if (itemId == null) Access.CREATE else Access.EDIT
            if (!Access.can(role, need)) {
                error.value = "Профиль «${Deps.users.activeUser()?.name ?: "—"}» не может это делать (роль ${Access.label(role)})"
                saving.value = false
                return@launch
            }
            val d = ItemData(
                name = name,
                code = code,
                description = description,
                attributes = attrs,
                locationId = locationId,
                photoPath = photoPath,
                expiryDate = if (rawExpiry.isEmpty()) null else Expiry.normalize(rawExpiry),
                ean = ean.trim().takeIf { it.isNotBlank() },
                tags = tags,
                volumeLiters = volumeLiters.toDoubleOrNull()?.takeIf { it > 0 } ?: 0.0,
                weightKg = weightKg.toDoubleOrNull()?.takeIf { it > 0 } ?: 0.0
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
            // Имя файла уникально (UUID): у новой вещи ещё нет id, а общий «new.jpg»
            // перезаписывался бы другими несозданными вещами.
            val dest = File(Deps.app.filesDir, "item_photos/${newId()}.jpg")
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

    fun downloadLinkPhoto(url: String) {
        if (linkPhotoBusy.value) return
        if (url.isBlank()) {
            linkPhotoError.value = "Вставьте ссылку на картинку"
            return
        }
        linkPhotoError.value = null
        linkPhotoBusy.value = true
        viewModelScope.launch {
            try {
                val f = ImageDownload.download(Deps.app, url)
                setPhoto(f.absolutePath)
                linkPhotoDone.value = true
            } catch (e: Exception) {
                linkPhotoError.value = e.message ?: "Не удалось скачать картинку"
            } finally {
                linkPhotoBusy.value = false
            }
        }
    }

    fun clearLinkPhotoError() {
        linkPhotoError.value = null
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
            snapshotFlow { FormSnap(name, code, description, locationId, photoPath, expiryDate, ean, attrs, tags) }
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
        val locationId: String?, val photoPath: String?, val expiryDate: String, val ean: String,
        val attrs: Map<String, String>, val tags: List<String>
    )

    private fun draftKey(): String = if (itemId == null) "item/new" else "item/$itemId"

    private fun hasFormContent(): Boolean =
        name.isNotBlank() || code.isNotBlank() || description.isNotBlank() ||
            locationId != null || photoPath != null || expiryDate.isNotBlank() || ean.isNotBlank() ||
            tags.isNotEmpty() || attrs.isNotEmpty()

    private fun formJson(): String {
        val o = JSONObject()
        o.put("name", name).put("code", code).put("description", description)
        o.put("locationId", locationId ?: "")
        o.put("photoPath", photoPath ?: "")
        o.put("expiryDate", expiryDate)
        o.put("ean", ean)
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
        ean = o.optString("ean")
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
    val recommendations by vm.recommendations.collectAsState()
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
            FieldRow("Штрихкод (EAN)") {
                Column {
                    OutlinedTextField(
                        value = vm.ean,
                        onValueChange = { vm.ean = it },
                        modifier = Modifier.fillMaxWidth(),
                        placeholder = { Text("Оригинальный штрихкод товара") },
                        supportingText = { Text("Например: 4607001234567") },
                        singleLine = true
                    )
                    if (vm.ean.trim().length >= 8) {
                        if (vm.eanLookupBusy.collectAsState().value) {
                            Text("Ищем по штрихкоду…", style = MaterialTheme.typography.bodySmall)
                        } else {
                            TextButton(onClick = { vm.lookupEan() }, modifier = Modifier.align(Alignment.End)) {
                                Text("Найти по штрихкоду в интернете")
                            }
                        }
                    }
                    vm.eanLookupError.collectAsState().value?.let {
                        Text(it, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.bodySmall)
                    }
                }
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
            FieldRow("Куда положить — подсказка") {
                Column {
                    OutlinedButton(onClick = { vm.refreshRecommendations() }, modifier = Modifier.fillMaxWidth()) {
                        Text("Подобрать место")
                    }
                    val recs = recommendations
                    if (recs.isNotEmpty()) {
                        recs.forEach { r ->
                            val selected = r.id == vm.locationId
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { vm.locationId = r.id }
                                    .padding(vertical = 6.dp)
                            ) {
                                Text(
                                    if (selected) "✓ " else "＋ ",
                                    color = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Column(Modifier.weight(1f)) {
                                    Text(r.name, style = MaterialTheme.typography.bodyLarge)
                                    val notes = (r.pros + r.cons).distinct()
                                    if (notes.isNotEmpty()) {
                                        Text(
                                            notes.joinToString(" · "),
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            maxLines = 2
                                        )
                                    }
                                }
                            }
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
            FieldRow("Объём (л)") {
                OutlinedTextField(
                    value = vm.volumeLiters,
                    onValueChange = { vm.volumeLiters = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: 2.5") },
                    keyboardOptions = KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Decimal),
                    singleLine = true
                )
            }
            FieldRow("Масса (кг)") {
                OutlinedTextField(
                    value = vm.weightKg,
                    onValueChange = { vm.weightKg = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: 1.2") },
                    keyboardOptions = KeyboardOptions(keyboardType = androidx.compose.ui.text.input.KeyboardType.Decimal),
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
        EanLookupDialog(vm)
    }
}

// US-B1: подтверждение полей, найденных по штрихкоду в интернете.
// В форму попадают только отмеченные значения.
@Composable
private fun EanLookupDialog(vm: ItemFormVm) {
    val rows by vm.eanLookupResult.collectAsState()
    if (rows == null) return
    AlertDialog(
        onDismissRequest = { vm.dismissEan() },
        title = { Text("Найдено по штрихкоду") },
        text = {
            Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState())) {
                Text("Отметьте поля, которые перенести в карточку.", style = MaterialTheme.typography.bodySmall)
                Spacer(Modifier.height(8.dp))
                rows.orEmpty().forEach { row ->
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        Checkbox(checked = row.checked, onCheckedChange = { vm.toggleEanRow(row.key) })
                        Column(Modifier.weight(1f).clickable { vm.toggleEanRow(row.key) }) {
                            Text(row.key, style = MaterialTheme.typography.labelLarge)
                            Text(
                                row.value,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { vm.applyEan() }) { Text("Перенести выбранные") }
        },
        dismissButton = {
            TextButton(onClick = { vm.dismissEan() }) { Text("Отмена") }
        }
    )
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

// US-I5: фото вещи — как у товара в маркетплейсе: снимок камеры, файл из галереи
// или картинка по ссылке (скачивается в базу, в поле остаётся файл, а не ссылка)
@Composable
private fun PhotoField(vm: ItemFormVm) {
    val pickers = rememberPhotoPickers(
        onCaptured = { f -> vm.setPhoto(f.absolutePath) },
        onPicked = { f -> vm.setPhoto(f.absolutePath) }
    )
    var showLinkDialog by remember { mutableStateOf(false) }
    FieldRow("Фото") {
        val path = vm.photoPath
        if (path == null) {
            Column(Modifier.fillMaxWidth()) {
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
                OutlinedButton(
                    onClick = { showLinkDialog = true },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    Icon(Icons.Filled.Link, contentDescription = null)
                    Spacer(Modifier.width(8.dp))
                    Text("Из ссылки")
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
                    TextButton(onClick = { showLinkDialog = true }) {
                        Text("Из ссылки")
                    }
                    TextButton(onClick = { vm.removePhoto() }) {
                        Text("Удалить", color = MaterialTheme.colorScheme.error)
                    }
                }
            }
        }
        if (showLinkDialog) {
            LinkPhotoDialog(vm, onDismiss = { showLinkDialog = false })
        }
    }
}

@Composable
private fun LinkPhotoDialog(vm: ItemFormVm, onDismiss: () -> Unit) {
    var url by remember { mutableStateOf("") }
    val busy by vm.linkPhotoBusy.collectAsState()
    val err by vm.linkPhotoError.collectAsState()
    LaunchedEffect(vm.linkPhotoDone) {
        if (vm.linkPhotoDone.value) {
            vm.linkPhotoDone.value = false
            onDismiss()
        }
    }
    AlertDialog(
        onDismissRequest = { if (!busy) onDismiss() },
        title = { Text("Фото из ссылки") },
        text = {
            Column(Modifier.fillMaxWidth()) {
                Text(
                    "Вставьте прямую ссылку на картинку (jpg/png/webp). Она скачается и сохранится в базе — в карточке останется файл, а не ссылка.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = url,
                    onValueChange = { url = it },
                    label = { Text("Ссылка на картинку") },
                    singleLine = true,
                    isError = err != null,
                    supportingText = err?.let { e -> { Text(e) } }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = { vm.downloadLinkPhoto(url) },
                enabled = !busy && url.isNotBlank()
            ) { Text(if (busy) "Скачиваем…" else "Скачать") }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }, enabled = !busy) { Text("Отмена") }
        }
    )
}
