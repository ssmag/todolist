package com.example.todoapp.presentation.viewmodel

import android.content.Context
import android.util.Log
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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(
    context: Context,
    private val _addTodoUseCase: ISuspendUseCase<TodoModel, Unit, TodoModel> = AddTodoUseCase(context),
    private val _deleteTodoUseCase: ISuspendUseCase<TodoModel, Unit, TodoModel> = DeleteTodoUseCase(context),
    private val _editTodoUseCase: ISuspendUseCase<EditTodoUseCase.Params, Unit, TodoModel> = EditTodoUseCase(context),
    private val _getTodoListUseCase:  ISimpleUseCase<Unit, Flow<List<TodoModel>>, TodoModel> = GetTodoListUseCase(context),
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

    private val _state = MutableStateFlow(TodoListState())
    val state: StateFlow<TodoListState> = _state

    init {
        populateTodoList()
    }

    fun onEvent(event: TodoEvent) {
        when (event) {
            is TodoEvent.UpdatedTodoEvent.AddTodo -> viewModelScope.launch(dispatcher) {
                val newTodo = TodoModel(
                    title = _state.value.title,
                    desc = _state.value.desc
                )
                _addTodoUseCase.execute(newTodo)
                dismissDialog()
                populateTodoList()
            }

            is TodoEvent.UpdatedTodoEvent.DeleteTodo -> viewModelScope.launch(dispatcher) {
                _deleteTodoUseCase.execute(event.todo)
            }

            is TodoEvent.UpdatedTodoEvent.EditTodo -> viewModelScope.launch(dispatcher) {
                val params =
                    EditTodoUseCase.Params(
                        event.todo,
                        event.title,
                        event.desc
                    )
                _editTodoUseCase.execute(params)
                dismissDialog()
                populateTodoList()
            }
            is TodoEvent.OnTodoSelected -> {
                _state.value = _state.value.copy(isTodoOpen = true)
            }
            TodoEvent.OnNewTodo -> {
                _state.value = _state.value.copy(isTodoOpen = true)
            }
            TodoEvent.OnTodoDismissed -> {
                dismissDialog()
            }
            is TodoEvent.SetDesc -> {
                _state.value = _state.value.copy(desc = event.desc)
            }
            is TodoEvent.SetTitle -> {
                _state.value = _state.value.copy(title = event.title)
            }
        }
    }

    private fun dismissDialog() {
        _state.value = _state.value.copy(
            isTodoOpen = false,
            title = "",
            desc = ""
        )

    }

    private fun populateTodoList() = viewModelScope.launch(dispatcher) {
        _getTodoListUseCase.execute(Unit).collect { todos ->
            _state.value = _state.value.copy(todos = todos)
            Log.d(TAG, "populateTodoList: $todos")
            _state
        }
    }

    companion object {
        private const val TAG = "TodoViewModel"
    }

}