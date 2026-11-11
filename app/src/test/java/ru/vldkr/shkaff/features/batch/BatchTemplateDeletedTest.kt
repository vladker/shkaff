package ru.vldkr.shkaff.features.batch

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

// T-050: в «Серии вещей» (DONE-фаза) удалённый шаблон молча подменялся первым из
// observeAll — этикетки серии уезжали другим макетом. Теперь: templateMissing,
// кнопка «Сменить» остаётся единственным способом сменить шаблон.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class BatchTemplateDeletedTest {

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
    fun `deleted template in batch asks for another pick instead of the first one`() {
        val seq = System.nanoTime()
        val a = "t050-b-a-$seq"
        val b = "t050-b-b-$seq"
        seed(a, "AAA4-$seq")
        seed(b, "BBB4-$seq")
        try {
            val vm = BatchVm()
            assertTrue(
                "подписка не отдала живой список шаблонов",
                awaitUntil { vm.ui.value.templates.any { it.id == b } }
            )
            assertTrue("шаблон по умолчанию не выбран", awaitUntil { vm.ui.value.template != null })
            assertFalse("признак удалённого шаблона при штатном выборе", vm.ui.value.templateMissing)
            val selected = vm.ui.value.template!!.id
            runBlocking { dao.softDelete(selected, System.currentTimeMillis(), Deps.deviceId) }
            assertTrue("удаление выбранного шаблона не помечено", awaitUntil { vm.ui.value.templateMissing })
            assertNull("шаблон подменён первым из списка", vm.ui.value.template)
            // Ручной выбор другого шаблона снимает признак.
            vm.setTemplate(b)
            assertEquals(b, vm.ui.value.template?.id)
            assertFalse(vm.ui.value.templateMissing)
        } finally {
            runBlocking {
                dao.hardDelete(a)
                dao.hardDelete(b)
            }
        }
    }
}
