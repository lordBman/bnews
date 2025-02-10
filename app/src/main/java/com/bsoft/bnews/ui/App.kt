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
import com.bsoft.bnews.ui.screens.MainScreen
import com.bsoft.bnews.ui.screens.OnBoardingScreen
import com.bsoft.bnews.utils.RootRoutes

val LocalRootNavController = compositionLocalOf<NavHostController>{
   error("No NavController found!")
}

@Composable
fun App(){
    Surface (modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        CompositionLocalProvider(LocalRootNavController provides navController) {
            NavHost(navController = navController, startDestination = RootRoutes.loading) {
                composable(route = RootRoutes.loading) {
                    LoadingScreen()
                }
                composable(route = RootRoutes.info) {
                    InfoScreen()
                }
                composable(route = RootRoutes.main) {
                    MainScreen()
                }
                composable(route = RootRoutes.onboarding) {
                    OnBoardingScreen()
                }
            }
        }
    }
}