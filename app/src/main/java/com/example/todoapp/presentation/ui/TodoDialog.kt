package com.example.todoapp.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todoapp.presentation.constants.StringConstants
import com.example.todoapp.presentation.event.TodoEvent
import com.example.todoapp.presentation.state.TodoListState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoDialog(
    state: TodoListState,
    onEvent: (TodoEvent) -> Unit,
) {
    BasicAlertDialog(
        onDismissRequest = {
            onEvent(TodoEvent.OnTodoDismissed)
        },
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = StringConstants.ADD_TODO)
            TextField(
                value = state.title,
                onValueChange = {
                    onEvent(TodoEvent.SetTitle(it))
                },
                placeholder = {
                    Text(text = StringConstants.TITLE_HINT)
                }
            )
            TextField(
                value = state.desc,
                onValueChange = {
                    onEvent(TodoEvent.SetDesc(it))
                },
                placeholder = {
                    Text(text = StringConstants.DESC_HINT)
                }
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(onClick = {
                if (state.selectedTodo == null) {
                    onEvent(TodoEvent.UpdatedTodoEvent.AddTodo)
                } else {
                    onEvent(
                        TodoEvent.UpdatedTodoEvent.EditTodo
                    )
                }
            }) {
                Text(text = "Save")
            }
        }
    }
}