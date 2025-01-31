package com.bsoft.bnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsoft.bnews.ui.screens.InfoScreen
import com.bsoft.bnews.ui.screens.LoadingScreen
import com.bsoft.bnews.ui.screens.MainScreen
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.LightDarkPreview
import com.bsoft.bnews.utils.RootRoutes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { App() }
    }
}

@Composable
fun App(){
    BNewsTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = RootRoutes.main , builder = {
            composable(route = RootRoutes.loading) {
                LoadingScreen()
            }
            composable(route = RootRoutes.main) {
                MainScreen()
            }
            composable(route = RootRoutes.info) {
                InfoScreen()
            }
        } )
    }
}

@LightDarkPreview
@Composable
fun AppPreview(){
    App()
}