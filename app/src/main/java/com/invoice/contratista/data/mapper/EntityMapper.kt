package com.invoice.contratista.data.mapper

import com.invoice.contratista.data.source.api.models.response.customer.Address
import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.data.source.api.models.response.product.*
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.entity.product.*
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem
import java.util.*

fun CustomerResponse.toCustomerEntity() =
    CustomerEntity(
        id,
        legalName,
        taxId ?: "",
        taxSystem,
        email ?: "",
        phone ?: ""
    )

fun Address.toAddressEntity(idCustomer: String) = AddressEntity(
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
    idCustomer
)

fun CostModel.toEntity(idProductInventory: String) =
    CostEntity(id, date.timestamp, quantity, unitCost, vendorModel.id, idProductInventory)

fun PriceModel.toEntity(idProduct: String) =
    PriceEntity(id, date.timestamp, unitPrice, idProduct = idProduct)

fun ProductBaseModel.toProductEntity(idProduct: String) = ProductBaseEntity(
    id,
    description,
    productKey.toInt(),
    taxIncluded,
    taxability,
    unitKey,
    unitName,
    sku,
    idProduct
)

fun ProductModel.toEntity() = ProductEntity(id, modifiedModel.timestamp, name, productBaseModel.id)

fun ProductInventoryModel.toEntity() = ProductInventoryEntity(
    id, modified = modified.timestamp, quantity, product.id
)

fun TaxModel.toTaxEntity(idProduct: String) =
    TaxEntity(id, type, rate, factor, withholding, localTax, idProduct)

fun VendorModel.toEntity() = VendorEntity(id, name, address.id ?: "")

fun TaxEntity.toTaxItem(subtotal: Double) =
    TaxItem(this.rate, this.type!!, subtotal, localTax, factor ?: "", withholding)