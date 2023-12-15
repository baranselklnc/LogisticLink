package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCarrierLoginScreenBinding

class CarrierLoginScreen : AppCompatActivity() {

    private lateinit var binding:ActivityCarrierLoginScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCarrierLoginScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val buttonKaydol=binding.buttonKaydol

    buttonKaydol.setOnClickListener {
       // Toast.makeText(this,"Giriş Başarılı",Toast.LENGTH_LONG).show()
        showCustomToast(this,"Yönlendirme yapılıyor")
        val intent = Intent(this@CarrierLoginScreen, MainActivity::class.java)
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
        // Özel simgeyi burada da ayarlayabilirsiniz

        val toast = Toast(context)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }

}

