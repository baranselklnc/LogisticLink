package com.example.logisticlink

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.logisticlink.databinding.ActivityCarrierRegisterScreenBinding

class CarrierRegisterScreen : AppCompatActivity() {

    private lateinit var binding: ActivityCarrierRegisterScreenBinding
    private lateinit var registerCarrierPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarrierRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.root.setOnTouchListener { _, _ ->
            // Klavyeyi kapat
            klavyeyiKapat()
            false // Dokunma olayının işlenmediğini belirtmek için false döndürün
        }
        val carrierName = binding.carrierName
        val nameNullTextError = binding.nameNullTextError
        val carrierSurname = binding.carrierSurname
        val surnameNullTextError = binding.surnameNullTextError
        val carrierMail = binding.carrierEmail
        val mailErrorText = binding.mailErrorText
        val carrierPhone = binding.carrierPhone
        val phoneError=binding.phoneError
        val carrierPassword = binding.carrierPassword
        val nullPasswordError=binding.nullPasswordError
        val notEqualPassword=binding.notEqualPassword
        val carrierPasswordCheck = binding.carrierPasswordCheck
        val nullPasswordError2=binding.nullPasswordError2
        val notEqualPassword2=binding.notEqualPassword2

        val buttonKaydol = binding.buttonKaydol
        val firstExpression = "@"
        val secondExpression = ".com"



        buttonKaydol.setOnClickListener {
            klavyeyiKapat()
            val name = carrierName.text.toString().trim()
            val surname = carrierSurname.text.toString().trim()
            val mail = carrierMail.text.toString().trim()
            val phone=carrierPhone.text.toString().trim()
            val password=carrierPassword.text.toString().trim()
            val passwordCheck=carrierPasswordCheck.text.toString().trim()

            if (name.isEmpty()) {
                nameNullTextError.isVisible = true
                return@setOnClickListener

            }
            if (surname.isEmpty()) {
                surnameNullTextError.isVisible = true
                return@setOnClickListener

            }
            if (mail.isEmpty() || (!mail.contains(firstExpression) || !mail.contains(secondExpression)))
            {
                mailErrorText.isVisible = true
                return@setOnClickListener

            }
            if (phone.isEmpty() || !phone.startsWith("5"))
            {
                phoneError.isVisible=true
                return@setOnClickListener

            }
            if (password.isEmpty())
            {
                nullPasswordError.isVisible=true
                return@setOnClickListener


            }
            if (passwordCheck.isEmpty())
            {
                nullPasswordError2.isVisible=true
                return@setOnClickListener

            }
            if (password!=passwordCheck)
            {
                notEqualPassword.isVisible=true
                notEqualPassword2.isVisible=true
                return@setOnClickListener


            } else  {
                (application as MyApplication).sharedCarrierPassword=passwordCheck
                (application as MyApplication).sharedCarrierMail=mail


                val intent = Intent(this@CarrierRegisterScreen, CustomerLoginScreen::class.java)
                startActivity(intent)
            }

        }
    }
    private fun klavyeyiKapat() {
        val view: View? = currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
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
