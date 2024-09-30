package com.example.todoapp.data.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun create(item: TodoModel)

    @Query("SELECT * FROM TodoModel")
    suspend fun read(): List<TodoModel>

    @Query("SELECT * FROM TodoModel WHERE id = :id")
    suspend fun read(id: Long): TodoModel

    @Update
    suspend fun update(item: TodoModel)

    @Delete
    suspend fun delete(item: TodoModel)
}