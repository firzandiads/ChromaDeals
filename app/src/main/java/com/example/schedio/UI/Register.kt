package com.example.schedio.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schedio.R
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.schedio.UI.login.LoginViewModel
import com.example.schedio.UI.register.RegisterViewModel
import com.example.schedio.data.local.UserEntity
import com.example.schedio.databinding.ActivityLoginBinding
import com.example.schedio.databinding.ActivityRegisterBinding
import org.koin.android.ext.android.inject

class Register : AppCompatActivity() {


    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        observeData()

  /*      val registerButton: Button = findViewById(R.id.register)
        val loginBlueButton: TextView = findViewById(R.id.login)

        registerButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }

        loginBlueButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }*/







    }

    private fun observeData() {
        with(viewModel){
            observeIsRegister().observe(this@Register){
                it.let{ data ->
                    if(data){
                        /*findNavController().navigate(R.id.action_registerActivity_to_loginActivity)*/
                        val intent = Intent(this@Register, Login::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@Register, "Email Sudah Terdaftar", Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }


    }


    private fun init() {
        binding.register.setOnClickListener {
            val username = binding.username.text.toString()
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val user = UserEntity(0, username, email, password)
            viewModel.insertUser(user)

        }

    }


}
