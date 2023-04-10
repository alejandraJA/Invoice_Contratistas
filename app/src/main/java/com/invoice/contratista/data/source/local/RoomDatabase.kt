package com.invoice.contratista.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.invoice.contratista.data.source.local.dao.AddressDao
import com.invoice.contratista.data.source.local.dao.CustomerDao
import com.invoice.contratista.data.source.local.dao.DateDao
import com.invoice.contratista.data.source.local.dao.EventDao
import com.invoice.contratista.data.source.local.dao.event.*
import com.invoice.contratista.data.source.local.dao.product.*
import com.invoice.contratista.data.source.local.entity.AddressEntity
import com.invoice.contratista.data.source.local.entity.CustomerEntity
import com.invoice.contratista.data.source.local.entity.DateEntity
import com.invoice.contratista.data.source.local.entity.EventEntity
import com.invoice.contratista.data.source.local.entity.event.*
import com.invoice.contratista.data.source.local.entity.product.*

@Database(
    entities = [
        BudgetEntity::class,
        NoteEntity::class,
        PartEntity::class,
        ReservedEntity::class,
        ScheduleEntity::class,

        CostEntity::class,
        PriceEntity::class,
        ProductBaseEntity::class,
        ProductEntity::class,
        ProductInventoryEntity::class,
        TaxEntity::class,
        VendorEntity::class,

        AddressEntity::class,
        CustomerEntity::class,
        DateEntity::class,
        EventEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
abstract class RoomDatabase : RoomDatabase() {
    abstract fun getBudgetDao(): BudgetDao
    abstract fun getNoteDao(): NoteDao
    abstract fun getPartDao(): PartDao
    abstract fun getReservedDao(): ReservedDao
    abstract fun getScheduleDao(): ScheduleDao
    abstract fun getCostDao(): CostDao
    abstract fun getPriceDao(): PriceDao
    abstract fun getProductBaseDao(): ProductBaseDao
    abstract fun getProductDao(): ProductDao
    abstract fun getProductInventoryDao(): ProductInventoryDao
    abstract fun getTaxDao(): TaxDao
    abstract fun getVendorDao(): VendorDao
    abstract fun getAddressDao(): AddressDao
    abstract fun getCustomerDao(): CustomerDao
    abstract fun getDateDao(): DateDao
    abstract fun getEventDao(): EventDao
}