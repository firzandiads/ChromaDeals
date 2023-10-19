package com.example.chromadeals

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {

    private lateinit var editTextName: TextInputEditText
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var editTextPhone: TextInputEditText
    private lateinit var register: Button
    private lateinit var login: TextView

    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editTextName = findViewById(R.id.name)
        editTextEmail = findViewById(R.id.email)
        editTextPassword = findViewById(R.id.password)
        editTextPhone = findViewById(R.id.phone)
        login = findViewById(R.id.login)
        register = findViewById(R.id.register)

        login.setOnClickListener {
            val intent = Intent(this@Register, Login::class.java)
            startActivity(intent)
            finish()
        }

        register.setOnClickListener {
            val name: String = editTextName.text.toString()
            val email: String = editTextEmail.text.toString()
            val password: String = editTextPassword.text.toString()
            val phone: String = editTextPhone.text.toString()


            if (TextUtils.isEmpty(name)) {
                Toast.makeText(this@Register, "Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(this@Register, "Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(this@Register, "Enter Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (TextUtils.isEmpty(phone)) {
                Toast.makeText(this@Register, "Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task: Task<AuthResult?> ->
                    if (task.isSuccessful) {
                        Toast.makeText(this@Register, "Registration Successfully", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@Register, Login::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@Register, "Authentication Failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}