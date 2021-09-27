package com.proway.fake_api.di

import com.proway.fake_api.service.ProductService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun retrofitFake(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideProducts(retrofit: Retrofit): ProductService =
        retrofit.create(ProductService::class.java)

}