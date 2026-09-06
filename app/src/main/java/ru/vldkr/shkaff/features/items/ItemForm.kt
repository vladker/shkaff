package ru.vldkr.shkaff.features.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.LocationPickerDialog
import ru.vldkr.shkaff.ui.components.SectionTitle

class ItemFormVm(
    private val itemId: String?,
    private val preselectLocationId: String?
) : ViewModel() {

    var name by mutableStateOf("")
    var code by mutableStateOf("")
    var description by mutableStateOf("")
    var locationId by mutableStateOf<String?>(null)
    var attrs by mutableStateOf<Map<String, String>>(emptyMap())
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())
    val locations = MutableStateFlow<List<LocationEntity>>(emptyList())
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
            attrDefs.value = Deps.attributes.forScope("item")
        }
        viewModelScope.launch {
            Deps.locations.observeAll().collect { l ->
                locations.value = l.sortedBy { it.label.ifEmpty { it.name } }
            }
        }
        if (itemId != null) {
            viewModelScope.launch {
                Deps.items.byId(itemId)?.let {
                    name = it.name
                    code = it.code
                    description = it.description
                    locationId = it.location_id
                    attrs = AttrJson.toMap(it.attributes)
                }
                loaded.value = true
            }
        } else {
            locationId = preselectLocationId
            loaded.value = true
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
        viewModelScope.launch {
            saving.value = true
            error.value = null
            val d = ItemData(
                name = name,
                code = code,
                description = description,
                attributes = attrs,
                locationId = locationId
            )
            try {
                val id = if (itemId == null) {
                    Deps.items.create(d).id
                } else {
                    itemId
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
