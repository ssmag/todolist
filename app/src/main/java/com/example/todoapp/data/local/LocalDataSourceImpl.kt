package com.example.todoapp.data.local

import android.content.Context
import androidx.room.Room
import com.example.todoapp.presentation.TodoModel
import com.example.todoapp.data.local.room.TodoDatabase

class LocalDataSourceImpl(context: Context): IDataSource<TodoModel> {

    // Would use dependency injection, especially since we are passing context
    // but due to time constraints and avoidance of introducing more libraries than
    // described in the requirements and not having to go ahead and build our own DI,
    // simple injection will do for the purposes of the exercise
    private val db by lazy {
        Room.databaseBuilder(
            context,
            TodoDatabase::class.java,
            "todo.db"
        ).build()
    }

    override fun create(item: TodoModel) {
        db.todoDao.create(item)
    }

    override fun read(): List<TodoModel> {
        return db.todoDao.read()
    }

    override fun read(id: Long): TodoModel {
        return db.todoDao.read(id)
    }

    override fun update(item: TodoModel) {
        db.todoDao.update(item)
    }

    override fun delete(item: TodoModel) {
        db.todoDao.delete(item)
    }
}