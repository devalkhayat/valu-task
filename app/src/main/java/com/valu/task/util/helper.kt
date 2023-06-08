package com.valu.task.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.valu.domain.home.models.Product
import com.valu.resources.R

object helper {

    fun loadImage(context: Context, path:String, photo: ImageView){
        Glide.with(context).load(path)
            .placeholder(R.color.app_gray) // placeholder
            .error(R.color.app_gray) // image broken
            .fallback(R.color.app_gray) // no image
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(photo)
    }

    fun checkProductIsValid(details:Product?):Boolean {
        if (details != null) {
            if (details.image.isNullOrBlank()) {
                return false

            } else if (details.title.isNullOrBlank()) {
                return false

            } else if (details.rating == null) {
                    return false

            } else {
                    return true
                }
        } else {
            return false
        }
    }


}