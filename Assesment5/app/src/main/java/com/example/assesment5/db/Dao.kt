package com.example.assesment5.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BasicDao{

    @Insert
    fun saveBasics(bsDt : BasicData)

    @Query("select * from basic_details")
    fun findAllBasic() : List<BasicData>

    @Query("select * from basic_details where bas_id =:bId")
    fun findBasicById(bId:Long): BasicData

    @Query("select bas_id from basic_details order by bas_id")
    fun findAllId():List<Long>
}

@Dao
interface SalaryDao{

    @Insert
    fun saveSalary(salDt : SalaryData)

    @Query("select * from salary_details")
    fun findAllSalary() : List<SalaryData>

    @Query("select * from salary_details where bas_id =:sId")
    fun findSalaryById(sId:Long) : SalaryData
}