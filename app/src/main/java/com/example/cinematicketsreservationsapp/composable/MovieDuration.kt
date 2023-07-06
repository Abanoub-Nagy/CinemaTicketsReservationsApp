package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.cinematicketsreservationsapp.R

@Composable
fun MovieDuration(
    time: String,
    modifier: Modifier = Modifier,
    iconColor: Color = Color.Gray,
    textColor: Color = Color.Black,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.clock),
            contentDescription = "Time",
            tint = iconColor
        )
        SpacerHorizontal8()
        Text(text = time, color = textColor)
    }
}