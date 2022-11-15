package com.invoice.contratista.data.api.models.customer


import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.local.entity.CustomerEntity

data class CustomerResponse(
    @SerializedName("address")
    val address: Address,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("legal_name")
    val legalName: String,
    @SerializedName("livemode")
    val liveMode: Boolean,
    @SerializedName("organization")
    val organization: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("tax_id")
    val taxId: String,
    @SerializedName("tax_system")
    val taxSystem: String
) {
    companion object {
        fun CustomerResponse.toCustomerEntity() =
            CustomerEntity(id, legalName, taxId, taxSystem, email, phone)
    }
}