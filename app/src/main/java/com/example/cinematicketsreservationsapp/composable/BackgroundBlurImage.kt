package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.cinematicketsreservationsapp.screens.home.HomeUiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BackgroundBlurImage(state: HomeUiState, pagerState: PagerState) {
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .blur(40.dp),
        contentScale = ContentScale.Crop,
        painter = rememberAsyncImagePainter(model = state.movies[pagerState.currentPage].imageUrl),
        contentDescription = ""
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Transparent,
                        Color.White,
                        Color.White
                    )
                )
            )
    )
}

//@Preview(showSystemUi = true)
//@Composable
//fun HomeScreenPreview() {
//    BackgroundBlurImage()
//}