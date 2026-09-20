package ru.vldkr.shkaff.features.labelstudio.domain

import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.features.labels.LabelGenerator

/**
 * Конвертация «классических» шаблонов (label_template, layout_mode classic/auto/v/h)
 * в документ LabelStudio. Используется при первом открытии этикетки объекта:
 * старый шаблон превращается в редактируемый LabelDoc, дальше живёт в label_doc.
 */
object LegacyTemplateMigrator {

    fun migrate(t: LabelTemplateEntity): LabelDoc {
        val margin = t.margin_mm.toFloat()
        val paperW = 58f
        val printableW = 48f
        val labelH = t.height_mm.toFloat()

        val page = PageSettings(
            paperWidthMm = paperW,
            printableWidthMm = printableW,
            labelHeightMm = labelH,
            minHeightMm = 10f,
            maxHeightMm = 200f,
            gapMm = 2.5f,
            marginTopMm = margin,
            marginBottomMm = margin,
            marginLeftMm = 0f,
            marginRightMm = 0f,
            invert = t.invert,
            darkness = 8,
            feedLines = 3
        )

        val innerW = (printableW - margin * 2).coerceAtLeast(8f)
        val innerH = (labelH - margin * 2).coerceAtLeast(8f)

        val elements = mutableListOf<LabelElement>()
        val isQr = t.format.equals("QR", ignoreCase = true)
        val codeContent: ContentSource =
            if (t.app_link) ContentSource.Template("{{appLink}}") else ContentSource.Field("code")

        val textContent = t.text_content
            .replace("{name}", "{{name}}")
            .replace("{code}", "{{code}}")
            .replace("{id}", "{{id}}")
        val textSizeMm = (t.font_size * 25.4f / 72f).toFloat().coerceIn(1.5f, 8f)

        val layout = t.layout_mode.lowercase()
        when (layout) {
            "h" -> {
                // Код слева (60% ширины), текст справа.
                val codeW = innerW * 0.6f
                val textW = innerW - codeW
                addCode(elements, isQr, codeContent, t, margin, margin, codeW, innerH)
                elements += TextElement(
                    xMm = margin + codeW,
                    yMm = margin,
                    widthMm = textW,
                    heightMm = innerH,
                    content = ContentSource.Template(textContent),
                    sizeMm = textSizeMm,
                    align = TextAlign.LEFT,
                    verticalAlign = VAlign.CENTER,
                    maxLines = 4
                )
            }
            "v", "auto" -> {
                // Код сверху (65% высоты), текст снизу.
                val codeH = innerH * 0.65f
                val textH = innerH - codeH
                addCode(elements, isQr, codeContent, t, margin, margin, innerW, codeH)
                elements += TextElement(
                    xMm = margin,
                    yMm = margin + codeH,
                    widthMm = innerW,
                    heightMm = textH,
                    content = ContentSource.Template(textContent),
                    sizeMm = textSizeMm,
                    align = TextAlign.CENTER,
                    verticalAlign = VAlign.CENTER,
                    maxLines = 3
                )
            }
            else -> {
                // classic: текст сверху или снизу, код в остальной области.
                val textOnTop = t.text_position.equals("top", ignoreCase = true)
                val textH = (innerH * 0.3f).coerceAtMost(14f)
                val codeH = innerH - textH
                val codeY = if (textOnTop) margin + textH else margin
                val textY = if (textOnTop) margin else margin + codeH
                addCode(elements, isQr, codeContent, t, margin, codeY, innerW, codeH)
                elements += TextElement(
                    xMm = margin,
                    yMm = textY,
                    widthMm = innerW,
                    heightMm = textH,
                    content = ContentSource.Template(textContent),
                    sizeMm = textSizeMm,
                    align = TextAlign.CENTER,
                    verticalAlign = VAlign.CENTER,
                    maxLines = 3
                )
            }
        }

        // Атрибуты объекта — отдельными строками «ключ: значение» под текстом.
        val attrKeys = LabelGenerator.labelAttrKeys(t)
        if (attrKeys.isNotEmpty()) {
            val lastY = elements.maxOfOrNull { it.yMm + it.heightMm } ?: margin
            var y = lastY + 1f
            for (key in attrKeys) {
                elements += FieldElement(
                    xMm = margin,
                    yMm = y,
                    widthMm = innerW,
                    heightMm = 3.5f,
                    key = key,
                    label = "",
                    sizeMm = 2.5f,
                    showLabel = false
                )
                y += 3.5f
            }
        }

        return LabelDoc(
            name = t.name,
            page = page,
            elements = elements,
            updatedAt = System.currentTimeMillis()
        )
    }

    private fun addCode(
        elements: MutableList<LabelElement>,
        isQr: Boolean,
        content: ContentSource,
        t: LabelTemplateEntity,
        x: Float,
        y: Float,
        w: Float,
        h: Float
    ) {
        if (isQr) {
            elements += QrElement(
                xMm = x, yMm = y, widthMm = w, heightMm = h,
                content = content,
                ecLevel = "M",
                quietZoneModules = if (t.quiet_zone) 4 else 0,
                scale = t.qr_scale.toFloat()
            )
        } else {
            elements += BarcodeElement(
                xMm = x, yMm = y, widthMm = w, heightMm = h,
                content = content,
                symbology = t.format,
                showText = t.show_text
            )
        }
    }
}