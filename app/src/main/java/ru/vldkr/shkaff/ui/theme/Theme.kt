package ru.vldkr.shkaff.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Палитра в стиле Ozon: фирменный синий #005BFF, белые карточки на светло-сером фоне.
private val LightColors = lightColorScheme(
    primary = Color(0xFF005BFF),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFE0EBFF),
    onPrimaryContainer = Color(0xFF002E7A),
    inversePrimary = Color(0xFF9CC7FF),
    secondary = Color(0xFF2E3A5A),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD9E2F8),
    onSecondaryContainer = Color(0xFF15203C),
    tertiary = Color(0xFF00875A),
    onTertiary = Color(0xFFFFFFFF),
    background = Color(0xFFF4F5F8),
    onBackground = Color(0xFF16181A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF16181A),
    surfaceVariant = Color(0xFFEAECF0),
    onSurfaceVariant = Color(0xFF585F66),
    outline = Color(0xFFD9DCE0),
    outlineVariant = Color(0xFFE4E7EB),
    error = Color(0xFFBA1A1A)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF7EA6FF),
    onPrimary = Color(0xFF002E7A),
    primaryContainer = Color(0xFF00399F),
    onPrimaryContainer = Color(0xFFDCE6FF),
    secondary = Color(0xFFB4C3E8),
    onSecondary = Color(0xFF1E2948),
    secondaryContainer = Color(0xFF354060),
    onSecondaryContainer = Color(0xFFD9E2F8),
    tertiary = Color(0xFF62D9A8),
    onTertiary = Color(0xFF003823),
    background = Color(0xFF15161A),
    onBackground = Color(0xFFE3E5E8),
    surface = Color(0xFF15161A),
    onSurface = Color(0xFFE3E5E8),
    surfaceVariant = Color(0xFF292C33),
    onSurfaceVariant = Color(0xFFC2C7CF),
    outline = Color(0xFF454950),
    error = Color(0xFFFFB4AB)
)

// Ozon: крупные заголовки жирные, основной текст обычный.
val ShkaffTypography = Typography(
    headlineLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 28.sp),
    headlineMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Bold, fontSize = 24.sp),
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
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = ShkaffTypography,
        shapes = ShkaffShapes,
        content = content
    )
}