package com.example.todoapp.data.local

import android.content.Context
import androidx.room.Room
import com.example.todoapp.domain.model.TodoModel
import com.example.todoapp.data.local.room.TodoDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoLocalDataSource(context: Context): IDataSource<TodoModel> {

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

    override suspend fun create(item: TodoModel) {
        db.todoDao.create(item)
    }

    override fun readFlow(): Flow<List<TodoModel>> {
        return flow { emit(db.todoDao.read()) }
    }

    override suspend fun read(): List<TodoModel> {
        return db.todoDao.read()
    }

    override suspend fun read(id: Long): TodoModel {
        return db.todoDao.read(id)
    }

    override fun readFlow(id: Long): Flow<TodoModel> {
        return flow { emit(db.todoDao.read(id)) }
    }

    override suspend fun update(item: TodoModel) {
        db.todoDao.update(item)
    }

    override suspend fun delete(item: TodoModel) {
        db.todoDao.delete(item)
    }
}