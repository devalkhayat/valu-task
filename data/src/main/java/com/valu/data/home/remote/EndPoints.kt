package com.valu.data.home.remote

import com.valu.domain.home.models.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoints {

    @GET("products")
    suspend fun getAllProducts():Response<MutableList<Product>>

}