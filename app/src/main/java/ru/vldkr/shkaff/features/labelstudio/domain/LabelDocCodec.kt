package ru.vldkr.shkaff.features.labelstudio.domain

import org.json.JSONArray
import org.json.JSONObject
import ru.vldkr.shkaff.util.newId

/**
 * Сериализация LabelDoc в JSON (org.json — как весь проект, без kotlinx-serialization).
 * Формат хранится в label_doc.doc_json и используется для экспорта/импорта шаблонов.
 */
object LabelDocCodec {

    fun toJson(doc: LabelDoc): String {
        val o = JSONObject()
        o.put("id", doc.id)
        o.put("name", doc.name)
        o.put("updatedAt", doc.updatedAt)
        o.put("page", pageToJson(doc.page))
        o.put("elements", JSONArray().apply {
            doc.elements.forEach { put(elementToJson(it)) }
        })
        return o.toString()
    }

    fun fromJson(json: String): LabelDoc {
        val o = JSONObject(json)
        val page = pageFromJson(o.optJSONObject("page") ?: JSONObject())
        val arr = o.optJSONArray("elements") ?: JSONArray()
        val elements = ArrayList<LabelElement>(arr.length())
        for (i in 0 until arr.length()) {
            elements += elementFromJson(arr.getJSONObject(i))
        }
        return LabelDoc(
            id = o.optString("id", newId()),
            name = o.optString("name", "Этикетка"),
            page = page,
            elements = elements,
            updatedAt = o.optLong("updatedAt", System.currentTimeMillis())
        )
    }

    private fun pageToJson(p: PageSettings): JSONObject = JSONObject().apply {
        put("paperWidthMm", p.paperWidthMm.toDouble())
        put("printableWidthMm", p.printableWidthMm.toDouble())
        put("labelHeightMm", p.labelHeightMm.toDouble())
        put("minHeightMm", p.minHeightMm.toDouble())
        put("maxHeightMm", p.maxHeightMm.toDouble())
        put("gapMm", p.gapMm.toDouble())
        put("marginTopMm", p.marginTopMm.toDouble())
        put("marginBottomMm", p.marginBottomMm.toDouble())
        put("marginLeftMm", p.marginLeftMm.toDouble())
        put("marginRightMm", p.marginRightMm.toDouble())
        put("invert", p.invert)
        put("darkness", p.darkness)
        put("feedLines", p.feedLines)
    }

    private fun pageFromJson(o: JSONObject): PageSettings = PageSettings(
        paperWidthMm = o.optDouble("paperWidthMm", 58.0).toFloat(),
        printableWidthMm = o.optDouble("printableWidthMm", 48.0).toFloat(),
        labelHeightMm = o.optDouble("labelHeightMm", 0.0).toFloat(),
        minHeightMm = o.optDouble("minHeightMm", 10.0).toFloat(),
        maxHeightMm = o.optDouble("maxHeightMm", 200.0).toFloat(),
        gapMm = o.optDouble("gapMm", 2.5).toFloat(),
        marginTopMm = o.optDouble("marginTopMm", 2.0).toFloat(),
        marginBottomMm = o.optDouble("marginBottomMm", 2.0).toFloat(),
        marginLeftMm = o.optDouble("marginLeftMm", 0.0).toFloat(),
        marginRightMm = o.optDouble("marginRightMm", 0.0).toFloat(),
        invert = o.optBoolean("invert", false),
        darkness = o.optInt("darkness", 8),
        feedLines = o.optInt("feedLines", 3)
    )

    private fun elementToJson(el: LabelElement): JSONObject {
        val o = JSONObject()
        o.put("type", el.javaClass.simpleName)
        o.put("id", el.id)
        o.put("xMm", el.xMm.toDouble())
        o.put("yMm", el.yMm.toDouble())
        o.put("widthMm", el.widthMm.toDouble())
        o.put("heightMm", el.heightMm.toDouble())
        o.put("rotationDeg", el.rotationDeg)
        o.put("zIndex", el.zIndex)
        o.put("locked", el.locked)

        when (el) {
            is QrElement -> {
                o.put("content", contentToJson(el.content))
                o.put("ecLevel", el.ecLevel)
                o.put("quietZoneModules", el.quietZoneModules)
                o.put("scale", el.scale.toDouble())
            }
            is BarcodeElement -> {
                o.put("content", contentToJson(el.content))
                o.put("symbology", el.symbology)
                o.put("showText", el.showText)
            }
            is TextElement -> {
                o.put("content", contentToJson(el.content))
                o.put("fontName", el.fontName)
                o.put("sizeMm", el.sizeMm.toDouble())
                o.put("bold", el.bold)
                o.put("align", el.align.name)
                o.put("verticalAlign", el.verticalAlign.name)
                o.put("lineHeight", el.lineHeight.toDouble())
                o.put("maxLines", el.maxLines)
                o.put("background", el.background)
            }
            is FieldElement -> {
                o.put("key", el.key)
                o.put("label", el.label)
                o.put("fallback", el.fallback)
                o.put("sizeMm", el.sizeMm.toDouble())
                o.put("showLabel", el.showLabel)
            }
            is ImageElement -> {
                o.put("path", el.path)
                o.put("scaleMode", el.scaleMode.name)
                o.put("dither", el.dither)
                o.put("threshold", el.threshold)
            }
            is ShapeElement -> {
                o.put("shape", el.shape.name)
                o.put("strokeMm", el.strokeMm.toDouble())
                o.put("filled", el.filled)
            }
        }
        return o
    }

    private fun elementFromJson(o: JSONObject): LabelElement {
        val id = o.optString("id", newId())
        val x = o.optDouble("xMm", 0.0).toFloat()
        val y = o.optDouble("yMm", 0.0).toFloat()
        val w = o.optDouble("widthMm", 10.0).toFloat()
        val h = o.optDouble("heightMm", 10.0).toFloat()
        val rot = o.optInt("rotationDeg", 0)
        val z = o.optInt("zIndex", 0)
        val locked = o.optBoolean("locked", false)

        return when (o.optString("type")) {
            "QrElement" -> QrElement(
                id = id, xMm = x, yMm = y, widthMm = w, heightMm = h,
                rotationDeg = rot, zIndex = z, locked = locked,
                content = contentFromJson(o.optJSONObject("content")),
                ecLevel = o.optString("ecLevel", "M"),
                quietZoneModules = o.optInt("quietZoneModules", 4),
                scale = o.optDouble("scale", 1.0).toFloat()
            )
            "BarcodeElement" -> BarcodeElement(
                id = id, xMm = x, yMm = y, widthMm = w, heightMm = h,
                rotationDeg = rot, zIndex = z, locked = locked,
                content = contentFromJson(o.optJSONObject("content")),
                symbology = o.optString("symbology", "CODE128"),
                showText = o.optBoolean("showText", true)
            )
            "TextElement" -> TextElement(
                id = id, xMm = x, yMm = y, widthMm = w, heightMm = h,
                rotationDeg = rot, zIndex = z, locked = locked,
                content = contentFromJson(o.optJSONObject("content")),
                fontName = o.optString("fontName", "sans"),
                sizeMm = o.optDouble("sizeMm", 3.5).toFloat(),
                bold = o.optBoolean("bold", false),
                align = runCatching { TextAlign.valueOf(o.optString("align", "LEFT")) }.getOrDefault(TextAlign.LEFT),
                verticalAlign = runCatching { VAlign.valueOf(o.optString("verticalAlign", "TOP")) }.getOrDefault(VAlign.TOP),
                lineHeight = o.optDouble("lineHeight", 1.2).toFloat(),
                maxLines = o.optInt("maxLines", 3),
                background = o.optBoolean("background", false)
            )
            "FieldElement" -> FieldElement(
                id = id, xMm = x, yMm = y, widthMm = w, heightMm = h,
                rotationDeg = rot, zIndex = z, locked = locked,
                key = o.optString("key", "code"),
                label = o.optString("label", ""),
                fallback = o.optString("fallback", ""),
                sizeMm = o.optDouble("sizeMm", 2.5).toFloat(),
                showLabel = o.optBoolean("showLabel", true)
            )
            "ImageElement" -> ImageElement(
                id = id, xMm = x, yMm = y, widthMm = w, heightMm = h,
                rotationDeg = rot, zIndex = z, locked = locked,
                path = o.optString("path", ""),
                scaleMode = runCatching { ScaleMode.valueOf(o.optString("scaleMode", "FIT")) }.getOrDefault(ScaleMode.FIT),
                dither = o.optBoolean("dither", true),
                threshold = o.optInt("threshold", 128)
            )
            "ShapeElement" -> ShapeElement(
                id = id, xMm = x, yMm = y, widthMm = w, heightMm = h,
                rotationDeg = rot, zIndex = z, locked = locked,
                shape = runCatching { ShapeType.valueOf(o.optString("shape", "LINE")) }.getOrDefault(ShapeType.LINE),
                strokeMm = o.optDouble("strokeMm", 0.3).toFloat(),
                filled = o.optBoolean("filled", false)
            )
            else -> TextElement(id = id, xMm = x, yMm = y, widthMm = w, heightMm = h)
        }
    }

    private fun contentToJson(c: ContentSource): JSONObject = when (c) {
        is ContentSource.Static -> JSONObject().put("t", "static").put("v", c.value)
        is ContentSource.Field -> JSONObject().put("t", "field").put("k", c.key).put("f", c.fallback)
        is ContentSource.Template -> JSONObject().put("t", "template").put("p", c.pattern)
    }

    private fun contentFromJson(o: JSONObject?): ContentSource {
        if (o == null) return ContentSource.Field("code")
        return when (o.optString("t")) {
            "static" -> ContentSource.Static(o.optString("v"))
            "field" -> ContentSource.Field(o.optString("k", "code"), o.optString("f"))
            "template" -> ContentSource.Template(o.optString("p"))
            else -> ContentSource.Field("code")
        }
    }
}