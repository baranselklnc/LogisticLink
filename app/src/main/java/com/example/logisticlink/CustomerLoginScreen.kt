package com.example.logisticlink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.logisticlink.databinding.ActivityCustomerLoginScreenBinding

class CustomerLoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCustomerLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carrierLoginButton=binding.carrierLoginButton
carrierLoginButton.setOnClickListener {
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
}
    }

}