package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.example.logisticlink.CustomToastManager
import com.example.logisticlink.CustomerLoginScreen
import com.example.logisticlink.MyApplication
import com.example.logisticlink.databinding.ActivityCarrierRegisterScreenBinding
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class CarrierRegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityCarrierRegisterScreenBinding
    private val apiService by lazy {
        // Retrofit örnek konfigürasyon
        Retrofit.Builder()
            .baseUrl("http://192.168.2.74:8091/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(ApiService::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarrierRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.setOnTouchListener { _, _ ->
            // Klavyeyi kapat
            klavyeyiKapat()
            false // Dokunma olayının işlenmediğini belirtmek için false döndürmek gerekiyor
        }

        val carrierName = binding.carrierName
        val nameNullTextError = binding.nameNullTextError
        val carrierSurname = binding.carrierSurname
        val surnameNullTextError = binding.surnameNullTextError
        val carrierMail = binding.carrierEmail
        val mailErrorText = binding.mailErrorText
        val carrierPhone = binding.carrierPhone
        val phoneError = binding.phoneError
        val carrierPassword = binding.carrierPassword
        val nullPasswordError = binding.nullPasswordError
        val notEqualPassword = binding.notEqualPassword
        val carrierPasswordCheck = binding.carrierPasswordCheck
        val nullPasswordError2 = binding.nullPasswordError2
        val notEqualPassword2 = binding.notEqualPassword2

        val buttonKaydol = binding.buttonKaydol

        buttonKaydol.setOnClickListener {
            val name = carrierName.text.toString().trim()
            val surname = carrierSurname.text.toString().trim()
            val mail = carrierMail.text.toString().trim()
            val phone = carrierPhone.text.toString().trim()
            val password = carrierPassword.text.toString().trim()
            val passwordCheck = carrierPasswordCheck.text.toString().trim()

            if (isValidInput(name, surname, mail, phone, password, passwordCheck)) {
                // Coroutine'i başlat
                launchCarrierRegisterTask(name, surname, mail, phone, password, passwordCheck)
            } else {
                CustomToastManager.showCustomToast(this, "Girdiğiniz bilgiler hatalı")
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun launchCarrierRegisterTask(
        name: String,
        surname: String,
        mail: String,
        phone: String,
        password: String,
        passwordCheck: String
    ) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = apiService.registerCarrier(name, surname, mail, password).execute()

                if (response.isSuccessful) {
                    runOnUiThread {
                        (application as MyApplication).sharedCarrierPassword = passwordCheck.trim()
                        (application as MyApplication).sharedCarrierMail = mail.trim()
                        val intent = Intent(this@CarrierRegisterScreen, CustomerLoginScreen::class.java)
                        startActivity(intent)
                    }
                } else {
                    runOnUiThread {
                        CustomToastManager.showCustomToast(
                            this@CarrierRegisterScreen,
                            "Hata: Kayıt başarısız, lütfen tekrar deneyin."
                        )
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
    private fun isValidInput(
        name: String,
        surname: String,
        mail: String,
        phone: String,
        password: String,
        passwordCheck: String
    ): Boolean {
        var isValid = true

        if (name.isEmpty()) {
            binding.nameNullTextError.visibility = View.VISIBLE
            isValid = false
        }

        if (surname.isEmpty()) {
            binding.surnameNullTextError.visibility = View.VISIBLE
            isValid = false
        }

        val firstExpression = "@"
        val secondExpression = ".com"

        if (mail.isEmpty() || (!mail.contains(firstExpression) || !mail.contains(secondExpression))) {
            binding.mailErrorText.visibility = View.VISIBLE
            isValid = false
        }

        if (phone.isEmpty() || !phone.startsWith("5")) {
            binding.phoneError.visibility = View.VISIBLE
            isValid = false
        }

        if (password.isEmpty()) {
            binding.nullPasswordError.visibility = View.VISIBLE
            isValid = false
        }

        if (passwordCheck.isEmpty()) {
            binding.nullPasswordError2.visibility = View.VISIBLE
            isValid = false
        }

        if (password != passwordCheck) {
            binding.notEqualPassword.visibility = View.VISIBLE
            binding.notEqualPassword2.visibility = View.VISIBLE
            isValid = false
        }

        return isValid
    }


    private fun klavyeyiKapat() {
        val view: View? = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    // Diğer fonksiyonlar burada
}
