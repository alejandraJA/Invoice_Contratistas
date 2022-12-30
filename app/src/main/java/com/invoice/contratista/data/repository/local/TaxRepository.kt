package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.TaxDao
import com.invoice.contratista.data.source.local.entity.product.TaxEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class TaxRepository @Inject constructor(
    private val taxDao: TaxDao,
    private val utilsManager: UtilsManager
) {
    fun getParts() = taxDao.getParts(
        utilsManager.getIdProduct(),
        utilsManager.getIdPart()
    )

    fun delete() = taxDao.deleteTaxes()
    fun set(taxEntity: TaxEntity) = taxDao.setTax(taxEntity)
}