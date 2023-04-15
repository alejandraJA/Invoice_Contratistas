package com.invoice.contratista.data.source.local.dao.product

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.source.local.entity.product.TaxEntity
import com.invoice.contratista.data.source.local.relations.Product
import com.invoice.contratista.ui.fragment.part.adapter.TaxItem

@Dao
interface TaxDao {

    /**
     * Metodo para insertar un impuesto normal.
     * @param taxEntity Objeto de tipo [TaxEntity]
     * @see Product.taxes
     * @see TaxEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(taxEntity: TaxEntity)

    @Query("DELETE FROM tax")
    fun deleteAll()

    @Query(
        "SELECT t.type\n" +
                "     , CASE\n" +
                "           WHEN t.factor != 'Cuota' THEN ((pri.unit_price * ptr.quantity) - ptr.discount) * t.rate\n" +
                "           ELSE t.rate * ptr.quantity END AS tax\n" +
                "     , t.rate\n" +
                "     , t.local_tax                        AS localTax\n" +
                "     , t.factor\n" +
                "     , t.withholding\n" +
                "FROM part ptr\n" +
                "         JOIN reserved r on r.id == ptr.reserved_id\n" +
                "         JOIN price pri on pri.id == r.price_id\n" +
                "         JOIN product p on p.id == r.product_id\n" +
                "         JOIN tax t on p.id == t.product_id\n" +
                "WHERE ptr.id = :idPart " +
                "ORDER BY t.local_tax"
    )
    fun findForPart(idPart: String): LiveData<List<TaxItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(listTaxes: MutableList<TaxEntity>)

}