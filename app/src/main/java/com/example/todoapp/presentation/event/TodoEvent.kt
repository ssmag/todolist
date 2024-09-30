package com.example.todoapp.presentation.event

import com.example.todoapp.domain.model.TodoModel

sealed class TodoEvent: UIEvent {
    sealed class UpdatedTodoEvent : TodoEvent() {
        object AddTodo : TodoEvent()
        class DeleteTodo(val todo: TodoModel) : TodoEvent()
        class EditTodo(val todo: TodoModel, val title: String, val desc: String) : TodoEvent()
    }
    class OnTodoSelected(val todo: TodoModel) : TodoEvent()
    object OnTodoDismissed: TodoEvent()
    class SetTitle(val title: String): TodoEvent()
    class SetDesc(val desc: String): TodoEvent()
    object OnNewTodo: TodoEvent()
}
