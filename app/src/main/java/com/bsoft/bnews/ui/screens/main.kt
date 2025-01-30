package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

enum class PageRoute(val title: String, val icon: ImageVector){
    Home("Home", icon = Icons.Outlined.Home),
    Settings("Settings", icon = Icons.Outlined.Settings)
}

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
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Surface(modifier = Modifier.padding(it)) {

        }
    }
}

@Composable
@Preview
fun MainScreenPreview(){
    MainScreen()
}