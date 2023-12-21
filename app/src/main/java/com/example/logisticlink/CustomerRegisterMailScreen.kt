package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCustomerRegisterMailScreenBinding

class CustomerRegisterMailScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerRegisterMailScreenBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCustomerRegisterMailScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nullErrorMail = binding.nullErrorMail
        val customerRegisterMailEdit = binding.customerRegisterMailEdit
        val username = intent.getStringExtra("key")
        val customerNameforMail = binding.customerNameforMail
        customerNameforMail.text = "$username mail hesabına ihtiyacımız var"

        val firstExpression = "@"
        val secondExpression = ".com"

        val nextButton = binding.nextButton

        nextButton.setOnClickListener {
            hideKeyboard()

            val email = customerRegisterMailEdit.text.toString().trim()
            if (email.isEmpty() || (!email.contains(firstExpression) || !email.contains(secondExpression))) {
                nullErrorMail.visibility = View.VISIBLE
            } else {
                // Intent'i sadece bir kez başlat
                val intent = Intent(this, CustomerRegisterPasswordScreen::class.java)
                intent.putExtra("email",email)
                startActivity(intent)

            }
        }
    }

    private fun hideKeyboard() {
        val view: View? = currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
