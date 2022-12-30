package com.invoice.contratista.domain.usecase.product

import android.content.Context
import com.invoice.contratista.R
import com.invoice.contratista.data.mapper.toLocalTaxEntity
import com.invoice.contratista.data.mapper.toProductEntity
import com.invoice.contratista.data.mapper.toTaxEntity
import com.invoice.contratista.data.repository.local.ProductRepository
import com.invoice.contratista.data.repository.local.TaxRepository
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SaveProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    private val taxRepository: TaxRepository,
    private val getProductsUseCase: GetProductsUseCase,
    @ApplicationContext private val context: Context
) {
    suspend operator fun invoke(function: (Resource<Void>) -> Unit) {
        val productsUseCase = getProductsUseCase()
        return if (productsUseCase.status == Constants.Status.Failure) function.invoke(
            Resource.error(
                productsUseCase.exception!!
            )
        ) else {
            val productResponses = productsUseCase.data!!
            if (productResponses.isEmpty())
                function.invoke(Resource.error(context.getString(R.string.empty_list)))
            else {
                productRepository.delete()
                taxRepository.delete()
                productResponses.forEach { productResponse ->
                    productRepository.set(productResponse.toProductEntity())
                    productResponse.taxes.forEach {
                        taxRepository.set(it.toTaxEntity(productResponse.id))
                    }
                    productResponse.localTaxes.forEach {
                        taxRepository.set(it.toLocalTaxEntity(productResponse.id))
                    }
                }
            }
        }
    }
}