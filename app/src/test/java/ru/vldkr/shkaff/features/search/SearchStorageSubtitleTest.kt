package ru.vldkr.shkaff.features.search

import android.os.Looper
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasSetTextAction
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import androidx.test.core.app.ApplicationProvider
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import ru.vldkr.shkaff.data.db.LocationEntity
import ru.vldkr.shkaff.data.db.StorageEntity
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.ui.theme.ShkaffTheme
import ru.vldkr.shkaff.util.ScanBus

// T-043 (карточка t_63cd3564): пин проводки — в SearchScreen карта шкафов строится из полных
// ui.storages; при регрессе на results.storages подпись «Гараж…» у ящика исчезнет и этот тест упадёт.
@RunWith(RobolectricTestRunner::class)
class SearchStorageSubtitleTest {
    @get:Rule
    val rule = createComposeRule()

    private class StoreOwner : ViewModelStoreOwner {
        override val viewModelStore = ViewModelStore()
    }

    // Deps — синглтон Robolectric-sandbox: база переиспользуется между тестами.
    @Before
    fun clearDb() {
        runBlocking { Deps.db.clearAllTables() }
        ScanBus.reset()
    }

    private fun hasText(text: String): Boolean {
        shadowOf(Looper.getMainLooper()).idle()
        return rule.onAllNodesWithText(text).fetchSemanticsNodes().isNotEmpty()
    }

    @Test
    fun `подпись ящика показывает шкаф, не попавший в результаты поиска`() {
        val now = System.currentTimeMillis()
        val n = System.nanoTime()
        // Имя шкафа НЕ содержит подстроку запроса → шкаф не попадает в results.storages,
        // но есть в полном ui.storages.
        val storageName = "Гараж ${n + 1}"
        val label = "Т043 $n"
        val query = "Т043 $n"

        // Порядок важен: FK location → storage.
        runBlocking {
            Deps.db.storageDao().upsert(
                StorageEntity(
                    id = "s-t043-$n",
                    name = storageName,
                    code = "",
                    description = "",
                    created_at = now,
                    updated_at = now,
                ),
            )
            Deps.db.locationDao().upsert(
                LocationEntity(
                    id = "l-t043-$n",
                    storage_id = "s-t043-$n",
                    label = label,
                    name = "",
                    created_at = now,
                    updated_at = now,
                ),
            )
        }

        val nav = NavController(ApplicationProvider.getApplicationContext())
        rule.setContent {
            ShkaffTheme {
                CompositionLocalProvider(LocalViewModelStoreOwner provides StoreOwner()) {
                    SearchScreen(nav)
                }
            }
        }
        rule.waitForIdle()
        rule.onNode(hasSetTextAction()).performTextInput(query)

        // Строка ящика отрисована (секция «Ящики» — единственная: вещей не сидим).
        rule.waitUntil(15_000) { hasText(label) }
        // Пин: подпись шкафа на месте, хотя сам шкаф в results.storages отсутствует.
        rule.onNodeWithText(storageName).assertIsDisplayed()
    }
}
