package com.proway.fake_api.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proway.fake_api.R
import com.proway.fake_api.databinding.ItemProductBinding
import com.proway.fake_api.model.Product


class ProductAdapter(val onTap: (Product) -> Unit) : ListAdapter<Product, ProductViewHolder>(ProductsDiffCallback()) {

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position).let { product ->
            holder.bind(product)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false).apply {
            return ProductViewHolder(this, onTap)
        }
    }
}

class ProductViewHolder(itemView: View, val onTap: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
    private val binding: ItemProductBinding = ItemProductBinding.bind(itemView)

    fun bind(product: Product) {
        binding.priceTextView.text = "R$ ${product.price}"
        binding.titleTextView.text = product.title
        binding.subtitleTextView.text = product.description
        itemView.setOnClickListener { onTap(product) }

        Glide.with(itemView.context)
            .load(product.image)
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(binding.productImageView)
    }
}