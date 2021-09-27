package com.proway.fake_api.adapters

import androidx.recyclerview.widget.DiffUtil
import com.proway.fake_api.model.Product

class ProductsDiffCallback: DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }
}