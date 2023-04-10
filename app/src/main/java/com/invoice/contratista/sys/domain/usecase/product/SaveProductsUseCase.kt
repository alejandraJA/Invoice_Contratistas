package com.invoice.contratista.sys.domain.usecase.product

import android.content.Context
import com.invoice.contratista.R
import com.invoice.contratista.data.mapper.toEntity
import com.invoice.contratista.data.mapper.toProductEntity
import com.invoice.contratista.data.mapper.toTaxEntity
import com.invoice.contratista.data.repository.local.ProductRepository
import com.invoice.contratista.data.repository.local.TaxRepository
import com.invoice.contratista.data.source.local.entity.product.CostEntity
import com.invoice.contratista.data.source.local.entity.product.PriceEntity
import com.invoice.contratista.data.source.local.entity.product.TaxEntity
import com.invoice.contratista.data.source.local.entity.product.VendorEntity
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
                    val productInventory = productResponse.toEntity()
                    val product = productResponse.product.toEntity()
                    val listCost = mutableListOf<CostEntity>()
                    val productBase =
                        productResponse.product.productBaseModel.toProductEntity(idProduct = product.id)
                    val listPrices = mutableListOf<PriceEntity>()
                    val listTaxes = mutableListOf<TaxEntity>()
                    val listVendor = mutableListOf<VendorEntity>()

                    productResponse.product.taxEntities.forEach {
                        listTaxes.add(it.toTaxEntity(idProduct = product.id))
                    }
                    productResponse.product.priceEntities.forEach {
                        listPrices.add(it.toEntity(idProduct = product.id))
                    }
                    productResponse.cost.forEach {
                        listCost.add(it.toEntity(idProductInventory = productInventory.id))
                        listVendor.add(it.vendorModel.toEntity())
                    }
                    productRepository.set(productBase)
                    productResponse.product.taxEntities.forEach {
                        taxRepository.set(it.toTaxEntity(productResponse.id))
                    }
                }
            }
        }
    }
}