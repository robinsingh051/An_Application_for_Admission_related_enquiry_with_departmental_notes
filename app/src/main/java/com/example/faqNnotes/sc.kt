package com.example.faqNnotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class sc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sc)
        var search: String? = intent.getStringExtra("stext")
        var url = "https://www.google.com/search?q=" + search
        var m: WebView? = null
        m = findViewById<View>(R.id.webView1) as WebView
        val webSettings: WebSettings = m.getSettings()
        val actionbar=supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        m.webViewClient = WebViewClient()

        // this will load the url of the website
        m.loadUrl(url.toString())

        // this will enable the javascript settings
        m.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        m.settings.setSupportZoom(true)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}