package com.example.todoapp.data.repository

import com.example.todoapp.data.local.IDataSource

interface IRepository<T> {

    val localDataSource: IDataSource<T>

    // if we want to add remote calls to fetch data from server, we can add a
    // val remoteDataSource: IDataSource<T>


}