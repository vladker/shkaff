package ru.vldkr.shkaff.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import ru.vldkr.shkaff.data.db.ItemEntity
import ru.vldkr.shkaff.data.db.LoanEntity
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.util.Expiry
import java.time.LocalDate

enum class ItemStatusKind { OK, LOANED, EXPIRED, EXPIRING, UNLOCATED }

data class ItemStatus(val label: String, val color: Color, val kind: ItemStatusKind)

// Статус вещи, вычисляемый из уже имеющихся данных — без новых полей в БД.
// Приоритет для карточек: выдана > срок истёк > скоро истечёт > без места > «на месте».
fun itemStatus(
    item: ItemEntity,
    hasLocation: Boolean,
    loan: LoanEntity? = null,
    today: LocalDate = LocalDate.now(),
    thresholdDays: Int = 14
): ItemStatus = itemStatuses(item, hasLocation, loan, today, thresholdDays).first()

// Все значимые статусы вещи — список показываем на странице вещи,
// карточки берут первый (самый важный).
fun itemStatuses(
    item: ItemEntity,
    hasLocation: Boolean,
    loan: LoanEntity? = null,
    today: LocalDate = LocalDate.now(),
    thresholdDays: Int = 14
): List<ItemStatus> {
    val out = mutableListOf<ItemStatus>()
    if (loan != null) out += ItemStatus("Одолжено · ${loan.borrower}", Ozon.Blue, ItemStatusKind.LOANED)
    val exp = item.expiry_date?.let { Expiry.parse(it) }
    if (exp != null) {
        val d = Expiry.daysUntil(exp, today)
        if (d < 0) {
            out += ItemStatus("Срок истёк", Ozon.Pink, ItemStatusKind.EXPIRED)
        } else if (d <= thresholdDays) {
            val t = if (d == 0) "Истекает сегодня" else if (d == 1) "Истекает завтра" else "Истекает через $d дн."
            out += ItemStatus(t, Ozon.Orange, ItemStatusKind.EXPIRING)
        }
    }
    if (!hasLocation) out += ItemStatus("Без места", Ozon.TextMuted, ItemStatusKind.UNLOCATED)
    if (out.isEmpty()) out += ItemStatus("На месте", Ozon.Green, ItemStatusKind.OK)
    return out
}

// На карточках «на месте» не рисуем — лишний шум; в деталях показываем всегда.
fun ItemStatus.showOnCard(): Boolean = kind != ItemStatusKind.OK

// Цветной бейдж-статус (сплошной фон, белый текст) — как статусы наличия у Ozon.
@Composable
fun StatusBadge(text: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier
            .clip(RoundedCornerShape(6.dp))
            .background(color)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Text(
            text,
            style = MaterialTheme.typography.labelMedium,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}