package com.example.cinematicketsreservationsapp.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.cinematicketsreservationsapp.screens.MovieDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = MutableStateFlow(DetailUiState())
    val state = _state.asStateFlow()

    private val args = DetailsArgs(savedStateHandle)

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {
        _state.update { state ->
            state.copy(
                image =
//                state.image
                "${
                    MovieDataSource.newPlayingMovies().find {
                        it.id == args.imageId.toString().toInt()
                    }?.imageUrl
                }"
            )
        }
    }
}