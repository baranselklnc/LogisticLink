package com.example.logisticlink

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCustomerRegisterPasswordCheckScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CustomerRegisterPasswordCheckScreen : AppCompatActivity() {
    private lateinit var binding:ActivityCustomerRegisterPasswordCheckScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityCustomerRegisterPasswordCheckScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val nextButton=binding.nextButton
        val passwordEqualError=binding.passwordEqualError
        val customerPasswordCheck=binding.customerPasswordCheck
        val lottieTruck=binding.lottieTruck
        nextButton.setOnClickListener {
            hideKeyboard()
            val password = customerPasswordCheck.text.toString().trim()
            val intent=intent
            val passwordCheck=intent.getStringExtra("password")
            if (password!=passwordCheck)
            {
                passwordEqualError.visibility=View.VISIBLE
            }
            else{

                val scope = CoroutineScope(Dispatchers.Main)

                lottieTruck.playAnimation()
                // CoroutineScope'u kullanarak bir coroutine başlat
                scope.launch {
                    delay(3000) // 5 saniye bekle
                    val intent = Intent(this@CustomerRegisterPasswordCheckScreen, CustomerLoginScreen::class.java)
                    startActivity(intent)

                }
                // CoroutineScope'u iptal et
                // Bu, eğer activity yoksa ya da işlem tamamlandıysa, coroutine'u iptal eder
 //               scope.onDestroy() // Eğer bu metot mevcut değilse, kullanıcıya bağlı olarak iptal etmelisiniz.
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