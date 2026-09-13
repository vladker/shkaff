package ru.vldkr.shkaff

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.vldkr.shkaff.features.agent.AgentScreen
import ru.vldkr.shkaff.features.agent.VolumeEstimateScreen
import ru.vldkr.shkaff.features.annotations.AnnotationScreen
import ru.vldkr.shkaff.features.actions.ActionsScreen
import ru.vldkr.shkaff.features.attrdefs.AttrDefsScreen
import ru.vldkr.shkaff.features.basket.BasketDetailScreen
import ru.vldkr.shkaff.features.basket.BasketScreen
import ru.vldkr.shkaff.features.dashboard.DashboardScreen
import ru.vldkr.shkaff.features.items.ItemDetailScreen
import ru.vldkr.shkaff.features.items.ItemFormScreen
import ru.vldkr.shkaff.features.batch.BatchEntryScreen
import ru.vldkr.shkaff.features.backup.BackupScreen
import ru.vldkr.shkaff.features.fragment.FragmentScreen
import ru.vldkr.shkaff.features.export.ExportScreen
import ru.vldkr.shkaff.features.federation.FederationScreen
import ru.vldkr.shkaff.features.items.ItemsScreen
import ru.vldkr.shkaff.features.journal.JournalScreen
import ru.vldkr.shkaff.features.labels.LabelsScreen
import ru.vldkr.shkaff.features.loans.LoansScreen
import ru.vldkr.shkaff.features.merge.ConflictsScreen
import ru.vldkr.shkaff.features.printers.PrintersScreen
import ru.vldkr.shkaff.features.profiles.ProfilesScreen
import ru.vldkr.shkaff.features.labels.TemplatesScreen
import ru.vldkr.shkaff.features.llm.ModelStoreScreen
import ru.vldkr.shkaff.features.locations.LocationDetailScreen
import ru.vldkr.shkaff.features.locations.LocationFormScreen
import ru.vldkr.shkaff.features.scan.ScannerScreen
import ru.vldkr.shkaff.di.Deps
import ru.vldkr.shkaff.data.printer.UsbPermission
import ru.vldkr.shkaff.domain.links.AppLink
import ru.vldkr.shkaff.util.DeepLinkBus
import ru.vldkr.shkaff.util.ScanBus
import ru.vldkr.shkaff.features.settings.SettingsScreen
import ru.vldkr.shkaff.features.stacks.StackDetailScreen
import ru.vldkr.shkaff.features.stacks.StacksScreen
import ru.vldkr.shkaff.features.storages.StorageDetailScreen
import ru.vldkr.shkaff.features.storages.StorageFormScreen
import ru.vldkr.shkaff.features.storages.StoragesScreen
import ru.vldkr.shkaff.ui.theme.Ozon
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UsbPermission.onIntent(intent)
        enableEdgeToEdge()
        setContent {
            ShkaffTheme {
                SplashHost()
            }
        }
        handleDeepLink(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        UsbPermission.onIntent(intent)
        handleDeepLink(intent)
    }

    // US-I3: QR со ссылкой приложения открывает «Шкаф» и ведёт к вещи по коду.
    private fun handleDeepLink(intent: Intent?) {
        val code = intent?.data?.toString()?.let { AppLink.parse(it) } ?: return
        DeepLinkBus.send(code)
    }
}

private const val SPLASH_DURATION_MS = 1500L

@Composable
private fun SplashHost() {
    var splashVisible by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        delay(SPLASH_DURATION_MS)
        splashVisible = false
    }
    Box(modifier = Modifier.fillMaxSize()) {
        AppRoot()
        AnimatedVisibility(
            visible = splashVisible,
            exit = fadeOut(tween(350))
        ) {
            Image(
                painter = painterResource(R.drawable.splash_screen),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

private data class Tab(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val pattern: String = route,
    val badgeKey: String? = null
)

// Таб-бар как в Ozon: Главная, Шкафы, [+] по центру, Поиск, Профиль.
private val tabs = listOf(
    Tab("dashboard", "Главная", Icons.Filled.Home, "dashboard"),
    Tab("storages", "Шкафы", Icons.Filled.Storage, "storages", "storages"),
    Tab("items/0", "Поиск", Icons.Filled.Search, "items/{tag}", "items"),
    Tab("profiles", "Профиль", Icons.Filled.Person, "profiles")
)

// Счётчики для бейджей в таб-баре (как «99+» у Ozon): число вещей и хранилищ.
@Composable
private fun TabCounts(): Map<String, Int> {
    val items by remember { Deps.items.observeAll() }.collectAsState(initial = emptyList())
    val storages by remember { Deps.storages.observeAll() }.collectAsState(initial = emptyList())
    return mapOf("items" to items.size, "storages" to storages.size)
}

private fun badgeText(count: Int): String? = when {
    count <= 0 -> null
    count > 99 -> "99+"
    else -> count.toString()
}

@Composable
fun AppRoot() {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val onTab = tabs.any { it.pattern == currentRoute }
    val counts = TabCounts()

    // US-I3: deep-link из QR/браузера — открываем «Вещи» с поиском по коду.
    LaunchedEffect(navController) {
        for (code in DeepLinkBus.codes) {
            ScanBus.lastCode = code
            navController.navigate("items/0") {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    }

    Scaffold(
        bottomBar = {
            if (onTab) {
                Column {
                    HorizontalDivider(color = Ozon.Card, thickness = 1.dp)
                    NavigationBar(containerColor = Ozon.Bg) {
                        // 5 слотов: Главная, Шкафы, [+] по центру, Поиск, Профиль.
                        // ВАЖНО: центральной кнопке НЕЛЬЗЯ давать fillMaxHeight() — она растянула бы
                        // весь NavigationBar на экран и сжала контент до нуля.
                        (0..4).forEach { slot ->
                            if (slot == 2) {
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable {
                                            navController.navigate("item-form/0/0")
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Box(
                                        Modifier
                                            .size(44.dp)
                                            .clip(CircleShape)
                                            .background(Ozon.Blue),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            Icons.Filled.Add,
                                            contentDescription = "Новая вещь",
                                            tint = Color.White,
                                            modifier = Modifier.size(26.dp)
                                        )
                                    }
                                }
                            } else {
                                val tab = tabs[if (slot < 2) slot else slot - 1]
                                val badge = badgeText(counts[tab.badgeKey ?: tab.route] ?: 0)
                                NavigationBarItem(
                                    selected = currentRoute == tab.pattern,
                                    onClick = {
                                        navController.navigate(tab.route) {
                                            popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if (badge != null) {
                                                    Badge(containerColor = Ozon.Pink, contentColor = Color.White) {
                                                        Text(badge, style = MaterialTheme.typography.labelSmall, fontWeight = FontWeight.Bold)
                                                    }
                                                }
                                            }
                                        ) {
                                            Icon(tab.icon, contentDescription = tab.label)
                                        }
                                    },
                                    label = { Text(tab.label) },
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedIconColor = Ozon.Blue,
                                        selectedTextColor = Ozon.Blue,
                                        indicatorColor = Color.Transparent,
                                        unselectedIconColor = Ozon.TextSecondary,
                                        unselectedTextColor = Ozon.TextSecondary
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = "dashboard",
            modifier = Modifier.padding(padding)
        ) {
            composable("dashboard") { DashboardScreen(navController) }
            composable("items/{tag}", arguments = listOf(navArgument("tag") { type = NavType.StringType })) { b ->
                ItemsScreen(navController, b.arguments?.getString("tag") ?: "")
            }
            composable("storages") { StoragesScreen(navController) }

            composable("storage/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType })) { b ->
                StorageDetailScreen(navController, b.arguments?.getString("id").orEmpty())
            }
            composable("storage-form/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType })) { b ->
                StorageFormScreen(navController, b.arguments?.getString("id").orEmpty())
            }

            composable("location/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType })) { b ->
                LocationDetailScreen(navController, b.arguments?.getString("id").orEmpty())
            }
            composable("location-form/{storageId}/{id}", arguments = listOf(
                navArgument("storageId") { type = NavType.StringType },
                navArgument("id") { type = NavType.StringType }
            )) { b ->
                LocationFormScreen(
                    navController,
                    b.arguments?.getString("storageId").orEmpty(),
                    b.arguments?.getString("id").orEmpty()
                )
            }

            composable("item/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType })) { b ->
                ItemDetailScreen(navController, b.arguments?.getString("id").orEmpty())
            }
            composable("item-form/{id}/{locationId}", arguments = listOf(
                navArgument("id") { type = NavType.StringType },
                navArgument("locationId") { type = NavType.StringType }
            )) { b ->
                ItemFormScreen(
                    navController,
                    b.arguments?.getString("id").orEmpty(),
                    b.arguments?.getString("locationId").orEmpty()
                )
            }

            composable("batch") { BatchEntryScreen(navController) }
            composable("scan") { ScannerScreen(navController) }
            composable("annotations/{storageId}", arguments = listOf(navArgument("storageId") { type = NavType.StringType })) { b ->
                AnnotationScreen(navController, b.arguments?.getString("storageId").orEmpty())
            }
            composable("labels/{itemId}/{templateId}", arguments = listOf(
                navArgument("itemId") { type = NavType.StringType },
                navArgument("templateId") { type = NavType.StringType }
            )) { b ->
                LabelsScreen(
                    navController,
                    b.arguments?.getString("itemId").orEmpty(),
                    b.arguments?.getString("templateId").orEmpty()
                )
            }
            composable("templates") { TemplatesScreen(navController) }
            composable("backup") { BackupScreen(navController) }
            composable("federation") { FederationScreen(navController) }
            composable("fragment") { FragmentScreen(navController) }
            composable("export") { ExportScreen(navController) }
            composable("conflicts") { ConflictsScreen(navController) }
            composable("printers") { PrintersScreen(navController) }
            composable("agent") { AgentScreen(navController) }
            composable("agent-volumes") { VolumeEstimateScreen(navController) }
            composable("llm-models") { ModelStoreScreen(navController) }

            composable("attrdefs") { AttrDefsScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
            composable("profiles") { ProfilesScreen(navController) }
            composable("loans") { LoansScreen(navController) }
            composable("journal") { JournalScreen(navController) }
            composable("actions") { ActionsScreen(navController) }

            composable("stacks") { StacksScreen(navController) }
            composable("stack/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType })) { b ->
                StackDetailScreen(navController, b.arguments?.getString("id").orEmpty())
            }

            composable("basket") { BasketScreen(navController) }
            composable("basket/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType })) { b ->
                BasketDetailScreen(navController, b.arguments?.getString("id").orEmpty())
            }
        }
    }
}
