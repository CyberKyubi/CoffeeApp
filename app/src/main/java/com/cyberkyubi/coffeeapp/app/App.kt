package com.cyberkyubi.coffeeapp.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

import com.cyberkyubi.coffeeapp.di.appModule
import com.cyberkyubi.coffeeapp.di.dataModule
import com.cyberkyubi.coffeeapp.di.domainModule

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, dataModule, domainModule))
        }
    }
}