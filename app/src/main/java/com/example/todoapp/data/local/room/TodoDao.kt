package com.example.todoapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.presentation.TodoModel
import com.example.todoapp.data.local.IDataSource

@Dao
interface TodoDao: IDataSource<TodoModel> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun create(item: TodoModel)

    @Query("SELECT * FROM TodoModel")
    override fun read(): List<TodoModel>

    @Query("SELECT * FROM TodoModel WHERE id = :id")
    override fun read(id: Long): TodoModel

    @Update
    override fun update(item: TodoModel)

    @Delete
    override fun delete(item: TodoModel)
}