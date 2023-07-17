package com.example.cinematicketsreservationsapp

sealed class AppDestination(val route: String) {
    object HomeScreen : AppDestination("homeScreen")
    object DetailsScreen : AppDestination("bookingScreen")
    object BookingScreen : AppDestination("ticketScreen")
}