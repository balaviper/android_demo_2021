package com.example.basicnavigationdrawer.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _clkPos = MutableLiveData<Int>()
    val clkPos: LiveData<Int> = _clkPos
}