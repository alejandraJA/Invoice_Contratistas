package com.invoice.contratista.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.invoice.contratista.data.source.local.dao.*
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.entity.DateEntity
import com.invoice.contratista.data.source.local.entity.EventEntity
import com.invoice.contratista.data.source.local.entity.event.BudgetEntity
import com.invoice.contratista.data.source.local.entity.event.NoteEntity
import com.invoice.contratista.data.source.local.entity.event.PartEntity
import com.invoice.contratista.data.source.local.entity.event.ScheduleEntity
import com.invoice.contratista.data.source.local.entity.product.*

@Database(
    entities = [
        AddressEntity::class,
        CustomerEntity::class,
        BudgetEntity::class,
        NoteEntity::class,
        PartEntity::class,
        ScheduleEntity::class,
        EventEntity::class,
        ProductEntity::class,
        TaxEntity::class,
        DateEntity::class,
        CategoryEntity::class,
        InventoryEntity::class,
        ReservedEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun getAddressDao(): AddressDao
    abstract fun getBudgetDao(): BudgetDao
    abstract fun getCustomerDao(): CustomerDao
    abstract fun getDateDao(): DateDao
    abstract fun getEventDao(): EventDao
    abstract fun getNoteDao(): NoteDao
    abstract fun getPartDao(): PartDao
    abstract fun getProductDao(): ProductDao
    abstract fun getScheduleDao(): ScheduleDao
    abstract fun getTaxDao(): TaxDao
}