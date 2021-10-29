package com.example.jetpack.stockApp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class StockViewModel : ViewModel() {


    private val _loginCheck : MutableLiveData<Boolean> = MutableLiveData()
    private val _userName : MutableLiveData<String> = MutableLiveData()
    private val _password : MutableLiveData<String> = MutableLiveData()

    val stock = listOf<StockData>(
        StockData("abc", "98898798798"),
        StockData("pqr", "98898798798"),
        StockData("gef", "98898798798"),
        StockData("xyz", "98898798798")
    )

    val loginCheck: LiveData<Boolean> = _loginCheck
    val userName: LiveData<String> = _userName
    val password: LiveData<String> = _password

    fun onLogin() {
        Log.i("@ani", "User Logged In")
        Log.i("@ani", "User Name - ${userName.value}")
        Log.i("@ani", "Password - ${password.value}")
        _loginCheck.value = userName.value == "android" && password.value == "android"
    }

    fun updateUserName(st : String) {
        _userName.value = st
    }

    fun updatePassword(st : String) {
        _password.value = st
    }

}