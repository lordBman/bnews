package com.bsoft.bnews.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.TopAppBarState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bsoft.bnews.R
import com.bsoft.bnews.ui.LocalRootNavController
import com.bsoft.bnews.ui.icons.Newspaper
import com.bsoft.bnews.ui.icons.Search
import com.bsoft.bnews.ui.pages.HomePage
import com.bsoft.bnews.ui.pages.SavedPage
import com.bsoft.bnews.ui.pages.SettingsPage
import com.bsoft.bnews.utils.PageRoute
import com.bsoft.bnews.utils.RootRoutes

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CustomTopBar(state: TopAppBarState = rememberTopAppBarState()){
    val rootNavController = LocalRootNavController.current

    val colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surfaceContainerHigh)
    TopAppBar(
        scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(state),
        colors = colors,
        modifier = Modifier.shadow(elevation = 8.dp),
        title = {
            Text("B-News", fontSize = 20.sp, fontFamily = FontFamily.SansSerif, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
        },
        navigationIcon = {
            Image(imageVector = ImageVector.vectorResource(R.drawable.noto__rolled_up_newspaper), modifier = Modifier.size(42.dp), contentDescription = "")
        },
        actions = {
            IconButton(onClick = { rootNavController.navigate(RootRoutes.search) }) {
                Icon(modifier = Modifier.size(20.dp), imageVector = Search, contentDescription = "")
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    val bottomNavController = rememberNavController()
    val topAppBarState = rememberTopAppBarState()

    Scaffold(topBar = { CustomTopBar() }, bottomBar = { CustomBottomBar(navController = bottomNavController) }) {
        NavHost(modifier = Modifier.padding(it), navController = bottomNavController, startDestination = PageRoute.Home.title) {
            composable(route = PageRoute.Home.title) {
                HomePage(topAppBarState)
            }
            composable(route = PageRoute.Saved.title) {
                SavedPage()
            }
            composable(route = PageRoute.Settings.title) {
                SettingsPage()
            }
        }
    }
}