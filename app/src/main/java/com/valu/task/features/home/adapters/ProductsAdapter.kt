package com.valu.task.features.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.valu.domain.home.models.Product
import com.valu.task.databinding.ItemProductBinding
import com.valu.task.features.home.adapters.holders.ProductItemHolder
import com.valu.task.util.eventListners.RecycleViewEventListener

class ProductsAdapter(val onClickListener: RecycleViewEventListener): RecyclerView.Adapter<ProductItemHolder>()  {

    lateinit var items:MutableList<Product>
    lateinit var itemBinding: ItemProductBinding

    fun setItemsList(_items:MutableList<Product>) {

        items = _items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemHolder {
        itemBinding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductItemHolder(parent.context,itemBinding,onClickListener)
    }

    override fun onBindViewHolder(holder: ProductItemHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int {
        return items.size
    }
}