package com.example.assesment5.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "basic_details")
data class BasicData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "bas_id")
    var id : Long =0,

    @ColumnInfo(name = "bas_nm")
    var nm : String,

    @ColumnInfo(name = "bas_mob")
    var mob: String,

    @ColumnInfo(name = "bas_age")
    var age : Int,

    @ColumnInfo(name = "bas_mail")
    var mail : String,
)

@Entity(
    tableName = "salary_details",
)
data class SalaryData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true,name = "bas_id")
    var id: Long=0,

    @ColumnInfo(name = "bas_sal")
    var sal : Double,

    @ColumnInfo(name = "bas_mob")
    var hra : Double,

    @ColumnInfo(name = "bas_age")
    var ta : Double,

    @ColumnInfo(name = "bas_mail")
    var ctc : Double,


)