package com.example.todoapp.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.usecase.AddTodoUseCase
import com.example.todoapp.domain.usecase.DeleteTodoUseCase
import com.example.todoapp.domain.usecase.EditTodoUseCase
import com.example.todoapp.domain.usecase.GetTodoListUseCase
import com.example.todoapp.presentation.event.TodoEvent
import com.example.todoapp.presentation.state.TodoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class TodoViewModel(context: Context): ViewModel() {

    private val _state = MutableStateFlow(TodoListState())

    private val _addTodoUseCase = AddTodoUseCase(context)
    private val _deleteTodoUseCase = DeleteTodoUseCase(context)
    private val _editTodoUseCase = EditTodoUseCase(context)
    private val _getTodoListUseCase = GetTodoListUseCase(context)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun onEvent(event: TodoEvent) {
        when (event) {
            is TodoEvent.UpdatedTodoEvent.AddTodo -> viewModelScope.launch {
                _addTodoUseCase.execute(event.todo)
            }

            is TodoEvent.UpdatedTodoEvent.DeleteTodo -> viewModelScope.launch {
                _deleteTodoUseCase.execute(event.todo)
            }

            is TodoEvent.UpdatedTodoEvent.EditTodo -> viewModelScope.launch {
                _editTodoUseCase.execute(event.todo)
                _state.value = _state.value.copy(isTodoOpen = false)
            }
            is TodoEvent.OnTodoSelected -> {
                _state.value = _state.value.copy(isTodoOpen = true)
            }
            is TodoEvent.UpdatedTodoEvent -> viewModelScope.launch {
                _getTodoListUseCase.execute().flatMapLatest { todos ->
                    _state.value = _state.value.copy(todos = todos)
                    _state
                }
            }
        }

    }
}