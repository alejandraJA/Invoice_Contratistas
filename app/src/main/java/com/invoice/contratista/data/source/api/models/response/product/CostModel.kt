package com.invoice.contratista.data.source.api.models.response.product

import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.source.api.models.response.DateModel

data class CostModel(
    @SerializedName("date") val date: DateModel,
    @SerializedName("id") val id: String,
    @SerializedName("quantity") val quantity: Int,
    @SerializedName("unitCost") val unitCost: Double,
    @SerializedName("vendor") val vendorModel: VendorModel
)