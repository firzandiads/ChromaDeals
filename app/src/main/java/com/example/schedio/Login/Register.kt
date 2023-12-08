package com.example.schedio.Login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schedio.R
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val registerButton: Button = findViewById(R.id.register)
        val loginBlueButton: TextView = findViewById(R.id.login)

        registerButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        loginBlueButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }







    }
}