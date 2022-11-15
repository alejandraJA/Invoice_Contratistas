package com.invoice.contratista.data.api.models.customer


import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.local.entity.AddressEntity
import java.util.*

data class Address(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("exterior")
    val exterior: String,
    @SerializedName("interior")
    val interior: String,
    @SerializedName("municipality")
    val municipality: String,
    @SerializedName("neighborhood")
    val neighborhood: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("zip")
    val zip: String
) {
    companion object {
        fun Address.toAddressEntity(id: String) = AddressEntity(
            UUID.randomUUID().toString(),
            street ?: "",
            exterior ?: "",
            interior ?: "",
            neighborhood ?: "",
            city ?: "",
            municipality,
            zip,
            state,
            country,
            id
        )
    }
}