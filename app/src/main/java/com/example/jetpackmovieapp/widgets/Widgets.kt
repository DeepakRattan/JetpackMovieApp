package com.example.jetpackmovieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import com.example.jetpackmovieapp.model.Movie
import com.example.jetpackmovieapp.model.getMovies

/**
 * Created by Deepak Rattan on 09/04/23
 */

@Preview
@Composable
fun MovieRow(
    movie: Movie = getMovies()[0],
    onItemClick: (String) -> Unit = {}
) {

    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
//            .height(130.dp)
            .clickable {
                movie.imdbID?.let { onItemClick(it) }
            }, shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        ), elevation = 6.dp
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
                    painter = rememberImagePainter(data = movie.images[0], builder = {
                        crossfade(true)
                        transformations(CircleCropTransformation())
                    }),
                )

            }
            Column(modifier = Modifier.padding(4.dp)) {
                movie.title?.let {
                    Text(
                        text = it, style = MaterialTheme.typography.h6
                    )
                }
                movie.director?.let {
                    Text(
                        text = "Director : $it", style = MaterialTheme.typography.caption
                    )
                }
                movie.year?.let {
                    Text(
                        text = "Release : $it", style = MaterialTheme.typography.caption
                    )
                }

                // Adds expand capability on the card to show more movie info
                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(
                            buildAnnotatedString {
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp
                                    )
                                ) {
                                    append("Plot: ")
                                }
                                withStyle(
                                    style = SpanStyle(
                                        color = Color.DarkGray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Light
                                    )
                                ) {
                                    movie.plot?.let { append(it) }
                                }
                            },
                            modifier = Modifier.padding(4.dp)
                        )
                        Divider(modifier = Modifier.padding(4.dp))
                        Text(
                            text = "Director: ${movie.director}",
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = "Actors: ${movie.actors}",
                            style = MaterialTheme.typography.caption
                        )
                        Text(
                            text = "Rating: ${movie.imdbRating}",
                            style = MaterialTheme.typography.caption
                        )

                    }
                }


                Icon(imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Down Arrow",
                    tint = Color.DarkGray,
                    modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        })
            }
        }


    }

}