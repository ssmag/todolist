package com.example.todoapp.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.presentation.ui.theme.TodoAppTheme
import com.example.todoapp.presentation.viewmodel.TodoViewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<TodoViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    @Suppress("UNCHECKED_CAST")
                    return TodoViewModel(applicationContext) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoAppTheme {
                val state by viewModel.state.collectAsState()
                TodoScreen(
                    state = state,
                    onEvent = viewModel::onEvent
                )
            }
        }
    }
}
