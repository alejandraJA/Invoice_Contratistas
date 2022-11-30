package com.invoice.contratista.ui.fragment.part.adapter

data class TaxItem(
    val rate: Double,
    val type: String,
    var tax: Double,
    var localTax: Boolean,
    var factor: String,
    var withholding: Boolean,
)