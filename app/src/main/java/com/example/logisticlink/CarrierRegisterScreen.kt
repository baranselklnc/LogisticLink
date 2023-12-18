package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCarrierRegisterScreenBinding

class CarrierRegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityCarrierRegisterScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCarrierRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val carrierName=binding.carrierName
        val carrierSurname=binding.carrierSurname
        val carrierMail=binding.carrierEmail
        val carrierPassword=binding.carrierPassword
        val carrierPasswordCheck=binding.carrierPasswordCheck





        val buttonKaydol=binding.buttonKaydol

    buttonKaydol.setOnClickListener {
       // Toast.makeText(this,"Giriş Başarılı",Toast.LENGTH_LONG).show()
        showCustomToast(this,"E posta ve şifrenizi giriniz")
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

