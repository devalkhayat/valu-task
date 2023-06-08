package com.valu.task.util.di

import com.valu.data.common.RetrofitBuilder
import org.koin.dsl.module

val NetworkModule = module {
    single { RetrofitBuilder() }
}