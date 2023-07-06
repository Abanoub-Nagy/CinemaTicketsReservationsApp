package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.cinematicketsreservationsapp.ui.theme.Orange80

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCategoriesChip(
    title: String,
    selected: Boolean = false,
    textColor: Color = Color.Black,
    onClick: (() -> Unit)? = null
) {
    FilterChip(
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Orange80,
            selectedLabelColor = Color.White,
            labelColor = Color.White
        ),
        selected = selected,
        onClick = onClick ?: {},
        shape = CircleShape,
        label = { Text(title, fontWeight = FontWeight.Normal, color = textColor) }
    )
}