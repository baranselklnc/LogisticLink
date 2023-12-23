package com.example.logisticlink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

class splashScreen : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView = findViewById<ImageView>(R.id.imageView)

        Glide.with(this)
            .asGif()
            .load(R.raw.newsplash)
            .into(imageView)

        object : CountDownTimer(SPLASH_DELAY, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val mainIntent = Intent(this@splashScreen, ChooseScreen::class.java)
                startActivity(mainIntent)
                finish()
            }
        }.start()
    }
}
