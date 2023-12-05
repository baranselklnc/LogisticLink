package com.example.logisticlink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class splashScreen : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 3000 // Milliseconds, 3 saniye örneğin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val imageView = findViewById<ImageView>(R.id.gifImageView)

        // Glide kütüphanesini kullanarak GIF'i yükleyin
        Glide.with(this)
            .asGif()
            .load(R.raw.splashscreenpro) // "your_gif" dosyanızın adını buraya ekleyin
            .into(imageView)

        // Splash ekranını belirli bir süre gösterdikten sonra ana aktiviteye geçiş yap
        android.os.Handler().postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DELAY)
    }
}