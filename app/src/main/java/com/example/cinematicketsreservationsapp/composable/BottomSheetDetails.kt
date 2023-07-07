package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.ui.theme.poppins
import com.example.cinematicketsreservationsapp.util.Constant.DEFAULT_IMAGE

@Composable
fun BottomSheetDetails() {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 18.dp, start = 50.dp, end = 50.dp),
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
                Text(
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                    text = "Fantastic Beasts: The\nSecrets of Dumbledore",
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            MovieCategoriesChip(title = "Fantasy", selected = false)
            SpacerHorizontal4()
            MovieCategoriesChip(title = "Adventure", selected = false)
        }
        SpacerVertical16()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(start = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(20) { ActorImage(imageUrl = DEFAULT_IMAGE) }
        }
        Column(
            modifier = Modifier.padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Text(
                text = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers.",
                fontSize = 12.sp,
                modifier = Modifier.padding(horizontal = 30.dp),
                maxLines = 3,
                textAlign = TextAlign.Center,
                fontFamily = poppins
            )
            CustomButton(
                "Booking",
                iconDrawable = R.drawable.bitcoin_card
            ) {

            }
        }
    }
}

