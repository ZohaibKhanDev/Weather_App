package com.example.weathers.presentation.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weathers.presentation.ui.screen.AddScreen
import com.example.weathers.presentation.ui.screen.LocationScreen
import com.example.weathers.presentation.ui.screen.MenuScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Location.route
    ) {
        composable(Screen.Location.route) {
            LocationScreen()
        }
        composable(Screen.Add.route) {
            AddScreen()
        }
        composable(Screen.Menu.route) {
            MenuScreen()
        }
    }
}

sealed class Screen(
    val tittle: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
) {
    object Location : Screen(
        "Location",
        "Location",
        selectedIcon = Icons.Outlined.LocationOn,
        unSelectedIcon = Icons.Outlined.LocationOn
    )

    object Add : Screen(
        "Add",
        "Add",
        selectedIcon = Icons.Outlined.AddCircleOutline,
        unSelectedIcon = Icons.Outlined.AddCircleOutline
    )

    object Menu : Screen(
        "Menu",
        "Menu",
        selectedIcon = Icons.Outlined.Menu,
        unSelectedIcon = Icons.Outlined.Menu
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavEntry() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { BottomNavigation(navController = navController) }) {
        Navigation(navController = navController)
    }
}

@Composable
fun BottomNavigation(navController: NavController) {
    val item = listOf(
        Screen.Location,
        Screen.Add,
        Screen.Menu
    )

    NavigationBar(containerColor = Color(0XFF9D52AC)) {
        val navStack by navController.currentBackStackEntryAsState()
        val current = navStack?.destination?.route

        item.forEach {
            NavigationBarItem(
                selected = current == it.route,
                onClick = {
                    navController.navigate(it.route) {
                        navController.graph?.let {
                            it.route?.let { it1 -> popUpTo(it1) }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    if (current == it.route) {
                        Icon(imageVector = it.selectedIcon, contentDescription = "")
                    } else {
                        Icon(imageVector = it.unSelectedIcon, contentDescription = "")
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.White,
                    indicatorColor = Color(0XFF9D52AC)
                )
            )
        }
    }
}