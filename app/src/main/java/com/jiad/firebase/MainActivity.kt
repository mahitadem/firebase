package com.jiad.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    lateinit var reg: TextView
    lateinit var mail: EditText
    lateinit var pas: EditText
    lateinit var btn: Button
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reg = findViewById(R.id.tvlog)
        mail = findViewById(R.id.emailreg)
        pas = findViewById(R.id.pasreg)
        btn = findViewById(R.id.btnlog)
        auth = FirebaseAuth.getInstance()

        reg.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
        btn.setOnClickListener {
            loginuser()

        }
    }

    private fun loginuser() {
        val email = mail.toString()
        val pass = pas.toString()
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully logged in", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_LONG).show()
            }
        }
    }
}


