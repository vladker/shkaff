package ru.vldkr.shkaff.features.items

import android.os.Looper
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.ItemData
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-028: карточка вещи больше не рисует некликабельные заглушки «M3»/«M5»
// (сканер уже достижим из поиска/вкладки), а вместо молчаливой пустоты для
// удалённой или несуществующей вещи показывает честный EmptyState с CTA.
@RunWith(RobolectricTestRunner::class)
class ItemDetailScreenTest {

    @get:Rule
    val rule = createComposeRule()

    private class StoreOwner : ViewModelStoreOwner {
        override val viewModelStore = ViewModelStore()
    }

    private fun show(itemId: String) {
        val nav = NavController(ApplicationProvider.getApplicationContext())
        rule.setContent {
            ShkaffTheme {
                CompositionLocalProvider(LocalViewModelStoreOwner provides StoreOwner()) {
                    ItemDetailScreen(nav, itemId)
                }
            }
        }
    }

    private fun hasText(text: String): Boolean {
        shadowOf(Looper.getMainLooper()).idle()
        return rule.onAllNodesWithText(text).fetchSemanticsNodes().isNotEmpty()
    }

    @Test
    fun `отсутствующая вещь — честное пустое состояние вместо молчаливой пустоты`() {
        show("no-such-item-" + System.nanoTime())
        rule.waitUntil(15_000) { hasText("Вещь не найдена или удалена") }
        rule.onNodeWithText("Вещь не найдена или удалена").assertIsDisplayed()
        // П1.4: пустое состояние обязано давать явный CTA — здесь это выход назад.
        rule.onNodeWithText("Назад").assertIsDisplayed()
        rule.onNodeWithText("Фотография и удаление фона").assertDoesNotExist()
        rule.onNodeWithText("Отсканировать код этой вещи").assertDoesNotExist()
    }

    @Test
    fun `живая карточка без заглушек M3 M5`() {
        val name = "t028-живая-" + System.nanoTime()
        val id = runBlocking { Deps.items.create(ItemData(name = name)).id }
        show(id)
        rule.waitUntil(15_000) { hasText("Действия") }
        rule.onNodeWithText("Фотография и удаление фона").assertDoesNotExist()
        rule.onNodeWithText("Отсканировать код этой вещи").assertDoesNotExist()
        rule.onNodeWithText("Вещь не найдена или удалена").assertDoesNotExist()
        // Карточка при этом живая: имя вещи и блок действий на месте
        // (кнопка корзины под сгибом скроллящейся колонки — проверяем наличие в семантике).
        rule.waitUntil(15_000) { hasText(name) }
        rule.onNodeWithText("В корзину извлечения").assertExists()
    }
}
