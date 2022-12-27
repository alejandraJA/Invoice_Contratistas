package com.invoice.contratista.ui.fragment.product.adapter

data class ProductItem(
    val id: String,
    val status: String,
    val name: String,
    val sku: String,
    val available: Int,
    val price: Double,
)