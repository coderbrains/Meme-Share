package com.example.memeshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class LoadWeb : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_web)
        val webView : WebView = findViewById(R.id.webview)
        webView.loadUrl("https://www.youtube.com/channel/UC4CwQWuy47lTFP8-RhtF8lw?view_as=subscriber")
    }
}