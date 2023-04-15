package com.invoice.contratista.data.repository.local

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.source.local.dao.product.ProductBaseDao
import com.invoice.contratista.data.source.local.dao.product.TaxDao
import com.invoice.contratista.data.source.local.entity.product.ProductBaseEntity
import com.invoice.contratista.data.source.local.relations.Product
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
import javax.inject.Inject

class ProductBaseRepository @Inject constructor(
    private val productBaseDao: ProductBaseDao,
    private val taxDao: TaxDao,
    private val utilsManager: UtilsManager
) {

    /**
     * Metodo para guardar un producto en la base de datos local
     * @param product Objeto de tipo [Product]
     *
     */
    fun createProduct(product: Product) {
        if (product.product != null) {
            productBaseDao.add(product.product)
            if (product.taxes != null)
                product.taxes.forEach {
                    taxDao.add(it)
                }
        }
    }

    /**
     * Metodo para obtener un producto de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Product]
     */
    fun getProduct() = productBaseDao.findByIdProduct(utilsManager.getIdProduct())
    fun getProductPart() =
        productBaseDao.findByIdPart(utilsManager.getIdPart())

    fun getProduct(idProduct: String) = productBaseDao.findByIdProduct(idProduct)

    /**
     * Metodo para obtener todos los productos de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductBaseEntity]
     */
    fun getProducts() = productBaseDao.findAll()
    fun getProductsForSelector() = productBaseDao.findAllForSelector()
    fun delete() = productBaseDao.deleteAll()
    fun add(productBaseEntity: ProductBaseEntity) = productBaseDao.add(productBaseEntity)

}