package com.allana.booksapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val imgSplashScreen: ImageView = findViewById(R.id.img_splash_screen)
        val tvSplashScreen: TextView = findViewById(R.id.tv_splash_screen)

        tvSplashScreen.alpha = 0f
        tvSplashScreen.animate().setDuration(2000).alpha(1f)
        imgSplashScreen.alpha = 0f
        imgSplashScreen.animate().setDuration(2000).alpha(1f).withEndAction {
            val moveToMainActivity = Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(moveToMainActivity)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}
