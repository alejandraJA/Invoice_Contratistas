package com.invoice.contratista.calendar

import java.util.*

data class DayItem(
    var day: String,
    val date: Date,
    var currentDay: Boolean,
    var visibility: Int,
    val currentMoth: Boolean,
)