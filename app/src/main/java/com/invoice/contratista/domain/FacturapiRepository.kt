package com.invoice.contratista.domain

import com.invoice.contratista.data.api.models.customer.Address.Companion.toAddressEntity
import com.invoice.contratista.data.api.models.customer.CustomerResponse.Companion.toCustomerEntity
import com.invoice.contratista.data.api.models.product.LocalTaxe.Companion.toLocalTaxEntity
import com.invoice.contratista.data.api.models.product.ProductResponse.Companion.toProductEntity
import com.invoice.contratista.data.api.models.product.Taxe.Companion.toTaxeEntity
import com.invoice.contratista.data.api.retrofit.Helper
import com.invoice.contratista.data.local.dao.AddressDao
import com.invoice.contratista.data.local.dao.CustomerDao
import com.invoice.contratista.data.local.dao.ProductDao
import com.invoice.contratista.data.local.dao.TaxDao
import com.invoice.contratista.utils.Json.toObject
import javax.inject.Inject

class FacturapiRepository @Inject constructor(
    private val helper: Helper,
    private val customerDao: CustomerDao,
    private val productDao: ProductDao,
    private val addressDao: AddressDao,
    private val taxDao: TaxDao
) {
    suspend fun loadData(function: (String?) -> Unit) {
        val customer = helper.getCustomer()
        val products = helper.getProducts()
        if (customer.code() != 200 || products.code() != 200) {
            if (customer.code() != 200) {
                val customerError = customer.errorBody()!!.toObject()
                function.invoke(customerError.message)
            }
            if (products.code() != 200) {
                val productsError = products.errorBody()!!.toObject()
                function.invoke(productsError.message)
            }
        }
        if (customer.code() == 200 && products.code() == 200) {
            val customerDataResponse = customer.body()!!
            val productDataResponse = products.body()!!
            if (customerDataResponse.totalResults != 0)
                customerDataResponse.data.forEach { customerResponse ->
                    customerDao.setCustomer(customerResponse.toCustomerEntity())
                    addressDao.setAddress(
                        customerResponse.address
                            .toAddressEntity(customerResponse.id)
                    )
                }

            if (productDataResponse.totalResults != 0)
                productDataResponse.data.forEach { productResponse ->
                    productDao.setProduct(productResponse.toProductEntity())
                    productResponse.localTaxes.forEach { localTaxe ->
                        taxDao.setLocalTax(localTaxe.toLocalTaxEntity(productResponse.id))
                    }
                    productResponse.taxes.forEach { tax ->
                        taxDao.setTax(tax.toTaxeEntity(productResponse.id))
                    }
                }
            function.invoke(null)
        }
    }
}