package com.example.sqllitebasic.db

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DealersViewModel : ViewModel(){
    private val _scp = MutableLiveData<CoroutineScope>()
    val scp: LiveData<CoroutineScope> = _scp

    private val _db = MutableLiveData<DealerDatabase>()
    val db: LiveData<DealerDatabase> = _db

    private val _dao = MutableLiveData<DealerDao>()
    val dao: LiveData<DealerDao> = _dao

    private val _list = MutableLiveData<List<Dealer>>()
    val list: LiveData<List<Dealer>> = _list

    fun insertData(dlr : Dealer){
        _scp.value?.launch {
            _dao.value?.createNewDealer(dlr)
        }
    }
    fun insertIntoViewModel(){
        _scp.value?.launch {
            //Cannot invoke setValue on a background thread
            withContext(Dispatchers.Main) {
                //Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
                _list.value = _dao.value?.findAllDealers()
            }
        }
    }
    fun getData():List<Dealer>{
        return _list.value ?: listOf()
    }

    fun coRoutine() {
         _scp.value = CoroutineScope(Dispatchers.IO)
    }

    fun dataBaseInit(context: Context){
        _db.value = Room.databaseBuilder(
            context,
            DealerDatabase::class.java,
            "dealer-database"
        ).build()
    }

    fun dataBuilder(context: Context): DealerDatabase{
        return _db.value ?: Room.databaseBuilder(
            context,
            DealerDatabase::class.java,
            "dealer-database"
        ).build()
    }
    fun dataDao(d : DealerDatabase): DealerDao{
        _dao.value = d.dealerDao()
        return _dao.value ?: d.dealerDao()
    }

}