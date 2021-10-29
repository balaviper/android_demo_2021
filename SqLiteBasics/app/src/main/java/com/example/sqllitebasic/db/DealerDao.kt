package com.example.sqllitebasic.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface DealerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createNewDealer(dlr : Dealer)

    @Query("select * from dealer")
    fun findAllDealers() : List<Dealer>

}