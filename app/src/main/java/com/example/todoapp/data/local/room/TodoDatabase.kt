package com.example.todoapp.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.domain.model.TodoModel

@Database(
    entities = [TodoModel::class],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {
    abstract val todoDao: TodoDao
}