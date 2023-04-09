package com.example.jetpackmovieapp.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * Created by Deepak Rattan on 07/04/23
 */

@Composable
fun DetailsScreen(navController: NavController, movie: String?) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "Movie")
            }
        }
    }) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Movie is $movie",
                style = MaterialTheme.typography.h5,
                fontSize = 30.sp
            )
        }
    }


    /*Surface(
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

    }*/
}