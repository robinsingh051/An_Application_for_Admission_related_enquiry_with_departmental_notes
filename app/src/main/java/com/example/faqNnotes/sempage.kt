package com.example.faqNnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sempage.*

class sempage : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var branch: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sempage)
        auth= FirebaseAuth.getInstance()
        var b: String? = intent.getStringExtra("branch")
        if (b != null)
            branch = b
        val actionbar=supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        //Toast.makeText(this, "hi " + branch, Toast.LENGTH_LONG).show()

        sem3.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem3")
            startActivity(intent)

        }
        sem4.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem4")
            startActivity(intent)

        }
        sem5.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem5")
            startActivity(intent)

        }
        sem6.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem6")
            startActivity(intent)

        }
        sem7.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem7")
            startActivity(intent)

        }
        sem8.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", "sem8")
            startActivity(intent)

        }

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