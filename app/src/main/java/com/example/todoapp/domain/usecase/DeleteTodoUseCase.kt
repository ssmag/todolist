package com.example.todoapp.domain.usecase

import android.content.Context
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.TodoModel

class DeleteTodoUseCase(context: Context): ISuspendUseCase<TodoModel, Unit, TodoModel> {

    override val repository = TodoRepository(context)

    override suspend fun execute(p: TodoModel) {
        repository.deleteTodo(p)
    }
}