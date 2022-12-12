package com.example.groupproject.pages

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupproject.model.todolist.TodoItem


@Composable
fun TodoPage() {
    val originalTodo = (0..10).map { i -> //TODO we don't need 20 todo, we need to show the add function
        TodoItem(
            "Make a " + i, false
        )
    }
    val mutableTodo = remember { mutableStateOf(originalTodo) }
    val addBar = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(text = "To-Do List", fontSize = 32.sp)
                Spacer(modifier = Modifier.width(32.dp))

                Button(onClick = {
                    mutableTodo.value = mutableTodo.value.filter { todoItem ->
                        !todoItem.isChecked
                    }
                }) { Text(text = "Delete") }
            }
        }
    ) {
            TodoList(list = mutableTodo.value, onChange = { idx, checked ->
                mutableTodo.value = mutableTodo.value.mapIndexed { i, todo ->
                    if (i == idx)
                        return@mapIndexed todo.copy(isChecked = checked)
                    todo
                }
            }, onAdd = {
                if (addBar.value != "") {
                    mutableTodo.value = mutableTodo.value.plus(TodoItem(addBar.value, false))
                    addBar.value = ""
                }
            }, addBar = addBar)

    }
}
@Composable
fun TodoList(
    list: List<TodoItem>,
    onChange: (Int, Boolean)->Unit,
    addBar: MutableState<String>,
    onAdd: ()->Unit
) {
    Box(contentAlignment = Alignment.Center) {
        Column(modifier = Modifier
            ) {
            LazyColumn {
                itemsIndexed(list) { idx, todoItem ->
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        elevation = 8.dp,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Column(
                                horizontalAlignment = Alignment.Start,
                                modifier = Modifier.fillMaxWidth(0.9f)
                            ) {
                                Text(todoItem.name)
                            }
                            Column(horizontalAlignment = Alignment.End) {
                                Checkbox(checked = todoItem.isChecked, onCheckedChange = {
                                    onChange(idx, !todoItem.isChecked)
                                })
                            }

                        }

                    }
                }
                item {
                    Row {
                        AddField(addBar = addBar, onAdd = onAdd)
                    }
                    //this row is simply to so that the bottom bar doesn't cover the add
                    Row(modifier = Modifier.padding(vertical = 28.dp)){}
                }

            }

        }
    }
}

@Composable
fun AddField(
    addBar: MutableState<String>,
    onAdd: ()->Unit
){
    Row( modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center) {
        Card(shape = RoundedCornerShape(4.dp),
            elevation = 4.dp,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(0.75f)) {
            Row {
                OutlinedTextField(value = addBar.value,
                    modifier = Modifier.fillMaxWidth(0.9f),
                    onValueChange = {
                        newval -> addBar.value = newval
                }, placeholder = {
                    Text(text = stringResource(id = com.example.groupproject.R.string.button_todo_addbar))
                })
                Button(onClick = {
                    onAdd()
                }) {

                }
            }
        }
    }


}