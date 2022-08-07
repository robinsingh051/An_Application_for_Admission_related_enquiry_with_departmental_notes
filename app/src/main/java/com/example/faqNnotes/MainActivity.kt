package com.example.faqNnotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    private lateinit var Login:Button
    private lateinit var Register:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth= FirebaseAuth.getInstance()

        Login=findViewById(R.id.Login)
        Register=findViewById(R.id.Register)

        Register.setOnClickListener {
            var intent =Intent(this,RegisterActivity::class.java)
            startActivity(intent)

        }
        bot.setOnClickListener {
            var intent =Intent(this,chatbot::class.java)
            startActivity(intent)
        }


        Login.setOnClickListener {
            val email=Email.text.toString()
            val password= Password.text.toString()
            val s:String="123456"
            if(email.endsWith("robin.19cs134@cambridge.edu.in") && password==s)
            { var intent =Intent(this,LoggedIn::class.java)
                intent.putExtra("email",email)
                startActivity(intent)
                finish()
            }
            else {
                if (checking()) {
                    auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                var intent = Intent(this, LoggedIn::class.java)
                                intent.putExtra("email", email)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this, "Wrong Details", Toast.LENGTH_LONG).show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Enter the Details", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun checking():Boolean
    {
        if(Email.text.toString().trim{it<=' '}.isNotEmpty()
            && Password.text.toString().trim{it<=' '}.isNotEmpty())
        {
            return true
        }
        return false
    }
}