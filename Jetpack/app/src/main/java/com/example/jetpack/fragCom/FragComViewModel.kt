package com.example.jetpack.fragCom


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FragComViewModel: ViewModel() {
    val color  = MutableLiveData<String>()

    fun changeColor(col : String) {
        color.value = col
        Log.i("@check","$col")
    }
}