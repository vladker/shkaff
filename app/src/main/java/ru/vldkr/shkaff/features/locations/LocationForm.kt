package ru.vldkr.shkaff.features.locations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.AttrJson
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.LocationData
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.LevelPicker
import ru.vldkr.shkaff.ui.components.LocationPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.subtreeIds
import ru.vldkr.shkaff.util.FormBus

class LocationFormVm(
    private val storageId: String,
    private val locationId: String?
) : ViewModel() {

    var label by mutableStateOf("")
    var name by mutableStateOf("")
    var parentId by mutableStateOf<String?>(null)
    var level by mutableStateOf("")
    var attrs by mutableStateOf<Map<String, String>>(emptyMap())
    var capacityVolume by mutableStateOf("")
    var capacityWeight by mutableStateOf("")
    var dontFillToBrim by mutableStateOf(false)
    var isFull by mutableStateOf(false)
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())
    val siblings = MutableStateFlow<List<LocationEntity>>(emptyList())
    val error = MutableStateFlow<String?>(null)
    val saving = MutableStateFlow(false)
    val loaded = MutableStateFlow(false)

    class Factory(private val storageId: String, private val locationId: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            LocationFormVm(storageId, if (locationId == "0") null else locationId) as T
    }

    init {
        viewModelScope.launch {
            Deps.attributes.observeAll().collect { all ->
                attrDefs.value = all.filter { it.scope == "location" || it.scope == "*" }
            }
        }
        viewModelScope.launch {
            val all = Deps.locations.allByStorage(storageId)
            siblings.value = all
            if (locationId != null) {
                all.firstOrNull { it.id == locationId }?.let {
                    label = it.label
                    name = it.name
                    parentId = it.parent_id
                    level = it.level
                    attrs = AttrJson.toMap(it.attributes)
                    capacityVolume = it.capacity_volume?.takeIf { v -> v > 0 }?.let { v -> v.toString() } ?: ""
                    capacityWeight = it.capacity_weight?.takeIf { v -> v > 0 }?.let { v -> v.toString() } ?: ""
                    dontFillToBrim = it.dont_fill_to_brim
                    isFull = it.is_full
                }
            } else {
                FormBus.locationParentPreset?.let { preset ->
                    if (preset in all.map { l -> l.id }) parentId = preset
                }
                FormBus.locationParentPreset = null
            }
            loaded.value = true
        }
    }

    // исключаем себя и своих потомков — иначе вложенность превратится в цикл
    fun parentCandidates(): List<LocationEntity> {
        val all = siblings.value
        if (locationId == null) return all
        return all.filter { it.id !in subtreeIds(locationId, all, { l -> l.id }, { l -> l.parent_id }) }
    }

    fun save(onDone: (String) -> Unit) {
        if (label.isBlank() && name.isBlank()) {
            error.value = "Укажите номер или название ящика"
            return
        }
        viewModelScope.launch {
            saving.value = true
            error.value = null
            val role = Role.parse(Deps.users.activeUser()?.role ?: "view")
            val need = if (locationId == null) Access.CREATE else Access.EDIT
            if (!Access.can(role, need)) {
                error.value = "Профиль «${Deps.users.activeUser()?.name ?: "—"}» не может это делать (роль ${Access.label(role)})"
                saving.value = false
                return@launch
            }
            val d = LocationData(
                storageId = storageId,
                parentId = parentId,
                label = label,
                name = name,
                attributes = attrs,
                capacityVolumeLiters = capacityVolume.toDoubleOrNull()?.takeIf { it > 0 },
                capacityWeightKg = capacityWeight.toDoubleOrNull()?.takeIf { it > 0 },
                dontFillToBrim = dontFillToBrim,
                isFull = isFull,
                level = level
            )
            try {
                val id = if (locationId == null) {
                    Deps.locations.create(d).id
                } else {
                    Deps.locations.update(locationId, d)?.id ?: throw IllegalStateException("Ящик не найден")
                }
                onDone(id)
            } catch (e: Exception) {
                error.value = e.message
            } finally {
                saving.value = false
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationFormScreen(nav: NavController, storageId: String, id: String) {
    val isNew = id == "0"
    val vm: LocationFormVm = viewModel(factory = LocationFormVm.Factory(storageId, id))
    val error by vm.error.collectAsState()
    val saving by vm.saving.collectAsState()
    val defs by vm.attrDefs.collectAsState()
    val loaded by vm.loaded.collectAsState()
    val siblings by vm.siblings.collectAsState()
    var showParentPicker by remember { mutableStateOf(false) }

    val parentName: String? = vm.parentId?.let { pid ->
        siblings.firstOrNull { it.id == pid }?.let { it.label.ifBlank { it.name } }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isNew) "Новый ящик" else "Ящик") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        vm.save { newId ->
                            if (isNew) nav.navigate("location/$newId") { popUpTo("dashboard") }
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
            FieldRow("Номер (маркировка)") {
                OutlinedTextField(
                    value = vm.label,
                    onValueChange = { vm.label = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: B-14") },
                    singleLine = true
                )
            }
            FieldRow("Название") {
                OutlinedTextField(
                    value = vm.name,
                    onValueChange = { vm.name = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: Коробка с проводами") },
                    singleLine = true
                )
            }
            FieldRow("Вложен в ящик (опционально)") {
                Column {
                    OutlinedButton(onClick = { showParentPicker = true }, modifier = Modifier.fillMaxWidth()) {
                        Text(parentName ?: "— не вложено —")
                    }
                    if (parentName != null) {
                        TextButton(onClick = { vm.parentId = null }) {
                            Text("Сбросить", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
            FieldRow("Уровень") {
                LevelPicker(vm.level) { vm.level = it }
            }
            FieldRow("Ёмкость (л)") {
                OutlinedTextField(
                    value = vm.capacityVolume,
                    onValueChange = { vm.capacityVolume = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Д×Ш×В → литры; например 30") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true
                )
            }
            FieldRow("Грузоподъёмность (кг) — необязательно") {
                OutlinedTextField(
                    value = vm.capacityWeight,
                    onValueChange = { vm.capacityWeight = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: 25") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text("Не набивать до упора (резерв места)", modifier = Modifier.weight(1f))
                Switch(checked = vm.dontFillToBrim, onCheckedChange = { vm.dontFillToBrim = it })
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
            ) {
                Text("Считать «полным» — блокировать добавление", modifier = Modifier.weight(1f))
                Switch(checked = vm.isFull, onCheckedChange = { vm.isFull = it })
            }
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

        if (showParentPicker) {
            LocationPickerDialog(
                locations = vm.parentCandidates(),
                currentId = vm.parentId,
                onPick = { vm.parentId = it },
                onDismiss = { showParentPicker = false },
                title = "Вложен в ящик",
                emptyLabel = "— не вложено —"
            )
        }
    }
}
