package com.invoice.contratista.ui.fragment.part.adapter

import com.invoice.contratista.data.local.entity.product.LocalTaxEntity
import com.invoice.contratista.data.local.entity.product.TaxEntity

data class TaxItem(
    val rate: Double,
    val type: String,
    var subtotal: Double
) {
    companion object {
        fun TaxEntity.toTaxItem(subtotal: Double) = TaxItem(this.rate, this.type!!, subtotal)
        fun LocalTaxEntity.toTaxItem(subtotal: Double) = TaxItem(this.rate, this.type, subtotal)
    }
}
