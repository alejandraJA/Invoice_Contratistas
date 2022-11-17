package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.local.entity.product.ProductEntity
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
        "SELECT \n" +
                "   pr.id,    \n" +
                "   pr.description, \n" +
                "   pr.sku, \n" +
                "   pr.price,    \n" +
                "   ((pr.price - p.discount) * pr.gain) AS gain,   \n" +
                "   (((pr.price - p.discount) * pr.gain) * p.quantity) AS totalGain,   \n" +
                "   p.quantity  * pr.price AS amount,   \n" +
                "   totals.subTotal,\n" +
                "   p.discount,\n" +
                "   totals.total,\n" +
                "   p.quantity, \n" +
                "   p.number \n" +
                "   FROM product AS pr, part AS p, \n" +
                "   (SELECT\n" +
                "      SUM(tax) + subTotal AS total,\n" +
                "      subTotal\n" +
                "    FROM (SELECT\n" +
                "          ((pr.price * p.quantity) - p.discount) * t.rate AS tax,\n" +
                "          (pr.price * p.quantity)-p.discount AS subTotal\n" +
                "       FROM tax AS t, product AS pr, part AS p\n" +
                "       WHERE t.idProduct == :idProduct AND pr.id == :idProduct AND p.id == :idPart\n" +
                "    )\n" +
                "   ) AS totals\n" +
                "WHERE pr.id == :idProduct AND p.id == :idPart"
    )
    fun getProduct(idProduct: String, idPart: String): LiveData<ProductPart>

    @Query("DELETE FROM product")
    fun deleteProducts()
}