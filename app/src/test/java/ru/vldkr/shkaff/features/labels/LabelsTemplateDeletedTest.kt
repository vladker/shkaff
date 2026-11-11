package ru.vldkr.shkaff.features.labels

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps

// T-050: удалённый шаблон в LabelsScreen молча подменялся первым из observeAll —
// этикетка печаталась другим макетом. Теперь: templateMissing + шаблон не выбран.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class LabelsTemplateDeletedTest {

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    private val dao get() = Deps.db.labelTemplateDao()

    private fun seed(id: String, name: String) {
        val now = System.currentTimeMillis()
        runBlocking { dao.upsert(LabelTemplateEntity(id = id, name = name, created_at = now, updated_at = now)) }
    }

    private fun awaitUntil(timeoutMs: Long = 3000, pred: () -> Boolean): Boolean {
        val end = System.currentTimeMillis() + timeoutMs
        while (System.currentTimeMillis() < end) {
            if (pred()) return true
            Thread.sleep(25)
        }
        return pred()
    }

    @Test
    fun `route to deleted template asks for another pick instead of the first one`() {
        val seq = System.nanoTime()
        val del = "t050-del-$seq"
        val keep = "t050-keep-$seq"
        seed(del, "AAA-$seq")
        seed(keep, "BBB-$seq")
        runBlocking { dao.softDelete(del, System.currentTimeMillis(), Deps.deviceId) }
        try {
            val vm = LabelsVm("item", null, del)
            assertTrue(
                "подписка не отдала живой список шаблонов",
                awaitUntil { vm.ui.value.templates.any { it.id == keep } }
            )
            assertTrue("не выставлен признак удалённого шаблона", vm.ui.value.templateMissing)
            assertNull("шаблон подменён первым из списка", vm.ui.value.template)
        } finally {
            runBlocking {
                dao.hardDelete(del)
                dao.hardDelete(keep)
            }
        }
    }

    @Test
    fun `no template requested still defaults to the first live template`() {
        val seq = System.nanoTime()
        val a = "t050-a-$seq"
        val b = "t050-b-$seq"
        seed(a, "AAA2-$seq")
        seed(b, "BBB2-$seq")
        try {
            val vm = LabelsVm("item", null, null)
            assertTrue(
                "подписка не отдала живой список шаблонов",
                awaitUntil { vm.ui.value.templates.any { it.id == b } }
            )
            assertTrue("не выбран шаблон по умолчанию", awaitUntil { vm.ui.value.template != null })
            assertFalse("признак удалённого шаблона при штатном выборе", vm.ui.value.templateMissing)
            assertEquals(
                "по умолчанию должен браться первый живой шаблон",
                vm.ui.value.templates.first().id, vm.ui.value.template?.id
            )
        } finally {
            runBlocking {
                dao.hardDelete(a)
                dao.hardDelete(b)
            }
        }
    }

    @Test
    fun `template deleted during session demands a new pick and survives later edits`() {
        val seq = System.nanoTime()
        val a = "t050-sel-$seq"
        val b = "t050-other-$seq"
        val fresh = "t050-fresh-$seq"
        seed(a, "AAA3-$seq")
        seed(b, "BBB3-$seq")
        try {
            val vm = LabelsVm("item", null, null)
            assertTrue("шаблон по умолчанию не выбран", awaitUntil { vm.ui.value.template != null })
            val selected = vm.ui.value.template!!.id
            runBlocking { dao.softDelete(selected, System.currentTimeMillis(), Deps.deviceId) }
            assertTrue("удаление выбранного шаблона не помечено", awaitUntil { vm.ui.value.templateMissing })
            assertNull("шаблон подменён при удалении", vm.ui.value.template)
            // Новая запись в списке не должна молча вернуть автовыбор.
            seed(fresh, "CCC3-$seq")
            assertTrue("не дождались эмиссии обновлённого списка", awaitUntil { vm.ui.value.templates.any { it.id == fresh } })
            assertTrue("признак удалённого шаблона сброшен сам собой", vm.ui.value.templateMissing)
            assertNull("шаблон молча подменён после изменения списка", vm.ui.value.template)
            // Пользователь выбирает другой — признак снимается.
            vm.setTemplate(fresh)
            assertEquals(fresh, vm.ui.value.template?.id)
            assertFalse(vm.ui.value.templateMissing)
        } finally {
            runBlocking {
                dao.hardDelete(a)
                dao.hardDelete(b)
                dao.hardDelete(fresh)
            }
        }
    }
}
