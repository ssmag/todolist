package com.example.todoapp.domain.usecase

import android.content.Context
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.TodoModel
import com.example.todoapp.domain.usecase.EditTodoUseCase.Params

class EditTodoUseCase(context: Context): ISuspendUseCase<Params, Unit, TodoModel> {

    override val repository = TodoRepository(context)

    override suspend fun execute(p: Params) {
        val newTodo = p.todo.copy(title = p.title, desc = p.description)
        repository.updateTodo(newTodo)
    }

    class Params(
        val todo: TodoModel,
        val title: String,
        val description: String
    )
}