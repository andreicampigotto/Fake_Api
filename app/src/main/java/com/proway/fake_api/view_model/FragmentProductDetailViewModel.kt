package com.proway.fake_api.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.proway.fake_api.R
import com.proway.fake_api.model.Product
import com.proway.fake_api.repository.FakeApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentProductDetailViewModel @Inject constructor(private val repository: FakeApiRepository) :
    ViewModel() {

    private val _product = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>> = _product

    fun fetchProductById(productId: Int) {
        viewModelScope.launch {
            val returnProductById = repository.fetchProductsbyId(productId)
            returnProductById?.let {
                _product.value = it
            }
        }
    }
}
