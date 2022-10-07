package com.invoice.contratista.domain

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.relations.Customer
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para guardar un Cliente en la base de datos local
     * @param customer Objeto de tipo [Customer]
     */
    fun createCustomer(customer: Customer) {
        if (customer.customer != null) dao.setCustomer(customer.customer)
        if (customer.address != null) dao.setAddress(customer.address)
    }

    /**
     * Metodo para obtener un Cliente especifico de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [Customer]
     */
    fun getCustomer() = dao.getCustomer(utilsManager.getIdCustomer())

    /**
     * Metodo para obtener un Cliente especifico de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [CustomerEntity]
     */
    fun getCustomerEntity() = dao.getCustomerEntity(utilsManager.getIdCustomer())

    /**
     * Metodo para obtener un Cliente especifico
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [CustomerEntity]
     */
    fun getCustomers() = dao.getCustomers()

}