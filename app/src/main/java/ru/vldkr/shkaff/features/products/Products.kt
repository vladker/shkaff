package ru.vldkr.shkaff.features.products

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.Access
import ru.vldkr.shkaff.ui.components.EmptyState
import ru.vldkr.shkaff.ui.components.ItemPhoto
import ru.vldkr.shkaff.ui.components.LocationMap
import ru.vldkr.shkaff.ui.components.PillBadge
import ru.vldkr.shkaff.ui.components.displayLabel
import ru.vldkr.shkaff.ui.components.rememberRole
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.util.Expiry
import java.time.LocalDate

// Продукты — магазинные вещи с рыночным штрихкодом (EAN); уличены отдельным
// экраном-каталогом, но в базе это те же item (ean заполнен).
class ProductsVm : ViewModel() {

    val allItems = MutableStateFlow<List<ItemEntity>>(emptyList())
    val query = MutableStateFlow("")

    val list = combine(allItems, query) { all, q ->
        val t = q.trim()
        var l = all.filter { it.ean?.isNotBlank() == true }
        if (t.isNotEmpty()) {
            l = l.filter {
                it.name.contains(t, true) ||
                    it.code.contains(t, true) ||
                    (it.ean ?: "").contains(t, true) ||
                    it.description.contains(t, true) ||
                    it.attributes.contains(t, true)
            }
        }
        l
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    init {
        viewModelScope.launch {
            Deps.items.observeAll().collect { allItems.value = it }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsScreen(nav: NavController) {
    val vm: ProductsVm = androidx.lifecycle.viewmodel.compose.viewModel()
    val list by vm.list.collectAsState()
    val locations = LocationMap()
    var queryText by remember { mutableStateOf(vm.query.value) }
    val role = rememberRole()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Продукты") },
                actions = {
                    if (Access.can(role, Access.CREATE)) {
                        IconButton(onClick = { nav.navigate("item-wizard") }) {
                            Icon(Icons.Filled.Add, contentDescription = "Новый продукт")
                        }
                    }
                }
            )
        },
        floatingActionButton = {
            if (Access.can(role, Access.CREATE)) {
                FloatingActionButton(
                    onClick = { nav.navigate("item-wizard") },
                    containerColor = Ozon.Blue,
                    contentColor = Ozon.TextPrimary
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Новый продукт")
                }
            }
        }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize()) {
            TextField(
                value = queryText,
                onValueChange = {
                    queryText = it
                    vm.query.value = it
                },
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp)),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null, tint = Ozon.Blue) },
                placeholder = { Text("Название, код или EAN…", color = Ozon.TextSecondary) },
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Ozon.Search,
                    unfocusedContainerColor = Ozon.Search,
                    disabledContainerColor = Ozon.Search,
                    focusedTextColor = Ozon.TextPrimary,
                    unfocusedTextColor = Ozon.TextPrimary,
                    cursorColor = Ozon.Blue,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            if (list.isEmpty()) {
                EmptyState(
                    if (queryText.isBlank()) {
                        "Продуктов пока нет. Продукт — вещь с рыночным штрихкодом (EAN)."
                    } else {
                        "Ничего не найдено по «$queryText»."
                    }
                )
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(start = 8.dp, end = 8.dp, bottom = 96.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(list, key = { it.id }) { it ->
                        val date = Expiry.parse(it.expiry_date)
                        val today = LocalDate.now()
                        val days = date?.let { d -> Expiry.daysUntil(d, today) }
                        ProductCard(
                            it,
                            locations[it.location_id]?.displayLabel(),
                            expiryText = date?.let { d -> Expiry.label(d, today) },
                            expiryColor = if ((days ?: 1) < 0) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary,
                            onClick = { nav.navigate("item/${it.id}") }
                        )
                    }
                }
            }
        }
    }
}

// Карточка продукта: фото, название, EAN, срок годности, ящик.
@Composable
private fun ProductCard(
    item: ItemEntity,
    locationLabel: String?,
    expiryText: String?,
    expiryColor: Color,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column {
            ItemPhoto(item.photo_path, Modifier.fillMaxWidth().aspectRatio(1f))
            Column(Modifier.padding(10.dp)) {
                Text(
                    item.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Ozon.TextPrimary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                item.ean?.let { ean ->
                    Text(
                        "EAN $ean",
                        style = MaterialTheme.typography.bodySmall,
                        fontFamily = FontFamily.Monospace,
                        color = Ozon.TextSecondary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                if (item.code.isNotBlank()) {
                    Text(
                        item.code,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Ozon.Pink,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
                if (expiryText != null) {
                    PillBadge(
                        text = expiryText,
                        color = expiryColor,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
                if (locationLabel != null) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Icon(
                            Icons.Filled.Place,
                            contentDescription = null,
                            modifier = Modifier.size(14.dp),
                            tint = Ozon.TextSecondary
                        )
                        Spacer(Modifier.width(4.dp))
                        Text(
                            locationLabel,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Ozon.TextSecondary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }
        }
    }
}
