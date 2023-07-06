package com.example.cinematicketsreservationsapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.composable.MovieCategoriesChip
import com.example.cinematicketsreservationsapp.composable.MovieDuration
import com.example.cinematicketsreservationsapp.composable.SpacerHorizontal8
import com.example.cinematicketsreservationsapp.composable.SpacerVertical16
import com.example.cinematicketsreservationsapp.composable.SpacerVertical4
import com.example.cinematicketsreservationsapp.composable.SpacerVertical8
import com.example.cinematicketsreservationsapp.ui.theme.LightWhite
import com.example.cinematicketsreservationsapp.ui.theme.Orange80
import com.example.cinematicketsreservationsapp.ui.theme.poppins

@Composable
fun MovieDetailsScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (imagePoster, playButton, movieDuration, backButton, informationCard) = createRefs()
        val topGuideLine = createGuidelineFromTop(0.40f)


        Image(
            painter = painterResource(id = R.drawable.poster),
            contentDescription = "poster movie",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .constrainAs(imagePoster) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentScale = ContentScale.Crop
        )
        Surface(
            color = Orange80,
            shape = CircleShape,
            modifier = Modifier
                .size(55.dp)
                .constrainAs(playButton) {
                    top.linkTo(imagePoster.top)
                    start.linkTo(imagePoster.start)
                    end.linkTo(imagePoster.end)
                    bottom.linkTo(imagePoster.bottom)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.play),
                contentDescription = "movie start to view",
                tint = Color.White,
                modifier = Modifier.padding(16.dp)
            )
        }
        Surface(
            color = LightWhite,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 32.dp, end = 16.dp)
                .constrainAs(movieDuration) {
                    top.linkTo(parent.top)
                    end.linkTo(imagePoster.end)
                }
        ) {
            MovieDuration(
                time = "3h 55m",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                iconColor = Color.White,
                textColor = Color.White
            )
        }
        Surface(
            color = LightWhite,
            shape = CircleShape,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 24.dp, start = 16.dp)
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(imagePoster.start)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.close_circle),
                contentDescription = "exit movie details",
                tint = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Surface(
            shape = RoundedCornerShape(
                topStart = 32.dp,
                topEnd = 23.dp
            ),
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(informationCard) {
                    top.linkTo(topGuideLine)
                }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 36.dp,
                            start = 48.dp,
                            end = 48.dp
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row() {
                            Text(text = "6", fontSize = 16.sp)
                            Text(text = "/10", color = Color.Gray, fontSize = 16.sp)
                        }
                        SpacerVertical4()
                        Text(text = "IMDB", color = Color.Gray, fontSize = 12.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "63%", fontSize = 16.sp)
                        SpacerVertical4()
                        Text(text = "Rotten Tomatoes", color = Color.Gray, fontSize = 12.sp)
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row() {
                            Text(text = "4", fontSize = 16.sp)
                            Text(text = "/10", color = Color.Gray, fontSize = 16.sp)
                        }
                        SpacerVertical4()
                        Text(text = "IGN", color = Color.Gray, fontSize = 12.sp)
                    }
                }
                SpacerVertical16()
                Text(
                    text = "Fantastic Beasts: The Secrets of Dumbledore",
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(horizontal = 48.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = poppins,
                )
                SpacerVertical8()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    MovieCategoriesChip(title = "Fantasy", selected = true)
                    SpacerHorizontal8()
                    MovieCategoriesChip(title = "Adventure", selected = false)
                }
                SpacerVertical16()
                LazyRow(
                    contentPadding = PaddingValues(start = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    for (i in 1..10) {
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.photo),
                                contentDescription = "A",
                                modifier = Modifier.size(60.dp),
                            )
                        }
                    }
                }
                SpacerVertical16()
                Text(
                    text = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers.",
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 30.dp),
                    maxLines = 3,
                    textAlign = TextAlign.Center,
                    fontFamily = poppins
                )
                SpacerVertical16()
                Button(
                    onClick = { },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange80,
                        contentColor = Color.White
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ticket),
                        contentDescription = "register movie ticket"
                    )
                    Text(
                        text = "Booking",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = poppins
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}