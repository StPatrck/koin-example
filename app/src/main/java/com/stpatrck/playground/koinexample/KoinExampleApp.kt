package com.stpatrck.playground.koinexample

import android.app.Application
import com.stpatrck.playground.koinexample.di.modules.appModule
import com.stpatrck.playground.koinexample.di.modules.launchesModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KoinExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this

        startKoin {
            androidLogger()
            androidContext(this@KoinExampleApp)

            modules(
                listOf(
                    appModule,
                    launchesModule
                )
            )
        }
    }

    companion object {
        @JvmStatic
        lateinit var app: KoinExampleApp
            private set
    }
}