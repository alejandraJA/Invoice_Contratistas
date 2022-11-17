package com.invoice.contratista.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.invoice.contratista.data.local.entity.product.TaxEntity
import com.invoice.contratista.data.local.relations.Product
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
    fun setTax(taxEntity: TaxEntity)

    @Query("DELETE FROM tax")
    fun deleteTaxes()

    @Query(
        "SELECT " +
                "   t.type, " +
                "   ((pr.price * p.quantity) - p.discount) * t.rate AS tax, " +
                "   t.rate, " +
                "   t.localTax " +
                "FROM tax AS t, product AS pr, part AS p " +
                "WHERE t.idProduct == :idProduct " +
                "   AND pr.id == :idProduct " +
                "   AND p.id == :idPart " +
                "ORDER BY t.localTax"
    )
    fun getParts(idProduct: String, idPart: String): LiveData<List<TaxItem>>

}