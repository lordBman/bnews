package com.bsoft.bnews.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bsoft.bnews.ui.screens.ArticleScreen
import com.bsoft.bnews.ui.screens.InfoScreen
import com.bsoft.bnews.ui.screens.LoadingScreen
import com.bsoft.bnews.ui.screens.MainScreen
import com.bsoft.bnews.ui.screens.OnBoardingScreen
import com.bsoft.bnews.ui.screens.SearchScreen
import com.bsoft.bnews.utils.DataStoreManager
import com.bsoft.bnews.utils.PreferenceManager
import com.bsoft.bnews.utils.RootRoutes
import com.bsoft.bnews.viewmodels.NewsDataViewModel
import com.bsoft.bnews.viewmodels.OnboardingViewModel

val LocalRootNavController = compositionLocalOf<NavHostController>{
   error("No NavController found!")
}

@Composable
fun App(viewModel: OnboardingViewModel = hiltViewModel(), newsDataViewModel: NewsDataViewModel = hiltViewModel()){
    val isOnboardingCompleted by viewModel.isOnboardingCompleted.collectAsState()

    Surface (modifier = Modifier.fillMaxSize()) {
        val navController = rememberNavController()
        val startDest = if(isOnboardingCompleted){
            RootRoutes.main
        }else{
            RootRoutes.onboarding
        }

        CompositionLocalProvider(LocalRootNavController provides navController) {
            NavHost(navController = navController, startDestination = startDest) {
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
                composable(route = RootRoutes.search) {
                    SearchScreen()
                }
                composable(
                    route = "${RootRoutes.article}/{category}/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.StringType })) { entry ->
                    val category = entry.arguments?.getString("category") ?: ""
                    val id = entry.arguments?.getString("id") ?: ""

                    ArticleScreen(category = category, id = id, newsDataViewModel = newsDataViewModel)
                }
            }
        }
    }
}