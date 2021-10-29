package com.example.sqllitebasic.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dealer")
data class Dealer(

    @PrimaryKey(autoGenerate = true)
    var id: Long =0,

    @ColumnInfo(name = "dl_nm")
    var dlNm: String,

    @ColumnInfo(name = "mobile")
    var mobile: String,

    @ColumnInfo(name = "period")
    var period: Int,

    @ColumnInfo(name = "is_active")
    var isActive: Boolean
)