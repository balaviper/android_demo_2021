package com.example.di_intro

import android.util.Log
import com.google.gson.Gson
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NwConfig
@Inject
constructor(
    val gc : GenConfig,
    val gen : Gson

) {
    fun config() = Log.i("@check", "Configuring Network")
}