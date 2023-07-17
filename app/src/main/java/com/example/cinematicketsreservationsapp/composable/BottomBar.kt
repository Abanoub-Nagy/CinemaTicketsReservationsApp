package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.cinematicketsreservationsapp.AppDestination
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.ui.theme.Orange80

@Composable
fun BottomAppBar(navController: NavHostController) {
    val current = navController.currentBackStackEntryAsState()
    val selectedScreen = current.value?.destination?.route ?: AppDestination.HomeScreen.route
    BottomAppBar(containerColor = Color.Transparent) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(63.dp)
                .background(Color.White)
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            ImageButton(
                painter = R.drawable.video_play,
                modifier = Modifier.size(52.dp),
                iconTint = if (selectedScreen == AppDestination.HomeScreen.route) Color.White else Color.Gray,
                backgroundColor = if (selectedScreen == AppDestination.HomeScreen.route) Orange80 else Color.Transparent
            ) {
                navController.navigate(AppDestination.HomeScreen.route)
            }
            ImageButton(
                painter = R.drawable.search_normal,
                modifier = Modifier.size(52.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
            ImageButton(
                painter = R.drawable.ticket,
                modifier = Modifier.size(52.dp),
                iconTint = if (selectedScreen == AppDestination.BookingScreen.route) Color.White else Color.Gray,
                backgroundColor = if (selectedScreen == AppDestination.BookingScreen.route) Orange80 else Color.Transparent
            ) {
                navController.navigate(AppDestination.BookingScreen.route)
            }
            ImageButton(
                painter = R.drawable.profile,
                modifier = Modifier.size(52.dp),
                iconTint = Color.Gray,
                backgroundColor = Color.Transparent
            ) {}
        }
    }
}
