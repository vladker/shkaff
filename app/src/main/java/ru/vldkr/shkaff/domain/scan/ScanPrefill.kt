package ru.vldkr.shkaff.domain.scan

// T-010: цель предзаполнения отсканированного кода в форме вещи. Чистый числовой код
// 8–13 разрядов (EAN-8/13, UPC-A) — товарный штрихкод, кладём в поле «Штрихкод (EAN)»:
// только с ним работают умный поиск товара и поиск «Найти» по штрихкоду. Всё остальное
// (артикул, номер вещи, ULID из ADD, служебные QR) — в «Код / номер».
object ScanPrefill {
    fun isEanLike(code: String): Boolean {
        val t = code.trim()
        return t.length in 8..13 && t.all { it.isDigit() }
    }
}
