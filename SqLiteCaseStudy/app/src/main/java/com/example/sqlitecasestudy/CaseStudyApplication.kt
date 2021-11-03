package com.example.sqlitecasestudy

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.example.sqlitecasestudy.db.AppDatabase

class CaseStudyApplication : Application() {

    val db: AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "exp_mgr_db"
        ).build()
    }

    override fun onCreate() {
        super.onCreate()

        Log.i("@Hash", "1 ${db.hashCode()}")

    }

}