package com.example.cinematicketsreservationsapp.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cinematicketsreservationsapp.AppDestination

fun NavGraphBuilder.homeRoute(navHostController: NavHostController) {
    composable(AppDestination.HomeScreen.route) { HomeScreen(navHostController) }
}