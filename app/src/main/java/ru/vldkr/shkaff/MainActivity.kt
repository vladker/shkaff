package ru.vldkr.shkaff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.vldkr.shkaff.features.annotations.AnnotationScreen
import ru.vldkr.shkaff.features.attrdefs.AttrDefsScreen
import ru.vldkr.shkaff.features.dashboard.DashboardScreen
import ru.vldkr.shkaff.features.items.ItemDetailScreen
import ru.vldkr.shkaff.features.items.ItemFormScreen
import ru.vldkr.shkaff.features.backup.BackupScreen
import ru.vldkr.shkaff.features.items.ItemsScreen
import ru.vldkr.shkaff.features.labels.LabelsScreen
import ru.vldkr.shkaff.features.merge.ConflictsScreen
import ru.vldkr.shkaff.features.printers.PrintersScreen
import ru.vldkr.shkaff.features.labels.TemplatesScreen
import ru.vldkr.shkaff.features.locations.LocationDetailScreen
import ru.vldkr.shkaff.features.locations.LocationFormScreen
import ru.vldkr.shkaff.features.scan.ScannerScreen
import ru.vldkr.shkaff.features.settings.SettingsScreen
import ru.vldkr.shkaff.features.storages.StorageDetailScreen
import ru.vldkr.shkaff.features.storages.StorageFormScreen
import ru.vldkr.shkaff.features.storages.StoragesScreen
import ru.vldkr.shkaff.ui.theme.ShkaffTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShkaffTheme {
                AppRoot()
            }
        }
    }
}

private data class Tab(val route: String, val label: String, val icon: ImageVector)

private val tabs = listOf(
    Tab("dashboard", "Главная", Icons.Filled.Home),
    Tab("items", "Вещи", Icons.Filled.Inventory2),
    Tab("storages", "Хранилища", Icons.Filled.Storage)
)

@Composable
fun AppRoot() {
    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val currentRoute = backStack?.destination?.route
    val onTab = tabs.any { it.route == currentRoute }

    Scaffold(
        bottomBar = {
            if (onTab) {
                NavigationBar {
                    tabs.forEach { tab ->
                        NavigationBarItem(
                            selected = currentRoute == tab.route,
                            onClick = {
                                navController.navigate(tab.route) {
                                    popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            icon = { Icon(tab.icon, contentDescription = tab.label) },
                            label = { Text(tab.label) }
                        )
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
            composable("items") { ItemsScreen(navController) }
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
            composable("conflicts") { ConflictsScreen(navController) }
            composable("printers") { PrintersScreen(navController) }

            composable("attrdefs") { AttrDefsScreen(navController) }
            composable("settings") { SettingsScreen(navController) }
        }
    }
}
