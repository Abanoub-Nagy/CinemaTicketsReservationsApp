package com.example.cinematicketsreservationsapp.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.composable.BackgroundBlurImage
import com.example.cinematicketsreservationsapp.composable.MovieCategoriesChip
import com.example.cinematicketsreservationsapp.composable.MovieDetails
import com.example.cinematicketsreservationsapp.composable.MovieImageSlider
import com.example.cinematicketsreservationsapp.composable.SpacerHorizontal8
import com.example.cinematicketsreservationsapp.ui.theme.Orange80

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(initialPage = 1)
    HomeContent(state = state, pagerState = pagerState)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    pagerState: PagerState,
) {

    Box(modifier = Modifier.fillMaxSize()) {
        BackgroundBlurImage(state, pagerState)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                MovieCategoriesChip(
                    title = "Now Showing",
                    selected = true,
                    onClick = {},
                    textColor = Color.White
                )
                SpacerHorizontal8()
                MovieCategoriesChip(
                    title = "Coming Soon",
                    selected = false,
                    onClick = {},
                    textColor = Color.White
                )
            }
            MovieImageSlider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 16.dp),
                state = state,
                pagerState = pagerState
            ) {

            }
            MovieDetails()
            BottomAppBar(containerColor = Color.Transparent) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.video_play),
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(Orange80)
                            .padding(10.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.search_normal),
                        tint = Color.Black,
                        contentDescription = "search"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ticket),
                        tint = Color.Black,
                        contentDescription = "ticket"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = "person",
                        tint = Color.Black
                    )
                }
            }
        }

    }
}