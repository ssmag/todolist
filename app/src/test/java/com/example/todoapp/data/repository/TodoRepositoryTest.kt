package com.example.todoapp.data.repository

import ContextStub
import TodoStub
import android.content.Context
import com.example.todoapp.data.local.IDataSource
import com.example.todoapp.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import org.junit.Test

class TodoRepositoryTest {

    private val context: Context = ContextStub()
    private val mockDataSource = object: IDataSource<TodoModel> {
        var createCalled = false
        var readCalled = false
        var readIdCalled = false
        var deleteCalled = false
        var updateCalled = false

        override fun create(item: TodoModel) {
            createCalled = true
        }

        override fun readFlow(): Flow<List<TodoModel>> {
            readCalled = true
            return flow { emit(read()) }
        }

        override fun read(): List<TodoModel> {
            readCalled = true
            return emptyList()
        }

        override fun read(id: Long): TodoModel {
            readIdCalled = true
            return TodoStub.stub
        }

        override fun readFlow(id: Long): Flow<TodoModel> {
            readIdCalled = true
            return flow { emit(read(id)) }
        }

        override fun delete(item: TodoModel) {
            deleteCalled = true
            // stub
        }

        override fun update(item: TodoModel) {
            updateCalled = true
            // stub
        }

    }
    private val repository = TodoRepository(context, mockDataSource)

    @Test
    fun createTodo() {
        repository.createTodo(TodoStub.stub)
        assert(mockDataSource.createCalled)
    }

    @Test
    fun getAllTodos() {
        repository.getAllTodos()
        assert(mockDataSource.readCalled)
    }

    @Test
    fun getTodoById() {
        repository.getTodoById(1)
        assert(mockDataSource.readIdCalled)
    }

    @Test
    fun updateTodo() {
        repository.updateTodo(TodoStub.stub)
        assert(mockDataSource.updateCalled)
    }

    @Test
    fun deleteTodo() {
        repository.deleteTodo(TodoStub.stub)
        assert(mockDataSource.deleteCalled)
    }
}