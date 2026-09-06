package ru.vldkr.shkaff.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val LightColors = lightColorScheme(
    primary = Color(0xFF3E5C4B),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFDCEEE2),
    onPrimaryContainer = Color(0xFF0F2A1D),
    secondary = Color(0xFF5C543E),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFEFDFC8),
    onSecondaryContainer = Color(0xFF241F12),
    tertiary = Color(0xFF4E5A6B),
    background = Color(0xFFF7F3EC),
    onBackground = Color(0xFF1C1B18),
    surface = Color(0xFFF7F3EC),
    onSurface = Color(0xFF1C1B18),
    surfaceVariant = Color(0xFFE9E2D4),
    onSurfaceVariant = Color(0xFF4A463C),
    error = Color(0xFFBA1A1A)
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFA3C9B2),
    onPrimary = Color(0xFF10281B),
    primaryContainer = Color(0xFF2A4537),
    onPrimaryContainer = Color(0xFFDCEEE2),
    secondary = Color(0xFFD4C29E),
    onSecondary = Color(0xFF2E291A),
    secondaryContainer = Color(0xFF463F2C),
    onSecondaryContainer = Color(0xFFEFDFC8),
    background = Color(0xFF171A18),
    onBackground = Color(0xFFE6E3DC),
    surface = Color(0xFF171A18),
    onSurface = Color(0xFFE6E3DC),
    surfaceVariant = Color(0xFF2B2D29),
    onSurfaceVariant = Color(0xFFC4BFB2),
    error = Color(0xFFFFB4AB)
)

val ShkaffTypography = Typography(
    titleLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, fontSize = 22.sp),
    titleMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.SemiBold, fontSize = 17.sp),
    bodyLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 15.sp),
    bodyMedium = TextStyle(fontFamily = FontFamily.SansSerif, fontSize = 14.sp),
    labelLarge = TextStyle(fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.Medium, fontSize = 14.sp)
)

@Composable
fun ShkaffTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = ShkaffTypography,
        content = content
    )
}
