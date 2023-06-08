package com.valu.task.features.home.adapters.holders

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.valu.domain.home.models.Product
import com.valu.task.databinding.ItemProductBinding
import com.valu.task.util.eventListners.RecycleViewEventListener
import com.valu.task.util.helper

class ProductItemHolder (val context: Context, val binding: ItemProductBinding,val onClickListener: RecycleViewEventListener): RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(data:Product){
        binding.apply {
            helper.loadImage(context,data.image!!,binding.img)
            tvTitle.text=data.title
            tvPrice.text= "${data.price.toString()} ${context.getString(com.valu.resources.R.string.currency)}"
            root.setOnClickListener {
                onClickListener.onClick(data)
            }
        }
    }

}