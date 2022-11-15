package com.invoice.contratista.data.api.models.product

import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.local.entity.product.LocalTaxEntity

data class LocalTaxe(
    @SerializedName("rate") val rate: Double,
    @SerializedName("type") val type: String,
    @SerializedName("withholding") val withholding: Boolean
) {
    companion object {
        fun LocalTaxe.toLocalTaxEntity(idProduct: String) = LocalTaxEntity(
            1,
            rate,
            type,
            withholding,
            idProduct
        )
    }
}