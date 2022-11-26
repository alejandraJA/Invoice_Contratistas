package com.invoice.contratista.data.source.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.source.local.entity.product.ProductEntity
import com.invoice.contratista.ui.fragment.part.data.ProductItem
import com.invoice.contratista.ui.fragment.part.data.ProductPart

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

    @Query("SELECT * FROM product WHERE id == :idProduct LIMIT 1")
    fun getProduct(idProduct: String): LiveData<ProductEntity>

    @Query("SELECT id, description FROM product ORDER BY description ASC")
    fun getProductsForSelector(): LiveData<List<ProductItem>>

    @Query(
        "SELECT  " +
                "   pr.id,     " +
                "   pr.description,  " +
                "   pr.sku,  " +
                "   pr.price,     " +
                "   ((pr.price - p.discount) * pr.gain) AS gain,    " +
                "   (((pr.price - p.discount) * pr.gain) * p.quantity) AS totalGain,    " +
                "   p.quantity  * pr.price AS amount,    " +
                "   totals.subTotal, " +
                "   p.discount, " +
                "   totals.total, " +
                "   p.quantity,  " +
                "   p.number  " +
                "   FROM product AS pr, part AS p,  " +
                "   (SELECT " +
                "      SUM(tax) + subTotal AS total, " +
                "      subTotal " +
                "    FROM (SELECT " +
                "          ((pr.price * p.quantity) - p.discount) * t.rate AS tax, " +
                "          (pr.price * p.quantity)-p.discount AS subTotal " +
                "       FROM tax AS t, product AS pr, part AS p " +
                "       WHERE t.idProduct == :idProduct AND pr.id == :idProduct AND p.id == :idPart " +
                "    ) " +
                "   ) AS totals " +
                "WHERE pr.id == :idProduct AND p.id == :idPart"
    )
    fun getProduct(idProduct: String, idPart: String): LiveData<ProductPart>

    @Query("DELETE FROM product")
    fun deleteProducts()
}