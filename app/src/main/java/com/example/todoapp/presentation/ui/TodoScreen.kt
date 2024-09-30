package com.example.todoapp.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.presentation.constants.StringConstants
import com.example.todoapp.presentation.event.TodoEvent
import com.example.todoapp.presentation.state.TodoListState

@Composable
fun TodoScreen(
    state: TodoListState,
    onEvent: (TodoEvent) -> Unit
) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                onEvent(TodoEvent.OnNewTodo)
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = StringConstants.ADD_TODO
                )
            }

        }

    ) { padding ->
        Title(
            modifier = Modifier.padding(padding)
        )
    }

    if (state.isTodoOpen) {
        AddTodoDialog(
            state = state,
            onEvent = onEvent
        )
    }
}

@Composable
fun Title(
    modifier: Modifier = Modifier
) {
        Text(
            text = StringConstants.SCREEN_TITLE,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
                .fillMaxWidth()
        )
}