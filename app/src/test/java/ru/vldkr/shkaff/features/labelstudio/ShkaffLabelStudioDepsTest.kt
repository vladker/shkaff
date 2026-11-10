package ru.vldkr.shkaff.features.labelstudio

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps

// T-016 (US-E2): стек — полноценный субъект этикетки: из карточки стека QR
// выдаётся так же, как у вещи/ящика/хранилища (LabelStudio, шаблон по kind=stack).
@RunWith(RobolectricTestRunner::class)
class ShkaffLabelStudioDepsTest {

    @Test
    fun `stack is a loadable label subject`() = runBlocking {
        val code = "T016-STACK-" + System.nanoTime()
        val st = Deps.stacks.create("Канистра с хламом", code)
        val subject = ShkaffLabelStudioDeps.loadSubject("stack", st.id)
        assertNotNull("стек должен быть субъектом этикетки", subject)
        assertEquals("stack", subject!!.kind)
        assertEquals(st.id, subject.id)
        assertEquals("Канистра с хламом", subject.name)
        assertEquals(code, subject.code)
    }

    @Test
    fun `stack subject template docs are stored per stack kind`() = runBlocking {
        val doc = ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc(name = "Шаблон стека")
        val saved = ShkaffLabelStudioDeps.saveTemplateDoc("stack", doc)
        val reloaded = ShkaffLabelStudioDeps.loadTemplateDoc("stack", saved.id)
        assertNotNull(reloaded)
        assertEquals("Шаблон стека", reloaded!!.name)
        assertTrue(ShkaffLabelStudioDeps.loadTemplates("stack").any { it.id == saved.id })
    }

    @Test
    fun `stack without a number gets a persistent code on label issue`() = runBlocking {
        val st = Deps.stacks.create("Без номера", "AUTOTEST-" + System.nanoTime())
        // Принудительно обнуляем номер (как в старых записях при выключенной автогенерации).
        Deps.db.stackDao().upsert(st.copy(code = "", updated_at = System.currentTimeMillis()))
        val subject = ShkaffLabelStudioDeps.loadSubject("stack", st.id)
        assertNotNull(subject)
        assertTrue("QR не может быть пустым", subject!!.code.isNotBlank())
        // Код сохранён в базе — повторная выдача печати тот же QR.
        val again = ShkaffLabelStudioDeps.loadSubject("stack", st.id)
        assertEquals(subject.code, again!!.code)
    }

    @Test
    fun `unknown kinds stay unsupported`() = runBlocking {
        val st = Deps.stacks.create("Проверка типа", "T016-KIND-" + System.nanoTime())
        assertEquals(null, ShkaffLabelStudioDeps.loadSubject("basket", st.id))
    }
}
