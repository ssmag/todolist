package com.example.todoapp.domain.usecase

import com.example.todoapp.data.repository.IRepository

interface ISimpleUseCase<in O, out U, T>: IUseCase<T> {

    override val repository: IRepository<T>

    fun execute(p: O): U
}