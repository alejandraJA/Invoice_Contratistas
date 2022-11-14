package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.relations.Customer

@Dao
interface CustomerDao {

    /**
     * Metodo para insertar un objeto que contiene la información del cliente.
     * @param customerEntity Objeto de tipo [CustomerEntity]
     * @see CustomerEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setCustomer(customerEntity: CustomerEntity)

    /**
     * Metodo para obtener a todos los clientes
     * @return Objeto de tipo [LiveData] que, a su vez, contiene uno de tipo [CustomerEntity].
     */
    @Query("SELECT * FROM customer")
    fun getCustomers(): LiveData<List<CustomerEntity>>

    /**
     * Metodo para obtener a un cliente en especifico.
     * @param idCustomer id del cliente
     * @return Retorna un objeto de tipo [LiveData] que, a su vez, contiene uno de tipo [Customer]
     * que contiene todos los objetos relacionados al **Cliente**.
     */
    @Transaction
    @Query("SELECT * FROM customer WHERE id == :idCustomer LIMIT 1")
    fun getCustomer(idCustomer: String): LiveData<Customer>

    /**
     * Metodo para obtener a un cliente en especifico.
     * @param idCustomer id del cliente
     * @return Retorna un objeto de tipo [LiveData] que, a su vez, contiene uno de tipo [CustomerEntity]
     * que contiene todos los objetos relacionados al **Cliente**.
     */
    @Transaction
    @Query("SELECT * FROM customer WHERE id == :idCustomer LIMIT 1")
    fun getCustomerEntity(idCustomer: String): LiveData<CustomerEntity>

}