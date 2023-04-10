package com.invoice.contratista.data.source.api.models.response

import com.google.gson.annotations.SerializedName

data class DateModel(
    @SerializedName("minutesOffset") val minutesOffset: Int,
    @SerializedName("offsetDateTime") val offsetDateTime: String,
    @SerializedName("timestamp") val timestamp: String
)