package com.example.di_intro

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApp : Application() {
    @Inject
    lateinit var nwConfig: NwConfig

    override fun onCreate() {
        super.onCreate()

        nwConfig.config()
    }
}