package com.invoice.contratista.data.api.models.product

import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.local.entity.product.TaxEntity

data class LocalTax(
    @SerializedName("rate") val rate: Double,
    @SerializedName("type") val type: String,
    @SerializedName("withholding") val withholding: Boolean
) {
    companion object {
        fun LocalTax.toLocalTaxEntity(idProduct: String) = TaxEntity(
            0,
            type,
            rate,
            "",
            withholding,
            idProduct,
            true
        )
    }
}