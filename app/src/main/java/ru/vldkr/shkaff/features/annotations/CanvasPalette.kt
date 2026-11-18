package ru.vldkr.shkaff.features.annotations

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import ru.vldkr.shkaff.ui.theme.Ozon

// Палитра Canvas-отрисовки схемы хранилища (SchematicView).
// Чистые функции вместо @Composable: палитру захватываем до блока Canvas,
// внутри DrawScope Compose-функции уже недоступны.
data class SchematicPalette(
    val blockFill: Color,
    val blockStroke: Color,
    val blockText: Color,
    val labelBase: TextStyle,
)

// Палитра редактора разметки (AnnotationScreen): выделение и черновик прямоугольника.
data class AnnotationPalette(
    val selectedStroke: Color,
    val draftColor: Color,
)

fun schematicPalette(
    scheme: ColorScheme,
    typography: Typography,
): SchematicPalette =
    SchematicPalette(
        blockFill = scheme.primaryContainer,
        blockStroke = scheme.primary,
        blockText = scheme.onPrimaryContainer,
        labelBase = typography.titleSmall,
    )

fun annotationPalette(scheme: ColorScheme): AnnotationPalette =
    AnnotationPalette(
        selectedStroke = scheme.primary,
        // Акцент Ozon.Orange одинаков в обеих темах — он и в светлой, и в тёмной читается.
        draftColor = Ozon.Orange,
    )
