package com.invoice.contratista.sys.domain.usecase.product

import android.content.Context
import com.invoice.contratista.R
import com.invoice.contratista.data.mapper.toAddressEntity
import com.invoice.contratista.data.mapper.toEntity
import com.invoice.contratista.data.mapper.toProductEntity
import com.invoice.contratista.data.mapper.toTaxEntity
import com.invoice.contratista.data.repository.local.AddressRepository
import com.invoice.contratista.data.repository.local.CostRepository
import com.invoice.contratista.data.repository.local.PriceRepository
import com.invoice.contratista.data.repository.local.ProductBaseRepository
import com.invoice.contratista.data.repository.local.ProductInventoryRepository
import com.invoice.contratista.data.repository.local.ProductRepository
import com.invoice.contratista.data.repository.local.TaxRepository
import com.invoice.contratista.data.repository.local.VendorRepository
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.product.CostEntity
import com.invoice.contratista.data.source.local.entity.product.PriceEntity
import com.invoice.contratista.data.source.local.entity.product.TaxEntity
import com.invoice.contratista.data.source.local.entity.product.VendorEntity
import com.invoice.contratista.utils.Constants
import com.invoice.contratista.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SaveProductsUseCase @Inject constructor(
    private val productInventoryRepository: ProductInventoryRepository,
    private val productRepository: ProductRepository,
    private val productBaseRepository: ProductBaseRepository,
    private val priceRepository: PriceRepository,
    private val costRepository: CostRepository,
    private val vendorRepository: VendorRepository,
    private val taxRepository: TaxRepository,
    private val addressRepository: AddressRepository,
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
                productBaseRepository.delete()
                taxRepository.delete()
                productResponses.forEach { productResponse ->
                    val productInventory = productResponse.toEntity()
                    val product = productResponse.product.toEntity()
                    val productBase =
                        productResponse.product.productBaseModel.toProductEntity(idProduct = product.id)
                    val listTaxes = mutableListOf<TaxEntity>()
                    val listPrices = mutableListOf<PriceEntity>()
                    val listCost = mutableListOf<CostEntity>()
                    val listVendor = mutableListOf<VendorEntity>()
                    val listAddress = mutableListOf<AddressEntity>()

                    // TODO: Tax
                    productResponse.product.taxEntities.forEach {
                        listTaxes.add(it.toTaxEntity(idProduct = product.id))
                    }
                    // TODO: Price
                    productResponse.product.priceEntities.forEach {
                        listPrices.add(it.toEntity(idProduct = product.id))
                    }
                    // TODO: Cost and Vendor
                    productResponse.cost.forEach {
                        listCost.add(it.toEntity(idProductInventory = productInventory.id))
                        listVendor.add(it.vendorModel.toEntity())
                        listAddress.add(it.vendorModel.address.toAddressEntity(it.vendorModel.id))
                    }

                    productInventoryRepository.add(productInventory)
                    productRepository.add(product)
                    productBaseRepository.add(productBase)
                    taxRepository.addAll(listTaxes)
                    priceRepository.addAll(listPrices)
                    costRepository.addAll(listCost)
                    vendorRepository.addAll(listVendor)
                    addressRepository.addAll(listAddress)
                }
            }
        }
    }
}