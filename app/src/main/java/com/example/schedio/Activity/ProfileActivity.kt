package com.example.schedio.Activity


import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import com.example.schedio.R
import com.example.schedio.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    private lateinit var mySharedPreferences: SharedPreferences
    private lateinit var myEditor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initSharedPreferences()
        showSharedPreferences()
        backButton()

        binding.btnSave.setOnClickListener {

            val name = binding.etName.text.toString()
            val role = binding.etRole.text.toString()

            if (validateInput(name,role)){

                insertSharedPreferences(name,role)
                showSharedPreferences()
            }
        }
    }

    private fun backButton() {
        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener { startActivity(Intent(this@ProfileActivity, MainActivity::class.java)) }


    }

    private fun initSharedPreferences(){

        mySharedPreferences = getSharedPreferences("my_shared_preferences", MODE_PRIVATE)
        myEditor = mySharedPreferences.edit()
    }

    private fun showSharedPreferences(){

        val name = mySharedPreferences.getString("key_name",null)
        val role = mySharedPreferences.getString("key_role",null)

        if (name != null && role != null){
            binding.tvName.text = name
            binding.tvRole.text = role

            binding.etName.setText("$name")
            binding.etRole.setText("$role")
        }else{
            binding.tvName.text = getString(R.string.empty_name)
            binding.tvRole.text = getString(R.string.empty_role)
        }
    }

    private fun validateInput(inputName: String?, inputRole: String?): Boolean{
        return when{
            inputName.isNullOrEmpty() -> {
                Toast.makeText(this,"Please type your username", Toast.LENGTH_LONG).show()
                binding.etName.requestFocus()
                false
            }
            inputRole.isNullOrEmpty() -> {
                Toast.makeText(this,"Please type your name", Toast.LENGTH_LONG).show()
                binding.etRole.requestFocus()
                false
            }
            else -> {
                true
            }
        }
    }

    private fun insertSharedPreferences(inputName: String, inputRole: String){

        myEditor.apply(){
            putString("key_name",inputName)
            putString("key_role",inputRole)
            apply()
        }

        Toast.makeText(this,"Saved successfully",Toast.LENGTH_LONG).show()
    }
}