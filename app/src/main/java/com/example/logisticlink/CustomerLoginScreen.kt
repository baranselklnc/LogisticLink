package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logisticlink.databinding.ActivityCustomerLoginScreenBinding

class CustomerLoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerLoginScreenBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CustomToastManager.showCustomToast(
            this,
            "E-posta ve şifrenizi girerek oturum açabilirsiniz"
        )
        val testText = binding.testText
        val carrierLoginButton = binding.carrierLoginButton
        val userPassword = intent.getStringExtra("password")
        val loginmail = intent.getStringExtra("email")
        testText.text = "Şifre= $userPassword ,Eposta $loginmail "

        carrierLoginButton.setOnClickListener {


            // Yeni bir Intent oluşturarak MainActivity'ye geçiş yap
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}