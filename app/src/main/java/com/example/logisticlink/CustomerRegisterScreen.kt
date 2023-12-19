package com.example.logisticlink

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.logisticlink.databinding.ActivityCustomerRegisterScreenBinding

class CustomerRegisterScreen : AppCompatActivity() {
    private lateinit var binding:ActivityCustomerRegisterScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCustomerRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nextButton=binding.nextButton
        val customerRegisterNameEdit=binding.customerRegisterNameEdit
        val nullErrorText=binding.nullErrorText


        nextButton.setOnClickListener {
            val name=binding.customerRegisterNameEdit.text.toString()
            if (name.isEmpty()){
                nullErrorText.visibility= View.VISIBLE
            }
            else{
                Toast.makeText(this,"Sonraki sayfa",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, CustomerRegisterMailScreen::class.java)
                intent.putExtra("key",name)
                startActivity(intent)

                //lottieyi çalıştır
            }
        }

    }
}