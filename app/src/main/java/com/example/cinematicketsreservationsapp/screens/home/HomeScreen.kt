package com.example.cinematicketsreservationsapp.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.cinematicketsreservationsapp.composable.BackgroundBlurImage
import com.example.cinematicketsreservationsapp.composable.MovieCategories
import com.example.cinematicketsreservationsapp.composable.MovieDetails
import com.example.cinematicketsreservationsapp.composable.MovieImageSlider
import com.example.cinematicketsreservationsapp.screens.details.navigateToDetailsScreen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)
    HomeContent(state = state, pagerState = pagerState) { id ->
        navController.navigateToDetailsScreen(id)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
    onItemClickListener: (id: Int) -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundBlurImage(state, pagerState)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MovieCategories()
            MovieImageSlider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 16.dp),
                state = state,
                pagerState = pagerState,
                onItemClickListener = { onItemClickListener(state.movies[pagerState.currentPage].id) }
            ) { page ->
                Image(
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = rememberAsyncImagePainter(model = state.movies[page].imageUrl),
                    contentDescription = ""
                )
            }
            MovieDetails()
        }
    }
}
