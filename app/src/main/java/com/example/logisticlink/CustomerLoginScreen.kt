package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import com.example.logisticlink.databinding.ActivityCustomerLoginScreenBinding

class CustomerLoginScreen : AppCompatActivity() {
    private lateinit var binding: ActivityCustomerLoginScreenBinding

    private fun showCustomDialog() {
        val builder=AlertDialog.Builder(this)
        val customView=LayoutInflater.from(this).inflate(R.layout.forget_password_dialog,null)
        builder.setView(customView)
        val eMailSendButton=customView.findViewById<Button>(R.id.rePasswordButton)
        val dialog =builder.create()

        eMailSendButton.setOnClickListener {
            CustomToastManager.showCustomToast(this,"Yeni şifreniz mailinize gönderildi")
            dialog.dismiss()
        }
        val eMailEditText=customView.findViewById<EditText>(R.id.rePasswordEditText)

        dialog.show()
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomerLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CustomToastManager.showCustomToast(
            this,
            "E-posta ve şifrenizi girerek oturum açabilirsiniz"
        )
        val carrierLoginMail=binding.carrierLoginMail
        val carrierLoginPassword=binding.carrierLoginPassword
        val testText = binding.testText
        val carrierLoginButton = binding.carrierLoginButton
        val forgetPasswordText=binding.forgetPasswordText

        val receivedMail=(application as MyApplication).sharedMail
        val receivedPassword=(application as MyApplication).sharedPassword

        carrierLoginButton.setOnClickListener {

            val mail =carrierLoginMail.text.toString()
            val password=carrierLoginPassword.text.toString()
            if (mail!=receivedMail || password!=receivedPassword )
            {
                CustomToastManager.showCustomToast(this,"Lütfen kullanıcı adı veya şifrenizi kontrol edin.")
            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }

            testText.text = "$receivedMail,$receivedPassword "

            // Yeni bir Intent oluşturarak MainActivity'ye geçiş yap

        }
        forgetPasswordText.setOnClickListener {showCustomDialog()}


        }
    }
