package com.example.todoapp.domain.usecase

import com.example.todoapp.data.repository.IRepository

interface IUseCase<T> {
    val repository: IRepository<T>
}
