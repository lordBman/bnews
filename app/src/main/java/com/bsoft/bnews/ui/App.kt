package com.bsoft.bnews.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bsoft.bnews.ui.screens.InfoScreen
import com.bsoft.bnews.ui.screens.LoadingScreen
import com.bsoft.bnews.ui.screens.MainScreen
import com.bsoft.bnews.ui.theme.BNewsTheme
import com.bsoft.bnews.utils.LightDarkPreview
import com.bsoft.bnews.utils.RootRoutes
//val LocalNavController = compositionLocalOf <NavController>{
   // error("No NavController found!")
//}

@Composable
fun appscreen(){

        val navController = rememberNavController()

     //   CompositionLocalProvider(LocalNavController provides navController) {
            NavHost(
                navController = navController,
                startDestination = RootRoutes.loading) {
                    composable(route = RootRoutes.loading) {
                        LoadingScreen()
                    }
                    composable(route = RootRoutes.main) {
                        MainScreen()
                    }
                    composable(route = RootRoutes.info) {
                        InfoScreen()
                    }
                }
    //    }
    }


//@LightDarkPreview
//@Composable
//fun AppPreview(){
//    appscreen()
//}


@Preview
@Composable
fun txxt(){
    appscreen()
}