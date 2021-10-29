package com.example.assesment4

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class LocalDataSource
@Inject
constructor (
    val rds : RemoteDataSource
) {


    fun loadData() = rds.fetchData()
}

@ViewModelScoped
class RemoteDataSource
@Inject
constructor()  {



    fun fetchData() = listOf(
        Expense(1, "Tea", 10.0, "00/00/0000","Desc1","asd",R.drawable.ic_food)
    )
}