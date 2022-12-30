package com.invoice.contratista.sys.di

import com.invoice.contratista.BuildConfig
import com.invoice.contratista.data.repository.web.CustomerRepositoryImp
import com.invoice.contratista.data.repository.web.ProductRepositoryImp
import com.invoice.contratista.data.repository.web.SingRepositoryImp
import com.invoice.contratista.data.source.api.retrofit.Service
import com.invoice.contratista.sys.domain.repository.CustomerRepository
import com.invoice.contratista.sys.domain.repository.ProductRepository
import com.invoice.contratista.sys.domain.repository.SingRepository
import com.invoice.contratista.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()
    } else OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): Service = retrofit.create(Service::class.java)

    @Singleton
    @Provides
    fun provideCustomerRepository(customerRepositoryImp: CustomerRepositoryImp): CustomerRepository =
        customerRepositoryImp

    @Singleton
    @Provides
    fun provideProductRepository(customerRepositoryImp: ProductRepositoryImp): ProductRepository =
        customerRepositoryImp

    @Singleton
    @Provides
    fun provideSingRepository(singRepositoryImp: SingRepositoryImp): SingRepository =
        singRepositoryImp


}