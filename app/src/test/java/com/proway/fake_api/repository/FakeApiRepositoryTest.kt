package com.proway.fake_api.repository

import com.google.common.truth.Truth
import com.proway.fake_api.model.Product
import com.proway.fake_api.service.ProductService
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

@RunWith(JUnit4::class)
class FakeApiRepositoryTest {

    @Mock
    private lateinit var responseResultApi: Response<List<Product>>
    @Mock
    lateinit var api: ProductService

    private lateinit var fakeApiRepository: FakeApiRepository


    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        fakeApiRepository = FakeApiRepository(api)
    }

    @Test
    fun `fetch products should return a success response`() = runBlocking {
        val expectedResult = listOf(
            Product(1, "tes", 4.0, "", " ", " "),
            Product(2, "tes", 4.0, "", " ", " ")
        )
        Mockito.`when`(responseResultApi.isSuccessful).thenReturn(true)
//        Mockito.`when`(responseResultApi.body()).thenReturn(
//            expectedResult
//        )
        Mockito.`when`(api.getProducts())
            .thenReturn(responseResultApi)

        val listResult = fakeApiRepository.fetchProducts()
        Truth.assertThat(listResult).containsExactlyElementsIn(emptyArray())
    }
}