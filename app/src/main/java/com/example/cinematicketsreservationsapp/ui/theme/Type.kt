package com.example.cinematicketsreservationsapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.cinematicketsreservationsapp.R

// Set of Material typography styles to start with

val poppins = FontFamily(
    Font(R.font.poppins_regular),
    Font(R.font.poppins_medium, FontWeight.Medium)
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 28.sp,
    ),
)