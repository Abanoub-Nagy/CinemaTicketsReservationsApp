package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cinematicketsreservationsapp.ui.theme.SelectedChip

@Composable
fun DateChip(
    day: Int,
    selectedDay: Int,
    onChecked: (Int) -> Unit,
    selectedColor: Color = SelectedChip
) {
    val isSelected = day == selectedDay
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else SelectedChip,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                onChecked(day)
            }
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = day.toString(),
            color = if (isSelected) White else Color.Black,
            fontSize = 16.sp
        )
        Text(
            text = "Fri",
            color = Color.LightGray,
            fontSize = 12.sp
        )
    }
}

@Preview()
@Composable
fun DateChipPreview() {
    DateChip(14, 12, {})
}
