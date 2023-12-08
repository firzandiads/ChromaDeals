package com.example.schedio.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schedio.R
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import com.example.schedio.Activity.MainActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val loginButton: Button = findViewById(R.id.login)
        val registerBlueButton: TextView = findViewById(R.id.register)

        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registerBlueButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }





    }
}