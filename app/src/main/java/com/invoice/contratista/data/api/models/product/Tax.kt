package com.invoice.contratista.data.api.models.product

import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.local.entity.product.TaxEntity

data class Tax(
    @SerializedName("factor") val factor: String,
    @SerializedName("ieps_mode") val iepsMode: String,
    @SerializedName("rate") val rate: Double,
    @SerializedName("type") val type: String,
    @SerializedName("withholding") val withholding: Boolean
) {
    companion object {
        fun Tax.toTaxEntity(idProduct: String) =
            TaxEntity(0, type, rate, factor, withholding, idProduct, false)
    }
}