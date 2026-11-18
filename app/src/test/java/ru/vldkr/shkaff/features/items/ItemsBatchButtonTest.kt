package ru.vldkr.shkaff.features.items

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.domain.access.ActiveRole
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class ItemsBatchButtonTest {
    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        runBlocking { Deps.db.clearAllTables() }
    }

    @After
    fun restore() {
        ActiveRole.set("view")
        Dispatchers.resetMain()
    }

    private class StoreOwner : ViewModelStoreOwner {
        override val viewModelStore = ViewModelStore()
    }

    private class BackOwner : OnBackPressedDispatcherOwner {
        private val registry = LifecycleRegistry(this)
        override val lifecycle: Lifecycle get() = registry
        override val onBackPressedDispatcher = OnBackPressedDispatcher()

        init {
            registry.currentState = Lifecycle.State.RESUMED
        }
    }

    private lateinit var nav: NavController

    private fun show() {
        val backOwner = BackOwner()
        rule.setContent {
            ShkaffTheme {
                CompositionLocalProvider(
                    LocalViewModelStoreOwner provides StoreOwner(),
                    LocalOnBackPressedDispatcherOwner provides backOwner,
                ) {
                    val host = rememberNavController()
                    nav = host
                    NavHost(navController = host, startDestination = "items") {
                        composable("items") { ItemsScreen(host, "") }
                        composable("batch") { Text("batch") }
                    }
                }
            }
        }
    }

    @Test
    fun `create role shows series button and navigates to batch`() {
        ActiveRole.set("admin")
        show()
        rule.onNodeWithContentDescription("Серия вещей").assertIsDisplayed()
        rule.onNodeWithContentDescription("Серия вещей").performClick()
        rule.waitUntil(15_000) {
            nav.currentBackStackEntry
                ?.destination
                ?.route
                ?.startsWith("batch") == true
        }
        val route = nav.currentBackStackEntry?.destination?.route
        assertTrue(route != null && route.startsWith("batch"))
    }

    @Test
    fun `view role hides series button`() {
        ActiveRole.set("view")
        show()
        rule.onNodeWithContentDescription("Серия вещей").assertDoesNotExist()
    }
}
