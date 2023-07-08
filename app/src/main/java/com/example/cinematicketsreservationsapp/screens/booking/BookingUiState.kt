package com.example.cinematicketsreservationsapp.screens.booking

data class BookingUiState(
    val seats: MutableList<ItemSeatData> = mutableListOf(),
    val selectedSeatsId: MutableList<Int> = mutableListOf(),
    var selectedSeatsCount: Int = 0,
    val selectedDate: Int = 0,
    val selectedTime: String = ""
)

data class ItemSeatData(
    val leftSeatData: SeatData,
    val rightSeatData: SeatData
)

data class SeatData(
    val id: Int,
    val isAvailable: Boolean,
    var isSelected: Boolean
)