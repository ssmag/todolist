package com.example.todoapp.presentation.data.local.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.presentation.TodoModel
import com.example.todoapp.presentation.data.local.IDataSource

interface TodoDao: IDataSource<TodoModel> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun create(item: TodoModel)

    @Query("SELECT * FROM todo")
    override fun read(): List<TodoModel>

    @Query("SELECT * FROM todo WHERE id = :id")
    override fun read(id: Long): TodoModel

    @Update
    override fun update(item: TodoModel)

    @Delete
    override fun delete(item: TodoModel)
}