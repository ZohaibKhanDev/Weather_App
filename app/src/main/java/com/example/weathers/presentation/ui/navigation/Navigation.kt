package com.example.weathers.presentation.ui.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.weathers.presentation.ui.screen.LocationScreen
import com.example.weathers.presentation.ui.screen.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.Location.route) {
            LocationScreen(navController)
        }

    }
}

sealed class Screen(
    val tittle: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector
) {
    object Home : Screen(
        "Home",
        "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home
    )

    object Location : Screen(
        "Location",
        "Location",
        selectedIcon = Icons.Filled.LocationOn,
        unSelectedIcon = Icons.Outlined.LocationOn
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
        Screen.Home,
        Screen.Location,

    )

    NavigationBar(containerColor = Color.White) {
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
                            Icon(imageVector = it.selectedIcon, contentDescription = "", tint = Color.Red)
                        } else {
                            Icon(imageVector = it.unSelectedIcon, contentDescription = "")
                        }


                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Red,
                    unselectedIconColor = Color.LightGray,
                    indicatorColor = Color.White
                )
            )
        }
    }
}