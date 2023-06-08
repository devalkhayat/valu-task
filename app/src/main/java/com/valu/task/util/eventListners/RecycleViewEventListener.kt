package com.valu.task.util.eventListners

import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.valu.domain.home.models.Product
import com.valu.task.databinding.ItemProductBinding

interface RecycleViewEventListener{
        fun onClick(item:Product){}

}