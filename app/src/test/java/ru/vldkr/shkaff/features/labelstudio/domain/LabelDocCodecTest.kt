package ru.vldkr.shkaff.features.labelstudio.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class LabelDocCodecTest {

    @Test
    fun roundTrip_preserves_all_fields() {
        val doc = LabelDoc(
            id = "doc-1",
            name = "Этикетка вещи",
            page = PageSettings(
                paperWidthMm = 58f,
                printableWidthMm = 48f,
                labelHeightMm = 30f,
                gapMm = 3f,
                marginTopMm = 2f,
                marginBottomMm = 2f,
                invert = true,
                darkness = 10,
                feedLines = 5
            ),
            elements = listOf(
                QrElement(
                    id = "e1", xMm = 4f, yMm = 4f, widthMm = 20f, heightMm = 20f,
                    content = ContentSource.Field("code"), ecLevel = "H", quietZoneModules = 2, scale = 0.8f
                ),
                BarcodeElement(
                    id = "e2", xMm = 4f, yMm = 24f, widthMm = 40f, heightMm = 8f,
                    content = ContentSource.Static("12345"), symbology = "CODE128", showText = false
                ),
                TextElement(
                    id = "e3", xMm = 4f, yMm = 32f, widthMm = 40f, heightMm = 6f,
                    content = ContentSource.Template("{{name}} #{{code}}"),
                    sizeMm = 3f, bold = true, align = TextAlign.CENTER,
                    verticalAlign = VAlign.CENTER, maxLines = 2, background = true
                ),
                FieldElement(
                    id = "e4", xMm = 4f, yMm = 38f, widthMm = 40f, heightMm = 4f,
                    key = "material", label = "Материал:", fallback = "—", sizeMm = 2.5f, showLabel = true
                ),
                ImageElement(
                    id = "e5", xMm = 4f, yMm = 42f, widthMm = 10f, heightMm = 10f,
                    path = "/tmp/x.png", scaleMode = ScaleMode.FILL, dither = false, threshold = 200
                ),
                ShapeElement(
                    id = "e6", xMm = 4f, yMm = 52f, widthMm = 40f, heightMm = 1f,
                    shape = ShapeType.RECT, strokeMm = 0.5f, filled = true
                )
            ),
            updatedAt = 123456789L
        )

        val json = LabelDocCodec.toJson(doc)
        val back = LabelDocCodec.fromJson(json)

        assertEquals(doc.id, back.id)
        assertEquals(doc.name, back.name)
        assertEquals(doc.updatedAt, back.updatedAt)
        assertEquals(doc.page, back.page)
        assertEquals(doc.elements.size, back.elements.size)
        assertEquals(doc.elements, back.elements)
    }

    @Test
    fun roundTrip_emptyDoc() {
        val doc = LabelDoc(id = "d", name = "Пустая", elements = emptyList())
        val back = LabelDocCodec.fromJson(LabelDocCodec.toJson(doc))
        assertEquals(doc, back)
    }

    @Test
    fun fromJson_unknownType_fallsBackToText() {
        val json = """{"id":"x","name":"N","page":{},"elements":[{"type":"Unknown","id":"u1"}]}"""
        val doc = LabelDocCodec.fromJson(json)
        assertEquals(1, doc.elements.size)
        assertTrue(doc.elements[0] is TextElement)
    }

    @Test
    fun fromJson_missingFields_usesDefaults() {
        val doc = LabelDocCodec.fromJson("{}")
        assertEquals(58f, doc.page.paperWidthMm, 0.001f)
        assertEquals(48f, doc.page.printableWidthMm, 0.001f)
        assertTrue(doc.elements.isEmpty())
    }
}