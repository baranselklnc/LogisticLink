package com.example.logisticlink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCustomerRegisterMailScreenBinding

class CustomerRegisterMailScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerRegisterMailScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityCustomerRegisterMailScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val nullErrorMail=binding.nullErrorMail
        val username=intent.getStringExtra("key")
        val customerNameforMail=binding. customerNameforMail
        customerNameforMail.text="${username} mail hesabına ihtiyacımız var"
        val firstExpression="@"
        val secondExpression=".com"
        val nextButton=binding.nextButton
    nextButton.setOnClickListener {
    val email=binding.customerRegisterMailEdit.text.toString()
    if (email.isEmpty()|| (!email.contains(firstExpression) || !email.contains(secondExpression))){
        nullErrorMail.visibility=View.VISIBLE
    }
    else{
        val intent = Intent(this, CustomerRegisterPasswordScreen::class.java)
        startActivity(intent)
    }

    }
}
    }
