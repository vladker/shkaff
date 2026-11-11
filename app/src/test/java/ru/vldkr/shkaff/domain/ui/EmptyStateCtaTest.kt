package ru.vldkr.shkaff.domain.ui

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

// П1.4: в каждом пустом состоянии ровно один явный CTA «что сделать».
// Решение о подписи и о том, показывать ли CTA роли — чистые функции;
// экраны только привязывают их к действию.
class EmptyStateCtaTest {

    @Test
    fun `вещи пустой список с правом создавать — добавить вещь`() {
        assertEquals("Добавить вещь", EmptyStateCta.itemsEmpty(filterActive = false, canAdd = true))
    }

    @Test
    fun `вещи пуст из-за фильтра тега — сначала показать всё`() {
        assertEquals("Показать все вещи", EmptyStateCta.itemsEmpty(filterActive = true, canAdd = true))
    }

    @Test
    fun `вещи пустой список без права создавать — CTA нет`() {
        assertNull(EmptyStateCta.itemsEmpty(filterActive = false, canAdd = false))
    }

    @Test
    fun `поиск без результата — сбросить поиск`() {
        assertEquals("Сбросить поиск", EmptyStateCta.RESET_SEARCH)
    }

    @Test
    fun `журнал пуст — добавить первую вещь`() {
        assertEquals("Добавить первую вещь", EmptyStateCta.journalEmpty(filterActive = false))
    }

    @Test
    fun `журнал пуст под фильтром — снять фильтр`() {
        assertEquals("Показать все записи", EmptyStateCta.journalEmpty(filterActive = true))
    }

    @Test
    fun `корзина пуста с правом создавать — создать корзину`() {
        assertEquals("Создать корзину", EmptyStateCta.basketEmpty(canCreate = true))
    }

    @Test
    fun `корзина пуста без права создавать — CTA нет`() {
        assertNull(EmptyStateCta.basketEmpty(canCreate = false))
    }

    @Test
    fun `выдач нет с правом выдачи — идти к вещам`() {
        assertEquals("Найти вещь для выдачи", EmptyStateCta.loansEmpty(canManage = true))
    }

    @Test
    fun `выдач нет без права выдачи — CTA нет`() {
        assertNull(EmptyStateCta.loansEmpty(canManage = false))
    }

    @Test
    fun `профилей нет у админа — создать профиль`() {
        assertEquals("Создать профиль", EmptyStateCta.profilesEmpty(isAdmin = true))
    }

    @Test
    fun `профилей нет у не админа — CTA нет`() {
        assertNull(EmptyStateCta.profilesEmpty(isAdmin = false))
    }

    @Test
    fun `шаблонов нет — создать шаблон`() {
        assertEquals("Создать шаблон", EmptyStateCta.NEW_TEMPLATE)
    }
}
