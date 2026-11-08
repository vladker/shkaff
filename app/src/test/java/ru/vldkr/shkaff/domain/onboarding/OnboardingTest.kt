package ru.vldkr.shkaff.domain.onboarding

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

// Чек-лист первого запуска: шаги гасятся по реальным объектам БД (принцип чек-листа ПВЗ),
// карточка показывается пока есть незавершённые и пользователь не скрыл её.
class OnboardingTest {

    @Test
    fun `fresh db - all steps pending, in order shelf-box-item`() {
        val s = Onboarding.steps(0, 0, 0)
        assertEquals(3, s.size)
        assertEquals(listOf("storage", "location", "item"), s.map { it.id })
        assertTrue(s.none { it.done })
    }

    @Test
    fun `steps complete by real counts only`() {
        val s1 = Onboarding.steps(1, 0, 0)
        assertTrue(s1[0].done); assertFalse(s1[1].done); assertFalse(s1[2].done)
        val s2 = Onboarding.steps(1, 1, 0)
        assertTrue(s2[0].done); assertTrue(s2[1].done); assertFalse(s2[2].done)
        val s3 = Onboarding.steps(1, 1, 1)
        assertTrue(s3.all { it.done })
        // Вещь без ящика тоже засчитывает шаг «вещь» — но порядок шагов подсказывает правильный путь.
        val s4 = Onboarding.steps(0, 0, 1)
        assertTrue(s4[2].done)
    }

    @Test
    fun `each step routes to a real screen`() {
        val routes = Onboarding.steps(0, 0, 0).map { it.route }
        assertTrue(routes.contains("storage-form/0"))
        assertTrue(routes.contains("storages"))
        assertTrue(routes.contains("item-wizard"))
    }

    @Test
    fun `show checklist while pending and not dismissed`() {
        val pending = Onboarding.steps(1, 0, 0)
        val allDone = Onboarding.steps(1, 1, 1)
        assertTrue(Onboarding.showChecklist(pending, dismissed = false))
        assertFalse(Onboarding.showChecklist(pending, dismissed = true))
        assertFalse(Onboarding.showChecklist(allDone, dismissed = false))
    }

    @Test
    fun `progress formats as done of total`() {
        assertEquals("0/3", Onboarding.progress(Onboarding.steps(0, 0, 0)))
        assertEquals("1/3", Onboarding.progress(Onboarding.steps(1, 0, 0)))
        assertEquals("3/3", Onboarding.progress(Onboarding.steps(1, 1, 1)))
    }
}
