package com.example.faqNnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_module.*
import kotlinx.android.synthetic.main.activity_sempage.*

class module : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    var branch: String? = null
    var sem: String? = null
    var pdfUrl: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_module)
        auth= FirebaseAuth.getInstance()
        val actionbar=supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
        var b: String? = intent.getStringExtra("branch")
        var s: String? = intent.getStringExtra("sem")
        branch = b
        sem = s
        //Toast.makeText(this, branch + " " + sem, Toast.LENGTH_LONG).show()

        if (branch == "chem")
            pdfUrl = "https://drive.google.com/file/d/1XIBEIZrBna2SSMg-T1EDcW98J9R1nneR/view"
        else if (branch == "phy")
            pdfUrl = "https://drive.google.com/file/d/1Mw6rCZjQHMspEZaJxOfJuSH-NsBCoj8h/view"
        else if (branch == "cse" || branch == "ise") {
            if (sem == "sem3")
                pdfUrl = "https://drive.google.com/file/d/1u63lTB8i6rMiw07VsHfGgLmJ6MJn0Tvt/view"
            else if (sem == "sem4")
                pdfUrl = "https://drive.google.com/file/d/1fW6ztPWGM5tZiHMfr9fpoRSYmPPlxIE3/view"
            else if (sem == "sem5")
                pdfUrl = "https://drive.google.com/file/d/1P-SXiBIGNn3iDOk6UQIaxwOcdcHvj04K/view"
            else if (sem == "sem6")
                pdfUrl = "https://drive.google.com/file/d/1UqI-Rs6x8IVslIg2lmZ89FnzGy4_HZss/view"
            else if (sem == "sem7")
                pdfUrl = "https://drive.google.com/file/d/1zROekwO9jeRxCfhl6h6oJuoemab57iZv/view"
            else if (sem == "sem8")
                pdfUrl = "https://drive.google.com/file/d/1z0djAdg2U0HP5Mqq8W3AdFovl7zDubFN/view"

        } else if (branch == "civil") {
            if (sem == "sem3")
                pdfUrl = "https://drive.google.com/file/d/1p9m0xmRf14z9Y7okE8LMLd-HTQxHZB25/view"
            else if (sem == "sem4")
                pdfUrl = "https://drive.google.com/file/d/1m_JUaur7oR9GGZ46CYHxLyC83c_7G66t/view"
            else if (sem == "sem5")
                pdfUrl = "https://drive.google.com/file/d/1o8ga4xCz2DP3sAONNRYlNaMaTAxJdnG6/view"
            else if (sem == "sem6")
                pdfUrl = "https://drive.google.com/file/d/1Vtn4-t5i5yzWiWrpHGKfcPbyY4oI4Dln/view"
            else if (sem == "sem7")
                pdfUrl = "https://drive.google.com/file/d/1XNVL9VyTeQKzD6bIRV2U_YQcSbLjpvl-/view"
            else if (sem == "sem8")
                pdfUrl = "https://drive.google.com/file/d/1MQcfShgxY8Y8ApvhGuRNrTkPWFsCzheu/view"

        } else if (branch == "mech") {
            if (sem == "sem3")
                pdfUrl = "https://drive.google.com/file/d/16ieM3xfLgN6OlgqN0JqzkWYzCyYIbsQP/view"
            else if (sem == "sem4")
                pdfUrl = "https://drive.google.com/file/d/1zq_xql7c-ykmSwN2YlAC4qlR28fzd7n7/view"
            else if (sem == "sem5")
                pdfUrl = "https://drive.google.com/file/d/1POup52qfJ8drUDDY0A00_pIu49uTD3EO/view"
            else if (sem == "sem6")
                pdfUrl = "https://drive.google.com/file/d/1Ffa8sKExNabiPtYVMS8ZST9wGghNh5It/view"
            else if (sem == "sem7")
                pdfUrl = "https://drive.google.com/file/d/1sAZhqh-eeXNHxhDBuajcOTCYxu1JDN6a/view"
            else if (sem == "sem8")
                pdfUrl = "https://drive.google.com/file/d/1Jt5L2XQu33oPFm4lxLg-L__IGnJJhski/view"

        } else if (branch == "ele") {
            if (sem == "sem3")
                pdfUrl = "https://drive.google.com/file/d/12id4zWa2ZSMp6p2g41ZgXhxZ2ndA6Lqw/view"
            else if (sem == "sem4")
                pdfUrl = "https://drive.google.com/file/d/1jqs_ZyyHb0PapGts0ObNEH8LY-JEEvHS/view"
            else if (sem == "sem5")
                pdfUrl = "https://drive.google.com/file/d/1D7To6-ocCcJZUQFNKVOFYBwTup5iE5UM/view"
            else if (sem == "sem6")
                pdfUrl = "https://drive.google.com/file/d/1lxICdOhf4ohxYKLAgZtzMFGLURIFicZl/view"
            else if (sem == "sem7")
                pdfUrl = "https://drive.google.com/file/d/1myiqpmxczbMFyunvMfkR3In-RJdDwPK6/view"
            else if (sem == "sem8")
                pdfUrl = "https://drive.google.com/file/d/1Xq4w90zeF9pb4pIxahGUdY0_hv3OrdVo/view"

        }

        mod1.setOnClickListener {
            var intent = Intent(this, pdfpage::class.java)
            intent.putExtra("pdfUrl", pdfUrl)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }

        mod2.setOnClickListener {
            var intent = Intent(this, pdfpage::class.java)
            intent.putExtra("pdfUrl", pdfUrl)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        mod3.setOnClickListener {
            var intent = Intent(this, pdfpage::class.java)
            intent.putExtra("pdfUrl", pdfUrl)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        mod4.setOnClickListener {
            var intent = Intent(this, pdfpage::class.java)
            intent.putExtra("pdfUrl", pdfUrl)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
            startActivity(intent)
        }
        mod5.setOnClickListener {
            var intent = Intent(this, pdfpage::class.java)
            intent.putExtra("pdfUrl", pdfUrl)
            intent.putExtra("branch", branch)
            intent.putExtra("sem", sem)
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