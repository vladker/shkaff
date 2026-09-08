package ru.vldkr.shkaff.export

// Таблица для экспорта: заголовок листа + строки (null/пусто — пустая ячейка)
data class Sheet(
    val title: String,
    val headers: List<String>,
    val rows: List<List<String?>>
)
