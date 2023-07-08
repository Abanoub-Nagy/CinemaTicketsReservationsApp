package com.example.cinematicketsreservationsapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cinematicketsreservationsapp.R
import com.example.cinematicketsreservationsapp.screens.booking.SeatData
import com.example.cinematicketsreservationsapp.ui.theme.AllSelected
import com.example.cinematicketsreservationsapp.ui.theme.AllTakenBorder
import com.example.cinematicketsreservationsapp.ui.theme.AvailableSeatColor
import com.example.cinematicketsreservationsapp.ui.theme.OneOrMoreAvailable
import com.example.cinematicketsreservationsapp.ui.theme.SelectedSeatColor
import com.example.cinematicketsreservationsapp.ui.theme.TakenSeatColor

@Composable
fun CinemaSeat(
    leftSeat: SeatData,
    rightSeatData: SeatData,
    onSeatAvailableClick: (isSelected: Boolean, id: Int) -> Unit
) {
    var leftSeat by remember { mutableStateOf(leftSeat) }
    var rightSeat by remember { mutableStateOf(rightSeatData) }
    Surface(
        modifier = Modifier
            .wrapContentSize()
            .roundedRectangleWithoutTheTop(
                color = roundedBorderColor(
                    leftSeat,
                    rightSeat
                )
            ),
        color = Color.Transparent
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            Image(
                modifier = Modifier.clickable(enabled = leftSeat.isAvailable, onClick = {
                    if (leftSeat.isAvailable) {
                        if (!leftSeat.isSelected) onSeatAvailableClick.invoke(
                            true,
                            leftSeat.id
                        ) else onSeatAvailableClick.invoke(false, leftSeat.id)
                    }
                    leftSeat = SeatData(
                        isAvailable = leftSeat.isAvailable,
                        isSelected = !leftSeat.isSelected,
                        id = leftSeat.id
                    )
                }),
                painter = painterResource(id = R.drawable.chair),
                contentDescription = "cinemaSeat",
                colorFilter = ColorFilter.tint(seatColor(leftSeat.isAvailable, leftSeat.isSelected))
            )
            SpacerHorizontal8()
            Image(
                modifier = Modifier.clickable(enabled = rightSeat.isAvailable, onClick = {
                    if (rightSeat.isAvailable) {
                        if (!rightSeat.isSelected) onSeatAvailableClick.invoke(
                            true,
                            rightSeat.id
                        ) else onSeatAvailableClick.invoke(false, rightSeat.id)
                    }
                    rightSeat = SeatData(
                        isAvailable = rightSeat.isAvailable,
                        isSelected = !rightSeat.isSelected,
                        id = rightSeat.id
                    )
                }),
                painter = painterResource(id = R.drawable.chair),
                contentDescription = "cinemaSeat",
                colorFilter = ColorFilter.tint(
                    seatColor(
                        rightSeat.isAvailable,
                        rightSeat.isSelected
                    )
                )
            )
        }
    }
}

@Preview()
@Composable
fun CinemaSeatPreview() {
    val leftSeatData = SeatData(isAvailable = true, isSelected = true, id = 0)
    val rightSeatData = SeatData(isAvailable = true, isSelected = true, id = 1)
    CinemaSeat(leftSeatData, rightSeatData) { isSelected, id ->

    }
}

fun seatColor(isAvailable: Boolean, IsSelected: Boolean): Color {
    return if (isAvailable)
        if (IsSelected) SelectedSeatColor else AvailableSeatColor
    else
        TakenSeatColor
}

fun roundedBorderColor(leftSeatData: SeatData, rightSeatData: SeatData): Color {
    return if (leftSeatData.isAvailable && rightSeatData.isAvailable) {
        if (leftSeatData.isSelected && rightSeatData.isSelected) {
            AllSelected
        } else {
            OneOrMoreAvailable
        }
    } else if (leftSeatData.isAvailable || rightSeatData.isAvailable) {
        OneOrMoreAvailable
    } else {
        AllTakenBorder
    }
}

fun Modifier.roundedRectangleWithoutTheTop(color: Color): Modifier {
    return this.drawBehind {
        val strokeWidthPx = 3.dp.toPx()
        val cornerRadiusPx = 12.dp.toPx()
        val width = size.width
        val height = size.height
        val topLeft = Offset(strokeWidthPx / 2, strokeWidthPx / 2)
        val topRight = Offset(width - strokeWidthPx / 2, strokeWidthPx / 2)
        val bottomLeft = Offset(strokeWidthPx / 2, height - strokeWidthPx / 2)
        val bottomRight = Offset(width - strokeWidthPx / 2, height - strokeWidthPx / 2)
        val arcSize = Size(cornerRadiusPx * 2, cornerRadiusPx * 2)

        // Draw the bottom left corner
        drawArc(
            color = color,
            startAngle = 90f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(strokeWidthPx / 2, height - cornerRadiusPx * 2 - strokeWidthPx / 2),
            size = arcSize,
            style = Stroke(width = strokeWidthPx)
        )
        // Draw the bottom right corner
        drawArc(
            color = color,
            startAngle = 0f,
            sweepAngle = 90f,
            useCenter = false,
            topLeft = Offset(
                width - cornerRadiusPx * 2 - strokeWidthPx / 2,
                height - cornerRadiusPx * 2 - strokeWidthPx / 2
            ),
            size = arcSize,
            style = Stroke(width = strokeWidthPx)
        )
        // Draw the left line
        drawLine(
            color = color,
            start = topLeft + Offset(0f, cornerRadiusPx / 2),
            end = bottomLeft - Offset(0f, cornerRadiusPx),
            strokeWidth = strokeWidthPx
        )
        // Draw the right line
        drawLine(
            color = color,
            start = topRight + Offset(0f, cornerRadiusPx / 2),
            end = bottomRight - Offset(0f, cornerRadiusPx),
            strokeWidth = strokeWidthPx
        )
        // Draw the bottom line
        drawLine(
            color = color,
            start = bottomLeft + Offset(cornerRadiusPx, 0f),
            end = bottomRight - Offset(cornerRadiusPx, 0f),
            strokeWidth = strokeWidthPx
        )
    }
}