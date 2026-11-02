package ru.vldkr.shkaff.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Режим темы. Тёмная — базовая (Ozon); светлая — «инвертированная белая», опция в Настройках.
enum class ThemeMode { DARK, LIGHT }

// Палитра и акценты в точности по описанию интерфейса Ozon (тёмная тема).
// Нейтральные цвета (фон, карточки, текст) переключаются по Ozon.mode —
// свойства читаются в композах, поэтому смена режима перерисовывает интерфейс.
object Ozon {
    // Акценты одинаковы в обеих темах (работают и на тёмном, и на светлом фоне).
    val Blue = Color(0xFF0066FF)
    val Pink = Color(0xFFFF2D55)
    val Yellow = Color(0xFFFFD60A)
    val Cyan = Color(0xFF00D4FF)
    val Teal = Color(0xFF2A9D8F)
    val Orange = Color(0xFFF59E0B)
    val Purple = Color(0xFF8B5CF6)
    val Green = Color(0xFF10B981)

    // Наблюдаемый режим: запись (из Настроек) инвалидирует все композы,
    // читающие любой из Ozon.*-нейтралов.
    private val _mode = mutableStateOf(ThemeMode.DARK)
    var mode: ThemeMode
        get() = _mode.value
        set(value) { _mode.value = value }

    private val dark = Palette(
        Bg = Color(0xFF1A1A2E),
        Card = Color(0xFF2A2A3E),
        Search = Color(0xFF2D2D44),
        Line = Color(0xFF3A3A50),
        TextPrimary = Color(0xFFFFFFFF),
        TextSecondary = Color(0xFF8E8E93),
        TextMuted = Color(0xFF6B6B7B)
    )
    private val light = Palette(
        Bg = Color(0xFFF1F1F6),
        Card = Color(0xFFFFFFFF),
        Search = Color(0xFFE7E7EE),
        Line = Color(0xFFD6D6E0),
        TextPrimary = Color(0xFF16162A),
        TextSecondary = Color(0xFF55555F),
        TextMuted = Color(0xFF8A8A96)
    )
    private val cur get() = if (mode == ThemeMode.LIGHT) light else dark

    val Bg get() = cur.Bg
    val Card get() = cur.Card
    val Search get() = cur.Search
    val Line get() = cur.Line
    val TextPrimary get() = cur.TextPrimary
    val TextSecondary get() = cur.TextSecondary
    val TextMuted get() = cur.TextMuted
}

private class Palette(
    val Bg: Color,
    val Card: Color,
    val Search: Color,
    val Line: Color,
    val TextPrimary: Color,
    val TextSecondary: Color,
    val TextMuted: Color
)

private val DarkColors = darkColorScheme(
    primary = Ozon.Blue,
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF00316B),
    onPrimaryContainer = Color(0xFF9CC7FF),
    inversePrimary = Color(0xFF9CC7FF),
    secondary = Color(0xFF7A7A8A),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFF2A2A3E),
    onSecondaryContainer = Color(0xFFFFFFFF),
    tertiary = Ozon.Green,
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF0E4A41),
    onTertiaryContainer = Color(0xFF9DF0DC),
    background = Color(0xFF1A1A2E),
    onBackground = Color(0xFFFFFFFF),
    surface = Color(0xFF1A1A2E),
    onSurface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFF2A2A3E),
    onSurfaceVariant = Color(0xFF8E8E93),
    outline = Color(0xFF3A3A50),
    outlineVariant = Color(0xFF2A2A3E),
    error = Ozon.Pink,
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF64001F),
    onErrorContainer = Color(0xFFFFB4AB)
)

// Светлая схема: нейтралы инвертированы, акценты — те же (Ozon).
private val LightColors = lightColorScheme(
    primary = Ozon.Blue,
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFD6E6FF),
    onPrimaryContainer = Color(0xFF002B6B),
    inversePrimary = Color(0xFF00316B),
    secondary = Color(0xFF5A5A66),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE7E7EE),
    onSecondaryContainer = Color(0xFF16162A),
    tertiary = Ozon.Green,
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFD6F5EE),
    onTertiaryContainer = Color(0xFF0E4A41),
    background = Color(0xFFF1F1F6),
    onBackground = Color(0xFF16162A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF16162A),
    surfaceVariant = Color(0xFFE7E7EE),
    onSurfaceVariant = Color(0xFF55555F),
    outline = Color(0xFFD6D6E0),
    outlineVariant = Color(0xFFE7E7EE),
    error = Ozon.Pink,
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD9),
    onErrorContainer = Color(0xFF64001F)
)

// Ozon: крупные жирные заголовки (extra bold), основной текст обычный, цены/акценты bold.
val ShkaffTypography = Typography(
    headlineLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold, fontSize = 28.sp),
    headlineMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold, fontSize = 24.sp),
    titleLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 22.sp),
    titleMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, fontSize = 17.sp),
    titleSmall = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, fontSize = 15.sp),
    bodyLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 15.sp),
    bodyMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 14.sp),
    bodySmall = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 12.sp),
    labelLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, fontSize = 14.sp),
    labelMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Medium, fontSize = 12.sp),
    labelSmall = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Medium, fontSize = 11.sp)
)

private val ShkaffShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(14.dp),
    extraLarge = RoundedCornerShape(16.dp)
)

@Composable
fun ShkaffTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (Ozon.mode == ThemeMode.LIGHT) LightColors else DarkColors,
        typography = ShkaffTypography,
        shapes = ShkaffShapes,
        content = content
    )
}
