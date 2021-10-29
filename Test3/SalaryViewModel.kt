package com.example.assesment3

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

data class Salary(
    val basicSalary : String,
    val hra : String,
    val ta : String,
    val ctc: String,
)

class SalaryViewModel: ViewModel(){

    private val _itemClick = MutableLiveData<Salary>()
    val itemClick : LiveData<Salary> = _itemClick

    private val data = MutableLiveData<Salary>()
    private val basicSalary = MutableLiveData<String>()
    private val hra = MutableLiveData<String>()
    private val ta = MutableLiveData<String>()
    private val ctc = MutableLiveData<String>()

    fun updateSalary(str : String){
        basicSalary.value = str
    }
    fun updateHra(str : String){
        hra.value = str
    }
    fun updateTa(str : String){
        ta.value = str
    }
    fun updateCtc(str : String){
        ctc.value = str
    }

    fun updateData(){
        data.value = Salary(basicSalary.toString(),hra.toString(),ta.toString(),ctc.toString())
        Log.i("check", "${data.value}")
    }





}