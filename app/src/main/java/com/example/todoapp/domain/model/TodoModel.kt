package com.example.todoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val desc: String
)