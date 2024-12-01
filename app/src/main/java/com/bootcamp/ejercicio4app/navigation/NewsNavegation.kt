package com.bootcamp.ejercicio4app.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bootcamp.ejercicio4app.viewModel.NewsViewModel
import com.bootcamp.ejercicio4app.view.DetailsView
import com.bootcamp.ejercicio4app.view.HomeView


sealed class Screen(val route: String) {
    object HomeNews: Screen("home_news")
    object DetailsNew: Screen("details_new")
}

@Composable
fun NewsNavegation(viewModel: NewsViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.HomeNews.route) {
        composable(Screen.HomeNews.route) {
            HomeView(viewModel, navController)
        }

        composable(
            route = Screen.DetailsNew.route + "/{title}",
            arguments = listOf(navArgument("title") {
                type = NavType.StringType
                defaultValue = ""
                nullable = false
            })
        ) { entry ->
            val title = entry.arguments?.getString("title") ?: ""
            DetailsView(title, navController, viewModel)
        }
    }
}