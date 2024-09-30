package com.example.todoapp.domain.usecase

import android.content.Context
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow

class GetTodoListUseCase(context: Context) {

    private val repository = TodoRepository(context)

    fun execute(): Flow<List<TodoModel>> {
       return repository.getAllTodos()
    }
}