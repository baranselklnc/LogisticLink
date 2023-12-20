package com.example.logisticlink

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCustomerRegisterPasswordScreenBinding

class CustomerRegisterPasswordScreen : AppCompatActivity() {
    private lateinit var binding:ActivityCustomerRegisterPasswordScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityCustomerRegisterPasswordScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val textInputLayout=binding.textInputLayout
        val nextButton=binding.nextButton
        val customerPassword=binding.customerPassword
        val passwordLengthError=binding.passwordLengthError
        nextButton.setOnClickListener {
            val password=customerPassword.text.toString().trim()
            hideKeyboard()

            if (password.length<6 || password.isEmpty())
            {
                passwordLengthError.visibility= View.VISIBLE
            }
            else{
                val intent = Intent(this, CustomerRegisterPasswordCheckScreen::class.java)
                intent.putExtra("password",password)
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