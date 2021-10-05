package com.proway.fake_api.service

import com.proway.fake_api.model.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("/products")
    suspend fun getProducts(): Response<List<Product>>

    @GET("/products/{id}")
    suspend fun getProduct(@Path("id") productId: Int): Response<List<Product>>




}