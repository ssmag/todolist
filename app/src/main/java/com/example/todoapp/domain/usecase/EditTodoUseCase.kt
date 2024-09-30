package com.example.todoapp.domain.usecase

import android.content.Context
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.TodoModel

class EditTodoUseCase(context: Context) {

    private val repository = TodoRepository(context)

    suspend fun execute(todo: TodoModel) {
        repository.updateTodo(todo)
    }
}