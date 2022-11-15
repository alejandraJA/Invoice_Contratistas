package com.invoice.contratista.data.api.retrofit

import com.invoice.contratista.data.api.models.DataResponse
import com.invoice.contratista.data.api.models.customer.CustomerResponse
import com.invoice.contratista.data.api.models.product.ProductResponse
import retrofit2.Response

interface Helper {

    suspend fun getProducts(): Response<DataResponse<ProductResponse>>

    suspend fun getCustomer(): Response<DataResponse<CustomerResponse>>

}