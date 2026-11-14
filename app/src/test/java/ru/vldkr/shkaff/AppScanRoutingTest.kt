package ru.vldkr.shkaff

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

// T-058: HID-скан на экранах без собственной подписки на ScanBus терялся молча.
// Глобальный подписчик в AppRoot обязан отвести код в «Вещи» поиском,
// а экраны-потребители (Поиск) — не уводить с текущего экрана.
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class AppScanRoutingTest {

    @get:Rule
    val rule = createComposeRule()

    @Before
    fun setup() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
        ScanBus.reset()
        runBlocking { Deps.db.clearAllTables() }
    }

    @After
    fun restore() {
        Dispatchers.resetMain()
        ScanBus.reset()
    }

    private lateinit var nav: NavHostController

    private fun mountApp() {
        rule.setContent {
            ShkaffTheme {
                val c = rememberNavController()
                nav = c
                AppRoot(navController = c)
            }
        }
        rule.waitForIdle()
    }

    @Test
    fun `скан на дашборде открывает Вещи с кодом`() {
        mountApp()
        assertEquals("dashboard", nav.currentBackStackEntry?.destination?.route)
        rule.runOnIdle { ScanBus.publish("DR-01") }
        rule.waitUntil(5_000) { nav.currentBackStackEntry?.destination?.route == "items/{tag}" }
        assertEquals("0", nav.currentBackStackEntry?.arguments?.getString("tag"))
    }

    @Test
    fun `скан на Поиске не уводит с экрана`() {
        mountApp()
        rule.runOnIdle { nav.navigate("search") }
        rule.waitForIdle()
        assertEquals("search", nav.currentBackStackEntry?.destination?.route)
        rule.runOnIdle { ScanBus.publish("DR-01") }
        rule.waitForIdle()
        // Поиск сам потребляет код живой подпиской — навигации быть не должно.
        assertEquals("search", nav.currentBackStackEntry?.destination?.route)
    }
}
