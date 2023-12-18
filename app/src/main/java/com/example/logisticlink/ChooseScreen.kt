package com.example.logisticlink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logisticlink.databinding.ActivityChooseScreenBinding

class ChooseScreen : AppCompatActivity() {

    private lateinit var binding: ActivityChooseScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityChooseScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

    binding.carrierAvatar.setOnClickListener{

        val intent = Intent(this, CarrierRegisterScreen::class.java)
        startActivity(intent)
    }
        binding.customerAvatar.setOnClickListener{
            val intent = Intent(this, CustomerRegisterScreen::class.java)
            startActivity(intent)
        }

    }
}