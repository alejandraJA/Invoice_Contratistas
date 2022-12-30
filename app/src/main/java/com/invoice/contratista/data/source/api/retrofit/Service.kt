package com.invoice.contratista.data.source.api.retrofit

import com.invoice.contratista.data.source.api.models.request.SingRequest
import com.invoice.contratista.data.source.api.models.request.UpdateTokenRequest
import com.invoice.contratista.data.source.api.models.response.DataResponse
import com.invoice.contratista.data.source.api.models.response.TokenResponse
import com.invoice.contratista.data.source.api.models.response.customer.CustomerResponse
import com.invoice.contratista.data.source.api.models.response.product.ProductResponse
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.ResponseApi
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface Service {

    @GET("products")
    suspend fun getProducts(
        @Header(Constants.AUTHORIZATION) token: String
    ): Response<DataResponse<ProductResponse>>

    @GET("customers")
    suspend fun getCustomer(
        @Header(Constants.AUTHORIZATION) token: String
    ): Response<DataResponse<CustomerResponse>>

    @POST("sing/in")
    suspend fun singIn(@Body request: SingRequest): Response<ResponseApi<TokenResponse?>>

    @POST("sing/up")
    suspend fun singUp(@Body request: SingRequest): Response<ResponseApi<Any?>>

    @PUT("sing/updateToken")
    suspend fun updateToken(@Body request: UpdateTokenRequest): Response<ResponseApi<TokenResponse>>

}