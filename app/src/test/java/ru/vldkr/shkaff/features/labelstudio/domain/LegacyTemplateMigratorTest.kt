package ru.vldkr.shkaff.features.labelstudio.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.LabelTemplateEntity

@RunWith(RobolectricTestRunner::class)
class LegacyTemplateMigratorTest {

    private fun template(
        format: String = "QR",
        layoutMode: String = "classic",
        textPosition: String = "bottom",
        appLink: Boolean = false,
        labelAttrs: String = "[]"
    ) = LabelTemplateEntity(
        id = "t1",
        name = "Шаблон",
        format = format,
        width_mm = 58.0,
        height_mm = 40.0,
        margin_mm = 3.0,
        show_text = true,
        text_content = "{name} {code}",
        font_size = 12.0,
        layout_mode = layoutMode,
        text_position = textPosition,
        app_link = appLink,
        label_attrs = labelAttrs,
        created_at = 1L,
        updated_at = 2L
    )

    @Test
    fun classic_qr_createsQrAndText() {
        val doc = LegacyTemplateMigrator.migrate(template())
        assertEquals(2, doc.elements.size)
        assertTrue(doc.elements[0] is QrElement)
        assertTrue(doc.elements[1] is TextElement)
        assertEquals(40f, doc.page.labelHeightMm, 0.001f)
        assertEquals(3f, doc.page.marginTopMm, 0.001f)
    }

    @Test
    fun code128_createsBarcodeElement() {
        val doc = LegacyTemplateMigrator.migrate(template(format = "CODE128"))
        assertTrue(doc.elements[0] is BarcodeElement)
        assertEquals("CODE128", (doc.elements[0] as BarcodeElement).symbology)
    }

    @Test
    fun appLink_usesTemplateContent() {
        val doc = LegacyTemplateMigrator.migrate(template(appLink = true))
        val qr = doc.elements[0] as QrElement
        assertEquals(ContentSource.Template("{{appLink}}"), qr.content)
    }

    @Test
    fun textContent_placeholdersConverted() {
        val doc = LegacyTemplateMigrator.migrate(template())
        val text = doc.elements[1] as TextElement
        assertEquals(ContentSource.Template("{{name}} {{code}}"), text.content)
    }

    @Test
    fun labelAttrs_addFieldElements() {
        val doc = LegacyTemplateMigrator.migrate(template(labelAttrs = """["material","brand"]"""))
        val fields = doc.elements.filterIsInstance<FieldElement>()
        assertEquals(2, fields.size)
        assertEquals("material", fields[0].key)
        assertEquals("brand", fields[1].key)
    }

    @Test
    fun layoutV_codeOnTopTextBelow() {
        val doc = LegacyTemplateMigrator.migrate(template(layoutMode = "v"))
        val code = doc.elements[0]
        val text = doc.elements[1] as TextElement
        assertTrue(code.yMm < text.yMm)
    }

    @Test
    fun layoutH_codeLeftTextRight() {
        val doc = LegacyTemplateMigrator.migrate(template(layoutMode = "h"))
        val code = doc.elements[0]
        val text = doc.elements[1] as TextElement
        assertTrue(code.xMm < text.xMm)
    }
}