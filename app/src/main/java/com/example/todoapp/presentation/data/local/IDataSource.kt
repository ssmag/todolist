package com.example.todoapp.presentation.data.local

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface IDataSource<T> {

    fun create(item: T)

    fun read(): List<T>

    fun read(id: Long): T

    fun readFlow(id: Long): Flow<T> = flow { read(id) }

    fun readFlow(): Flow<List<T>> = flow { read() }

    fun update(item: T)

    fun delete(item: T)

}
