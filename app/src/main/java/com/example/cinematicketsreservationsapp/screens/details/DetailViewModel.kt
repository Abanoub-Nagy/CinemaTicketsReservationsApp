package com.example.cinematicketsreservationsapp.screens.details

import androidx.lifecycle.ViewModel
import com.example.cinematicketsreservationsapp.screens.MovieDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(DetailUiState())
    val state = _state.asStateFlow()

    init {
        getMovieDetails()
        getActors()
    }

    private fun getMovieDetails() {
        _state.update {
            it.copy(
                image = "${
                    MovieDataSource.newPlayingMovies()
                }"
            )
        }
    }

    private fun getActors() {
        val actors = listOf(
            "https://pyxis.nymag.com/v1/imgs/5e3/c1a/b5c147858f5022732164fcbd645b1e38a3-jude-law.rsquare.w330.jpg",
            "https://m.media-amazon.com/images/M/MV5BMTU0MjEyNzQyM15BMl5BanBnXkFtZTcwMTc4ODUxOQ@@._V1_.jpg",
            "https://nationaltoday.com/wp-content/uploads/2022/10/456840842-min-1200x834.jpg.webp",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFJwvrWQtYoX_KqQUXZRs6FNRSaNCqb2-BFjtVxXkfFa1jUpF2z7YJqrj7orOewetYRJA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYt6I-Pi-But4S9lFulWLRtd42wQhPp0038tQz4g8AbLdijE3qlfi-2---nG8eo1g_ftg&usqp=CAU",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Ezra_Miller_by_Gage_Skidmore_2.jpg/800px-Ezra_Miller_by_Gage_Skidmore_2.jpg",
            "https://static.wikia.nocookie.net/the-royals/images/e/eb/PoppyCorby-Tuech.jpg/revision/latest?cb=20150324221521",
            "https://pyxis.nymag.com/v1/imgs/5e3/c1a/b5c147858f5022732164fcbd645b1e38a3-jude-law.rsquare.w330.jpg",
            "https://m.media-amazon.com/images/M/MV5BMTU0MjEyNzQyM15BMl5BanBnXkFtZTcwMTc4ODUxOQ@@._V1_.jpg",
            "https://nationaltoday.com/wp-content/uploads/2022/10/456840842-min-1200x834.jpg.webp",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFJwvrWQtYoX_KqQUXZRs6FNRSaNCqb2-BFjtVxXkfFa1jUpF2z7YJqrj7orOewetYRJA&usqp=CAU",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYt6I-Pi-But4S9lFulWLRtd42wQhPp0038tQz4g8AbLdijE3qlfi-2---nG8eo1g_ftg&usqp=CAU",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Ezra_Miller_by_Gage_Skidmore_2.jpg/800px-Ezra_Miller_by_Gage_Skidmore_2.jpg",
            "https://static.wikia.nocookie.net/the-royals/images/e/eb/PoppyCorby-Tuech.jpg/revision/latest?cb=20150324221521",

        )
        _state.update {
            it.copy(
                actors = actors
            )
        }
    }
}