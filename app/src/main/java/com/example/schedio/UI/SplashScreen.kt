package com.example.schedio.UI

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.schedio.R
import com.example.schedio.UI.Login
//import com.example.schedio.UI.Login
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            navigateToMainActivity()

        },3000)
   /*     GlobalScope.launch(Dispatchers.Main) {
            delay(SPLASH_TIME_OUT)
            navigateToMainActivity()
        }*/
    }

    private fun navigateToMainActivity() {
        //val intent = Intent(this@SplashScreen, Login::class.java)
        val intent = Intent(this@SplashScreen, Login::class.java)
        startActivity(intent)
        finish()
    }
}