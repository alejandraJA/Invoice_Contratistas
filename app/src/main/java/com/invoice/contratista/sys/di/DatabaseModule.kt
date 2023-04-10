package com.invoice.contratista.sys.di

import android.content.Context
import androidx.room.Room
import com.invoice.contratista.data.source.local.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun providerDataDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        RoomDatabase::class.java,
        "facturaFacil"
    ).build()

    @Singleton
    @Provides
    fun provideBudgetEntity(db: RoomDatabase) = db.getBudgetDao()
    @Singleton
    @Provides
    fun provideNoteEntity(db: RoomDatabase) = db.getNoteDao()
    @Singleton
    @Provides
    fun providePartEntity(db: RoomDatabase) = db.getPartDao()
    @Singleton
    @Provides
    fun provideReservedEntity(db: RoomDatabase) = db.getReservedDao()
    @Singleton
    @Provides
    fun provideScheduleEntity(db: RoomDatabase) = db.getScheduleDao()
    @Singleton
    @Provides
    fun provideCostEntity(db: RoomDatabase) = db.getCostDao()
    @Singleton
    @Provides
    fun providePriceEntity(db: RoomDatabase) = db.getPriceDao()
    @Singleton
    @Provides
    fun provideProductBaseEntity(db: RoomDatabase) = db.getProductBaseDao()
    @Singleton
    @Provides
    fun provideProductEntity(db: RoomDatabase) = db.getProductDao()
    @Singleton
    @Provides
    fun provideProductInventoryEntity(db: RoomDatabase) = db.getProductInventoryDao()
    @Singleton
    @Provides
    fun provideTaxEntity(db: RoomDatabase) = db.getTaxDao()
    @Singleton
    @Provides
    fun provideVendorEntity(db: RoomDatabase) = db.getVendorDao()
    @Singleton
    @Provides
    fun provideAddressEntity(db: RoomDatabase) = db.getAddressDao()
    @Singleton
    @Provides
    fun provideCustomerEntity(db: RoomDatabase) = db.getCustomerDao()
    @Singleton
    @Provides
    fun provideDateEntity(db: RoomDatabase) = db.getDateDao()
    @Singleton
    @Provides
    fun provideEventEntity(db: RoomDatabase) = db.getEventDao()

}