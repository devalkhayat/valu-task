package com.valu.task.util.di

import com.valu.task.features.home.viewmodels.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val ViewModelModule = module {
    viewModel{ HomeViewModel(get()) }
}