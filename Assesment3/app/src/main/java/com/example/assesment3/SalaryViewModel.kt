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
    val ctc: String
)

class SalaryViewModel: ViewModel(){
//    private val _data = MutableLiveData<Salary>()
//    val data : LiveData<Salary> = _data
    val data = MutableLiveData<Salary>()
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

    fun getSalary(): String{
        return "Salary : ${data.value?.basicSalary}"
    }

    fun getHraa(): String{
        return "Hra : ${data.value?.hra}"
    }
    fun getTaa():String{
        return "Ta : ${data.value?.ta}"
    }
    fun getCtcc():String{
        return "Ctc : ${data.value?.ctc}"
    }

    fun updateData(){
        data.value = Salary(basicSalary.value.toString(),hra.value.toString(),ta.value.toString(),ctc.value.toString())
        Log.i("check", "${data.value}")
    }





}