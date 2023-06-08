package com.valu.task.util.di

import com.valu.data.home.remote.repoImp.HomeRepoImpl
import com.valu.domain.home.repositories.HomeRepo
import org.koin.dsl.module


val RepositoryModule=module{
    single<HomeRepo> { HomeRepoImpl(get()) }
}