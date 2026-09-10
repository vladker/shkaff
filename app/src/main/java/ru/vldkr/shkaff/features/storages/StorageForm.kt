package ru.vldkr.shkaff.features.storages

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
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.StorageData
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.domain.access.Role
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.SectionTitle
import ru.vldkr.shkaff.ui.components.StoragePickerDialog
import ru.vldkr.shkaff.ui.components.subtreeIds

class StorageFormVm(
    private val storageId: String?
) : ViewModel() {

    var name by mutableStateOf("")
    var code by mutableStateOf("")
    var description by mutableStateOf("")
    var parentId by mutableStateOf<String?>(null)
    var attrs by mutableStateOf<Map<String, String>>(emptyMap())
    var capacityVolume by mutableStateOf("")
    var capacityWeight by mutableStateOf("")
    var dontFillToBrim by mutableStateOf(false)
    var isFull by mutableStateOf(false)
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())
    val allStorages = MutableStateFlow<List<StorageEntity>>(emptyList())
    val error = MutableStateFlow<String?>(null)
    val saving = MutableStateFlow(false)
    val loaded = MutableStateFlow(false)

    class Factory(private val id: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            StorageFormVm(if (id == "0") null else id) as T
    }

    init {
        viewModelScope.launch {
            Deps.attributes.observeAll().collect { all ->
                attrDefs.value = all.filter { it.scope == "storage" || it.scope == "*" }
            }
        }
        viewModelScope.launch {
            Deps.storages.observeAll().collect { allStorages.value = it }
        }
        if (storageId != null) {
            viewModelScope.launch {
                Deps.storages.byId(storageId)?.let {
                    name = it.name
                    code = it.code
                    description = it.description
                    parentId = it.parent_id
                    attrs = AttrJson.toMap(it.attributes)
                    capacityVolume = it.capacity_volume?.takeIf { v -> v > 0 }?.let { v -> v.toString() } ?: ""
                    capacityWeight = it.capacity_weight?.takeIf { v -> v > 0 }?.let { v -> v.toString() } ?: ""
                    dontFillToBrim = it.dont_fill_to_brim
                    isFull = it.is_full
                }
                loaded.value = true
            }
        } else {
            loaded.value = true
        }
    }

    // исключаем себя и потомков — иначе получился бы цикл вложенности
    fun parentCandidates(): List<StorageEntity> {
        val all = allStorages.value
        if (storageId == null) return all
        return all.filter { it.id !in subtreeIds(storageId, all, { s -> s.id }, { s -> s.parent_id }) }
    }

    fun parentName(): String? = parentId?.let { id ->
        allStorages.value.firstOrNull { it.id == id }?.name
    }

    fun save(onDone: (String?) -> Unit) {
        if (name.isBlank()) {
            error.value = "Введите название хранилища"
            return
        }
        viewModelScope.launch {
            saving.value = true
            error.value = null
            val role = Role.parse(Deps.users.activeUser()?.role ?: "view")
            val need = if (storageId == null) Access.CREATE else Access.EDIT
            if (!Access.can(role, need)) {
                error.value = "Профиль «${Deps.users.activeUser()?.name ?: "—"}» не может это делать (роль ${Access.label(role)})"
                saving.value = false
                return@launch
            }
            val d = StorageData(
                name = name,
                code = code,
                description = description,
                attributes = attrs,
                parentId = parentId,
                capacityVolumeLiters = capacityVolume.toDoubleOrNull()?.takeIf { it > 0 },
                capacityWeightKg = capacityWeight.toDoubleOrNull()?.takeIf { it > 0 },
                dontFillToBrim = dontFillToBrim,
                isFull = isFull
            )
            try {
                val id = if (storageId == null) {
                    Deps.storages.create(d).id
                } else {
                    Deps.storages.update(storageId, d)?.id ?: throw IllegalStateException("Хранилище не найдено")
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
fun StorageFormScreen(nav: NavController, id: String) {
    val isNew = id == "0"
    val vm: StorageFormVm = viewModel(factory = StorageFormVm.Factory(id))
    val error by vm.error.collectAsState()
    val saving by vm.saving.collectAsState()
    val defs by vm.attrDefs.collectAsState()
    val loaded by vm.loaded.collectAsState()
    var showParentPicker by remember { mutableStateOf(false) }

    val parentName = vm.parentName()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (isNew) "Новое хранилище" else "Хранилище") },
                navigationIcon = {
                    IconButton(onClick = { nav.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        vm.save { newId ->
                            if (newId != null) {
                                if (isNew) nav.navigate("storage/$newId") { popUpTo("dashboard") }
                                else nav.popBackStack()
                            }
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
            FieldRow("Название *") {
                OutlinedTextField(
                    value = vm.name,
                    onValueChange = { vm.name = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: Шкаф в прихожей") },
                    singleLine = true
                )
            }
            FieldRow("Код (необязательно)") {
                OutlinedTextField(
                    value = vm.code,
                    onValueChange = { vm.code = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("например: S-01") },
                    supportingText = { Text("Пусто — сгенерируется автоматически") },
                    singleLine = true
                )
            }
            FieldRow("Вложено в хранилище (опционально)") {
                Column {
                    OutlinedButton(onClick = { showParentPicker = true }, modifier = Modifier.fillMaxWidth()) {
                        Text(parentName ?: "— без родителя —")
                    }
                    if (parentName != null) {
                        TextButton(onClick = { vm.parentId = null }) {
                            Text("Сбросить", color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            }
            FieldRow("Ёмкость (л) — например, пакет 60 л") {
                OutlinedTextField(
                    value = vm.capacityVolume,
                    onValueChange = { vm.capacityVolume = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Например: 60") },
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
            FieldRow("Описание") {
                OutlinedTextField(
                    value = vm.description,
                    onValueChange = { vm.description = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Комментарий, где стоит, цвет…") }
                )
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
            StoragePickerDialog(
                storages = vm.parentCandidates(),
                currentId = vm.parentId,
                onPick = { vm.parentId = it },
                onDismiss = { showParentPicker = false }
            )
        }
    }
}
