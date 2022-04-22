package com.invoice.contratista.ui.fragment.event

import java.util.*

data class DayItem(
    val day: String,
    val date: Date,
    val currentDay: Boolean,
    val currentMonth: Int,
)