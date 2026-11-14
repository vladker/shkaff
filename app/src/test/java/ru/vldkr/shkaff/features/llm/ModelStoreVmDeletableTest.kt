package ru.vldkr.shkaff.features.llm

import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps

/**
 * Маппинг каталога в RowVm (T-053): у строки с осиротевшим «*.part», у строки
 * в состоянии ошибки и у своей строки без файлов должно появляться «Удалить»;
 * у пресета «ничего нет» — не должно.
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ModelStoreVmDeletableTest {

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        cleanParts()
        Deps.modelStore.reload()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        cleanParts()
        Deps.modelStore.reload()
    }

    private fun cleanParts() {
        val dir = Deps.modelStore.dir
        dir.listFiles()?.forEach { f ->
            if (f.name.endsWith(".part")) f.delete()
            if (f.name == "custom-test.gguf" || f.name == "custom-test.gguf.part") f.delete()
        }
        // Убрать свои строки, добавленные предыдущими тестами.
        Deps.modelStore.state.value.rows.filter { it.custom }.forEach { Deps.modelStore.delete(it) }
    }

    @Test
    fun interruptedDownloadRowBecomesDeletable() {
        val store = Deps.modelStore
        val row = store.state.value.rows.first { !store.isDownloaded(it) && !it.custom }
        File(store.dir, row.file + ".part").writeText("x".repeat(1000))
        store.reload() // эмит нового состояния -> VM пересчитает строки
        val vm = ModelStoreVm()
        val rv = vm.ui.value.rows.first { it.row.id == row.id }
        assertEquals(1000L, rv.partBytes)
        assertTrue("«Удалить» должно появляться при осиротевшем *.part", rv.deletable)
    }

    @Test
    fun idlePresetWithoutFilesIsNotDeletable() {
        val store = Deps.modelStore
        val row = store.state.value.rows.first { !store.isDownloaded(it) && !it.custom }
        val vm = ModelStoreVm()
        val rv = vm.ui.value.rows.first { it.row.id == row.id }
        assertEquals(0L, rv.partBytes)
        assertFalse(rv.deletable)
    }

    @Test
    fun customRowIsDeletableEvenWithoutAnyFiles() {
        val store = Deps.modelStore
        val added = store.addCustom("https://example.com/custom-test.gguf")
        assertTrue(added.isFailure.toString(), added.isSuccess)
        val vm = ModelStoreVm()
        val rv = vm.ui.value.rows.first { it.row.id == added.getOrThrow().id }
        assertTrue("свою строку нужно уметь убрать из списка", rv.deletable)
        store.delete(added.getOrThrow())
    }

    @Test
    fun reAddingSameCustomAfterDeleteWorks() {
        // Дефект T-053: «Такая модель уже в списке» блокировал повторное
        // добавление, пока строку нельзя было удалить.
        val store = Deps.modelStore
        val first = store.addCustom("https://example.com/custom-test.gguf").getOrThrow()
        store.delete(first)
        val again = store.addCustom("https://example.com/custom-test.gguf")
        assertTrue(again.isSuccess)
        store.delete(again.getOrThrow())
    }
}
