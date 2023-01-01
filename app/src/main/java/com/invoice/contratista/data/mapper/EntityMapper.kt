package com.invoice.contratista.data.mapper

import com.invoice.contratista.data.source.api.models.response.customer.Address
import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.data.source.api.models.response.product.LocalTax
import com.invoice.contratista.data.source.api.models.response.product.ProductResponse
import com.invoice.contratista.data.source.api.models.response.product.Tax
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.entity.product.ProductEntity
import com.invoice.contratista.data.source.local.entity.product.TaxEntity
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
)

fun TaxEntity.toTaxItem(subtotal: Double) =
    TaxItem(this.rate, this.type!!, subtotal, localTax, factor ?: "", withholding)

fun Tax.toTaxEntity(idProduct: String) =
    TaxEntity(0, type, rate, factor, withholding, idProduct, false)

fun LocalTax.toLocalTaxEntity(idProduct: String) = TaxEntity(
    0,
    type,
    rate,
    "",
    withholding,
    idProduct,
    true
)