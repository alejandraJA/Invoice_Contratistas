package com.invoice.contratista.ui.fragment.part.adapter

import com.invoice.contratista.data.local.entity.product.TaxEntity

data class TaxItem(
    val rate: Double,
    val type: String,
    var tax: Double,
    var localTax: Boolean
) {
    companion object {
        fun TaxEntity.toTaxItem(subtotal: Double) =
            TaxItem(this.rate, this.type!!, subtotal, localTax)
    }
}
