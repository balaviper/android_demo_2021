package com.example.di_intro

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GenConfig
@Inject
constructor() {
    fun genConfig() = Log.i("@ani", "General Config")
}