package com.invoice.contratista.data.repository.web

import com.invoice.contratista.data.source.api.models.response.ResponseApi
import com.invoice.contratista.data.source.api.models.response.product.ProductInventoryModel
import com.invoice.contratista.data.source.api.retrofit.Service
import com.invoice.contratista.sys.domain.repository.ProductRepository
import retrofit2.Response
import javax.inject.Inject

class ProductRepositoryImp @Inject constructor(private val service: Service) : ProductRepository {
    override suspend fun getProducts(token: String): Response<ResponseApi<List<ProductInventoryModel>>> =
        service.getProducts(token)
}