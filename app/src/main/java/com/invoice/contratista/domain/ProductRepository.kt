package com.invoice.contratista.domain

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.local.dao.ProductDao
import com.invoice.contratista.data.local.dao.TaxDao
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.relations.Product
import com.invoice.contratista.data.shared_preferences.UtilsManager
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productDao: ProductDao,
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
            productDao.setProduct(product.product)
            if (product.taxes != null)
                product.taxes.forEach {
                    taxDao.setTax(it)
                }
        }
    }

    /**
     * Metodo para obtener un producto de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Product]
     */
    fun getProduct() = productDao.getProduct(utilsManager.getIdProduct())
    fun getProductPart() =
        productDao.getProduct(utilsManager.getIdProduct(), utilsManager.getIdPart())

    fun getProduct(idProduct: String) = productDao.getProduct(idProduct)

    /**
     * Metodo para obtener todos los productos de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductEntity]
     */
    fun getProducts() = productDao.getProducts()
    fun getProductsForSelector() = productDao.getProductsForSelector()

}