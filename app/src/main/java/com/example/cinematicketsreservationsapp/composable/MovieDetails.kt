package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.ui.theme.Gray

@Composable
fun MovieDetails() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.clock),
            contentDescription = "clock",
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(text = "2h 23m")
    }

    Text(
        modifier = Modifier.padding(vertical = 16.dp),
        text = "Fantastic Beasts: The\nSecrets of Dumbledore",
        fontSize = 22.sp,
        textAlign = TextAlign.Center
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        OutlineButton(modifier = Modifier.padding(end = 8.dp), text = "Fantasy") {

        }
        OutlineButton(text = "Adventure") {

        }
    }
}

@Composable
fun OutlineButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textSize: Int = 14,
    buttonColor: Color = Color.Transparent,
    textColor: Color = Color.Black,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = modifier,
        onClick = onClick,
        border = BorderStroke(0.5.dp, Gray),
        colors = ButtonDefaults.buttonColors(buttonColor),
    ) {
        Text(
            text = text,
            fontSize = textSize.sp,
            color = textColor
        )
    }
}