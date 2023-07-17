package com.example.cinematicketsreservationsapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cinematicketsreservationsapp.composable.BottomAppBar
import com.example.cinematicketsreservationsapp.ui.theme.CinemaTicketsReservationsAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CinemaTicketApp() {
    CinemaTicketsReservationsAppTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomAppBar(navController) }) {
            NavGraph(navHostController = navController, modifier = Modifier.padding(it))
        }
    }
}