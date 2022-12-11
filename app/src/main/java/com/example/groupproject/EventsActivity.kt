package com.example.groupproject

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.groupproject.ui.theme.GroupProjectTheme
import android.webkit.WebViewClient
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView

import androidx.compose.material.Scaffold

class EventsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GroupProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()



                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Involed at TU", color = Color.White) },
            backgroundColor = Color(4294885393)) },
        content = { MyContent() }
    )
}
@Composable
fun MyContent(){
    val mUrl = "https://www.towson.edu/calendars/"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(mUrl)
        }
    }, update = {
        it.loadUrl(mUrl)
    })
}

@Composable
fun Greeting8(name: String) {
    Text(text = "Welcome $name!!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    GroupProjectTheme {
        Greeting8("User")
    }
}