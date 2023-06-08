package com.valu.task

import android.app.Application
import com.valu.task.util.di.NetworkModule
import com.valu.task.util.di.RepositoryModule
import com.valu.task.util.di.UseCaseModule
import com.valu.task.util.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class ApplicationStartup: Application()  {


    override fun onCreate() {
        super.onCreate()
        startKoin(this)
    }
    private fun startKoin(app: Application) {
        org.koin.core.context.startKoin {
            androidLogger(Level.ERROR)
            androidContext(app)
            modules(
                ViewModelModule,
                RepositoryModule,
                UseCaseModule,
                NetworkModule
            )
        }
    }
}