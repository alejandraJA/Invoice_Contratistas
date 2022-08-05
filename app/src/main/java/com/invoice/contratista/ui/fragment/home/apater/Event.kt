package com.invoice.contratista.ui.fragment.home.apater

import com.invoice.contratista.utils.Constants

data class Event(
    val id: String,
    val customer: String,
    val description: String,
    val step: String,
    val priority: Constants.Priority,
    val date: String,
    val hour: String
)