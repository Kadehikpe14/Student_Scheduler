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
import androidx.compose.ui.unit.sp

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
                    Scaffold(
                        topBar = { TopAppBar(
                            title = { Text("View Towson Events!", fontSize = 30.sp, color = Color.White) },
                            backgroundColor = Color(4294885393)) },
                        content = { MyContent()})
                //TODO instead of having a webview to TU events, make multiple links they can view
                }
            }
        }
    }
}

@Composable
fun MyContent(){
    val url = "https://www.towson.edu/calendars/"
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            webViewClient = WebViewClient()
            loadUrl(url)
        }}, update = { it.loadUrl(url) })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    GroupProjectTheme {}
}