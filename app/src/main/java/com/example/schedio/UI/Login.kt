package com.example.schedio.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schedio.R
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.schedio.Activity.MainActivity
import com.example.schedio.UI.login.LoginViewModel
import com.example.schedio.databinding.ActivityLoginBinding
import org.koin.android.ext.android.inject
import java.util.zip.Inflater

class Login : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("login", "onCreate: ")
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("login", "onCreate: init")
        init()
        observeData()



        /*val loginButton: Button = findViewById(R.id.login)
        val registerBlueButton: TextView = findViewById(R.id.register)*/

/*        loginButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        registerBlueButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }*/





    }

    private fun observeData() {
        Log.d("log", "observeData: ")
        with(viewModel){
            observeIsLogin().observe(this@Login){
                it.let{ data ->
                    if (data != null){
                        //findnaccontroler
                        val intent = Intent(this@Login, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@Login,"not found", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun init() {
        Log.d("login", "onCreate: init222")
        with(binding){
            login.setOnClickListener{
                if(email.text.isNullOrBlank()){
                    email.error = "Email Kosong"
                }

                if(password.text.isNullOrBlank()){
                    password.error = "Password Kosong"
                }

                if(!email.text.isNullOrBlank() && !password.text.isNullOrBlank()){
                    viewModel.getDataLogin(email.text.toString(), password.text.toString())
                }
            }

            register.setOnClickListener{
                val intent = Intent(this@Login, Register::class.java)
                startActivity(intent)
            }
        }
    }

}
