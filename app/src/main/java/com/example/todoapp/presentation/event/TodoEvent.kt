package com.example.todoapp.presentation.event

import com.example.todoapp.domain.model.TodoModel

sealed class TodoEvent(open val todo: TodoModel): UIEvent {
    sealed class UpdatedTodoEvent(todo: TodoModel): TodoEvent(todo) {
        class AddTodo(todo: TodoModel) : TodoEvent(todo)
        class DeleteTodo(todo: TodoModel) : TodoEvent(todo)
        class EditTodo(todo: TodoModel) : TodoEvent(todo)
    }
    class OnTodoSelected(todo: TodoModel) : TodoEvent(todo)
}
