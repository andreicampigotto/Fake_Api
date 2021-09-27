package com.proway.fake_api.repository

import com.proway.fake_api.model.Product
import com.proway.fake_api.service.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class FakeApiRepository @Inject constructor(private val service: ProductService) {

    suspend fun fetchProducts(): List<Product>?{
        return  withContext(Dispatchers.Default){
            val response = service.getProducts()
            val processedResponse = processData(response)
            processedResponse
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body() else null
    }
}