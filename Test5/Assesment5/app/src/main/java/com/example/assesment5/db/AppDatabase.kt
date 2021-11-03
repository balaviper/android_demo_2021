package com.example.assesment5.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BasicData::class, SalaryData::class], version = 2,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun  basicDao(): BasicDao
    abstract fun  salaryDao(): SalaryDao
}