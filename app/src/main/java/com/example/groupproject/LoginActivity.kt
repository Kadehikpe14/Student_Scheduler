package com.example.groupproject

//import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.groupproject.ui.theme.GroupProjectTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Scaffold(
                        topBar = { TopAppBar(
                            title = {Text("Please Login", fontSize = 30.sp, color = Color.White)},
                            backgroundColor = Color(0xFF0718C4)
                        ) },
                        content = {
                            Column(
                                modifier = Modifier.padding(
                                    horizontal = 24.dp,
                                    vertical = 48.dp
                                )
                            ) {
                                TextRow(text = stringResource(id = R.string.inform_prompt_username))
                                FieldRow()
                                EmptyRow()
                                TextRow(text = stringResource(id = R.string.inform_prompt_password))
                                FieldRow()
                                EmptyRow()
                                Login()
                                HyperTextRow(text = stringResource(id = R.string.inform_login_forgotinfo))
                                HyperTextRow(text = stringResource(id = R.string.inform_login_signup))
                            }
                        })
                }
            }
        }
    }
}

@Composable
fun HyperTextRow(text: String){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = text, fontSize = 16.sp, modifier = Modifier.clickable{  })
    }
}

@Composable
fun Login(){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Button(onClick = {/*TODO make the login button go to homepage*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE47001))
        ) {
            Text(text = stringResource(id = R.string.button_function_login), fontSize = 28.sp, color = Color.White)
        }
    }
}

@Composable
fun FieldRow(){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        TextField(value = "", onValueChange = {})
    }
}

@Composable
fun TextRow(text: String){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Text(text = text, fontSize = 32.sp)
    }
}

@Composable
fun EmptyRow(){
    Row(horizontalArrangement = Arrangement.Center,modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    GroupProjectTheme {}
}