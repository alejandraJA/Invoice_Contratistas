package com.invoice.contratista.data.repository.local

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.source.local.dao.AddressDao
import com.invoice.contratista.data.source.local.dao.CustomerDao
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.relations.Customer
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
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

    fun deleteCustomers() = customerDao.deleteCustomers()
    fun setCustomer(customerEntity: CustomerEntity) = customerDao.setCustomer(customerEntity)

}