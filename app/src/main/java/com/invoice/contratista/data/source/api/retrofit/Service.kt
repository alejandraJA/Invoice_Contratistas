package com.invoice.contratista.data.source.api.retrofit

import com.invoice.contratista.data.source.api.models.DataResponse
import com.invoice.contratista.data.source.api.models.customer.CustomerResponse
import com.invoice.contratista.data.source.api.models.product.ProductResponse
import com.invoice.contratista.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface Service {

    @GET("products")
    suspend fun getProducts(
        @Header(Constants.AUTHORIZATION) token: String
    ): Response<DataResponse<ProductResponse>>

    @GET("customers")
    suspend fun getCustomer(
        @Header(Constants.AUTHORIZATION) token: String
    ): Response<DataResponse<CustomerResponse>>

}