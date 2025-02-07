package com.bsoft.bnews.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsoft.bnews.ui.screens.InfoScreen
import com.bsoft.bnews.ui.screens.LoadingScreen
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.MobilePreview
import com.bsoft.bnews.utils.RootRoutes

val LocalNavController = compositionLocalOf<NavHostController>{
   error("No NavController found!")
}

@Composable
fun App(){
    Surface (modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()

        CompositionLocalProvider(LocalNavController provides navController) {
            NavHost(navController = navController, startDestination = RootRoutes.loading) {
                composable(route = RootRoutes.loading) {
                    LoadingScreen()
                }
                composable(route = RootRoutes.info) {
                    InfoScreen()
                }
            }
        }
    }
}


@MobilePreview
@Composable
fun AppPreview(){
    BNewsTheme {
        App()
    }
}