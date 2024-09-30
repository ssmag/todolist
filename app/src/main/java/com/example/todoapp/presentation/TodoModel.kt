package com.example.todoapp.presentation

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val desc: String
)