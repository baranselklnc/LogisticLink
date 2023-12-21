package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.logisticlink.databinding.ActivityCarrierRegisterScreenBinding

class CarrierRegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityCarrierRegisterScreenBinding
    private lateinit var registerCarrierPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarrierRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carrierName = binding.carrierName
        val carrierSurname = binding.carrierSurname
        val carrierMail = binding.carrierEmail
        val registerCarrierPhone = binding.registerCarrierPhone  // Fix: Use the class property instead of creating a new variable
        val carrierPassword = binding.carrierPassword
        val carrierPasswordCheck = binding.carrierPasswordCheck
        val buttonKaydol = binding.buttonKaydol




        buttonKaydol.setOnClickListener {
            showCustomToast(this, "E posta ve şifrenizi giriniz")
            val intent = Intent(this@CarrierRegisterScreen, CustomerLoginScreen::class.java)
            startActivity(intent)
        }
    }



    @SuppressLint("MissingInflatedId")
    fun showCustomToast(context: Context, message: String) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val layout = inflater.inflate(R.layout.special_toast, null)
        val text = layout.findViewById<TextView>(R.id.dispatchText)
        text.text = message

        val image = layout.findViewById<ImageView>(R.id.customImageView)

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }


}
