package com.example.jetpackmovieapp.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Created by Deepak Rattan on 07/04/23
 */

@Composable
fun DetailsScreen(navController: NavController, movie: String?) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Movie is $movie",
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    navController.popBackStack()
                }) {
                Text(text = "Go Back")
            }
        }

    }
}