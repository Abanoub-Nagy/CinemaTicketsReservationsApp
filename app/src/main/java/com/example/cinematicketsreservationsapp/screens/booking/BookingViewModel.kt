package com.example.cinematicketsreservationsapp.screens.booking

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(BookingUiState())
    val state = _state.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        val seatsData = mutableListOf(
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 1),
                SeatData(isAvailable = false, isSelected = false, id = 2),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 3),
                SeatData(isAvailable = true, isSelected = false, id = 4),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 5),
                SeatData(isAvailable = true, isSelected = false, id = 6),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 7),
                SeatData(isAvailable = true, isSelected = false, id = 8),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 9),
                SeatData(isAvailable = false, isSelected = false, id = 10),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 11),
                SeatData(isAvailable = true, isSelected = false, id = 12),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 13),
                SeatData(isAvailable = true, isSelected = false, id = 14),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 15),
                SeatData(isAvailable = true, isSelected = false, id = 16),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 17),
                SeatData(isAvailable = true, isSelected = false, id = 18),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 19),
                SeatData(isAvailable = true, isSelected = false, id = 20),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 21),
                SeatData(isAvailable = false, isSelected = false, id = 22),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 19),
                SeatData(isAvailable = true, isSelected = false, id = 20),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 25),
                SeatData(isAvailable = true, isSelected = false, id = 26),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 27),
                SeatData(isAvailable = false, isSelected = false, id = 28),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 29),
                SeatData(isAvailable = true, isSelected = false, id = 30),
            )

        )

        _state.update {
            BookingUiState(
                seats = seatsData
            )
        }
    }

    fun changeSelectedSeat(selected: Boolean, id: Int) {
        val list = _state.value.selectedSeatsId
        if (selected) list.add(id) else list.remove(id)
        _state.update { state ->
            state.copy(
                selectedSeatsId = list
            )
        }
    }

    fun changeSelectedDate(selected: Int) {
        _state.update { state ->
            state.copy(
                selectedDate = selected
            )
        }
    }

    fun changeSelectedTime(selected: String) {
        _state.update { state ->
            state.copy(
                selectedTime = selected
            )
        }
    }

    fun incrementSelectedCount() {
        _state.update { state ->
            state.copy(
                selectedSeatsCount = state.selectedSeatsCount++
            )
        }
    }
}