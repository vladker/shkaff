package ru.vldkr.shkaff.export

import java.nio.charset.StandardCharsets

// RFC4180: ячейки с запятой/кавычкой/переносом оборачиваются в кавычки,
// кавычка внутри удваивается
fun Sheet.toCsv(): String {
    val sb = StringBuilder()
    fun cell(v: String?) {
        val s = v.orEmpty()
        if (s.any { it == '"' || it == ',' || it == '\n' || it == '\r' }) {
            sb.append('"').append(s.replace("\"", "\"\"")).append('"')
        } else {
            sb.append(s)
        }
    }
    val all: List<List<String?>> = listOf(headers.map { it as String? }) + rows
    for (row in all) {
        row.forEachIndexed { idx, v ->
            if (idx > 0) sb.append(',')
            cell(v)
        }
        sb.append("\r\n")
    }
    return sb.toString()
}

// BOM в начале, чтобы Excel корректно определил UTF-8 (кириллица)
fun Sheet.csvBytes(): ByteArray =
    "\uFEFF".toByteArray(StandardCharsets.UTF_8) + toCsv().toByteArray(StandardCharsets.UTF_8)
