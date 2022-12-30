package com.invoice.contratista.data.repository.local

import androidx.lifecycle.LiveData
import com.invoice.contratista.data.source.local.dao.ProductDao
import com.invoice.contratista.data.source.local.dao.TaxDao
import com.invoice.contratista.data.source.local.entity.product.ProductEntity
import com.invoice.contratista.data.source.local.relations.Product
import com.invoice.contratista.data.source.shared_preferences.UtilsManager
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
        productDao.getProductWithPart(utilsManager.getIdPart())

    fun getProduct(idProduct: String) = productDao.getProduct(idProduct)

    /**
     * Metodo para obtener todos los productos de la base de datos local
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductEntity]
     */
    fun getProducts() = productDao.getProducts()
    fun getProductsForSelector() = productDao.getProductsForSelector()
    fun delete() = productDao.deleteProducts()
    fun set(productEntity: ProductEntity) = productDao.setProduct(productEntity)

}