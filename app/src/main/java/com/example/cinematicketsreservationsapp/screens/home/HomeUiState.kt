package com.example.cinematicketsreservationsapp.screens.home

data class HomeUiState(
    val movies: List<MovieUiState> = emptyList()
)

data class MovieUiState(val id: Int, val imageUrl: String)