package com.invoice.contratista.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.invoice.contratista.data.local.entity.product.LocalTaxEntity
import com.invoice.contratista.data.local.entity.product.TaxEntity
import com.invoice.contratista.data.local.relations.Product

@Dao
interface TaxDao {

    /**
     * Metodo para insertar un impuetso local a un Producto.
     * @param localTaxEntity Objeto del impuesto local
     *
     * @see Product.localTaxes
     * @see LocalTaxEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setLocalTax(localTaxEntity: LocalTaxEntity)

    /**
     * Metodo para insertar un impuesto normal.
     * @param taxEntity Objeto de tipo [TaxEntity]
     * @see Product.taxes
     * @see TaxEntity
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setTax(taxEntity: TaxEntity)

}