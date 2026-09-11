package ru.vldkr.shkaff.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Палитра и акценты в точности по описанию интерфейса Ozon (тёмная тема).
object Ozon {
    val Blue = Color(0xFF0066FF)
    val Pink = Color(0xFFFF2D55)
    val Yellow = Color(0xFFFFD60A)
    val Cyan = Color(0xFF00D4FF)
    val Teal = Color(0xFF2A9D8F)
    val Orange = Color(0xFFF59E0B)
    val Purple = Color(0xFF8B5CF6)
    val Green = Color(0xFF10B981)
    val Bg = Color(0xFF1A1A2E)
    val Card = Color(0xFF2A2A3E)
    val Search = Color(0xFF2D2D44)
    val Line = Color(0xFF3A3A50)
    val TextPrimary = Color(0xFFFFFFFF)
    val TextSecondary = Color(0xFF8E8E93)
    val TextMuted = Color(0xFF6B6B7B)
}

// Единственная тема — тёмная (как интерфейс Ozon на скриншоте). Светлой темы нет.
private val DarkColors = darkColorScheme(
    primary = Ozon.Blue,
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFF00316B),
    onPrimaryContainer = Color(0xFF9CC7FF),
    inversePrimary = Color(0xFF9CC7FF),
    secondary = Color(0xFF7A7A8A),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Ozon.Card,
    onSecondaryContainer = Ozon.TextPrimary,
    tertiary = Ozon.Green,
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFF0E4A41),
    onTertiaryContainer = Color(0xFF9DF0DC),
    background = Ozon.Bg,
    onBackground = Ozon.TextPrimary,
    surface = Ozon.Bg,
    onSurface = Ozon.TextPrimary,
    surfaceVariant = Ozon.Card,
    onSurfaceVariant = Ozon.TextSecondary,
    outline = Ozon.Line,
    outlineVariant = Ozon.Card,
    error = Ozon.Pink,
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFF64001F),
    onErrorContainer = Color(0xFFFFB4AB)
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
        colorScheme = DarkColors,
        typography = ShkaffTypography,
        shapes = ShkaffShapes,
        content = content
    )
}