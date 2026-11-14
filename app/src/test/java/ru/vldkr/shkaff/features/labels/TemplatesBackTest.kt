package ru.vldkr.shkaff.features.labels

import android.os.Looper
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import ru.vldkr.shkaff.data.db.LabelTemplateEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-047: открытая форма шаблона обязана перехватывать системную «Назад»:
// Back закрывает форму (чистую — сразу, грязную — через подтверждение), а не
// покидает экран «Шаблоны этикеток» целиком с молчаливой потерей правок.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class TemplatesBackTest {

    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        runBlocking { Deps.db.clearAllTables() }
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
    }

    private class StoreOwner : ViewModelStoreOwner {
        override val viewModelStore = ViewModelStore()
    }

    // Свой диспетчер вместо activity-ного: «нажатие Назад» в тесте =
    // onBackPressedDispatcher.onBackPressed(), тот же путь, что у системной кнопки.
    private class BackOwner : OnBackPressedDispatcherOwner {
        private val registry = androidx.lifecycle.LifecycleRegistry(this)
        override val lifecycle: androidx.lifecycle.Lifecycle get() = registry
        override val onBackPressedDispatcher = OnBackPressedDispatcher()
        init { registry.currentState = androidx.lifecycle.Lifecycle.State.RESUMED }
    }

    private lateinit var backOwner: BackOwner

    private fun show(): NavController {
        val nav = NavController(ApplicationProvider.getApplicationContext())
        backOwner = BackOwner()
        rule.setContent {
            ShkaffTheme {
                CompositionLocalProvider(
                    LocalViewModelStoreOwner provides StoreOwner(),
                    LocalOnBackPressedDispatcherOwner provides backOwner
                ) {
                    TemplatesScreen(nav)
                }
            }
        }
        return nav
    }

    private fun pressBack() = rule.runOnIdle { backOwner.onBackPressedDispatcher.onBackPressed() }

    private fun hasText(text: String): Boolean {
        shadowOf(Looper.getMainLooper()).idle()
        // EmptyState рисует многострочный текст одним Text-узлом — ищем по подстроке.
        return rule.onAllNodesWithText(text, substring = true).fetchSemanticsNodes().isNotEmpty()
    }

    private fun entity(name: String): LabelTemplateEntity {
        val now = System.currentTimeMillis()
        return LabelTemplateEntity(
            id = "t047-" + System.nanoTime(), name = name, format = "QR",
            width_mm = 58.0, height_mm = 40.0, margin_mm = 3.0,
            show_text = true, text_content = "{name}", text_position = "bottom",
            show_number = true, app_link = false, font_size = 12.0,
            text_color = "#000000", bg_color = "#FFFFFF", invert = false, quiet_zone = true,
            created_at = now, updated_at = now, deleted_at = null,
            device_last_modified = "t047"
        )
    }

    // ---- VM-уровень: признак грязной формы ----

    @Test
    fun `свежеоткрытая новая форма не грязная`() {
        val vm = TemplatesVm()
        vm.openNew()
        assertEquals(false, vm.isDirty())
    }

    @Test
    fun `правка делает форму грязной`() {
        val vm = TemplatesVm()
        vm.openNew()
        vm.editForm { it.copy(name = "что-то") }
        assertEquals(true, vm.isDirty())
    }

    @Test
    fun `открытая на редактирование форма без правок не грязная`() {
        val t = entity("t047-чистая-" + System.nanoTime())
        runBlocking { Deps.db.labelTemplateDao().upsert(t) }
        val vm = TemplatesVm()
        vm.openEdit(t)
        assertEquals(false, vm.isDirty())
        vm.editForm { it.copy(showText = false) }
        assertEquals(true, vm.isDirty())
    }

    // ---- UI-уровень: поведение системной «Назад» ----

    @Test
    fun `Back закрывает чистую форму и остаётся на экране`() {
        show()
        rule.waitUntil(15_000) { hasText("Шаблонов пока нет") }
        rule.onNodeWithContentDescription("Добавить").performClick()
        rule.waitUntil(15_000) { hasText("Новый шаблон") }

        pressBack()

        rule.waitUntil(15_000) { !hasText("Новый шаблон") }
        // Экран не покинут: список/пустое состояние по-прежнему на месте.
        rule.waitUntil(15_000) { hasText("Шаблонов пока нет") }
    }

    @Test
    fun `Back на грязной форме требует подтверждения и ничего не закрывает`() {
        show()
        rule.waitUntil(15_000) { hasText("Шаблонов пока нет") }
        rule.onNodeWithContentDescription("Добавить").performClick()
        rule.waitUntil(15_000) { hasText("Новый шаблон") }
        // Грязним форму: выбор другого формата — щелчок по кнопке «DATAMATRIX».
        rule.onNodeWithText("DATAMATRIX").performClick()

        pressBack()

        rule.waitUntil(15_000) { hasText("Закрыть форму?") }
        rule.onNodeWithText("Несохранённые правки пропадут.").assertIsDisplayed()
        rule.onNodeWithText("Новый шаблон").assertIsDisplayed()

        // Отказ от закрытия оставляет форму открытой.
        rule.onNodeWithText("Продолжить правки").performClick()
        rule.waitUntil(15_000) { !hasText("Закрыть форму?") }
        rule.onNodeWithText("Новый шаблон").assertIsDisplayed()

        // Согласие закрывает форму, экран прежний.
        pressBack()
        rule.waitUntil(15_000) { hasText("Закрыть форму?") }
        rule.onNodeWithText("Закрыть").performClick()
        rule.waitUntil(15_000) { !hasText("Новый шаблон") }
        rule.waitUntil(15_000) { hasText("Шаблонов пока нет") }
    }
}
