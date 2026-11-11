package ru.vldkr.shkaff.domain.tags

import org.junit.Assert.assertEquals
import org.junit.Test

// T-039: ряд чипов тега-фильтра на «Вещях» рендерился только при непустом словаре
// (tagOptions). Тег, пришедший из дашборда по роуту items/<tag> мимо словаря,
// оставлял фильтр активным, но невидимым и неснимаемым.
class TagChipRowTest {

    @Test
    fun `active tag outside the dictionary still lands in the chip row`() {
        assertEquals(listOf("гараж"), TagChipRow.row(emptyList(), "гараж"))
    }

    @Test
    fun `dictionary stays as is when no tag is active`() {
        val dict = listOf("Инструмент", "Книги")
        assertEquals(dict, TagChipRow.row(dict, ""))
    }

    @Test
    fun `active tag already in dictionary is not duplicated even with other case`() {
        val dict = listOf("Инструмент", "Книги")
        assertEquals(dict, TagChipRow.row(dict, "книги"))
    }

    @Test
    fun `ghost active tag is appended once after the dictionary`() {
        val dict = listOf("Книги")
        assertEquals(listOf("Книги", "Гараж"), TagChipRow.row(dict, "Гараж"))
    }

    @Test
    fun `duplicates in the dictionary collapse`() {
        assertEquals(listOf("Книги"), TagChipRow.row(listOf("Книги", "Книги"), ""))
    }
}
