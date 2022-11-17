package com.invoice.contratista.data.api.models.product

import com.google.gson.annotations.SerializedName
import com.invoice.contratista.data.local.entity.product.ProductEntity

data class ProductResponse(
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("description") val description: String,
    @SerializedName("id") val id: String,
    @SerializedName("livemode") val liveMode: Boolean,
    @SerializedName("local_taxes") val localTaxes: List<LocalTax>,
    @SerializedName("organization") val organization: String,
    @SerializedName("price") val price: Double,
    @SerializedName("product_key") val productKey: String,
    @SerializedName("sku") val sku: String,
    @SerializedName("tax_included") val tax_included: Boolean,
    @SerializedName("taxability") val taxAbility: String,
    @SerializedName("taxes") val taxes: List<Tax>,
    @SerializedName("unit_key") val unit_key: String,
    @SerializedName("unit_name") val unit_name: String
) {
    companion object {
        fun ProductResponse.toProductEntity() = ProductEntity(
            id,
            description,
            productKey.toInt(),
            price,
            tax_included,
            taxAbility,
            unit_key,
            unit_name,
            sku,
            0.20
        )
    }
}