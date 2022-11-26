package com.invoice.contratista.data.source.api.models.product

import com.google.gson.annotations.SerializedName

data class LocalTax(
    @SerializedName("rate") val rate: Double,
    @SerializedName("type") val type: String,
    @SerializedName("withholding") val withholding: Boolean
)