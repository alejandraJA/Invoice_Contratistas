package com.invoice.contratista.data.models.local

import com.invoice.contratista.utils.GlobalVariables
import java.time.LocalDate

data class Event(
    val id: String,
    val idCustomer: String,
    val priority: GlobalVariables.Priority,
    val step: GlobalVariables.Steps,
    val steps: ArrayList<GlobalVariables.Steps>,
    val dates: ArrayList<Date>,
    val creationDate: LocalDate
)
