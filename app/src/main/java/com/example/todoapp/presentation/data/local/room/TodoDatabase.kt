package com.example.todoapp.presentation.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.presentation.TodoModel

@Database(
    entities = [TodoModel::class],
    version = 1
)
abstract class TodoDatabase: RoomDatabase() {
    abstract val todoDao: TodoDao
}