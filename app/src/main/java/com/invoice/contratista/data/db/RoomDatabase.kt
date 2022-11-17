package com.invoice.contratista.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.invoice.contratista.data.local.dao.AddressDao
import com.invoice.contratista.data.local.dao.BudgetDao
import com.invoice.contratista.data.local.dao.CustomerDao
import com.invoice.contratista.data.local.dao.DateDao
import com.invoice.contratista.data.local.dao.EventDao
import com.invoice.contratista.data.local.dao.NoteDao
import com.invoice.contratista.data.local.dao.PartDao
import com.invoice.contratista.data.local.dao.ProductDao
import com.invoice.contratista.data.local.dao.ScheduleDao
import com.invoice.contratista.data.local.dao.TaxDao
import com.invoice.contratista.data.local.entity.AddressEntity
import com.invoice.contratista.data.local.entity.CustomerEntity
import com.invoice.contratista.data.local.entity.DateEntity
import com.invoice.contratista.data.local.entity.EventEntity
import com.invoice.contratista.data.local.entity.event.BudgetEntity
import com.invoice.contratista.data.local.entity.event.NoteEntity
import com.invoice.contratista.data.local.entity.event.PartEntity
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
        ProductEntity::class,
        TaxEntity::class,
        DateEntity::class
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