package ru.vldkr.shkaff.data.llm

import android.app.Application
import androidx.test.core.app.ApplicationProvider
import java.io.File
import org.json.JSONArray
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * T-057: битый «.custom.json» молча обнулял список пользовательских моделей —
 * getter проглатывал исключение парсера и возвращал emptyList, на экране
 * модели исчезали без следа. Исправление: копия битого файла бережётся,
 * в StoreState появляется флаг ошибки с русским сообщением.
 */
@RunWith(RobolectricTestRunner::class)
class ModelStoreCustomsCorruptTest {

    private fun store(): ModelStore =
        ModelStore(ApplicationProvider.getApplicationContext<Application>())

    @Before
    fun cleanIndex() {
        val dir = store().dir
        File(dir, ".custom.json").delete()
        File(dir, ".custom.json.corrupt").delete()
    }

    @Test
    fun brokenIndexIsBackedUpAndErrorSurfaces() {
        val store = store()
        val idx = File(store.dir, ".custom.json")
        idx.writeText("{ это не json")
        store.reload()
        val st = store.state.value
        assertNotNull("ошибка списка должна попасть в StoreState", st.customsError)
        assertTrue(
            "сообщение должно быть по-русски про повреждённый список: ${st.customsError}",
            st.customsError!!.contains("повреждён"),
        )
        // Пресеты не должны пострадать, битых кастомных строк в списке нет.
        assertTrue(st.rows.isNotEmpty())
        assertTrue(st.rows.none { it.custom })
        // Копия битого файла сберечься обязана, байт в байт.
        val bak = File(store.dir, ".custom.json.corrupt")
        assertTrue("копия битого файла не сохранена", bak.exists())
        assertEquals("{ это не json", bak.readText())
    }

    @Test
    fun indexEntryMissingKeysIsTreatedAsBroken() {
        val store = store()
        // Парсер JSONArray проходит, но обязательных полей нет — это тоже битый индекс.
        File(store.dir, ".custom.json").writeText("""[{"id":"a"}]""")
        store.reload()
        val st = store.state.value
        assertNotNull("пропуск обязательных полей тоже ошибка", st.customsError)
        assertTrue(st.rows.none { it.custom })
        assertTrue(File(store.dir, ".custom.json.corrupt").exists())
    }

    @Test
    fun validIndexStillLoadsAndNoError() {
        val store = store()
        File(store.dir, ".custom.json").writeText(
            """[{"id":"id-1","name":"модель","file":"m.gguf","url":"https://example.com/m.gguf","sizeBytes":42}]""",
        )
        store.reload()
        val st = store.state.value
        assertNull(st.customsError)
        val custom = st.rows.first { it.custom }
        assertEquals("id-1", custom.id)
        assertEquals("m.gguf", custom.file)
    }

    @Test
    fun addCustomAfterCorruptionRewritesIndexAndClearsError() {
        val store = store()
        File(store.dir, ".custom.json").writeText("<<<битый")
        store.reload()
        assertNotNull(store.state.value.customsError)
        val added = store.addCustom("https://example.com/ok.gguf")
        assertTrue("добавление после повреждения обязано работать", added.isSuccess)
        val st = store.state.value
        assertNull("ошибка должна исчезнуть после успешной перезаписи индекса", st.customsError)
        assertTrue(st.rows.any { it.custom && it.file == "ok.gguf" })
        // Индекс снова валиден и содержит ровно новую строку.
        val arr = JSONArray(File(store.dir, ".custom.json").readText())
        assertEquals(1, arr.length())
        assertEquals("ok.gguf", arr.getJSONObject(0).getString("file"))
    }
}
