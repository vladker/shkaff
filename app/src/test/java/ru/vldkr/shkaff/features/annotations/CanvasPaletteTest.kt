package ru.vldkr.shkaff.features.annotations

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.ui.theme.ShkaffTypography

// Роли подобраны «отличными» друг от друга и от дефолтов Material3,
// чтобы доказать привязку палитры к ColorScheme, а не к литералам.
private val light =
    lightColorScheme(
        primary = Color(0xFF111111),
        primaryContainer = Color(0xFF222222),
        onPrimaryContainer = Color(0xFF333333),
    )
private val dark =
    darkColorScheme(
        primary = Color(0xFFAAAAAA),
        primaryContainer = Color(0xFFBBBBBB),
        onPrimaryContainer = Color(0xFFCCCCCC),
    )

class CanvasPaletteTest {
    @Test
    fun `схема следует за светлой ColorScheme`() {
        val p = schematicPalette(light, ShkaffTypography)
        assertEquals(light.primaryContainer, p.blockFill)
        assertEquals(light.primary, p.blockStroke)
        assertEquals(light.onPrimaryContainer, p.blockText)
    }

    @Test
    fun `схема следует за тёмной ColorScheme`() {
        val p = schematicPalette(dark, ShkaffTypography)
        assertEquals(dark.primaryContainer, p.blockFill)
        assertEquals(dark.primary, p.blockStroke)
        assertEquals(dark.onPrimaryContainer, p.blockText)
    }

    @Test
    fun `палитры светлой и тёмной схем различаются`() {
        val l = schematicPalette(light, ShkaffTypography)
        val d = schematicPalette(dark, ShkaffTypography)
        assertNotEquals(l.blockFill, d.blockFill)
        assertNotEquals(l.blockText, d.blockText)
    }

    @Test
    fun `подпись блока наследует типографику темы`() {
        val p = schematicPalette(light, ShkaffTypography)
        assertEquals(ShkaffTypography.titleSmall, p.labelBase)
    }

    @Test
    fun `выделение аннотации берёт primary темы`() {
        assertEquals(light.primary, annotationPalette(light).selectedStroke)
        assertEquals(dark.primary, annotationPalette(dark).selectedStroke)
    }

    @Test
    fun `черновик разметки — акцент Ozon в светлой теме`() {
        assertEquals(Ozon.Orange, annotationPalette(light).draftColor)
    }

    @Test
    fun `черновик разметки одинаков в тёмной теме`() {
        assertEquals(Ozon.Orange, annotationPalette(dark).draftColor)
    }
}
