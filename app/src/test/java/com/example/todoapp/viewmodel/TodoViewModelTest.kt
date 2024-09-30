package com.example.todoapp.viewmodel

import ContextStub
import TodoStub
import com.example.todoapp.data.local.IDataSource
import com.example.todoapp.data.repository.IRepository
import com.example.todoapp.domain.model.TodoModel
import com.example.todoapp.domain.usecase.EditTodoUseCase
import com.example.todoapp.domain.usecase.ISimpleUseCase
import com.example.todoapp.domain.usecase.ISuspendUseCase
import com.example.todoapp.presentation.event.TodoEvent
import com.example.todoapp.presentation.viewmodel.TodoViewModel
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

import org.junit.Test

class TodoViewModelTest {

    private var didAddEvent = false
    private var didDeleteEvent = false
    private var didEditEvent = false
    private var didGetTodoListEvent = false

    private val mockContext = ContextStub()
    private val mockDataSource = object : IDataSource<TodoModel> {
        override suspend fun create(item: TodoModel) { /* stub */
        }

        override suspend fun read(): List<TodoModel> {
            // stub
            return emptyList()
        }

        override suspend fun read(id: Long): TodoModel {
            // stub
            return TodoStub.stub
        }

        override suspend fun delete(item: TodoModel) { /* stub */
        }

        override suspend fun update(item: TodoModel) { /* stub */
        }

    }
    private val mockRepository = object : IRepository<TodoModel> {
        override val localDataSource: IDataSource<TodoModel> = mockDataSource
    }

    private val addTodoUseCase = object : ISuspendUseCase<TodoModel, Unit, TodoModel> {
        override val repository: IRepository<TodoModel> = mockRepository
        override suspend fun execute(p: TodoModel) {
            didAddEvent = true
        }
    }
    private val deleteTodoUseCase = object : ISuspendUseCase<TodoModel, Unit, TodoModel> {
        override val repository: IRepository<TodoModel> = mockRepository
        override suspend fun execute(p: TodoModel) {
            didDeleteEvent = true
        }

    }
    private val editTodoUseCase = object : ISuspendUseCase<EditTodoUseCase.Params, Unit, TodoModel> {
        override val repository: IRepository<TodoModel> = mockRepository
        override suspend fun execute(p: EditTodoUseCase.Params) {
            didEditEvent = true
        }

    }

    private val getTodoListUseCase =
        object : ISimpleUseCase<Unit, Flow<List<TodoModel>>, TodoModel> {
            override val repository: IRepository<TodoModel> = mockRepository
            override fun execute(p: Unit): Flow<List<TodoModel>> {
                // stub
                didGetTodoListEvent = true
                return flow { emit(emptyList()) }
            }
        }

    private val mockViewModel = TodoViewModel(
        mockContext,
        addTodoUseCase,
        deleteTodoUseCase,
        editTodoUseCase,
        getTodoListUseCase
    )

    @Test
    fun onEvent_UpdatedTodoEvent_onAdd() {
        didGetTodoListEvent = false
        runBlocking {
            mockViewModel.onEvent(TodoEvent.UpdatedTodoEvent.AddTodo)
            delay(BLOCK_DELAY)
        }
        assertTrue(didGetTodoListEvent)
    }

    @Test
    fun onEvent_UpdatedTodoEvent_onDelete() {
        didGetTodoListEvent = false
        runBlocking {
            mockViewModel.onEvent(TodoEvent.UpdatedTodoEvent.DeleteTodo(TodoStub.stub))
            delay(BLOCK_DELAY)
        }
        assertTrue(didGetTodoListEvent)
    }

    @Test
    fun onEvent_UpdateTodoEvent_onEdit() {
        didGetTodoListEvent = false
        runBlocking {
            mockViewModel.onEvent(TodoEvent.UpdatedTodoEvent.EditTodo)
            delay(BLOCK_DELAY)
        }
        assertTrue(didGetTodoListEvent)
    }

    @Test
    fun onEvent_AddTodo() {
        runBlocking {
            mockViewModel.onEvent(TodoEvent.UpdatedTodoEvent.AddTodo)
            delay(BLOCK_DELAY)
        }
        assertTrue(didAddEvent)
    }

    @Test
    fun onEvent_DeleteTodo() {
        runBlocking {
            mockViewModel.onEvent(TodoEvent.UpdatedTodoEvent.DeleteTodo(TodoStub.stub))
            delay(BLOCK_DELAY)
        }
        assertTrue(didDeleteEvent)
    }

    @Test
    fun onEvent_EditTodo() {
        runBlocking {
            mockViewModel.onEvent(TodoEvent.UpdatedTodoEvent.EditTodo)
            delay(BLOCK_DELAY)
        }
        assertTrue(didEditEvent)
    }

    @Test
    fun onEvent_GetTodoList() {
        runBlocking {
            mockViewModel
            delay(BLOCK_DELAY)
        }
        assertTrue(didGetTodoListEvent)
    }

    companion object {
        private const val BLOCK_DELAY = 1000L
    }
}