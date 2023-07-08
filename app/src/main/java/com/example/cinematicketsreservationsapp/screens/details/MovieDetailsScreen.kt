package com.example.cinematicketsreservationsapp.screens.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cinematicketsreservationsapp.composable.BottomSheet
import com.example.cinematicketsreservationsapp.composable.HeaderTitleDetails

@Composable
fun MovieDetailsScreen(
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()

    MovieDetailsContent(state = state) {}

}

@Composable
private fun MovieDetailsContent(
    state: DetailUiState,
    closeButton: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (header, bottomSheet) = createRefs()
        val topGuideLine = createGuidelineFromTop(0.40f)
        HeaderTitleDetails(
            state = state,
            modifier = Modifier.constrainAs(header) {
                top.linkTo(parent.top)
            }
        ) {
            closeButton()
        }
        BottomSheet(
            modifier = Modifier.constrainAs(bottomSheet) {
                top.linkTo(topGuideLine)

            },
            state.actors
        )
    }
}