package ru.vldkr.shkaff.features.labels

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotSame
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps

// T-046: форма шаблона в TemplatesScreen держалась в Form c plain var внутри
// mutableStateOf-держателя, который отслеживал только ссылку: запись в поле
// (чекбокс, формат) не инвалидировала композицию — чекбоксы «замерзали»,
// подраскрытый блок текста не появлялся. Форма обязана жить в Ui-state:
// любая правка — неизменяемый copy через StateFlow.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class TemplatesFormStateTest {

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    @Test
    fun `form lives in Ui state after openNew`() {
        val vm = TemplatesVm()
        vm.openNew()
        val f = vm.ui.value.form
        assertEquals(true, f != null)
        assertEquals("QR", f!!.format)
        assertEquals(true, f.showText)
    }

    @Test
    fun `editForm swaps form instance inside Ui state`() {
        val vm = TemplatesVm()
        vm.openNew()
        val before = vm.ui.value.form!!
        vm.editForm { it.copy(showText = false) }
        val after = vm.ui.value.form!!
        assertEquals("чекбокс применён", false, after.showText)
        assertNotSame("правка поля обязана менять ссылку формы в Ui-state", before, after)
        assertEquals("прочие поля сохранены", "QR", after.format)
        // Ссылка в Ui изменилась -> StateFlow даёт новый экземпляр Ui,
        // композиция инвалидируется (в этом суть дефекта).
        assertNotSame(before, vm.ui.value.form)
    }

    @Test
    fun `format selection visible in Ui state`() {
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { it.copy(format = "DATAMATRIX") }
        assertEquals("DATAMATRIX", vm.ui.value.form!!.format)
    }

    @Test
    fun `edited checkboxes reach database on save`() {
        val dao = Deps.db.labelTemplateDao()
        val name = "T-046 чекбокс " + System.nanoTime()
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { it.copy(name = name, showText = false, showNumber = false, appLink = true) }
        vm.save()

        var saved: LabelTemplateEntity? = null
        repeat(40) {
            saved = runBlocking { dao.observeAll().first() }.firstOrNull { it.name == name }
            if (saved != null) return@repeat
            Thread.sleep(50)
        }
        val t = saved!!
        try {
            assertEquals(false, t.show_text)
            assertEquals(false, t.show_number)
            assertEquals(true, t.app_link)
            // Правка одного поля не должна обнулять соседние значения формы:
            assertEquals("{name}", t.text_content)
            assertEquals("bottom", t.text_position)
        } finally {
            runBlocking { dao.hardDelete(t.id) }
        }
    }

    @Test
    fun `closeForm clears form from Ui state`() {
        val vm = TemplatesVm()
        vm.openNew()
        assertEquals(true, vm.ui.value.form != null)
        vm.closeForm()
        assertNull(vm.ui.value.form)
    }
}
