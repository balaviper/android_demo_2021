package com.example.assesment5.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assesment5.db.BasicDao
import com.example.assesment5.db.BasicData
import com.example.assesment5.db.SalaryDao
import com.example.assesment5.db.SalaryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel: ViewModel(){

    private var daoBasic : BasicDao ?= null
    private var daoSalary : SalaryDao ?= null

    private val _id = MutableLiveData<Long>()
    val id : LiveData<Long> = _id

     fun onSaveBasic(nm:String, mob: String, age:Int, mail: String){
        viewModelScope.launch(Dispatchers.IO) {
            daoBasic?.saveBasics(
                BasicData(
                    nm = nm,
                    mob = mob,
                    age = age,
                    mail = mail
                )
            )
        }
    }

    fun setId(id:Long){
        _id.value = id ?: 1
    }
    fun onSaveBasic(sal:Double, hra: Double, ta:Double, ctc: Double){
        viewModelScope.launch(Dispatchers.IO) {
            daoSalary?.saveSalary(
                SalaryData(
                    sal = sal,
                    hra = hra,
                    ta = ta,
                    ctc = ctc
                )
            )
        }
    }

    fun viewData(){
        viewModelScope.launch(Dispatchers.IO) {
            daoSalary?.findAllSalary()?.forEach {
                Log.i("@Salary Data","${it.id} ${it.sal} ${it.hra} ${it.ctc}")
            }
            daoBasic?.findAllBasic()?.forEach {
                Log.i("@Basic Data","${it.id} ${it.nm} ${it.age} ${it.mail}")
            }
        }
    }
    fun setBasicDao(dao : BasicDao) {
        daoBasic = dao
    }
    fun setSalaryDao(dao : SalaryDao) {
        daoSalary = dao
    }
}