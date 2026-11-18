package ru.vldkr.shkaff.features.journal

import org.junit.Assert.assertEquals
import org.junit.Test

/** Русские подписи типов сущностей в журнале. */
class EntityLabelTest {
    @Test
    fun knownTypes() {
        assertEquals("вещь", entityLabel("item"))
        assertEquals("хранилище", entityLabel("storage"))
        assertEquals("ящик", entityLabel("location"))
        assertEquals("стек", entityLabel("stack"))
        assertEquals("корзина", entityLabel("basket"))
        assertEquals("разметка", entityLabel("sheet_layout"))
        assertEquals("пир", entityLabel("peer"))
        assertEquals("профиль", entityLabel("user"))
    }

    @Test
    fun unknownTypeKeptRaw() {
        assertEquals("widget", entityLabel("widget"))
    }
}
