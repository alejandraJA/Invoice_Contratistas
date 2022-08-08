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
    fun provideDataDao(db: RoomDatabase) = db.getDataDao()

    @Provides
    fun provideSharedPreferenceUtils(@ApplicationContext context: Context): SharedPreferences =
        context.getSharedPreferences("utils", Context.MODE_PRIVATE)

}