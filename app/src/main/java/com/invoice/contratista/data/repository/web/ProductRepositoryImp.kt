package com.invoice.contratista.data.repository.web

import com.invoice.contratista.data.source.api.models.response.DataResponse
import com.invoice.contratista.data.source.api.models.response.product.ProductResponse
import com.invoice.contratista.data.source.api.retrofit.Service
import com.invoice.contratista.domain.repository.ProductRepository
import retrofit2.Response
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(private val service: Service) : ProductRepository {
    override suspend fun getProducts(token: String): Response<DataResponse<ProductResponse>> =
        service.getProducts(token)
}