package com.valu.task.util.di

import com.valu.domain.home.usecases.GetAllProductsUseCase

import org.koin.dsl.module

val UseCaseModule= module {
    single<GetAllProductsUseCase> {GetAllProductsUseCase(get())  }
}