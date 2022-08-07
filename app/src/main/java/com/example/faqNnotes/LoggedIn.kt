package com.example.faqNnotes
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_logged_in.*
import kotlinx.android.synthetic.main.activity_sempage.*

class LoggedIn : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var db: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged_in)
        auth= FirebaseAuth.getInstance()
        val sharedPref = this?.getPreferences(Context.MODE_PRIVATE) ?: return
        val isLogin = sharedPref.getString("Email", "1")
        val search=findViewById<Button>(R.id.search)
        val searchText=findViewById<EditText>(R.id.w)

        /*logout.setOnClickListener {
            sharedPref.edit().remove("Email").apply()
            var intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }*/
        chem.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", "chem")
            startActivity(intent)

        }
        phy.setOnClickListener {
            var intent = Intent(this, subject::class.java)
            intent.putExtra("branch", "phy")
            startActivity(intent)
        }
        cse.setOnClickListener {
            var intent = Intent(this, sempage::class.java)
            intent.putExtra("branch", "cse")
            startActivity(intent)
        }
        ise.setOnClickListener {
            var intent = Intent(this, sempage::class.java)
            intent.putExtra("branch", "ise")
            startActivity(intent)
        }
        civil.setOnClickListener {
            var intent = Intent(this, sempage::class.java)
            intent.putExtra("branch", "civil")
            startActivity(intent)
        }
        mech.setOnClickListener {
            var intent = Intent(this, sempage::class.java)
            intent.putExtra("branch", "mech")
            startActivity(intent)
        }

        ele.setOnClickListener {
            var intent = Intent(this, sempage::class.java)
            intent.putExtra("branch", "ele")
            startActivity(intent)
        }
        search.setOnClickListener {
            var intent = Intent(this, sc::class.java)
            intent.putExtra("stext", searchText.text.toString())
            startActivity(intent)
        }
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