package com.invoice.contratista.domain.usecase.product

import com.invoice.contratista.data.source.api.models.response.product.ProductResponse
import com.invoice.contratista.data.source.shared_preferences.UserManager
import com.invoice.contratista.domain.repository.ProductRepository
import com.invoice.contratista.utils.Json.toObject
import com.invoice.contratista.utils.Resource
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val userManager: UserManager
) {
    suspend operator fun invoke(): Resource<List<ProductResponse>> {
        val productsResponse =
            productRepository.getProducts(userManager.getToken(userManager.getUsername()))
        return if (productsResponse.code() != 200) {
            val productError = productsResponse.errorBody()!!.toObject()
            Resource.error(productError.message)
        } else {
            val product = productsResponse.body()!!
            if (product.totalResults == 0) Resource.success(emptyList())
            else Resource.success(product.data)
        }
    }
}