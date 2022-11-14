package com.invoice.contratista.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.invoice.contratista.data.db.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Singleton
    @Provides
    fun providerDataDatabase(@ApplicationContext app: Context) = Room.databaseBuilder(
        app,
        RoomDatabase::class.java,
        "facturaFacil"
    ).build()

    @Singleton
    @Provides
    fun provideAddressDao(db: RoomDatabase) = db.getAddressDao()

    @Singleton
    @Provides
    fun provideBudgetDao(db: RoomDatabase) = db.getBudgetDao()

    @Singleton
    @Provides
    fun provideCustomerDao(db: RoomDatabase) = db.getCustomerDao()

    @Singleton
    @Provides
    fun provideDateDao(db: RoomDatabase) = db.getDateDao()

    @Singleton
    @Provides
    fun provideEventDao(db: RoomDatabase) = db.getEventDao()

    @Singleton
    @Provides
    fun provideNoteDao(db: RoomDatabase) = db.getNoteDao()

    @Singleton
    @Provides
    fun providePartDao(db: RoomDatabase) = db.getPartDao()

    @Singleton
    @Provides
    fun provideProductDao(db: RoomDatabase) = db.getProductDao()

    @Singleton
    @Provides
    fun provideScheduleDao(db: RoomDatabase) = db.getScheduleDao()

    @Singleton
    @Provides
    fun provideTaxDao(db: RoomDatabase) = db.getTaxDao()

    @Provides
    fun provideSharedPreferenceUtils(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("utils", Context.MODE_PRIVATE)

}