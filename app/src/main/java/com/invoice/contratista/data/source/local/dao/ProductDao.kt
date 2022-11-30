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
        "SELECT " +
                "    pr.id, " +
                "    pr.description, " +
                "    pr.sku, " +
                "    pr.price, " +
                "    ((pr.price - p.discount) * pr.gain) AS gain, " +
                "    (((pr.price - p.discount) * pr.gain) * p.quantity) AS totalGain, " +
                "    p.quantity * pr.price AS amount, " +
                "    (pr.price * p.quantity)-p.discount AS subTotal, " +
                "    ((pr.price * p.quantity)-p.discount) + IFNULL(r.sumTax, 0) - IFNULL(r.restTax, 0) AS total, " +
                "    p.discount, " +
                "    p.quantity, " +
                "    p.number " +
                "FROM part AS p, product AS pr, ( " +
                "    SELECT SUM(CASE WHEN withholding == 0 THEN  tax ELSE 0 END) AS sumTax, SUM(CASE WHEN withholding == 1 THEN  tax ELSE 0 END) AS restTax FROM ( " +
                "        SELECT CASE WHEN t.factor != 'Cuota' THEN ((pr.price * p.quantity) - p.discount) * t.rate ELSE t.rate * p.quantity END AS tax, t.withholding " +
                "        FROM part AS p, product AS pr, tax AS t " +
                "        WHERE p.idProduct == pr.id AND p.id == :idPart AND t.idProduct == p.idProduct AND t.factor != 'Exento' " +
                "    ) " +
                ")AS r " +
                "WHERE p.idProduct == pr.id AND p.id == :idPart"
    )
    fun getProductWithPart(idPart: String): LiveData<ProductPart>

    @Query("DELETE FROM product")
    fun deleteProducts()
}