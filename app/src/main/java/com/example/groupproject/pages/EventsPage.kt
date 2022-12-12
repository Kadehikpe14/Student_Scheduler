package com.example.groupproject.pages

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.groupproject.ui.theme.DarkBlue

@Composable
fun EventsPage(
    nav: NavHostController = rememberNavController()
){
    Scaffold(content = { MyContent() },)}


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