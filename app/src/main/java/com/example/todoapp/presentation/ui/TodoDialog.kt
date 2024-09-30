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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        val (isTitleValid, setIsTitleValid) = remember { mutableStateOf(true) }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            val dialogTitle = if (state.selectedTodo == null) {
                StringConstants.ADD_TODO
            } else {
                StringConstants.EDIT_TODO
            }
            Text(text = dialogTitle)
            TextField(
                value = state.title,
                onValueChange = {
                    onEvent(TodoEvent.SetTitle(it))
                    setIsTitleValid(it.isEmpty().not())
                },
                placeholder = {
                    Text(text = StringConstants.TITLE_HINT)
                },
                isError = !isTitleValid,
                maxLines = 2
            )
            TextField(
                value = state.desc,
                onValueChange = {
                    onEvent(TodoEvent.SetDesc(it))
                },
                placeholder = {
                    Text(text = StringConstants.DESC_HINT)
                },
                maxLines = 7
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Button(
                enabled = isTitleValid && state.title.isNotBlank(),
                onClick = {
                if (state.selectedTodo == null) {
                    onEvent(TodoEvent.UpdatedTodoEvent.AddTodo)
                } else {
                    onEvent(
                        TodoEvent.UpdatedTodoEvent.EditTodo
                    )
                }
            }) {
                Text(text = StringConstants.SAVE_TODO)
            }
        }
    }
}