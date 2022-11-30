package com.invoice.contratista.ui.fragment.budget

data class BudgetData(
    val number: Int,
    val date: String,
    val subtotal: Double,
    val total: Double,
    val totalGain: Double,
)