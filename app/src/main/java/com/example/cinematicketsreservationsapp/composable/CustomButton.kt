package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketsreservationsapp.ui.theme.Orange80
import com.example.cinematicketsreservationsapp.ui.theme.poppins

@Composable
fun CustomButton(
    text: String,
    color: Color = Orange80,
    iconDrawable: Int,
    onclick: () -> Unit
) {
    Button(
        modifier = Modifier.padding(vertical = 16.dp),
        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 16.dp),
        onClick = onclick,
        colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = Color.White)
    )
    {
        Icon(painter = painterResource(id = iconDrawable), contentDescription = "")
        Text(
            text = text,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 8.dp),
            textAlign = TextAlign.Center,
            fontFamily = poppins
        )
    }
}