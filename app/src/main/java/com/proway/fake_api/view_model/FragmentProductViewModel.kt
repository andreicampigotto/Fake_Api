package com.proway.fake_api.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.proway.fake_api.model.Product
import com.proway.fake_api.repository.FakeApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentProductViewModel @Inject constructor(private val repository: FakeApiRepository) :
    ViewModel() {

    private val _product = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _product

    fun fetchProducts() {
        viewModelScope.launch {
            val returnedProducts = repository.fetchProducts()
            returnedProducts?.let {
                _product.value = it
            }
        }
    }
}