package ru.vldkr.shkaff.domain.scan

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

// T-010: скан рыночного штрихкода должен попадать в поле EAN, а не в «Код / номер» —
// иначе умный поиск по штрихкоду и поиск «Найти» не заводятся. Цель предзаполнения —
// чистый предикат: числовые 8–13 разрядов (EAN-8/13, UPC-A) = товарный штрихкод.
class ScanPrefillTest {

    @Test
    fun `Товарные штрихкоды EAN-8, EAN-13, UPC-A распознаются как EAN`() {
        assertTrue(ScanPrefill.isEanLike("96385074"))          // EAN-8
        assertTrue(ScanPrefill.isEanLike("3073781003641"))     // EAN-13
        assertTrue(ScanPrefill.isEanLike("0012345678905"))     // EAN-13 с ведущим нулём
        assertTrue(ScanPrefill.isEanLike("036000291452"))      // UPC-A (12 разрядов)
        assertTrue(ScanPrefill.isEanLike("12345678"))          // ровно 8
        assertTrue(ScanPrefill.isEanLike("1234567890123"))     // ровно 13
    }

    @Test
    fun `Артикул, ULID и служебный код — не EAN`() {
        assertFalse(ScanPrefill.isEanLike(""))
        assertFalse(ScanPrefill.isEanLike("   "))
        assertFalse(ScanPrefill.isEanLike("1234567"))                       // 7 — коротко
        assertFalse(ScanPrefill.isEanLike("12345678901234"))                // 14 — не помещается
        assertFalse(ScanPrefill.isEanLike("ABC-123456"))                    // артикул с буквами
        assertFalse(ScanPrefill.isEanLike("01HZY3K9F2M8QW5T7XJ4NPEZVB"))    // ULID
        assertFalse(ScanPrefill.isEanLike("shkaff:v1:move:item:01HZY3K9F2M8QW5T7XJ4NPEZVB"))
        assertFalse(ScanPrefill.isEanLike("30737 81003641"))                // пробел внутри
    }

    @Test
    fun `Ведущие и хвостовые пробелы скану не помеха`() {
        assertTrue(ScanPrefill.isEanLike("  3073781003641 "))
    }
}
