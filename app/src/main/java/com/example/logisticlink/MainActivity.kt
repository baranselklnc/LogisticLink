package com.example.logisticlink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.logisticlink.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Homepage())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.anasayfa->replaceFragment(Homepage())
                R.id.profil->replaceFragment(Profil())
                R.id.ilanlarim->replaceFragment(Ilanlarim())

                else->{



                }

            }
            true
        }

    }


    private fun replaceFragment(fragment: Fragment){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

    }
}