package com.invoice.contratista.data.source.api.models.response

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("id") val id: Int,
    @SerializedName("registration") val registration: DateModel,
    @SerializedName("username") val username: String
)