package com.example.logisticlink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.logisticlink.databinding.ActivityChooseScreenBinding

class ChooseScreen : AppCompatActivity() {

    private lateinit var binding: ActivityChooseScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityChooseScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun onAvatarClick(view: View) {
            when (view.id) {
                R.id.carrierAvatar -> showToast("Taşıyıcı avatarına tıklandı")
                R.id.customerAvatar -> showToast("Müşteri avatarına tıklandı")
            }
        }    }
}