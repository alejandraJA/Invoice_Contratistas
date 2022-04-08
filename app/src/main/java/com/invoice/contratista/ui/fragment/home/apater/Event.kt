package com.invoice.contratista.ui.fragment.home.apater

import com.invoice.contratista.config.GlobalVariables

data class Event(
    val id: String,
    val customer: String,
    val description: String,
    val step: String,
    val priority: GlobalVariables.Priority,
    val date: String,
    val hour: String
)