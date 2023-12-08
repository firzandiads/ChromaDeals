package com.example.schedio.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.schedio.Activity.MainActivity
import com.example.schedio.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DeliveredActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 1700


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivered)

        GlobalScope.launch(Dispatchers.Main) {
            delay(SPLASH_TIME_OUT)
            navigateToDeliveredActivity()
        }

    }

    private fun navigateToDeliveredActivity() {
        val intent = Intent(this@DeliveredActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}