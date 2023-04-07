package com.example.jetpackmovieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

        composable(MovieScreens.DetailScreen.name) {
            DetailsScreen(navController = navController)
        }

    }
}