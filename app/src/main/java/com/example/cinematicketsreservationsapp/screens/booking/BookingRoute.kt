package com.example.cinematicketsreservationsapp.screens.booking

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cinematicketsreservationsapp.AppDestination

fun NavGraphBuilder.ticketRoute(navHostController: NavHostController) {
    composable(AppDestination.BookingScreen.route) { MovieBookingScreen(navHostController) }
}