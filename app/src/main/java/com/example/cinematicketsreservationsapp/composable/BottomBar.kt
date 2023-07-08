package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.ui.theme.Orange80

@Composable
fun BottomAppBar(){
    BottomAppBar(containerColor = Color.Transparent) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.video_play),
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Orange80)
                    .padding(10.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.search_normal),
                tint = Color.Black,
                contentDescription = "search"
            )
            Icon(
                painter = painterResource(id = R.drawable.ticket),
                tint = Color.Black,
                contentDescription = "ticket"
            )
            Icon(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "person",
                tint = Color.Black
            )
        }
    }
}
