package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.product.VendorDao
import com.invoice.contratista.data.source.local.entity.product.VendorEntity
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class VendorRepository @Inject constructor(
    private val dao: VendorDao,
    private val utilsManager: UtilsManager
) {
    fun addAll(listVendor: MutableList<VendorEntity>) = dao.addAll(listVendor)
}