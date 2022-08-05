package com.invoice.contratista.data.db

import androidx.room.Database
import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.BudgetEntity
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.entity.product.LocalTaxEntity
import androidx.room.RoomDatabase
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.entity.product.TaxEntity

@Database(
    entities = [
        BudgetEntity::class,
        AddressEntity::class,
        CustomerEntity::class,
        PartEntity::class,
        LocalTaxEntity::class,
        ProductEntity::class,
        TaxEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun getDataDao(): Dao
}