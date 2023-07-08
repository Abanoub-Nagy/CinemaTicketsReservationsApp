package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.screens.details.DetailUiState
import com.example.cinematicketsreservationsapp.ui.theme.Orange80

@Composable
fun HeaderTitleDetails(state: DetailUiState, modifier: Modifier = Modifier, closeButton: () -> Unit) {
    Box(modifier = Modifier.aspectRatio(4f / 5f)) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.poster),
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