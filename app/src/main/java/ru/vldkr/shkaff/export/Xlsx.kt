package ru.vldkr.shkaff.export

import java.io.OutputStream
import java.nio.charset.StandardCharsets
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

// Минимальный XLSX-запись: zip с OOXML-частьями.
// Инлайновые строки (без sharedStrings/styles-зависимостей) — без внешних библиотек.
fun Sheet.toXlsx(out: OutputStream) {
    ZipOutputStream(out.buffered()).use { zip ->
        zip.putEntry("[Content_Types].xml", contentTypes())
        zip.putEntry("_rels/.rels", rootRels())
        zip.putEntry("xl/workbook.xml", workbook())
        zip.putEntry("xl/_rels/workbook.xml.rels", workbookRels())
        zip.putEntry("xl/styles.xml", styles())
        zip.putEntry("xl/worksheets/sheet1.xml", sheetXml())
    }
}

private fun ZipOutputStream.putEntry(name: String, data: ByteArray) {
    putNextEntry(ZipEntry(name))
    write(data)
    closeEntry()
}

private fun Sheet.contentTypes(): ByteArray {
    val xml = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Types xmlns="http://schemas.openxmlformats.org/package/2006/content-types"><Default Extension="rels" ContentType="application/vnd.openxmlformats-package.relationships+xml"/><Default Extension="xml" ContentType="application/xml"/><Override PartName="/xl/workbook.xml" ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet.main+xml"/><Override PartName="/xl/worksheets/sheet1.xml" ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.worksheet+xml"/><Override PartName="/xl/styles.xml" ContentType="application/vnd.openxmlformats-officedocument.spreadsheetml.styles+xml"/></Types>"""
    return xml.toByteArray(StandardCharsets.UTF_8)
}

private fun Sheet.rootRels(): ByteArray {
    val xml = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships"><Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument" Target="xl/workbook.xml"/></Relationships>"""
    return xml.toByteArray(StandardCharsets.UTF_8)
}

private fun Sheet.workbook(): ByteArray {
    val xml = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<workbook xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main" xmlns:r="http://schemas.openxmlformats.org/officeDocument/2006/relationships"><sheets><sheet name="${xmlEscape(sheetName())}" sheetId="1" r:id="rId1"/></sheets></workbook>"""
    return xml.toByteArray(StandardCharsets.UTF_8)
}

private fun Sheet.workbookRels(): ByteArray {
    val xml = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Relationships xmlns="http://schemas.openxmlformats.org/package/2006/relationships"><Relationship Id="rId1" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/worksheet" Target="worksheets/sheet1.xml"/><Relationship Id="rId2" Type="http://schemas.openxmlformats.org/officeDocument/2006/relationships/styles" Target="styles.xml"/></Relationships>"""
    return xml.toByteArray(StandardCharsets.UTF_8)
}

private fun Sheet.styles(): ByteArray {
    val xml = """<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<styleSheet xmlns="http://schemas.openxmlformats.org/spreadsheetml/2006/main"><fonts count="1"><font><sz val="11"/><name val="Calibri"/></font></fonts><fills count="2"><fill><patternFill patternType="none"/></patternFill><fill><patternFill patternType="gray125"/></patternFill></fills><borders count="1"><border><left/><right/><top/><bottom/><diagonal/></border></borders><cellStyleXfs count="1"><xf numFmtId="0" fontId="0" fillId="0" borderId="0"/></cellStyleXfs><cellXfs count="1"><xf numFmtId="0" fontId="0" fillId="0" borderId="0" xfId="0"/></cellXfs></styleSheet>"""
    return xml.toByteArray(StandardCharsets.UTF_8)
}

private fun Sheet.sheetXml(): ByteArray {
    val sb = StringBuilder()
    sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
    sb.append("<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\"><sheetData>")
    val all: List<List<String?>> = listOf(headers.map { it as String? }) + rows
    all.forEachIndexed { ri, row ->
        val r = ri + 1
        sb.append("<row r=\"").append(r).append("\">")
        row.forEachIndexed { ci, v ->
            sb.append("<c r=\"").append(colName(ci)).append(r).append("\" t=\"inlineStr\"><is><t xml:space=\"preserve\">")
            sb.append(xmlEscape(v.orEmpty()))
            sb.append("</t></is></c>")
        }
        sb.append("</row>")
    }
    sb.append("</sheetData></worksheet>")
    return sb.toString().toByteArray(StandardCharsets.UTF_8)
}

// A..Z, AA..
private fun colName(idx: Int): String {
    var n = idx
    val sb = StringBuilder()
    do {
        sb.append(('A' + (n % 26)))
        n = n / 26 - 1
    } while (n >= 0)
    return sb.reverse().toString()
}

// Имя листа: без []:*?/, не длиннее 31 символа
private fun Sheet.sheetName(): String =
    title.replace(Regex("[\\[\\]:*?/]"), " ").trim().ifBlank { "Лист" }.take(31)

private fun xmlEscape(s: String): String =
    s.replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&apos;")
