package com.example.todoapp.presentation.state

import com.example.todoapp.domain.model.TodoModel

data class TodoListState(
    val todos: List<TodoModel> = emptyList(),
    val selectedTodo: TodoModel? = null,
    val title: String = "",
    val desc: String = "",
    val isTodoOpen: Boolean = false
)