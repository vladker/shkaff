package ru.vldkr.shkaff.util

import org.junit.Assert.assertEquals
import org.junit.Test

/** Русская плюрализация форм: 1 вещь / 2 вещи / 5 вещей. */
class PluralRuTest {
    @Test
    fun oneForm() {
        assertEquals("1 вещь", pluralRu(1, "вещь", "вещи", "вещей"))
        assertEquals("21 вещь", pluralRu(21, "вещь", "вещи", "вещей"))
        assertEquals("101 вещь", pluralRu(101, "вещь", "вещи", "вещей"))
    }

    @Test
    fun fewForm() {
        assertEquals("2 вещи", pluralRu(2, "вещь", "вещи", "вещей"))
        assertEquals("24 вещи", pluralRu(24, "вещь", "вещи", "вещей"))
        assertEquals("103 вещи", pluralRu(103, "вещь", "вещи", "вещей"))
    }

    @Test
    fun manyForm() {
        assertEquals("5 вещей", pluralRu(5, "вещь", "вещи", "вещей"))
        assertEquals("0 вещей", pluralRu(0, "вещь", "вещи", "вещей"))
        assertEquals("11 вещей", pluralRu(11, "вещь", "вещи", "вещей"))
        assertEquals("12 вещей", pluralRu(12, "вещь", "вещи", "вещей"))
        assertEquals("14 вещей", pluralRu(14, "вещь", "вещи", "вещей"))
        assertEquals("111 вещей", pluralRu(111, "вещь", "вещи", "вещей"))
    }

    @Test
    fun boxForms() {
        assertEquals("1 ящик", pluralRu(1, "ящик", "ящика", "ящиков"))
        assertEquals("2 ящика", pluralRu(2, "ящик", "ящика", "ящиков"))
        assertEquals("21 ящик", pluralRu(21, "ящик", "ящика", "ящиков"))
        assertEquals("25 ящиков", pluralRu(25, "ящик", "ящика", "ящиков"))
    }
}
