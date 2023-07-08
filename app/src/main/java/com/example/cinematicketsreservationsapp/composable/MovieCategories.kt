package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MovieCategories() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        MovieCategoriesChip(
            title = "Now Showing",
            selected = true,
            onClick = {},
            textColor = Color.White
        )
        SpacerHorizontal8()
        MovieCategoriesChip(
            title = "Coming Soon",
            selected = false,
            onClick = {},
            textColor = Color.White
        )
    }
}