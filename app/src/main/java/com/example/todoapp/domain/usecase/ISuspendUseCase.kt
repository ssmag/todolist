package com.example.todoapp.domain.usecase

import com.example.todoapp.data.repository.IRepository

interface ISuspendUseCase<O, U, T>: IUseCase<T> {

    override val repository: IRepository<T>

    suspend fun execute(p: O): U
}