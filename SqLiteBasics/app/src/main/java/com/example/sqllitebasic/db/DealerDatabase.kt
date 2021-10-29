package com.example.sqllitebasic.db

import android.content.Context
import android.view.View
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


@Database(entities = [Dealer::class],version = 1)
abstract class DealerDatabase : RoomDatabase(){

    abstract fun dealerDao() : DealerDao

    fun coroutineScp() = CoroutineScope(Dispatchers.IO)



    fun dbBuilder(view: Context) : DealerDatabase{
        return Room.databaseBuilder(
            view,
            DealerDatabase::class.java,
            "dealer-database"
        ).build()
    }

}