package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.relations.Product
import com.invoice.contratista.ui.fragment.part.ProductsItem

@Dao
interface ProductDao {

    /**
     * Metodo para insertar un producto.
     * @param productEntity Objeto de tipo [ProductEntity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setProduct(productEntity: ProductEntity)

    /**
     * Metodo para obtener todos los productos.
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductEntity]
     */
    @Query("SELECT * FROM product")
    fun getProducts(): LiveData<List<ProductEntity>>

    /**
     * Metodo para obtener un producto por su id
     * @return Objeto de tipo [LiveData] que contiene un objeto de tipo [Product] que lleva todos
     * los obetos relacionados a un **Producto**.
     */
    @Transaction
    @Query("SELECT * FROM product WHERE id == :idProduct LIMIT 1")
    fun getProduct(idProduct: String): LiveData<Product>

    @Query("SELECT id, description FROM product ORDER BY description ASC")
    fun getProductsForSelector(): LiveData<List<ProductsItem>>
}