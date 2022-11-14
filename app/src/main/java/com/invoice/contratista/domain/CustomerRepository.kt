package com.invoice.contratista.domain

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.dao.AddressDao
import com.invoice.contratista.data.local.dao.CustomerDao
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.relations.Customer
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val customerDao: CustomerDao,
    private val addressDao: AddressDao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para guardar un Cliente en la base de datos local
     * @param customer Objeto de tipo [Customer]
     */
    fun createCustomer(customer: Customer) {
        if (customer.customer != null) customerDao.setCustomer(customer.customer)
        if (customer.address != null) addressDao.setAddress(customer.address)
    }

    /**
     * Metodo para obtener un Cliente especifico de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [Customer]
     */
    fun getCustomer() = customerDao.getCustomer(utilsManager.getIdCustomer())

    /**
     * Metodo para obtener un Cliente especifico de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [CustomerEntity]
     */
    fun getCustomerEntity() = customerDao.getCustomerEntity(utilsManager.getIdCustomer())

    /**
     * Metodo para obtener un Cliente especifico
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [CustomerEntity]
     */
    fun getCustomers() = customerDao.getCustomers()

}