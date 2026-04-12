package com.example.starwarsapp.application

import android.app.Application
import com.example.data.di.databaseModule
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.starwarsapp.di.appModule
import com.example.starwarsapp.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(listOf(domainModule, networkModule, repositoryModule, databaseModule, appModule))
        }
    }
}