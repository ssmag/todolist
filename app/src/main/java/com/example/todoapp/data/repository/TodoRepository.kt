package com.example.todoapp.data.repository

import android.content.Context
import com.example.todoapp.data.local.IDataSource
import com.example.todoapp.data.local.TodoLocalDataSource
import com.example.todoapp.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow

class TodoRepository(context: Context): IRepository<TodoModel> {

    override val localDataSource: IDataSource<TodoModel> = TodoLocalDataSource(context)

    fun createTodo(todo: TodoModel) {
        localDataSource.create(todo)
    }

    fun getAllTodos(): Flow<List<TodoModel>> {
        return localDataSource.readFlow()
    }

    fun getTodoById(id: Long): Flow<TodoModel> {
        return localDataSource.readFlow(id)
    }

    fun updateTodo(todo: TodoModel) {
        localDataSource.update(todo)
    }

    fun deleteTodo(todo: TodoModel) {
        localDataSource.delete(todo)
    }
}