package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.product.ProductInventoryDao
import com.invoice.contratista.data.source.local.entity.product.ProductInventoryEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class ProductInventoryRepository @Inject constructor(
    private val dao: ProductInventoryDao,
    private val utilsManager: UtilsManager
) {
    fun add(productInventory: ProductInventoryEntity) = dao.add(productInventory)
}