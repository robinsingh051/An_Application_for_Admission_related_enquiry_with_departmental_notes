package com.example.faqNnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class pdfpage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var branch: String? = null
    var sem: String? = null
    var pdfUrl: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdfpage)
        auth= FirebaseAuth.getInstance()
        val actionbar=supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        var b: String? = intent.getStringExtra("branch")
        var s: String? = intent.getStringExtra("sem")
        var p: String? = intent.getStringExtra("pdfUrl")
        branch = b
        sem = s
        pdfUrl = p
        var url = "https://docs.google.com/gview?embedded=true&url=" + pdfUrl
        //Toast.makeText(this, branch + " " + sem + " " + pdfUrl, Toast.LENGTH_LONG).show()
        var m: WebView? = null
        m = findViewById<View>(R.id.webView) as WebView
        val webSettings: WebSettings = m.getSettings()

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        m.webViewClient = WebViewClient()

        // this will load the url of the website
        m.loadUrl(pdfUrl.toString())

        // this will enable the javascript settings
        m.settings.javaScriptEnabled = true

        // if you want to enable zoom feature
        m.settings.setSupportZoom(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.logoutaction, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout -> {
                Intent(this, MainActivity::class.java).apply {
                    addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }.also { startActivity(it) }
                finish()
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }

}