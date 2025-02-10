package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bsoft.bnews.ui.pages.HomePage
import com.bsoft.bnews.ui.pages.SettingsPage
import com.bsoft.bnews.utils.PageRoute

@Composable
fun CustomBottomBar(navController: NavHostController){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: return

    val colors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.primary,
        unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
        selectedTextColor = MaterialTheme.colorScheme.primary,
        unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
    )

    NavigationBar{
        PageRoute.entries.forEach{
            NavigationBarItem(selected = currentRoute == it.title,
                onClick = { navController.navigate(it.title) },
                icon = { Icon(imageVector = it.icon, contentDescription = "") },
                label = { Text(text = it.title) },
                colors = colors
            )
        }
    }
}

@Composable
fun MainScreen(){
    val bottomNavController = rememberNavController()
    Scaffold(bottomBar = { CustomBottomBar(navController = bottomNavController) }) {
        NavHost(modifier = Modifier.padding(it), navController = bottomNavController, startDestination = PageRoute.Home.title) {
            composable(route = PageRoute.Home.title) {
                HomePage()
            }
            composable(route = PageRoute.Settings.title) {
                SettingsPage()
            }
        }
    }
}