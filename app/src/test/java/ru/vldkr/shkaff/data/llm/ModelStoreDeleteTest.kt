package ru.vldkr.shkaff.data.llm

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import java.io.File

/**
 * Удаление модели с активной mmproj-загрузкой (T-054): во время докачки
 * vision-файла activeName == row.mmprojFile, поэтому старая проверка
 * «activeName == row.file» не отменяла сервис — тот после удаления
 * переименовывал *.part в целевой файл, и модель «воскресала» на диске.
 */
@RunWith(RobolectricTestRunner::class)
class ModelStoreDeleteTest {

    private fun store(): ModelStore =
        ModelStore(ApplicationProvider.getApplicationContext<Application>())

    @Test
    fun deleteDuringMainDownloadCancelsAndLeavesNoFiles() {
        val store = store()
        val row = store.state.value.rows.first { it.mmprojFile != null }
        store.trackProgress(row.file, 100L, row.sizeBytes)
        File(store.dir, row.file + ".part").writeText("partial")
        store.delete(row)
        assertNull(store.state.value.activeName)
        assertFalse(File(store.dir, row.file + ".part").exists())
    }

    @Test
    fun deleteDuringMmprojDownloadCancelsActiveDownload() {
        val store = store()
        val row = store.state.value.rows.first { it.mmprojFile != null }
        // Докачка mmproj: активное имя — сам vision-файл, а не основной GGUF.
        store.trackProgress(row.mmprojFile!!, 100L, row.mmprojSizeBytes ?: 1L)
        assertEquals(row.mmprojFile, store.state.value.activeName)
        store.delete(row)
        assertNull(store.state.value.activeName)
        // Отменённая загрузка не оставляет карточку в DOWNLOADING.
        val deleted = store.state.value.rows.first { it.id == row.id }
        assertEquals(ModelState.IDLE, deleted.state)
    }

    @Test
    fun deleteRemovesMmprojPartFile() {
        val store = store()
        val row = store.state.value.rows.first { it.mmprojFile != null }
        val mmproj = File(store.dir, row.mmprojFile!!)
        val mmprojPart = File(store.dir, row.mmprojFile!! + ".part")
        mmproj.writeText("full")
        mmprojPart.writeText("partial")
        store.delete(row)
        assertFalse(mmproj.exists())
        assertFalse(mmprojPart.exists())
    }
}
