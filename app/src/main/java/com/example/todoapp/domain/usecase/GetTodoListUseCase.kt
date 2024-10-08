package com.example.todoapp.domain.usecase

import android.content.Context
import com.example.todoapp.data.repository.TodoRepository
import com.example.todoapp.domain.model.TodoModel
import kotlinx.coroutines.flow.Flow

class GetTodoListUseCase(context: Context): ISimpleUseCase<Unit, Flow<List<TodoModel>>, TodoModel> {

    override val repository = TodoRepository(context)

    override fun execute(p: Unit): Flow<List<TodoModel>> {
        return repository.getAllTodos()
    }
}