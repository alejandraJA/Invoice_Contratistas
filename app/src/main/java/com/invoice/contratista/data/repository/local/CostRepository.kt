package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.product.CostDao
import com.invoice.contratista.data.source.local.entity.product.CostEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class CostRepository @Inject constructor(
    private val dao: CostDao,
    private val utilsManager: UtilsManager
) {
    fun addAll(listCost: MutableList<CostEntity>) = dao.addAll(listCost)
}