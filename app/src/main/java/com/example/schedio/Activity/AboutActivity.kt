package com.example.schedio.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.schedio.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        backButton()


    }

    private fun backButton() {
        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener { startActivity(Intent(this@AboutActivity, MainActivity::class.java)) }
    }
}