package com.example.sqlitecasestudy.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashViewModel: ViewModel() {

    private val _itemClick = MutableLiveData<DashItem>()
    val itemClick : LiveData<DashItem> = _itemClick

    fun performClick(dashItem : DashItem) {
        _itemClick.value = dashItem
    }
}