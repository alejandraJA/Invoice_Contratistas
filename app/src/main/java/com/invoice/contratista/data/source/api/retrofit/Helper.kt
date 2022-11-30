package com.invoice.contratista.data.source.api.retrofit

import com.invoice.contratista.data.source.api.models.DataResponse
import com.invoice.contratista.data.source.api.models.customer.CustomerResponse
import com.invoice.contratista.data.source.api.models.product.ProductResponse
import retrofit2.Response

interface Helper {

    suspend fun getProducts(): Response<DataResponse<ProductResponse>>

    suspend fun getCustomer(): Response<DataResponse<CustomerResponse>>

}