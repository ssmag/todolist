package com.example.todoapp.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.model.TodoModel
import com.example.todoapp.domain.usecase.AddTodoUseCase
import com.example.todoapp.domain.usecase.DeleteTodoUseCase
import com.example.todoapp.domain.usecase.EditTodoUseCase
import com.example.todoapp.domain.usecase.GetTodoListUseCase
import com.example.todoapp.domain.usecase.ISimpleUseCase
import com.example.todoapp.domain.usecase.ISuspendUseCase
import com.example.todoapp.presentation.event.TodoEvent
import com.example.todoapp.presentation.state.TodoListState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class TodoViewModel(
    context: Context,
    private val _addTodoUseCase: ISuspendUseCase<TodoModel, Unit, TodoModel> = AddTodoUseCase(context),
    private val _deleteTodoUseCase: ISuspendUseCase<TodoModel, Unit, TodoModel> = DeleteTodoUseCase(context),
    private val _editTodoUseCase: ISuspendUseCase<TodoModel, Unit, TodoModel> = EditTodoUseCase(context),
    private val _getTodoListUseCase:  ISimpleUseCase<Unit, Flow<List<TodoModel>>, TodoModel> = GetTodoListUseCase(context),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _state = MutableStateFlow(TodoListState())

    init {
        populateTodoList()
    }

    fun onEvent(event: TodoEvent) {
        when (event) {
            is TodoEvent.UpdatedTodoEvent.AddTodo -> viewModelScope.launch(dispatcher) {
                _addTodoUseCase.execute(event.todo)
            }

            is TodoEvent.UpdatedTodoEvent.DeleteTodo -> viewModelScope.launch(dispatcher) {
                _deleteTodoUseCase.execute(event.todo)
            }

            is TodoEvent.UpdatedTodoEvent.EditTodo -> viewModelScope.launch(dispatcher) {
                _editTodoUseCase.execute(event.todo)
                _state.value = _state.value.copy(isTodoOpen = false)
            }
            is TodoEvent.OnTodoSelected -> {
                _state.value = _state.value.copy(isTodoOpen = true)
            }
            is TodoEvent.UpdatedTodoEvent -> {
                populateTodoList()
            }
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    private fun populateTodoList() = viewModelScope.launch(dispatcher) {
        _getTodoListUseCase.execute(Unit).flatMapLatest { todos ->
            _state.value = _state.value.copy(todos = todos)
            _state
        }
    }
}