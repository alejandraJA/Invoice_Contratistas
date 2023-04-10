package com.invoice.contratista.data.source.local.dao.product

import androidx.lifecycle.LiveData
import androidx.room.*
import com.invoice.contratista.data.source.local.entity.product.ProductBaseEntity
import com.invoice.contratista.ui.fragment.part.data.ProductItem
import com.invoice.contratista.ui.fragment.part.data.ProductPart

@Dao
interface ProductBaseDao {

    /**
     * Metodo para insertar un producto.
     * @param productBaseEntity Objeto de tipo [ProductBaseEntity]
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(productBaseEntity: ProductBaseEntity)

    /**
     * Metodo para obtener todos los productos.
     * @return Objeto de tipo [LiveData] que contiene una lista de objetos de tipo [ProductBaseEntity]
     */
    @Query("SELECT * FROM product_base")
    fun findAll(): LiveData<List<ProductBaseEntity>>

    @Query("SELECT * FROM product_base WHERE id == :idProduct LIMIT 1")
    fun findByIdProduct(idProduct: String): LiveData<ProductBaseEntity>

    @Query("SELECT id, description FROM product_base ORDER BY description ASC")
    fun findAllForSelector(): LiveData<List<ProductItem>>

    @Query("SELECT ptr.id " +
            "     , pb.description " +
            "     , pb.sku " +
            "     , pri.unit_price                                                                                        AS price " +
            "     , (pri.unit_price - ptr.discount)                                                                       AS gain " +
            "     , ((pri.unit_price - ptr.discount) * ptr.quantity)                                                      AS totalGain " +
            "     , ptr.quantity * pri.unit_price                                                                         AS amount " +
            "     , (pri.unit_price * ptr.quantity) - ptr.discount                                                        AS subTotal " +
            "     , ((pri.unit_price * ptr.quantity) - ptr.discount) + IFNULL(taxes.sumTax, 0) - IFNULL(taxes.restTax, 0) AS total " +
            "     , ptr.discount " +
            "     , ptr.quantity " +
            "     , ptr.number " +
            "FROM part AS ptr " +
            "         JOIN reserved r on ptr.reserved_id = r.id " +
            "         JOIN price pri ON R.price_id = pri.id " +
            "         JOIN product pr on r.product_id = pr.id " +
            "         JOIN product_base pb on pb.id = pr.product_base_id " +
            "         JOIN (SELECT SUM(CASE WHEN tw.withholding = 0 THEN tw.tax ELSE 0 END) AS sumTax " +
            "                    , SUM(CASE WHEN tw.withholding = 1 THEN tw.tax ELSE 0 END) AS restTax " +
            "                    , tw.product_id " +
            "               FROM (SELECT CASE " +
            "                                WHEN t.factor != 'Cuota' " +
            "                                    THEN ((pri.unit_price * ptr.quantity) - ptr.discount) * t.rate " +
            "                                ELSE t.rate * ptr.quantity END AS tax " +
            "                          , t.withholding " +
            "                          , t.product_id " +
            "                     FROM part ptr " +
            "                              JOIN tax AS t ON t.factor != 'Exento' " +
            "                              JOIN reserved AS r ON r.id = ptr.reserved_id AND r.product_id = t.product_id " +
            "                              JOIN price pri ON pri.id = r.price_id) as tw) AS taxes " +
            "              ON taxes.product_id = pr.id " +
            "WHERE ptr.id = :idPart ")
    fun findByIdPart(idPart: String): LiveData<ProductPart>

    @Query("DELETE FROM product_base")
    fun deleteAll()
}