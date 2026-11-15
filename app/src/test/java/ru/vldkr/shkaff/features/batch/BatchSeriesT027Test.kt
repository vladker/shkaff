package ru.vldkr.shkaff.features.batch

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.data.db.AttributeDefEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.domain.batch.BatchPlan
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-027 «Серия вещей» (US-A1):
// 1) общее фото: префилл из шаблон-вещи и раздача его всем вещам серии;
// 2) count>1 без {n} — предупреждение, что имена совпадут;
// 3) чекбокс «для каждого»: клик работает по всей строке, не только по 32×32.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class BatchSeriesT027Test {

    @get:Rule
    val rule = createComposeRule()

    @Before
    fun mainDispatcher() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    private fun awaitUntil(timeoutMs: Long = 3000, pred: () -> Boolean): Boolean {
        val end = System.currentTimeMillis() + timeoutMs
        while (System.currentTimeMillis() < end) {
            if (pred()) return true
            Thread.sleep(25)
        }
        return pred()
    }

    // --- 1. Общее фото серии ---

    @Test
    fun `шаблон-вещь префиллит общее фото, серия раздаёт его всем вещам`() {
        val seq = System.nanoTime()
        val photo = "photos/t027-$seq.jpg"
        val template = runBlocking {
            Deps.items.create(
                ItemData(name = "T027 шаблон $seq", photoPath = photo),
                allowOverCapacity = true
            )
        }
        val createdIds = ArrayList<String>()
        try {
            val vm = BatchVm()
            vm.loadFromItem(template.id)
            assertTrue(
                "имя шаблон-вещи не подставилось",
                awaitUntil { vm.ui.value.namePattern == template.name }
            )
            assertEquals("фото шаблон-вещи не префиллено", photo, vm.ui.value.photoPath)

            vm.setCount("2")
            vm.start()
            vm.next()
            assertTrue("первая вещь не создана", awaitUntil { vm.ui.value.created.isNotEmpty() })
            val first = runBlocking { Deps.items.byId(vm.ui.value.created[0].id) }
            assertNotNull(first)
            assertEquals("первая вещь серии без общего фото", photo, first!!.photo_path)

            vm.next()
            assertTrue("вторая вещь не создана", awaitUntil { vm.ui.value.created.size == 2 })
            val second = runBlocking { Deps.items.byId(vm.ui.value.created[1].id) }
            assertNotNull(second)
            assertEquals("вторая вещь серии без общего фото", photo, second!!.photo_path)
            createdIds += vm.ui.value.created.map { it.id }
        } finally {
            runBlocking {
                Deps.db.itemDao().hardDelete(template.id)
                createdIds.forEach { Deps.db.itemDao().hardDelete(it) }
            }
        }
    }

    @Test
    fun `общее фото без шаблон-вещи тоже уходит в вещи серии`() {
        val seq = System.nanoTime()
        val photo = "photos/t027-clear-$seq.jpg"
        val vm = BatchVm()
        val createdIds = ArrayList<String>()
        try {
            vm.setName("T027 сброс $seq {n}")
            vm.setPhoto(photo)
            vm.setCount("1")
            vm.start()
            vm.next()
            assertTrue("первая вещь не создана", awaitUntil { vm.ui.value.created.isNotEmpty() })
            val e = runBlocking { Deps.items.byId(vm.ui.value.created[0].id) }
            assertNotNull(e)
            assertEquals("вещь серии без общего фото", photo, e!!.photo_path)
            createdIds += vm.ui.value.created.map { it.id }
        } finally {
            runBlocking { createdIds.forEach { Deps.db.itemDao().hardDelete(it) } }
        }
    }

    // --- 2. Предупреждение про одинаковые имена ---

    @Test
    fun `дублирование имён считается только для серии без маркера номера`() {
        assertNull(BatchPlan.duplicateNameWarning("", 10))
        assertNull(BatchPlan.duplicateNameWarning("Гвозди", 1))
        assertNull(BatchPlan.duplicateNameWarning("Батарея {n}", 10))
        assertNotNull(BatchPlan.duplicateNameWarning("Гвозди 3×70", 10))
    }

    @Test
    fun `Setup предупреждает об одинаковых именах когда count больше 1 без маркера`() {
        rule.setContent { ShkaffTheme { BatchEntryScreen(rememberNavController()) } }
        rule.waitUntil(5000) { rule.onAllNodesWithTag("batchName").fetchSemanticsNodes().isNotEmpty() }
        rule.onNodeWithTag("batchName").performTextInput("Гвозди 3×70")
        // count по умолчанию 10 > 1 и в имени нет {n} — предупреждение обязательно.
        rule.onNodeWithText("Без {n}", substring = true).assertExists()
    }

    @Test
    fun `Setup не предупреждает когда в шаблоне есть маркер номера`() {
        rule.setContent { ShkaffTheme { BatchEntryScreen(rememberNavController()) } }
        rule.waitUntil(5000) { rule.onAllNodesWithTag("batchName").fetchSemanticsNodes().isNotEmpty() }
        rule.onNodeWithTag("batchName").performTextInput("Батарея {n}")
        rule.onNodeWithText("Без {n}", substring = true).assertDoesNotExist()
    }

    // --- 3. Тач-таргет «для каждого» ---

    private var defToggleCount = 0

    @Test
    fun `чекбокс для каждого переключается кликом по подписи строки`() {
        defToggleCount = 0
        rule.setContent {
            ShkaffTheme {
                BatchAttrField(
                    def = AttributeDefEntity(
                        id = "t027-def", scope = "item", key = "note",
                        label = "Заметка", type = "text",
                        created_at = System.currentTimeMillis(),
                        updated_at = System.currentTimeMillis()
                    ),
                    value = "",
                    perItem = false,
                    onChange = {},
                    onTogglePerItem = { defToggleCount++ }
                )
            }
        }
        rule.onNodeWithText("для каждого").performClick()
        assertEquals("клик по подписи не переключает «для каждого»", 1, defToggleCount)
        rule.onNodeWithTag("perItemCheck").performClick()
        assertEquals("клик по чекбоксу не переключает", 2, defToggleCount)
    }
}
