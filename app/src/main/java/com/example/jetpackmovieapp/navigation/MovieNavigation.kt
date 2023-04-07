package com.example.jetpackmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackmovieapp.screens.details.DetailsScreen
import com.example.jetpackmovieapp.screens.home.HomeScreen

/**
 * Created by Deepak Rattan on 05/04/23
 */

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        // www.google.com/detail-screen/id=34
        composable(
            MovieScreens.DetailScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )

        }

    }
}