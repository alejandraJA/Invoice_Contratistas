package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.product.ProductDao
import com.invoice.contratista.data.source.local.entity.product.ProductEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val dao: ProductDao,
    private val utilsManager: UtilsManager,
) {
    fun add(product: ProductEntity) = dao.add(product)
}