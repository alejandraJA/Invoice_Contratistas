package com.invoice.contratista.data.source.api.models.response.product

import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.source.api.models.response.DateModel

data class PriceModel(
    @SerializedName("date") val date: DateModel,
    @SerializedName("id") val id: String,
    @SerializedName("unitPrice") val unitPrice: Double
)