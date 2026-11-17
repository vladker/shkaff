package ru.vldkr.shkaff.features.llm

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
import java.io.File
import java.io.RandomAccessFile

/**
 * Пин регрессии T-053 на уровне ВМ (проводка, а не сам предикат):
 * строка в ERROR без «*.part» и завершённые строки (полностью / только
 * основной файл) обязаны получать «Удалить» в RowVm.
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ModelStoreVmErrorAndCompletedTest {
    private val created = mutableListOf<File>()

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        clean()
        Deps.modelStore.reload()
    }

    @After
    fun tearDown() {
        if (Deps.modelStore.state.value.activeName != null) Deps.modelStore.cancel()
        Dispatchers.resetMain()
        clean()
        Deps.modelStore.reload()
    }

    private fun clean() {
        created.forEach { it.delete() }
        created.clear()
        val dir = Deps.modelStore.dir
        dir.listFiles()?.forEach { f ->
            if (f.name.endsWith(".part")) f.delete()
            if (f.name == "custom-test.gguf" || f.name == "custom-test.gguf.part") f.delete()
        }
        // Убрать свои строки, добавленные предыдущими тестами.
        Deps.modelStore.state.value.rows
            .filter { it.custom }
            .forEach { Deps.modelStore.delete(it) }
    }

    /** Разрежённый файл нужного размера — «файл скачан» без записи гигабайт. */
    private fun makeComplete(
        name: String,
        size: Long,
    ) {
        val f = File(Deps.modelStore.dir, name)
        RandomAccessFile(f, "rw").use { it.setLength(size) }
        created.add(f)
    }

    @Test
    fun errorRowWithoutPartsIsDeletable() {
        // Отказ предпроверки свободного места: строка в ERROR, файлов нет —
        // «Удалить» всё равно обязан появляться (проводка row.state == ERROR).
        val store = Deps.modelStore
        val row =
            store.state.value.rows
                .first { !store.isDownloaded(it) && !it.custom }
        store.start(row.copy(sizeBytes = 1L shl 50))
        val vm = ModelStoreVm()
        val rv =
            vm.ui.value.rows
                .first { it.row.id == row.id }
        assertEquals(0L, rv.partBytes)
        assertFalse(rv.downloading)
        assertTrue("строка в ERROR обязана удаляться даже без *.part", rv.deletable)
    }

    @Test
    fun fullyCompletedRowIsDeletableWithoutParts() {
        // Ветка «Готово ✓ + Удалить»: основной файл + mmproj на диске.
        val store = Deps.modelStore
        val row =
            store.state.value.rows.first {
                !it.custom && it.mmprojFile != null && it.sizeBytes > 0 &&
                    !store.isDownloaded(it) && !store.mmprojDone(it)
            }
        makeComplete(row.file, row.sizeBytes)
        val mm = File(store.dir, row.mmprojFile!!)
        mm.writeText("") // mmprojDone проверяет только существование
        created.add(mm)
        store.reload() // эмит нового состояния -> VM пересчитает строки
        val vm = ModelStoreVm()
        val rv =
            vm.ui.value.rows
                .first { it.row.id == row.id }
        assertTrue(rv.got)
        assertTrue(rv.mmprojGot)
        assertEquals(0L, rv.partBytes)
        assertFalse(rv.downloading)
        assertTrue("завершённую модель можно удалить", rv.deletable)
    }

    @Test
    fun completedMainWithoutMmprojIsDeletable() {
        // Ветка «Скачать mmproj» + «Удалить»: только основной файл на диске.
        val store = Deps.modelStore
        val row =
            store.state.value.rows.first {
                !it.custom && it.mmprojFile != null && it.sizeBytes > 0 &&
                    !store.isDownloaded(it) && !store.mmprojDone(it)
            }
        makeComplete(row.file, row.sizeBytes)
        store.reload()
        val vm = ModelStoreVm()
        val rv =
            vm.ui.value.rows
                .first { it.row.id == row.id }
        assertTrue(rv.got)
        assertFalse(rv.mmprojGot)
        assertEquals(0L, rv.partBytes)
        assertTrue("модель без mmproj тоже должна удаляться", rv.deletable)
    }
}
