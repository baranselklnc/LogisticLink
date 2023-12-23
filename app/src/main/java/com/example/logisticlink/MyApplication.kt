package com.example.logisticlink

import android.app.Application

class MyApplication : Application() {
    var sharedPassword:String?=null
    var sharedMail:String?=null
    var sharedCarrierMail:String?=null
    var sharedCarrierPassword:String?=null
    override fun onCreate() {
        super.onCreate()


        // Uygulama başladığında yapılacak işlemleri buraya ekleyebilirsiniz.

        // CustomToastManager'ı başlatmak için:
        CustomToastManager.initialize(this)
    }
}
