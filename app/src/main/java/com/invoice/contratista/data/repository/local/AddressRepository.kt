package com.invoice.contratista.data.repository.local

import com.invoice.contratista.data.source.local.dao.AddressDao
import com.invoice.contratista.data.source.local.entity.AddressEntity
import javax.inject.Inject

class AddressRepository @Inject constructor(private val addressDao: AddressDao) {
    fun deleteAddress() = addressDao.deleteAddress()
    fun setAddress(addressEntity: AddressEntity) = addressDao.setAddress(addressEntity)
}
