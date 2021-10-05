package com.proway.fake_api.view

import android.os.Bundle
import android.telecom.Call
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.google.android.gms.common.api.Response
import com.proway.fake_api.R
import com.proway.fake_api.databinding.FragmentProductDetailBinding
import com.proway.fake_api.model.Product
import com.proway.fake_api.view_model.FragmentProductDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentProductDetail : Fragment(R.layout.fragment_product_detail) {

    private lateinit var binding: FragmentProductDetailBinding
    lateinit var viewModel: FragmentProductDetailViewModel


//    val observerProduct = Observer<List<Product>>{
//
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductDetailBinding.bind(view)

        viewModel = ViewModelProvider(this).get(FragmentProductDetailViewModel::class.java)


        

    }


    fun bind(product: Product) {
        binding.priceTextView.text = "R$ ${product.price}"
        binding.titleTextView.text = product.title
        binding.subtitleTextView.text = product.description

        Glide.with(this)
            .load(product.image)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(binding.productImageView)
    }
}


