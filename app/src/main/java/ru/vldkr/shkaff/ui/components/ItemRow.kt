package ru.vldkr.shkaff.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.ui.theme.Ozon

fun LocationEntity.displayLabel(): String = label.ifBlank { name }.ifBlank { "Ящик" }

@Composable
fun ItemRow(
    item: ItemEntity,
    locationLabel: String?,
    onClick: () -> Unit,
    expiryText: String? = null,
    expiryColor: Color = Color.Transparent
) {
    Column(
        Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp, horizontal = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                item.name,
                style = MaterialTheme.typography.titleMedium,
                color = Ozon.TextPrimary,
                modifier = Modifier.weight(1f)
            )
            if (item.code.isNotBlank()) {
                Text(
                    item.code,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Ozon.Pink
                )
            }
            if (expiryText != null) {
                Spacer(Modifier.width(8.dp))
                Text(
                    expiryText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = expiryColor
                )
            }
        }
        val sub = buildList {
            locationLabel?.let { add("в «$it»") }
            if (item.description.isNotBlank()) add(item.description.take(60))
        }.joinToString(" · ")
        if (sub.isNotEmpty()) {
            Spacer(Modifier.height(2.dp))
            Text(sub, style = MaterialTheme.typography.bodyMedium, color = Ozon.TextSecondary)
        }
        Spacer(Modifier.height(8.dp))
        HorizontalDivider(color = Ozon.Card)
    }
}
