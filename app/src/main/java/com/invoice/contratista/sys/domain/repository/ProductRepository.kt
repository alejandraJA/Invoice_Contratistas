package com.invoice.contratista.sys.domain.repository

import com.invoice.contratista.data.source.api.models.response.ResponseApi
import com.invoice.contratista.data.source.api.models.response.product.ProductInventoryModel
import retrofit2.Response

interface ProductRepository {
    suspend fun getProducts(token: String): Response<ResponseApi<List<ProductInventoryModel>>>
}