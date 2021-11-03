package com.example.assesment5

import android.app.Application
import androidx.room.Room
import com.example.assesment5.db.AppDatabase


class SalaryApplication : Application() {

    val db : AppDatabase by lazy {
        Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "salary_database"
        ).fallbackToDestructiveMigration().build()
    }
}