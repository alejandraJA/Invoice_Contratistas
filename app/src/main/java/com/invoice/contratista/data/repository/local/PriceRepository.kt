package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.product.PriceDao
import com.invoice.contratista.data.source.local.entity.product.PriceEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class PriceRepository @Inject constructor(
    private val dao: PriceDao,
    private val utilsManager: UtilsManager
) {
    fun addAll(listPrices: MutableList<PriceEntity>) = dao.addAll(listPrices)

}