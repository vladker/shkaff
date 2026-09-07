package ru.vldkr.shkaff.domain.batch

import org.junit.Assert.assertEquals
import org.junit.Test

class BatchPlanTest {

    @Test
    fun `expandName без шаблона возвращает имя без изменений`() {
        assertEquals("Батарейки AA", BatchPlan.expandName("Батарейки AA", 1))
        assertEquals("Батарейки AA", BatchPlan.expandName("Батарейки AA", 42))
    }

    @Test
    fun `expandName подставляет номер позиции`() {
        assertEquals("Батарея AA 1", BatchPlan.expandName("Батарея AA {n}", 1))
        assertEquals("Батарея AA 10", BatchPlan.expandName("Батарея AA {n}", 10))
        assertEquals("Коробка-3", BatchPlan.expandName("Коробка-{n}", 3))
    }

    @Test
    fun `expandName подставляет все вхождения шаблона одним номером`() {
        assertEquals("n1 из n1", BatchPlan.expandName("n{n} из n{n}", 1))
        assertEquals("n10 из n10", BatchPlan.expandName("n{n} из n{n}", 10))
    }

    @Test
    fun `expandName тримует пробелы по краям`() {
        assertEquals("X 5 Y", BatchPlan.expandName("  X {n} Y  ", 5))
    }

    @Test
    fun `copiedAttrs оставляет только не отмеченные поля`() {
        val all = mapOf("a" to "1", "b" to "2", "c" to "3")
        assertEquals(mapOf("a" to "1", "c" to "3"), BatchPlan.copiedAttrs(all, setOf("b")))
        assertEquals(emptyMap<String, String>(), BatchPlan.copiedAttrs(all, setOf("a", "b", "c")))
        assertEquals(all, BatchPlan.copiedAttrs(all, emptySet()))
    }

    @Test
    fun `mergeValues значения позиции преобладают над общими`() {
        val copied = mapOf("a" to "1", "b" to "2")
        val perItem = mapOf("b" to "X", "c" to "3")
        assertEquals(mapOf("a" to "1", "b" to "X", "c" to "3"), BatchPlan.mergeValues(copied, perItem))
    }

    @Test
    fun `mergeValues с пустыми позиционными значениями оставляет общие`() {
        val copied = mapOf("a" to "1")
        assertEquals(mapOf("a" to "1"), BatchPlan.mergeValues(copied, emptyMap()))
    }

    @Test
    fun `максимальный размер серии ограничен`() {
        org.junit.Assert.assertTrue(BatchPlan.MAX_SERIES >= 10)
    }
}
