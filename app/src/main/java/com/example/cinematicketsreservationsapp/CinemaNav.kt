package com.example.cinematicketsreservationsapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.cinematicketsreservationsapp.screens.booking.ticketRoute
import com.example.cinematicketsreservationsapp.screens.details.detailsRoute
import com.example.cinematicketsreservationsapp.screens.home.homeRoute

@Composable
fun NavGraph(navHostController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = AppDestination.HomeScreen.route
    ) {

        homeRoute(navHostController)

        detailsRoute(navHostController)

        ticketRoute(navHostController)
    }
}