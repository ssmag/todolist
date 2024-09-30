package com.example.todoapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        if (state.isTodoOpen) {
            AddTodoDialog(
                state = state,
                onEvent = onEvent
            )
        }

        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Title(
                modifier = Modifier.padding(padding)
            )
            TodoList(
                state = state,
                onEvent = onEvent
            )
        }
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

@Composable
fun TodoList(
    state: TodoListState,
    onEvent: (TodoEvent) -> Unit
) {

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(state.todos) { todo ->
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = todo.title,
                        fontSize = 20.sp
                    )
                    Text(
                        text = todo.desc,
                        fontSize = 15.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                IconButton(onClick = {
                    onEvent(TodoEvent.UpdatedTodoEvent.DeleteTodo(todo))
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete contact"
                    )
                }
            }
        }
    }
}