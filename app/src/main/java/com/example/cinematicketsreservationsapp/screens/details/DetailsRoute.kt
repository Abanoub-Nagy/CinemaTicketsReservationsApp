package com.example.cinematicketsreservationsapp.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.cinematicketsreservationsapp.AppDestination

private val ROUTE = AppDestination.DetailsScreen.route

fun NavController.navigateToDetailsScreen(imageId: Int) {
    navigate("$ROUTE/$imageId")
}

fun NavGraphBuilder.detailsRoute(navHostController: NavHostController) {
    composable(
        "$ROUTE/{${DetailsArgs.ARG_IMAGE_ID}}",
        arguments = listOf(
            navArgument(DetailsArgs.ARG_IMAGE_ID) { NavType.IntType }
        )
    ) { MovieDetailsScreen(navHostController) }
}

class DetailsArgs(savedStateHandle: SavedStateHandle) {
    val imageId = checkNotNull(savedStateHandle[ARG_IMAGE_ID])

    companion object {
        const val ARG_IMAGE_ID = "imageId"
    }
}