package ru.vldkr.shkaff.domain.labels

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import ru.vldkr.shkaff.data.db.LabelTemplateEntity

// T-050: удалённый шаблон (нет в живом списке observeAll) молча подменялся
// list.firstOrNull() — этикетка уезжала другим макетом. Разрешение выбора
// вынесено в чистую функцию pickTemplate: не найден → Missing, не подмена.
class TemplatePickTest {

    private fun tpl(id: String, name: String) =
        LabelTemplateEntity(id = id, name = name, created_at = 0L, updated_at = 0L)

    private val a = tpl("id-a", "AAA")
    private val b = tpl("id-b", "BBB")

    @Test
    fun `no selection defaults to first template`() {
        val pick = pickTemplate(listOf(a, b), null)
        assertTrue("ожидался Defaulted", pick is TemplatePick.Defaulted)
        assertEquals(a, pick.resolved)
    }

    @Test
    fun `blank wanted id treated as no selection`() {
        val pick = pickTemplate(listOf(a, b), "")
        assertTrue("ожидался Defaulted", pick is TemplatePick.Defaulted)
        assertEquals(a, pick.resolved)
    }

    @Test
    fun `wanted id picks exactly that template`() {
        val pick = pickTemplate(listOf(a, b), "id-b")
        assertTrue("ожидался Found", pick is TemplatePick.Found)
        assertEquals(b, pick.resolved)
    }

    @Test
    fun `deleted template is missing, not silently the first one`() {
        val pick = pickTemplate(listOf(a, b), "gone")
        assertTrue("ожидался Missing", pick is TemplatePick.Missing)
        assertNull(pick.resolved)
    }

    @Test
    fun `empty list without selection is empty`() {
        val pick = pickTemplate(emptyList(), null)
        assertTrue("ожидался Empty", pick is TemplatePick.Empty)
        assertNull(pick.resolved)
    }

    @Test
    fun `empty list with wanted id is missing`() {
        val pick = pickTemplate(emptyList(), "id-a")
        assertTrue("ожидался Missing", pick is TemplatePick.Missing)
    }

    @Test
    fun `deleted template message tells to choose another`() {
        assertTrue(TEMPLATE_DELETED_MSG.contains("удалён"))
        assertTrue(TEMPLATE_DELETED_MSG.contains("выберит"))
    }
}
