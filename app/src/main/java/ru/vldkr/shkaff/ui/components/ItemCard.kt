package ru.vldkr.shkaff.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Photo
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.ui.theme.Ozon
import java.io.File

// Фото вещи или нейтральный плейсхолдер (карточки каталога не должны «плыть» без фото)
@Composable
fun ItemPhoto(path: String?, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        val file = path?.let { File(it) }
        if (file == null || !file.exists()) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Ozon.Bg),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Filled.Photo,
                    contentDescription = null,
                    tint = Ozon.TextSecondary.copy(alpha = 0.6f),
                    modifier = Modifier.size(40.dp)
                )
            }
        } else {
            AsyncImage(
                model = file,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

// Бейдж-плашка как «осталось N шт» у Ozon — цветной фон под текст
@Composable
fun PillBadge(text: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color.copy(alpha = 0.14f))
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelLarge,
            color = color,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

// Карточка «товара» в стиле Ozon: фото, статус, код-«цена» (розовый), срок, название, ящик.
@Composable
fun ItemCard(
    item: ItemEntity,
    locationLabel: String?,
    onClick: () -> Unit,
    expiryText: String? = null,
    expiryColor: Color = MaterialTheme.colorScheme.primary,
    status: ItemStatus? = null,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Ozon.Card),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column {
            ItemPhoto(item.photo_path, Modifier.fillMaxWidth().aspectRatio(1f))
            Column(Modifier.padding(10.dp)) {
                if (status != null && status.showOnCard()) {
                    StatusBadge(status.label, status.color, Modifier.padding(bottom = 6.dp))
                }
                Text(
                    item.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Ozon.TextPrimary,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
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