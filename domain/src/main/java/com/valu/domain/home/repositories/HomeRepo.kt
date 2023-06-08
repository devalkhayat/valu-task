package com.valu.domain.home.repositories

import com.valu.domain.common.FinalResponse
import com.valu.domain.home.models.Product

interface HomeRepo {

    suspend fun getAll(): FinalResponse<MutableList<Product>>
}