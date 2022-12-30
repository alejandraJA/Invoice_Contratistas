package com.invoice.contratista.domain.repository

import com.invoice.contratista.data.source.api.models.response.DataResponse
import com.invoice.contratista.data.source.api.models.response.product.ProductResponse
import retrofit2.Response

interface ProductRepository {
    suspend fun getProducts(token: String): Response<DataResponse<ProductResponse>>
}