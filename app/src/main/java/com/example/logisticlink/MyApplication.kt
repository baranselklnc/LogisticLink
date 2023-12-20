package com.example.logisticlink

import android.app.Application

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Uygulama başladığında yapılacak işlemleri buraya ekleyebilirsiniz.

        // CustomToastManager'ı başlatmak için:
        CustomToastManager.initialize(this)
    }
}
