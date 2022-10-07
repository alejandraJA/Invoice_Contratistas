package com.invoice.contratista.domain

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.relations.Product
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val dao: Dao,
    private val utilsManager: UtilsManager
) {

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

}