package ru.vldkr.shkaff.features.storages

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.StorageData
import ru.vldkr.shkaff.ui.components.AttrFields
import ru.vldkr.shkaff.ui.components.FieldRow
import ru.vldkr.shkaff.ui.components.SectionTitle

class StorageFormVm(
    private val storageId: String?
) : ViewModel() {

    var name by mutableStateOf("")
    var description by mutableStateOf("")
    var attrs by mutableStateOf<Map<String, String>>(emptyMap())
    val attrDefs = MutableStateFlow<List<AttributeDefEntity>>(emptyList())
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
            attrDefs.value = Deps.attributes.forScope("storage")
        }
        if (storageId != null) {
            viewModelScope.launch {
                Deps.storages.byId(storageId)?.let {
                    name = it.name
                    description = it.description
                    attrs = AttrJson.toMap(it.attributes)
                }
                loaded.value = true
            }
        } else {
            loaded.value = true
        }
    }

    fun save(onDone: (String?) -> Unit) {
        if (name.isBlank()) {
            error.value = "Введите название хранилища"
            return
        }
        viewModelScope.launch {
            saving.value = true
            error.value = null
            val d = StorageData(name = name, description = description, attributes = attrs)
            try {
                val id = if (storageId == null) {
                    Deps.storages.create(d).id
                } else {
                    storageId
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
    }
}
