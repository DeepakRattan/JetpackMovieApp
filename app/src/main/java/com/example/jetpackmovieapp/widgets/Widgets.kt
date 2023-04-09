package com.example.jetpackmovieapp.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import com.example.jetpackmovieapp.model.Movie
import com.example.jetpackmovieapp.model.getMovies

/**
 * Created by Deepak Rattan on 09/04/23
 */

@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(130.dp)
            .clickable {
                movie.imdbID?.let { onItemClick(it) }
            },
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        ),
        elevation = 6.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp
            ) {
                Image(
                    contentDescription = "Image",
                    painter = rememberImagePainter(
                        data = movie.images[0],
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                        }
                    ),
                )

//                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "Image")
            }
            Column(modifier = Modifier.padding(4.dp)) {
                movie.title?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h6
                    )
                }
                movie.director?.let {
                    Text(
                        text = "Director : $it",
                        style = MaterialTheme.typography.caption
                    )
                }
                movie.year?.let {
                    Text(
                        text = "Release : $it",
                        style = MaterialTheme.typography.caption
                    )
                }

            }

        }
    }

}