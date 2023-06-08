package com.valu.domain.home.usecases

import com.valu.domain.home.repositories.HomeRepo


class GetAllProductsUseCase(private val homeRepo: HomeRepo) {
    suspend operator fun invoke()=homeRepo.getAll()
}
