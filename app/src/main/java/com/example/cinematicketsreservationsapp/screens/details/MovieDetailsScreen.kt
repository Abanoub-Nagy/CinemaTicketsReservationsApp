package com.example.cinematicketsreservationsapp.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.composable.BottomSheet
import com.example.cinematicketsreservationsapp.composable.ImageButton
import com.example.cinematicketsreservationsapp.composable.Toolbar
import com.example.cinematicketsreservationsapp.ui.theme.Orange80

@Composable
fun MovieDetailsScreen(
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    MovieDetailsContent(state = state) {

    }

}

@Composable
private fun MovieDetailsContent(
    state: DetailUiState,
    closeButton: () -> Unit
) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (header, bottomSheet) = createRefs()
        val topGuideLine = createGuidelineFromTop(0.40f)
        Header(
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
            }
        )
    }
}

@Composable
private fun Header(state: DetailUiState, modifier: Modifier = Modifier, closeButton: () -> Unit) {
    Box(modifier = Modifier.aspectRatio(4f / 5f)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = rememberAsyncImagePainter(model = state.image),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop
        )

        Toolbar() {
            closeButton
        }

        ImageButton(
            painter = R.drawable.play,
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center),
            backgroundColor = Orange80
        ) {

        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}