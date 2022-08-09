package com.invoice.contratista.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import com.invoice.contratista.data.local.dao.Dao
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.data.local.entity.event.PartEntity
import com.invoice.contratista.data.local.entity.product.LocalTaxEntity
import androidx.room.RoomDatabase
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.data.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.local.entity.product.ProductEntity
import com.invoice.contratista.data.local.entity.product.TaxEntity

@Database(
    entities = [
        AddressEntity::class,
        CustomerEntity::class,
        BudgetEntity::class,
        NoteEntity::class,
        PartEntity::class,
        ScheduleEntity::class,
        EventEntity::class,
        LocalTaxEntity::class,
        ProductEntity::class,
        TaxEntity::class,
    ],
    version = 2,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2)
    ]
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun getDataDao(): Dao
}