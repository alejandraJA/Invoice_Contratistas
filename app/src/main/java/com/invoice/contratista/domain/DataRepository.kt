package com.invoice.contratista.domain

import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.relations.Customer
import com.invoice.contratista.data.local.relations.Product
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject
import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.relations.Budget
import com.invoice.contratista.data.local.relations.Part

class DataRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {

    // region Customer - Create, Get
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
     * Metodo para obtener un Cliente especifico
     * @return Objeto de tipo [LiveData] que contiene uno más de tipo [CustomerEntity]
     */
    fun getCustomers() = dao.getCustomers()
    // endregion

    // region Product - Create, Get
    /**
     * Metodo para guardar un producto en la base de datos local
     * @param product Objeto de tipo [Product]
     *
     */
    fun createProduct(product: Product) {
        if (product.product != null) {
            dao.setProduct(product.product)
            if (product.localTaxes != null)
                product.localTaxes.forEach {
                    dao.setLocalTax(it)
                }
            if (product.taxes != null)
                product.taxes.forEach {
                    dao.setTax(it)
                }
        }
    }

    /**
     * Metodo para obtener un producto de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Product]
     */
    fun getProduct() = dao.getProduct(utilsManager.getIdProduct())

    /**
     * Metodo para obtener todos los productos de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductEntity]
     */
    fun getProducts() = dao.getProducts()

    // endregion

    // region Part - Get

    /**
     * Metodo para obtener una partida en especifico de la base de datos Local
     * @return [LiveData] que contiene un objeto de tipo [Part]
     */
    fun getPart() = dao.getPart(utilsManager.getIdPart())

    /**
     * Metodo para obtener una lista de partidas relacionadas a una cotización de la base de datos local
     * @return [LiveData] de una lista de [Part]
     */
    fun getParts() = dao.getParts(utilsManager.getIdBudget())

    // endregion

    // region Budget - Create, Get

    /**
     * Metodo para crear cotizaciones en la base de datos local
     * @param budget Objeto de tipo [Budget]
     */
    fun createBudget(budget: Budget) {
        if (budget.budgetEntity != null) {
            dao.setBudget(budget.budgetEntity)
            if (budget.parts != null) budget.parts.forEach {
                if (it.partEntity != null) dao.setPart(it.partEntity)
            }
        }
    }

    /**
     * Metodo para obtener una cotización
     * @return Objeto de tipo [Budget]
     */
    fun getBudget() = dao.getBudget(utilsManager.getIdEvent())

    // endregion

}