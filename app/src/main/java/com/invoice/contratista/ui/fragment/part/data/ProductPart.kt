package com.invoice.contratista.ui.fragment.part.data

data class ProductPart(
    val id: String,
    val description: String,
    val sku: String,
    val price: Double,
    val gain: Double,
    val totalGain: Double,
    val amount: Double,
    val subTotal: Double,
    val discount: Double,
    val total: Double,
    val quantity: Int,
    val number: Int,
)