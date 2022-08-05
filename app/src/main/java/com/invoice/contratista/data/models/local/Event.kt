package com.invoice.contratista.data.models.local

import com.invoice.contratista.utils.Constants
import java.time.LocalDate

data class Event(
    val id: String,
    val idCustomer: String,
    val priority: Constants.Priority,
    val step: Constants.Steps,
    val steps: ArrayList<Constants.Steps>,
    val dates: ArrayList<Date>,
    val creationDate: LocalDate
)
