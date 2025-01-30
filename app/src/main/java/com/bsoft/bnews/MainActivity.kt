package com.bsoft.bnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.bsoft.bnews.ui.screens.InfoScreen
import com.bsoft.bnews.ui.screens.LoadingScreen
import com.bsoft.bnews.ui.screens.MainScreen
import com.bsoft.bnews.ui.theme.BNewsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BNewsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Surface(modifier = Modifier.padding(it)) {

                    }
                }
            }
        }
    }
}

enum class Screens(val route: String) {
    Loading(route = "Loading"),
    Main(route = "Main"),
    Info(route = "Info")
}

@Composable
fun App(){
    BNewsTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screens.Loading.route , builder = {
                composable(route = Screens.Loading.route) {
                    LoadingScreen()
                }
                composable(route = Screens.Main.route) {
                    MainScreen()
                }
                composable(route = Screens.Info.route) {
                    InfoScreen()
                }
            } )

        }
    }
}

@Preview(name = "App Light Mode")
@Composable
fun AppPreview(){
    App()
}