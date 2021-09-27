package com.proway.fake_api.view

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proway.fake_api.R
import com.proway.fake_api.adapters.ProductAdapter
import com.proway.fake_api.databinding.FragmentProductBinding
import com.proway.fake_api.model.Product
import com.proway.fake_api.view_model.FragmentProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentProduct : Fragment(R.layout.fragment_product) {

    private lateinit var viewModel: FragmentProductViewModel
    private lateinit var binding: FragmentProductBinding
    private val productAdapter = ProductAdapter()

    private val observerProduct = Observer<List<Product>> {
        productAdapter.submitList(it)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentProductBinding.bind(view)

        viewModel = ViewModelProvider(this).get(FragmentProductViewModel::class.java)
        viewModel.products.observe(viewLifecycleOwner, observerProduct)

        setupRecyclerView()

    }

    private fun setupRecyclerView() = with(binding.productsRecyclerView) {
        adapter = productAdapter
        layoutManager = GridLayoutManager(requireContext(), 2)
        addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                hideSoftInput()
            }
        })
        viewModel.fetchProducts()
    }

    fun View.hideSoftInput() {
        val inputMethodManager =
            context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    companion object {
        fun newInstance() = FragmentProduct()
    }

}