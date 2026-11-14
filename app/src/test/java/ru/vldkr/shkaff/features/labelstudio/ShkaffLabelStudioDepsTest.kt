package ru.vldkr.shkaff.features.labelstudio

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
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

    // T-067: правка дефолтного макета не должна снимать с него «по умолчанию»
    // (иначе у вида перестаёт читаться дефолт) и не должна передвигать created_at.
    @Test
    fun `editing default template keeps default flag and creation date`() = runBlocking {
        val kind = "t067-" + System.nanoTime()
        val doc = ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc(name = "Дефолт вида")
        val saved = ShkaffLabelStudioDeps.saveTemplateDoc(kind, doc)
        val first = Deps.db.labelDocDao().byId(saved.id)
        assertNotNull("документ должен сохраниться", first)
        assertTrue("первый документ вида становится по умолчанию", first!!.is_default)
        val createdAt = first.created_at
        // Тот же документ, повторное сохранение — это правка, а не новый макет.
        ShkaffLabelStudioDeps.saveTemplateDoc(kind, doc.copy(name = "Дефолт вида (правка)"))
        val second = Deps.db.labelDocDao().byId(saved.id)!!
        assertFalse("правка не снимает «по умолчанию»", second.is_default.not())
        assertEquals("created_at не уезжает на правку", createdAt, second.created_at)
        assertTrue("updated_at обязан обновиться", second.updated_at >= first.updated_at)
        // Дефолт вида по-прежнему читается без id.
        val def = ShkaffLabelStudioDeps.loadTemplateDoc(kind, null)
        assertNotNull("у вида остаётся дефолтный макет", def)
        assertEquals("Дефолт вида (правка)", def!!.name)
    }

    @Test
    fun `second template of a kind does not become default`() = runBlocking {
        val kind = "t067b-" + System.nanoTime()
        val firstSaved = ShkaffLabelStudioDeps.saveTemplateDoc(kind, ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc(name = "Первый"))
        val secondSaved = ShkaffLabelStudioDeps.saveTemplateDoc(kind, ru.vldkr.shkaff.features.labelstudio.domain.LabelDoc(name = "Второй"))
        assertTrue("первый сохранённый макет вида — по умолчанию", Deps.db.labelDocDao().byId(firstSaved.id)!!.is_default)
        assertFalse("второй макет вида не становится по умолчанию", Deps.db.labelDocDao().byId(secondSaved.id)!!.is_default)
    }
}
