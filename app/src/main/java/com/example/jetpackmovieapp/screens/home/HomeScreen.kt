package com.example.jetpackmovieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackmovieapp.MovieRow
import com.example.jetpackmovieapp.navigation.MovieScreens

/**
 * Created by Deepak Rattan on 07/04/23
 */

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Magenta,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        },
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
        "Lagaan",
        "Avtaar",
        "Bahubali",
        "RRR",
        "Chak De",
        "Dhoni",
        "Bend it like Bekhem",
        "DDLJ"
    )
) {
    Column(modifier = Modifier.padding(all = 12.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie ->
                    Log.d("Movie", "Clicked Movie is $movie ")
                    navController.navigate(route = MovieScreens.DetailScreen.name + "/$movie")
                }
            }
        }

    }
}