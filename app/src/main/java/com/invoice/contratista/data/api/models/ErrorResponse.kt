package com.invoice.contratista.data.api.models


import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message")
    val message: String
)