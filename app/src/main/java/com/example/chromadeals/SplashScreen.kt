package com.example.chromadeals

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        GlobalScope.launch(Dispatchers.Main) {
            delay(SPLASH_TIME_OUT)
            navigateToMainActivity()
        }
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this@SplashScreen, Login::class.java)
        startActivity(intent)
        finish()
    }
}
