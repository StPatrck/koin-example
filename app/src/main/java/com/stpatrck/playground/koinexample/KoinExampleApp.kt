package com.stpatrck.playground.koinexample

import android.app.Application

class KoinExampleApp : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this
    }

    companion object {
        @JvmStatic
        lateinit var app: KoinExampleApp
            private set
    }
}