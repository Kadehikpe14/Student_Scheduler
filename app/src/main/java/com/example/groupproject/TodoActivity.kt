package com.example.groupproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.example.groupproject.ui.theme.GroupProjectTheme
import com.example.groupproject.util.TodoItem

class TodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val originalTodo = (0..20).map{ i -> TodoItem("make a "+i,i%3==0
                    )}
                    val mutableTodo = remember{ mutableStateOf(originalTodo) }
                    val addBar = remember{ mutableStateOf("")};
                    Scaffold(
                        topBar = {
                            Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp)) {
                                Text(text = stringResource(id = R.string.title_activity_todo), fontSize = 32.sp)
                                Spacer(modifier = Modifier.width(32.dp))
                                Button(onClick = {
                                    mutableTodo.value = mutableTodo.value.filter {
                                            todoItem -> !todoItem.checked
                                    }
                                }) {

                                }
                            }
                        }
                    ){
                        TodoList(list = mutableTodo.value, onChange = {
                                idx, checked ->
                            mutableTodo.value = mutableTodo.value.mapIndexed() {
                                    i, todo ->
                                if(i==idx)
                                    return@mapIndexed todo.copy(checked = checked)
                                todo
                            }
                        }, onAdd = {
                            if(addBar.value!=""){
                                mutableTodo.value = mutableTodo.value.plus(TodoItem(addBar.value,false))
                                addBar.value = ""
                            }


                        }, addBar = addBar)
                    }

                }
            }
        }
    }
}

@Composable
fun TodoList(
    list: List<TodoItem>,
    onChange: (Int, Boolean)->Unit,
    addBar: MutableState<String>,
    onAdd: ()->Unit
){
    Column(modifier = Modifier.fillMaxHeight()) {
        LazyColumn(){
            itemsIndexed(list){
                idx, todoItem ->
                Card(shape = RoundedCornerShape(4.dp),
                elevation = 8.dp,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()){
                    Row(verticalAlignment = Alignment.CenterVertically){
                        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.fillMaxWidth(0.9f)) {
                            Text(todoItem.name)
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Checkbox(checked = todoItem.checked, onCheckedChange = {
                                onChange(idx,!todoItem.checked)
                            })
                        }

                    }

                }
            }
            item { 
                Row() {
                    AddField(addBar = addBar, onAdd= onAdd)
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
    Row( modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Card(shape = RoundedCornerShape(4.dp),
            elevation = 4.dp,
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(0.75f)) {
            Row() {
                OutlinedTextField(value = addBar.value, modifier = Modifier.fillMaxWidth(0.9f), onValueChange = {
                        newval -> addBar.value = newval
                }, placeholder = {
                    Text(text = stringResource(id = R.string.button_todo_addbar))
                })
                Button(onClick = {
                    onAdd();
                }) {

                }
            }

        }
    }


}

@Composable
fun Greeting5(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    GroupProjectTheme {
        Greeting5("Android")
    }
}